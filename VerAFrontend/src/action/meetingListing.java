package action;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import model.Treffen;

public class meetingListing extends ActionSupport implements SessionAware{
	List<Treffen> meetings;
	private static final long serialVersionUID = 1L;

	public String execute(){
		Treffen a = new Treffen(null, null, null, null, null, 0);
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
