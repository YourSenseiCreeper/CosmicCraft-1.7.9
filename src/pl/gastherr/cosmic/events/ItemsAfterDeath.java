package pl.gastherr.cosmic.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import pl.gastherr.cosmic.API;
import pl.gastherr.cosmic.Main;
import pl.gastherr.cosmic.events.PlayerJoin;
import pl.gastherr.cosmic.events.NPCInteract;
import pl.gastherr.cosmic.player.Gracz;

public class ItemsAfterDeath implements Listener{

	static Main plugin;
	static HashMap<String, Gracz> players = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy;
	static HashMap<String, ItemStack[]> invBefore = new HashMap<String, ItemStack[]>();
	static HashMap<String, Float> expAfter = new HashMap<String, Float>();
	
	public ItemsAfterDeath (Main main){
		plugin = main;
	    main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	NPCInteract inter = new NPCInteract(plugin);
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		
		// NOWY KOD:
		// DODAÆ CHECKERY OPCJI
		
		e.setDeathMessage(null);
		e.setKeepLevel(true);
		
		
		
		if (e.getEntity() instanceof Player && e.getEntity().getKiller() != null){
			UUID kUd = e.getEntity().getKiller().getUniqueId();
			String kuid = kUd.toString();
			String kname = e.getEntity().getKiller().getName();
			Player killer = e.getEntity().getKiller();
			int lvlKiller = players.get(kuid).getStaty().getLevel();
			String kFrakcja = players.get(kuid).getFrakcja();
			
			Player frager = (Player) e.getEntity();
			String fname = frager.getName();
			UUID fUd = frager.getUniqueId();
			String fuid = fUd.toString();
			int lvlFrager = players.get(fuid).getStaty().getLevel();
			double fKasa = players.get(fuid).getStaty().getKasa();
			double fZarobionaKasa = players.get(fuid).getStaty().getZarobionaKasa();
			ItemStack[] invFrager = frager.getInventory().getContents().clone();
			float exp = players.get(fuid).getStaty().getExp();
			invBefore.put(fname, invFrager);
			e.getDrops().clear();
			e.setDroppedExp(0);
			float dropExp = 0;
			if (frager.hasPermission("cc.vip")){
				dropExp = exp - (exp / 10);
				expAfter.put(fname, dropExp);
			}else{
				if (frager.getExp() == 0){
					dropExp = 0;
				}else{
					dropExp = exp - (exp / 4);
				}
				expAfter.put(fname, dropExp);
			}
			players.get(fuid).getStaty().setExp(dropExp);
			frager.setExp(dropExp);
			double pocieszenie = 0;
			if (lvlFrager > 0){
				pocieszenie = lvlFrager * 5;
			}else{
				pocieszenie = 5;
			}
			players.get(fuid).getStaty().setSmierci(players.get(fuid).getStaty().getSmierci()+1);
			players.get(fuid).getStaty().setKasa(fKasa + pocieszenie);
			players.get(fuid).getStaty().setOtrzymanaKasa(fZarobionaKasa+pocieszenie);
			frager.sendMessage(ChatColor.GRAY+"Zostales zabity przez "+ChatColor.GOLD+kname+
					" "+ChatColor.GRAY+"["+ChatColor.GOLD+lvlKiller+" lvl"+ChatColor.GRAY+"] "+
					ChatColor.GREEN+"+"+pocieszenie+" cc"+ChatColor.RED+" -"+dropExp);
				
			
			double kasa = 0.0;
			float giveExp = 0;
			if (kFrakcja.equals("Instor")){
				kasa = 150;
				if (killer.getLevel() > 0){
					int minus = -killer.getLevel();
					float second = minus * 5;
					float third = second + 250;
					float fourth = third / 1000;
					giveExp = fourth;
				}else{
					giveExp = (float) 0.25;
				}
			}
			if (kFrakcja.equals("Forter")){
				if ((lvlFrager - lvlKiller) <= 0){
					kasa = 100;
				}else{
					kasa = (lvlFrager - lvlKiller) * 100;
				}
					int minus = -killer.getLevel();
					float second = minus * 5;
					float third = second + 250;
					float fourth = third / 1000;
					giveExp = fourth;
			}
			if (kFrakcja.equals("Proter")){
				if ((lvlFrager - lvlKiller) <= 0){
					kasa = 80;
				}else{
					kasa = (lvlFrager - lvlKiller) * 80;
				}
					int minus = -killer.getLevel();
					float second = minus * 5;
					float third = second + 250;
					float fourth = third / 1000;
					giveExp = fourth;
			}
			if (kFrakcja.equals("Pread")){
				kasa = 120;
				if (lvlKiller > 0){
						int minus = -killer.getLevel();
						float second = minus * 5;
						float third = second + 250;
						float fourth = third / 1000;
						giveExp = fourth;
				}else{
					giveExp = (float) 0.245;
				}
			}
			
			pl.gastherr.cosmic.API.addExp(killer, giveExp);
			pl.gastherr.cosmic.API.addKasa(killer, kasa);
			killer.sendMessage(ChatColor.GRAY+"Zabiles "+ChatColor.GOLD+fname+
					" "+ChatColor.GRAY+"["+ChatColor.GOLD+lvlFrager+" lvl"+ChatColor.GRAY+"] "+
					ChatColor.GREEN+"+"+kasa+" cc"+ChatColor.DARK_GREEN+" +"+giveExp);
			
		}else{
			if (e.getEntity() instanceof Player){
				Player p = (Player) e.getEntity();
				String puid = p.getUniqueId().toString();
				ItemStack[] invFrager = p.getInventory().getContents().clone();
				float exp = players.get(puid).getStaty().getExp();
				invBefore.put(p.getName(), invFrager);
				e.getDrops().clear();
				e.setDroppedExp(0);
				float dropExp = 0;
				if (p.getExp() == 0){
					dropExp = 0;
				}else{
					dropExp = exp - (exp / 4);
				}
				expAfter.put(p.getName(), dropExp);
				players.get(puid).getStaty().setExp(dropExp);
				p.setExp(dropExp);
				players.get(puid).getStaty().setSmierci(players.get(puid).getStaty().getSmierci()+1);
				p.sendMessage(ChatColor.GRAY+"Zostales zabity przez "+ChatColor.GOLD+"grawitacje"+
						" "+ChatColor.GRAY+"["+ChatColor.GOLD+"X"+" lvl"+ChatColor.GRAY+"] "+
						ChatColor.GREEN+"+"+"0.0"+" cc"+ChatColor.RED+" -"+dropExp);
			}
		}
		
	}
	
	public static void regiveMoney(Player p){
		
		ItemStack heal1 = Signs.getByName("Heal:1");
		ItemStack heal2 = Signs.getByName("Heal:2");
		ItemStack heal3 = Signs.getByName("Heal:3");
		
		ItemStack speed1 = Signs.getByName("Speed:1");
		ItemStack speed2 = Signs.getByName("Speed:2");
		ItemStack speed3 = Signs.getByName("Speed:3");
		
		ItemStack jump1 = Signs.getByName("Jump:1");
		ItemStack jump2 = Signs.getByName("Jump:2");
		ItemStack jump3 = Signs.getByName("Jump:3");
		
		ItemStack power1 = Signs.getByName("Power:1");
		ItemStack power2 = Signs.getByName("Power:2");
		ItemStack power3 = Signs.getByName("Power:3");
		
		ItemStack sp1 = Signs.getByName("StartPacket:1");
		ItemStack nic = new ItemStack(Material.AIR);
		
		PlayerInventory inv = p.getInventory();
		inv.setHelmet(nic);
		inv.setChestplate(nic);
		inv.setLeggings(nic);
		inv.setBoots(nic);
		
		String puid = p.getUniqueId().toString();
		
		ItemStack sword = players.get(puid).getWalka().getSword();
		p.getInventory().remove(sword);
		
		double zwrot = 0.0;
		ArrayList<ItemStack> itemy = players.get(puid).getWalka().getMechList();
		for (int i = 0; i < itemy.size(); i++){
			ItemStack item = itemy.get(i);
			if (item.equals(heal1)){
				zwrot = zwrot + 20.0;
				p.getInventory().removeItem(heal1);
			}
			if (item.equals(heal2)){
				zwrot = zwrot + 45.0;
				p.getInventory().removeItem(heal2);
			}
			if (item.equals(heal3)){
				zwrot = zwrot + 110.0;
				p.getInventory().removeItem(heal3);
			}
			if (item.equals(speed1)){
				zwrot = zwrot + 20.0;
				p.getInventory().removeItem(speed1);
			}
			if (item.equals(speed2)){
				zwrot = zwrot + 50.0;
				p.getInventory().removeItem(speed2);
			}
			if (item.equals(speed3)){
				zwrot = zwrot + 80.0;
				p.getInventory().removeItem(speed3);
			}
			if (item.equals(jump1)){
				zwrot = zwrot + 20.0;
				p.getInventory().removeItem(jump1);
			}
			if (item.equals(jump2)){
				zwrot = zwrot + 50.0;
				p.getInventory().removeItem(jump2);
			}
			if (item.equals(jump3)){
				zwrot = zwrot + 135.0;
				p.getInventory().removeItem(jump3);
			}
			if (item.equals(power1)){
				zwrot = zwrot + 45.0;
				p.getInventory().removeItem(power1);
			}
			if (item.equals(power2)){
				zwrot = zwrot + 90.0;
				p.getInventory().removeItem(power2);
			}
			if (item.equals(power3)){
				zwrot = zwrot + 110.0;
				p.getInventory().removeItem(power3);
			}
			if (item.equals(sp1)){
				zwrot = 0.0;
				if (p.getInventory().contains(speed1)){
					p.getInventory().removeItem(speed1);
				}
				if (p.getInventory().contains(heal1)){
					p.getInventory().removeItem(heal1);
				}
			}
		}
		double kasa = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getKasa();
		pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setKasa(kasa+zwrot);
		p.sendMessage(ChatColor.GRAY+"Za kupione i nieuzyte mechanizmy otrzymujesz "+ChatColor.GREEN+zwrot+" cc");
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		
		Player p = e.getPlayer();
		String puid = p.getUniqueId().toString();
		p.getInventory().setContents(invBefore.get(p.getName()));
		invBefore.remove(p.getName());
		expAfter.remove(p.getName());
		double blockX = plugin.getPluginConfig().getDouble("Lokacje.RespawnPoint.BlockX");
		double blockY = plugin.getPluginConfig().getDouble("Lokacje.RespawnPoint.BlockY");
		double blockZ = plugin.getPluginConfig().getDouble("Lokacje.RespawnPoint.BlockZ");
		float pitch = (float) plugin.getPluginConfig().getDouble("Lokacje.RespawnPoint.Pitch");
		float yaw = (float) plugin.getPluginConfig().getDouble("Lokacje.RespawnPoint.Yaw");
		World wd = Bukkit.getWorld("SpawnMap");
		Location loc = new Location(wd, blockX, blockY, blockZ, pitch, yaw);
		e.setRespawnLocation(loc);
		regiveMoney(p);
		ItemStack sword = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().getSword();
		p.getInventory().remove(sword);
		pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().setMechList(null);
		pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().setIsFighting(false);
	}
	
}
