package model;

public class Treffen {
	private String thema, info, kategorie, ort, uhrzeit;
	private int maxTeilnehmer, treffenID;

	
	public Treffen(String thema, String info, String kategorie, String ort, String uhrzeit, int maxTeilnehmer) {
		super();
		this.thema = thema;
		this.info = info;
		this.kategorie = kategorie;
		this.ort = ort;
		this.uhrzeit = uhrzeit;
		this.maxTeilnehmer = maxTeilnehmer;
		this.treffenID = 12345;
	}
	public String getThema() {
		return thema;
	}
	public void setThema(String thema) {
		this.thema = thema;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getKategorie() {
		return kategorie;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	public String getUhrzeit() {
		return uhrzeit;
	}
	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}
	public int getMaxTeilnehmer() {
		return maxTeilnehmer;
	}
	public void setMaxTeilnehmer(int maxTeilnehmer) {
		this.maxTeilnehmer = maxTeilnehmer;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public int getTreffenID() {
		return treffenID;
	}
	public void setTreffenID(int treffenID) {
		this.treffenID = treffenID;
	}
}
