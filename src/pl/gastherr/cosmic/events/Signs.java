package pl.gastherr.cosmic.events;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import pl.gastherr.cosmic.Main;
import pl.gastherr.cosmic.ServerStats;
import pl.gastherr.cosmic.util.ItemType;

public class Signs implements Listener{
	   
	Main plugin;
	pl.gastherr.cosmic.events.PlayerJoin PlayerJoin;
	ServerStats ServerStats;
	
	   public Signs (Main plugin){
		   this.plugin = plugin;
		   plugin.getServer().getPluginManager().registerEvents(this, plugin);
	   }
	
	   public String removeColor(String msg){
		   return ChatColor.stripColor(msg);
	   }
	   
	   public String getColor(String msg){
		   return ChatColor.valueOf(msg).name();
	   }
	   
	   public String getByColor(String msg){
		   return ChatColor.getLastColors(msg);
	   }
	   
	   static HashMap<String, ItemStack> itemy = new HashMap<String, ItemStack>();
			
		   public void registerItems(){
				
				ItemStack item3 = new ItemStack(Material.PAPER);
				ItemMeta mitem3 = item3.getItemMeta();
				mitem3.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 1");
				ArrayList<String> lore3 = new ArrayList<String>();
				lore3.add(ChatColor.GRAY+"Leczy przez 5 sekund");
				mitem3.setLore(lore3);
				item3.setItemMeta(mitem3);
				itemy.put("Heal:1", item3);
				
				ItemStack item31 = new ItemStack(Material.PAPER);
				ItemMeta mitem31 = item31.getItemMeta();
				mitem31.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 1"+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> lore31 = new ArrayList<String>();
				lore31.add(ChatColor.GRAY+"Leczy przez pewien czas");
				lore31.add(ChatColor.GRAY+"Dostepne od poziomu "+ChatColor.RED+"5");
				mitem31.setLore(lore31);
				item31.setItemMeta(mitem31);
				itemy.put("Heal:1B", item31);
				
				ItemStack item32 = item3;
				item32.setType(Material.INK_SACK);
				item32.setDurability((short) 10);
				itemy.put("Heal:1S", item32);
				
				ItemStack item33 = new ItemStack(Material.PAPER);
				ItemMeta mitem33 = item33.getItemMeta();
				mitem33.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 1");
				ArrayList<String> lore33 = new ArrayList<String>();
				lore33.add(ChatColor.GRAY+"Leczy przez 5 sekund");
				lore33.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"36.0 cc");
				mitem33.setLore(lore33);
				item33.setItemMeta(mitem33);
				itemy.put("Heal:1I", item33);
				
				ItemStack item34 = new ItemStack(Material.PAPER);
				ItemMeta mitem34 = item34.getItemMeta();
				mitem34.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 1");
				ArrayList<String> lore34 = new ArrayList<String>();
				lore34.add(ChatColor.GRAY+"Leczy przez 5 sekund");
				lore34.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"40.0 cc");
				mitem34.setLore(lore34);
				item34.setItemMeta(mitem34);
				itemy.put("Heal:1N", item34);
				
				
				ItemStack item4 = new ItemStack(Material.PAPER);
				ItemMeta mitem4 = item4.getItemMeta();
				mitem4.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 2");
				ArrayList<String> lore4 = new ArrayList<String>();
				lore4.add(ChatColor.GRAY+"Leczy przez 10 sekund");
				mitem4.setLore(lore4);
				item4.setItemMeta(mitem4);
				itemy.put("Heal:2", item4);
				
				ItemStack item41 = new ItemStack(Material.PAPER);
				ItemMeta mitem41 = item41.getItemMeta();
				mitem41.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 2"+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> lore41 = new ArrayList<String>();
				lore41.add(ChatColor.GRAY+"Leczy przez pewien czas");
				lore41.add(ChatColor.GRAY+"Dostepne od poziomu "+ChatColor.RED+"10");
				mitem41.setLore(lore41);
				item41.setItemMeta(mitem41);
				itemy.put("Heal:2B", item41);
				
				ItemStack item42 = item4;
				item42.setType(Material.INK_SACK);
				item42.setDurability((short) 10);
				itemy.put("Heal:2S", item42);
				
				ItemStack item43 = new ItemStack(Material.PAPER);
				ItemMeta mitem43 = item43.getItemMeta();
				mitem43.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 2");
				ArrayList<String> lore43 = new ArrayList<String>();
				lore43.add(ChatColor.GRAY+"Leczy przez 10 sekund");
				lore43.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"90.0 cc");
				mitem43.setLore(lore43);
				item43.setItemMeta(mitem43);
				itemy.put("Heal:2I", item43);
				
				ItemStack item44 = new ItemStack(Material.PAPER);
				ItemMeta mitem44 = item44.getItemMeta();
				mitem44.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 2");
				ArrayList<String> lore44 = new ArrayList<String>();
				lore44.add(ChatColor.GRAY+"Leczy przez 10 sekund");
				lore44.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"100.0 cc");
				mitem44.setLore(lore44);
				item44.setItemMeta(mitem44);
				itemy.put("Heal:2N", item44);
				
				
				ItemStack item5 = new ItemStack(Material.PAPER);
				ItemMeta mitem5 = item5.getItemMeta();
				mitem5.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 3");
				ArrayList<String> lore5 = new ArrayList<String>();
				lore3.add(ChatColor.GRAY+"Leczy przez 15 sekund");
				mitem5.setLore(lore5);
				item5.setItemMeta(mitem5);
				itemy.put("Heal:3", item5);
				
				ItemStack item51 = new ItemStack(Material.PAPER);
				ItemMeta mitem51 = item51.getItemMeta();
				mitem51.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 3"+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> lore51 = new ArrayList<String>();
				lore51.add(ChatColor.GRAY+"Leczy przez pewien czas");
				lore51.add(ChatColor.GRAY+"Dostepne od poziomu "+ChatColor.RED+"15");
				mitem51.setLore(lore51);
				item51.setItemMeta(mitem51);
				itemy.put("Heal:3B", item51);
				
				ItemStack item52 = item4;
				item52.setType(Material.INK_SACK);
				item52.setDurability((short) 10);
				itemy.put("Heal:3S", item52);
				
				ItemStack item53 = new ItemStack(Material.PAPER);
				ItemMeta mitem53 = item53.getItemMeta();
				mitem53.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 3");
				ArrayList<String> lore53 = new ArrayList<String>();
				lore53.add(ChatColor.GRAY+"Leczy przez 15 sekund");
				lore53.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"225.0 cc");
				mitem53.setLore(lore53);
				item53.setItemMeta(mitem53);
				itemy.put("Heal:3I", item53);
				
				ItemStack item54 = new ItemStack(Material.PAPER);
				ItemMeta mitem54 = item54.getItemMeta();
				mitem54.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 3");
				ArrayList<String> lore54 = new ArrayList<String>();
				lore54.add(ChatColor.GRAY+"Leczy przez 15 sekund");
				lore54.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"250.0 cc");
				mitem54.setLore(lore54);
				item54.setItemMeta(mitem54);
				itemy.put("Heal:3N", item54);
				
				
				ItemStack speed1 = new ItemStack(Material.PAPER);
				ItemMeta mspeed1 = speed1.getItemMeta();
				mspeed1.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Speed 1");
				ArrayList<String> loreSpeed1 = new ArrayList<String>();
				loreSpeed1.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na 10 sekund");
				mspeed1.setLore(loreSpeed1);
				speed1.setItemMeta(mspeed1);
				itemy.put("Speed:1", speed1);
				
				ItemStack speed11 = speed1;
				ItemMeta mspeed11 = speed11.getItemMeta();
				mspeed11.setDisplayName(mspeed11.getDisplayName()+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> loreSpeed11 = new ArrayList<String>();
				loreSpeed11.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na pewien czas");
				loreSpeed11.add(ChatColor.GRAY+"Dostepny od poziomu "+ChatColor.RED+"1");
				mspeed11.setLore(loreSpeed11);
				speed11.setItemMeta(mspeed11);
				itemy.put("Speed:1B", speed11);
				
				ItemStack speed12 = speed1;
				speed12.setType(Material.INK_SACK);
				speed12.setDurability((short) 10);
				itemy.put("Speed:1S", speed12);
				
				ItemStack speed13 = speed1;
				ItemMeta mspeed13 = speed13.getItemMeta();
				ArrayList<String> loreSpeed13 = new ArrayList<String>();
				loreSpeed13.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na 10 sekund");
				loreSpeed13.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"45.0 cc");
				mspeed13.setLore(loreSpeed13);
				speed13.setItemMeta(mspeed13);
				itemy.put("Speed:1I", speed13);
				
				ItemStack speed14 = speed1;
				ItemMeta mspeed14 = speed14.getItemMeta();
				ArrayList<String> loreSpeed14 = new ArrayList<String>();
				loreSpeed14.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na 10 sekund");
				loreSpeed14.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"50.0 cc");
				mspeed14.setLore(loreSpeed14);
				speed14.setItemMeta(mspeed14);
				itemy.put("Speed:1N", speed14);
				
				
				ItemStack speed2 = new ItemStack(Material.PAPER);
				ItemMeta mspeed2 = speed2.getItemMeta();
				mspeed2.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Speed 2");
				ArrayList<String> loreSpeed2 = new ArrayList<String>();
				loreSpeed2.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na 15 sekund");
				mspeed2.setLore(loreSpeed2);
				speed2.setItemMeta(mspeed2);
				itemy.put("Speed:2", speed2);
				
				ItemStack speed21 = speed2;
				ItemMeta mspeed21 = speed21.getItemMeta();
				mspeed21.setDisplayName(mspeed21.getDisplayName()+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> loreSpeed21 = new ArrayList<String>();
				loreSpeed21.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na pewien czas");
				loreSpeed21.add(ChatColor.GRAY+"Dostepny od poziomu "+ChatColor.RED+"15");
				mspeed2.setLore(loreSpeed2);
				speed2.setItemMeta(mspeed2);
				itemy.put("Speed:2B", speed2);
				
				ItemStack speed22 = speed2;
				speed22.setType(Material.INK_SACK);
				speed22.setDurability((short) 10);
				itemy.put("Speed:2S", speed22);
				
				ItemStack speed23 = speed2;
				ItemMeta mspeed23 = speed13.getItemMeta();
				ArrayList<String> loreSpeed23 = new ArrayList<String>();
				loreSpeed23.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na 15 sekund");
				loreSpeed13.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"108.0 cc");
				mspeed23.setLore(loreSpeed23);
				speed23.setItemMeta(mspeed23);
				itemy.put("Speed:2I", speed23);
				
				ItemStack speed24 = speed2;
				ItemMeta mspeed24 = speed24.getItemMeta();
				ArrayList<String> loreSpeed24 = new ArrayList<String>();
				loreSpeed24.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na 15 sekund");
				loreSpeed24.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"120.0 cc");
				mspeed24.setLore(loreSpeed24);
				speed24.setItemMeta(mspeed24);
				itemy.put("Speed:2N", speed24);
				
				
				ItemStack speed3 = new ItemStack(Material.PAPER);
				ItemMeta mspeed3 = speed3.getItemMeta();
				mspeed3.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Speed 3");
				ArrayList<String> loreSpeed3 = new ArrayList<String>();
				loreSpeed3.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na 20 sekund");
				mspeed3.setLore(loreSpeed3);
				speed3.setItemMeta(mspeed3);
				itemy.put("Speed:3", speed3);
				
				ItemStack speed31 = speed3;
				ItemMeta mspeed31 = speed31.getItemMeta();
				mspeed31.setDisplayName(mspeed31.getDisplayName()+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> loreSpeed31 = new ArrayList<String>();
				loreSpeed31.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na pewien czas");
				loreSpeed31.add(ChatColor.GRAY+"Dostepny od poziomu "+ChatColor.RED+"20");
				mspeed31.setLore(loreSpeed31);
				speed31.setItemMeta(mspeed31);
				itemy.put("Speed:3B", speed31);
				
				ItemStack speed32 = speed3;
				speed32.setType(Material.INK_SACK);
				speed32.setDurability((short) 10);
				itemy.put("Speed:3S", speed32);
				
				ItemStack speed33 = speed3;
				ItemMeta mspeed33 = speed33.getItemMeta();
				ArrayList<String> loreSpeed33 = new ArrayList<String>();
				loreSpeed33.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na 20 sekund");
				loreSpeed33.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"162.0 cc");
				mspeed33.setLore(loreSpeed33);
				speed33.setItemMeta(mspeed33);
				itemy.put("Speed:3I", speed33);
				
				ItemStack speed34 = speed3;
				ItemMeta mspeed34 = speed34.getItemMeta();
				ArrayList<String> loreSpeed34 = new ArrayList<String>();
				loreSpeed34.add(ChatColor.GRAY+"Zwieksza predkosc chodzenia na 20 sekund");
				loreSpeed34.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"180.0 cc");
				mspeed34.setLore(loreSpeed34);
				speed34.setItemMeta(mspeed34);
				itemy.put("Speed:3N", speed34);
				
				
				ItemStack jump1 = new ItemStack(Material.PAPER);
				ItemMeta mjump1 = jump1.getItemMeta();
				mjump1.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Jump 1");
				ArrayList<String> loreJump1 = new ArrayList<String>();
				loreJump1.add(ChatColor.GRAY+"Zwieksza skok na 10 sekund");
				mjump1.setLore(loreJump1);
				jump1.setItemMeta(mjump1);
				itemy.put("Jump:1", jump1);
				
				ItemStack jump11 = jump1;
				ItemMeta mjump11 = jump11.getItemMeta();
				mjump11.setDisplayName(mjump11.getDisplayName()+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> loreJump11 = new ArrayList<String>();
				loreJump11.add(ChatColor.GRAY+"Zwieksza skok na pewien czas");
				loreJump11.add(ChatColor.GRAY+"Dostepny od poziomu "+ChatColor.RED+"3");
				mjump11.setLore(loreJump11);
				jump11.setItemMeta(mjump11);
				itemy.put("Jump:1B", jump11);
				
				ItemStack jump12 = jump1;
				jump12.setType(Material.INK_SACK);
				jump12.setDurability((short) 10);
				itemy.put("Jump:1S", jump12);
				
				ItemStack jump13 = jump1;
				ItemMeta mjump13 = jump13.getItemMeta();
				ArrayList<String> loreJump13 = new ArrayList<String>();
				loreJump13.add(ChatColor.GRAY+"Zwieksza skok na 10 sekund");
				loreJump13.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"45.0 cc");
				mjump13.setLore(loreJump13);
				jump13.setItemMeta(mjump13);
				itemy.put("Jump:1I", jump13);
				
				ItemStack jump14 = jump1;
				ItemMeta mjump14 = jump14.getItemMeta();
				ArrayList<String> loreJump14 = new ArrayList<String>();
				loreJump14.add(ChatColor.GRAY+"Zwieksza skok na 10 sekund");
				loreJump14.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"50.0 cc");
				mjump14.setLore(loreJump14);
				jump14.setItemMeta(mjump14);
				itemy.put("Jump:1N", jump14);
				
				
				ItemStack jump2 = new ItemStack(Material.PAPER);
				ItemMeta mjump2 = jump2.getItemMeta();
				mjump2.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Jump 2");
				ArrayList<String> loreJump2 = new ArrayList<String>();
				loreJump2.add(ChatColor.GRAY+"Zwieksza skok na 15 sekund");
				mjump2.setLore(loreJump2);
				jump2.setItemMeta(mjump2);
				itemy.put("Jump:2", jump2);
				
				ItemStack jump21 = jump2;
				ItemMeta mjump21 = jump21.getItemMeta();
				mjump21.setDisplayName(mjump21.getDisplayName()+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> loreJump21 = new ArrayList<String>();
				loreJump21.add(ChatColor.GRAY+"Zwieksza skok na pewien czas");
				loreJump21.add(ChatColor.GRAY+"Dostepny od poziomu "+ChatColor.RED+"8");
				mjump21.setLore(loreJump21);
				jump21.setItemMeta(mjump21);
				itemy.put("Jump:2B", jump21);
				
				ItemStack jump22 = jump21;
				jump12.setType(Material.INK_SACK);
				jump12.setDurability((short) 10);
				itemy.put("Jump:2S", jump22);
				
				ItemStack jump23 = jump2;
				ItemMeta mjump23 = jump23.getItemMeta();
				ArrayList<String> loreJump23 = new ArrayList<String>();
				loreJump23.add(ChatColor.GRAY+"Zwieksza skok na 15 sekund");
				loreJump23.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"108.0 cc");
				mjump23.setLore(loreJump23);
				jump23.setItemMeta(mjump23);
				itemy.put("Jump:2I", jump23);
				
				ItemStack jump24 = jump2;
				ItemMeta mjump24 = jump24.getItemMeta();
				ArrayList<String> loreJump24 = new ArrayList<String>();
				loreJump24.add(ChatColor.GRAY+"Zwieksza skok na 15 sekund");
				loreJump24.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"120.0 cc");
				mjump24.setLore(loreJump24);
				jump24.setItemMeta(mjump24);
				itemy.put("Jump:2N", jump24);
				
				
				ItemStack jump3 = new ItemStack(Material.PAPER);
				ItemMeta mjump3 = jump3.getItemMeta();
				mjump3.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Jump 3");
				ArrayList<String> loreJump3 = new ArrayList<String>();
				loreJump3.add(ChatColor.GRAY+"Zwieksza skok na 20 sekund");
				mjump3.setLore(loreJump3);
				jump3.setItemMeta(mjump3);
				itemy.put("Jump:3", jump3);
				
				ItemStack jump31 = jump3;
				ItemMeta mjump31 = jump31.getItemMeta();
				mjump31.setDisplayName(mjump31.getDisplayName()+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> loreJump31 = new ArrayList<String>();
				loreJump31.add(ChatColor.GRAY+"Zwieksza skok na pewien czas");
				loreJump31.add(ChatColor.GRAY+"Dostepny od poziomu "+ChatColor.RED+"13");
				mjump31.setLore(loreJump31);
				jump31.setItemMeta(mjump31);
				itemy.put("Jump:3B", jump31);
				
				ItemStack jump32 = jump31;
				jump32.setType(Material.INK_SACK);
				jump32.setDurability((short) 10);
				itemy.put("Jump:3S", jump32);
				
				ItemStack jump33 = jump3;
				ItemMeta mjump33 = jump33.getItemMeta();
				ArrayList<String> loreJump33 = new ArrayList<String>();
				loreJump33.add(ChatColor.GRAY+"Zwieksza skok na 20 sekund");
				loreJump33.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"270.0 cc");
				mjump33.setLore(loreJump33);
				jump33.setItemMeta(mjump33);
				itemy.put("Jump:3I", jump33);
				
				ItemStack jump34 = jump3;
				ItemMeta mjump34 = jump34.getItemMeta();
				ArrayList<String> loreJump34 = new ArrayList<String>();
				loreJump34.add(ChatColor.GRAY+"Zwieksza skok na 20 sekund");
				loreJump34.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"300.0 cc");
				mjump34.setLore(loreJump34);
				jump34.setItemMeta(mjump34);
				itemy.put("Jump:3N", jump34);
				
				
				ItemStack power1 = new ItemStack(Material.PAPER);
				ItemMeta mpower1 = power1.getItemMeta();
				mpower1.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Power 1");
				ArrayList<String> lorePower1 = new ArrayList<String>();
				lorePower1.add(ChatColor.GRAY+"Zwieksza sile na 5 sekund");
				mpower1.setLore(lorePower1);
				power1.setItemMeta(mpower1);
				itemy.put("Power:1", power1);
				
				ItemStack power11 = power1;
				ItemMeta mpower11 = power11.getItemMeta();
				mpower11.setDisplayName(mpower11.getDisplayName()+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> lorePower11 = new ArrayList<String>();
				lorePower11.add(ChatColor.GRAY+"Zwieksza sile na pewien czas");
				lorePower11.add(ChatColor.GRAY+"Dostepny od poziomu "+ChatColor.RED+"9");
				mpower11.setLore(lorePower11);
				power11.setItemMeta(mpower11);
				itemy.put("Power:1B", power11);
				
				ItemStack power12 = power1;
				power12.setType(Material.INK_SACK);
				power12.setDurability((short) 10);
				itemy.put("Power:1S", power12);
				
				ItemStack power13 = power1;
				ItemMeta mpower13 = power13.getItemMeta();
				ArrayList<String> lorePower13 = new ArrayList<String>();
				lorePower13.add(ChatColor.GRAY+"Zwieksza sile na 5 sekund");
				lorePower13.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"90.0 cc");
				mpower13.setLore(lorePower13);
				power13.setItemMeta(mpower13);
				itemy.put("Power:1I", power13);
				
				ItemStack power14 = power1;
				ItemMeta mpower14 = power14.getItemMeta();
				ArrayList<String> lorePower14 = new ArrayList<String>();
				lorePower14.add(ChatColor.GRAY+"Zwieksza skok na 5 sekund");
				lorePower14.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"100.0 cc");
				mpower14.setLore(lorePower14);
				power14.setItemMeta(mpower14);
				itemy.put("Power:1N", power14);
				
				
				ItemStack power2 = new ItemStack(Material.PAPER);
				ItemMeta mpower2 = power2.getItemMeta();
				mpower2.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Power 2");
				ArrayList<String> lorePower2 = new ArrayList<String>();
				lorePower2.add(ChatColor.GRAY+"Zwieksza sile na 10 sekund");
				mpower2.setLore(lorePower2);
				power2.setItemMeta(mpower2);
				itemy.put("Power:2", power2);
				
				ItemStack power21 = power2;
				ItemMeta mpower21 = power21.getItemMeta();
				mpower21.setDisplayName(mpower21.getDisplayName()+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> lorePower21 = new ArrayList<String>();
				lorePower21.add(ChatColor.GRAY+"Zwieksza sile na pewien czas");
				lorePower21.add(ChatColor.GRAY+"Dostepny od poziomu "+ChatColor.RED+"16");
				mpower21.setLore(lorePower21);
				power21.setItemMeta(mpower21);
				itemy.put("Power:2B", power21);
				
				ItemStack power22 = power2;
				power22.setType(Material.INK_SACK);
				power22.setDurability((short) 10);
				itemy.put("Power:2S", power22);
				
				ItemStack power23 = power2;
				ItemMeta mpower23 = power23.getItemMeta();
				ArrayList<String> lorePower23 = new ArrayList<String>();
				lorePower23.add(ChatColor.GRAY+"Zwieksza sile na 10 sekund");
				lorePower23.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"180.0 cc");
				mpower23.setLore(lorePower23);
				power23.setItemMeta(mpower23);
				itemy.put("Power:2I", power23);
				
				ItemStack power24 = power2;
				ItemMeta mpower24 = power24.getItemMeta();
				ArrayList<String> lorePower24 = new ArrayList<String>();
				lorePower24.add(ChatColor.GRAY+"Zwieksza skok na 10 sekund");
				lorePower24.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"200.0 cc");
				mpower24.setLore(lorePower24);
				power24.setItemMeta(mpower24);
				itemy.put("Power:2N", power24);
				
				
				ItemStack power3 = new ItemStack(Material.PAPER);
				ItemMeta mpower3 = power3.getItemMeta();
				mpower3.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Power 3");
				ArrayList<String> lorePower3 = new ArrayList<String>();
				lorePower3.add(ChatColor.GRAY+"Zwieksza sile na 15 sekund");
				mpower3.setLore(lorePower3);
				power3.setItemMeta(mpower3);
				itemy.put("Power:3", power3);
				
				ItemStack power31 = power3;
				ItemMeta mpower31 = power31.getItemMeta();
				mpower31.setDisplayName(mpower31.getDisplayName()+ChatColor.RED+" (Zablokowane)");
				ArrayList<String> lorePower31 = new ArrayList<String>();
				lorePower31.add(ChatColor.GRAY+"Zwieksza sile na pewien czas");
				lorePower31.add(ChatColor.GRAY+"Dostepny od poziomu "+ChatColor.RED+"24");
				mpower31.setLore(lorePower31);
				power31.setItemMeta(mpower31);
				itemy.put("Power:3B", power31);
				
				ItemStack power32 = power3;
				power32.setType(Material.INK_SACK);
				power32.setDurability((short) 10);
				itemy.put("Power:3S", power32);
				
				ItemStack power33 = power3;
				ItemMeta mpower33 = power23.getItemMeta();
				ArrayList<String> lorePower33 = new ArrayList<String>();
				lorePower33.add(ChatColor.GRAY+"Zwieksza sile na 10 sekund");
				lorePower33.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+"225.0 cc");
				mpower33.setLore(lorePower33);
				power33.setItemMeta(mpower33);
				itemy.put("Power:3I", power33);
				
				ItemStack power34 = power3;
				ItemMeta mpower34 = power34.getItemMeta();
				ArrayList<String> lorePower34 = new ArrayList<String>();
				lorePower34.add(ChatColor.GRAY+"Zwieksza skok na 10 sekund");
				lorePower34.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"250.0 cc");
				mpower34.setLore(lorePower34);
				power34.setItemMeta(mpower34);
				itemy.put("Power:3N", power34);
				
				
				ItemStack movePack1 = new ItemStack(Material.PAPER);
				ItemMeta mMovePack1 = movePack1.getItemMeta();
				mMovePack1.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Movepack 1");
				ArrayList<String> loreMovePack1 = new ArrayList<String>();
				loreMovePack1.add(ChatColor.GRAY+"- Zwieksza predkosc na 10 sekund");
				loreMovePack1.add(ChatColor.GRAY+"- Zwieksza skok na 10 sekund");
				mMovePack1.setLore(loreMovePack1);
				movePack1.setItemMeta(mMovePack1);
				itemy.put("Movepack:1", movePack1);
				
				ItemStack movePack2 = new ItemStack(Material.PAPER);
				ItemMeta mMovePack2 = movePack2.getItemMeta();
				mMovePack2.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Movepack 2");
				ArrayList<String> loreMovePack2 = new ArrayList<String>();
				loreMovePack2.add(ChatColor.GRAY+"- Zwieksza predkosc na 20 sekund");
				loreMovePack2.add(ChatColor.GRAY+"- Zwieksza skok na 15 sekund");
				mMovePack2.setLore(loreMovePack2);
				movePack2.setItemMeta(mMovePack2);
				itemy.put("Movepack:2", movePack2);
				
				ItemStack movePack3 = new ItemStack(Material.PAPER);
				ItemMeta mMovePack3 = movePack3.getItemMeta();
				mMovePack3.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Movepack 3");
				ArrayList<String> loreMovePack3 = new ArrayList<String>();
				loreMovePack3.add(ChatColor.GRAY+"- Zwieksza predkosc na 30 sekund");
				loreMovePack3.add(ChatColor.GRAY+"- Zwieksza skok na 20 sekund");
				mMovePack3.setLore(loreMovePack3);
				movePack3.setItemMeta(mMovePack3);
				itemy.put("Movepack:3", movePack3);
				
				ItemStack drain = new ItemStack(Material.PAPER);
				ItemMeta mdrain = drain.getItemMeta();
				mdrain.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Drain");
				ArrayList<String> loreDrain = new ArrayList<String>();
				loreDrain.add(ChatColor.GRAY+"Otrzymujesz polowe hp");
				loreDrain.add(ChatColor.GRAY+"zabranego przeciwnikowi przez uderzenie.");
				mdrain.setLore(loreDrain);
				drain.setItemMeta(mdrain);
				itemy.put("Drain", drain);
				
				ItemStack startPc1 = new ItemStack(Material.PAPER);
				ItemMeta mStartPc1 = startPc1.getItemMeta();
				mStartPc1.setDisplayName(ChatColor.GREEN+""+ChatColor.BOLD+"Pakiet podstawowy");
				ArrayList<String> loreStartPc1 = new ArrayList<String>();
				loreStartPc1.add(ChatColor.GRAY+"Zawiera 2 standardowe mechanizmy");
				loreStartPc1.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+"0.0 cc");
				mStartPc1.setLore(loreStartPc1);
				startPc1.setItemMeta(mStartPc1);
				itemy.put("StartPacket:1", startPc1);
				
				ItemStack startPc11 = startPc1;
				startPc11.setType(Material.INK_SACK);
				startPc11.setDurability((short) 10);
				itemy.put("StartPacket:1S", startPc1);

		   }
		   
		   public static ItemStack getByName(ItemType it, String name){
			   String pref = "";
			   if (it.equals(ItemType.NORMAL)){
				   pref = "N";
			   }
			   else if (it.equals(ItemType.SELECTED)){
				   pref = "S";
			   }
			   else if (it.equals(ItemType.NOLVL)){
				   pref = "B";
			   }
			   else if(it.equals(ItemType.INSTORED)){
				   pref = "I";
			   }
			   else if(it.equals(ItemType.NULL)){
				   pref = "";
			   }
			   ItemStack result = itemy.get(name+pref);
			return result;
			   
		   }
	   
	   public ItemStack giveItemByName(String name){
		   return itemy.get(name);
	   }  
	   
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		final Player p = e.getPlayer();
		
		final String puid = p.getUniqueId().toString();
		final ArrayList<String> activeMech = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().getActiveMech();
		final ItemType it = ItemType.NORMAL;
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if (e.getPlayer().getItemInHand().getAmount() >= 1 && e.getPlayer().getItemInHand().getType().equals(Material.PAPER)
					&& (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 1")
					|| p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 2")
					|| p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 3"))){
				if (activeMech.size() == 0){
			     		plugin.statystyki.setAktywowaneMechanizmy(plugin.statystyki.getAktywowaneMechanizmy()+1);
            			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setAktywowaneMechanizmy(pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getAktywowaneMechanizmy()+1);
						String prefixItem = "";
						String itemName = "";
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 1")){
							prefixItem = "Heal 1";
							itemName = "Heal:1";
							p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*5, 3));
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 2")){
							prefixItem = "Heal 2";
							itemName = "Heal:2";
							p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*10, 3));
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Heal 3")){
							prefixItem = "Heal 3";
							itemName = "Heal:3";
							p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*15, 3));
						}
						final String itemNamef = itemName;
						p.sendMessage(ChatColor.GOLD+"Mechanizm: "+ChatColor.WHITE+prefixItem+ChatColor.GOLD+" aktywowany!");
						p.getInventory().setItemInHand(new ItemStack(Material.AIR));
						Location head = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+1, p.getLocation().getZ());
						p.playEffect(head, Effect.MOBSPAWNER_FLAMES, 1);
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.FIZZ, 1, 1);
						ArrayList<ItemStack> mechy = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().getMechList();
						mechy.remove(getByName(it, itemName));
						pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().setMechList(mechy);
						activeMech.add(itemName);
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
							@Override
							public void run() {
								activeMech.remove(itemNamef);
								p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
								p.sendMessage(ChatColor.GRAY+"Teraz mozesz uzywac mechanizmow!");
							}
						}, 20*20);
				}else{
					p.sendMessage(ChatColor.RED+"Poczekaj 20 sekund od ostatniej aktywacji mechanizmu!");
					return;
				}
			}
			if (e.getPlayer().getItemInHand().getAmount() >= 1 && e.getPlayer().getItemInHand().getType().equals(Material.PAPER)
					&& (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Jump 1")
					|| p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Jump 2")
					|| p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Jump 3"))){
				if (activeMech.size() == 0){
			     		plugin.statystyki.setAktywowaneMechanizmy(plugin.statystyki.getAktywowaneMechanizmy()+1);
            			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setAktywowaneMechanizmy(pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getAktywowaneMechanizmy()+1);
						String prefixItem = "";
						String itemName = "";
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Jump 1")){
							prefixItem = "Jump 1";
							itemName = "Jump:1";
							p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*10, 1));
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Jump 2")){
							prefixItem = "Jump 2";
							itemName = "Jump:2";
							p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*15, 1));
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Jump 3")){
							prefixItem = "Jump 3";
							itemName = "Jump:3";
							p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*20, 1));
						}
						final String itemNamef = itemName;
						p.sendMessage(ChatColor.GOLD+"Mechanizm: "+ChatColor.WHITE+prefixItem+ChatColor.GOLD+" aktywowany!");
						p.getInventory().setItemInHand(new ItemStack(Material.AIR));
						Location head = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+1, p.getLocation().getZ());
						p.playEffect(head, Effect.MOBSPAWNER_FLAMES, 1);
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.FIZZ, 1, 1);
						ArrayList<ItemStack> mechy = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().getMechList();
						mechy.remove(getByName(it, itemName));
						pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().setMechList(mechy);
						activeMech.add(itemName);
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
							@Override
							public void run() {
								activeMech.remove(itemNamef);
								p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
								p.sendMessage(ChatColor.GRAY+"Teraz mozesz uzywac mechanizmow!");
							}
						}, 20*20);
				}else{
					p.sendMessage(ChatColor.RED+"Poczekaj 20 sekund od ostatniej aktywacji mechanizmu!");
					return;
				}
			}
			if (e.getPlayer().getItemInHand().getAmount() >= 1 && e.getPlayer().getItemInHand().getType().equals(Material.PAPER)
					&& (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Speed 1")
					|| p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Speed 2")
					|| p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Speed 3"))){
				if (activeMech.size() == 0){
			     		plugin.statystyki.setAktywowaneMechanizmy(plugin.statystyki.getAktywowaneMechanizmy()+1);
            			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setAktywowaneMechanizmy(pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getAktywowaneMechanizmy()+1);
						String prefixItem = "";
						String itemName = "";
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Speed 1")){
							prefixItem = "Speed 1";
							itemName = "Speed:1";
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*10, 1));
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Speed 2")){
							prefixItem = "Speed 2";
							itemName = "Speed:2";
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*20, 1));
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Speed 3")){
							prefixItem = "Speed 3";
							itemName = "Speed:3";
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*30, 1));
						}
						final String itemNamef = itemName;
						p.sendMessage(ChatColor.GOLD+"Mechanizm: "+ChatColor.WHITE+prefixItem+ChatColor.GOLD+" aktywowany!");
						p.getInventory().setItemInHand(new ItemStack(Material.AIR));
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.FIZZ, 1, 1);
						Location head = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+1, p.getLocation().getZ());
						p.playEffect(head, Effect.MOBSPAWNER_FLAMES, 1);
						ArrayList<ItemStack> mechy = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().getMechList();
						mechy.remove(getByName(it, itemName));
						pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().setMechList(mechy);
						activeMech.add(itemName);
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
							@Override
							public void run() {
								activeMech.remove(itemNamef);
								p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
								p.sendMessage(ChatColor.GRAY+"Teraz mozesz uzywac mechanizmow!");
							}
						}, 20*20);
				}else{
					p.sendMessage(ChatColor.RED+"Poczekaj 20 sekund od ostatniej aktywacji mechanizmu!");
					return;
				}
			}
			if (e.getPlayer().getItemInHand().getAmount() >= 1 && e.getPlayer().getItemInHand().getType().equals(Material.PAPER)
					&& (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Movepack 1")
					|| p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Movepack 2")
					|| p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Movepack 3"))){
				if (activeMech.size() == 0){
			     		plugin.statystyki.setAktywowaneMechanizmy(plugin.statystyki.getAktywowaneMechanizmy()+1);
            			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setAktywowaneMechanizmy(pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getAktywowaneMechanizmy()+1);
						String prefixItem = "";
						String itemName = "";
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Movepack 1")){
							prefixItem = "Movepack 1";
							itemName = "Movepack:1";
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*10, 1));
							p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*10, 1));
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Movepack 2")){
							prefixItem = "Movepack 2";
							itemName = "Movepack:2";
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*20, 1));
							p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*15, 1));
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Movepack 3")){
							prefixItem = "Movepack 3";
							itemName = "Movepack:3";
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*30, 1));
							p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*20, 1));
						}
						final String itemNamef = itemName;
						p.sendMessage(ChatColor.GOLD+"Mechanizm: "+ChatColor.WHITE+prefixItem+ChatColor.GOLD+" aktywowany!");
						p.getInventory().setItemInHand(new ItemStack(Material.AIR));
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.FIZZ, 1, 1);
						Location head = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+1, p.getLocation().getZ());
						p.playEffect(head, Effect.MOBSPAWNER_FLAMES, 1);
						activeMech.add(itemName);
						ArrayList<ItemStack> mechy = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().getMechList();
						mechy.remove(getByName(it, itemName));
						pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().setMechList(mechy);
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
							@Override
							public void run() {
								activeMech.remove(itemNamef);
								p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
								p.sendMessage(ChatColor.GRAY+"Teraz mozesz uzywac mechanizmow!");
							}
						}, 20*20);
				}else{
					p.sendMessage(ChatColor.RED+"Poczekaj 20 sekund od ostatniej aktywacji mechanizmu!");
					return;
				}
			}
			if (e.getPlayer().getItemInHand().getAmount() >= 1 && e.getPlayer().getItemInHand().getType().equals(Material.PAPER)
					&& (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Power 1")
					|| p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Power 2")
					|| p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Power 3"))){
				if (activeMech.size() == 0){
			     		plugin.statystyki.setAktywowaneMechanizmy(plugin.statystyki.getAktywowaneMechanizmy()+1);
            			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setAktywowaneMechanizmy(pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getAktywowaneMechanizmy()+1);
						String prefixItem = "";
						String itemName = "";
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Power 1")){
							prefixItem = "Power 1";
							itemName = "Power:1";
							p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*10, 1));
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Power 2")){
							prefixItem = "Power 2";
							itemName = "Power:2";
							p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*15, 1));
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Power 3")){
							prefixItem = "Power 3";
							itemName = "Power:3";
							p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*20, 1));
						}
						final String itemNamef = itemName;
						p.sendMessage(ChatColor.GOLD+"Mechanizm: "+ChatColor.WHITE+prefixItem+ChatColor.GOLD+" aktywowany!");
						p.getInventory().setItemInHand(new ItemStack(Material.AIR));
						p.updateInventory();
						p.playSound(p.getLocation(), Sound.FIZZ, 1, 1);
						Location head = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+1, p.getLocation().getZ());
						p.playEffect(head, Effect.MOBSPAWNER_FLAMES, 1);
						ArrayList<ItemStack> mechy = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().getMechList();
						mechy.remove(getByName(it, itemName));
						pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().setMechList(mechy);
						activeMech.add(itemName);
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
							@Override
							public void run() {
								activeMech.remove(itemNamef);
								p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
								p.sendMessage(ChatColor.GRAY+"Teraz mozesz uzywac mechanizmow!");
							}
						}, 20*20);
				}else{
					p.sendMessage(ChatColor.RED+"Poczekaj 20 sekund od ostatniej aktywacji mechanizmu!");
					return;
				}
			}
			
			if (e.getPlayer().getItemInHand().getAmount() >= 1 && e.getPlayer().getItemInHand().getType().equals(Material.PAPER)
					&& (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Fireball"))){
				if (activeMech.size() == 0){
			     		plugin.statystyki.setAktywowaneMechanizmy(plugin.statystyki.getAktywowaneMechanizmy()+1);
            			pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().setAktywowaneMechanizmy(pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getStaty().getAktywowaneMechanizmy()+1);
						activeMech.add("Fireball");
						p.playSound(p.getLocation(), Sound.FIZZ, 1, 1);
						p.sendMessage(ChatColor.GOLD+"Mechanizm: "+ChatColor.WHITE+"Fireball"+ChatColor.GOLD+" aktywowany!");
				}else{
					if (activeMech.contains("Fireball")){
						p.sendMessage(ChatColor.RED+"Mechanizm: "+ChatColor.WHITE+"Teleport"+ChatColor.RED+" dezaktywowany!");
			     		plugin.statystyki.setAktywowaneMechanizmy(plugin.statystyki.getAktywowaneMechanizmy()-1);
						activeMech.remove("Fireball");
						p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
					}
					if (!activeMech.contains("Fireball")){
						p.sendMessage(ChatColor.RED+"Poczekaj 20 sekund od ostatniej aktywacji mechanizmu!");
					}
				}
			}
		}
		
		if ((e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getAmount() >= 1 && e.getPlayer().getItemInHand().getType().equals(Material.PAPER)){
			if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+"Fireball")){
				if (!activeMech.contains("Fireball")){
					return;
				}
				p.getInventory().setItemInHand(new ItemStack(Material.AIR));
				p.updateInventory();
				plugin.getServer().dispatchCommand(p, "fireball");
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST2, 10, 1);
				Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
					@Override
					public void run() {
						activeMech.remove("Fireball");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
						p.sendMessage(ChatColor.GRAY+"Teraz mozesz uzywac mechanizmow!");
					}
				}, 20*20);
				return;
		}
		}
		
	}

}
