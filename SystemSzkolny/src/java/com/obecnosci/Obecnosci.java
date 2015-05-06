/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obecnosci;

import com.klasa.Labcon;
import com.user.User;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lukasz
 */
@ManagedBean(name="o")
@SessionScoped
public class Obecnosci extends User {
    Connection con1 = null;
    CallableStatement call= null;
    ResultSet result = null;
    Statement stmt = null;
    String id = null;
    public int wybranyID;
    public int idNieobecnosci;
    public int zapisz;
    public String wybranaGodzina;
    
    
    public String getWybranaGodzina() {
        return wybranaGodzina;
    }

    public void setWybranaGodzina(String wybranaGodzina) {
        this.wybranaGodzina = wybranaGodzina;
    }
    
    public int getZapisz() {
        return zapisz;
    }

    public void setZapisz(int zapisz) {
        this.zapisz = zapisz;
    }
    
    public int getIdNieobecnosci() {
        return idNieobecnosci;
    }

    public void setIdNieobecnosci(int idNieobecnosci) {
        this.idNieobecnosci = idNieobecnosci;
    }

    public List<ObecnosciInfo> getListaObecnosci() throws SQLException{
        listaObecnosci.clear();
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        stmt=con1.createStatement();
        String sql2 = "USE 686_szkola";
        stmt.executeQuery(sql2); 
       
        System.out.println("user "+wybranyID);
        
        String strSql="select ID, Id_uzytkownik, Id_godzina, Data, Godzina from Obecnosci where Id_uzytkownik="+wybranyID;
            
        result=stmt.executeQuery(strSql);

        while(result.next()){
            ObecnosciInfo nowa = new ObecnosciInfo();
            nowa.setID(result.getString("Id"));
            nowa.setGodzina(result.getString("Godzina"));
            nowa.setUzytkownik(result.getString("Id_uzytkownik"));  
            nowa.setData(result.getString("Data"));
            listaObecnosci.add(nowa);
        }
        result.close();
        con1.close();
        getgodzinLista();
        return listaObecnosci;
    }

    public void setListaObecnosci(List<ObecnosciInfo> listaObecnosci) {
        this.listaObecnosci = listaObecnosci;
    }
    
    public int getWybranyID() {
        return wybranyID;
    }

    public void setWybranyID(int wybranyID) {
        this.wybranyID = wybranyID;
    }
    
    public List<ObecnosciInfo> listaObecnosci = new ArrayList();
    
    public List <String> godzinLista = new ArrayList();
    
    public List getgodzinLista() throws SQLException{
        godzinLista.clear();
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        stmt=con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql); 
        
        String strSql="select Godzina from Godziny";
        //System.err.println("****"+strSql);
        result=stmt.executeQuery(strSql);
        
        while(result.next()){
            String nowa;
            nowa = result.getString("Godzina");
            godzinLista.add(nowa);
        }
        result.close();
        con1.close();
        return godzinLista;
    }
    
    public String zwrocNazweGodziny(String x){
        String godzina = null;
        id = null;
        for(int i = 0; i < listaObecnosci.size(); i++){
            if(listaObecnosci.get(i).ID.equals(x)){               
                godzina = listaObecnosci.get(i).godzina+", "+listaObecnosci.get(i).data;  
                id = listaObecnosci.get(i).ID;
                System.out.println("id --- : "+id);
            }
        }
        return godzina;
    }
    
    public List<ObecnosciInfo> listaID = new ArrayList();

    public List<ObecnosciInfo> getListaID()throws SQLException{
        listaID.clear();
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        stmt=con1.createStatement();
        String sql2 = "USE 686_szkola";
        stmt.executeQuery(sql2); 
              
        String strSql="select Id from Obecnosci";
            
        result=stmt.executeQuery(strSql);
        while(result.next()){
            ObecnosciInfo nowa = new ObecnosciInfo();
            nowa.setID(result.getString("Id"));
            
            listaID.add(nowa);
        }
        result.close();
        return listaID;
    }

    public void setListaID(List<ObecnosciInfo> listaID) {
        this.listaID = listaID;
    }
    
    
    public int zwrocMaxIdNieobecnosci()throws SQLException{
       getListaID();
       int max = 0;
       int tmp = 0;
       for(int i = 0 ; i < listaID.size() ; i++) {
           tmp = Integer.parseInt(listaID.get(i).ID);
           if(max < tmp){
               max = tmp;          
           }
       }
       max++;
       return max;
    }
    
    public String zwrocDate(){
     Date dNow = new Date();
     SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
        System.out.println("" + ft.format(dNow) );
     return ft.format(dNow);
    }
    
    public List<ObecnosciInfo> listaDoOb = new ArrayList();
    
    public List<ObecnosciInfo> getListaDoOb(int wybranyID, int idNN) throws SQLException{
        listaDoOb.clear();
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        stmt=con1.createStatement();
        String sql2 = "USE 686_szkola";
        stmt.executeQuery(sql2); 
       
        System.out.println("user2 "+wybranyID);
        System.out.println("zmienna "+idNN);
        String strSql="select ID, Id_uzytkownik, Id_godzina, Data, Godzina from Obecnosci where Id_uzytkownik="+wybranyID;
            
        result=stmt.executeQuery(strSql);

        while(result.next()){
            ObecnosciInfo nowa = new ObecnosciInfo();
            nowa.setID(result.getString("Id"));
            nowa.setGodzina(result.getString("Godzina"));
            nowa.setUzytkownik(result.getString("Id_uzytkownik"));  
            nowa.setData(result.getString("Data"));
            listaDoOb.add(nowa);
        }
        result.close();
        con1.close();
        getgodzinLista();
        return listaDoOb;
    }
    
    public void setListaDoOb(List<ObecnosciInfo> listaDoOb) {
        this.listaDoOb = listaDoOb;
    }
    
   
    private int idN;

    public int getIdN() {
        return idN;
    }

    public void setIdN(int idN) {
        this.idN = idN;
    }
    
    public void usNieobecnosc(int idN, int idUs)throws SQLException{
       
        Connection con1 = null;
        Statement stmt = null;
        //ResultSet result = null;
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        stmt = con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql);
        
        try {
            
            System.out.println("  usun taka nieobecnosc : "+idN + "    i id user = "+ idUs);
            
            String query = "DELETE FROM Obecnosci WHERE Id="+idN+" and Id_uzytkownik="+idUs;
            //System.out.println("insert query is--" +query);
            stmt.executeUpdate(query);
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Usprawiedliwiono", ""));
         
        } catch (Exception e) {
            System.out.println("Exception is:-"+e.getMessage());
        }
       
    }
    
    
    public void dodajObecnosc(int iduser)throws SQLException{
        Connection con1 = null;
        Statement stmt = null;
        //ResultSet result = null;
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        stmt = con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql);
        
        getListaObecnosci();
        
        try{
            System.out.println("  dodano taka nieobecnosc : userID " +iduser+ "  godzina "+ wybranaGodzina +"  IDdodanejNieobecnosci " +zwrocMaxIdNieobecnosci());
            String query = "INSERT INTO Obecnosci(Id, Id_uzytkownik, Id_godzina, Data, Godzina) values ('"+zwrocMaxIdNieobecnosci()+"','"+iduser+"','"+0+"','"+zwrocDate()+"','"+wybranaGodzina+"')";
            //System.out.println("insert query is--" +query);
            stmt.executeUpdate(query);
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Dodano nieobecność", "zamknij komunikat!"));
            
        
        }catch(Exception ex){
            System.out.println("Exception is:-"+ex.getMessage());
        }
        
        
    }
    
    public String dodajGodzine(String godz){
        System.out.println("" + godz);
        
        return godz;
    }
    
    
    public class ObecnosciInfo{
            String ID, uzytkownik, godzina, data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getUzytkownik() {
            return uzytkownik;
        }

        public void setUzytkownik(String uzytkownik) {
            this.uzytkownik = uzytkownik;
        }

        public String getGodzina() {
            return godzina;
        }

        public void setGodzina(String godzina) {
            this.godzina = godzina;
        }
        
        public ObecnosciInfo() {
        }
        
        
    }
    
    public Obecnosci() {
        
    }
    
    
}
