package pl.gastherr.cosmic;

public class ServerStats {
	
	private double kasa;
	private double wydanaKasa;
	private double zarobionaKasa;
	private double otrzymanaKasa;
	private int wykonanePrzelewy;
	private double przelanaKasa;
	
	private int kupione_mechanizmy;
	private int aktywowane_mechanizmy;

	private int frakcjaInstor;
	private int frakcjaForter;
	private int frakcjaProter;
	private int frakcjaPread;
	
	private int liczbaOdwiedzin;
	
    public ServerStats(double kasa, double wydanaKasa, double zarobionaKasa, double otrzymanaKasa, int wykonanePrzelewy,
    		double przelanaKasa, int kupione_mechanizmy, int aktywowane_mechanizmy, int frakcjaInstor, int frakcjaForter,
    		int frakcjaProter, int frakcjaPread, int liczbaOdwiedzin)
    {
        this.kasa = kasa;
        this.wydanaKasa = wydanaKasa;
        this.zarobionaKasa = zarobionaKasa;
        this.otrzymanaKasa = otrzymanaKasa;
        this.wykonanePrzelewy = wykonanePrzelewy;
        this.przelanaKasa = przelanaKasa;
        
        this.kupione_mechanizmy = kupione_mechanizmy;
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
	
	public double getWydanaKasa(){
		return this.wydanaKasa;
	}
	
	public void setWydanaKasa(double wydanaKasa){
		this.wydanaKasa = wydanaKasa;
	}
	
	public double getZarobionaKasa(){
		return this.zarobionaKasa;
	}
	
	public void setZarobionaKasa(double zarobionaKasa){
		this.zarobionaKasa = zarobionaKasa;
	}
	
	public double getOtrzymanaKasa(){
		return this.otrzymanaKasa;
	}
	
	public void setOtrzymanaKasa(double otrzymanaKasa){
		this.otrzymanaKasa = otrzymanaKasa;
	}
	
	public int getWykonanePrzelewy(){
		return this.wykonanePrzelewy;
	}
	
	public void setWykonanePrzelewy(int wykonanePrzelewy){
		this.wykonanePrzelewy = wykonanePrzelewy;
	}
	
	public double getPrzelanaKasa(){
		return this.przelanaKasa;
	}
	
	public void setPrzelanaKasa(double przelanaKasa){
		this.przelanaKasa = przelanaKasa;
	}
	
	public int getKupioneMechanizmy(){
		return this.kupione_mechanizmy;
	}
	
	public void setKupioneMechanizmy(int kupione_mechanizmy){
		this.kupione_mechanizmy = kupione_mechanizmy;
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
	
	public void setLiczbaOdwiedzin(int liczbaOdwiedzin){
		this.liczbaOdwiedzin = liczbaOdwiedzin;
	}
}