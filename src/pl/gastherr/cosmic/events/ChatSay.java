package pl.gastherr.cosmic.events;

import java.util.UnknownFormatConversionException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import pl.gastherr.cosmic.Main;

public class ChatSay implements Listener{
	
	Main plugin;
	
	public ChatSay (Main plugin){
		this.plugin = plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		
		Player p = e.getPlayer();
		String name = p.getName();
		String lvl = ChatColor.DARK_GRAY+"["+ChatColor.AQUA+p.getLevel()+" lvl"+ChatColor.DARK_GRAY+"] "+ChatColor.RESET;
		
		String in = "";
		String pPrefix = ChatColor.DARK_GRAY+"["+ChatColor.YELLOW+in+ChatColor.DARK_GRAY+"] ";
		
		if (plugin.getPluginConfig().getStringList("KidMods").contains(name)){
			in = "▌";
		}
		else if (plugin.getPluginConfig().getStringList("Mods").contains(name)){
			in = "▌▌";
		}
		else if (plugin.getPluginConfig().getStringList("Admins").contains(name)){
			in = "▌▌▌";
		}
		else if (plugin.getPluginConfig().getStringList("HAdmins").contains(name)){
			in = "▌▌▌▌";
		}
		else{
			pPrefix = lvl;
		}
		String pointer = ChatColor.BOLD+" » ";
		String format = pPrefix+ChatColor.GRAY+e.getPlayer().getName()+ChatColor.WHITE+pointer+ChatColor.RED+e.getMessage();
		try{
			e.setFormat(format);
		}catch(UnknownFormatConversionException e1){
			p.sendMessage(ChatColor.RED+"Znak '%' jest zablokowany!");
			e.setCancelled(true);
		}
		for(Player pp : Bukkit.getOnlinePlayers()){
		if (PlayerJoin.listaGraczy.get(pp.getUniqueId().toString()).getSoundChat()){
			pp.playSound(pp.getLocation(), Sound.NOTE_PIANO, 1, 1);
		}
		}
	}
	
}
