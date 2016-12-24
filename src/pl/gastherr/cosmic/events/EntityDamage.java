package pl.gastherr.cosmic.events;

import java.util.Date;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import pl.gastherr.cosmic.Main;

public class EntityDamage implements Listener{

	Main plugin;
	
	public EntityDamage(Main plugin){
		this.plugin = plugin;
	}
	
	HashMap<String, Integer> licznik = new HashMap<String, Integer>();
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		
		Entity damager  = e.getDamager();
		Entity taker = e.getEntity();
		
		if (taker.getType().equals(EntityType.PLAYER)){
			Player ptaker = (Player) taker;
			Player pdamager = (Player) damager;
			String tuid = ptaker.getUniqueId().toString();
			boolean spawning = PlayerJoin.listaGraczy.get(tuid).getWalka().getIsSpawing();
			if (spawning){
				e.setCancelled(true);
				pdamager.sendMessage(ChatColor.RED+"Nie mozesz uderzyc tego gracza przez 5 sek");
			}
		}
		
		if (damager.getType().equals(EntityType.PLAYER)){
			
			Player pdamager = (Player) damager;
			String puid = pdamager.getUniqueId().toString();
			
			if (pdamager.getItemInHand().getType().equals(Material.STONE_SWORD)){
				ItemStack hand = PlayerJoin.listaGraczy.get(puid).getWalka().getSword();
				hand.setDurability((short) -1);
				pdamager.setItemInHand(hand);
			}
		}
		
		if (damager.getType().equals(EntityType.PLAYER) && taker.getType().equals(EntityType.PLAYER)){
			
			Player pdamager = (Player) damager;
			Player ptaker = (Player) taker;
			
			if (!Bukkit.getOnlinePlayers().equals(ptaker)){
				return;
			}
			
			ItemStack h = ptaker.getInventory().getHelmet();
			h.setDurability((short) 0);
			ptaker.getInventory().setHelmet(h);
			ItemStack ch = ptaker.getInventory().getChestplate();
			ch.setDurability((short) 0);
			ptaker.getInventory().setChestplate(ch);
			ItemStack l = ptaker.getInventory().getLeggings();
			l.setDurability((short) 0);
			ptaker.getInventory().setLeggings(l);
			ItemStack b = ptaker.getInventory().getBoots();
			b.setDurability((short) 0);
			ptaker.getInventory().setBoots(b);
			
			if(pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(pdamager.getName()).getWalka().getActiveMech().contains("Drain")){
				EntityDamageEvent health = pdamager.getLastDamageCause();
				double cause_health = health.getDamage();
				long time = new Date().getTime();
				
				PlayerJoin.listaGraczy.get(ptaker.getName()).getWalka().setFirstAtack(time);
				if (!licznik.containsKey(pdamager.getName())){
					licznik.put(pdamager.getName(), 0);
				}
				if (licznik.get(pdamager.getName()) <= 5){
					if (pdamager.getHealth()+cause_health <= 20){
						pdamager.setHealth(pdamager.getHealth()+cause_health);
						licznik.put(pdamager.getName(), licznik.get(pdamager.getName())+1);
					}else{
						double reszta = 20 - pdamager.getHealth();
						pdamager.setHealth(pdamager.getHealth()+reszta);
						licznik.put(pdamager.getName(), licznik.get(pdamager.getName())+1);
					}
					if (pdamager.getHealth() == 20){
						return;
					}
				}
			}
		}
		
	}
}
