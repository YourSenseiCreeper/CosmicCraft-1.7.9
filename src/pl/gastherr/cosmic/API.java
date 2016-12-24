package pl.gastherr.cosmic;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import pl.gastherr.cosmic.events.PlayerJoin;

public class API {
	
	static Main plugin;
	
	public API (Main plugin){
		API.plugin = plugin;
	}
	
	public static void addExp(Player p, float giveExp){
		
		String puid = p.getUniqueId().toString();
		int lvl = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getLevel();
		float exp = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getExp();
		double kasa = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getKasa();
		double zarobionaKasa = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getZarobionaKasa();
		int postep = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getPktPostepu();
		
		if (lvl == 50){
			p.sendMessage(ChatColor.RED+"Osiagnales maksymalny poziom ("+ChatColor.GOLD+""+ChatColor.BOLD+"50"+ChatColor.RED+") i nie mozesz wyzej awansowac!");
			p.sendMessage(ChatColor.GRAY+"Ta wiadomosc mozesz wylaczyc w: "+ChatColor.GOLD+"Menu > Opcje > Ogolne > Powiadomienia");
			return;
		}
		if (lvl == 0 && exp == 0){
			p.setExp(p.getExp()+giveExp);
			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setExp(giveExp);
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
			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setExp(pozostalyExp);
			p.setExp(pozostalyExp);
			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setLevel(lvl+1);
			p.setLevel(p.getLevel()+1);
			int newLvl = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getLevel();
			
			double nagroda = newLvl * 250;
			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setKasa(kasa+nagroda);
			
			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setZarobionaKasa(zarobionaKasa+nagroda);
			
			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).setPktPostepu(postep+1);
			int newPunkty = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getPktPostepu();
			
			p.sendMessage(ChatColor.GRAY+"==============[ "+ChatColor.GOLD+""+ChatColor.BOLD+newLvl+ChatColor.GOLD+" poziom "+ChatColor.GRAY+"]==============");
			p.sendMessage(ChatColor.GRAY+"W nagrode otrzymujesz "+ChatColor.GOLD+nagroda+" cc");
			p.sendMessage(ChatColor.GRAY+"Twoje punkty postepu: "+ChatColor.GOLD+newPunkty);
			p.sendMessage(ChatColor.GRAY+"Swoje aktualne statystyki mozesz sprawdzic komenda "+ChatColor.GOLD+"/pinfo");
			Main.setScoreboard(p, false);
			return;
		}else{
				p.setExp(p.getExp()+giveExp);
				pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setExp(exp+giveExp);
		}
	}
	
	public static void addKasa(Player p, double kasa){
		
		String puid = p.getUniqueId().toString();
		
		PlayerJoin.listaGraczy.get(puid).getStaty().setKasa(PlayerJoin.listaGraczy.get(puid).getStaty().getKasa()+kasa);
		PlayerJoin.listaGraczy.get(puid).getStaty().setZarobionaKasa(PlayerJoin.listaGraczy.get(puid).getStaty().getZarobionaKasa()+kasa);
	}

}
