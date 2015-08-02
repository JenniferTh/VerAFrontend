package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 * Created by Malte on 06.07.2015.
 */
public class BeitragDAO {

    Connection connection;

    PreparedStatement deleteArticle;
    PreparedStatement createArticle;
    PreparedStatement updateArticle;
    PreparedStatement searchArticle;
    PreparedStatement getArticleFromUser;
    PreparedStatement getAllArticlesWithUsernames;
    PreparedStatement getArticle;
    PreparedStatement getAllComments;
    

    String sqlGetArticle;
    String sqlCreateArticle;
    String sqlGetAllArticlesWithUsernames;
    String sqlDeleteArticle;
    String sqlUpdateArticle;
    String sqlSearchArticle;
    String sqlGetArticleFromUser;
    String sqlGetAllComments;
    ResultSet rs;

    
    public BeitragDAO(){
        connection = new DBConnection().getConnection();
        createPreparedStatements();
    }

    //TODO Beitrag editierbar machen
    private void createPreparedStatements(){
        sqlGetArticle = "SELECT b.*, u.Benutzername FROM dbwebanw_sose15_07.Beitrag AS b INNER JOIN Benutzer AS u ON b.Mitgliedsnummer = u.Mitgliedsnummer where b.Beitrag_ID = ?";
    	sqlCreateArticle = "INSERT INTO Beitrag(Titel, Kategorie, Inhalt) VALUES(?, ?, ?)";
        sqlDeleteArticle = "DELETE FROM Beitrag WHERE Beitrag_ID =?";
        sqlUpdateArticle = "UPDATE Beitrag SET Titel=?, Inhalt = ? where Beitrag_ID = ? ";
        sqlGetAllArticlesWithUsernames = "SELECT bt.Beitrag_ID, bt.Titel, bt.Kategorie, bt.Inhalt, bt.Erstellungsdatum, bt.Mitgliedsnummer, bn.Benutzername FROM dbwebanw_sose15_07.Beitrag AS bt JOIN Benutzer AS bn WHERE bt.Mitgliedsnummer = bn.Mitgliedsnummer Order by Beitrag_ID";
        sqlSearchArticle = "SELECT * FROM Beitrag where Beitrag.Titel like ?";
        sqlGetArticleFromUser ="Select * FROM Beitrag WHERE Mitgliedsnummer =?";
        sqlGetAllComments = "SELECT c.*, b.Benutzername FROM dbwebanw_sose15_07.Beitragskommentar as c INNER JOIN Benutzer as b ON c.Benutzer_Mitgliedsnummer = b.Mitgliedsnummer where Beitrag_ID = ? order by Erstellungsdatum DESC;";
        try {
            this.createArticle = this.connection.prepareStatement(sqlCreateArticle);
            this.deleteArticle = this.connection.prepareStatement(sqlDeleteArticle);
            this.updateArticle = this.connection.prepareStatement(sqlUpdateArticle);
            this.getAllArticlesWithUsernames= this.connection.prepareStatement(sqlGetAllArticlesWithUsernames);
            this.searchArticle = this.connection.prepareStatement(sqlSearchArticle);
            this.getArticleFromUser = this.connection.prepareStatement(sqlGetArticleFromUser);
            this.getArticle = this.connection.prepareStatement(sqlGetArticle);
            this.getAllComments = this.connection.prepareStatement(sqlGetAllComments);
        } catch (SQLException e) {
            System.out.println("Error while creating prepared Statements");
            e.printStackTrace();
        }
    }
    
    public Article getArticle(int articleID){
    	ResultSet tempRS;
    	ResultSet tempRS2;
    	Article article = new Article();
    	String thema, info, kategorie, author,date;
    	int userID;
    	try {
			getArticle.setInt(1, articleID);
			System.out.println("Hallo");
			getAllComments.setInt(1, articleID);
			tempRS = getArticle.executeQuery();
			tempRS2 = getAllComments.executeQuery();
			while(tempRS.next()){
				thema= tempRS.getString(2);
				info=tempRS.getString(4);
				kategorie=tempRS.getString(3);
				userID=tempRS.getInt(6);
				author=tempRS.getString(7);
				article = new Article(thema, kategorie, info, userID, author, articleID);
			}
			while(tempRS2.next()){
				info=tempRS2.getString(3);
				author=tempRS2.getString(6);
				date=tempRS2.getString(1);
				article.insertComment(new Comment(date,author,info));
			}
			return article;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			article=null;
			e.printStackTrace();
			return article;
		}
    }
    
    public void createArticle(String Titel, String Kategorie, String Inhalt){
        //TODO create method to enable the user to create an article with the desired title and content

        try {
            createArticle.setString( 1, Titel );
            createArticle.setString( 2, Kategorie );
            createArticle.setString(3, Inhalt);
            createArticle.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("BeitragDAO konnte nicht erstellt werden du Lauch");
            e.printStackTrace();
        }
    }

    public void deleteArticle(int beitragID){
        try {
            deleteArticle.setInt(1, beitragID);
            deleteArticle.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Artikel konnte nicht gelöscht werden du Lauch");
            e.printStackTrace();
        }
    }


    public void updateArticle(int Beitrags_ID, String Titel, String Kategorie, String Inhalt){

        try {
        	updateArticle.setInt(1, Beitrags_ID);
            updateArticle.setString(1, Titel);
            updateArticle.setString(2, Kategorie);
            updateArticle.setString(3, Inhalt);
            updateArticle.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Article> searchArticle(String term){
    	List<Article> beitraglist = new ArrayList<Article>();
    	String titel;
    	String kategorie;
    	try {
        	searchArticle.setString(1, "%" + term + "%");
    		rs = searchArticle.executeQuery();
    		
    		while(rs.next()){
				titel = rs.getString(2);
				kategorie = rs.getString(3);
				
				beitraglist.add(new Article(titel, kategorie));
			}
    		
    		return beitraglist;
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			beitraglist = null;
			return beitraglist;
		}
    }
    
    
    public List<Article> getArticleFromUser(int mitgliedsnummer){
    	try {
    		ResultSet articleFromUserRS;
    		List<Article> articleFromUserList = new ArrayList<Article>();
    		
			getArticleFromUser.setInt(1, mitgliedsnummer);
			articleFromUserRS = getArticleFromUser.executeQuery();
			
			while(articleFromUserRS.next()){
				String title = articleFromUserRS.getString(2);
				String category = articleFromUserRS.getString(3);
				String content= articleFromUserRS.getString(4);
				int userID  = articleFromUserRS.getInt(6);
				articleFromUserList.add(new Article(title, category, content, userID));
			}
			
			return articleFromUserList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    public List<Article> getAllArticles(){
    	ResultSet tempRS;
    	List<Article> articleList = new ArrayList<Article>();
    	Article article;
    	String thema, info, kategorie, author;
    	int userID, articleID;
    	try {
			tempRS = getAllArticlesWithUsernames.executeQuery();
			while(tempRS.next()){
				articleID = tempRS.getInt(1);
				thema= tempRS.getString(2);
				info=tempRS.getString(4);
				kategorie=tempRS.getString(3);
				userID=tempRS.getInt(6);
				author=tempRS.getString(7);
				article = new Article(thema, kategorie, info, userID, author, articleID);
				articleList.add(article);
			}
			return articleList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			articleList=null;
			e.printStackTrace();
			return articleList;
		}
    }

}
