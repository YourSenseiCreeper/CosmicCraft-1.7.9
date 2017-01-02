package pl.gastherr.cosmic_core.player;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import pl.gastherr.cosmic.util.MenuType;

public class Walka {
	
	MenuType MenuType;
	
	private ArrayList<ItemStack> mechList = new ArrayList<ItemStack>();
	private ArrayList<String> activeMech = new ArrayList<String>();
	private ArrayList<String> bangCheck = new ArrayList<String>();
	private boolean openChoise;
	private boolean chosingItem;
	private boolean isFighting;
	private boolean isSpawning;
	private long firstAtack;
	private double mechKoszt;
	private String atacker;
	private ItemStack sword;
	private MenuType mType;
	
	public Walka(boolean openChoise, boolean chosingItem, long firstAtack, ArrayList<String> activeMech,
			ArrayList<String> bangCheck, ArrayList<ItemStack> mechList, ItemStack sword, boolean isFighting, boolean isSpawning,
			MenuType mType, int mechKoszt){
		this.openChoise = openChoise;
		this.chosingItem = chosingItem;
		this.firstAtack = firstAtack;
		this.activeMech = activeMech;
		this.bangCheck = bangCheck;
		this.mechList = mechList;
		this.sword = sword;
		this.isFighting = isFighting;
		this.isSpawning = isSpawning;
		this.mType = mType;
		this.mechKoszt = mechKoszt;
		
	}

	public ArrayList<ItemStack> getMechList(){
		return this.mechList;
	}
	
	public void setMechList(ArrayList<ItemStack> mechList){
		this.mechList = mechList;
	}
	
	public ArrayList<String> getActiveMech(){
		return this.activeMech;
	}
	
	public void setActiveMech(ArrayList<String> activeMech){
		this.activeMech = activeMech;
	}
	
	public ArrayList<String> getBangCheck(){
		return this.bangCheck;
	}
	
	public void setBangCheck(ArrayList<String> bangCheck){
		this.bangCheck = bangCheck;
	}
    
    public boolean getOpenChoise()
    {
        return this.openChoise;
    }
 
    public void setOpenChoise(boolean openChoise)
    {
        this.openChoise = openChoise;
    }
    
    public boolean getChosingItem()
    {
        return this.chosingItem;
    }
 
    public void setChosingItem(boolean chosingItem)
    {
        this.chosingItem = chosingItem;
    }
    
    public long getFirstAtack()
    {
        return this.firstAtack;
    }
 
    public void setFirstAtack(long firstAtack)
    {
        this.firstAtack = firstAtack;
    }
    
    public ItemStack getSword()
    {
        return this.sword;
    }
 
    public void setSword(ItemStack sword)
    {
        this.sword = sword;
    }
    
    public String getAtacker(){
    	return this.atacker;
    }
    
    public void setAtacker(String atacker){
    	this.atacker = atacker;
    }
    
    public boolean getIsFighting()
    {
        return this.isFighting;
    }
 
    public void setIsFighting(boolean isFighting)
    {
        this.isFighting = isFighting;
    }
    
    public boolean getIsSpawing()
    {
        return this.isSpawning;
    }
 
    public void setIsSpawning(boolean isSpawning)
    {
        this.isSpawning = isSpawning;
    }
    
    public MenuType getMenuType()
    {
    	return this.mType;
    }
    
    public void setMenuType(MenuType mType)
    {
    	this.mType = mType;
    }
    
    public double getMechKoszt()
    {
    	return this.mechKoszt;
    }
    
    public void setMechKoszt(double koszt)
    {
    	this.mechKoszt = koszt;
    }
}
