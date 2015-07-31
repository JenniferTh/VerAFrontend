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


    String sqlCreateArticle;
    String sqlDeleteArticle;
    String sqlUpdateArticle;
    String sqlSearchArticle;
    String sqlGetArticleFromUser;
    
    public BeitragDAO(){
        connection = new DBConnection().getConnection();
        createPreparedStatements();
    }

    //TODO Beitrag editierbar machen
    private void createPreparedStatements(){
        sqlCreateArticle = "INSERT INTO Beitrag(Titel, Kategorie, Inhalt) VALUES(?, ?, ?)";
        sqlDeleteArticle = "DELETE FROM Beitrag WHERE Beitrag_ID =?";
        sqlUpdateArticle = "UPDATE Beitrag SET Titel=?, Inhalt = ? where Beitrag_ID = ? ";
        sqlSearchArticle = "SELECT * FROM Beitrag where Beitrag.Titel like %?% or Beitrag.Titel = %?%";
        sqlGetArticleFromUser ="Select * FROM Beitrag WHERE Mitgliedsnummer =?";
        try {
            this.createArticle = this.connection.prepareStatement(sqlCreateArticle);
            this.deleteArticle = this.connection.prepareStatement(sqlDeleteArticle);
            this.updateArticle = this.connection.prepareStatement(sqlUpdateArticle);
            this.searchArticle = this.connection.prepareStatement(sqlSearchArticle);
            this.getArticleFromUser = this.connection.prepareStatement(sqlGetArticleFromUser);

        } catch (SQLException e) {
            System.out.println("Error while creating prepared Statements");
            e.printStackTrace();
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


    public void updateArticle(String Titel, String Inhalt,int Mitgliedsnummer){

        try {
            updateArticle.setString(1, Titel);
            updateArticle.setString(2, Inhalt);
            updateArticle.setInt(3, Mitgliedsnummer);
            updateArticle.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Article> searchArticle(String term){
    	ResultSet articleRS;
		List<Article> articleList = new ArrayList<Article>();

    	
    	try {
        	searchArticle.setString(1, term);
    		searchArticle.setString(2, term);
    		articleRS = searchArticle.executeQuery();
    		
			while(articleRS.next()){
				String title = articleRS.getString(2);
				String category = articleRS.getString(3);
				String content= articleRS.getString(4);
				int userID  = articleRS.getInt(6);
				articleList.add(new Article(title, category, content, userID));
			}
    		
    		return articleList;
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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

}
