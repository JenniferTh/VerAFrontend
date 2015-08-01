package model;

import java.sql.ResultSet;

public class User {
	private String username;
	private String mailAdress;
	private int level;
	private ResultSet allArticles;
	private ResultSet lastComments;
	//Nachricht schreiben

	
	public User(String username, String mailAdress) {
		super();
		this.username = username;
		this.mailAdress = mailAdress;
	}
	public User(String username, String mailAdress, int level) {
		super();
		this.username = username;
		this.mailAdress = mailAdress;
		this.level = level;
	}

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int status) {
		this.level = status;
	}

	public ResultSet getLastArticles() {
		return allArticles;
	}

	public void setLastArticles(ResultSet allArticles) {
		this.allArticles = allArticles;
	}

	public ResultSet getLastComments() {
		return lastComments;
	}

	public void setLastComments(ResultSet lastComments) {
		this.lastComments = lastComments;
	}
	

	
}
