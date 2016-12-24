package pl.gastherr.cosmic.player;

public class Staty {
	
	private int lvl;
	private float exp;
	
	private double kasa;
	private double wydanaKasa;
	private double zarobionaKasa;
	private double otrzymanaKasa;
	private int wykonanePrzelewy;
	private double przelanaKasa;
	
	private int aktywowane_mechanizmy;
	
	private int zabojstwa;
	private int smierci;
	
	private int mieczLvl;
	private int helmLvl;
	private int klataLvl;
	private int spodnieLvl;
	private int butyLvl;
	
	private int uz_instor;
	private int uz_forter;
	private int uz_proter;
	private int uz_pread;
	
	public Staty(int lvl, float exp, double kasa, double wydanaKasa, double zarobionaKasa, double otrzymanaKasa,
			int wykonanePrzelewy, double przelanaKasa, int aktywowane_mechanizmy, int mieczLvl,
			int helmLvl, int klataLvl, int spodnieLvl, int butyLvl, int zabojstwa,
			int smierci, int uz_instor, int uz_forter, int uz_proter, int uz_pread){
		this.lvl = lvl;
		this.exp = exp;
		this.kasa = kasa;
		this.wydanaKasa = wydanaKasa;
		this.zarobionaKasa = zarobionaKasa;
		this.otrzymanaKasa = otrzymanaKasa;
		this.wykonanePrzelewy = wykonanePrzelewy;
		this.przelanaKasa = przelanaKasa;
		this.aktywowane_mechanizmy = aktywowane_mechanizmy;
		this.zabojstwa = zabojstwa;
		this.smierci = smierci;
		this.mieczLvl = mieczLvl;
		this.helmLvl = helmLvl;
		this.klataLvl = klataLvl;
		this.spodnieLvl = spodnieLvl;
		this.butyLvl = butyLvl;
		this.uz_instor = uz_instor;
		this.uz_forter = uz_forter;
		this.uz_proter = uz_proter;
		this.uz_pread = uz_pread;
	}
	
    public int getLevel()
    {
        return this.lvl;
    }
 
    public void setLevel(int lvl2)
    {
        this.lvl = lvl2;
    }
    
    public float getExp()
    {
        return this.exp;
    }
 
    public void setExp(float exp)
    {
        this.exp = exp;
    }
    
    public double getKasa()
    {
        return this.kasa;
    }
 
    public void setKasa(double kasa)
    {
        this.kasa = kasa;
    }

    public double getWydanaKasa()
    {
        return this.wydanaKasa;
    }
 
    public void setWydanaKasa(double wydanaKasa)
    {
        this.wydanaKasa = wydanaKasa;
    }
    
    public double getZarobionaKasa()
    {
        return this.zarobionaKasa;
    }
 
    public void setZarobionaKasa(double zarobionaKasa)
    {
        this.zarobionaKasa = zarobionaKasa;
    }

    public double getOtrzymanaKasa()
    {
        return this.otrzymanaKasa;
    }
 
    public void setOtrzymanaKasa(double otrzymanaKasa)
    {
        this.otrzymanaKasa = otrzymanaKasa;
    }
    
    public int getWykonanePrzelewy()
    {
        return this.wykonanePrzelewy;
    }
 
    public void setWykonanePrzelewy(int wykonanePrzelewy)
    {
        this.wykonanePrzelewy = wykonanePrzelewy;
    }

    public double getPrzelanaKasa()
    {
        return this.przelanaKasa;
    }
 
    public void setPrzelanaKasa(double przelanaKasa)
    {
        this.przelanaKasa = przelanaKasa;
    }
    
    public int getAktywowaneMechanizmy()
    {
        return this.aktywowane_mechanizmy;
    }
 
    public void setAktywowaneMechanizmy(int aktywowane_mechanizmy)
    {
        this.aktywowane_mechanizmy = aktywowane_mechanizmy;
    }
	
	public int getZabojstwa(){
		return this.zabojstwa;
	}
	
	public void setZabojstwa(int zabojstwa){
		this.zabojstwa = zabojstwa;
	}
	
	public int getSmierci(){
		return this.smierci;
	}
	
	public void setSmierci(int smierci){
		this.smierci = smierci;
	}
	
	public int getMieczLvl()
    {
        return this.mieczLvl;
    }
 
    public void setMieczLvl(int mieczLvl)
    {
        this.mieczLvl = mieczLvl;
    }
    
    public int getHelmLvl()
    {
        return this.helmLvl;
    }
 
    public void setHelmLvl(int helmLvl)
    {
        this.helmLvl = helmLvl;
    }
    
    public int getKlataLvl()
    {
        return this.klataLvl;
    }
 
    public void setKlataLvl(int klataLvl)
    {
        this.klataLvl = klataLvl;
    }
    
    public int getSpodnieLvl()
    {
        return this.spodnieLvl;
    }
 
    public void setSpodnieLvl(int spodnieLvl)
    {
        this.spodnieLvl = spodnieLvl;
    }
    
    public int getButyLvl()
    {
        return this.butyLvl;
    }
 
    public void setButyLvl(int butyLvl)
    {
        this.butyLvl = butyLvl;
    }
    
    public int getUzyciaInstor()
    {
    	return this.uz_instor;
    }
    
    public void setUzyciaInstor(int uz_instor)
    {
    	this.uz_instor = uz_instor;
    }
    
    public int getUzyciaForter()
    {
    	return this.uz_forter;
    }
    
    public void setUzyciaForter(int uz_forter)
    {
    	this.uz_forter = uz_forter;
    }
    
    public int getUzyciaProter()
    {
    	return this.uz_proter;
    }
    
    public void setUzyciaProter(int uz_proter)
    {
    	this.uz_proter = uz_proter;
    }
    
    public int getUzyciaPread()
    {
    	return this.uz_pread;
    }
    
    public void setUzyciaPread(int uz_pread)
    {
    	this.uz_pread = uz_pread;
    }

}
