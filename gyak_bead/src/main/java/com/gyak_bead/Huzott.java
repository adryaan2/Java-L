package com.gyak_bead;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "huzott")
public class Huzott implements Serializable
{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private int huzasid;
    private int szam;

    public Huzott(int id, int huzasid, int szam) {
        this.id = id;
        this.huzasid = huzasid;
        this.szam = szam;
    }

    public Huzott() {
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

    public int getSzam() {
        return this.szam;
    }

    public void setSzam(int szam) {
        this.szam = szam;
    }


}

