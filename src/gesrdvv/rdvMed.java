package gesrdvv;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Simob
 */
public class rdvMed {
    int id;
    String nom,pre,gen,cin,naiss;
    int cnss;
    String drdv,hrdv;

    public rdvMed(int id, String nom, String pre, String gen, String cin, String naiss, int cnss, String drdv, String hrdv) {
        this.id = id;
        this.nom = nom;
        this.pre = pre;
        this.gen = gen;
        this.cin = cin;
        this.naiss = naiss;
        this.cnss = cnss;
        this.drdv = drdv;
        this.hrdv = hrdv;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPre() {
        return pre;
    }

    public String getGen() {
        return gen;
    }

    public String getCin() {
        return cin;
    }

    public String getNaiss() {
        return naiss;
    }

    public int getCnss() {
        return cnss;
    }

    public String getDrdv() {
        return drdv;
    }

    public String getHrdv() {
        return hrdv;
    }
    
}
