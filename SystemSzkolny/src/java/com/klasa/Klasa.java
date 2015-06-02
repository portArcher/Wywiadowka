
package com.klasa;

import com.planlekcji.Plan;
import com.user.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="d")
@SessionScoped
public class Klasa extends User{
   
    CallableStatement call= null;
    ResultSet result = null;
    Statement stmt = null;
    CallableStatement call2= null;
    ResultSet result2 = null;
    Statement stmt2 = null;
    Labcon lc = new Labcon();
    Connection con1 = lc.getLocalConnection();
    
    
    public String wejscie;

    public String getWejscie() {
        return wejscie;
    }

    public void setWejscie(String wejscie) {
        this.wejscie = wejscie;
    }

    public Plan listaPlanow;
    private List <KlasaInfo> klasaLista = new ArrayList();
    //connect to DB and get customer list
    public int wybranaKlasa;
    public String nazwaWybranejKlasy = new String();
    
    public String getNazwaWybranejKlasy() {
        return nazwaWybranejKlasy;
    }

    public void setNazwaWybranejKlasy(String nazwaWybranejKlasy) {
        this.nazwaWybranejKlasy = nazwaWybranejKlasy;
    }
    
    public String zobacz(){
        return "/strony/zobaczObecnosci.xhtml";
    }

    public int getWybranaKlasa() {
        return wybranaKlasa;
    }

    public void setWybranaKlasa(int wybranaKlasa) {
        this.wybranaKlasa = wybranaKlasa;
    }
    
    

    public List getKlasaList() throws SQLException{
        klasaLista.clear();
        //Labcon lc = new Labcon();
        
        stmt=con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql); 
        
        String strSql="select ID, Nazwa from Klasy";
        //System.err.println("****"+strSql);
        result=stmt.executeQuery(strSql);
        
        while(result.next()){
            KlasaInfo nowa = new KlasaInfo();
            nowa.setKlasaID(result.getString("Id"));
            nowa.setKlasaNazwa(result.getString("Nazwa"));
            klasaLista.add(nowa);
        }
        result.close();
        //con1.close();
        return klasaLista;
    }
    
    private List <UserInfo> UserListwKlasie = new ArrayList();

    public List<UserInfo> getUserListwKlasie() throws SQLException{
        UserListwKlasie.clear();
        
        
        stmt2=con1.createStatement();
        String sql2 = "USE 686_szkola";
        stmt2.executeQuery(sql2); 
        
        System.out.println("klasa "+wybranaKlasa);
            String strSql2="select ID, Imie, Id_klasa, Nazwisko from Uzytkownicy where Id_klasa="+wybranaKlasa;
            
            result2=stmt2.executeQuery(strSql2);
        
        while(result2.next()){
            UserInfo nowa = new UserInfo();
            nowa.setIdUser(result2.getString("Id"));
            nowa.setNazwisko(result2.getString("Nazwisko"));
            nowa.setImie(result2.getString("Imie"));  
            UserListwKlasie.add(nowa);
        }
        result2.close();
        //con1.close();
        return UserListwKlasie;
    }

    public void setUserListwKlasie(List<UserInfo> UserListwKlasie) {
        this.UserListwKlasie = UserListwKlasie;
    }

    public class KlasaInfo {
        public String klasaID;
        public String klasaNazwa;
        
        public String getKlasaID() {
            return klasaID;
        }
        public String getKlasaNazwa() {
            return klasaNazwa;
        }

        public void setKlasaID(String klasaID) {
            this.klasaID = klasaID;
        }

        public void setKlasaNazwa(String klasaNazwa) {
            this.klasaNazwa = klasaNazwa;
        }
        
        public KlasaInfo() {
        }
        
    }

    public List<KlasaInfo> getKlasaLista() {
        return klasaLista;
    }

    public void setKlasaLista(List<KlasaInfo> klasaLista) {
        this.klasaLista = klasaLista;
    }
    
    public void funkcja(){
        for(int i=0;i<klasaLista.size();i++){
            if(wejscie.equals(klasaLista.get(i).klasaID)){
                System.out.println("i "+klasaLista.get(i).klasaNazwa);
            }
        }
    }
    
    public Klasa() {
    }
    
    
}
