package service;
import java.sql.ResultSet;

import database.UserDAO;

public class userFinderService {
	UserDAO user = new UserDAO();
	
	public boolean loginSuccess(String username, String password){
		if(username == null || password == null){
			return false;
		}
		return user.login(username, password);
	}
	
	public int getUserID(String username){
		return user.getUser(username);
	}

	public int getLevel(int userID) {
		return user.getLevel(userID);
	}
}