/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Matej
 */
@Entity
@Table
public class Linija extends Entitet implements Serializable {

    private Date polazak;
    private Date dolazak;
    private BigDecimal udaljenost;
    private BigDecimal cijena;
    @ManyToOne
    private Autobus autobus;

    @ManyToOne
    private Lokacija polaziste;

    @ManyToOne
    private Lokacija odrediste;

    public Lokacija getPolaziste() {
        return polaziste;
    }

    public void setPolaziste(Lokacija polaziste) {
        this.polaziste = polaziste;
    }

    public Lokacija getOdrediste() {
        return odrediste;
    }

    public void setOdrediste(Lokacija odrediste) {
        this.odrediste = odrediste;
    }

    @OneToMany(mappedBy = "linija")
    private List<Rezervacija> rezervacije;
    

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public Date getPolazak() {
        return polazak;
    }

    public void setPolazak(Date polazak) {
        this.polazak = polazak;
    }

    public Date getDolazak() {
        return dolazak;
    }

    public void setDolazak(Date dolazak) {
        this.dolazak = dolazak;
    }

    public BigDecimal getUdaljenost() {
        return udaljenost;
    }

    public void setUdaljenost(BigDecimal udaljenost) {
        this.udaljenost = udaljenost;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }
    
    public String toString() {
        return "Linija " + getSifra();
    }


}
