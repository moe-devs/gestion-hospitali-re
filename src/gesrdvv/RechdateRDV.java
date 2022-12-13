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
//,String pnom,String pprenom,String mnom,String mprenom,String specialite,String mgenre,String pgenre,Date datenaissance
//,pnom,pprenom,mnom,mprenom,specialite,mgenre,pgenre
/*this.pnom=pnom;
      this.pprenom=pprenom;
      this.mnom=mnom;
      this.mprenom=mprenom;
      this.specialite=specialite;
      this.mgenre=mgenre;
      this.pgenre=pgenre;
      this.datenaissance=datenaissance;*/
//,datenaissance
/*public String getpnom(){
       return pnom;
   }
   public String getpprenom(){
       return pprenom;
   }
   public String getmnom(){
       return mnom;
   }
   public String getmprenom(){
       return mprenom;
   }
   public String getspecialite(){
       return specialite;
   }
   public String getmgenre(){
       return mgenre;
   }
   public String getpgenre(){
       return pgenre;
   }
   public Date getdatenaissance(){
       return datenaissance;
   }*/
class RechdateRDV{
   private int idrdv,idmedecin,idpatient;
   private String heurerdv,nom,specialite,pnom;
    private Date daterdv;
   public RechdateRDV(int idrdv,int idmedecin,int idpatient,Date daterdv,String heurerdv,String nom,String specialite,String pnom)
   {
      this.idrdv=idrdv;
      this.idmedecin=idmedecin;
      this.idpatient=idpatient;
      this.daterdv=daterdv;
      this.heurerdv=heurerdv;
      this.nom=nom;
      this.specialite=specialite;
      this.pnom=pnom; 
   }
  public int getidrdv(){
       return idrdv;
   }
  public int getidmedecin(){
       return idmedecin;
   }
   public int getidpatient(){
       return idpatient;
   }
   public Date getdaterdv(){
       return daterdv;
   }
   public String getheurerdv(){
       return heurerdv;
   }
   public String getnom(){
       return nom;
   }
    public String getspecialite(){
       return specialite;
   }
    public String getpnom(){
        return pnom;
    } 
}
