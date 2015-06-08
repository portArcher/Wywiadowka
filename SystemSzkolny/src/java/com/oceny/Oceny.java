/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oceny;

import com.klasa.Labcon;
import com.user.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * 
 */
@ManagedBean(name="oceny")
@SessionScoped
public class Oceny extends User {
   
    CallableStatement call= null;
    ResultSet result = null;
    Statement stmt = null;
    Labcon lc = new Labcon();
    Connection con1 = lc.getLocalConnection();
     
    public String id_user;
    public String ocena;
    public String przedmiot;

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }
    
    public String getOcena() {
        return ocena;
    }

    public void setOcena(String ocena) {
        this.ocena = ocena;
    }
    
    public List <OcenyInfo> listaOcen = new ArrayList();
    
    public List<OcenyInfo> getListaOcen() throws SQLException {
        
        listaOcen.clear();
        
        stmt=con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql); 
        //System.out.println("user oceny  " + id_user);
        String strSql="select ocena, Id_uzytkownik, przedmiot from Oceny where Id_uzytkownik="+id_user;
        //System.err.println("****"+strSql);
        result=stmt.executeQuery(strSql);
        
        while(result.next()){
            OcenyInfo nowa = new OcenyInfo();
            nowa.setId_uzytkownika(result.getString("Id_uzytkownik"));
            nowa.setOcena(result.getString("ocena"));
            nowa.setPrzedmioty(result.getString("przedmiot"));
            listaOcen.add(nowa);
        }
        result.close();
        //con1.close();

        return listaOcen;   
    }

    public void setListaOcen(List<OcenyInfo> listaOcen) {
        this.listaOcen = listaOcen;
    }
       
    public void dodajOcene(int id_user)throws SQLException{
        //Connection con1 = null;
        Statement stmt = null;
        //ResultSet result = null;
        //Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        stmt = con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql);
        

        try{
            System.out.println("  dodano taka ocene : userID " +id_user+ "  ocena "+ ocena +"  przedmiot " +przedmiot);
            String query = "INSERT INTO Oceny(ocena, Id_przedmiot, Id_uzytkownik, przedmiot) values ('"+ocena+"','"+0+"','"+id_user+"','"+przedmiot+"')";
            //System.out.println("insert query is--" +query);
            stmt.executeUpdate(query);
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Dodano ocene", "zamknij komunikat!"));
            
        
        }catch(Exception ex){
            System.out.println("Exception is:-"+ex.getMessage());
        }
     
    }
    
    public Oceny() {
    }
    
}
