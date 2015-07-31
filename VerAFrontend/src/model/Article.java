package model;

public class Article {
	private String author;
	private String title;
	private String category;
	private String content;
	private int userID;
	
	
	public Article(String title, String category, String content, int userID, String author) {
		this.title = title;
		this.category = category;
		this.content = content;
		this.userID = userID;
		this.author = author;
		System.out.println(author);
		System.out.println(title);
	}
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String username) {
		this.author = username;
	}
}
