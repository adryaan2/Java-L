package com.gyak_bead;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "nyeremeny"
)
public class Nyeremeny {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private int huzasid;
    private int talalat;
    private int darab;
    private int ertek;

    public Nyeremeny(int id, int huzasid, int talalat, int darab, int ertek) {
        this.id = id;
        this.huzasid = huzasid;
        this.talalat = talalat;
        this.darab = darab;
        this.ertek = ertek;
    }

    public Nyeremeny() {
    }

    public void setTalalat(int talalat) {
        this.talalat = talalat;
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
    }

    public int getErtek() {
        return ertek;
    }

    public void setErtek(int ertek) {
        this.ertek = ertek;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHuzasid() {
        return this.huzasid;
    }

    public void setHuzasid(int huzasid) {
        this.huzasid = huzasid;
    }

    public int getTalalat() {
        return this.talalat;
    }
}