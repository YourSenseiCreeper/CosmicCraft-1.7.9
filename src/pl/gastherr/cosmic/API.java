package pl.gastherr.cosmic;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import pl.gastherr.cosmic.events.PlayerJoin;
import pl.gastherr.cosmic.player.Gracz;

public class API {
	
	static Main plugin;
	static HashMap<String, Gracz> players;
	
	public API (Main plugin){
		API.plugin = plugin;
		players = PlayerJoin.getListaGraczy();
	}
	
	public static void addExp(Player p, float giveExp){
		
		String puid = p.getUniqueId().toString();
		int lvl = players.get(puid).getStaty().getLevel();
		float exp = players.get(puid).getStaty().getExp();
		double kasa = players.get(puid).getStaty().getKasa();
		double zarobionaKasa = players.get(puid).getStaty().getZarobionaKasa();
		int postep = players.get(puid).getPktPostepu();
		
		if (lvl == 50){
			p.sendMessage(ChatColor.RED+"Osiagnales maksymalny poziom ("+ChatColor.GOLD+""+ChatColor.BOLD+"50"+ChatColor.RED+") i nie mozesz wyzej awansowac!");
			p.sendMessage(ChatColor.GRAY+"Ta wiadomosc mozesz wylaczyc w: "+ChatColor.GOLD+"Menu > Opcje > Ogolne > Powiadomienia");
			return;
		}
		if (lvl == 0 && exp == 0){
			p.setExp(p.getExp()+giveExp);
			players.get(puid).getStaty().setExp(giveExp);
			p.sendMessage(ChatColor.GRAY+"----------------------------------------------------");
			p.sendMessage(ChatColor.GOLD+"Gratulacje! To twoje pierwsze zdobyte doswiadczenie!");
			p.sendMessage(ChatColor.GRAY+"----------------------------------------------------");
			p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST2, 1, 1);
			return;
		}
		if (exp+giveExp >= 1){
			if (lvl == 0){
				plugin.getServer().broadcastMessage(ChatColor.YELLOW+"Gracz "+ChatColor.GOLD+p.getName()+ChatColor.YELLOW+" osiagnal 1 poziom! Gratulacje!");
			}
			float pozostalyExp = (exp + giveExp) - 1;
			players.get(puid).getStaty().setExp(pozostalyExp);
			
			p.setExp(pozostalyExp);
			players.get(puid).getStaty().setLevel(lvl+1);
			
			p.setLevel(p.getLevel()+1);
			int newLvl = players.get(puid).getStaty().getLevel();
			
			double nagroda = newLvl * 250;
			players.get(puid).getStaty().setKasa(kasa+nagroda);
			
			players.get(puid).getStaty().setZarobionaKasa(zarobionaKasa+nagroda);
			
			players.get(puid).setPktPostepu(postep+1);
			int newPunkty = players.get(puid).getPktPostepu();
			
			p.sendMessage(ChatColor.GRAY+"==============[ "+ChatColor.GOLD+""+ChatColor.BOLD+newLvl+ChatColor.GOLD+" poziom "+ChatColor.GRAY+"]==============");
			p.sendMessage(ChatColor.GRAY+"W nagrode otrzymujesz "+ChatColor.GOLD+nagroda+" cc");
			p.sendMessage(ChatColor.GRAY+"Twoje punkty postepu: "+ChatColor.GOLD+newPunkty);
			p.sendMessage(ChatColor.GRAY+"Swoje aktualne statystyki mozesz sprawdzic komenda "+ChatColor.GOLD+"/pinfo");
			Main.setScoreboard(p, false);
			return;
		}else{
				p.setExp(p.getExp()+giveExp);
				players.get(puid).getStaty().setExp(exp+giveExp);
		}
	}
	
	public static void addKasa(Player p, double kasa){
		
		String puid = p.getUniqueId().toString();
		
		players.get(puid).getStaty().setKasa(players.get(puid).getStaty().getKasa()+kasa);
		players.get(puid).getStaty().setZarobionaKasa(players.get(puid).getStaty().getZarobionaKasa()+kasa);
	}

}
