package action;

import java.sql.ResultSet;

import service.userFinderService;

public class SearchAction {
	
	private String term;
	private String infoMessage;
	private ResultSet resSet;
	
	public String execute(){
		
		userFinderService userFinder = new userFinderService();
		System.out.println(getTerm());
		userFinder.searchForUser(term);
		return "successSearch";
	}
	
	
	public String getTerm(){
		return term;
	}
	
	public void setTerm(String term){
		this.term = term;
	}

	public String getInfoMessage() {
		return infoMessage;
	}

	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}
}
