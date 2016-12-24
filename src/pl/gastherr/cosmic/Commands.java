package pl.gastherr.cosmic;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import pl.gastherr.cosmic.events.ItemsAfterDeath;
import pl.gastherr.cosmic.events.NPCInteract;
import pl.gastherr.cosmic.events.PlayerJoin;

public class Commands implements Listener, CommandExecutor{
	
	Main plugin;
	PlayerJoin pj;
	ItemsAfterDeath ItemsAfterDeath;
	NPCInteract reakcja = new NPCInteract(plugin);
	pl.gastherr.cosmic.events.Signs Signs;
	
	public Commands (Main plugin){
		this.plugin = plugin;
		   plugin.getCommand("clearexp").setExecutor(this);
		   plugin.getCommand("dajmenu").setExecutor(this);
		   plugin.getCommand("pinfo").setExecutor(this);
		   plugin.getCommand("setoption").setExecutor(this);
		   plugin.getCommand("zdejmijkombinezon").setExecutor(this);
		   plugin.getCommand("zalozkombinezon").setExecutor(this);
		   plugin.getCommand("setexp").setExecutor(this);
		   plugin.getCommand("upgrade").setExecutor(this);
		   plugin.getCommand("setlvl").setExecutor(this);
		   plugin.getCommand("clearchat").setExecutor(this);
		   plugin.getCommand("ainfo").setExecutor(this);
		   plugin.getCommand("givekombinezon").setExecutor(this);
		   plugin.getCommand("addfractioninfo").setExecutor(this);
		   plugin.getCommand("fractioninfo").setExecutor(this);
		   plugin.getCommand("money").setExecutor(this);
		   plugin.getCommand("kasa").setExecutor(this);
		   plugin.getCommand("sinfo").setExecutor(this);
		   plugin.getCommand("setloc").setExecutor(this);
		   plugin.getCommand("delloc").setExecutor(this);
		   plugin.getCommand("spawn").setExecutor(this);
		   plugin.getCommand("setrank").setExecutor(this);
		   plugin.getCommand("delrank").setExecutor(this);
		   plugin.getCommand("mechmenu").setExecutor(this);
		   plugin.getCommand("tptocord").setExecutor(this);
		   plugin.getCommand("iteminfo").setExecutor(this);
	}
	
	public void locationSaver(Location loc, String name){
		double blockX = loc.getX();
		double blockY = loc.getY();
		double blockZ = loc.getZ();
		float pitch = loc.getPitch();
		double yaw = loc.getYaw();
		String world = loc.getWorld().getName();
		
		plugin.getPluginConfig().createSection("Lokacje."+name);
		plugin.getPluginConfig().createSection("Lokacje."+name+".BlockX");
		plugin.getPluginConfig().set("Lokacje."+name+".BlockX", blockX);
		
		plugin.getPluginConfig().createSection("Lokacje."+name+".BlockY");
		plugin.getPluginConfig().set("Lokacje."+name+".BlockY", blockY);
		
		plugin.getPluginConfig().createSection("Lokacje."+name+".BlockZ");
		plugin.getPluginConfig().set("Lokacje."+name+".BlockZ", blockZ);
		
		plugin.getPluginConfig().createSection("Lokacje."+name+".Pitch");
		plugin.getPluginConfig().set("Lokacje."+name+".Pitch", pitch);
		
		plugin.getPluginConfig().createSection("Lokacje."+name+".Yaw");
		plugin.getPluginConfig().set("Lokacje."+name+".Yaw", yaw);
		
		plugin.getPluginConfig().createSection("Lokacje."+name+".Swiat");
		plugin.getPluginConfig().set("Lokacje."+name+".Swiat", world);
		
		plugin.savePluginConfig();
	}
	
	public ItemStack getItemLevel(String name, int path, String itemname, Material mate, String fraction){
		ItemStack result = new ItemStack(Material.STONE);
		Color cl = Color.WHITE;
		
		EnchantCC prot1 = new EnchantCC(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		EnchantCC prot2 = new EnchantCC(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		
		EnchantCC prot_fall_1 = new EnchantCC(Enchantment.PROTECTION_FALL, 1);
		EnchantCC prot_fall_2 = new EnchantCC(Enchantment.PROTECTION_FALL, 2);
		EnchantCC prot_fall_3 = new EnchantCC(Enchantment.PROTECTION_FALL, 3);
		EnchantCC prot_fall_4 = new EnchantCC(Enchantment.PROTECTION_FALL, 4);
		EnchantCC prot_fall_5 = new EnchantCC(Enchantment.PROTECTION_FALL, 5);
		
		EnchantCC thorns1 = new EnchantCC(Enchantment.THORNS, 1);
		EnchantCC thorns2 = new EnchantCC(Enchantment.THORNS, 2);
		
		switch(fraction.toLowerCase()){
			case "Instor":
			{
				cl = Color.GREEN;
				break;
			}
			case "Forter":
			{
				cl = Color.RED;
				break;
			}
			case "Proter":
			{
				cl = Color.AQUA;
				break;
			}
			case "Pread":
			{
				cl = Color.GRAY;
				break;
			}
			case "Liga":
			{
				cl = Color.ORANGE;
			}
		}
		
		if(path == 1){
			result = itemCreator(mate, cl, itemname, ChatColor.WHITE+"Level "+path, prot1);
		}
		
		if(path == 2){
			result = itemCreator(mate, cl, itemname, ChatColor.WHITE+"Level "+path, prot1, prot_fall_1);
		}
		
		if(path == 3){
			result = itemCreator(mate, cl, itemname, ChatColor.YELLOW+"Level "+path, prot1, prot_fall_1);
		}
		
		if(path == 4){
			result = itemCreator(mate, cl, itemname, ChatColor.YELLOW+"Level "+path, prot1, prot_fall_2);
		}
		
		if(path == 5){
			result = itemCreator(mate, cl, itemname, ChatColor.GOLD+"Level "+path, prot1, prot_fall_2);
		}
		
		if(path == 6){
			result = itemCreator(mate, cl, itemname, ChatColor.GOLD+"Level "+path, prot2, prot_fall_3);
		}
		
		if(path == 7){
			result = itemCreator(mate, cl, itemname, ChatColor.RED+"Level "+path, prot2, prot_fall_3);
		}
		
		if(path == 8){
			result = itemCreator(mate, cl, itemname, ChatColor.RED+"Level "+path, prot2, thorns1, prot_fall_4);
		}
		
		if(path == 9){
			result = itemCreator(mate, cl, itemname, ChatColor.DARK_RED+"Level "+path, prot2, thorns1, prot_fall_4);
		}
		
		if(path == 10){
			result = itemCreator(mate, cl, itemname, ChatColor.DARK_RED+""+ChatColor.BOLD+"Level "+path, prot2, thorns2, prot_fall_5);
		}
		
		return result;
	}
	
	public String changeMoneyFormat(int money){
		String result = "";
		if (money >= 1000){
			int kasa2 = money / 1000;
			double resztaKasa2 = money - kasa2*1000;
			String resztaShow = resztaKasa2+"";
			if (resztaKasa2 == 0.0){
				resztaShow = "000.0";
			}
			if (resztaKasa2 < 100.0){
				resztaShow = "0"+resztaKasa2;
			}
			if (resztaKasa2 < 10.0){
				resztaShow = "00"+resztaKasa2;
			}
			result = kasa2+" "+resztaShow;
		}else{
			result = money+".0";
		}
		return result;
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("clearexp")){
			if (!(s instanceof Player)){
				s.sendMessage(ChatColor.RED+"Tylko gracz moze uzyc tej komendy!");
				return false;
			}
			if (args.length == 0){
				Player p = (Player) s;
				String puid = p.getUniqueId().toString();
				p.setExp(0);
				p.setLevel(0);
				PlayerJoin.listaGraczy.get(puid).getStaty().setExp(0);;
				PlayerJoin.listaGraczy.get(puid).getStaty().setLevel(0);
				p.sendMessage("Oczyszczono exp i lvl");
			}
			if (args.length == 1){
				if(!Bukkit.getOnlinePlayers().equals(args[0])){
					s.sendMessage(ChatColor.RED+"Ten gracz nie przebywa na serwerze!");
				}
				Player p = Bukkit.getPlayer(args[0]);
				String puid = p.getUniqueId().toString();
				p.setExp(0);
				p.setLevel(0);
				PlayerJoin.listaGraczy.get(puid).getStaty().setExp(0);
				PlayerJoin.listaGraczy.get(puid).getStaty().setLevel(0);
				s.sendMessage("Oczyszczono exp i lvl graczowi "+args[0]);
			}
		}
		
		if (cmd.getName().equals("iteminfo")){
			Player p = (Player) s;
			ItemStack h = p.getItemInHand();
			String type = h.getType().toString();
			String amount = h.getAmount()+"";
			String name = h.getItemMeta().getDisplayName();
			String dura = h.getDurability()+"";
			p.sendMessage(ChatColor.GRAY+"Type: "+ChatColor.GOLD+type);
			p.sendMessage(ChatColor.GRAY+"Amount: "+ChatColor.GOLD+amount);
			p.sendMessage(ChatColor.GRAY+"Name: "+ChatColor.GOLD+name);
			p.sendMessage(ChatColor.GRAY+"Durability: "+ChatColor.GOLD+dura);
		}
		
		if (cmd.getName().equalsIgnoreCase("clearchat")){
			String ligaPrefix = ChatColor.DARK_GRAY+"["+ChatColor.RED+""+ChatColor.BOLD+"Liga"+ChatColor.DARK_GRAY+"] ";

			for(int i = 0; i< 100; i++){
				plugin.getServer().broadcastMessage("");
			}
			
			if (s.getName() != "CONSOLE"){
				plugin.getServer().broadcastMessage(ChatColor.GRAY+"Czat oczyscil: "+ChatColor.GOLD+s.getName());
			}else{
				plugin.getServer().broadcastMessage(ChatColor.GRAY+"Czat oczyscila "+ChatColor.GOLD+"KONSOLA");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("dajmenu")){
			if (!(s instanceof Player)){
				s.sendMessage(ChatColor.RED+"Tylko gracz moze uzyc tej komendy!");
				return false;
			}
			Player p = (Player) s;
			ItemStack menu = new ItemStack(Material.DOUBLE_PLANT);
			ItemMeta menu2 = menu.getItemMeta();
			menu2.setDisplayName(ChatColor.GOLD+""+ChatColor.BOLD+"Menu");
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY+"Wszystkie funkcje");
			lore.add(ChatColor.GRAY+"w jednym przedmiocie.");
			menu2.setLore(lore);
			menu.setItemMeta(menu2);
			if(p.getInventory().contains(menu)){
				p.sendMessage("Masz juz: Menu");
				return false;
			}else{
				p.getInventory().addItem(new ItemStack[] { menu });
				p.sendMessage("Dano: Menu");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("setloc")){
			Player p = (Player) s;
			if (args.length == 1){
				locationSaver(p.getLocation(), args[0]);
				p.sendMessage(ChatColor.GRAY+"Zapisano lokalizacje: "+ChatColor.GOLD+args[0]);
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("delloc")){
			Player p = (Player) s;
			if (args.length == 1){
				if (plugin.getPluginConfig().contains("Lokacje."+args[0])){
					plugin.getPluginConfig().set("Lokacje."+args[0], null);
					p.sendMessage(ChatColor.GRAY+"Usunieto lokalizacje: "+ChatColor.GOLD+args[0]);
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("setrank")){
			if (s.hasPermission("cc.setrank")){
				if (plugin.getServer().getPlayer(args[1]) != null){
					ArrayList<String> kmods = (ArrayList<String>) plugin.getPluginConfig().getStringList("KidMods");
					ArrayList<String> mods = (ArrayList<String>) plugin.getPluginConfig().getStringList("Mods");
					ArrayList<String> admins = (ArrayList<String>) plugin.getPluginConfig().getStringList("Admins");
					ArrayList<String> hadmins = (ArrayList<String>) plugin.getPluginConfig().getStringList("HAdmins");
					if (args[0].equalsIgnoreCase("kidmod")){
						kmods.add(args[1]);
						plugin.getPluginConfig().set("KidMods", kmods);
						String ranga = ChatColor.YELLOW+"kid mod";
						s.sendMessage(ChatColor.GRAY+"Gracz: "+ChatColor.GOLD+args[1]+ChatColor.GRAY+" jest ustawiony jako "+ranga+ChatColor.GRAY+"!");
						return false;
					}
					if (args[0].equalsIgnoreCase("mod")){
						mods.add(args[1]);
						plugin.getPluginConfig().set("Mods", mods);
						String ranga = ChatColor.GOLD+"mod";
						s.sendMessage(ChatColor.GRAY+"Gracz: "+ChatColor.GOLD+args[1]+ChatColor.GRAY+" jest ustawiony jako "+ranga+ChatColor.GRAY+"!");
						return false;
					}
					if (args[0].equalsIgnoreCase("admin")){
						admins.add(args[1]);
						plugin.getPluginConfig().set("Admins", admins);
						String ranga = ChatColor.RED+"admin";
						s.sendMessage(ChatColor.GRAY+"Gracz: "+ChatColor.GOLD+args[1]+ChatColor.GRAY+" jest ustawiony jako "+ranga+ChatColor.GRAY+"!");
						return false;
					}
					if (args[0].equalsIgnoreCase("hadmin")){
						hadmins.add(args[1]);
						plugin.getPluginConfig().set("HAdmins", hadmins);
						String ranga = ChatColor.DARK_RED+"H admin";
						s.sendMessage(ChatColor.GRAY+"Gracz: "+ChatColor.GOLD+args[1]+ChatColor.GRAY+" jest ustawiony jako "+ranga+ChatColor.GRAY+"!");
						return false;
					}
				}else{
					s.sendMessage(ChatColor.RED+"Taki gracz nie przebywa na serwerze!");
					return false;
				}
			}else{
				s.sendMessage(ChatColor.RED+"Brak permisji!");
				return false;
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("tptocord")){
			double blockX = Integer.parseInt(args[0])+0.5;
			double blockY = Integer.parseInt(args[1]);
			double blockZ = Integer.parseInt(args[2])+0.5;
			float pitch = Float.parseFloat(args[3]);
			float yaw = Float.parseFloat(args[4]);
			World swiat = Bukkit.getWorld("world");
			Location loc = new Location(swiat, blockX, blockY, blockZ, pitch, yaw);
			Player p = (Player) s;
			p.teleport(loc);
		}
		
		if (cmd.getName().equalsIgnoreCase("delrank")){
			if (s.hasPermission("cc.delrank")){
					ArrayList<String> kmods = (ArrayList<String>) plugin.getPluginConfig().getStringList("KidMods");
					ArrayList<String> mods = (ArrayList<String>) plugin.getPluginConfig().getStringList("Mods");
					ArrayList<String> admins = (ArrayList<String>) plugin.getPluginConfig().getStringList("Admins");
					ArrayList<String> hadmins = (ArrayList<String>) plugin.getPluginConfig().getStringList("HAdmins");
					if (args[0].equalsIgnoreCase("kidmod")){
						if (!kmods.contains(args[1])){
							s.sendMessage(ChatColor.RED+"Nie odnaleziono gracza!");
							return false;
						}
						kmods.remove(args[1]);
						plugin.getPluginConfig().set("KidMods", kmods);
						String ranga = ChatColor.YELLOW+"kid mod";
						s.sendMessage(ChatColor.GRAY+"Gracz: "+ChatColor.GOLD+args[1]+ChatColor.GRAY+" nie jest ustawiony jako "+ranga+ChatColor.GRAY+"!");
						return false;
					}
					if (args[0].equalsIgnoreCase("mod")){
						if (!mods.contains(args[1])){
							s.sendMessage(ChatColor.RED+"Nie odnaleziono gracza!");
							return false;
						}
						mods.remove(args[1]);
						plugin.getPluginConfig().set("Mods", mods);
						String ranga = ChatColor.GOLD+"mod";
						s.sendMessage(ChatColor.GRAY+"Gracz: "+ChatColor.GOLD+args[1]+ChatColor.GRAY+" nie jest ustawiony jako "+ranga+ChatColor.GRAY+"!");
						return false;
					}
					if (args[0].equalsIgnoreCase("admin")){
						if (!admins.contains(args[1])){
							s.sendMessage(ChatColor.RED+"Nie odnaleziono gracza!");
							return false;
						}
						admins.remove(args[1]);
						plugin.getPluginConfig().set("Admins", admins);
						String ranga = ChatColor.RED+"admin";
						s.sendMessage(ChatColor.GRAY+"Gracz: "+ChatColor.GOLD+args[1]+ChatColor.GRAY+" nie jest ustawiony jako "+ranga+ChatColor.GRAY+"!");
						return false;
					}
					if (args[0].equalsIgnoreCase("hadmin")){
						if (!hadmins.contains(args[1])){
							s.sendMessage(ChatColor.RED+"Nie odnaleziono gracza!");
							return false;
						}
						hadmins.remove(args[1]);
						plugin.getPluginConfig().set("HAdmins", hadmins);
						String ranga = ChatColor.DARK_RED+"H admin";
						s.sendMessage(ChatColor.GRAY+"Gracz: "+ChatColor.GOLD+args[1]+ChatColor.GRAY+" nie jest ustawiony jako "+ranga+ChatColor.GRAY+"!");
						return false;
					}
			}else{
				s.sendMessage(ChatColor.RED+"Brak permisji!");
				return false;
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("setexp")){
			if (!(s instanceof Player)){
				s.sendMessage(ChatColor.RED+"Tylko gracz moze uzyc tej komendy!");
				return false;
			}
			if (args.length==1){
				float value = 0;
				value = Float.parseFloat(args[0]); 
				Player p = (Player) s;
				String puid = p.getUniqueId().toString();
				PlayerJoin.listaGraczy.get(puid).getStaty().setExp(value);
				p.setExp(0);
				p.setExp(value);
				p.sendMessage(ChatColor.GRAY+"Ustawiono exp na "+ChatColor.GOLD+value);
			}
			if (args.length==2){
				Player cel = Bukkit.getPlayer(args[0]);
				if (cel != null){
					float value = 0;
					value = Float.parseFloat(args[1]); 
					Player p = (Player) s;
					String puid = cel.getUniqueId().toString();
					PlayerJoin.listaGraczy.get(puid).getStaty().setExp(value);
					cel.setExp(0);
					cel.setExp(value);
					p.sendMessage(ChatColor.GRAY+"Ustawiono exp graczowi "+cel.getName()+" na "+ChatColor.GOLD+value);
				}else{
					s.sendMessage(ChatColor.RED+"Taki gracz nie przebywa na serwerze!");
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("setlvl")){
			if (!(s instanceof Player)){
				s.sendMessage(ChatColor.RED+"Tylko gracz moze uzyc tej komendy!");
				return false;
			}
			if (args.length==1){
				int value = 0;
				value = Integer.parseInt(args[0]); 
				Player p = (Player) s;
				String puid = p.getUniqueId().toString();
				PlayerJoin.listaGraczy.get(puid).getStaty().setLevel(value);
				p.setLevel(value);
				p.sendMessage(ChatColor.GRAY+"Ustawiono level na "+ChatColor.GOLD+value);
				return false;
			}
			if (args.length==2){
				Player cel = Bukkit.getPlayer(args[0]);
				if (cel != null){
					int value = 0;
					value = Integer.parseInt(args[1]); 
					Player p = (Player) s;
					String puid = cel.getUniqueId().toString();
					PlayerJoin.listaGraczy.get(puid).getStaty().setLevel(value);
					cel.setLevel(value);
					p.sendMessage(ChatColor.GRAY+"Ustawiono level graczowi "+cel.getName()+" na "+ChatColor.GOLD+value);
					return false;
				}else{
					s.sendMessage(ChatColor.RED+"Taki gracz nie przebywa na serwerze!");
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("sinfo")){
			double kasa = plugin.statystyki.getKasa();
			String kasaFormat = changeMoneyFormat((int) kasa)+" cc";
			double wydanaKasa = plugin.statystyki.getWydanaKasa();
			String wydanaKasaFormat = changeMoneyFormat((int) wydanaKasa)+" cc";
			double zarobionaKasa = plugin.statystyki.getZarobionaKasa();
			String zarobionaKasaFormat = changeMoneyFormat((int) zarobionaKasa)+" cc";
			double otrzymanaKasa = plugin.statystyki.getOtrzymanaKasa();
			String otrzymanaKasaFormat = changeMoneyFormat((int) otrzymanaKasa)+" cc";
			int wykonanePrzelewy = plugin.statystyki.getWykonanePrzelewy();
			double przelanaKasa = plugin.statystyki.getPrzelanaKasa();
			String przelanaKasaFormat = changeMoneyFormat((int) przelanaKasa)+" cc";
			
			int aktywowane_mechanizmy = plugin.statystyki.getAktywowaneMechanizmy();

			int frakcjaInstor = plugin.statystyki.getFrakcjaInstor();
			int frakcjaForter = plugin.statystyki.getFrakcjaForter();
			int frakcjaProter = plugin.statystyki.getFrakcjaProter();
			int frakcjaPread = plugin.statystyki.getFrakcjaPread();
			
			int liczbaOdwiedzin = plugin.statystyki.getLiczbaOdwiedzin();
			
			if (args.length == 0){
				s.sendMessage(ChatColor.GRAY+"=====[ "+ChatColor.YELLOW+""+ChatColor.BOLD+"Statystytki serwerowe"+ChatColor.GRAY+" strona "+ChatColor.YELLOW+"1"+ChatColor.GRAY+"/"+ChatColor.YELLOW+"2"+ChatColor.GRAY+" ]=====");
				s.sendMessage(ChatColor.GRAY+"Kasa: "+ChatColor.YELLOW+kasaFormat);
				s.sendMessage(ChatColor.GRAY+"Wydana kasa: "+ChatColor.YELLOW+wydanaKasaFormat);
				s.sendMessage(ChatColor.GRAY+"Zarobiona kasa: "+ChatColor.YELLOW+zarobionaKasaFormat);
				s.sendMessage(ChatColor.GRAY+"Otrzymana kasa: "+ChatColor.YELLOW+otrzymanaKasaFormat);
				s.sendMessage(ChatColor.GRAY+"Przelana kasa: "+ChatColor.YELLOW+przelanaKasaFormat);
				s.sendMessage(ChatColor.GRAY+"Aktywowane mechanizmy: "+ChatColor.YELLOW+aktywowane_mechanizmy);
				s.sendMessage(ChatColor.GRAY+"Liczba odwiedzin: "+ChatColor.YELLOW+liczbaOdwiedzin);
				s.sendMessage(ChatColor.GRAY+"Aby zobaczyc kolejna strone wpisz:"+ChatColor.YELLOW+" /sinfo 2");
			}else{
				if (args[0].equalsIgnoreCase("1")){
					s.sendMessage(ChatColor.GRAY+"=====[ "+ChatColor.YELLOW+""+ChatColor.BOLD+"Statystytki serwerowe"+ChatColor.GRAY+" strona "+ChatColor.YELLOW+"1"+ChatColor.GRAY+"/"+ChatColor.YELLOW+"2"+ChatColor.GRAY+" ]=====");
					s.sendMessage(ChatColor.GRAY+"Kasa: "+ChatColor.YELLOW+kasaFormat);
					s.sendMessage(ChatColor.GRAY+"Wydana kasa: "+ChatColor.YELLOW+wydanaKasaFormat);
					s.sendMessage(ChatColor.GRAY+"Zarobiona kasa: "+ChatColor.YELLOW+zarobionaKasaFormat);
					s.sendMessage(ChatColor.GRAY+"Otrzymana kasa: "+ChatColor.YELLOW+otrzymanaKasaFormat);
					s.sendMessage(ChatColor.GRAY+"Przelana kasa: "+ChatColor.YELLOW+przelanaKasaFormat);
					s.sendMessage(ChatColor.GRAY+"Aktywowane mechanizmy: "+ChatColor.YELLOW+aktywowane_mechanizmy);
					s.sendMessage(ChatColor.GRAY+"Liczba odwiedzin: "+ChatColor.YELLOW+liczbaOdwiedzin);
					s.sendMessage(ChatColor.GRAY+"Aby zobaczyc kolejna strone wpisz:"+ChatColor.YELLOW+" /sinfo 2");
				}
				if (args[0].equalsIgnoreCase("2")){
					s.sendMessage(ChatColor.GRAY+"=====[ "+ChatColor.YELLOW+""+ChatColor.BOLD+"Statystytki serwerowe"+ChatColor.GRAY+" strona "+ChatColor.YELLOW+"2"+ChatColor.GRAY+"/"+ChatColor.YELLOW+"2"+ChatColor.GRAY+" ]=====");
					s.sendMessage(ChatColor.GRAY+"Ilosc rozegranych gier jako czlonek frakcji:");
					s.sendMessage(ChatColor.GRAY+"Instor: "+ChatColor.YELLOW+frakcjaInstor);
					s.sendMessage(ChatColor.GRAY+"Forter: "+ChatColor.YELLOW+frakcjaForter);
					s.sendMessage(ChatColor.GRAY+"Proter: "+ChatColor.YELLOW+frakcjaProter);
					s.sendMessage(ChatColor.GRAY+"Pread: "+ChatColor.YELLOW+frakcjaPread);
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("ainfo")){
			if (!s.hasPermission("cc.playerinfo")){
				s.sendMessage(ChatColor.RED+"Brak permisji!");
				return false;
			}
			Player cel = Bukkit.getPlayer(args[0]);
			if (cel != null){
				Player p = cel;
				String name = p.getName();
				String puid = p.getUniqueId().toString();
				double kasa = PlayerJoin.listaGraczy.get(puid).getStaty().getKasa();
				String kasaFormat = changeMoneyFormat((int) kasa);
				double przelanaKasa = PlayerJoin.listaGraczy.get(puid).getStaty().getPrzelanaKasa();
				String przelanaKasaFormat = changeMoneyFormat((int) przelanaKasa);
				double wydanaKasa = PlayerJoin.listaGraczy.get(puid).getStaty().getWydanaKasa();
				String wydanaKasaFormat = changeMoneyFormat((int) wydanaKasa);
				double zarobionaKasa = PlayerJoin.listaGraczy.get(puid).getStaty().getZarobionaKasa();
				String zarobionaKasaFormat = changeMoneyFormat((int) zarobionaKasa);
				double otrzymanaKasa = PlayerJoin.listaGraczy.get(puid).getStaty().getOtrzymanaKasa();
				String otrzymanaKasaFormat = changeMoneyFormat((int) otrzymanaKasa);
				
				boolean sound_chat = PlayerJoin.listaGraczy.get(puid).getSoundChat();
				boolean sound_exp = PlayerJoin.listaGraczy.get(puid).getSoundExp();
				boolean sound_lvlup = PlayerJoin.listaGraczy.get(puid).getSoundLvlup();
				boolean sound_teleport = PlayerJoin.listaGraczy.get(puid).getSoundTeleport();
				boolean scoreboard_show = PlayerJoin.listaGraczy.get(puid).getScoreboardShow();
				
				int zabojstwa = PlayerJoin.listaGraczy.get(puid).getStaty().getZabojstwa();
				int smierci = PlayerJoin.listaGraczy.get(puid).getStaty().getSmierci();
				double kdr = 0;
				if (zabojstwa != 0 && smierci != 0){
					kdr = zabojstwa/smierci;
				}else{
					kdr = 0;
				}
				int aktywowane_mechanizmy = PlayerJoin.listaGraczy.get(puid).getStaty().getAktywowaneMechanizmy();
				
				
				int lvl = PlayerJoin.listaGraczy.get(puid).getStaty().getLevel();
				float totalExp = PlayerJoin.listaGraczy.get(puid).getStaty().getExp();
				float expToLvl = Math.round(totalExp*100);
				String show = ""+expToLvl+"%";
				String frakcja = PlayerJoin.listaGraczy.get(puid).getFrakcja();
				ChatColor kolor = ChatColor.GOLD;
				
				if (args.length == 0){
					s.sendMessage(ChatColor.GRAY+"===== [ "+kolor+name+ChatColor.GRAY+" strona "+kolor+"1"+ChatColor.GRAY+"/"+kolor+"3"+ChatColor.GRAY+" ] =====");
					s.sendMessage(ChatColor.GRAY+"Poziom: "+kolor+lvl);
					s.sendMessage(ChatColor.GRAY+"Exp: "+kolor+show+ChatColor.GRAY+" nastepnego lvla");
					s.sendMessage(ChatColor.GRAY+"Kasa: "+kolor+kasaFormat+" cc");
					s.sendMessage(ChatColor.GRAY+"Zarobiona kasa: "+kolor+zarobionaKasaFormat+" cc");
					s.sendMessage(ChatColor.GRAY+"Wydana kasa: "+kolor+wydanaKasaFormat+" cc");
					s.sendMessage(ChatColor.GRAY+"Przelana kasa: "+kolor+przelanaKasaFormat+" cc");
					s.sendMessage(ChatColor.GRAY+"Otrzymana kasa: "+kolor+otrzymanaKasaFormat+" cc");
					s.sendMessage(ChatColor.GRAY+"Aktywowane mechanizmy: "+kolor+aktywowane_mechanizmy);
					s.sendMessage(ChatColor.GRAY+"Aby zobaczyc kolejna strone wpisz "+kolor+"/ainfo 2");
				}
				if (args.length == 1){
					if (args[0].equalsIgnoreCase("1")){
						s.sendMessage(ChatColor.GRAY+"===== ["+kolor+name+ChatColor.GRAY+"strona "+kolor+"1"+ChatColor.GRAY+"/"+kolor+"2"+ChatColor.GRAY+" ] =====");
						s.sendMessage(ChatColor.GRAY+"Poziom: "+kolor+lvl);
						s.sendMessage(ChatColor.GRAY+"Exp: "+kolor+show+ChatColor.GRAY+" nastepnego lvla");
						s.sendMessage(ChatColor.GRAY+"Kasa: "+kolor+kasaFormat+" cc");
						s.sendMessage(ChatColor.GRAY+"Zarobiona kasa: "+kolor+zarobionaKasaFormat+" cc");
						s.sendMessage(ChatColor.GRAY+"Wydana kasa: "+kolor+wydanaKasaFormat+" cc");
						s.sendMessage(ChatColor.GRAY+"Przelana kasa: "+kolor+przelanaKasaFormat+" cc");
						s.sendMessage(ChatColor.GRAY+"Otrzymana kasa: "+kolor+otrzymanaKasaFormat+" cc");
						s.sendMessage(ChatColor.GRAY+"Aktywowane mechanizmy: "+kolor+aktywowane_mechanizmy);
						s.sendMessage(ChatColor.GRAY+"Aby zobaczyc kolejna strone wpisz "+kolor+"/pinfo 2");
					}
					if (args[0].equalsIgnoreCase("2")){
						s.sendMessage(ChatColor.GRAY+"===== ["+kolor+name+ChatColor.GRAY+" strona "+kolor+"2"+ChatColor.GRAY+"/"+kolor+"3"+ChatColor.GRAY+" ] =====");
						s.sendMessage(ChatColor.GRAY+"Zabojstwa: "+kolor+zabojstwa);
						s.sendMessage(ChatColor.GRAY+"Smierci: "+kolor+smierci);
						s.sendMessage(ChatColor.GRAY+"KDR (zabojstwa / smierci): "+kolor+kdr);
					}
					if (args[0].equalsIgnoreCase("3")){
						s.sendMessage(ChatColor.GRAY+"===== ["+kolor+name+ChatColor.GRAY+" strona "+kolor+"2"+ChatColor.GRAY+"/"+kolor+"3"+ChatColor.GRAY+" ] =====");
						s.sendMessage(ChatColor.GRAY+"Zabojstwa: "+kolor+zabojstwa);
						s.sendMessage(ChatColor.GRAY+"Smierci: "+kolor+smierci);
						s.sendMessage(ChatColor.GRAY+"KDR (zabojstwa / smierci): "+kolor+kdr);
					}
				}
			}else{
				s.sendMessage(ChatColor.RED+"Taki gracz nie przebywa aktualnie na serwerze!");
			}
			
		}
		
		if (cmd.getName().equalsIgnoreCase("addfractioninfo")){
			  StringBuilder sb = new StringBuilder();
			  for(int z = 1; z < args.length; z++){
			    sb.append(args[z]).append(" ");
			  }
			  String msg = sb.toString();
			  ArrayList<String> lista = new ArrayList<String>();
			  if (plugin.getPluginConfig().getStringList("InfoFrakcji."+args[0]) != null){
				  lista = (ArrayList<String>) plugin.getPluginConfig().getStringList("InfoFrakcji."+args[0]);
			  }
			  lista.add(msg);
			  if(!plugin.getPluginConfig().contains("InfoFrakcji")){
				  plugin.getPluginConfig().createSection("InfoFrakcji");
				  plugin.getPluginConfig().createSection("InfoFrakcji.Instor");
				  plugin.getPluginConfig().createSection("InfoFrakcji.Forter");
				  plugin.getPluginConfig().createSection("InfoFrakcji.Proter");
				  plugin.getPluginConfig().createSection("InfoFrakcji.Pread");
			  }
			  plugin.getPluginConfig().set("InfoFrakcji."+args[0], lista);
			  plugin.savePluginConfig();
			  s.sendMessage(ChatColor.GRAY+"Dodano informacje dla: "+ChatColor.GOLD+args[0]);
		}
		
		if (cmd.getName().equalsIgnoreCase("money") || cmd.getName().equalsIgnoreCase("kasa")){
			if (!(s instanceof Player)){
				s.sendMessage(ChatColor.RED+"Tylko gracz moze uzyc tej komendy!");
				return false;
			}
			Player p = (Player) s;
			String puid = p.getUniqueId().toString();
			double kasa = PlayerJoin.listaGraczy.get(puid).getStaty().getKasa();
			String kasaFormat = changeMoneyFormat((int) kasa);
			s.sendMessage(ChatColor.GRAY+"Stan konta: "+ChatColor.GREEN+kasaFormat+" cc");
		}
		
		if (cmd.getName().equalsIgnoreCase("fractioninfo")){
			if (args.length == 1){
				String frakcjaPrefix = "";
				String iprefix = ChatColor.GREEN+""+ChatColor.BOLD+"Instor";
				String fprefix = ChatColor.RED+""+ChatColor.BOLD+"Forter";
				String pprefix = ChatColor.AQUA+""+ChatColor.BOLD+"Proter";
				String prprefix = ChatColor.DARK_GRAY+""+ChatColor.BOLD+"Pread";
				if (args[0].equalsIgnoreCase("Instor") || args[0].equalsIgnoreCase("instor")){
					frakcjaPrefix = iprefix;
				}
				if (args[0].equalsIgnoreCase("Forter") || args[0].equalsIgnoreCase("forter")){
					frakcjaPrefix = fprefix;
				}
				if (args[0].equalsIgnoreCase("Proter") || args[0].equalsIgnoreCase("proter")){
					frakcjaPrefix = pprefix;
				}
				if (args[0].equalsIgnoreCase("Pread") || args[0].equalsIgnoreCase("pread")){
					frakcjaPrefix = prprefix;
				}
				if (args[0].equalsIgnoreCase("help")){
					s.sendMessage(ChatColor.GRAY+"=====[ "+ChatColor.YELLOW+"Wszystkie frakcje"+ChatColor.GRAY+" ]=====");
					s.sendMessage(ChatColor.GRAY+"Informacje o "+iprefix+ChatColor.GRAY+" -> /fractioninfo Instor");
					s.sendMessage(ChatColor.GRAY+"Informacje o "+fprefix+ChatColor.GRAY+" -> /fractioninfo Forter");
					s.sendMessage(ChatColor.GRAY+"Informacje o "+pprefix+ChatColor.GRAY+" -> /fractioninfo Proter");
					s.sendMessage(ChatColor.GRAY+"Informacje o "+prprefix+ChatColor.GRAY+" -> /fractioninfo Pread");
					return false;
				}
			    s.sendMessage(ChatColor.GRAY+"=====[ "+frakcjaPrefix+ChatColor.GRAY+" ]=====");
				ArrayList<String> info = (ArrayList<String>) plugin.getPluginConfig().getStringList("InfoFrakcji."+args[0]);
				for(int z = 0; z < info.size(); z++){
				    s.sendMessage(ChatColor.GRAY+plugin.fixColors(info.get(z)));
				  }
			}else{
				s.sendMessage(ChatColor.RED+"Prawidlowe uzycie: /fractioninfo <nazwaFrakcji>");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("givekombinezon")){
			if (!(s instanceof Player)){
				s.sendMessage(ChatColor.RED+"Tylko gracz moze uzyc tej komendy!");
				return false;
			}
			Player p = (Player) s;
			ItemStack helm = getItemLevel(p.getName(), 1, ChatColor.AQUA+"Helm kombinezonu", Material.LEATHER_HELMET, args[0]);
			ItemStack klata = getItemLevel(p.getName(), 1, ChatColor.AQUA+"Tors kombinezonu", Material.LEATHER_CHESTPLATE, args[0]);
			ItemStack spodnie = getItemLevel(p.getName(), 1, ChatColor.AQUA+"Spodnie kombinezonu", Material.LEATHER_LEGGINGS, args[0]);
			ItemStack buty = getItemLevel(p.getName(), 1, ChatColor.AQUA+"Buty kombinezonu", Material.LEATHER_BOOTS, args[0]);
			
			p.getInventory().addItem(helm);
			p.getInventory().addItem(klata);
			p.getInventory().addItem(spodnie);
			p.getInventory().addItem(buty);
			
			p.sendMessage(ChatColor.GRAY+"Dano kombinezon: "+ChatColor.GOLD+args[0]);
		}
		
		if (cmd.getName().equalsIgnoreCase("pinfo")){
			if (!(s instanceof Player)){
				s.sendMessage(ChatColor.RED+"Tylko gracz moze uzyc tej komendy!");
				return false;
			}
			if (args.length == 0 || args.length == 1){
				Player p = Bukkit.getPlayer(s.getName());
				String name = p.getName();
				String puid = p.getUniqueId().toString();
				double kasa = PlayerJoin.listaGraczy.get(puid).getStaty().getKasa();
				String kasaFormat = changeMoneyFormat((int) kasa);
				double przelanaKasa = PlayerJoin.listaGraczy.get(puid).getStaty().getPrzelanaKasa();
				String przelanaKasaFormat = changeMoneyFormat((int) przelanaKasa);
				double wydanaKasa = PlayerJoin.listaGraczy.get(puid).getStaty().getWydanaKasa();
				String wydanaKasaFormat = changeMoneyFormat((int) wydanaKasa);
				double zarobionaKasa = PlayerJoin.listaGraczy.get(puid).getStaty().getZarobionaKasa();
				String zarobionaKasaFormat = changeMoneyFormat((int) zarobionaKasa);
				double otrzymanaKasa = PlayerJoin.listaGraczy.get(puid).getStaty().getOtrzymanaKasa();
				String otrzymanaKasaFormat = changeMoneyFormat((int) otrzymanaKasa);
				
				boolean sound_chat = PlayerJoin.listaGraczy.get(puid).getSoundChat();
				boolean sound_exp = PlayerJoin.listaGraczy.get(puid).getSoundExp();
				boolean sound_lvlup = PlayerJoin.listaGraczy.get(puid).getSoundLvlup();
				boolean sound_teleport = PlayerJoin.listaGraczy.get(puid).getSoundTeleport();
				boolean scoreboard_show = PlayerJoin.listaGraczy.get(puid).getScoreboardShow();
				
				int pktPost = PlayerJoin.listaGraczy.get(puid).getPktPostepu();
				
				int frakcjaInstor = PlayerJoin.listaGraczy.get(puid).getStaty().getUzyciaInstor();
				int frakcjaForter = PlayerJoin.listaGraczy.get(puid).getStaty().getUzyciaForter();
				int frakcjaProter = PlayerJoin.listaGraczy.get(puid).getStaty().getUzyciaProter();
				int frakcjaPread = PlayerJoin.listaGraczy.get(puid).getStaty().getUzyciaPread();
				
				int zabojstwa = PlayerJoin.listaGraczy.get(puid).getStaty().getZabojstwa();
				int smierci = PlayerJoin.listaGraczy.get(puid).getStaty().getSmierci();
				double kdr = 0;
				if (zabojstwa > 0){
					if (smierci == 0){
						smierci = 1;
					}
					kdr = zabojstwa/smierci;
				}else{
					kdr = 0;
				}
				int aktywowane_mechanizmy = PlayerJoin.listaGraczy.get(puid).getStaty().getAktywowaneMechanizmy();
				
				
				int lvl = PlayerJoin.listaGraczy.get(puid).getStaty().getLevel();
				float totalExp = PlayerJoin.listaGraczy.get(puid).getStaty().getExp();
				float expToLvl = 0;
				expToLvl = Math.round(totalExp*100);
				String show = ""+expToLvl+"%";
				String frakcja = PlayerJoin.listaGraczy.get(puid).getFrakcja();
				ChatColor kolor = ChatColor.GOLD;
				
				if (args.length == 0){
					s.sendMessage(ChatColor.GRAY+"===== [ "+kolor+name+ChatColor.GRAY+" strona "+kolor+"1"+ChatColor.GRAY+"/"+kolor+"3"+ChatColor.GRAY+" ] =====");
					s.sendMessage(ChatColor.GRAY+"Poziom: "+kolor+lvl);
					s.sendMessage(ChatColor.GRAY+"Exp: "+kolor+show+ChatColor.GRAY+" nastepnego lvla");
					s.sendMessage(ChatColor.GRAY+"Punkty postepu: "+kolor+pktPost);
					s.sendMessage(ChatColor.GRAY+"Kasa: "+kolor+kasaFormat+" cc");
					s.sendMessage(ChatColor.GRAY+"Zarobiona kasa: "+kolor+zarobionaKasaFormat+" cc");
					s.sendMessage(ChatColor.GRAY+"Wydana kasa: "+kolor+wydanaKasaFormat+" cc");
					s.sendMessage(ChatColor.GRAY+"Przelana kasa: "+kolor+przelanaKasaFormat+" cc");
					s.sendMessage(ChatColor.GRAY+"Aby zobaczyc kolejna strone wpisz "+kolor+"/pinfo 2");
				}
				if (args.length == 1){
					if (args[0].equalsIgnoreCase("1")){
						s.sendMessage(ChatColor.GRAY+"===== ["+kolor+name+ChatColor.GRAY+"strona "+kolor+"1"+ChatColor.GRAY+"/"+kolor+"2"+ChatColor.GRAY+" ] =====");
						s.sendMessage(ChatColor.GRAY+"Poziom: "+kolor+lvl);
						s.sendMessage(ChatColor.GRAY+"Exp: "+kolor+show+ChatColor.GRAY+" nastepnego lvla");
						s.sendMessage(ChatColor.GRAY+"Punkty postepu: "+kolor+pktPost);
						s.sendMessage(ChatColor.GRAY+"Kasa: "+kolor+kasaFormat+" cc");
						s.sendMessage(ChatColor.GRAY+"Zarobiona kasa: "+kolor+zarobionaKasaFormat+" cc");
						s.sendMessage(ChatColor.GRAY+"Wydana kasa: "+kolor+wydanaKasaFormat+" cc");
						s.sendMessage(ChatColor.GRAY+"Przelana kasa: "+kolor+przelanaKasaFormat+" cc");
						s.sendMessage(ChatColor.GRAY+"Otrzymana kasa: "+kolor+otrzymanaKasaFormat+" cc");
						s.sendMessage(ChatColor.GRAY+"Aby zobaczyc kolejna strone wpisz "+kolor+"/pinfo 2");
					}
					if (args[0].equalsIgnoreCase("2")){
						s.sendMessage(ChatColor.GRAY+"===== ["+kolor+name+ChatColor.GRAY+" strona "+kolor+"2"+ChatColor.GRAY+"/"+kolor+"3"+ChatColor.GRAY+" ] =====");
						s.sendMessage(ChatColor.GRAY+"Aktywowane mechanizmy: "+kolor+aktywowane_mechanizmy);
						s.sendMessage(ChatColor.GRAY+"Zabojstwa: "+kolor+zabojstwa);
						s.sendMessage(ChatColor.GRAY+"Smierci: "+kolor+smierci);
						s.sendMessage(ChatColor.GRAY+"KDR (zabojstwa / smierci): "+kolor+kdr);
					}
					if (args[0].equalsIgnoreCase("3")){
						s.sendMessage(ChatColor.GRAY+"===== ["+kolor+name+ChatColor.GRAY+" strona "+kolor+"3"+ChatColor.GRAY+"/"+kolor+"3"+ChatColor.GRAY+" ] =====");
						s.sendMessage(ChatColor.GRAY+"Ilosc rozegranych gier jako czlonek frakcji:");
						s.sendMessage(ChatColor.GRAY+"Instor: "+kolor+frakcjaInstor);
						s.sendMessage(ChatColor.GRAY+"Forter: "+kolor+frakcjaForter);
						s.sendMessage(ChatColor.GRAY+"Proter: "+kolor+frakcjaProter);
						s.sendMessage(ChatColor.GRAY+"Pread: "+kolor+frakcjaPread);
					}
				}
			}
		}
			
			if (cmd.getName().equalsIgnoreCase("zdejmijkombinezon")){
				Player p = Bukkit.getPlayer(s.getName());
				String puid = p.getUniqueId().toString();
				ItemStack item = new ItemStack(Material.AIR);

				p.getInventory().setHelmet(item);
				p.getInventory().setChestplate(item);
				p.getInventory().setLeggings(item);
				p.getInventory().setBoots(item);
			}
			
			if (cmd.getName().equalsIgnoreCase("spawn")){
				final Player p = (Player) s;
				final String puid = p.getUniqueId().toString();
				boolean isTeleporting = PlayerJoin.listaGraczy.get(puid).getIsTeleporting();
				final ItemStack nic = new ItemStack(Material.AIR);
				if (isTeleporting == false){
					if (!plugin.getPluginConfig().contains("Lokacje.RespawnPoint")){
						p.sendMessage(ChatColor.RED+"Lokacja "+ChatColor.YELLOW+"RespawnPoint"+ChatColor.RED+" nie zostala ustawiona!");
						return false;
					}
					double blockX = plugin.getPluginConfig().getDouble("Lokacje.RespawnPoint.BlockX");
					double blockY = plugin.getPluginConfig().getDouble("Lokacje.RespawnPoint.BlockY");
					double blockZ = plugin.getPluginConfig().getDouble("Lokacje.RespawnPoint.BlockZ");
					float pitch = (float) plugin.getPluginConfig().getDouble("Lokacje.RespawnPoint.Pitch");
					float yaw = (float) plugin.getPluginConfig().getDouble("Lokacje.RespawnPoint.Yaw");
					World swiat = Bukkit.getWorld("SpawnMap");
					final Location sLoc = new Location(swiat, blockX, blockY, blockZ, yaw, pitch);
					final boolean f = PlayerJoin.listaGraczy.get(puid).getWalka().getIsFighting();
					if (f == false && s.hasPermission("cc.teleport")){
						p.teleport(sLoc);
						return false;
					}
					p.sendMessage(ChatColor.GRAY+"Teleportacja nastapi za "+ChatColor.RED+"5"+ChatColor.GRAY+" sekund. Prosze sie nie ruszac.");
					PlayerJoin.listaGraczy.get(puid).setIsTeleporting(true);
					Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
						@Override
						public void run() {
							if (PlayerJoin.listaGraczy.get(puid).getIsTeleporting()){
								PlayerJoin.listaGraczy.get(puid).setIsTeleporting(false);
								p.sendMessage(ChatColor.GRAY+"Teleportuje...");
								p.teleport(sLoc);
								if (f){
									pl.gastherr.cosmic.events.ItemsAfterDeath.regiveMoney(p);
									ItemStack sword = pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().getSword();
									p.getInventory().remove(sword);
									p.getInventory().setHelmet(nic);
									p.getInventory().setChestplate(nic);
									p.getInventory().setLeggings(nic);
									p.getInventory().setBoots(nic);
									PlayerJoin.listaGraczy.get(puid).setFrakcja("Brak");
									pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().setMechList(null);
									pl.gastherr.cosmic.events.PlayerJoin.listaGraczy.get(puid).getWalka().setIsFighting(false);
								}
							}	
						}
					}, 20*5);
				}else{
					s.sendMessage(ChatColor.RED+"Nie mozesz uzyc tej komendy teraz!");
				}
			}
			
			if (cmd.getName().equalsIgnoreCase("zalozkombinezon")){
				Player p = Bukkit.getPlayer(s.getName());
				String puid = p.getUniqueId().toString();
				int helmLvl = PlayerJoin.listaGraczy.get(puid).getStaty().getHelmLvl();
				int klataLvl = PlayerJoin.listaGraczy.get(puid).getStaty().getKlataLvl();
				int spodnieLvl = PlayerJoin.listaGraczy.get(puid).getStaty().getSpodnieLvl();
				int butyLvl = PlayerJoin.listaGraczy.get(puid).getStaty().getButyLvl();
				String frakcja = PlayerJoin.listaGraczy.get(puid).getFrakcja();
				ItemStack helm = getItemLevel(p.getName(), helmLvl, ChatColor.AQUA+"Helm kombinezonu", Material.LEATHER_HELMET, frakcja);
				ItemStack klata = getItemLevel(p.getName(), klataLvl, ChatColor.AQUA+"Tors kombinezonu", Material.LEATHER_CHESTPLATE, frakcja);
				ItemStack spodnie = getItemLevel(p.getName(), spodnieLvl, ChatColor.AQUA+"Spodnie kombinezonu", Material.LEATHER_LEGGINGS, frakcja);
				ItemStack buty = getItemLevel(p.getName(), butyLvl, ChatColor.AQUA+"Buty kombinezonu", Material.LEATHER_BOOTS, frakcja);
				p.getInventory().setHelmet(helm);
				p.getInventory().setChestplate(klata);
				p.getInventory().setLeggings(spodnie);
				p.getInventory().setBoots(buty);
			
			}
			
			if (cmd.getName().equalsIgnoreCase("setoption")){
				Player p = (Player) s;
				String puid = p.getUniqueId().toString();
				if (args[0].equalsIgnoreCase("sound")){
					if (args[1].equalsIgnoreCase("exp")){
						if (args[2].equalsIgnoreCase("true")){
							PlayerJoin.listaGraczy.get(puid).setSoundExp(true);
							s.sendMessage(ChatColor.GRAY+"Opcja "+ChatColor.AQUA+"Dzwiek przy wydobyciu"+ChatColor.GRAY+" - "+ChatColor.GREEN+"ON");
						}
						if (args[2].equalsIgnoreCase("false")){
							PlayerJoin.listaGraczy.get(puid).setSoundExp(false);
							s.sendMessage(ChatColor.GRAY+"Opcja "+ChatColor.AQUA+"Dzwiek przy wydobyciu"+ChatColor.GRAY+" - "+ChatColor.RED+"OFF");
						}
					}
					if (args[1].equalsIgnoreCase("lvlup")){
						if (args[2].equalsIgnoreCase("true")){
							PlayerJoin.listaGraczy.get(puid).setSoundLvlup(true);
							s.sendMessage(ChatColor.GRAY+"Opcja "+ChatColor.AQUA+"Dzwiek przy lvlowaniu"+ChatColor.GRAY+" - "+ChatColor.GREEN+"ON");
						}
						if (args[2].equalsIgnoreCase("false")){
							PlayerJoin.listaGraczy.get(puid).setSoundLvlup(false);
							s.sendMessage(ChatColor.GRAY+"Opcja "+ChatColor.AQUA+"Dzwiek przy lvlowaniu"+ChatColor.GRAY+" - "+ChatColor.RED+"OFF");
						}
					}
					if (args[1].equalsIgnoreCase("teleport")){
						if (args[2].equalsIgnoreCase("true")){
							PlayerJoin.listaGraczy.get(puid).setSoundTeleport(true);
							s.sendMessage(ChatColor.GRAY+"Opcja "+ChatColor.AQUA+"Dzwiek przy teleportacji"+ChatColor.GRAY+" - "+ChatColor.GREEN+"ON");
						}
						if (args[2].equalsIgnoreCase("false")){
							PlayerJoin.listaGraczy.get(puid).setSoundTeleport(false);
							s.sendMessage(ChatColor.GRAY+"Opcja "+ChatColor.AQUA+"Dzwiek przy teleportacji"+ChatColor.GRAY+" - "+ChatColor.RED+"OFF");
						}
					}
					if (args[1].equalsIgnoreCase("chat")){
						if (args[2].equalsIgnoreCase("true")){
							PlayerJoin.listaGraczy.get(puid).setSoundChat(true);
							s.sendMessage(ChatColor.GRAY+"Opcja "+ChatColor.AQUA+"Dzwiek przy pisaniu na czacie"+ChatColor.GRAY+" - "+ChatColor.GREEN+"ON");
						}
						if (args[2].equalsIgnoreCase("false")){
							PlayerJoin.listaGraczy.get(puid).setSoundChat(false);
							s.sendMessage(ChatColor.GRAY+"Opcja "+ChatColor.AQUA+"Dzwiek przy pisaniu na czacie"+ChatColor.GRAY+" - "+ChatColor.RED+"OFF");
						}
					}
				}
				if (args[0].equalsIgnoreCase("scoreboard")){
					if (!(s instanceof Player)){
						s.sendMessage(ChatColor.RED+"Tylko gracz moze uzyc tej opcji!");
						return false;
					}
					if (args[1].equalsIgnoreCase("true")){
						PlayerJoin.listaGraczy.get(puid).setScoreboardShow(true);
						s.sendMessage(ChatColor.GRAY+"Opcja "+ChatColor.AQUA+"Pokaz scoreboard"+ChatColor.GRAY+" - "+ChatColor.GREEN+"ON");
						Main.setScoreboard(p, false);
					}
					if (args[1].equalsIgnoreCase("false")){
						PlayerJoin.listaGraczy.get(puid).setScoreboardShow(false);
						s.sendMessage(ChatColor.GRAY+"Opcja "+ChatColor.AQUA+"Pokaz scoreboard"+ChatColor.GRAY+" - "+ChatColor.RED+"OFF");
						Main.setScoreboard(p, false);
					}
				}
			}
			
			if(cmd.getName().equalsIgnoreCase("upgrade")){
				Player p = (Player) s;
				String puid = p.getUniqueId().toString();
				int pkt = PlayerJoin.listaGraczy.get(s.getName()).getPktPostepu();
				if (args[0].equalsIgnoreCase("miecz")){
					if (pkt > 0){
						PlayerJoin.listaGraczy.get(puid).setPktPostepu(PlayerJoin.listaGraczy.get(puid).getPktPostepu()-1);
						PlayerJoin.listaGraczy.get(puid).getStaty().setMieczLvl(PlayerJoin.listaGraczy.get(puid).getStaty().getMieczLvl()+1);
						s.sendMessage(ChatColor.GRAY+"Ulepszono "+ChatColor.GOLD+"Miecz"+ChatColor.GRAY+" do poziomu "+ChatColor.GOLD+PlayerJoin.listaGraczy.get(s.getName()).getStaty().getMieczLvl());
					}else{
						s.sendMessage(ChatColor.RED+"Nie masz zadnego punktu postepu, aby ulepszyc przedmiot!");
					}
				}
					
				if (args[0].equalsIgnoreCase("helm")){
					if (pkt > 0){
						PlayerJoin.listaGraczy.get(puid).setPktPostepu(PlayerJoin.listaGraczy.get(puid).getPktPostepu()-1);
						PlayerJoin.listaGraczy.get(puid).getStaty().setHelmLvl(PlayerJoin.listaGraczy.get(puid).getStaty().getHelmLvl()+1);
						s.sendMessage(ChatColor.GRAY+"Ulepszono "+ChatColor.GOLD+"Helm kombinezonu"+ChatColor.GRAY+" do poziomu "+ChatColor.GOLD+PlayerJoin.listaGraczy.get(s.getName()).getStaty().getHelmLvl());
					}else{
						s.sendMessage(ChatColor.RED+"Nie masz zadnego punktu postepu, aby ulepszyc przedmiot!");
					}
				}
				if (args[0].equalsIgnoreCase("klata")){
					if (pkt > 0){
						PlayerJoin.listaGraczy.get(puid).setPktPostepu(PlayerJoin.listaGraczy.get(puid).getPktPostepu()-1);
						PlayerJoin.listaGraczy.get(puid).getStaty().setKlataLvl(PlayerJoin.listaGraczy.get(puid).getStaty().getKlataLvl()+1);
						s.sendMessage(ChatColor.GRAY+"Ulepszono "+ChatColor.GOLD+"Tors kombinezonu"+ChatColor.GRAY+" do poziomu "+ChatColor.GOLD+PlayerJoin.listaGraczy.get(s.getName()).getStaty().getKlataLvl());
					}else{
						s.sendMessage(ChatColor.RED+"Nie masz zadnego punktu postepu, aby ulepszyc przedmiot!");
					}
				}
				if (args[0].equalsIgnoreCase("spodnie")){
					if (pkt > 0){
						PlayerJoin.listaGraczy.get(puid).setPktPostepu(PlayerJoin.listaGraczy.get(puid).getPktPostepu()-1);
						PlayerJoin.listaGraczy.get(puid).getStaty().setSpodnieLvl(PlayerJoin.listaGraczy.get(puid).getStaty().getSpodnieLvl()+1);
						s.sendMessage(ChatColor.GRAY+"Ulepszono "+ChatColor.GOLD+"Spodnie kombinezonu"+ChatColor.GRAY+" do poziomu "+ChatColor.GOLD+PlayerJoin.listaGraczy.get(s.getName()).getStaty().getSpodnieLvl());
					}else{
						s.sendMessage(ChatColor.RED+"Nie masz zadnego punktu postepu, aby ulepszyc przedmiot!");
					}
				}
				if (args[0].equalsIgnoreCase("buty")){
					if (pkt > 0){
						PlayerJoin.listaGraczy.get(puid).setPktPostepu(PlayerJoin.listaGraczy.get(puid).getPktPostepu()-1);
						PlayerJoin.listaGraczy.get(puid).getStaty().setButyLvl(PlayerJoin.listaGraczy.get(puid).getStaty().getButyLvl()+1);
						s.sendMessage(ChatColor.GRAY+"Ulepszono "+ChatColor.GOLD+"Buty kombinezonu"+ChatColor.GRAY+" do poziomu "+ChatColor.GOLD+PlayerJoin.listaGraczy.get(s.getName()).getStaty().getButyLvl());
					}else{
						s.sendMessage(ChatColor.RED+"Nie masz zadnego punktu postepu, aby ulepszyc przedmiot!");
					}
				}
			}
		return false;
	}
	
	private ItemStack itemCreator(Material mate, Color cl, String itemname, String lore, EnchantCC... ench){
		ItemStack level = new ItemStack(mate);
		ItemMeta levelM = level.getItemMeta();
		((LeatherArmorMeta) levelM).setColor(cl);
		levelM.setDisplayName(itemname);
		ArrayList<String> lore1 = new ArrayList<String>();
		lore1.add(lore);
		levelM.setLore(lore1);
		
		for(EnchantCC e : ench){
			levelM.addEnchant(e.getEnch(), e.getLevel(), true);
		}
		
		level.setItemMeta(levelM);
		return level;
	}

	
	
}
class EnchantCC {
	
	private Enchantment ench;
	private int level;
	
	public EnchantCC(Enchantment ench, int level) {
		this.ench = ench;
		this.level = level;
	}

	public Enchantment getEnch() {
		return ench;
	}

	public void setEnch(Enchantment ench) {
		this.ench = ench;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
