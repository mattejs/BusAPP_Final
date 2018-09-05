/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Matej
 */
@MappedSuperclass
public abstract class Entitet {

    @Id
    @GeneratedValue
    private int sifra = 0;

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    private Date datumKreiranja;
    private Date datumPromjene;
    private Date datumBrisanja;

    private boolean obrisano = false;

    @ManyToOne
    private Operater operaterKreiranja;

    @ManyToOne
    private Operater operaterPromjene;

    @ManyToOne
    private Operater operaterBrisanja;

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Date getDatumPromjene() {
        return datumPromjene;
    }

    public void setDatumPromjene(Date datumPromjene) {
        this.datumPromjene = datumPromjene;
    }

    public Date getDatumBrisanja() {
        return datumBrisanja;
    }

    public void setDatumBrisanja(Date datumBrisanja) {
        this.datumBrisanja = datumBrisanja;
    }

    public boolean isObrisano() {
        return obrisano;
    }

    public void setObrisano(boolean obrisano) {
        this.obrisano = obrisano;
    }

    public Operater getOperaterKreiranja() {
        return operaterKreiranja;
    }

    public void setOperaterKreiranja(Operater operaterKreiranja) {
        this.operaterKreiranja = operaterKreiranja;
    }

    public Operater getOperaterPromjene() {
        return operaterPromjene;
    }

    public void setOperaterPromjene(Operater operaterPromjene) {
        this.operaterPromjene = operaterPromjene;
    }

    public Operater getOperaterBrisanja() {
        return operaterBrisanja;
    }

    public void setOperaterBrisanja(Operater operaterBrisanja) {
        this.operaterBrisanja = operaterBrisanja;
    }

}
