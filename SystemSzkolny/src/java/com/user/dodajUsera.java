/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Sylwester
 */
@ManagedBean
@RequestScoped
public class dodajUsera {
    public int userIDdodaj;
    public String imieDodaj;
    public String hasloDodaj;

    public int getUserIDdodaj() {
        return userIDdodaj;
    }

    public void setUserIDdodaj(int userIDdodaj) {
        this.userIDdodaj = userIDdodaj;
    }

    public String getImieDodaj() {
        return imieDodaj;
    }

    public void setImieDodaj(String imieDodaj) {
        this.imieDodaj = imieDodaj;
    }

    public String getHasloDodaj() {
        return hasloDodaj;
    }

    public void setHasloDodaj(String hasloDodaj) {
        this.hasloDodaj = hasloDodaj;
    }
    
    
    
    public String addAction() throws SQLException {
        Connection con1 = null;
        Statement stmt = null;
        //ResultSet result = null;
        LabconUser lc = new LabconUser();
        con1 = lc.getLocalConnection();
        stmt = con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql);
        try{
            int useridDodaj=this.userIDdodaj;
            String userimieDodaj=this.imieDodaj;
            String userhasloDodaj=this.hasloDodaj;
            
            String query = "INSERT INTO Uzytkownicy(Id, Imie, Haslo ) values ('"+useridDodaj+"','"+userimieDodaj+"','"+userhasloDodaj+"')";
            //System.out.println("insert query is--" +query);
            stmt.executeUpdate(query);
        }catch(Exception ex){
            System.out.println("Exception is:-"+ex.getMessage());
        }
        return "Success";
    }
    public dodajUsera() {
    }
    
}
