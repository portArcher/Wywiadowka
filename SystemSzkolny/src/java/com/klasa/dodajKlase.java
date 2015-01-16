
package com.klasa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class dodajKlase {
    public int klasaIDdodaj;
    public String nazwaDodaj;

    public int getKlasaIDdodaj() {
        return klasaIDdodaj;
    }

    public void setKlasaIDdodaj(int klasaIDdodaj) {
        this.klasaIDdodaj = klasaIDdodaj;
    }

    public String getNazwaDodaj() {
        return nazwaDodaj;
    }

    public void setNazwaDodaj(String nazwaDodaj) {
        this.nazwaDodaj = nazwaDodaj;
    }
    
    public String addAction() throws SQLException {
        Connection con1 = null;
        Statement stmt = null;
        //ResultSet result = null;
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        stmt = con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql);
        try{
            int klasaidDodaj=this.klasaIDdodaj;
            String klasanazwaDodaj=this.nazwaDodaj;
            
            String query = "INSERT INTO Klasy(Id, Nazwa) values ('"+klasaidDodaj+"','"+klasanazwaDodaj+"')";
            //System.out.println("insert query is--" +query);
            stmt.executeUpdate(query);
        }catch(Exception ex){
            System.out.println("Exception is:-"+ex.getMessage());
        }
        return "Success";
    }
    
    public dodajKlase() {
    }
    
}
