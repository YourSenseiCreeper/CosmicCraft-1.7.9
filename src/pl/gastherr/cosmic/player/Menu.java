package pl.gastherr.cosmic.player;

import pl.gastherr.cosmic.util.MenuType;

public class Menu {
	
	private MenuType mType;
	private int page;
	
	public Menu(MenuType mType, int page){
		this.mType = mType;
		this.page = page;
	}
	
	public MenuType getMenuType(){
		return this.mType;
	}

	public void setMenuType(MenuType mType){
		this.mType = mType;
	}
	
	public int getMenuPage(){
		return this.page;
	}
	
	public void setMenuPage(int page){
		this.page = page;
	}
}
