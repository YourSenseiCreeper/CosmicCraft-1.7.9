package pl.gastherr.cosmic.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

//import com.gmail.bukkitsmerf.check.Check;
//import com.gmail.bukkitsmerf.check.IPlayersStorage;

import pl.gastherr.cosmic.Main;
import pl.gastherr.cosmic.player.Gracz;
import pl.gastherr.cosmic.player.Menu;
import pl.gastherr.cosmic.player.Walka;
import pl.gastherr.cosmic.player.Staty;
import pl.gastherr.cosmic.util.MenuType;

public class PlayerJoin implements Listener{
	
	Main plugin;
	public static HashMap<String, Gracz> listaGraczy = new HashMap<String, Gracz>();
	
	public PlayerJoin (Main plugin){
		this.plugin = plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		
		//Player data
		Player p = e.getPlayer();
		UUID pU = p.getUniqueId();
		String puid = pU.toString();
		String name = p.getName();
		
		//Loading & registring player
		plugin.registerGraczConfig(puid);
		plugin.addToGraczConfig(puid);
		loadUser(puid);
		
		e.setJoinMessage(ChatColor.GOLD+p.getName()+ChatColor.GRAY+" dolaczyl do gry!");
		//IPlayersStorage storage = Check.getStorage();
		List<String> kmods = plugin.getPluginConfig().getStringList("KidMods");
		List<String> mods = plugin.getPluginConfig().getStringList("Mods");
		List<String> admins = plugin.getPluginConfig().getStringList("Admins");
		List<String> hadmins = plugin.getPluginConfig().getStringList("HAdmins");
		String plist = "";
		if (kmods.contains(name)){
			plist = ChatColor.YELLOW+name;
		}
		else if (mods.contains(name)){
			plist = ChatColor.GOLD+name;
		}
		else if (admins.contains(name)){
			plist = ChatColor.RED+name;
		}
		else if (hadmins.contains(name)){
			plist = ChatColor.DARK_RED+name;
		}
		else	//default
		{
			plist = ChatColor.GRAY+name;
		}
		
		/**Logging in & checking premium
		if (storage.isPremium(name)){
			p.sendMessage(ChatColor.GRAY+"Dolaczasz z konta premium. "+ChatColor.GREEN+"Nie musisz sie logowac!");
		}else{
			p.sendMessage(ChatColor.GRAY+"Dolaczasz z konta no-premium.");
		}
		*/
		
		p.setPlayerListName(plist);
		e.getPlayer().setLevel(listaGraczy.get(puid).getStaty().getLevel());
		e.getPlayer().setExp((float) listaGraczy.get(puid).getStaty().getExp());
		for(Player on : Bukkit.getOnlinePlayers()){
			Main.setScoreboard(on, false);
		}
		plugin.statystyki.setLiczbaOdwiedzin(plugin.statystyki.getLiczbaOdwiedzin()+1);
	}
	
	public void loadUser(String name){
		FileConfiguration player = plugin.getGraczConfig(name);
		
		float exp = (float) player.getDouble("Dane.Exp");
		int lvl = player.getInt("Dane.Level");
		int pktpostepu = player.getInt("Dane.PktPostepu");
		double kasa = player.getDouble("Dane.Ekonomia.Kasa");
		double wydanaKasa = player.getDouble("Dane.Ekonomia.WydanaKasa");
		double zarobionaKasa = player.getDouble("Dane.Ekonomia.ZarobionaKasa");
		double przelanaKasa = player.getDouble("Dane.Ekonomia.PrzelanaKasa");
		double otrzymanaKasa = player.getDouble("Dane.Ekonomia.OtrzymanaKasa");
		int wykonanePrzelewy = player.getInt("Dane.Ekonomia.WykonanePrzelewy");
		
		boolean sound_exp = player.getBoolean("Dane.Opcje.Dzwiek.Exp");
		boolean sound_lvlup = player.getBoolean("Dane.Opcje.Dzwiek.LvlUp");
		boolean sound_teleport = player.getBoolean("Dane.Opcje.Dzwiek.Teleport");
		boolean scoreboard_show = player.getBoolean("Dane.Opcje.Scoreboard.Pokaz");
		boolean sound_chat = player.getBoolean("Dane.Opcje.Dzwiek.Chat");
		
		int mieczLvl = player.getInt("Dane.Inwentarz.MieczLvl");
		int helmLvl = player.getInt("Dane.Inwentarz.HelmLvl");
		int klataLvl = player.getInt("Dane.Inwentarz.KlataLvl");
		int spodnieLvl = player.getInt("Dane.Inwentarz.SpodnieLvl");
		int butyLvl = player.getInt("Dane.Inwentarz.ButyLvl");
		
		int zabojstwa = player.getInt("Dane.Statystyki.Zabojstwa");
		int smierci = player.getInt("Dane.Statystyki.Smierci");
		int aktywowane_mechanizmy = player.getInt("Dane.Statystyki.AktywowaneMechanizmy");
		
		int uz_instor = player.getInt("Dane.Uzycia.Instor");
		int uz_forter = player.getInt("Dane.Uzycia.Forter");
		int uz_proter = player.getInt("Dane.Uzycia.Proter");
		int uz_pread = player.getInt("Dane.Uzycia.Pread");
		
		ArrayList<String> activeMech = new ArrayList<String>();
		ArrayList<ItemStack> mechList = new ArrayList<ItemStack>();
		MenuType mType = pl.gastherr.cosmic.util.MenuType.NULL;
		Menu menu = new Menu(mType, 0);
		Walka walka = new Walka(false, false, 0, activeMech, activeMech, mechList, null, false, false, mType, 0);
		
		Staty staty = new Staty(lvl, exp, kasa, wydanaKasa, zarobionaKasa, otrzymanaKasa, wykonanePrzelewy, przelanaKasa,
				aktywowane_mechanizmy, mieczLvl, helmLvl, klataLvl, spodnieLvl, butyLvl, zabojstwa, smierci,
				uz_instor, uz_forter, uz_proter, uz_pread);
		
		Gracz gr = new Gracz(menu, staty, walka, pktpostepu, "", sound_exp, sound_lvlup, sound_teleport, sound_chat,
				scoreboard_show, false);
		listaGraczy.put(name, gr);
}

	public HashMap<String, Gracz> getListaGraczy() {
		return listaGraczy;
	}
	
}
