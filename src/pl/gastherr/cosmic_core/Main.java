package pl.gastherr.cosmic_core;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import pl.gastherr.cosmic.util.Mech;
import pl.gastherr.cosmic_core.util.PluginData;

public class Main extends JavaPlugin implements Listener{

	/**
	Commands Commands;					Dodaæ wtyczke na komendy serwerowe		
	ChatSay ChatSay;					Event pisania na czacie
	public PlayerJoin PlayerJoin;		Event do³¹czania gracza do gry
	Signs Signs;						Event klikniêcia w tabliczkê
	ItemsAfterDeath ItemsAfterDeath;	Event œmierci gracza
	EntityDamage EntityDamage;			Event zadania obra¿eñ
	PlayerMove PlayerMove;				Event ruchu gracza
	PickupItem PickupItem;				Event podniesienia przedmiotu				
	*/
	
	private API api;
	private PluginData pl_data;
	private static String plugin_name = "CosmicCraft_Core";
	
	private HashMap<String, Mech> mechs = new HashMap<>();
	private ConsoleCommandSender kon = Bukkit.getConsoleSender();

	@Override
	@SuppressWarnings("deprecation")
	public void onEnable() {
		pl_data = new PluginData(this);
		pl_data.loadServerData();
		
		api = new API(this);

		loadMechs();
		
		kon.sendMessage(ChatColor.WHITE+"["+ChatColor.AQUA+plugin_name+" by gastherr"+ChatColor.WHITE+"] Uruchamianie...");
		Bukkit.getScheduler().runTaskTimer(this, new Runnable(){
			
			@Override
			public void run(){
				if (Bukkit.getOnlinePlayers().length > 0){
					for(Player online : Bukkit.getOnlinePlayers()){
						PluginData.savePlayer(online.getName());
					}
					Bukkit.broadcastMessage(ChatColor.GOLD+"[Autosave]"+ChatColor.GRAY+" Pomyslnie zapisano dane "+ChatColor.GOLD+Bukkit.getOnlinePlayers().length+ChatColor.GRAY+" uzytkownikow!");
				}
			}	
		}, 0, 20*60*5);
		if (Bukkit.getOnlinePlayers().length > 0){
			for (Player online : Bukkit.getOnlinePlayers()){
				PluginData.loadPlayer(online.getName());
			}
		}
	}

	@Override
	@SuppressWarnings("deprecation")
	public void onDisable() {
		pl_data.saveServerData();
		
		kon.sendMessage(ChatColor.WHITE+"["+ChatColor.AQUA+plugin_name+" by gastherr"+ChatColor.WHITE+"] Zapisywanie danych...");
		for (Player online : Bukkit.getOnlinePlayers()){
			PluginData.savePlayer(online.getName());
		}
		
	}
	
	//Loading all mechanisms;
		private void loadMechs(){
			mechs.put("Heal:1", new Mech("Heal", "Leczy", 1, 5, 5, 40, PotionEffectType.HEAL));
			mechs.put("Heal:2", new Mech("Heal", "Leczy", 2, 10, 10, 100, PotionEffectType.HEAL));
			mechs.put("Heal:3", new Mech("Heal", "Leczy", 3, 15, 20, 250, PotionEffectType.HEAL));
		}
	    
	    
		public String fixColors(String msg){
			return ChatColor.translateAlternateColorCodes('&', msg);
		}
		
		public HashMap<String, Mech> getMechs(){
			return mechs;
		}
		
		public API getApi() {
			return api;
		}
		
	/**
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
	
	*/
}
