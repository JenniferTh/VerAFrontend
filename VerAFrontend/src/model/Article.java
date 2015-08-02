package model;

import java.util.LinkedList;
import java.util.List;

public class Article {
	private String author;
	private String title;
	private String category;
	private String content;
	private int userID;
	private int articleID;
	private List<Comment> comments = new LinkedList<Comment>();
	
	public Article(){}
	public Article(String title, String category, String content, int userID, String author, int articleID) {
		this.title = title;
		this.category = category;
		this.content = content;
		this.userID = userID;
		this.author = author;
		this.setArticleID(articleID);
	}
	public Article(String title, String category, String content, int userID, String author) {
		this.title = title;
		this.category = category;
		this.content = content;
		this.userID = userID;
		this.author = author;
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
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public void insertComment(Comment comment){
		this.comments.add(comment);
	}
}
