package net.db.vera.entities;

import net.db.vera.DBConnection;

import java.sql.*;

/**
 * Created by Malte on 06.07.2015.
 */
public class UserDAO {

    //Die Verbindung wird mit null initialisiert
    private Connection connection = null;


    //PreparedStatements erstellen
    PreparedStatement createUser;
    PreparedStatement login;
    PreparedStatement logout;
    PreparedStatement getLevel;
    PreparedStatement setLevel;
    PreparedStatement deleteUser;

    //SQL Querys erstellen
    String sqlLogin;
    String sqlLogout;
    String sqlGetLevel;
    String sqlSetLevel;
    String sqlDeleteUser;
    String sqlCreateNewUser;

    //Anderer Kram
    Statement stmt = null;
    ResultSet rs;


    public UserDAO() {
        connection = new DBConnection().getConnection();
        createPreparedStatements();
    }


    /*
    * #########
    * Initialisierung aller PreparedStatements
    * #########
    */
    private void createPreparedStatements() {
        sqlCreateNewUser = "INSERT INTO Benutzer(Benutzername, Email, Level, Passwort) VALUES(?,?,?,?)";
        sqlLogin = "UPDATE Benutzer SET LoggedIn= ? where Benutzername= ?";
        sqlLogout = "UPDATE Benutzer SET LoggedIn= ? where Benutzername= ?";
        sqlGetLevel = "SELECT Level FROM Benutzer WHERE Mitgliedsnummer = ?";
        sqlSetLevel = "UPDATE Benutzer SET Level= ? where Mitgliedsnummer= ?";
        sqlDeleteUser = "DELETE FROM Benutzer where Mitgliedsnummer= ?";
        try {
            this.createUser = this.connection.prepareStatement(sqlCreateNewUser);
            this.logout = this.connection.prepareStatement(sqlLogout);
            this.login = this.connection.prepareStatement(sqlLogin);
            this.getLevel = this.connection.prepareStatement(sqlGetLevel);
            this.setLevel = this.connection.prepareStatement(sqlSetLevel);
            this.deleteUser = this.connection.prepareStatement(sqlDeleteUser);
        } catch (SQLException e) {
            System.out.println("Error while creating prepared Statements");
            e.printStackTrace();
        }
    }

    //Ein ResultSet mit allen Usern holen
    public ResultSet getAllUser() {
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from Benutzer");
            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
            rs = null;
            return rs;
        }
    }

    public void login(String username) {
        try {
            login.setInt(1, 1);
            login.setString(2, username);
            login.execute();
        } catch (SQLException e) {
            System.out.println("login update not successfull");
            e.printStackTrace();
        }
    }

    //Methode zum überprüfen, ob der Nutzername existiert
    private boolean usernameMatch(String _username) {
        return true;
    }

    //Methode zum überprüfen ob das eingegebene Passwort mit dem in der Datenbank übereinstimmt
    private boolean passwordMatch(String _passwort) {
        return true;
    }


    //Methode zum ausloggen des Users
    public void logout(String username) {
        //TODO implement method to logout the current user
        try {
            logout.setInt(1, 0);
            logout.setString(2, username);
            logout.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Logout konnte nicht durchgeführt werden du Lauch");
            e.printStackTrace();
        }
    }


    //Methode zum Registrieren eines Benutzers
    public boolean registerNewUser(String username, String mail, int level, String passwort) throws SQLException {
        try {

            createUser.setString(1, username);
            createUser.setString(2, mail);
            createUser.setInt(3, level);
            createUser.setString(4, passwort);
            createUser.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            System.out.println("Nutzer konnte nicht erstellt werden du Lauch");
            return false;
        }
    }

    //Hier bekommt der Admin die Möglichkeit einen Nutzer zu entfernen
    public void deleteUser(int mitgliedsnummer) {

        System.out.println("Einfuegen von Datensaetzen in die Tabelle...");
        try {
            deleteUser.setInt(1, mitgliedsnummer);
            deleteUser.execute();
        } catch (SQLException e) {
            System.out.println("Level update not successfull");
            e.printStackTrace();

        }
    }

    /*
    *#########
    * Bereich für getter & setter
    *#########
    */
    //Die Methode gibt das Level eines Users zurück
    public int getLevel(int mitgliedsnummer) {
        int level = 0;
        try {
            getLevel.setInt(1, mitgliedsnummer);
            getLevel.execute();

        } catch (SQLException e) {
            System.out.println("Not able to get level ;____;");
        }
        return level;

    }

    //Die Methode ermöglicht das Setzen des Levels für einen bestimmten UserDAO
    public void setLevel(int mitgliedsnummer, int level) {
        System.out.println("Inserting records into the table...");
        try {
            setLevel.setInt(1, level);
            setLevel.setInt(2, mitgliedsnummer);
            setLevel.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Level update not successfull");
            e.printStackTrace();
        }
    }

    /*
    *#########
    *Ende des getter & setter Blocks
    * Schließen der Verbindung zur Datenbank
    *#########
    */
    private void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
