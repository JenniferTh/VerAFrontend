package service;
import database.UserDAO;

public class userFinderService {
	UserDAO user = new UserDAO();
	
	public boolean loginSuccess(String username, String password){
		return user.login(username, password);
	}
}
