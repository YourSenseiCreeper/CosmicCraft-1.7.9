package pl.gastherr.cosmic.events;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import pl.gastherr.cosmic.Main;

public class PlayerMove implements Listener{

	Main plugin;
	PlayerJoin PlayerJoin;
	
	public PlayerMove(Main plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		
		Player p = e.getPlayer();
		String puid = p.getUniqueId().toString();
		boolean isTeleporting = PlayerJoin.listaGraczy.get(puid).getIsTeleporting();
		if (isTeleporting){
			if (e.getFrom().getBlockX() != e.getTo().getBlockX() ||
			    e.getFrom().getBlockY() != e.getTo().getBlockY() ||
			    e.getFrom().getBlockZ() != e.getTo().getBlockZ()){
				p.sendMessage(ChatColor.RED+"Teleportacja anulowana.");
				PlayerJoin.listaGraczy.get(puid).setIsTeleporting(false);
			}
		}
		if (p.getFallDistance() >= 40){
			if (p.getGameMode().equals(GameMode.CREATIVE)){
				return;
			}
			ArrayList<Location> listaLoc = new ArrayList<Location>();
			for(int z = 1; z < 5; z++){
				double blockX = plugin.getPluginConfig().getDouble("Lokacje.ArenaSpawn"+z+".BlockX");
				double blockY = plugin.getPluginConfig().getDouble("Lokacje.ArenaSpawn"+z+".BlockY");
				double blockZ = plugin.getPluginConfig().getDouble("Lokacje.ArenaSpawn"+z+".BlockZ");
				float pitch = (float) plugin.getPluginConfig().getDouble("Lokacje.ArenaSpawn"+z+".Pitch");
				float yaw = (float) plugin.getPluginConfig().getDouble("Lokacje.ArenaSpawn"+z+".Yaw");
				World swiat = Bukkit.getWorld("world_the_end");
				Location sLoc = new Location(swiat, blockX, blockY, blockZ, yaw, pitch);
				listaLoc.add(sLoc);
			}
			Random r = new Random();
			int liczba = r.nextInt(listaLoc.size());
			Location fLoc = listaLoc.get(liczba);
			p.sendMessage(""+p.getFallDistance());
			p.setNoDamageTicks(20*2);
			p.teleport(fLoc);
		}
	}
	
}
