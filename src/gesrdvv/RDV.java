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
class RDV{
   private int idrdv,idmedecin,idpatient;
   private String heurerdv;
    private Date daterdv;
   public RDV(int idrdv,int idmedecin,int idpatient,Date daterdv,String heurerdv)
   {
      this.idrdv=idrdv;
      this.idmedecin=idmedecin;
      this.idpatient=idpatient;
      this.daterdv=daterdv;
      this.heurerdv=heurerdv;
      
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
   
}
