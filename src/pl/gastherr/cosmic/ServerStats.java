package pl.gastherr.cosmic;

public class ServerStats {
	
	private double kasa;
	
	private int aktywowane_mechanizmy;

	private int frakcjaInstor;
	private int frakcjaForter;
	private int frakcjaProter;
	private int frakcjaPread;
	
	private int liczbaOdwiedzin;
	
    public ServerStats(double kasa, int aktywowane_mechanizmy, int frakcjaInstor, int frakcjaForter,
    		int frakcjaProter, int frakcjaPread, int liczbaOdwiedzin)
    {
        this.kasa = kasa;
       
        this.aktywowane_mechanizmy = aktywowane_mechanizmy;
        
        this.frakcjaInstor = frakcjaInstor;
        this.frakcjaForter = frakcjaForter;
        this.frakcjaProter = frakcjaProter;
        this.frakcjaPread = frakcjaPread;
        
        this.liczbaOdwiedzin = liczbaOdwiedzin;
    }
	
	public double getKasa(){
		return this.kasa;
	}
	
	public void setKasa(double kasa){
		this.kasa = kasa;
	}
	
	public int getAktywowaneMechanizmy(){
		return this.aktywowane_mechanizmy;
	}
	
	public void setAktywowaneMechanizmy(int aktywowane_mechanizmy){
		this.aktywowane_mechanizmy = aktywowane_mechanizmy;
	}
	
	public int getFrakcjaInstor(){
		return this.frakcjaInstor;
	}
	
	public void setFrakcjaInstor(int frakcjaInstor){
		this.frakcjaInstor = frakcjaInstor;
	}
	
	public int getFrakcjaForter(){
		return this.frakcjaForter;
	}
	
	public void setFrakcjaForter(int frakcjaForter){
		this.frakcjaForter = frakcjaForter;
	}
	
	public int getFrakcjaProter(){
		return this.frakcjaProter;
	}
	
	public void setFrakcjaProter(int frakcjaProter){
		this.frakcjaProter = frakcjaProter;
	}
	
	public int getFrakcjaPread(){
		return this.frakcjaPread;
	}
	
	public void setFrakcjaPread(int frakcjaPread){
		this.frakcjaPread = frakcjaPread;
	}
	
	public int getLiczbaOdwiedzin(){
		return this.liczbaOdwiedzin;
	}
	
	public void addLiczbaOdwiedzin(){
		this.liczbaOdwiedzin = liczbaOdwiedzin++;
	}
}