/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.model;

import java.io.Serializable;
import java.util.ArrayList;
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
public class Lokacija extends Entitet implements Serializable {

    private String naziv;

    @OneToMany(mappedBy = "polaziste")
    private List<Linija> polaziste;

    @OneToMany(mappedBy = "odrediste")
    private List<Linija> odrediste;

    public List<Linija> getPolaziste() {
        return polaziste;
    }

    public void setPolaziste(List<Linija> polaziste) {
        this.polaziste = polaziste;
    }

    public List<Linija> getOdrediste() {
        return odrediste;
    }

    public void setOdrediste(List<Linija> odrediste) {
        this.odrediste = odrediste;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String toString() {
        return getNaziv();
    }

}
