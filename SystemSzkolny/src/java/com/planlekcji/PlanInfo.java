
package com.planlekcji;

public class PlanInfo {
        public int ID;
        public int Id_przedmiot;
        public int Id_godzina;
        public int Id_dzien;
        public int Id_klasa;

        public int getID() {
            System.out.println(ID);
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getId_przedmiot() {
            return Id_przedmiot;
        }

        public void setId_przedmiot(int Id_przedmiot) {
            this.Id_przedmiot = Id_przedmiot;
        }

        public int getId_godzina() {
            return Id_godzina;
        }

        public void setId_godzina(int Id_godzina) {
            this.Id_godzina = Id_godzina;
        }

        public int getId_dzien() {
            return Id_dzien;
        }

        public void setId_dzien(int Id_dzien) {
            this.Id_dzien = Id_dzien;
        }

        public int getId_klasa() {
            return Id_klasa;
        }

        public void setId_klasa(int Id_klasa) {
            this.Id_klasa = Id_klasa;
        }

        
        
        public PlanInfo() {
        }
        
    }