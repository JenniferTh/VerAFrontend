package action;

import database.BeitragDAO;

public class bCreate {

	private String Titel;
	private String Kathegorie;
	private String Inhalt;
	private int Mitgliedsnummer;
	
	public String execute(){
		
		BeitragDAO beitrag = new BeitragDAO();
		System.out.println(getTitel());
		System.out.println(getKathegorie());
		System.out.println(getInhalt());
		System.out.println(getMitgliedsnummer());
		beitrag.createArticle(Titel, Kathegorie, Inhalt, Mitgliedsnummer);
		return "bsuccess";
	}
	
	public String getTitel(){
		return Titel;
	}
	
	public void setTitel(String Titel){
		this.Titel=Titel;
	}
	
	public String getKathegorie(){
		return Kathegorie;
	}
	
	public void setKathegorie(String Kathegorie){
		this.Kathegorie=Kathegorie;
	}
	
	public String getInhalt(){
		return Inhalt;
	}
	
	public void setInhalt(String Inhalt){
		this.Inhalt=Inhalt;
	}
	
	public int getMitgliedsnummer(){
		return Mitgliedsnummer;
	}
	
	public void setMitgliedsnummer(int Mitgliedsnummer){
		this.Mitgliedsnummer=Mitgliedsnummer;
	}
	
}
