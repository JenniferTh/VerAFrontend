package action;

import service.userFinderService;

public class login {
	private String username;
	private int userID;
	private String password;
	
	public String execute(){
		userFinderService userFinder = new userFinderService();
		System.out.println(getUsername());
		System.out.println(getPassword());
		if(userFinder.loginSuccess(username, password)){
			return "success";
		}else {
			return "error";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}