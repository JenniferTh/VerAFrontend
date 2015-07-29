package action;

import service.userFinderService;

public class login {
	private String username;
	private String password;
	private String infoMessage = "Bitte einloggen";
	
	public String execute(){
		userFinderService userFinder = new userFinderService();
		System.out.println(getUsername());
		System.out.println(getPassword());
		if(userFinder.loginSuccess(username, password)){
			return "success";
		}else if(this.infoMessage.equals("Bitte einloggen")){
			return "login";
		}else{		
			setInfoMessage("Der login ist fehlgeschlagen");
			return "error";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInfoMessage() {
		return infoMessage;
	}

	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}
}