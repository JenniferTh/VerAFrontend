package net.db.vera;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.db.vera.entities.BeitragskommentarDAO;
import net.db.vera.entities.MeetingDAO;
import net.db.vera.entities.UserDAO;


public class Main {

    private static void displayResultSet(ResultSet _rs) {

        java.sql.ResultSetMetaData rsmd;
        try {
            rsmd = _rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (_rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = _rs.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//		System.out.println(Arrays.toString(args));


        //displayResultSet(UserDAO.getAllUser());
        UserDAO userDAO = new UserDAO();
        displayResultSet(userDAO.getAllUser());
        //Closing the connection

        MeetingDAO meetingDAO = new MeetingDAO();
        meetingDAO.joinMeeting(2, "Hallp");

    }
}
