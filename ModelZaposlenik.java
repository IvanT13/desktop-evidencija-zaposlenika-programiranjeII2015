package model;

import java.io.Serializable;

public class ModelZaposlenik implements Serializable {

	/**
	 * 
	 */
	private String imeZaposlenika;
	private String prezimeZaposlenika;
	private String spolZaposlenika;
	private String oibZaposlenika;
	private int danRodjenja;
	private int mjesecRodjenja;
	private int godinaRodjenja;
	private String strucnaSpremaZaposlenika;
	private double mjesecnaPlaca;
	private String pozicijaUTvrtki;
	
	
	public String getImeZaposlenika() {
		return imeZaposlenika;
	}
	public void setImeZaposlenika(String imeZaposlenika) {
		this.imeZaposlenika = imeZaposlenika;
	}
	public String getPrezimeZaposlenika() {
		return prezimeZaposlenika;
	}
	public void setPrezimeZaposlenika(String prezimeZaposlenika) {
		this.prezimeZaposlenika = prezimeZaposlenika;
	}
	public String getSpolZaposlenika() {
		return spolZaposlenika;
	}
	public void setSpolZaposlenika(String spolZaposlenika) {
		this.spolZaposlenika = spolZaposlenika;
	}
	
	public String getOibZaposlenika() {
		return oibZaposlenika;
	}
	public void setOibZaposlenika(String oibZaposlenika) {
		this.oibZaposlenika = oibZaposlenika;
	}
	public int getDanRodjenja() {
		return danRodjenja;
	}
	public void setDanRodjenja(int danRodjenja) {
		this.danRodjenja = danRodjenja;
	}
	public int getMjesecRodjenja() {
		return mjesecRodjenja;
	}
	public void setMjesecRodjenja(int mjesecRodjenja) {
		this.mjesecRodjenja = mjesecRodjenja;
	}
	public int getGodinaRodjenja() {
		return godinaRodjenja;
	}
	public void setGodinaRodjenja(int godinaRodjenja) {
		this.godinaRodjenja = godinaRodjenja;
	}

	public String getStrucnaSpremaZaposlenika() {
		return strucnaSpremaZaposlenika;
	}
	public void setStrucnaSpremaZaposlenika(String strucnaSpremaZaposlenika) {
		this.strucnaSpremaZaposlenika = strucnaSpremaZaposlenika;
	}
	public double getMjesecnaPlaca() {
		return mjesecnaPlaca;
	}
	public void setMjesecnaPlaca(double mjesecnaPlaca) {
		this.mjesecnaPlaca = mjesecnaPlaca;
	}
	public String getPozicijaUTvrtki() {
		return pozicijaUTvrtki;
	}
	public void setPozicijaUTvrtki(String pozicijaUTvrtki) {
		this.pozicijaUTvrtki = pozicijaUTvrtki;
	}
	
	
}
