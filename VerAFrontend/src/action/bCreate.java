package action;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ParameterAware;
import database.BeitragDAO;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class bCreate extends ActionSupport implements SessionAware, ParameterAware{

	private static final long serialVersionUID = 1L;
	private String titel;
	private String kategorie;
	private String inhalt;
	private SessionMap<String,Object> session;
	private Map<String, String[]> param = new HashMap<String, String[]>();
	
	
	public String execute(){
		
		BeitragDAO beitrag = new BeitragDAO();
		System.out.println(getTitel());
		this.kategorie = this.param.get("kategorie")[0];
		System.out.println(kategorie);
		System.out.println(getInhalt());
		beitrag.createArticle(titel, kategorie, inhalt);
		session.put("Titel", this.titel);
		session.put("Kategorie", kategorie);
		session.put("Text", this.inhalt);
		return SUCCESS;
	}
	
	/*@Override
	 
	public void validate() {
		if(StringUtils.isEmpty(titel)){
			addFieldError(titel, "Bitte geben Sie einen Titel ein.");
		}if(StringUtils.isEmpty(kategorie)){
			addFieldError(kategorie, "Bitte wählen Sie eine Kategorie aus.");
		}if(StringUtils.isEmpty(inhalt)){
			addFieldError(inhalt, "Bitte schreiben Sie einen Beitrag.");
		}
	} */
	
	public Map getParameters(){
        return param;
	}   
    
	@Override
	public void setParameters(Map<String, String[]> param){
	    this.param = param;
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
