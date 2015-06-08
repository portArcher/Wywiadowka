
package com.przedmiot;

import com.klasa.Labcon;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="test")
@RequestScoped
public class Przedmioty {
    Connection con1 = null;
    CallableStatement call= null;
    ResultSet result = null;
    Statement stmt = null;
    Labcon lc = new Labcon();
    public String przedmiot;

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    private final List <PrzedmiotInfo> przedmiotyLista = new ArrayList();
    //connect to DB and get customer list
    public List getPrzedmiotyList() throws SQLException{
        przedmiotyLista.clear();
        
        con1 = lc.getLocalConnection();
        stmt=con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql); 
        
        String strSql="select ID, Nazwa from Przedmioty";
        //System.err.println("****"+strSql);
        result=stmt.executeQuery(strSql);
        
        while(result.next()){
            PrzedmiotInfo nowa = new PrzedmiotInfo();
            nowa.setPrzedmiotID(result.getString("Id"));
            nowa.setPrzedmiotNazwa(result.getString("Nazwa"));
            przedmiotyLista.add(nowa);
        }
        result.close();
        con1.close();
        return przedmiotyLista;
    }
    
    public class PrzedmiotInfo {
        public String przedmiotID;
        public String przedmiotNazwa;

        public String getPrzedmiotID() {
            return przedmiotID;
        }

        public void setPrzedmiotID(String przedmiotID) {
            this.przedmiotID = przedmiotID;
        }

        public String getPrzedmiotNazwa() {
            return przedmiotNazwa;
        }

        public void setPrzedmiotNazwa(String przedmiotNazwa) {
            this.przedmiotNazwa = przedmiotNazwa;
        }
        
        
        public PrzedmiotInfo() {
        }
        
    }
    public Przedmioty() {
    }
    
}
