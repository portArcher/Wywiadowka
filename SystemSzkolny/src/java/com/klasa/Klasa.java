
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
    
    public Plan listaPlanow;
    private List <KlasaInfo> klasaLista = new ArrayList();
    //connect to DB and get customer list
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
    
    
    public Klasa() {
    }
    
    
}
