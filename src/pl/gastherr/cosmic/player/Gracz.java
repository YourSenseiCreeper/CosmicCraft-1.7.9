package pl.gastherr.cosmic.player;

public class Gracz {
	
	private int pktpostepu;
	private String frakcja;
	private boolean isTeleporting;

	private Walka walka;
	private Staty staty;
	private Menu menu;
	
    public Gracz(Menu menu, Staty staty, Walka walka, int pktpostepu, String frakcja, boolean isTeleporting)
    {
    	this.staty = staty;
		this.walka = walka;
		this.menu = menu;
        this.pktpostepu = pktpostepu;
        this.frakcja = frakcja;
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