package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.User;

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
	PreparedStatement loginStatement;
	PreparedStatement getUserStatement;
	PreparedStatement searchUserStatement;


    //SQL Querys erstellen
    String sqlLogin;
    String sqlLogout;
    String sqlGetLevel;
    String sqlSetLevel;
    String sqlDeleteUser;
    String sqlCreateNewUser;
    String sqlGetUser;
    String sqlSearchUser;

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
        sqlLogin = "SELECT * " + "FROM Benutzer WHERE Benutzername=? AND Passwort=?";
        sqlLogout = "UPDATE Benutzer SET LoggedIn= ? where Benutzername= ?";
        sqlGetLevel = "SELECT Level FROM Benutzer WHERE Mitgliedsnummer = ?";
        sqlSetLevel = "UPDATE Benutzer SET Level= ? where Mitgliedsnummer= ?";
        sqlDeleteUser = "DELETE FROM Benutzer where Mitgliedsnummer= ?";
        sqlGetUser = "SELECT * FROM dbwebanw_sose15_07.Benutzer where Benutzer.Mitgliedsnummer = ?";
        sqlSearchUser = "SELECT * FROM Benutzer where Benutzer.Benutzername like ?";
        try {
            this.createUser = this.connection.prepareStatement(sqlCreateNewUser);
            this.logout = this.connection.prepareStatement(sqlLogout);
            this.getLevel = this.connection.prepareStatement(sqlGetLevel);
            this.setLevel = this.connection.prepareStatement(sqlSetLevel);
            this.deleteUser = this.connection.prepareStatement(sqlDeleteUser);
            this.loginStatement = this.connection.prepareStatement(sqlLogin);
            this.getUserStatement = this.connection.prepareStatement(sqlGetUser);
            this.searchUserStatement = this.connection.prepareStatement(sqlSearchUser);
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
    
    public User getUser(int id){
		String userName = null;
		String mail = null;
		int status = 0;
		//ResultSet lastArticles = null;
		
    	
    	//Daten in ein Resultset packen
    	try {
			this.getUserStatement.setInt(1, id);
			rs = getUserStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
			while (rs.next()) {
			    userName = rs.getString(2);
			    mail = rs.getString(3);
			    status = rs.getInt(4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        User user = new User(userName, mail, status);
    	return user;
    }

    public boolean login(String username, String password) {
    	boolean loginCorrect = false;
		try {
			this.loginStatement.setString(1, username);
			this.loginStatement.setString(2, password);
			final ResultSet resultSet = this.loginStatement.executeQuery();
			loginCorrect = resultSet.next();
		} catch (SQLException e) {
			System.err.println("Usage of prepared Statement failed :-/");
		}
		return loginCorrect;
    }


    //Methode zum ausloggen des Users
    //Eigentlich nicht nötig da die session in der Action Klasse gehandelt wird
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
    
    public List<User> searchUser(String term){
		List<User> userlist = new ArrayList<User>();
		String username;
		String mailadress;
		int level;
		try {
			searchUserStatement.setString(1, "%" + term + "%");
			rs = searchUserStatement.executeQuery();
			
			while(rs.next()){
				username = rs.getString(2);
				mailadress = rs.getString(3);
				level = rs.getInt(4);
				
				userlist.add(new User(username, mailadress, level));
			}
    		return userlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			userlist = null;
			return userlist;
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
