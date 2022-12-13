package gesrdvv;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class gescatalogue extends javax.swing.JFrame {
    private static String url = "jdbc:mysql://localhost:3306/gesrdv";    
    private static String driverName = "com.mysql.cj.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "";
    private static Connection con;
    
    public gescatalogue() {
        initComponents();
                       this.setLocationRelativeTo(null);
        setIconImage((new ImageIcon(getClass().getResource("/images/hospital.png")).getImage()));

         try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM catalogue";
          ResultSet res = s.executeQuery(sql);
          while(res.next()){
              jComboBox1.addItem(res.getString("idcatalogue"));
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }
         show_cat();
    }
    public ArrayList<catalogue> catalogue(){
        ArrayList<catalogue> catList = new ArrayList();
        try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM catalogue";
          ResultSet res = s.executeQuery(sql);
          catalogue cat;
          while(res.next()){
              cat = new catalogue(res.getInt("idcatalogue"),res.getString("lib"));
              catList.add(cat);
          }
        }
        catch(ClassNotFoundException c){
            JOptionPane.showMessageDialog(null,c.getMessage());
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,s.getMessage());
        }
        return catList;
    }
    public void show_cat(){
        ArrayList<catalogue> catList = catalogue();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        Object row[] = new Object[2];
        for(int i = 0;i<catList.size();i++){
            row[0] = catList.get(i).getId();
            row[1] = catList.get(i).getLib();
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion Catalogue");

        jLabel1.setText("Id");

        jLabel2.setText("Nom");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pluss.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/x.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisir..." }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Nova Cond", 0, 24)); // NOI18N
        jLabel3.setText("LISTE DES CATALOGUES");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Libelle"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Arial Nova Cond", 0, 24)); // NOI18N
        jLabel4.setText("GESTION DES CATALOGUES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(62, 62, 62)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addComponent(jButton2))
                        .addGap(53, 53, 53)
                        .addComponent(jButton5))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton2)
                            .addComponent(jButton5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton3))))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedItem() == "Choisir..."){
            jTextField1.setText(null);
        }
        else{
        try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM catalogue WHERE idcatalogue = "+jComboBox1.getSelectedItem()+" ";
          ResultSet res = s.executeQuery(sql);
          while(res.next()){

              jTextField1.setText(res.getString("lib"));
              
              
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }}
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                    if(jTextField1.getText().length() <= 0){
                    JOptionPane.showMessageDialog(null,"Vous n'avais pas saisis un champ obligatoire");
                }
            else{
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO catalogue (lib)"
                    + "VALUES('"+jTextField1.getText()+"')";
            int res = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Les informations sont inseres");

        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,s.getMessage());
        }
        jComboBox1.removeAllItems();
        try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM catalogue";
          ResultSet res = s.executeQuery(sql);
          while(res.next()){
              
              jComboBox1.addItem(res.getString("idcatalogue"));
              jTextField1.setText(res.getString("lib"));
              
              
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }}
                    show_cat();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jTextField1.getText().length() <= 0 ){
                    JOptionPane.showMessageDialog(null,"Vous n'avais pas saisis un champ obligatoire");
                }
        else{
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = "UPDATE catalogue SET lib = '"+jTextField1.getText()+"' where idcatalogue = '"+jComboBox1.getSelectedItem()+"' ";
            int res = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Les informations sont modifiés");

        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,s.getMessage());
        } }
        show_cat();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM catalogue WHERE idcatalogue= '"+jComboBox1.getSelectedItem()+"'";
            int a = JOptionPane.showConfirmDialog(null, "Voulez vraiment supprimer ce catalogue?");
            if(a == 0){
                int res = stmt.executeUpdate(sql);}

        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,s.getMessage());
        }
        jComboBox1.removeAllItems();
        try{
            Class.forName(driverName);
            Connection con = null;
            con = DriverManager.getConnection(url,username,password);
            Statement s = con.createStatement();
            String sql = "SELECT * FROM catalogue";
            ResultSet res = s.executeQuery(sql);
            
            while(res.next()){
                
                jComboBox1.addItem(res.getString("idcatalogue"));
            }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote");
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion");
        }
        show_cat();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       jComboBox1.setSelectedItem("Choisir...");
       jTextField1.setText(null);
    
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       this.setVisible(false);
       new dashboard().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
