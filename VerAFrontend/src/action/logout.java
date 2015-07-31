package action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class logout extends ActionSupport implements SessionAware {
	private SessionMap<String, Object> session;
	private static final long serialVersionUID = 1L;
	private login login = new login();
	
	public String execute(){
		session.invalidate();
		login.setInfoMessage("Bitte einloggen");
		login.setPassword("");
		login.setUsername("");
		return SUCCESS;
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

}
