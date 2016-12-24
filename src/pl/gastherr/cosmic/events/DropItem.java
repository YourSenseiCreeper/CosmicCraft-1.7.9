package pl.gastherr.cosmic.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import pl.gastherr.cosmic.Main;

public class DropItem implements Listener{

	Main plugin;
	
	public DropItem (Main plugin){
		this.plugin = plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		
		String puid = e.getPlayer().getUniqueId().toString();
		boolean openInv = PlayerJoin.listaGraczy.get(puid).getWalka().getOpenChoise();
		boolean fight = PlayerJoin.listaGraczy.get(puid).getWalka().getIsFighting();
		
		if (openInv || fight){
			e.setCancelled(true);
		}
	}
	
	
}
