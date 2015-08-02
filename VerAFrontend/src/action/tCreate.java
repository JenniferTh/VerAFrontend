package action;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import database.MeetingDAO;
import org.apache.struts2.dispatcher.SessionMap;
import com.opensymphony.xwork2.ActionSupport;
import model.Treffen;

public class tCreate extends ActionSupport implements SessionAware, ParameterAware {

	private static final long serialVersionUID = 1L;
	private String thema;
	private String ort;
	private String uhrzeit;
	private int maxT;
	private String kategorie;
	private Date datum;
	private String date;
	private String info;
	private Treffen treffen;
	private SessionMap<String,Object> session;
	private Map<String, String[]> param = new HashMap<String, String[]>();
	
	public String execute(){
		MeetingDAO meeting = new MeetingDAO();
		System.out.println(getThema());
		this.kategorie = this.param.get("kategorie")[0];
		System.out.println(kategorie);
		System.out.println(getOrt());
		System.out.println(getUhrzeit());
		System.out.println(getMaxT());
		System.out.println(date);
		date=date.substring(6, 10)+date.substring(2, 6)+date.substring(0, 2);
		System.out.println(date);
		System.out.println(getInfo());
		meeting.createMeeting(thema, info, kategorie, ort, date, uhrzeit, maxT);
		return SUCCESS;
	}

	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public int getMaxT() {
		return maxT;
	}

	public void setMaxT(int maxT) {
		this.maxT = maxT;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getDatum() {
		Format formatter = new SimpleDateFormat("dd-MM-yyy");
		String date = formatter.format(datum);
		return date;
	}

	public void setDatum(String date) {
		this.date=date;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Map getParameters(){
        return param;
	}
	
	@Override
	public void setParameters(Map<String, String[]> param){
	    this.param = param;
	}

	public SessionMap<String,Object> getSession() {
		return session;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
