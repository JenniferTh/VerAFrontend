package action;
import java.util.Map;
import service.*;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class PostComment extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private String commentary;
	private int articleID, mitgliedsnummer;
	private ArticleFinderService articleFinder = new ArticleFinderService();

	public String execute(){
		articleFinder.setComment(mitgliedsnummer, commentary, articleID);
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub	

	}
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articalID) {
		this.articleID = articalID;
	}
	public ArticleFinderService getArticleFinder() {
		return articleFinder;
	}
	public void setArticleFinder(ArticleFinderService articleFinder) {
		this.articleFinder = articleFinder;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the mitgliedsnummer
	 */
	public int getMitgliedsnummer() {
		return mitgliedsnummer;
	}
	/**
	 * @param mitgliedsnummer the mitgliedsnummer to set
	 */
	public void setMitgliedsnummer(int mitgliedsnummer) {
		this.mitgliedsnummer = mitgliedsnummer;
	}

}
