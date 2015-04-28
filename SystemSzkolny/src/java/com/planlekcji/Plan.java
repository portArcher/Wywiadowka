
package com.planlekcji;

import com.klasa.Labcon;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="p")
@SessionScoped
public class Plan {
    Connection con1 = null;
    CallableStatement call= null;
    ResultSet result = null;
    Statement stmt = null;
    Statement stmt1 = null;
    public int wejscie;
    public PlanInfo dokonca;
    int przedmiot;
    int iterator=0;

    public int getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(int przedmiot) {
        this.przedmiot = przedmiot;
    }
    
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
    private List<String> przedTab = new ArrayList();
    
    //connect to DB and get customer list
    public List getPlanList() throws SQLException{
        planLista.clear();
        Labcon lc = new Labcon();
        
        con1 = lc.getLocalConnection();
        String sql = "USE 686_szkola";
        stmt=con1.createStatement();
        
        stmt.executeQuery(sql); 
        
        String strSql="select ID, Id_przedmiot, Id_godzina, Id_dzien, Id_klasa from PlanLekcji where Id_klasa="+wejscie+" and Id_dzien=0 ORDER BY Id_godzina";
        //System.err.println("****"+strSql);
        result=stmt.executeQuery(strSql);
        
        while(result.next()){
            PlanInfo nowa = new PlanInfo();
            nowa.setID(result.getInt("Id"));
            
            nowa.setId_godzina(result.getString("Id_godzina"));
            nowa.setId_dzien(result.getString("Id_dzien"));
            nowa.setId_klasa(result.getString("Id_klasa"));
            nowa.setId_przedmiot(result.getString("Id_przedmiot"));
            planLista.add(nowa);
            
        }
        result.close();
        stmt.close();
        con1.close();
        getNazwaPrzedmiot();
        return planLista;
    }
    public List getNazwaPrzedmiot() throws SQLException{
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        String sql = "USE 686_szkola";
        stmt1=con1.createStatement();
        stmt1.executeQuery(sql);
        ResultSet rs1 = null;
        
        for(int i=0;i<planLista.size();i++){
            System.out.println("jeszcze dziala"+i);
            rs1=stmt1.executeQuery("SELECT Nazwa from Przedmioty where id="+planLista.get(i).Id_przedmiot);
            rs1.next();
            planLista.get(i).Id_przedmiot=rs1.getString("Nazwa");
            
            
        }
        rs1.close();
        
        stmt1.close();
        con1.close();
        return planLista;
    }
    public String funkcja(String x){
        for(int i=0;i<7;i++){
            przedTab.add(" ");
        }
        try {
            getPlanList();
        } catch (SQLException ex) {
            Logger.getLogger(Plan.class.getName()).log(Level.SEVERE, null, ex);
        }
        iterator++;
        boolean czy;
        if(x.equals("Poniedzialek")){
            for(int i=0;i<7;i++){
                czy=false;
                for(int j=0;j<planLista.size();j++){
                    if(planLista.get(j).Id_dzien.equals("0")&&planLista.get(j).Id_godzina.equals(Integer.toString(i))&&planLista.get(j).Id_klasa.equals(Integer.toString(wejscie))){
                        przedTab.set(i, planLista.get(j).Id_przedmiot);
                        czy=true;
                    }
                    if(j==planLista.size()-1&&czy==false){
                        przedTab.set(i, " ");
                    }
                }
            }
        }
        /*if(x.equals("Wtorek")){
            for(int i=0;i<7;i++){
                czy=false;
                for(int j=0;j<planLista.size();j++){
                    if(planLista.get(j).Id_dzien.equals("1")&&planLista.get(j).Id_godzina.equals(Integer.toString(i))&&planLista.get(j).Id_klasa.equals(Integer.toString(wejscie))){
                        przedTab.set(i, planLista.get(j).Id_przedmiot);
                        czy=true;
                    }
                    if(j==planLista.size()-1&&czy==false){
                        przedTab.set(i, " ");
                    }
                }
            }
        }*/
        //System.out.println("SZUKAM"+(iterator-1)); //zerować iteraor zrobić aby nie dodawalo ale zmienialo do listy 
        return przedTab.get(iterator-1);
    }

    public List<String> getPrzedTab() {
        return przedTab;
    }

    public void setPrzedTab(List<String> przedTab) {
        this.przedTab = przedTab;
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
