package action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import service.meetingFinderService;

public class JoinMeeting extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String username;
	private int meetingID, mitgliedsnummer;
	private meetingFinderService meetingFinder = new meetingFinderService();
	
	public String execute(){
		System.out.println(mitgliedsnummer);
		System.out.println(meetingID);
		if(meetingFinder.joinMetting(mitgliedsnummer, meetingID)){
			return SUCCESS;
		}
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public int getMeetingID() {
		return meetingID;
	}

	public void setMeetingID(int meetingID) {
		this.meetingID = meetingID;
	}

	public int getMitgliedsnummer() {
		return mitgliedsnummer;
	}

	public void setMitgliedsnummer(int mitgliedsnummer) {
		this.mitgliedsnummer = mitgliedsnummer;
	}

}
