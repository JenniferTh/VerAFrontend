package model;
import database.*;

public class Article {
	private String title;
	private String category;
	private String content;
	int userID;
	private String author;
	
	
	public Article(String title, String category, String content, int userID, String user) {
		this.title = title;
		this.category = category;
		this.content = content;
		this.userID = userID;
		this.author = user;
		System.out.println(author);
	}
	public Article(String title, String category, String content, int userID) {
		this.title = title;
		this.category = category;
		this.content = content;
		this.userID = userID;
		System.out.println(author);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return author;
	}
	public void setUsername(String username) {
		this.author = username;
	}
	
	
	
}
