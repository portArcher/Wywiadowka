/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LabconUser {
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
