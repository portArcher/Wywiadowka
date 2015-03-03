package com.przedmiot;

import com.klasa.Labcon;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class dodajPrzedmiot {
    public int przedmiotIDdodaj;
    public String nazwaDodaj;

    public int getPrzedmiotIDdodaj() {
        return przedmiotIDdodaj;
    }

    public void setPrzedmiotIDdodaj(int przedmiotIDdodaj) {
        this.przedmiotIDdodaj = przedmiotIDdodaj;
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
            int przedmiotidDodaj=this.przedmiotIDdodaj;
            String przedmiotnazwaDodaj=this.nazwaDodaj;
            
            String query = "INSERT INTO Przedmioty(Id, Nazwa) values ('"+przedmiotidDodaj+"','"+przedmiotnazwaDodaj+"')";
            //System.out.println("insert query is--" +query);
            stmt.executeUpdate(query);
        }catch(Exception ex){
            System.out.println("Exception is:-"+ex.getMessage());
        }
        return "Success";
    }
    public dodajPrzedmiot() {
    }
    
}
