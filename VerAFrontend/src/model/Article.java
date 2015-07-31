package model;

public class Article {
	String title;
	String category;
	String content;
	int userID;
	
	
	
	public Article(String title, String category, String content, int userID) {
		this.title = title;
		this.category = category;
		this.content = content;
		this.userID = userID;
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
	
	
	
}
