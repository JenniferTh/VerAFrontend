package action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import model.Article;
import service.ArticleFinderService;


public class ArticleView extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private Article article = new Article();
	private int artcID;
	private String grr;
	private ArticleFinderService articleFinder = new ArticleFinderService();

	public String execute(){
		System.out.println("Hallo");
		System.out.println(artcID);
		this.article = articleFinder.getArticle(artcID);
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

	public int getArtcID() {
		return artcID;
	}

	public void setArtcID(int articleID) {
		this.artcID = articleID;
	}

	public ArticleFinderService getArticleFinder() {
		return articleFinder;
	}

	public void setArticleFinder(ArticleFinderService articleFinder) {
		this.articleFinder = articleFinder;
	}

	public String getGrr() {
		return grr;
	}

	public void setGrr(String grr) {
		this.grr = grr;
	}

}
