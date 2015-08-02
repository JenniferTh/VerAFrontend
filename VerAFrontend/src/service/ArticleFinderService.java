package service;

import java.util.List;
import database.*;
import model.*;

public class ArticleFinderService {
	BeitragDAO articles = new BeitragDAO();
	
	public List<Article> getArticle(){
		return articles.getAllArticles();
	}
	public Article getArticle(int articleID){
		return articles.getArticle(articleID);
	}
}

