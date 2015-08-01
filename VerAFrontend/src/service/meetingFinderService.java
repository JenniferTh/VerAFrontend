package service;

import java.util.List;
import model.Treffen;
import database.MeetingDAO;;

public class meetingFinderService {
	MeetingDAO meetings = new MeetingDAO();
	
	public List<Treffen> getTreffen(){
		return meetings.getAllMeetings();
	}
	public boolean joinMetting(int mitgliedsnummer, int treffenID){
		return meetings.joinMeeting(mitgliedsnummer, treffenID);
	}
}

