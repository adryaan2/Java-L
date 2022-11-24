package com.gyak_bead;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "huzas"
)
public class Huzas {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private int id;
    private int ev;
    private int het;

    public Huzas(int id, int ev, int het) {
        this.id = id;
        this.ev = ev;
        this.het = het;
    }

    public Huzas() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEv() {
        return this.ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public int getHet() {
        return this.het;
    }

    public void setHet(int het) {
        this.het = het;
    }
}
