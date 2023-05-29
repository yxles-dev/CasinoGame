package com.dabest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    public static Connection getConnection() throws SQLException{
        // Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/digibet", "root", "DJs231205");
        Connection con = DriverManager.getConnection("jdbc:mariadb://oqo.h.filess.io:3305/digibet_huntdrawn", "digibet_huntdrawn", "2e5ce5bc621670809c68f88dfaacae74c0ba4a62");
        return con;
    }  
}
