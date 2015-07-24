package net.db.vera.entities;

import net.db.vera.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Malte on 06.07.2015.
 */
public class MeetingDAO {
    Connection connection;

    PreparedStatement joinMeeting;
    PreparedStatement createMeeting;

    String sqlCreateMeeting;
    String sqlJoinMeeting;

    public MeetingDAO() {
        connection = new DBConnection().getConnection();
        createPreparedStatements();
    }

    private void createPreparedStatements() {
        sqlCreateMeeting = "INSERT INTO Benutzer(Thema, Ort, Datum, Abteilungsleiter_Mitgliedsnummer) VALUES(?,?,?,?,)";
        sqlJoinMeeting = "INSERT INTO Teilnehmer_eines_Treffens (Benutzer_Mitgliedsnummer, Treffen_Thema) VALUES (?,?)";
        try {
            this.createMeeting = this.connection.prepareStatement(sqlCreateMeeting);
            this.joinMeeting = this.connection.prepareStatement(sqlJoinMeeting);

        } catch (SQLException e) {
            System.out.println("Error while creating prepared Statements");
            e.printStackTrace();
        }
    }

    public void createMeeting(String Thema, String Ort, int Abteilungsleiter_Mitgliedsnummer) {
        Date Datum = getCurrentDate();
        try {

            createMeeting.setString(1, Thema);
            createMeeting.setString(2, Ort);
            createMeeting.setDate(3, Datum);
            createMeeting.setInt(4, Abteilungsleiter_Mitgliedsnummer);
            createMeeting.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("MeetingDAO konnte nicht erstellt werden du Lauch");
        }
    }

    private java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public void joinMeeting(int mitgliedsnummer, String thema) {
        System.out.println("Inserting records into the table...");
        try {
            joinMeeting.setInt(1, mitgliedsnummer);
            joinMeeting.setString(2, thema);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Anmeldung war nicht erfolgreich du Lauch");
            e.printStackTrace();
        }
    }
}
