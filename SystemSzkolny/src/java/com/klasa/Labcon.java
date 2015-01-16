package com.klasa;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Labcon {
    Connection con = null;
    public Connection getLocalConnection(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://mysql.hosteam.pl","686_szkola","Projekt3s");
        }
        catch (ClassNotFoundException e){
            System.err.println("ClassNotFoundException in getConnection, " + e.getMessage());
        }
        catch (SQLException e){
            System.err.println("SQLException in getConnection, " + e.getMessage());
        }
        return con;
    }
    public void setConnectionClose() throws SQLException{
        con.close();
    }
}
