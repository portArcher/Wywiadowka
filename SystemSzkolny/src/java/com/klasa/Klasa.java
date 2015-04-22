
package com.klasa;

import com.planlekcji.Plan;
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
public class Klasa {
    Connection con1 = null;
    CallableStatement call= null;
    ResultSet result = null;
    Statement stmt = null;
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
    public String wybranaKlasa = new String();
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
    
    public String getWybranaKlasa() {
        return wybranaKlasa;
    }

    public void setWybranaKlasa(String wybranaKlasa) {
        this.wybranaKlasa = wybranaKlasa;
    }

    public List getKlasaList() throws SQLException{
        klasaLista.clear();
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
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
        con1.close();
        return klasaLista;
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
