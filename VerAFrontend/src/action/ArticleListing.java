
package action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import model.Article;
import service.*;

public class ArticleListing extends ActionSupport implements SessionAware{
	private List<Article> articles = new LinkedList<Article>();
	private static final long serialVersionUID = 1L;
	private ArticleFinderService articleFinder = new ArticleFinderService();

	
	public String execute(){
		System.out.println("hallo");
		setArticles(articleFinder.getArticle());
		if(articles.isEmpty()){
			return ERROR;
		}else{return SUCCESS;}
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

