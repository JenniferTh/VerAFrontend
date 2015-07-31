package action;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import service.userFinderService;

public class login extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private String username, password;
	private String infoMessage = "Bitte einloggen";
	private userFinderService userFinder = new userFinderService();
	private SessionMap<String, Object> session;
	
	public String execute(){
		
		System.out.println(getUsername());
		System.out.println(getPassword());
		if(this.userFinder.loginSuccess(username, password)){
			session.put("user", this.username);
			
			return SUCCESS;
		}else{
			setInfoMessage("Ein Fehler ist aufgetreten");
			return ERROR;
		}
	}
	@Override
	public void validate(){
		if(StringUtils.isEmpty(this.username)){
			addFieldError("username", "Bitte gib deinen Benutzernamen ein");
			setInfoMessage("Ein Fehler ist aufgetreten");
		}
		if(StringUtils.isEmpty(this.password)){
			addFieldError("password", "Bitte gib dein Passwort ein");
			setInfoMessage("Ein Fehler ist aufgetreten");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInfoMessage() {
		return infoMessage;
	}

	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}
	public userFinderService getUserFinder() {
		return userFinder;
	}
	public void setUserFinder(userFinderService userFinder) {
		this.userFinder = userFinder;
	}
	@Override
	public void setSession(Map<String, Object> map) {
		session = (SessionMap<String, Object>) map;
		
	}
	public SessionMap<String, Object> getSession() {
		return session;
	}
	public void setSession(SessionMap<String, Object> session) {
		this.session = session;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}