package net.db.vera.entities;

import net.db.vera.DBConnection;

import java.sql.Connection;

/**
 * Created by Malte on 06.07.2015.
 */

public class AbteilungDAO {
    Connection connection = null;

    AbteilungDAO(){
        connection = new DBConnection().getConnection();
    }

}
