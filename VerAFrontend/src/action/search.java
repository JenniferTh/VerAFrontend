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
			//System.out.println(getOption(suchoption));
			if(suchoption.equals("Beitrag")){
				bl =suche.searchArticle(term);
				for(int i = 0; i<bl.size() ; i++){
					session.put("Username", bl.get(i).getTitle());
					session.put("Kategorie", bl.get(i).getCategory());
				}
				
			}else if(suchoption.equals("User")){
				ul =search.searchUser(term);
				for(int i = 0; i<ul.size() ; i++){
					System.out.println(ul.get(i).getUsername());
					System.out.println(ul.get(i).getMailAdress());
				}
			}else{
					System.out.println("fuck...");
			}
			
			return "success";
		}else{
			return "fail";
		}
		
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
}
