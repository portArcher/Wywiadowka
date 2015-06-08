/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rejestracja;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Lukasz
 */
@ManagedBean(name="rej")
@SessionScoped
public class RejestracjaBean {
    public String email;
    public String haslo;
    public String imie;
    public String nazwisko;
    public String uprawanienia;
    public int klasa;
    
    public String getUprawanienia() {
        return uprawanienia;
    }

    public void setUprawanienia(String uprawanienia) {
        this.uprawanienia = uprawanienia;
    }
    
    
    public RejestracjaBean() {
    }
    
}
