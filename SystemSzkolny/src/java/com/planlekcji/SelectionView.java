
package com.planlekcji;

import com.klasa.Klasa;
import com.klasa.Klasa.KlasaInfo;
import com.przedmiot.Przedmioty;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="dtSelectionView")
@RequestScoped
public class SelectionView implements Serializable{
    private List<Przedmioty> przedmioty;
    private Klasa wybranaKlasa;
    private KlasaInfo klasainfo;

    public KlasaInfo getKlasainfo() {
        return klasainfo;
    }

    public void setKlasainfo(KlasaInfo klasainfo) {
        this.klasainfo = klasainfo;
    }
    
    public List<Przedmioty> getPrzedmioty() {
        return przedmioty;
    }
    public Klasa getWybranaKlasa() {
        return wybranaKlasa;
    }

    public void setWybranaKlasa(Klasa wybranaKlasa) {
        this.wybranaKlasa = wybranaKlasa;
    }
    
    
    public SelectionView() {
    }
    
}
