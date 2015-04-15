/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dniTygodnia;

import com.klasa.Labcon;
import com.planlekcji.PlanInfo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Lukasz
 */
@ManagedBean(name="dni")
@SessionScoped
public class DniTygodnia {

    Connection con1 = null;
    CallableStatement call= null;
    ResultSet result = null;
    Statement stmt = null;
    
    private List <DniTygodniaInfo> dniTygodniaLista = new ArrayList();
    //connect to DB and get customer list
    public List getPlanList() throws SQLException{
        dniTygodniaLista.clear();
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        stmt=con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql); 
        
        String strSql="select ID, NazwaDnia from DniTygodnia";
        //System.err.println("****"+strSql);
        result=stmt.executeQuery(strSql);
        
        while(result.next()){
            DniTygodniaInfo nowa = new DniTygodniaInfo();
            nowa.setID(result.getInt("Id"));
            nowa.setNazwaDnia(result.getNString("NazwaDnia"));       
            dniTygodniaLista.add(nowa);
        }
        result.close();
        con1.close();
        return dniTygodniaLista;
    }

    public List<DniTygodniaInfo> getDniTygodniaLista() {
        return dniTygodniaLista;
    }

    public void setDniTygodniaLista(List<DniTygodniaInfo> dniTygodniaLista) {
        this.dniTygodniaLista = dniTygodniaLista;
    }

    
    public void szukajDnia(){
        //for(int i=0;i<planLista.size();i++){
            System.out.println("info "+ dniTygodniaLista.get(0).nazwaDnia);
            //if(wejscie == planLista.get(i).Id_klasa){
                
                
               // dokonca =planLista.get(i);
            //}
       // }
    }
            
            
    public DniTygodnia() {
    }
    
  
}
