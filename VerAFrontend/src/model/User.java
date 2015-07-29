package model;

import java.sql.ResultSet;

public class User {
	String username;
	String mailAdress;
	int status;
	
	public User(String username, String mailAdress, int status) {
		super();
		this.username = username;
		this.mailAdress = mailAdress;
		this.status = status;
		this.allArticles = allArticles;
	}
	
	ResultSet allArticles;
	ResultSet lastComments;
	//Nachricht schreiben

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}

	public String getMailAdress() {
		return mailAdress;
	}

	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ResultSet getLastArticles() {
		return allArticles;
	}

	public void setLastArticles(ResultSet allArticles) {
		this.allArticles = allArticles;
	}
	
	public ResultSet searchUser(){
		return null;
	}
	
}
