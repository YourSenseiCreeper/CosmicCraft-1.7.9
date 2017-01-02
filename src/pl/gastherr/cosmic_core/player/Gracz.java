package pl.gastherr.cosmic_core.player;

import pl.gastherr.cosmic_core.util.Frakcja;

public class Gracz {
	
	private int lvl;
	private float exp;
	private int pktpostepu;
	
	private double kasa;
	
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
	
	private Frakcja frakcja;
	private boolean isTeleporting;

	private Walka walka;
	private Menu menu;
	
	public Gracz(int lvl, float exp, int pktpostepu, double kasa,
			int aktywowane_mechanizmy, int zabojstwa, int smierci,
			int mieczLvl, int helmLvl, int klataLvl, int spodnieLvl,
			int butyLvl, int uz_instor, int uz_forter, int uz_proter,
			int uz_pread, Frakcja frakcja, boolean isTeleporting, Walka walka, Menu menu) {
		this.lvl = lvl;
		this.exp = exp;
		this.pktpostepu = pktpostepu;
		this.kasa = kasa;
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
		this.frakcja = frakcja;
		this.isTeleporting = isTeleporting;
		this.walka = walka;
		this.menu = menu;
	}

	public int getLevel() {
		return lvl;
	}

	public void setLevel(int lvl) {
		this.lvl = lvl;
	}

	public float getExp() {
		return exp;
	}

	public void setExp(float exp) {
		this.exp = exp;
	}

	public int getPktPostepu() {
		return pktpostepu;
	}

	public void setPktPostepu(int pktpostepu) {
		this.pktpostepu = pktpostepu;
	}

	public double getKasa() {
		return kasa;
	}

	public void setKasa(double kasa) {
		this.kasa = kasa;
	}

	public int getAktywowaneMechanizmy() {
		return aktywowane_mechanizmy;
	}

	public void setAktywowaneMechanizmy(int aktywowane_mechanizmy) {
		this.aktywowane_mechanizmy = aktywowane_mechanizmy;
	}

	public int getZabojstwa() {
		return zabojstwa;
	}

	public void setZabojstwa(int zabojstwa) {
		this.zabojstwa = zabojstwa;
	}

	public int getSmierci() {
		return smierci;
	}

	public void setSmierci(int smierci) {
		this.smierci = smierci;
	}

	public int getMieczLvl() {
		return mieczLvl;
	}

	public void setMieczLvl(int mieczLvl) {
		this.mieczLvl = mieczLvl;
	}

	public int getHelmLvl() {
		return helmLvl;
	}

	public void setHelmLvl(int helmLvl) {
		this.helmLvl = helmLvl;
	}

	public int getKlataLvl() {
		return klataLvl;
	}

	public void setKlataLvl(int klataLvl) {
		this.klataLvl = klataLvl;
	}

	public int getSpodnieLvl() {
		return spodnieLvl;
	}

	public void setSpodnieLvl(int spodnieLvl) {
		this.spodnieLvl = spodnieLvl;
	}

	public int getButyLvl() {
		return butyLvl;
	}

	public void setButyLvl(int butyLvl) {
		this.butyLvl = butyLvl;
	}

	public int getUz_instor() {
		return uz_instor;
	}

	public void setUz_instor(int uz_instor) {
		this.uz_instor = uz_instor;
	}

	public int getUz_forter() {
		return uz_forter;
	}

	public void setUz_forter(int uz_forter) {
		this.uz_forter = uz_forter;
	}

	public int getUz_proter() {
		return uz_proter;
	}

	public void setUz_proter(int uz_proter) {
		this.uz_proter = uz_proter;
	}

	public int getUz_pread() {
		return uz_pread;
	}

	public void setUz_pread(int uz_pread) {
		this.uz_pread = uz_pread;
	}

	public Frakcja getFrakcja() {
		return frakcja;
	}

	public void setFrakcja(Frakcja frakcja) {
		this.frakcja = frakcja;
	}

	public boolean isTeleporting() {
		return isTeleporting;
	}

	public void setTeleporting(boolean isTeleporting) {
		this.isTeleporting = isTeleporting;
	}

	public Walka getWalka() {
		return walka;
	}

	public Menu getMenu() {
		return menu;
	}
	
    
}