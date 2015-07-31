package action;

import com.opensymphony.xwork2.ActionSupport;
import service.meetingFinderService;

public class JoinMeeting extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;
	private int meetingID = 100;
	private meetingFinderService meetingFinder = new meetingFinderService();
	
	public String execute(){
		/*if(meetingFinder.joinMetting(username, treffenID)){
			return SUCCESS;
		}*/
		System.out.println(""+meetingID);
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTreffenID() {
		return meetingID;
	}

	public void setTreffenID(int treffenID) {
		this.meetingID = treffenID;
	}

	public meetingFinderService getMeetingFinder() {
		return meetingFinder;
	}

	public void setMeetingFinder(meetingFinderService meetingFinder) {
		this.meetingFinder = meetingFinder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
