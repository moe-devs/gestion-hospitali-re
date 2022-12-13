package gesrdvv;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Simob
 */
public class consultMed {
    int idcon,idpat,idmed,pres;
    float poid;
    int coeur;
    String medicat,obser;

    public consultMed(int idcon, int idpat, int idmed, int pres, float poid, int coeur, String medicat, String obser) {
        this.idcon = idcon;
        this.idpat = idpat;
        this.idmed = idmed;
        this.pres = pres;
        this.poid = poid;
        this.coeur = coeur;
        this.medicat = medicat;
        this.obser = obser;
    }

    public int getIdcon() {
        return idcon;
    }

    public int getIdpat() {
        return idpat;
    }

    public int getIdmed() {
        return idmed;
    }

    public int getPres() {
        return pres;
    }

    public float getPoid() {
        return poid;
    }

    public int getCoeur() {
        return coeur;
    }

    public String getMedicat() {
        return medicat;
    }

    public String getObser() {
        return obser;
    }
    
}
