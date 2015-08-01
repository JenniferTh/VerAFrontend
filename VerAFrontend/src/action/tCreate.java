package action;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import database.BeitragDAO;
import database.MeetingDAO;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionSupport;


public class tCreate extends ActionSupport implements SessionAware, ParameterAware {

	private static final long serialVersionUID = 1L;
	private String thema;
	private String ort;
	private int abt_l_ID;
	private int maxT;
	private String kategorie;
	private Date datum;
	private String info;
	private SessionMap<String,Object> session;
	private Map<String, String[]> param = new HashMap<String, String[]>();
	
	public String execute(){
		MeetingDAO meeting = new MeetingDAO();
		System.out.println(getThema());
		this.kategorie = this.param.get("kategorie")[0];
		System.out.println(kategorie);
		System.out.println(getOrt());
		System.out.println(getAbt_l_ID());
		System.out.println(getMaxT());
		System.out.println(getDatum());
		System.out.println(getInfo());
		//meeting.createMeeting(thema, ort, abt_l_ID, maxT, kategorie, datum, info);
		session.put("Thema", this.thema);
		session.put("Ort", this.ort);
		session.put("Abteilungsleiter ID", this.abt_l_ID);
		session.put("MaxT", this.maxT);
		session.put("Kategorie", this.kategorie);
		session.put("Datum", this.datum);
		session.put("Info", this.info);
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

	public int getAbt_l_ID() {
		return 1234;
	}

	public void setAbt_l_ID(int abt_l_ID) {
		this.abt_l_ID = 1234;
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

	public Date getDatum() {
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    this.datum=sqlDate;
		return datum;
	}

	public void setDatum(Date datum) {
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
