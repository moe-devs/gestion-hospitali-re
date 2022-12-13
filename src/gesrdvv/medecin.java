package gesrdvv;


import java.util.Date;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author toshiba
 */
class medecin {
   private int idmedecin,idspecialite;
   private String genre,nom,prenom,addresse,telephone;
    private Date date_embauche,date_naissance;
   public medecin(int idmedecin,int idspecialite,String genre,String nom,String prenom,Date date_embauche,Date date_naissance,String addresse,String telephone)
   {
      this.idmedecin=idmedecin;
      this.idspecialite=idspecialite;
      this.genre=genre;
      this.nom= nom;
      this.prenom=prenom;
      this.date_embauche=date_embauche;
      this.date_naissance=date_naissance;
      this.addresse=addresse;
      this.telephone=telephone;
   }
   public int getidmedecin(){
       return idmedecin;
   }
   public int getidspecialite(){
       return idspecialite;
   }
   public String getgenre(){
       return genre;
   }
   public String getnom(){
       return nom;
   }
   public String getprenom(){
       return prenom;
   }
   public Date getdate_embauche(){
       return date_embauche;
   }
   public Date getdate_naissance(){
       return date_naissance;
   }
   public String getaddresse(){
       return addresse;
   }
   public String gettelephone(){
       return telephone;
   }
   
}
