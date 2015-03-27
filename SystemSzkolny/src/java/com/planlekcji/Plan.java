
package com.planlekcji;

import com.klasa.Labcon;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Plan {
    Connection con1 = null;
    CallableStatement call= null;
    ResultSet result = null;
    Statement stmt = null;
    public Boolean klik = false;
    private List <PlanInfo> planLista = new ArrayList();
    public int index;
    //connect to DB and get customer list
    public void zmienIndex(int i){
        index=i;
        System.out.println(i);
    }
    public List getPlanList() throws SQLException{
        planLista.clear();
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        stmt=con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql); 
        
        String strSql="select ID, Id_przedmiot, Id_godzina, Id_dzien, Id_klasa from PlanLekcji";
        //System.err.println("****"+strSql);
        result=stmt.executeQuery(strSql);
        
        while(result.next()){
            if(result.getInt("Id_klasa")==index){
                PlanInfo nowa = new PlanInfo();
                nowa.setID(result.getInt("Id"));
                nowa.setId_przedmiot(result.getInt("Id_przedmiot"));
                nowa.setId_godzina(result.getInt("Id_godzina"));
                nowa.setId_dzien(result.getInt("Id_dzien"));
                nowa.setId_klasa(result.getInt("Id_klasa"));
                planLista.add(nowa);
            }
        }
        result.close();
        return planLista;
    }
    public void Click(){
        klik = true;
    }
    
    public Plan() {
    }
}
