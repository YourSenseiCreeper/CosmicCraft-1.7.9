package pl.gastherr.cosmic.events;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import pl.gastherr.cosmic.Main;
import pl.gastherr.cosmic.API;

public class PickupItem implements Listener{

	Main plugin;
	API API;
	
	public PickupItem(Main plugin){
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e){
		Player p = e.getPlayer();
		Random r = new Random();
		
		if (e.getItem().getItemStack().getType().equals(Material.GOLD_INGOT)){
			e.setCancelled(true);
			e.getItem().remove();
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, 1);
			int liczba = r.nextInt(100);
			p.sendMessage(ChatColor.GRAY+"Dostajesz: "+ChatColor.GOLD+liczba+".0 cc");
			pl.gastherr.cosmic.API.addKasa(p, liczba);
			return;
		}
		if (e.getItem().getItemStack().getType().equals(Material.EXP_BOTTLE)){
			e.setCancelled(true);
			e.getItem().remove();
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
			int liczba = r.nextInt(25);
			double l2 = liczba / 100;
			p.sendMessage(ChatColor.GRAY+"Dostajesz: "+ChatColor.GOLD+liczba+"% lvla");
			pl.gastherr.cosmic.API.addExp(p, (float) l2);
			return;
		}
	}
	
}
