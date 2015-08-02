package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Article;
import model.User;

/**
 * Created by Malte on 06.07.2015.
 */
public class BeitragDAO {

    Connection connection;

    PreparedStatement deleteArticle;
    PreparedStatement createArticle;
    PreparedStatement updateArticle;
    PreparedStatement searchArticle;


    String sqlCreateArticle;
    String sqlDeleteArticle;
    String sqlUpdateArticle;
    String sqlSearchArticle;
    
    ResultSet rs;
    
    public BeitragDAO(){
        connection = new DBConnection().getConnection();
        createPreparedStatements();
    }

    //TODO Beitrag editierbar machen

    private void createPreparedStatements(){
        sqlCreateArticle = "INSERT INTO Beitrag(Titel, Kategorie, Inhalt) VALUES(?, ?, ?)";
        sqlDeleteArticle = "DELETE FROM Beitrag WHERE Beitrag_ID =?";
        sqlUpdateArticle = "UPDATE Beitrag SET Titel=?, Inhalt = ? where Beitrag_ID = ? ";
        sqlSearchArticle = "SELECT * FROM Beitrag where Beitrag.Titel like ?";
        try {
            this.createArticle = this.connection.prepareStatement(sqlCreateArticle);
            this.deleteArticle = this.connection.prepareStatement(sqlDeleteArticle);
            this.updateArticle = this.connection.prepareStatement(sqlUpdateArticle);
            this.searchArticle = this.connection.prepareStatement(sqlSearchArticle);

        } catch (SQLException e) {
            System.out.println("Error while creating prepared Statements");
            e.printStackTrace();
        }
    }

    public void createArticle(String Titel, String Kategorie, String Inhalt){
        //TODO create method to enable the user to create an article with the desired title and content

        try {
            createArticle.setString( 1, Titel);
            createArticle.setString( 2, Kategorie);
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

}
