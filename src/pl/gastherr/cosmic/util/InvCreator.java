package pl.gastherr.cosmic.util;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import pl.gastherr.cosmic.Main;
import pl.gastherr.cosmic.events.PlayerJoin;
import pl.gastherr.cosmic.events.Signs;
import pl.gastherr.cosmic.util.ItemType;

public class InvCreator {
	
	Main plugin;
	pl.gastherr.cosmic.player.Menu Menu;
	
	public void createInv(MenuType mType, Player p){
		Inventory inv = null;
		String puid = p.getUniqueId().toString();
		ArrayList<ItemStack> wybrane = PlayerJoin.listaGraczy.get(puid).getWalka().getMechList();
		
		int lvl = PlayerJoin.listaGraczy.get(puid).getStaty().getLevel();
		double kasa = PlayerJoin.listaGraczy.get(puid).getStaty().getKasa();
		int page = Menu.getMenuPage();
		String frakcja = PlayerJoin.listaGraczy.get(puid).getFrakcja();
		ItemType normal = ItemType.NORMAL;
		ItemType nolvl = ItemType.NOLVL;
		ItemType instored = ItemType.INSTORED;
		ItemType sel = ItemType.SELECTED;
		ItemType natur = ItemType.NULL;
		
		if (mType.equals(MenuType.FIGHT)){
			
			if (page == 1){
				
			}
			ItemStack healer1 = null;
			ItemStack healer2 = null;
			ItemStack healer3 = null;
			for (int i = 1; i < 3; i++){
				if (i==1){
					if (lvl >= 5){
						if (frakcja.equalsIgnoreCase("instor")){
							healer1 = Signs.getByName(instored, "Heal:"+i);
						}else{
							healer1 = Signs.getByName(normal, "Heal:"+i);
						}
					}else{
						healer1 = Signs.getByName(nolvl, "Heal:"+i);
					}
				}
				if (i==2){
					if (lvl >= 10){
						if (frakcja.equalsIgnoreCase("instor")){
							healer2 = Signs.getByName(instored, "Heal:"+i);
						}else{
							healer2 = Signs.getByName(normal, "Heal:"+i);
						}
					}else{
						healer2 = Signs.getByName(nolvl, "Heal:"+i);
					}
				}
				if (i==3){
					if (lvl >= 15){
						if (frakcja.equalsIgnoreCase("instor")){
							healer3 = Signs.getByName(instored, "Heal:"+i);
						}else{
							healer3 = Signs.getByName(normal, "Heal:"+i);
						}
					}else{
						healer3 = Signs.getByName(nolvl, "Heal:"+i);
					}
				}
			}
			
			
			ItemStack speed1 = null;
			ItemStack speed2 = null;
			ItemStack speed3 = null;
			for (int i = 1; i < 3; i++){
				if (i==1){
					if (lvl >= 1){
						if (frakcja.equalsIgnoreCase("instor")){
							speed1 = Signs.getByName(instored, "Speed:"+i);
						}else{
							speed1 = Signs.getByName(normal, "Speed:"+i);
						}
					}else{
						speed1 = Signs.getByName(nolvl, "Speed:"+i);
					}
				}
				if (i==2){
					if (lvl >= 15){
						if (frakcja.equalsIgnoreCase("instor")){
							speed2 = Signs.getByName(instored, "Speed:"+i);
						}else{
							speed2 = Signs.getByName(normal, "Speed:"+i);
						}
					}else{
						speed2 = Signs.getByName(nolvl, "Speed:"+i);
					}
				}
				if (i==3){
					if (lvl >= 20){
						if (frakcja.equalsIgnoreCase("instor")){
							speed3 = Signs.getByName(instored, "Speed:"+i);
						}else{
							speed3 = Signs.getByName(normal, "Speed:"+i);
						}
					}else{
						speed3 = Signs.getByName(nolvl, "Speed:"+i);
					}
				}
			}
			
			ItemStack jump1 = null;
			ItemStack jump2 = null;
			ItemStack jump3 = null;
			for (int i = 1; i < 3; i++){
				if (i==1){
					if (lvl >= 3){
						if (frakcja.equalsIgnoreCase("instor")){
							jump1 = Signs.getByName(instored, "Jump:"+i);
						}else{
							jump1 = Signs.getByName(normal, "Jump:"+i);
						}
					}else{
						jump1 = Signs.getByName(nolvl, "Jump:"+i);
					}
				}
				if (i==2){
					if (lvl >= 8){
						if (frakcja.equalsIgnoreCase("instor")){
							jump2 = Signs.getByName(instored, "Jump:"+i);
						}else{
							jump2 = Signs.getByName(normal, "Jump:"+i);
						}
					}else{
						jump2 = Signs.getByName(nolvl, "Jump:"+i);
					}
				}
				if (i==3){
					if (lvl >= 13){
						if (frakcja.equalsIgnoreCase("instor")){
							jump3 = Signs.getByName(instored, "Jump:"+i);
						}else{
							jump3 = Signs.getByName(normal, "Jump:"+i);
						}
					}else{
						jump3 = Signs.getByName(nolvl, "Jump:"+i);
					}
				}
			}
			
			ItemStack power1 = null;
			ItemStack power2 = null;
			ItemStack power3 = null;
			for (int i = 1; i < 3; i++){
				if (i==1){
					if (lvl >= 3){
						if (frakcja.equalsIgnoreCase("instor")){
							power1 = Signs.getByName(instored, "Power:"+i);
						}else{
							power1 = Signs.getByName(normal, "Power:"+i);
						}
					}else{
						power1 = Signs.getByName(nolvl, "Power:"+i);
					}
				}
				if (i==2){
					if (lvl >= 8){
						if (frakcja.equalsIgnoreCase("instor")){
							power2 = Signs.getByName(instored, "Power:"+i);
						}else{
							power2 = Signs.getByName(normal, "Power:"+i);
						}
					}else{
						power2 = Signs.getByName(nolvl, "Power:"+i);
					}
				}
				if (i==3){
					if (lvl >= 13){
						if (frakcja.equalsIgnoreCase("instor")){
							power3 = Signs.getByName(instored, "Power:"+i);
						}else{
							power3 = Signs.getByName(normal, "Power:"+i);
						}
					}else{
						power3 = Signs.getByName(nolvl, "Power:"+i);
					}
				}
			}
			
			ItemStack fight = null;
			double kosz = PlayerJoin.listaGraczy.get(puid).getWalka().getMechKoszt();
			if (kosz <= kasa){
				fight = Signs.getByName(natur, "Fight");
				ItemMeta mFight = fight.getItemMeta();
				mFight.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"Do walki!");
				ArrayList<String> blockedItemLore =  new ArrayList<String>();
				blockedItemLore.add(ChatColor.GRAY+"Kliknij, aby dolaczyc do walki!");
				blockedItemLore.add(ChatColor.GRAY+"Koszt mechanizmow: "+ChatColor.GREEN+kosz+" cc");
				mFight.setLore(blockedItemLore);
				fight.setItemMeta(mFight);
			}else{
				fight = Signs.getByName(natur, "Fight");
				ItemMeta mFight = fight.getItemMeta();
				mFight.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"Do walki!");
				ArrayList<String> blockedItemLore =  new ArrayList<String>();
				blockedItemLore.add(ChatColor.GRAY+"Kliknij, aby dolaczyc do walki!");
				blockedItemLore.add(ChatColor.GRAY+"Koszt mechanizmow: "+ChatColor.RED+kosz+" cc");
				mFight.setLore(blockedItemLore);
				fight.setItemMeta(mFight);
			}
			
			inv = Bukkit.createInventory(p, 27, ChatColor.BLACK+"Wybierz mechanizmy!");
			
			ItemStack sp1 = Signs.getByName(normal, "StartPacket:1");
			if (wybrane.contains(sp1)){
				sp1 = Signs.getByName(sel, "StartPacket:1");
			}
			
			inv.setItem(0, healer1);
			inv.setItem(9, healer2);
			inv.setItem(18, healer3);
			
			inv.setItem(2, speed1);
			inv.setItem(11, speed2);
			inv.setItem(20, speed3);
			
			inv.setItem(4, jump1);
			inv.setItem(13, jump2);
			inv.setItem(22, jump3);
			
			inv.setItem(6, power1);
			inv.setItem(15, power2);
			inv.setItem(24, power3);
			
			inv.setItem(17, sp1);
			inv.setItem(26, fight);
		}
		if (mType.equals(MenuType.UPGRADE)){
			
		}
		PlayerJoin.listaGraczy.get(puid).getWalka().setChosingItem(true);
		p.openInventory(inv);
		PlayerJoin.listaGraczy.get(puid).getWalka().setChosingItem(false);
		
	}
	
}
