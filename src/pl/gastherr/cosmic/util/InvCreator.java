package pl.gastherr.cosmic.util;

import java.util.ArrayList;
import java.util.HashMap;

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
import pl.gastherr.cosmic.player.Gracz;
import pl.gastherr.cosmic.player.Menu;

public class InvCreator {
	
	Main plugin;
	Menu Menu;
	
	public void createInv(MenuType mType, Player p){
		
		Inventory inv = null;
		String puid = p.getUniqueId().toString();
		HashMap<String, Gracz> players = PlayerJoin.listaGraczy;
		ArrayList<ItemStack> wybrane = players.get(puid).getWalka().getMechList();
		
		int lvl = players.get(puid).getStaty().getLevel();
		double kasa = players.get(puid).getStaty().getKasa();
		String frakcja = players.get(puid).getFrakcja();
		
		int page = Menu.getMenuPage();
		
		
		if (mType.equals(MenuType.FIGHT)){
			
			if (page == 1){
				
			}
			HashMap<String, ItemStack> items = new HashMap<>();
			
			HashMap<String, Integer[]> mechs = new HashMap<>(5);
			mechs.put("Heal", new Integer[]{5, 10, 15});
			mechs.put("Speed", new Integer[]{1, 15, 20});
			mechs.put("Jump", new Integer[]{3, 8, 13});	
			mechs.put("Power", new Integer[]{3, 8, 13});

			for(String mech : mechs.keySet()){
				for (int i : mechs.get(mech)){
					items.put(mech+":"+i, select(i, lvl, i, frakcja, mech));
				}
			}
			
			ItemStack fight = null;
			double kosz = PlayerJoin.listaGraczy.get(puid).getWalka().getMechKoszt();
			
			boolean decision = kosz <= kasa;
			
			String cost = decision ? ChatColor.GREEN+"" : ChatColor.RED+"";
			fight = Signs.getByName(ItemType.NULL, "Fight");
			ItemMeta mFight = fight.getItemMeta();
			mFight.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"Do walki!");
			ArrayList<String> blockedItemLore =  new ArrayList<String>();
			blockedItemLore.add(ChatColor.GRAY+"Kliknij, aby dolaczyc do walki!");
			blockedItemLore.add(ChatColor.GRAY+"Koszt mechanizmow: "+cost+kosz+" cc");
			mFight.setLore(blockedItemLore);
			fight.setItemMeta(mFight);
		
			inv = Bukkit.createInventory(p, 27, ChatColor.BLACK+"Wybierz mechanizmy!");
			
			ItemStack sp1 = Signs.getByName(ItemType.NORMAL, "StartPacket:1");
			if (wybrane.contains(sp1)){
				sp1 = Signs.getByName(ItemType.SELECTED, "StartPacket:1");
			}
			
			inv.setItem(0, items.get("Heal:1"));
			inv.setItem(9, items.get("Heal:2"));
			inv.setItem(18, items.get("Heal:3"));
			
			inv.setItem(2, items.get("Speed:1"));
			inv.setItem(11, items.get("Speed:2"));
			inv.setItem(20, items.get("Speed:3"));
			
			inv.setItem(4, items.get("Jump:1"));
			inv.setItem(13, items.get("Jump:2"));
			inv.setItem(22, items.get("Jump:3"));
			
			inv.setItem(6, items.get("Power:1"));
			inv.setItem(15, items.get("Power:2"));
			inv.setItem(24, items.get("Power:3"));
			
			inv.setItem(17, sp1);
			inv.setItem(26, fight);
		}
		if (mType.equals(MenuType.UPGRADE)){
			
		}
		players.get(puid).getWalka().setChosingItem(true);
		p.openInventory(inv);
		players.get(puid).getWalka().setChosingItem(false);
		
	}
	
	private ItemStack select(int minimalLvl, int lvl, int number, String frakcja, String mech){
		ItemStack ret = null;
		if (lvl >= minimalLvl){
			if (frakcja.equalsIgnoreCase("instor")){
				ret = Signs.getByName(ItemType.INSTORED, mech+number);
			}else{
				ret = Signs.getByName(ItemType.NORMAL, mech+number);
			}
		}else{
			ret = Signs.getByName(ItemType.NOLVL, mech+number);
		}
		return ret;
	}
	
}
