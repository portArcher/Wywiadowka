/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class bazaklasy {
    
    String nazwa;
    List<String> klasy_lista = new ArrayList<>();

    public bazaklasy(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
    public void dodaj(String nazwa) {
        klasy_lista.add(nazwa);
    }

    public List<String> getKlasy_lista() {
        return klasy_lista;
    }

    public void setKlasy_lista(List<String> klasy_lista) {
        this.klasy_lista = klasy_lista;
    }

    public boolean dodaj2() {
        dodaj(nazwa);
        return true;
    }
    
    public bazaklasy() {
    }
    
    

}
