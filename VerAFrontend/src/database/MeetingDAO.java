package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Treffen;

/**
 * Created by Malte on 06.07.2015.
 */
public class MeetingDAO {
    Connection connection;

    PreparedStatement joinMeeting;
    PreparedStatement createMeeting;
    PreparedStatement unjoinMeeting;
    PreparedStatement getUserCount;
    PreparedStatement getUserMax;
    PreparedStatement getAllMeetings;
    PreparedStatement validateUser;
    PreparedStatement getAllParticipants;
    
    String sqlCreateMeeting;
    String sqlJoinMeeting;
    String sqlUnjoinMeeting;
    String sqlGetUserCount;
    String sqlGetUserMax;
    String sqlGetAllMeetings;
    String sqlValidateUser;
    String sqlGetAllParticipants;
    
    public MeetingDAO() {
        connection = new DBConnection().getConnection();
        createPreparedStatements();
    }
    

    private void createPreparedStatements() {
        sqlCreateMeeting = "INSERT INTO Treffen(Thema, Info, Kategorie, Ort, Datum, Uhrzeit, Teilnehmer) VALUES(?,?,?,?,?,?,?)";
        sqlJoinMeeting = "INSERT INTO Teilnehmer_eines_Treffens (Benutzer_Mitgliedsnummer, Treffen_Thema) VALUES (?,?)";
        sqlUnjoinMeeting ="DELETE FROM Teilnehmer_eines_Treffens WHERE Benutzer_Mitgliedsnummer =?";
        sqlGetUserCount = "SELECT COUNT(Treffen_ID) FROM Teilnehmer_eines_Treffens WHERE Treffen_ID=?";
        sqlGetAllMeetings ="SELECT * FROM dbwebanw_sose15_07.Treffen order by Datum DESC, Uhrzeit DESC;";
        sqlValidateUser ="SELECT * FROM dbwebanw_sose15_07.Teilnehmer_eines_Treffens WHERE Benutzer_Mitgliedsnummer = ? AND Treffen_ID = ?;";
        sqlGetAllParticipants = "SELECT * FROM dbwebanw_sose15_07.Teilnehmer_eines_Treffens;";
        try {
            this.createMeeting = this.connection.prepareStatement(sqlCreateMeeting);
            this.joinMeeting = this.connection.prepareStatement(sqlJoinMeeting);
            this.unjoinMeeting = this.connection.prepareStatement(sqlUnjoinMeeting);
            this.getAllMeetings= this.connection.prepareStatement(sqlGetAllMeetings);
            this.validateUser = this.connection.prepareStatement(sqlValidateUser);
            this.getAllParticipants = this.connection.prepareStatement(sqlGetAllParticipants);

        } catch (SQLException e) {
            System.out.println("Error while creating prepared Statements");
            e.printStackTrace();
        }
    }

    public boolean createMeeting(String thema, String info, String kategorie, String ort, Date datum ,String uhrzeit, int maxTeilnehmer) {
        try {

            createMeeting.setString(1, thema);
            createMeeting.setString(2, info);
            createMeeting.setString(3, kategorie);
            createMeeting.setString(4, ort);
            createMeeting.setDate(5, datum);
            createMeeting.setString(6, uhrzeit);
            createMeeting.setInt(7, maxTeilnehmer);
            createMeeting.executeUpdate();
            
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("MeetingDAO konnte nicht erstellt werden du Lauch");
            return false;
        }
    }

    private java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public boolean joinMeeting(int mitgliedsnummer, int treffenID) {
    	//Zuerst die maxuser aus dem treffen holen, dann die aus teilnehmer eines Treffens
    	//dann die beiden werte vergleichen
    	int userMax;
    	int userCount;
    	ResultSet tempRS;
    	try {
			getUserCount.setInt(1, treffenID);
			getUserMax.setInt(1, treffenID);
			
			tempRS = getUserMax.executeQuery();
	    	userMax = tempRS.getInt(1);
			
	    	tempRS = getUserCount.executeQuery();
	    	userCount = tempRS.getInt(1);
	    	
	    	
	    	while(tempRS.next()){
	    		if(userMax==userCount){
	    			return false;
	    		}
	    	}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
        System.out.println("Inserting records into the table...");
        try {
            joinMeeting.setInt(1, mitgliedsnummer);
            joinMeeting.setInt(2, treffenID);
            joinMeeting.executeQuery();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Anmeldung war nicht erfolgreich du Lauch");
            e.printStackTrace();
            return false;
        }
    }
    
    public void unjoinMeeting(int mitgliedsnummer){
        try {
            unjoinMeeting.setInt(1, mitgliedsnummer);
            unjoinMeeting.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("MeetingDAO konnte nicht erstellt werden du Lauch :/");
        }
    }
    
    public List<Treffen> getAllMeetings(){
    	ResultSet tempRS;
    	ResultSet tempRS2;
    	List<Treffen> meetingList = new ArrayList<Treffen>();
    	Treffen treffen;
    	String thema, info, kategorie, ort, uhrzeit, datum;
    	int maxTeilnehmer, treffenID, mitgliedsNummer;
    	try {
			tempRS = getAllMeetings.executeQuery();
			tempRS2 = getAllParticipants.executeQuery();
			
			while(tempRS.next()){
				treffenID=tempRS.getInt(1);
				thema= tempRS.getString(2);
				info=tempRS.getString(3);
				kategorie=tempRS.getString(4);
				ort=tempRS.getString(5);
				datum=tempRS.getString(6);
				uhrzeit=tempRS.getString(7);
				maxTeilnehmer=tempRS.getInt(8);
				treffen = new Treffen(thema, info, kategorie, ort, uhrzeit, maxTeilnehmer, datum, treffenID);
				meetingList.add(treffen);
			}
			while(tempRS2.next()){
				mitgliedsNummer=tempRS2.getInt(1);
				treffenID=tempRS2.getInt(2);
				for(Treffen m:meetingList){
					if(m.getTreffenID()==treffenID){
						m.insertTeilnehmer(mitgliedsNummer);
					}
				}
			}
			return meetingList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			meetingList=null;
			e.printStackTrace();
			return meetingList;
		}
    }
    
    public boolean validateUser(int mitgliedsnummer, int treffen_id){
    	ResultSet rs;
    	try {
    		validateUser.setInt(1, mitgliedsnummer);
    		validateUser.setInt(2, treffen_id);
			rs = validateUser.executeQuery();
			if(rs.next()){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
}