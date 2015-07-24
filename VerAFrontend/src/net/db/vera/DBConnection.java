package net.db.vera;

import java.sql.*;
import java.util.Arrays;
import java.util.List;


public class DBConnection {

    String url = "jdbc:mysql://195.37.176.178:11336/dbwebanw_sose15_07";
    String user = "dbweb_user_07";
    String pass = "LPtCLVYnSh";
    Connection connection = null;
    Statement stmt = null;


    PreparedStatement commentOnArticle;


    String sqlCommentOnArticle;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
        createPreparedStatements();
    }

    private void createPreparedStatements() {
        sqlCommentOnArticle = "INSERT INTO Beitragskommentar (Benutzer_Mitgliedsnummer, Kommentar, Beitrag_ID) VALUES (?,?,?)";
        try {
            this.commentOnArticle = this.connection.prepareStatement(sqlCommentOnArticle);

        } catch (SQLException e) {
            System.out.println("Error while creating prepared Statements");
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                this.connection.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Logout not successfull");
            }
        }
    }
}
