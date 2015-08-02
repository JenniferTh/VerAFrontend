package service;

import java.util.List;
import database.*;
import model.*;

public class ArticleFinderService {
	BeitragDAO articles = new BeitragDAO();
	BeitragskommentarDAO comment = new BeitragskommentarDAO();
	
	public List<Article> getArticle(){
		return articles.getAllArticles();
	}
	public Article getArticle(int articleID){
		return articles.getArticle(articleID);
	}
	public void setComment(int mitgliedsnummer, String Kommentar, int Beitrags_ID){
		comment.createArticleComment(mitgliedsnummer, Kommentar, Beitrags_ID);
	}
}

