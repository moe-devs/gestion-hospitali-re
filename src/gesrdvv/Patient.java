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
class Patient{
   private int idpatient,cnss;
   private String genre,nom,prenom,cin,addresse,tel,profession;
    private Date date_naissance;
   public Patient(int idpatient,String genre,String nom,String prenom,String cin,Date date_naissance,String addresse,String tel,String profession,int cnss)
   {
      this.idpatient=idpatient;
      this.genre=genre;
      this.nom= nom;
      this.prenom=prenom;
      this.cin=cin;
      this.date_naissance=date_naissance;
      this.addresse=addresse;
      this.tel=tel;
      this.profession=profession;
      this.cnss=cnss;
   }
   public int getidpatient(){
       return idpatient;
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
   public String getcin(){
       return cin;
   }
   public Date getdate_naissance(){
       return date_naissance;
   }
   public String getaddresse(){
       return addresse;
   }
   public String gettel(){
       return tel;
   }
   public String getprofession(){
       return profession;
   }
public int getcnss(){
       return cnss;
   }
}
