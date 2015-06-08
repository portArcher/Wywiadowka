/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sylwester
 */
@ManagedBean
@RequestScoped
public class dodajUsera extends User{
    public int userIDdodaj;
    public String imieDodaj;
    public String hasloDodaj;
    public String emailDodaj;
    public String nazwiskoDodaj;
    public String uprawnieniaDodaj;
    public int klasaDodaj;
    public String wybraneID;

    public String getWybraneID() {
        return wybraneID;
    }

    public void setWybraneID(String wybraneID) {
        this.wybraneID = wybraneID;
    }

    public String getEmailDodaj() {
        return emailDodaj;
    }

    public void setEmailDodaj(String emailDodaj) {
        this.emailDodaj = emailDodaj;
    }

    public String getNazwiskoDodaj() {
        return nazwiskoDodaj;
    }

    public void setNazwiskoDodaj(String nazwiskoDodaj) {
        this.nazwiskoDodaj = nazwiskoDodaj;
    }

    public String getUprawanieniaDodaj() {
        return uprawnieniaDodaj;
    }

    public void setUprawanieniaDodaj(String uprawanieniaDodaj) {
        this.uprawnieniaDodaj = uprawanieniaDodaj;
    }

    public int getKlasaDodaj() {
        return klasaDodaj;
    }

    public void setKlasaDodaj(int klasaDodaj) {
        this.klasaDodaj = klasaDodaj;
    }

    
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
            String unazwiskoDodaj=this.nazwiskoDodaj;
            String uemailDodaj=this.emailDodaj;
            String uuprawnieniaDodaj=this.uprawnieniaDodaj;
            int uklasaDodaj = this.klasaDodaj;
            
            String query = "INSERT INTO Uzytkownicy(Id, Imie, Nazwisko, Email, Id_klasa, Haslo, Uprawnienia) values ('"+zwrocMaxIdNieobecnosci()+"','"+userimieDodaj+"','"+unazwiskoDodaj+"','"+uemailDodaj+"','"+uklasaDodaj+"','"+userhasloDodaj+"','"+uuprawnieniaDodaj+"')";
            //System.out.println("insert query is--" +query);
            stmt.executeUpdate(query);
        }catch(Exception ex){
            System.out.println("Exception is:-"+ex.getMessage());
        }
        return "Success";
    }
    
     public int zwrocMaxIdNieobecnosci()throws SQLException{
       getUserListx();
       int max = 0;
       int tmp = 0;
       for(int i = 0 ; i < userListax.size() ; i++) {
           tmp = Integer.parseInt(userListax.get(i).IdUser);
           if(max < tmp){
               max = tmp;          
            }
       }
       max++;
       return max;
    }
     
    private final List <UserInfo> userListax = new ArrayList();
    public List getUserListx() throws SQLException{
        userListax.clear();
     
        String sql = "USE 686_szkola";
        stmt=con1.createStatement();
        
        stmt.executeQuery(sql); 
        String strSql="select ID, Imie, Id_klasa, Haslo, Uprawnienia, Nazwisko from Uzytkownicy";
        //System.err.println("****"+strSql);
        result=stmt.executeQuery(strSql);
        while(result.next()){
            UserInfo nowa = new UserInfo();
            nowa.setIdUser(result.getString("Id"));
            nowa.setNazwisko(result.getString("Nazwisko"));
            nowa.setImie(result.getString("Imie"));  
            nowa.setHaslo(result.getString("Haslo"));
            nowa.setUprawanienia(result.getString("Uprawnienia"));
            userListax.add(nowa);
        }
        result.close();
         con1.close();
        return userListax;  
    }
    
   

    public String getUprawnieniaDodaj() {
        return uprawnieniaDodaj;
    }

    public void setUprawnieniaDodaj(String uprawnieniaDodaj) {
        this.uprawnieniaDodaj = uprawnieniaDodaj;
    }
    
    public String zaloguj() throws SQLException{
        getUserListx();
        for(int i = 0; i < userListax.size(); i++){
            if((imieDodaj.equals(userListax.get(i).imie) && (hasloDodaj.equals(userListax.get(i).haslo)))){
                wybraneID=userListax.get(i).IdUser; 
                if("N".equals(userListax.get(i).uprawanienia)){ 
                    
                    return "/strony/index2.xhtml";
                }
                else{
                   
                    return "/strony/index2_uczen.xhtml";
                }
            }      
        }
         
        return "/strony/logowanie.xhtml";
    }
    
    
     public dodajUsera() {
    }
}
