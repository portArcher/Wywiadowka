/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Closeable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
@ManagedBean
@SessionScoped
public class bazaUczniow extends uczen{
      public Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
    List<uczen> uczniowie = new ArrayList<>();

    private Connection con;;
    
    public bazaUczniow() {
    }

    public bazaUczniow(Connection con) {
        this.con = con;
    }
    //Host: mysql.hosteam.pl
    //User: 686_szkola
    //Pass: Projekt3s
    
    public void dodajUsera() throws SQLException, ClassNotFoundException{
        

        String host = "jdbc:mysql://mysql.hosteam.pl";
        String uzytkownik = "686_szkola";
        String haslo = "Projekt3s";
        con =         DriverManager.getConnection("jdbc:mysql://mysql.hosteam.pl","686_szkola","Projekt3s");
         
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM Uzytkownicy";
            ResultSet rs = stmt.executeQuery(SQL);
             
            rs.next();
            int id_col = rs.getInt("Id");
            String imie = rs.getString("Imie");
            String nazwisko = rs.getString("Nazwisko");
            String stanowisko = rs.getString("Email");
             
            String p = id_col + " " + imie + " " + nazwisko + " " + email;
            System.out.println(p);
        
        /*String host = "jdbc:mysql://mysql.hosteam.pl";
        String uzytkownik = "686_szkola";
        String haslo = "Projekt3s";
        con = DriverManager.getConnection(host, uzytkownik, haslo);
         
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM Uzytkownicy";
            ResultSet rs = stmt.executeQuery(SQL);
             
            rs.next();
            int id_col = rs.getInt("Id");
            String imie = rs.getString("Imie");
            String nazwisko = rs.getString("Nazwisko");
            String stanowisko = rs.getString("Email");
             
            String p = id_col + " " + imie + " " + nazwisko + " " + email;
            System.out.println(p);*/
        

            
    }
    
    public void dodajUcznia(){
        uczen nowy = new uczen(imie);
        uczniowie.add(nowy);
        
    }
    
    public List<uczen> getUczniowie() {
        return uczniowie;
    }

    public void setUczniowie(List<uczen> uczniowie) {
        this.uczniowie = uczniowie;
    }

 
   
}
