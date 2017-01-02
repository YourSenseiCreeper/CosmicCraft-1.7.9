package pl.gastherr.cosmic_core;

import java.util.List;

public class ServerStats {
	
	private double kasa;
	private int aktywowane_mechanizmy;

	private int uz_instor;
	private int uz_forter;
	private int uz_proter;
	private int uz_pread;
	private List<String> staff;
	
	private int l_odwiedzin;
	private int lu_odwiedzin;
	
	public ServerStats(double kasa, int aktywowane_mechanizmy, int uz_instor,
			int uz_forter, int uz_proter, int uz_pread, int l_odwiedzin,
			int lu_odwiedzin, List<String> staff) {
		super();
		this.kasa = kasa;
		this.aktywowane_mechanizmy = aktywowane_mechanizmy;
		this.uz_instor = uz_instor;
		this.uz_forter = uz_forter;
		this.uz_proter = uz_proter;
		this.uz_pread = uz_pread;
		this.l_odwiedzin = l_odwiedzin;
		this.lu_odwiedzin = lu_odwiedzin;
		this.staff = staff;
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

	public List<String> getStaff() {
		return staff;
	}

	public int getLiczbaOdwiedzin(){
		return this.l_odwiedzin;
	}
	
	public void addLiczbaOdwiedzin(){
		this.l_odwiedzin = l_odwiedzin++;
	}
	
	public int getLiczbaUnikalnychOdwiedzin(){
		return this.l_odwiedzin;
	}
	
	public void addLiczbaUnikalnychOdwiedzin(){
		this.lu_odwiedzin = lu_odwiedzin++;
	}
}