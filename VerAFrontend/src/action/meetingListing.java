package action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import model.Treffen;

public class meetingListing extends ActionSupport implements SessionAware{
	List<Treffen> meetings = new LinkedList<Treffen>();
	private static final long serialVersionUID = 1L;

	public String execute(){
		
		return SUCCESS;
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
