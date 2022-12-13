package gesrdvv;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Simob
 */
public class consult {
    private int idconsult,idpat;

    private int pression;
    private float poids;
    private int coeur;
    private String medicament,observation;

    public consult(int idconsult, int idpat, int pression, float poids, int coeur, String medicament, String observation) {
        this.idconsult = idconsult;
        this.idpat = idpat;

        this.pression = pression;
        this.poids = poids;
        this.coeur = coeur;
        this.medicament = medicament;
        this.observation = observation;
    }

    public int getIdconsult() {
        return idconsult;
    }

    public int getIdpat() {
        return idpat;
    }



    public int getPression() {
        return pression;
    }

    public float getPoids() {
        return poids;
    }

    public int getCoeur() {
        return coeur;
    }

    public String getMedicament() {
        return medicament;
    }

    public String getObservation() {
        return observation;
    }
    
}
