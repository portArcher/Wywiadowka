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
public class bazaUczniow extends uczen{

    List<uczen> uczniowie = new ArrayList<>();

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
    
    public bazaUczniow() {
    }
    
}
