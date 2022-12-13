package gesrdvv;

class listeMedicats {
  int idCatalo;
  String nomCatalogue;
  int idMedicats;
  String nomMedicats;

    public listeMedicats(int idCatalo, String nomCatalogue, int idMedicats, String nomMedicats) {
        this.idCatalo = idCatalo;
        this.nomCatalogue = nomCatalogue;
        this.idMedicats = idMedicats;
        this.nomMedicats = nomMedicats;
    }

    public int getIdCatalo() {
        return idCatalo;
    }

    public String getNomCatalogue() {
        return nomCatalogue;
    }

    public int getIdMedicats() {
        return idMedicats;
    }

    public String getNomMedicats() {
        return nomMedicats;
    }
  
}
