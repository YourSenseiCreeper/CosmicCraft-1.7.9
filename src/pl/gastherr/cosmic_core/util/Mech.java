package pl.gastherr.cosmic_core.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Mech {
	
	private String name;
	private String lore;
	private int level;
	private int minimalLevel;
	private int time;
	private int price;
	private ItemStack item;
	private int merchandice;
	private PotionEffect pe;
	
	public Mech(String name, String lore, int level, int minimalLevel,
			int time, int price, PotionEffectType pet) {
		this.name = name;
		this.lore = lore+" przez "+time+" sekund";
		this.level = level;
		this.minimalLevel = minimalLevel;
		this.time = time;
		this.price = price;
		this.pe = new PotionEffect(pet, 20*time, 1);
		
		ItemStack item = new ItemStack(Material.PAPER);
		ItemMeta mitem = item.getItemMeta();
		
		mitem.setDisplayName(ChatColor.GRAY+"Mechanizm: "+ChatColor.AQUA+name+" "+level);
		ArrayList<String> loreI = new ArrayList<String>();
		loreI.add(ChatColor.GRAY+lore);
		loreI.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+price+" cc");
		mitem.setLore(loreI);
		item.setItemMeta(mitem);
	}
	
	public PotionEffect getPotionEffect(){
		return pe;
	}
	
	public String getFullName(){
		return name+" "+level;
	}
	
	public String getName() {
		return name;
	}

	public String getLore() {
		return lore;
	}

	public int getLevel() {
		return level;
	}

	public int getMinimalLevel() {
		return minimalLevel;
	}

	public int getTime() {
		return time;
	}

	public int getPrice() {
		if(merchandice > 0){
			price = (int) price/100*merchandice;
		}
		return price;
	}

	public ItemStack getItem() {
		return item;
	}

	public int getMerchandice() {
		return merchandice;
	}

	public void setMerchandice(int merchandice) {
		this.merchandice = merchandice;
		
		ItemMeta mitem = item.getItemMeta();
		List<String> loreI = mitem.getLore();
		loreI.remove(loreI.size());
		loreI.add(ChatColor.GRAY+"Koszt: "+ChatColor.GREEN+ChatColor.UNDERLINE+price+" cc");
		mitem.setLore(loreI);
		item.setItemMeta(mitem);
	}
	
	public void setBlocked(){
		ItemMeta mitem = item.getItemMeta();
		mitem.setDisplayName(mitem.getDisplayName()+ChatColor.RED+" (Zablokowane)");
		List<String> loreI = mitem.getLore();
		loreI.remove(loreI.size());
		loreI.add(ChatColor.GRAY+"Dostepne od poziomu "+ChatColor.RED+minimalLevel);
		mitem.setLore(loreI);
		item.setItemMeta(mitem);
	}
	

}
