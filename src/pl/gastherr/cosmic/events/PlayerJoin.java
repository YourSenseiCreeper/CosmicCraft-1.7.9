package pl.gastherr.cosmic.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.bukkitsmerf.check.Check;
import com.gmail.bukkitsmerf.check.IPlayersStorage;

import pl.gastherr.cosmic.Main;
import pl.gastherr.cosmic.player.Gracz;
import pl.gastherr.cosmic.player.Menu;
import pl.gastherr.cosmic.player.Walka;
import pl.gastherr.cosmic.player.Staty;
import pl.gastherr.cosmic.ServerStats;
import pl.gastherr.cosmic.util.MenuType;

public class PlayerJoin implements Listener{
	
	Main plugin;
	Gracz Gracz;
	Walka Walka;
	Staty Staty;
	ServerStats ServerStats;
	public static HashMap<String, Gracz> listaGraczy = new HashMap<String, Gracz>();
	
	public PlayerJoin (Main plugin){
		this.plugin = plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e){

		Player p = e.getPlayer();
		UUID pU = p.getUniqueId();
		String puid = pU.toString();
		String name = p.getName();
		plugin.registerGraczConfig(puid);
		plugin.addToGraczConfig(puid);
		loadUser(puid);
		e.setJoinMessage(ChatColor.GOLD+p.getName()+ChatColor.GRAY+" dolaczyl do gry!");
		IPlayersStorage storage = Check.getStorage();
		ArrayList<String> kmods = (ArrayList<String>) plugin.getPluginConfig().getStringList("KidMods");
		ArrayList<String> mods = (ArrayList<String>) plugin.getPluginConfig().getStringList("Mods");
		ArrayList<String> admins = (ArrayList<String>) plugin.getPluginConfig().getStringList("Admins");
		ArrayList<String> hadmins = (ArrayList<String>) plugin.getPluginConfig().getStringList("HAdmins");
		String plist = "";
		if (kmods.contains(name)){
			plist = ChatColor.YELLOW+name;
		}
		if (mods.contains(name)){
			plist = ChatColor.GOLD+name;
		}
		if (admins.contains(name)){
			plist = ChatColor.RED+name;
		}
		if (hadmins.contains(name)){
			plist = ChatColor.DARK_RED+name;
		}
		if (!kmods.contains(name) && !mods.contains(name) && !admins.contains(name) && !hadmins.contains(name)){
			plist = ChatColor.GRAY+name;
		}
		p.setPlayerListName(plist);
		if (storage.isPremium(name)){
			p.sendMessage(ChatColor.GRAY+"Dolaczasz z konta premium. "+ChatColor.GREEN+"Nie musisz sie logowac!");
		}else{
			p.sendMessage(ChatColor.GRAY+"Dolaczasz z konta no-premium.");
		}
		e.getPlayer().setLevel(listaGraczy.get(puid).getStaty().getLevel());
		e.getPlayer().setExp((float) listaGraczy.get(puid).getStaty().getExp());
		for(Player on : Bukkit.getOnlinePlayers()){
			Main.setScoreboard(on, false);
		}
		plugin.statystyki.setLiczbaOdwiedzin(plugin.statystyki.getLiczbaOdwiedzin()+1);
	}
	
	public void loadUser(String name){
		float exp = (float) plugin.getGraczConfig(name).getDouble("Dane.Exp");
		int lvl = plugin.getGraczConfig(name).getInt("Dane.Level");
		int pktpostepu = plugin.getGraczConfig(name).getInt("Dane.PktPostepu");
		double kasa = plugin.getGraczConfig(name).getDouble("Dane.Ekonomia.Kasa");
		double wydanaKasa = plugin.getGraczConfig(name).getDouble("Dane.Ekonomia.WydanaKasa");
		double zarobionaKasa = plugin.getGraczConfig(name).getDouble("Dane.Ekonomia.ZarobionaKasa");
		double przelanaKasa = plugin.getGraczConfig(name).getDouble("Dane.Ekonomia.PrzelanaKasa");
		double otrzymanaKasa = plugin.getGraczConfig(name).getDouble("Dane.Ekonomia.OtrzymanaKasa");
		int wykonanePrzelewy = plugin.getGraczConfig(name).getInt("Dane.Ekonomia.WykonanePrzelewy");
		boolean sound_exp = plugin.getGraczConfig(name).getBoolean("Dane.Opcje.Dzwiek.Exp");
		boolean sound_lvlup = plugin.getGraczConfig(name).getBoolean("Dane.Opcje.Dzwiek.LvlUp");
		boolean sound_teleport = plugin.getGraczConfig(name).getBoolean("Dane.Opcje.Dzwiek.Teleport");
		boolean scoreboard_show = plugin.getGraczConfig(name).getBoolean("Dane.Opcje.Scoreboard.Pokaz");
		boolean sound_chat = plugin.getGraczConfig(name).getBoolean("Dane.Opcje.Dzwiek.Chat");
		int mieczLvl = plugin.getGraczConfig(name).getInt("Dane.Inwentarz.MieczLvl");
		int helmLvl = plugin.getGraczConfig(name).getInt("Dane.Inwentarz.HelmLvl");
		int klataLvl = plugin.getGraczConfig(name).getInt("Dane.Inwentarz.KlataLvl");
		int spodnieLvl = plugin.getGraczConfig(name).getInt("Dane.Inwentarz.SpodnieLvl");
		int butyLvl = plugin.getGraczConfig(name).getInt("Dane.Inwentarz.ButyLvl");
		int zabojstwa = plugin.getGraczConfig(name).getInt("Dane.Statystyki.Zabojstwa");
		int smierci = plugin.getGraczConfig(name).getInt("Dane.Statystyki.Smierci");
		int aktywowane_mechanizmy = plugin.getGraczConfig(name).getInt("Dane.Statystyki.AktywowaneMechanizmy");
		int uz_instor = plugin.getGraczConfig(name).getInt("Dane.Uzycia.Instor");
		int uz_forter = plugin.getGraczConfig(name).getInt("Dane.Uzycia.Forter");
		int uz_proter = plugin.getGraczConfig(name).getInt("Dane.Uzycia.Proter");
		int uz_pread = plugin.getGraczConfig(name).getInt("Dane.Uzycia.Pread");
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
	
}
