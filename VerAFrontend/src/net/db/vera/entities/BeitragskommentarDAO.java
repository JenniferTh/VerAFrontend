package net.db.vera.entities;

import net.db.vera.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Malte on 06.07.2015.
 */
public class BeitragskommentarDAO {

    Connection connection;

    PreparedStatement deleteArticleComment;
    PreparedStatement createArticleComment;
    PreparedStatement updateArticleComment;


    String sqlCreateArticleComment;
    String sqlDeleteArticleComment;
    String sqlUpdateArticleComment;

    public BeitragskommentarDAO() {
        connection = new DBConnection().getConnection();
        createPreparedStatements();
    }

    private void createPreparedStatements() {
        sqlCreateArticleComment = "INSERT INTO Beitragskommentar(Benutzer_Mitgliedsnummer, Kommentar, Beitrag_ID) VALUES( ?, ?, ?)";
        sqlDeleteArticleComment = "DELETE FROM Beitragskommentar WHERE ID =?";
        sqlUpdateArticleComment = "UPDATE Beitragskommentar SET Kommentar= ? where ID = ? ";
        try {
            this.createArticleComment = this.connection.prepareStatement(sqlCreateArticleComment);
            this.deleteArticleComment = this.connection.prepareStatement(sqlDeleteArticleComment);
            this.updateArticleComment = this.connection.prepareStatement(sqlUpdateArticleComment);

        } catch (SQLException e) {
            System.out.println("Error while creating prepared Statements");
            e.printStackTrace();
        }
    }

    public void createArticleComment(int Mitgliedsnummer, String Kommentar, int Beitrags_ID) {

        try {
            createArticleComment.setInt(1, Mitgliedsnummer);
            createArticleComment.setString(2, Kommentar);
            createArticleComment.setInt(3, Beitrags_ID);
            createArticleComment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateArticleComment(String Kommentar, int Beitragskommentar_ID) {

        try {
            updateArticleComment.setString(1, Kommentar);
            updateArticleComment.setInt(2, Beitragskommentar_ID);
            updateArticleComment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteArticleComment(int Beitragskommentar_ID) {

        try {
            deleteArticleComment.setInt(1, Beitragskommentar_ID);
            deleteArticleComment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
