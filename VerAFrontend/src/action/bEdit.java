package action;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ParameterAware;
import database.BeitragDAO;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class bEdit extends ActionSupport implements SessionAware, ParameterAware{

	private static final long serialVersionUID = 1L;
	private String titel;
	private String kategorie;
	private String inhalt;
	private int bid;
	private SessionMap<String,Object> session;
	private Map<String, String[]> param = new HashMap<String, String[]>();
	
	public String execute(){
		
		BeitragDAO edit = new BeitragDAO();
		System.out.println(getBID());
		this.titel = this.param.get("titel")[0];
		System.out.println(titel);
		this.kategorie = this.param.get("kategorie")[0];
		System.out.println(kategorie);
		this.inhalt = this.param.get("inhalt")[0];
		System.out.println(inhalt);
		edit.updateArticle(bid, titel, kategorie, inhalt);
		session.put("BID", this.bid);
		session.put("Titel", this.titel);
		session.put("Kategorie", kategorie);
		session.put("Text", this.inhalt);
		return "success";
	}
	
	public Map getParameters(){
		return param;
	}   

	@Override
	public void setParameters(Map<String, String[]> param){
		this.param = param;
	}

	public int getBID(){
		return bid;
	}

	public void setBID(int bid){
		this.bid=bid;
	}
	
	public String getTitel(){
		return titel;
	}

	public void setTitel(String titel){
		this.titel=titel;
	}

	public String getKategorie(){
		return kategorie;
	}

	public void setKathegorie(String kategorie){
		this.kategorie=kategorie;
	}

	public String getInhalt(){
		return inhalt;
	}

	public void setInhalt(String inhalt){
		this.inhalt=inhalt;
	}

	public void setSession(Map<String, Object> map) {
		session=(SessionMap<String, Object>) map;
	}

	public SessionMap<String,Object> getSession() {
		return session;
	}

	public void setSession(SessionMap<String,Object> session) {
		this.session = session;
	}

}
