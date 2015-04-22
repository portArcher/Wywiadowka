/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="u")
@RequestScoped
public class User {
    Connection con1 = null;
    CallableStatement call= null;
    ResultSet result = null;
    Statement stmt = null;

    /**
     *
     */
    public String wybranyUczenImie = new String();
    public String wybranyUczenNazwisko = new String();

    public String getWybranyUczenImie() {
        return wybranyUczenImie;
    }

    public void setWybranyUczenImie(String wybranyUczenImie) {
        this.wybranyUczenImie = wybranyUczenImie;
    }

    public String getWybranyUczenNazwisko() {
        return wybranyUczenNazwisko;
    }

    public void setWybranyUczenNazwisko(String wybranyUczenNazwisko) {
        this.wybranyUczenNazwisko = wybranyUczenNazwisko;
    }

    public List<UserInfo> getUserLista() {
        return userLista;
    }

    public void setUserLista(List<UserInfo> userLista) {
        this.userLista = userLista;
    }

    private List <UserInfo> userLista = new ArrayList();
    //connect to DB and get customer list
    public List getUserList() throws SQLException{
        userLista.clear();
        LabconUser lc = new LabconUser();
        con1 = lc.getLocalConnection();
        stmt=con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql); 
        
        String strSql="select ID, Imie, Nazwisko from Uzytkownicy";
        //System.err.println("****"+strSql);
        result=stmt.executeQuery(strSql);
        
        while(result.next()){
            UserInfo nowa = new UserInfo();
            nowa.setIdUser(result.getString("Id"));
            nowa.setNazwisko(result.getString("Nazwisko"));
            nowa.setImie(result.getString("Imie"));        
            userLista.add(nowa);
        }
        result.close();
        return userLista;
    
    }
    public class UserInfo {
            String imie, nazwisko, haslo, idUser;

        public String getNazwisko() {
            return nazwisko;
        }

        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }

        public String getIdUser() {
            return idUser;
        }

        public void setIdUser(String idUser) {
            this.idUser = idUser;
        }
            
        public String getImie() {
            return imie;
        }

        public void setImie(String imie) {
            this.imie = imie;
        }

        public String getHaslo() {
            return haslo;
        }

        public void setHaslo(String haslo) {
            this.haslo = haslo;
        }
            
        }
    
    public User() {
        
    }
    
}
