package pl.gastherr.cosmic.player;

public class Gracz {
	
	private int pktpostepu;
	private String frakcja;
	
	private boolean sound_exp;
	private boolean sound_lvlup;
	private boolean sound_teleport;
	private boolean sound_chat;
	private boolean scoreboard_show;
	private boolean isTeleporting;

	private Walka walka;
	private Staty staty;
	private Menu menu;
	
    public Gracz(Menu menu, Staty staty, Walka walka, int pktpostepu, String frakcja, boolean sound_exp, boolean sound_lvlup,
    		boolean sound_teleport, boolean sound_chat, boolean scoreboard_show, boolean isTeleporting
    		)
    {
    	this.staty = staty;
		this.walka = walka;
		this.menu = menu;
        this.pktpostepu = pktpostepu;
        this.frakcja = frakcja;
        this.sound_exp = sound_exp;
        this.sound_lvlup = sound_lvlup;
        this.sound_teleport = sound_teleport;
        this.sound_chat = sound_chat;
        this.scoreboard_show = scoreboard_show;
        this.isTeleporting = isTeleporting;
    }
    
    public int getPktPostepu()
    {
        return this.pktpostepu;
    }
 
    public void setPktPostepu(int pkt)
    {
        this.pktpostepu = pkt;
    }
    
    public String getFrakcja()
    {
        return this.frakcja;
    }
 
    public void setFrakcja(String frakcja)
    {
        this.frakcja = frakcja;
    }
    
    public boolean getSoundExp()
    {
        return this.sound_exp;
    }
 
    public void setSoundExp(boolean sound_exp)
    {
        this.sound_exp = sound_exp;
    }
    
    public boolean getSoundLvlup()
    {
        return this.sound_lvlup;
    }
 
    public void setSoundLvlup(boolean sound_lvlup)
    {
        this.sound_lvlup = sound_lvlup;
    }
    
    public boolean getSoundTeleport()
    {
        return this.sound_teleport;
    }
 
    public void setSoundTeleport(boolean sound_teleport)
    {
        this.sound_teleport = sound_teleport;
    }
	
    public boolean getSoundChat()
    {
        return this.sound_chat;
    }
 
    public void setSoundChat(boolean sound_chat)
    {
        this.sound_chat = sound_chat;
    }
    
    public boolean getScoreboardShow()
    {
        return this.scoreboard_show;
    }
 
    public void setScoreboardShow(boolean scoreboard_show)
    {
        this.scoreboard_show = scoreboard_show;
    }
    
    public boolean getIsTeleporting()
    {
        return this.isTeleporting;
    }
 
    public void setIsTeleporting(boolean isTeleporting)
    {
        this.isTeleporting = isTeleporting;
    }
    
    public Walka getWalka(){
    	return this.walka;
    }
    
    public Staty getStaty(){
    	return this.staty;
    }
    
    public Menu getMenu(){
    	return this.menu;
    }
    
}