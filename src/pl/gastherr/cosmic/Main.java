package pl.gastherr.cosmic;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import pl.gastherr.cosmic.ServerStats;
import pl.gastherr.cosmic.player.Gracz;
import pl.gastherr.cosmic.player.Staty;
import pl.gastherr.cosmic.events.*;

public class Main extends JavaPlugin implements Listener{

	DropItem DropItem;
	Commands Commands;
	ChatSay ChatSay;
	public PlayerJoin PlayerJoin;
	Gracz Gracz;
	Signs Signs;
	ItemsAfterDeath ItemsAfterDeath;
	EntityDamage EntityDamage;
	NPCInteract NPCInteract;
	PlayerMove PlayerMove;
	PickupItem PickupItem;
	private API api;
	public ServerStats statystyki;
    
    
	public String fixColors(String msg){
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
	public void loadServerData(){
		String prefix = "StatystykiSerwerowe.";
		double kasa = getPluginConfig().getDouble(prefix+"Kasa");
		double wydanaKasa = getPluginConfig().getDouble(prefix+"WydanaKasa");
		double zarobionaKasa = getPluginConfig().getDouble(prefix+"ZarobionaKasa");
		double otrzymanaKasa = getPluginConfig().getDouble(prefix+"OtrzymanaKasa");
		int wykonanePrzelewy = getPluginConfig().getInt(prefix+"WykonanePrzelewy");
		double przelanaKasa = getPluginConfig().getDouble(prefix+"PrzelanaKasa");
		
		int kupione_mechanizmy = getPluginConfig().getInt(prefix+"KupioneMechanizmy");
		int aktywowane_mechanizmy = getPluginConfig().getInt(prefix+"AktywowaneMechanizmy");

		int frakcjaInstor = getPluginConfig().getInt(prefix+"FrakcjaInstor");
		int frakcjaForter = getPluginConfig().getInt(prefix+"FrakcjaForter");
		int frakcjaProter = getPluginConfig().getInt(prefix+"FrakcjaProter");
		int frakcjaPread = getPluginConfig().getInt(prefix+"FrakcjaPread");
		
		int liczbaOdwiedzin = getPluginConfig().getInt(prefix+"LiczbaOdwiedzin");
		
	    ServerStats server = new ServerStats(kasa, wydanaKasa, zarobionaKasa, otrzymanaKasa, wykonanePrzelewy,
	    		przelanaKasa, kupione_mechanizmy, aktywowane_mechanizmy, frakcjaInstor, frakcjaForter,
	    		frakcjaProter, frakcjaPread, liczbaOdwiedzin);
	    statystyki = server;
		
	}
	
	public void saveServerData(){
		double kasa = statystyki.getKasa();
		double wydanaKasa = statystyki.getWydanaKasa();
		double zarobionaKasa = statystyki.getZarobionaKasa();
		double otrzymanaKasa = statystyki.getOtrzymanaKasa();
		int wykonanePrzelewy = statystyki.getWykonanePrzelewy();
		double przelanaKasa = statystyki.getPrzelanaKasa();
		
		int kupione_mechanizmy = statystyki.getKupioneMechanizmy();
		int aktywowane_mechanizmy = statystyki.getAktywowaneMechanizmy();

		int frakcjaInstor = statystyki.getFrakcjaInstor();
		int frakcjaForter = statystyki.getFrakcjaForter();
		int frakcjaProter = statystyki.getFrakcjaProter();
		int frakcjaPread = statystyki.getFrakcjaPread();
		
		int liczbaOdwiedzin = statystyki.getLiczbaOdwiedzin();
		
		getPluginConfig().set("StatystykiSerwerowe.Kasa", kasa);
		getPluginConfig().set("StatystykiSerwerowe.WydanaKasa", wydanaKasa);
		getPluginConfig().set("StatystykiSerwerowe.ZarobionaKasa", zarobionaKasa);
		getPluginConfig().set("StatystykiSerwerowe.OtrzymanaKasa", otrzymanaKasa);
		getPluginConfig().set("StatystykiSerwerowe.WykonanePrzelewy", wykonanePrzelewy);
		getPluginConfig().set("StatystykiSerwerowe.PrzelanaKasa", przelanaKasa);
		getPluginConfig().set("StatystykiSerwerowe.KupioneMechanizmy", kupione_mechanizmy);
		getPluginConfig().set("StatystykiSerwerowe.AktywowaneMechanizmy", aktywowane_mechanizmy);
		getPluginConfig().set("StatystykiSerwerowe.FrakcjaInstor", frakcjaInstor);
		getPluginConfig().set("StatystykiSerwerowe.FrakcjaForter", frakcjaForter);
		getPluginConfig().set("StatystykiSerwerowe.FrakcjaProter", frakcjaProter);
		getPluginConfig().set("StatystykiSerwerowe.FrakcjaPread", frakcjaPread);
		
		getPluginConfig().set("StatystykiSerwerowe.LiczbaOdwiedzin", liczbaOdwiedzin);
		savePluginConfig();
	}
	
	public void saveUser(String name){
		
		Gracz g = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(name);
		Staty s = g.getStaty();
		
		float exp = s.getExp();
		int lvl = s.getLevel();
		int pktpostepu = g.getPktPostepu();
		double kasa = s.getKasa();
		double wydanaKasa = s.getWydanaKasa();
		double zarobionaKasa = s.getZarobionaKasa();
		double przelanaKasa = s.getPrzelanaKasa();
		double zgubionaKasa = s.getZarobionaKasa();
		double otrzymanaKasa = s.getOtrzymanaKasa();
		int wykonanePrzelewy = s.getWykonanePrzelewy();
		boolean sound_exp = g.getSoundExp();
		boolean sound_lvlup = g.getSoundLvlup();
		boolean sound_teleport = g.getSoundTeleport();
		boolean scoreboard_show = g.getScoreboardShow();
		boolean sound_chat = g.getSoundChat();
		int mieczLvl = s.getMieczLvl();
		int helmLvl = s.getHelmLvl();
		int klataLvl = s.getKlataLvl();
		int spodnieLvl = s.getSpodnieLvl();
		int butyLvl = s.getButyLvl();
		int zabojstwa = s.getZabojstwa();
		int smierci = s.getSmierci();
		int aktywowane_mechanizmy = s.getAktywowaneMechanizmy();
		
		int uz_instor = s.getUzyciaInstor();
		int uz_forter = s.getUzyciaForter();
		int uz_proter = s.getUzyciaProter();
		int uz_pread = s.getUzyciaPread();
		
		getGraczConfig(name).set("Dane.Exp", exp);
		getGraczConfig(name).set("Dane.PktPostepu", pktpostepu);
		getGraczConfig(name).set("Dane.Level", lvl);
		getGraczConfig(name).set("Dane.Ekonomia.Kasa", kasa);
		getGraczConfig(name).set("Dane.Ekonomia.WydanaKasa", wydanaKasa);
		getGraczConfig(name).set("Dane.Ekonomia.ZarobionaKasa", zarobionaKasa);
		getGraczConfig(name).set("Dane.Ekonomia.PrzelanaKasa", przelanaKasa);
		getGraczConfig(name).set("Dane.Ekonomia.ZgubionaKasa", zgubionaKasa);
		getGraczConfig(name).set("Dane.Ekonomia.OtrzymanaKasa", otrzymanaKasa);
		getGraczConfig(name).set("Dane.Ekonomia.WykonanePrzelewy", wykonanePrzelewy);
		getGraczConfig(name).set("Dane.Opcje.Dzwiek.Exp", sound_exp);
		getGraczConfig(name).set("Dane.Opcje.Dzwiek.LvlUp", sound_lvlup);
		getGraczConfig(name).set("Dane.Opcje.Dzwiek.Teleport", sound_teleport);
		getGraczConfig(name).set("Dane.Opcje.Dzwiek.Chat", sound_chat);
		getGraczConfig(name).set("Dane.Opcje.Dzwiek.Teleport", sound_teleport);
		getGraczConfig(name).set("Dane.Opcje.Scoreboard.Pokaz", scoreboard_show);
		getGraczConfig(name).set("Dane.Inwentarz.MieczLvl", mieczLvl);
		getGraczConfig(name).set("Dane.Inwentarz.HelmLvl", helmLvl);
		getGraczConfig(name).set("Dane.Inwentarz.KlataLvl", klataLvl);
		getGraczConfig(name).set("Dane.Inwentarz.SpodnieLvl", spodnieLvl);
		getGraczConfig(name).set("Dane.Inwentarz.ButyLvl", butyLvl);
		getGraczConfig(name).set("Dane.Statystyki.Zabojstwa", zabojstwa);
		getGraczConfig(name).set("Dane.Statystyki.Smierci", smierci);
		getGraczConfig(name).set("Dane.Statystyki.AktywowaneMechanizmy", aktywowane_mechanizmy);
		getGraczConfig(name).set("Dane.Uzycia.Instor", uz_instor);
		getGraczConfig(name).set("Dane.Uzycia.Forter", uz_forter);
		getGraczConfig(name).set("Dane.Uzycia.Proter", uz_proter);
		getGraczConfig(name).set("Dane.Uzycia.Pread", uz_pread);
		saveGraczConfig(name);
	}

	@Override
	public void onEnable() {
		api = new API(this);
		Commands = new Commands(this);
		ChatSay = new ChatSay(this);
		PlayerJoin = new PlayerJoin(this);
		Signs = new Signs(this);
		ItemsAfterDeath = new ItemsAfterDeath(this);
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new PickupItem(this), this);
		getServer().getPluginManager().registerEvents(new DropItem(this), this);
		getServer().getPluginManager().registerEvents(new PlayerMove(this), this);
		getServer().getPluginManager().registerEvents(new EntityDamage(this), this);
		getServer().getPluginManager().registerEvents(new NPCInteract(this), this);
		Signs.registerItems();
		ConsoleCommandSender kon = Bukkit.getConsoleSender();
		registerPluginConfig();
		addToPluginConfig();
		loadServerData();
		kon.sendMessage(ChatColor.WHITE+"["+ChatColor.AQUA+"CosmoCraft by gastherr"+ChatColor.WHITE+"] Uruchamianie...");
		Bukkit.getScheduler().runTaskTimer(this, new Runnable(){
			@Override
			public void run(){
				if (Bukkit.getOnlinePlayers().length > 0){
					for(Player online : Bukkit.getOnlinePlayers()){
						String puid = online.getUniqueId().toString();
						saveUser(puid);
						String wd = online.getWorld().getName();
						Bukkit.getServer().getWorld(wd).setStorm(false);
						Bukkit.getServer().getWorld(wd).setThundering(false);
					}
					Bukkit.broadcastMessage(ChatColor.GOLD+"[Autosave]"+ChatColor.GRAY+" Pomyslnie zapisano dane "+ChatColor.GOLD+Bukkit.getOnlinePlayers().length+ChatColor.GRAY+" uzytkownikow!");
				}
			}	
		}, 0, 20*60*5);
		if (Bukkit.getOnlinePlayers().length > 0){
			for (Player online : Bukkit.getOnlinePlayers()){
				String puid = online.getUniqueId().toString();
				registerGraczConfig(puid);
				PlayerJoin.loadUser(puid);
			}
		}
	}

	@Override
	public void onDisable() {
		saveServerData();
		ConsoleCommandSender kon = Bukkit.getConsoleSender();
		kon.sendMessage(ChatColor.WHITE+"["+ChatColor.AQUA+"CosmoCraft by gastherr"+ChatColor.WHITE+"] Zapisywanie danych...");
		for (Player online : Bukkit.getOnlinePlayers()){
			String puid = online.getUniqueId().toString();
			saveUser(puid);
			unregisterGraczConfig(puid);
		}
		
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent e){
		
		Player p = e.getPlayer();
		String puid = p.getUniqueId().toString();
		boolean fight = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().getIsFighting();
		if (fight){
			pl.gastherr.cosmic.events.ItemsAfterDeath.regiveMoney(p);
			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().setIsFighting(false);
			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).setFrakcja("Brak");
		}
		e.setQuitMessage(ChatColor.GOLD+p.getName()+ChatColor.GRAY+" opuscil serwer!");
		saveUser(puid);
		unregisterGraczConfig(puid);
		if (Bukkit.getOnlinePlayers().length > 0){
			for (Player pl : Bukkit.getOnlinePlayers()){
				setScoreboard(pl, true);
			}
		}

	}
	
    static HashMap<String, FileConfiguration> configs = new HashMap<String, FileConfiguration>();
	
	public void registerGraczConfig(String name){
		File file = new File(getDataFolder()+File.separator+"Gracze", name+".yml");
        YamlConfiguration getConfig = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                try {
                    getConfig.save(file);
                    configs.put(name, getConfig);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
        	configs.put(name, getConfig);
        }
	}
	
	public void registerPluginConfig(){
		File file = new File(getDataFolder(), "config.yml");
        YamlConfiguration getConfig = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                try {
                    getConfig.save(file);
                    configs.put("config", getConfig);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
        	configs.put("config", getConfig);
        }
	}
	
	public void savePluginConfig(){
		File f = new File(getDataFolder(), "config.yml");
        try {
			getPluginConfig().save(f);
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addToPluginConfig(){
		if (!getPluginConfig().contains("Admins")){
			getPluginConfig().createSection("Admins");
		}
		if (!getPluginConfig().contains("Mods")){
			getPluginConfig().createSection("Mods");
		}
		if (!getPluginConfig().contains("KidMods")){
			getPluginConfig().createSection("KidMods");
		}
		if (!getPluginConfig().contains("HAdmins")){
			getPluginConfig().createSection("HAdmins");
		}
		savePluginConfig();
	}
	
	public FileConfiguration getPluginConfig(){
		return configs.get("config");
	}
	
	public FileConfiguration getGraczConfig(String name){
		return configs.get(name);
	}
	
	public void saveGraczConfig(String name){
		File f = new File(getDataFolder()+File.separator+"Gracze", name+".yml");
        try {
			getGraczConfig(name).save(f);
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void unregisterGraczConfig(String name){
		configs.remove(name);
	}
	
	public void addToConfig(){
		if (!getPluginConfig().contains("StatystykiSerwerowe")){
			getPluginConfig().createSection("StatystykiSerwerowe");
			getPluginConfig().createSection("StatystykiSerwerowe.Kasa");
			getPluginConfig().set("StatystykiSerwerowe.Kasa", 0.0);
			getPluginConfig().createSection("StatystykiSerwerowe.WydanaKasa");
			getPluginConfig().set("StatystykiSerwerowe.WydanaKasa", 0.0);
			getPluginConfig().createSection("StatystykiSerwerowe.ZarobionaKasa");
			getPluginConfig().set("StatystykiSerwerowe.ZarobionaKasa", 0.0);
			getPluginConfig().createSection("StatystykiSerwerowe.OtrzymanaKasa");
			getPluginConfig().set("StatystykiSerwerowe.OtrzymanaKasa", 0.0);
			getPluginConfig().createSection("StatystykiSerwerowe.WykonanePrzelewy");
			getPluginConfig().set("StatystykiSerwerowe.WykonanePrzelewy", 0);
			getPluginConfig().createSection("StatystykiSerwerowe.PrzelanaKasa");
			getPluginConfig().set("StatystykiSerwerowe.PrzelanaKasa", 0.0);
			
			getPluginConfig().createSection("StatystykiSerwerowe.KupioneMechanizmy");
			getPluginConfig().set("StatystykiSerwerowe.KupioneMechanizmy", 0.0);
			getPluginConfig().createSection("StatystykiSerwerowe.AktywowaneMechanizmy");
			getPluginConfig().set("StatystykiSerwerowe.AktywowaneMechanizmy", 0.0);
			
			getPluginConfig().createSection("StatystykiSerwerowe.FrakcjaInstor");
			getPluginConfig().set("StatystykiSerwerowe.FrakcjaInstor", 0);
			getPluginConfig().createSection("StatystykiSerwerowe.FrakcjaForter");
			getPluginConfig().set("StatystykiSerwerowe.FrakcjaForter", 0);
			getPluginConfig().createSection("StatystykiSerwerowe.FrakcjaProter");
			getPluginConfig().set("StatystykiSerwerowe.FrakcjaProter", 0);
			getPluginConfig().createSection("StatystykiSerwerowe.FrakcjaPread");
			getPluginConfig().set("StatystykiSerwerowe.FrakcjaPread", 0);
			
			getPluginConfig().createSection("StatystykiSerwerowe.LiczbaOdwiedzin");
			getPluginConfig().set("StatystykiSerwerowe.LiczbaOdwiedzin", 0);
			savePluginConfig();
		}
	}

	public void addToGraczConfig(String name){
		FileConfiguration g = getGraczConfig(name);
		if (!g.contains("Dane")){
			g.createSection("Dane");
			g.createSection("Dane.Level");
			getGraczConfig(name).set("Dane.Level", 0);
			getGraczConfig(name).createSection("Dane.PktPostepu");
			getGraczConfig(name).set("Dane.PktPostepu", 0);
			getGraczConfig(name).createSection("Dane.Exp");
			getGraczConfig(name).set("Dane.Exp", 0.00);
			getGraczConfig(name).createSection("Dane.Frakcja");
			getGraczConfig(name).set("Dane.Frakcja", "Brak");
			getGraczConfig(name).createSection("Dane.RejestracjaBlokow");
			getGraczConfig(name).set("Dane.RejestracjaBlokow", false);
			getGraczConfig(name).createSection("Dane.ZarejestrowaneKlocki");
			getGraczConfig(name).set("Dane.ZarejestrowaneKlocki", 0);
			
			getGraczConfig(name).createSection("Dane.Ekonomia");
			getGraczConfig(name).createSection("Dane.Ekonomia.Kasa");
			getGraczConfig(name).set("Dane.Ekonomia.Kasa", 0.0);
			getGraczConfig(name).createSection("Dane.Ekonomia.ZarobionaKasa");
			getGraczConfig(name).set("Dane.Ekonomia.ZarobionaKasa", 0.0);
			getGraczConfig(name).createSection("Dane.Ekonomia.WydanaKasa");
			getGraczConfig(name).set("Dane.Ekonomia.WydanaKasa", 0.0);
			getGraczConfig(name).createSection("Dane.Ekonomia.OtrzymanaKasa");
			getGraczConfig(name).set("Dane.Ekonomia.OtrzymanaKasa", 0.0);
			getGraczConfig(name).createSection("Dane.Ekonomia.PrzelanaKasa");
			getGraczConfig(name).set("Dane.Ekonomia.PrzelanaKasa", 0.0);
			getGraczConfig(name).createSection("Dane.Ekonomia.ZgubionaKasa");
			getGraczConfig(name).set("Dane.Ekonomia.ZgubionaKasa", 0.0);
			getGraczConfig(name).createSection("Dane.Ekonomia.WykonanePrzelewy");
			getGraczConfig(name).set("Dane.Ekonomia.WykonanePrzelewy", 0);
	
			getGraczConfig(name).createSection("Dane.Inwentarz");
			getGraczConfig(name).createSection("Dane.Inwentarz.MieczLvl");
			getGraczConfig(name).set("Dane.Inwentarz.MieczLvl", 1);
			getGraczConfig(name).createSection("Dane.Inwentarz.HelmLvl");
			getGraczConfig(name).set("Dane.Inwentarz.HelmLvl", 1);
			getGraczConfig(name).createSection("Dane.Inwentarz.KlataLvl");
			getGraczConfig(name).set("Dane.Inwentarz.KlataLvl", 1);
			getGraczConfig(name).createSection("Dane.Inwentarz.SpodnieLvl");
			getGraczConfig(name).set("Dane.Inwentarz.SpodnieLvl", 1);
			getGraczConfig(name).createSection("Dane.Inwentarz.ButyLvl");
			getGraczConfig(name).set("Dane.Inwentarz.ButyLvl", 1);
			
			getGraczConfig(name).createSection("Dane.Opcje");
			getGraczConfig(name).createSection("Dane.Opcje.Dzwiek");
			getGraczConfig(name).createSection("Dane.Opcje.Dzwiek.Exp");
			getGraczConfig(name).set("Dane.Opcje.Dzwiek.Exp", true);
			getGraczConfig(name).createSection("Dane.Opcje.Dzwiek.LvlUp");
			getGraczConfig(name).set("Dane.Opcje.Dzwiek.LvlUp", true);
			getGraczConfig(name).createSection("Dane.Opcje.Dzwiek.Teleport");
			getGraczConfig(name).set("Dane.Opcje.Dzwiek.Teleport", true);
			getGraczConfig(name).createSection("Dane.Opcje.Dzwiek.Armor");
			getGraczConfig(name).set("Dane.Opcje.Dzwiek.Armor", true);
			getGraczConfig(name).createSection("Dane.Opcje.Dzwiek.Chat");
			getGraczConfig(name).set("Dane.Opcje.Dzwiek.Chat", true);
			getGraczConfig(name).createSection("Dane.Opcje.Scoreboard");
			getGraczConfig(name).createSection("Dane.Opcje.Scoreboard.Pokaz");
			getGraczConfig(name).set("Dane.Opcje.Scoreboard.Pokaz", true);
			getGraczConfig(name).createSection("Dane.Opcje.Ogolne");
			getGraczConfig(name).createSection("Dane.Opcje.Ogolne.ToLvlType");
			getGraczConfig(name).set("Dane.Opcje.Ogolne.ToLvlType", 1);
			getGraczConfig(name).createSection("Dane.Opcje.Powiadomienia");
			getGraczConfig(name).createSection("Dane.Opcje.Powiadomienia.Wszystkie");
			getGraczConfig(name).set("Dane.Opcje.Powiadomienia.Wszystkie", true);
			getGraczConfig(name).createSection("Dane.Opcje.Powiadomienia.MaxLvl");
			getGraczConfig(name).set("Dane.Opcje.Powiadomienia.MaxLvl", true);
			
			getGraczConfig(name).createSection("Dane.Statystyki");
			getGraczConfig(name).createSection("Dane.Statystyki.Zabojstwa");
			getGraczConfig(name).set("Dane.Statystyki.Zabojstwa", 0);
			getGraczConfig(name).createSection("Dane.Statystyki.Smierci");
			getGraczConfig(name).set("Dane.Statystyki.Smierci", 0);
			getGraczConfig(name).createSection("Dane.Statystyki.KupioneMechanizmy");
			getGraczConfig(name).set("Dane.Statystyki.KupioneMechanizmy", 0);
			getGraczConfig(name).createSection("Dane.Statystyki.AktywowaneMechanizmy");
			getGraczConfig(name).set("Dane.Statystyki.AktywowaneMechanizmy", 0);
			
			getGraczConfig(name).createSection("Dane.Odblokowane");
			getGraczConfig(name).createSection("Dane.Odblokowane.Healer");
			getGraczConfig(name).set("Dane.Odblokowane.Healer", 0);
			getGraczConfig(name).createSection("Dane.Odblokowane.Speed");
			getGraczConfig(name).set("Dane.Odblokowane.Speed", 0);
			getGraczConfig(name).createSection("Dane.Odblokowane.Jump");
			getGraczConfig(name).set("Dane.Odblokowane.Jump", 0);
			getGraczConfig(name).createSection("Dane.Odblokowane.MovePack");
			getGraczConfig(name).set("Dane.Odblokowane.MovePack", 0);
			getGraczConfig(name).createSection("Dane.Odblokowane.Teleport");
			getGraczConfig(name).set("Dane.Odblokowane.Teleport", 0);
			getGraczConfig(name).createSection("Dane.Odblokowane.Fireball");
			getGraczConfig(name).set("Dane.Odblokowane.Fireball", 0);
			getGraczConfig(name).createSection("Dane.Odblokowane.Drain");
			getGraczConfig(name).set("Dane.Odblokowane.Drain", 0);
			
			getGraczConfig(name).createSection("Dane.Uzycia");
			getGraczConfig(name).createSection("Dane.Uzycia.Instor");
			getGraczConfig(name).set("Dane.Uzycia.Instor", 0);
			getGraczConfig(name).createSection("Dane.Uzycia.Forter");
			getGraczConfig(name).set("Dane.Uzycia.Forter", 0);
			getGraczConfig(name).createSection("Dane.Uzycia.Proter");
			getGraczConfig(name).set("Dane.Uzycia.Proter", 0);
			getGraczConfig(name).createSection("Dane.Uzycia.Pread");
			getGraczConfig(name).set("Dane.Uzycia.Pread", 0);
			
			saveGraczConfig(name);
		}
		
		// Update section !
		
	}
	
	@SuppressWarnings("deprecation")
	public static void setScoreboard(Player p, boolean isQuiting){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("side", "dummy");
		String puid = p.getUniqueId().toString();
		if (pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getScoreboardShow()){
			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.setDisplayName(ChatColor.GREEN+""+ChatColor.BOLD+"INFO");
			OfflinePlayer sc1 = Bukkit.getOfflinePlayer(ChatColor.GRAY+"Gracze online");
			Score score = objective.getScore(sc1);
			int gracze = 0;
			if (isQuiting){
				gracze = Bukkit.getOnlinePlayers().length-1;
			}else{
				gracze = Bukkit.getOnlinePlayers().length;
			}
			OfflinePlayer sc2 = Bukkit.getOfflinePlayer(ChatColor.AQUA+""+gracze+"/"+Bukkit.getMaxPlayers());
			score.setScore(9);
			Score score1 = objective.getScore(sc2);
			score1.setScore(8);
			OfflinePlayer sc3 = Bukkit.getOfflinePlayer(ChatColor.GOLD+"");
			Score score2 = objective.getScore(sc3);
			score2.setScore(7);
			OfflinePlayer sc4 = Bukkit.getOfflinePlayer(ChatColor.GRAY+"Poziom");
			Score score3 = objective.getScore(sc4);
			score3.setScore(6);
			int poziom = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(p.getUniqueId().toString()).getStaty().getLevel();
			OfflinePlayer sc5 = Bukkit.getOfflinePlayer(ChatColor.RESET+""+ChatColor.AQUA+""+poziom);
			Score score4 = objective.getScore(sc5);
			score4.setScore(5);
			p.setScoreboard(board);
		}else{
			p.setScoreboard(board);
		}
	}

	public API getApi() {
		return api;
	}
	
	
}
