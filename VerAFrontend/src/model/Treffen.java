package model;
import java.util.*;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

public class Treffen {
	private String thema, info, kategorie, ort, uhrzeit, datum;
	private int maxTeilnehmer, treffenID;
	private Vector<Integer> teilnehmer = new Vector<Integer>(); 

	
	public Treffen(String thema, String info, String kategorie, String ort, String uhrzeit, int maxTeilnehmer) {
		this.thema = thema;
		this.info = info;
		this.kategorie = kategorie;
		this.ort = ort;
		this.uhrzeit = uhrzeit;
		this.maxTeilnehmer = maxTeilnehmer;
	}
	public Treffen(String thema, String info, String kategorie, String ort, String uhrzeit, int maxTeilnehmer, String datum) {
		this.thema = thema;
		this.info = info;
		this.kategorie = kategorie;
		this.ort = ort;
		this.uhrzeit = uhrzeit;
		this.datum = datum;
		this.maxTeilnehmer = maxTeilnehmer;
	}
	public Treffen(String thema, String info, String kategorie, String ort, String uhrzeit, int maxTeilnehmer, String datum, int treffenID) {
		this.thema = thema;
		this.info = info;
		this.kategorie = kategorie;
		this.ort = ort;
		this.uhrzeit = uhrzeit;
		this.datum = datum;
		this.maxTeilnehmer = maxTeilnehmer;
		this.treffenID = treffenID;
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
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public Vector<Integer> getTeilnehmer() {
		return teilnehmer;
	}
	public void setTeilnehmer(Vector<Integer> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}
	public void insertTeilnehmer(int i){
		this.teilnehmer.add(i);
	}
	public int getAmountOfTeilnehmer(){
		return this.teilnehmer.size();
	}
}
