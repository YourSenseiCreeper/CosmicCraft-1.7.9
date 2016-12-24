package pl.gastherr.cosmic.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import net.citizensnpcs.api.event.NPCRightClickEvent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import pl.gastherr.cosmic.Main;
import pl.gastherr.cosmic.events.Signs;
import pl.gastherr.cosmic.util.ItemType;
import pl.gastherr.cosmic.util.MenuType;
import pl.gastherr.cosmic.ServerStats;

public class NPCInteract implements Listener{

	Main plugin;
	Signs Signs;
	ServerStats ServerStats;
	pl.gastherr.cosmic.util.InvCreator InvCreator;
	
	public NPCInteract (Main plugin){
		this.plugin = plugin;
	}
	
	public ItemStack giveSword(Player p){
		String puid = p.getUniqueId().toString();
		String frakcja = PlayerJoin.listaGraczy.get(puid).getFrakcja();
		int mieczLvl = PlayerJoin.listaGraczy.get(puid).getStaty().getMieczLvl();
		ItemStack miecz = new ItemStack(Material.STONE_SWORD);
		ItemMeta mMiecz = miecz.getItemMeta();
		mMiecz.setDisplayName(ChatColor.RED+"Miecz wojownika");
		ArrayList<String> lore = new ArrayList<String>();
			if (mieczLvl == 1){
				if (frakcja.equalsIgnoreCase("Instor")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Forter")){
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Proter")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Pread")){
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
				}
				lore.add(ChatColor.WHITE+"Level 1");
			}
			if (mieczLvl == 2){
				if (frakcja.equalsIgnoreCase("Instor")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Forter")){
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Proter")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Pread")){
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
				}
				lore.add(ChatColor.WHITE+"Level 2");
			}
			if (mieczLvl == 3){
				if (frakcja.equalsIgnoreCase("Instor")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Forter")){
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Proter")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Pread")){
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
				}
				lore.add(ChatColor.WHITE+"Level 3");
			}
			if (mieczLvl == 4){
				if (frakcja.equalsIgnoreCase("Instor")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Forter")){
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Proter")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Pread")){
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
				}
				lore.add(ChatColor.WHITE+"Level 4");
			}
			if (mieczLvl == 5){
				if (frakcja.equalsIgnoreCase("Instor")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Forter")){
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Proter")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Pread")){
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 1, true);
				}
				lore.add(ChatColor.WHITE+"Level 5");
			}
			if (mieczLvl == 6){
				if (frakcja.equalsIgnoreCase("Instor")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Forter")){
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Proter")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Pread")){
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 1, true);
				}
				lore.add(ChatColor.WHITE+"Level 6");
			}
			if (mieczLvl == 7){
				if (frakcja.equalsIgnoreCase("Instor")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Forter")){
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Proter")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Pread")){
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
				}
				lore.add(ChatColor.WHITE+"Level 7");
			}
			if (mieczLvl == 8){
				if (frakcja.equalsIgnoreCase("Instor")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Forter")){
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Proter")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Pread")){
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
				}
				lore.add(ChatColor.WHITE+"Level 8");
			}
			if (mieczLvl == 9){
				if (frakcja.equalsIgnoreCase("Instor")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Forter")){
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Proter")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Pread")){
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				}
				lore.add(ChatColor.WHITE+"Level 9");
			}
			if (mieczLvl == 10){
				if (frakcja.equalsIgnoreCase("Instor")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Forter")){
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
				}
				if (frakcja.equalsIgnoreCase("Proter")){
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
				}
				if (frakcja.equalsIgnoreCase("Pread")){
					mMiecz.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
					mMiecz.addEnchant(Enchantment.KNOCKBACK, 2, true);
					mMiecz.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
				}
				lore.add(ChatColor.WHITE+"Level 10");
			}
			mMiecz.setLore(lore);
			miecz.setItemMeta(mMiecz);
			return miecz;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onRightClickNPC(NPCRightClickEvent e){
		
		String name = ChatColor.stripColor(e.getNPC().getName());
		Location npcLoc = e.getNPC().getStoredLocation();
		Location eyeNPC = new Location(npcLoc.getWorld(), npcLoc.getX(), npcLoc.getY()+1, npcLoc.getZ());
		ArrayList<ItemStack> lista = new ArrayList<ItemStack>();
		String puid = e.getClicker().getUniqueId().toString();
		Player p = e.getClicker();
		ItemStack hand = p.getItemInHand(); 
		if (hand.getType().equals(Material.LEATHER_BOOTS) ||
			hand.getType().equals(Material.LEATHER_CHESTPLATE) ||
			hand.getType().equals(Material.LEATHER_LEGGINGS) ||
			hand.getType().equals(Material.LEATHER_BOOTS) ||
			hand.getType().equals(Material.STONE_SWORD)){
			return;
		}
		
		if (name.equalsIgnoreCase("Instor") ||
				name.equalsIgnoreCase("Forter")||
				name.equalsIgnoreCase("Proter")||
				name.equalsIgnoreCase("Pread")){
			MenuType mType = MenuType.FIGHT;
			p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
			String fr = name;
			p.playEffect(eyeNPC, Effect.MOBSPAWNER_FLAMES, 2);
			PlayerJoin.listaGraczy.get(puid).getWalka().setOpenChoise(true);
			PlayerJoin.listaGraczy.get(puid).setFrakcja(fr);
			PlayerJoin.listaGraczy.get(puid).getWalka().setMechList(lista);
			PlayerJoin.listaGraczy.get(puid).getWalka().setMechKoszt(0);
			InvCreator.createInv(mType, p);
		}
		
	}
	
	@SuppressWarnings("static-access")
	public void itemCheck(Player p, ItemStack item, int lvl, int lvlPotrzebny){
		
		ItemType nor = ItemType.NULL;
		ItemStack heal1 = Signs.getByName(nor, "Heal:1");
		ItemStack heal2 = Signs.getByName(nor, "Heal:2");
		ItemStack heal3 = Signs.getByName(nor, "Heal:3");
		
		ItemStack speed1 = Signs.getByName(nor, "Speed:1");
		ItemStack speed2 = Signs.getByName(nor, "Speed:2");
		ItemStack speed3 = Signs.getByName(nor, "Speed:3");
		
		ItemStack jump1 = Signs.getByName(nor, "Jump:1");
		ItemStack jump2 = Signs.getByName(nor, "Jump:2");
		ItemStack jump3 = Signs.getByName(nor, "Jump:3");
		
		ItemStack power1 = Signs.getByName(nor, "Power:1");
		ItemStack power2 = Signs.getByName(nor, "Power:2");
		ItemStack power3 = Signs.getByName(nor, "Power:3");
		
		ItemStack sp1 = Signs.getByName(nor, "StartPacket:1");
		
		String msg_dodany = ChatColor.DARK_GRAY+"["+ChatColor.GREEN+"\u2714"+ChatColor.DARK_GRAY+"] "+ChatColor.GRAY+"Mechanizm dodany!";
		String msg_usuniety = ChatColor.DARK_GRAY+"["+ChatColor.RED+"\u2726"+ChatColor.DARK_GRAY+"] "+ChatColor.GRAY+"Mechanizm usuniety!";
		String msg_max = ChatColor.DARK_GRAY+"["+ChatColor.RED+"\u2726"+ChatColor.DARK_GRAY+"] "+ChatColor.GRAY+"Maksymalna ilosc to 2!";
		
		String puid = p.getUniqueId().toString();
		String frakcja = PlayerJoin.listaGraczy.get(puid).getFrakcja();
		ArrayList<ItemStack> mechList = PlayerJoin.listaGraczy.get(puid).getWalka().getMechList();
		
		double wyd = 0.0;
		if (item.equals(heal1)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 36.0;
			}else{
				wyd = 40.0;
			}
		}
		if (item.equals(heal2)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 90.0;
			}else{
				wyd = 100.0;
			}
		}
		if (item.equals(heal3)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 225.0;
			}else{
				wyd = 250.0;
			}
		}
		if (item.equals(speed1)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 45.0;
			}else{
				wyd = 50.0;
			}
		}
		if (item.equals(speed2)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 108.0;
			}else{
				wyd = 120.0;
			}
		}
		if (item.equals(speed3)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 162.0;
			}else{
				wyd = 180.0;
			}
		}
		if (item.equals(jump1)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 45.0;
			}else{
				wyd = 50.0;
			}
		}
		if (item.equals(jump2)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 108.0;
			}else{
				wyd = 120.0;
			}
		}
		if (item.equals(jump3)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 270.0;
			}else{
				wyd = 300.0;
			}
		}
		if (item.equals(power1)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 90.0;
			}else{
				wyd = 100.0;
			}
		}
		if (item.equals(power2)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 180.0;
			}else{
				wyd = 200.0;
			}
		}
		if (item.equals(power3)){
			if (frakcja.equalsIgnoreCase("Instor")){
				wyd = 225.0;
			}else{
				wyd = 250.0;
			}
		}
		
		if (lvl >= lvlPotrzebny){
			if (!mechList.contains(item)){
				if (mechList.size() < 2){
					if (mechList.contains(sp1)){
						p.sendMessage(ChatColor.GREEN+"Pakiet startowy"+ChatColor.GRAY+" nie moze byc z innymi mechanizmami!");
						return;
					}
					if (item.equals(sp1) && mechList.size() > 0){
						p.sendMessage(ChatColor.GREEN+"Pakiet startowy"+ChatColor.GRAY+" nie moze byc z innymi mechanizmami!");
						return;
					}
					p.sendMessage(msg_dodany);
					mechList.add(item);
					PlayerJoin.listaGraczy.get(puid).getWalka().setMechList(mechList);
					this.koszt.put(p.getName(), this.koszt.get(p.getName())+wyd);
					createInv(MenuType.FIGHT, p);
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 1);
					return;
				}else{
					p.sendMessage(msg_max);
				}
			}else{
				p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 1);
				mechList.remove(item);
				koszt.put(p.getName(), koszt.get(p.getName())-wyd);
				PlayerJoin.listaGraczy.get(puid).getWalka().setMechList(mechList);
				createInv(MenuType.FIGHT, p);
				p.sendMessage(msg_usuniety);
			}
		}else{
			p.sendMessage(ChatColor.RED+"Ten mechanizm nie jest odblokowany!");
		}
	}
	
	@SuppressWarnings({ "static-access", "deprecation" })
	@EventHandler
	public void onClick(InventoryClickEvent e){
		
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
		
		ItemStack fight = Signs.getByName("Fight");
		ItemStack sp1 = Signs.getByName("StartPacket:1");
		
		final Player p = (Player) e.getWhoClicked();
		final String puid = p.getUniqueId().toString();
		
		int lvl = PlayerJoin.listaGraczy.get(puid).getStaty().getLevel();
		
		int slot = e.getRawSlot();
		int size = e.getInventory().getSize();
		String frakcja = PlayerJoin.listaGraczy.get(puid).getFrakcja();
		boolean openInv = PlayerJoin.listaGraczy.get(puid).getWalka().getOpenChoise();
		ArrayList<ItemStack> mechList = PlayerJoin.listaGraczy.get(puid).getWalka().getMechList();
		
		if (e.getSlotType().equals(SlotType.ARMOR)){
			e.setCancelled(true);
			p.sendMessage(ChatColor.RED+"Nie mozesz zmieniac kombinezonu!");
			return;
		}
		
		boolean ft = PlayerJoin.listaGraczy.get(puid).getWalka().getIsFighting();
		
		if (ft){
			e.setCancelled(true);
			return;
		}
		
		if (openInv){
			if (e.getAction() == InventoryAction.PICKUP_ALL){
				e.setCancelled(true);
				if (slot >= 0 && slot < size){
						if (e.getCurrentItem().equals(heal1)){
							itemCheck(p, heal1, lvl, 5);
						}
						if (e.getCurrentItem().equals(heal2)){
							itemCheck(p, heal2, lvl, 10);
						}
						if (e.getCurrentItem().equals(heal3)){
							itemCheck(p, heal3, lvl, 15);
						}
						if (e.getCurrentItem().equals(speed1)){
							itemCheck(p, speed1, lvl, 1);
						}
						if (e.getCurrentItem().equals(speed2)){
							itemCheck(p, speed2, lvl, 15);
						}
						if (e.getCurrentItem().equals(speed3)){
							itemCheck(p, speed3, lvl, 20);
						}
						if (e.getCurrentItem().equals(jump1)){
							itemCheck(p, jump1, lvl, 3);
						}
						if (e.getCurrentItem().equals(jump2)){
							itemCheck(p, jump2, lvl, 8);
						}
						if (e.getCurrentItem().equals(jump3)){
							itemCheck(p, jump3, lvl, 13);
						}
						if (e.getCurrentItem().equals(power1)){
							itemCheck(p, power1, lvl, 9);
						}
						if (e.getCurrentItem().equals(power2)){
							itemCheck(p, power2, lvl, 16);
						}
						if (e.getCurrentItem().equals(power3)){
							itemCheck(p, power3, lvl, 24);
						}
						if (e.getCurrentItem().equals(sp1)){
							itemCheck(p, sp1, lvl, 0);
						}
						if (e.getCurrentItem().equals(fight)){
							ArrayList<ItemStack> mechy = PlayerJoin.listaGraczy.get(puid).getWalka().getMechList();
							if (mechy.size() == 0){
								p.sendMessage(ChatColor.RED+"Musisz wybrac jakies mechanizmy!");
								return;
							}
							ArrayList<Location> listaLoc = new ArrayList<Location>();
							for(int z = 1; z <= 5; z++){
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
							p.teleport(fLoc);
							ItemStack sword = giveSword(p);
							p.getInventory().addItem(sword);
							PlayerJoin.listaGraczy.get(puid).getWalka().setSword(sword);
							if (!mechList.contains(sp1)){
								for (int l = 0; l < 2; l++){
									ItemStack st = mechList.get(l);
									st.setType(Material.PAPER);
									ItemMeta stMeta = st.getItemMeta();
									if(st.equals(heal1)){
										ArrayList<String> lore = (ArrayList<String>) stMeta.getLore();
										lore.remove(1);
										st.setItemMeta(stMeta);
									}
									if(st.equals(heal2)){
										ArrayList<String> lore = (ArrayList<String>) stMeta.getLore();
										lore.remove(1);
										st.setItemMeta(stMeta);
									}
									if(st.equals(heal3)){
										ArrayList<String> lore = (ArrayList<String>) stMeta.getLore();
										lore.remove(1);
										st.setItemMeta(stMeta);
									}
									p.getInventory().addItem(st);
								}
							}else{
								ItemStack h1 = Signs.getByName("Heal:1");
								ItemStack s1 = Signs.getByName("Speed:1");
								
								p.getInventory().addItem(h1);
								p.getInventory().addItem(s1);
							}
							p.chat("/zalozkombinezon");
							PlayerJoin.listaGraczy.get(puid).getStaty().setKasa(PlayerJoin.listaGraczy.get(puid).getStaty().getKasa()-koszt.get(p.getName()));
							PlayerJoin.listaGraczy.get(puid).getStaty().setWydanaKasa(PlayerJoin.listaGraczy.get(puid).getStaty().getWydanaKasa()+koszt.get(p.getName()));
							PlayerJoin.listaGraczy.get(puid).getWalka().setIsFighting(true);
							p.playEffect(fLoc, Effect.MOBSPAWNER_FLAMES, 1);
							p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1, 1);
							if (frakcja.equalsIgnoreCase("Instor")){
								PlayerJoin.listaGraczy.get(puid).getStaty().setUzyciaInstor(PlayerJoin.listaGraczy.get(puid).getStaty().getUzyciaInstor()+1);
								plugin.statystyki.setFrakcjaInstor(plugin.statystyki.getFrakcjaInstor()+1);
							}
							if (frakcja.equalsIgnoreCase("Forter")){
								PlayerJoin.listaGraczy.get(puid).getStaty().setUzyciaForter(PlayerJoin.listaGraczy.get(puid).getStaty().getUzyciaForter()+1);
								plugin.statystyki.setFrakcjaForter(plugin.statystyki.getFrakcjaForter()+1);
							}
							if (frakcja.equalsIgnoreCase("Proter")){
								PlayerJoin.listaGraczy.get(puid).getStaty().setUzyciaProter(PlayerJoin.listaGraczy.get(puid).getStaty().getUzyciaProter()+1);
								plugin.statystyki.setFrakcjaProter(plugin.statystyki.getFrakcjaProter()+1);
							}
							if (frakcja.equalsIgnoreCase("Pread")){
								PlayerJoin.listaGraczy.get(puid).getStaty().setUzyciaPread(PlayerJoin.listaGraczy.get(puid).getStaty().getUzyciaPread()+1);
								plugin.statystyki.setFrakcjaPread(plugin.statystyki.getFrakcjaPread()+1);
							}
							p.setNoDamageTicks(100);
							PlayerJoin.listaGraczy.get(puid).getWalka().setIsSpawning(true);
							Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){

								@Override
								public void run() {
									PlayerJoin.listaGraczy.get(puid).getWalka().setIsSpawning(false);
									Location pl = p.getLocation();
									Location head = new Location(pl.getWorld(), pl.getX(), pl.getY()+1, pl.getZ());
									p.playEffect(head, Effect.MOBSPAWNER_FLAMES, 2);
								}
								
							}, 100);
							p.sendMessage(ChatColor.GOLD+"Powodzenia!");
						}
				}else{
					e.setCancelled(true);
				}
			}else{
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onDrag(InventoryDragEvent e){
	
		Player p = (Player) e.getWhoClicked();
		String puid = p.getUniqueId().toString();
		boolean openInv = PlayerJoin.listaGraczy.get(puid).getWalka().getOpenChoise();
		boolean fight = PlayerJoin.listaGraczy.get(puid).getWalka().getIsFighting();
		
		if(openInv || fight){
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onInteract(InventoryInteractEvent e){
		
		Player p = (Player) e.getWhoClicked();
		String puid = p.getUniqueId().toString();
		boolean openInv = PlayerJoin.listaGraczy.get(puid).getWalka().getOpenChoise();
		boolean fight = PlayerJoin.listaGraczy.get(puid).getWalka().getIsFighting();
		if (openInv || fight){
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent e){
		
		Player p = (Player) e.getPlayer();
		String puid = p.getUniqueId().toString();
		boolean openInv = PlayerJoin.listaGraczy.get(puid).getWalka().getOpenChoise();
		boolean chosingItem = PlayerJoin.listaGraczy.get(puid).getWalka().getChosingItem();
		
		if (openInv){
			if (chosingItem == false){
				PlayerJoin.listaGraczy.get(puid).getWalka().setOpenChoise(false);
			}
		}
		
	}
	
}
