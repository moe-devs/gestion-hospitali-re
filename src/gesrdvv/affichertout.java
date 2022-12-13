package gesrdvv;


import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.lang.String;


//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.JTableHeader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author toshiba
 */
public class affichertout extends javax.swing.JFrame {
    private static String url = "jdbc:mysql://localhost:3306/gesrdv";    
    private static String driverName = "com.mysql.cj.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "";
    private static Connection con;
    private static String urlstring;
   
    public affichertout() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage((new ImageIcon(getClass().getResource("/images/hospital.png")).getImage()));       
        jTable1.setEnabled(false);
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4); 
         
    }
    public ArrayList<medecin> medlist(){
        ArrayList<medecin> medclist = new ArrayList<>();
         try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM medecin";
          ResultSet res = s.executeQuery(sql);
          medecin medecin;
          while(res.next()){
         medecin = new medecin(res.getInt("idmedecin"),res.getInt("idspecialite"),res.getString("genre"),res.getString("nom"),res.getString("prenom"),res.getDate("date_embauche"),res.getDate("date_naissance"),res.getString("addresse"),res.getString("telephone"));   
           medclist.add(medecin);
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }
         return medclist;
    }
    
 public ArrayList<Patient> Patientlist(){
        ArrayList<Patient> patientslist = new ArrayList<>();
         try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM patient";
          ResultSet res = s.executeQuery(sql);
          Patient Patient;
          while(res.next()){
         Patient= new Patient(res.getInt("idpatient"),res.getString("genre"),res.getString("nom"),res.getString("prenom"),res.getString("cin"),res.getDate("date_naissance"),res.getString("addresse"),res.getString("tel"),res.getString("profession"),res.getInt("cnss"));   
           patientslist.add(Patient);
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }
         return patientslist;
 }
 public ArrayList<RDV>RDVlist(){
        ArrayList<RDV> rdvlist = new ArrayList<>();
         try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM rdv";
          ResultSet res = s.executeQuery(sql);
          RDV RDV;
          while(res.next()){
         RDV= new RDV(res.getInt("idrdv"),res.getInt("idmedecin"),res.getInt("idpatient"),res.getDate("daterdv"),res.getString("heurerdv"));  
           rdvlist.add(RDV);
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }
         return rdvlist;
 }
 
 public void show_medcin(){
     ArrayList<medecin> list =medlist();
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                 model.setRowCount(0);     
                 model.setColumnCount(0);
                 
        String id="Id Medecin";
        String Spe="Id Spécialité";
            String G="Genre";
            String N="Nom";
            String Pre="Prénom";
            String DE="Date embauche";
            String DN="Date Naissance";
            String Add="Addresse";
            String Tel="Telephone";
            
            Object[] row=new Object[9] ;
            String [] col = new String[9];
            for(int i = 0;i<col.length;i++){
                row[0] =id ;
                row[1] = Spe;
                row[2] = G;
                row[3] = N;
                row[4] = Pre;
                row[5] = DE;
                row[6] = DN;
                row[7] = Add;
                row[8] = Tel;
                model.addColumn(row[i]);
            }
            for(int i=0;i<list.size();i++){
                
          jScrollPane1.setViewportView(jTable1);
                row[0]=list.get(i).getidmedecin();
                row[1]=list.get(i).getidspecialite();
                row[2]=list.get(i).getgenre();
                row[3]=list.get(i).getnom();
                row[4]=list.get(i).getprenom();
                row[5]=list.get(i).getdate_embauche();
                row[6]=list.get(i).getdate_naissance();
                row[7]=list.get(i).getaddresse();
                row[8]=list.get(i).gettelephone();
                model.addRow(row);
            } 
 }
 public void show_patient(){
     
            ArrayList<Patient> list =Patientlist();
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0); 
            model.setColumnCount(0);
            
        String id="Id Patient";
            String G="Genre";
            String N="Nom";
            String Pre="Prénom";
            String C="Cin";
            String DN="Date Naissance";
            String Add="Addresse";
            String Tel="Telephone";
            String Pro="Profession";
            String cnss="CNSS";
            Object[] row=new Object[10] ;
            String [] col = new String[10];
            for(int i = 0;i<col.length;i++){
                row[0] =id ;
                row[1] = G;
                row[2] = N;
                row[3] = Pre;
                row[4] = C;
                row[5] = DN;
                row[6] = Add;
                row[7] = Tel;
                row[8] = Pro;
                row[9] = cnss;
                model.addColumn(row[i]);
            }
            for(int i=0;i<list.size();i++){
          jScrollPane1.setViewportView(jTable1);
                row[0]=list.get(i).getidpatient();
                row[1]=list.get(i).getgenre();
                row[2]=list.get(i).getnom();
                row[3]=list.get(i).getprenom();
                row[4]=list.get(i).getcin();
                row[5]=list.get(i).getdate_naissance();
                row[6]=list.get(i).getaddresse();
                row[7]=list.get(i).gettel();
                row[8]=list.get(i).getprofession();
                row[9]=list.get(i).getcnss();
                model.addRow(row);  
                 
            } 
 }
  public void show_RDV(){
     ArrayList<RDV> list =RDVlist();
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                 model.setRowCount(0);     
                 model.setColumnCount(0);
            String idr="Id Rendez-vous";
            String idm="Id Medecin";
            String idp="Id Patient";;
            String DR="Date Rendez-vous";
            String H="Heure Rendez-vous";
            Object[] row=new Object[5] ;
            String [] col = new String[5];
            for(int i = 0;i<col.length;i++){
                row[0] =idr ;
                row[1] = idm;
                row[2] = idp;
                row[3] = DR;
                row[4] = H;
                model.addColumn(row[i]);
            }
            for(int i=0;i<list.size();i++){
          jScrollPane1.setViewportView(jTable1);
                row[0]=list.get(i).getidrdv();
                row[1]=list.get(i).getidmedecin();
                row[2]=list.get(i).getidpatient();
                row[3]=list.get(i).getdaterdv();
                row[4]=list.get(i).getheurerdv();
                model.addRow(row);
            } 
           
  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Afficher Tout");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jRadioButton1.setText("TOUT LES MEDECINS");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("TOUT LES PATIENTS");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("TOUS LES RENDEZ-VOUS");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("Retour");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jRadioButton1)
                .addGap(98, 98, 98)
                .addComponent(jRadioButton2)
                .addGap(106, 106, 106)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jRadioButton4)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        show_medcin();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       show_patient();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        show_RDV();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        this.setVisible(false);
        new dashboard().setVisible(true);
    }//GEN-LAST:event_jRadioButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
