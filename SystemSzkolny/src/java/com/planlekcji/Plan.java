
package com.planlekcji;

import com.klasa.Labcon;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="p")
@SessionScoped
public class Plan {
    Connection con1 = null;
    CallableStatement call= null;
    ResultSet result = null;
    Statement stmt = null;
    public int wejscie;
    public PlanInfo dokonca;

    public PlanInfo getDokonca() {
        return dokonca;
    }

    public void setDokonca(PlanInfo dokonca) {
        this.dokonca = dokonca;
    }

    public int getWejscie() {
        return wejscie;
    }

    public void setWejscie(int wejscie) {
        this.wejscie = wejscie;
    }
    public Boolean klik = false;
    private List <PlanInfo> planLista = new ArrayList();
    //connect to DB and get customer list
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
            PlanInfo nowa = new PlanInfo();
            nowa.setID(result.getInt("Id"));
            nowa.setId_przedmiot(result.getInt("Id_przedmiot"));
            nowa.setId_godzina(result.getInt("Id_godzina"));
            nowa.setId_dzien(result.getInt("Id_dzien"));
            nowa.setId_klasa(result.getInt("Id_klasa"));
            planLista.add(nowa);
        }
        result.close();
        return planLista;
    }

    public List<PlanInfo> getPlanLista() {
        return planLista;
    }

    public void setPlanLista(List<PlanInfo> planLista) {
        this.planLista = planLista;
    }
    
    public void szukajPlan(){
        //for(int i=0;i<planLista.size();i++){
            System.out.println("info "+ planLista.get(0).Id_klasa);
            //if(wejscie == planLista.get(i).Id_klasa){
                
                
               // dokonca =planLista.get(i);
            //}
       // }
    }
    
    public Plan() {
    }
}
