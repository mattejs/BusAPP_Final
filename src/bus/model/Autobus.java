/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Matej
 */
@Entity
@Table
public class Autobus extends Entitet implements Serializable {

    private int brojSjedala;
    private String registracija;

    @OneToMany(mappedBy = "autobus")
    private List<Linija> vozniRedovi;

    public List<Linija> getVozniRedovi() {
        return vozniRedovi;
    }

    public void setVozniRedovi(List<Linija> vozniRedovi) {
        this.vozniRedovi = vozniRedovi;
    }

    public int getBrojSjedala() {
        return brojSjedala;
    }

    public void setBrojSjedala(int brojSjedala) {
        this.brojSjedala = brojSjedala;
    }

    public String getRegistracija() {
        return registracija;
    }

    public void setRegistracija(String registracija) {
        this.registracija = registracija;
    }
    
    public String toString(){
        return getRegistracija();
    }

}
