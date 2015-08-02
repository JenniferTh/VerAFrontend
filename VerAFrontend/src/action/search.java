package action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.dispatcher.SessionMap;

import database.BeitragDAO;
import database.UserDAO;
import model.*;

public class search {
	
	private String term;
	private String infoMessage;
	private ResultSet resSet;
	private String suchoption;
	private SessionMap<String,Object> session;
	private List<User> ul= new ArrayList<User>();
	private List<Article> bl = new ArrayList<Article>();
	
	public String execute(){
		if(term!=null){
			BeitragDAO suche = new BeitragDAO();
			UserDAO search = new UserDAO();
			System.out.println(getTerm());
			System.out.println(getSuchoption());
			if(suchoption.equals("Beitrag")){
				bl =suche.searchArticle(term);
				return "beitrag";	
			}else if(suchoption.equals("User")){	
				ul = search.searchUser(term);
				System.out.println(ul.get(0).getUsername());
				return "success";
			}
		}
		return "fail";
		
	}
	
	
	public String getTerm(){
		return term;
	}
	
	public void setTerm(String term){
		this.term = term;
	}

	public String getInfoMessage() {
		return infoMessage;
	}

	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}
	
	public String getSuchoption(){
		return suchoption;
	}
	
	public void setSuchoption(String suchoption){
		this.suchoption=suchoption;
	}
	
	public String getOption(String suchoption){
		if(suchoption == "User"){
		return "user";
		}else if(suchoption == "Beitrag"){
			return "beitrag";
		}else{
			return "fuck";
		}
	}


	/**
	 * @return the ul
	 */
	public List<User> getUl() {
		return ul;
	}


	/**
	 * @param ul the ul to set
	 */
	public void setUl(List<User> ul) {
		this.ul = ul;
	}


	/**
	 * @return the bl
	 */
	public List<Article> getBl() {
		return bl;
	}


	/**
	 * @param bl the bl to set
	 */
	public void setBl(List<Article> bl) {
		this.bl = bl;
	}


	/**
	 * @return the resSet
	 */
	public ResultSet getResSet() {
		return resSet;
	}


	/**
	 * @param resSet the resSet to set
	 */
	public void setResSet(ResultSet resSet) {
		this.resSet = resSet;
	}


	/**
	 * @return the session
	 */
	public SessionMap<String,Object> getSession() {
		return session;
	}


	/**
	 * @param session the session to set
	 */
	public void setSession(SessionMap<String,Object> session) {
		this.session = session;
	}
}
