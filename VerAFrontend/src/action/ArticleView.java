package action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import model.Article;
import service.ArticleFinderService;


public class ArticleView extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private Article article = new Article();
	private int articleID = 10;
	private ArticleFinderService articleFinder = new ArticleFinderService();

	public String execute(){
		this.article = articleFinder.getArticle(10);
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public ArticleFinderService getArticleFinder() {
		return articleFinder;
	}

	public void setArticleFinder(ArticleFinderService articleFinder) {
		this.articleFinder = articleFinder;
	}

}
