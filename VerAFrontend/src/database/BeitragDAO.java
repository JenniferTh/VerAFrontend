package database;

import java.sql.*;

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
    
    public BeitragDAO(){
        connection = new DBConnection().getConnection();
        createPreparedStatements();
    }

    //TODO Beitrag editierbar machen

    private void createPreparedStatements(){
        sqlCreateArticle = "INSERT INTO Beitrag(Titel, Kategorie, Inhalt, Abteilung_Abteilungsleiter_Mitgliedsnummer) VALUES(?, ?, ?, ?)";
        sqlDeleteArticle = "DELETE FROM Beitrag WHERE Beitrag_ID =?";
        sqlUpdateArticle = "UPDATE Beitrag SET Titel=?, Inhalt = ? where Beitrag_ID = ? ";
        sqlSearchArticle = "SELECT * FROM Beitrag where Beitrag.Titel like %?% or Beitrag.Titel = %?%";
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

    public void createArticle(String Titel, String Kategorie, String Inhalt,int Abteilung_Abteilungsleiter_Mitgliedsnummer){
        //TODO create method to enable the user to create an article with the desired title and content

        try {
            createArticle.setString( 1, Titel );
            createArticle.setString( 2, Kategorie );
            createArticle.setString(3, Inhalt);
            createArticle.setInt(4, Abteilung_Abteilungsleiter_Mitgliedsnummer);
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
    
    public ResultSet searchArticle(String term){
    	ResultSet resSet;
    	try {
        	searchArticle.setString(1, term);
    		searchArticle.setString(2, term);
    		resSet = searchArticle.executeQuery();
    		return resSet;
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resSet = null;
			return resSet;
		}
    }

}
