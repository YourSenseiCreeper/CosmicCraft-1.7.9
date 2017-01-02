package pl.gastherr.cosmic_core.util;

import java.io.*;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import pl.gastherr.cosmic_core.Main;
import pl.gastherr.cosmic_core.ServerStats;
import pl.gastherr.cosmic_core.player.Gracz;
import pl.gastherr.cosmic_core.player.Menu;

/**
 * @author YourSenseiCreeper
 * @since 2017
 */

public class PluginData {
	
	private static Main core;
	
	@SuppressWarnings("static-access")
	public PluginData(Main plugin){
		this.core = plugin;
	}

	private static ServerStats stats;
	private static FileConfiguration config;
	
	private static HashMap<String, FileConfiguration> player_configs = new HashMap<>();
	private static HashMap<String, Gracz> players = new HashMap<>();

	
	private static void copy(InputStream in, File file) throws IOException {
        OutputStream out = new FileOutputStream(file);
        byte[] buf = new byte[1024];
        int len;
 
        while((len = in.read(buf)) > 0){
            out.write(buf, 0, len);
        }
 
        out.close();
        in.close();
    }
	
	//SERVER CONFIGURATION & DATA
	
	public void loadServerData(){
		
		File file = new File(core.getDataFolder(), "config.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        
        if (file.exists()){
        	config = cfg;
        }
        
        try {
        	
            file.getParentFile().mkdirs();
            copy(core.getResource("config.yml"), file);
            cfg = YamlConfiguration.loadConfiguration(file);
            cfg.save(file);
            config = cfg;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		double kasa = cfg.getDouble("Kasa");
		int akt_mech = cfg.getInt("AktywowaneMechanizmy");

		int instor = cfg.getInt("Instor");
		int forter = cfg.getInt("Forter");
		int proter = cfg.getInt("Proter");
		int pread = cfg.getInt("Pread");
		
		int l_odw = cfg.getInt("LiczbaOdwiedzin");
		int lu_odw = cfg.getInt("LiczbaUnikalnychOdwiedzin");
		List<String> staff = cfg.getStringList("Admins");
		
	    stats = new ServerStats(kasa, akt_mech, instor, forter, proter, pread, l_odw, lu_odw, staff);
	}
	
	public static ServerStats getServerStats(){
		return stats;
	}
	
	public void saveServerData(){
		
		config.set("Kasa", stats.getKasa());
		config.set("AktywowaneMechanizmy", stats.getAktywowaneMechanizmy());
		config.set("Instor", stats.getUz_instor());
		config.set("Forter", stats.getUz_forter());
		config.set("Proter", stats.getUz_proter());
		config.set("Pread", stats.getUz_pread());
		
		config.set("LiczbaOdwiedzin", stats.getLiczbaOdwiedzin());
		config.set("LiczbaUnikalnychOdwiedzin", stats.getLiczbaUnikalnychOdwiedzin());
		
		File f = new File(core.getDataFolder(), "config.yml");
        try {
        	config.save(f);
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//PLAYER CONFIGURATION & DATA
	
	public static void registerPlayerConfig(String name){
		
		File file = new File(core.getDataFolder()+File.separator+"Gracze", name+".yml");
        YamlConfiguration getConfig;
        
        if (file.exists()){
        	player_configs.put(name, YamlConfiguration.loadConfiguration(file));
        	return;
        }
        
        try {
        	
            file.getParentFile().mkdirs();
            copy(core.getResource("gracz.yml"), file);
            getConfig = YamlConfiguration.loadConfiguration(file);
            getConfig.save(file);
            player_configs.put(name, getConfig);  
            
        } catch (IOException e) {
            e.printStackTrace();
        }    
	}
	
	public static void loadPlayer(String name){
		
		FileConfiguration gracz = player_configs.get(name);
		
		float exp = (float) gracz.getDouble("Exp");
		int level = gracz.getInt("Level");
		int pktpostepu = gracz.getInt("PktPostepu");
		double kasa = gracz.getDouble("Kasa");
		int mieczLvl = gracz.getInt("MieczLvl");
		int helmLvl = gracz.getInt("HelmLvl");
		int klataLvl = gracz.getInt("KlataLvl");
		int spodnieLvl = gracz.getInt("SpodnieLvl");
		int butyLvl = gracz.getInt("ButyLvl");
		
		int zabojstwa = gracz.getInt("Zabojstwa");
		int smierci = gracz.getInt("Smierci");
		int akt_mech = gracz.getInt("AktywowaneMechanizmy");
		
		int instor = gracz.getInt("Instor");
		int forter = gracz.getInt("Forter");
		int proter = gracz.getInt("Proter");
		int pread = gracz.getInt("Pread");
		
		
		Gracz g = new Gracz(level, exp, pktpostepu, kasa, akt_mech, zabojstwa, smierci,
				mieczLvl, helmLvl, klataLvl, spodnieLvl, butyLvl,
				instor, forter, proter, pread,
				Frakcja.BRAK, false, null, new Menu(MenuType.NULL, 0));
		players.put(name, g);
	}
	
	public static void savePlayer(String name){
		
		Gracz g = players.get(name);
		FileConfiguration gracz = player_configs.get(name);
		
		gracz.set("Exp", g.getExp());
		gracz.set("Level", g.getLevel());
		gracz.set("PktPostepu", g.getPktPostepu());
		
		gracz.set("Kasa", g.getKasa());
		gracz.set("MieczLvl", g.getMieczLvl());
		gracz.set("HelmLvl", g.getHelmLvl());
		gracz.set("KlataLvl", g.getKlataLvl());
		gracz.set("SpodnieLvl", g.getSpodnieLvl());
		gracz.set("ButyLvl", g.getButyLvl());
		gracz.set("Zabojstwa", g.getZabojstwa());
		gracz.set("Smierci", g.getSmierci());
		gracz.set("AktywowaneMechanizmy", g.getAktywowaneMechanizmy());
		gracz.set("Instor", g.getUz_instor());
		gracz.set("Forter", g.getUz_forter());
		gracz.set("Proter", g.getUz_proter());
		gracz.set("Pread", g.getUz_pread());
		
		File f = new File(core.getDataFolder()+File.separator+"Gracze", name+".yml");
        try {
			gracz.save(f);
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void unregisterPlayerConfig(String name){
		player_configs.remove(name);
	}
	
}