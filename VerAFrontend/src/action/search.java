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
	private List<User> userList= new ArrayList<User>();
	private List<Article> articleList = new ArrayList<Article>();
	private BeitragDAO searchArticle = new BeitragDAO();
	private UserDAO searchUser = new UserDAO();
	
	public String execute(){
		if(term!=null){
			if(suchoption.equals("Beitrag")){
				articleList =searchArticle.searchArticle(term);
				return "article";	
			}else if(suchoption.equals("User")){	
				userList = searchUser.searchUser(term);
				System.out.println(userList.get(0).getUsername());
				return "user";
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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> ul) {
		this.userList = ul;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> bl) {
		this.articleList = bl;
	}

	public ResultSet getResSet() {
		return resSet;
	}

	public void setResSet(ResultSet resSet) {
		this.resSet = resSet;
	}
	public SessionMap<String,Object> getSession() {
		return session;
	}

	public void setSession(SessionMap<String,Object> session) {
		this.session = session;
	}


	public BeitragDAO getSuche() {
		return searchArticle;
	}


	public void setSuche(BeitragDAO suche) {
		this.searchArticle = suche;
	}


	public UserDAO getSearch() {
		return searchUser;
	}


	public void setSearch(UserDAO search) {
		this.searchUser = search;
	}
}
