
package action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import model.Treffen;
import service.meetingFinderService;

public class meetingListing extends ActionSupport implements SessionAware{
	private List<Treffen> meetings = new LinkedList<Treffen>();
	private static final long serialVersionUID = 1L;
	private meetingFinderService meetingFinder = new meetingFinderService();

	
	public String execute(){
		if(meetingFinder.getTreffen()!=null){
			setMeetings(meetingFinder.getTreffen());
			return SUCCESS;
		}else{return ERROR;}
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public List<Treffen> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Treffen> meetings) {
		this.meetings = meetings;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

