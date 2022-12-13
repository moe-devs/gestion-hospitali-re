package gesrdvv;


import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
public class consultation extends javax.swing.JFrame {
    private static String url = "jdbc:mysql://localhost:3306/gesrdv";    
    private static String driverName = "com.mysql.cj.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "";
    private static Connection con;
    private static String urlstring;
    long catalogue[];
    long medicament[];
    Login login = new Login();
    int idmed = login.getMedId();
    public consultation() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage((new ImageIcon(getClass().getResource("/images/hospital.png")).getImage()));
        catalogue = new long[100];
        medicament = new long[100];
        int index = 0;
        
        
        try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT idcatalogue,lib FROM catalogue";
          ResultSet res = s.executeQuery(sql);
          
          while(res.next()){
              catalogue[index] = res.getLong(1);
              index++;
              jComboBox1.addItem(res.getString("lib"));
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }
        //Get The Observation Table FROM The Database
                try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM consultation WHERE idmedecin = "+idmed+" ";
          ResultSet res = s.executeQuery(sql);
          
          while(res.next()){
              jComboBox4.addItem(res.getString("idconsultation"));
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }
        //Get The Patient Table FROM The Database
        try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM rdv r INNER JOIN medecin m ON m.idmedecin = r.idmedecin INNER JOIN patient p ON "
                  + "p.idpatient = r.idpatient WHERE m.idmedecin = "+idmed+" "
                  ;
          ResultSet res = s.executeQuery(sql);
          
          while(res.next()){
              jComboBox3.addItem(res.getString("r.idpatient"));
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }
       
    }
    public ArrayList<consult> getConsultation(){
        ArrayList<consult> consultList = new ArrayList<>();
        try{
            Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM consultation c INNER JOIN medicament m ON m.idmedicament = c.idmedicament WHERE idconsultation = "+jComboBox4.getSelectedItem()+" ";
          ResultSet res = s.executeQuery(sql);
          consult cL;
          while(res.next()){
              cL = new consult(res.getInt("idconsultation"),res.getInt("idpatient"),res.getInt("pression"),res.getFloat("poids"),res.getInt("coeur"),res.getString("m.libmedicament"),res.getString("observation"));
              consultList.add(cL);
          }
        }
        catch(ClassNotFoundException c){
            JOptionPane.showMessageDialog(null,c.getMessage());
        }
        catch(SQLException c){
            JOptionPane.showMessageDialog(null,c.getMessage());
        }
        return consultList;
    }
    public void show_consultation(){
        ArrayList<consult> list = getConsultation();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        Object[] row = new Object[7];
        for(int i = 0;i<list.size();i++){
            row[0] = list.get(i).getIdconsult();
            row[1] = list.get(i).getIdpat();
            row[2] = list.get(i).getPression();
            row[3] = list.get(i).getPoids();
            row[4] = list.get(i).getCoeur();
            row[5] = list.get(i).getMedicament();
            row[6] = list.get(i).getObservation();
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dossier Médical");
        setResizable(false);

        jLabel1.setText("ID Patient");

        jLabel2.setText("Pression:");

        jLabel3.setText("Poids:");

        jLabel4.setText("Coeur:");

        jLabel5.setText("Catégorie:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Médicaments:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "choisir..." }));

        jLabel7.setText("Observation:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idConsultation", "idpatient", "Pression", "Poids", "Coeur", "idMédicaments", "Observation"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pluss.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/x.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisir..." }));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel8.setText("ID Consultation");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisir..." }));

        jButton1.setText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton7.setText("Ajouter d'autre médicaments");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4)
                                .addComponent(jTextField3)
                                .addComponent(jTextField2)
                                .addComponent(jComboBox2, 0, 117, Short.MAX_VALUE)
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton7))
                        .addGap(44, 44, 44)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(29, 29, 29)
                        .addComponent(jButton3)
                        .addGap(25, 25, 25)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton6)
                            .addComponent(jButton5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jTextField2.getText().length() <= 0 ||jTextField3.getText().length() <= 0 ||jTextField4.getText().length() <= 0 ||jTextArea1.getText().length() <= 0){
                    JOptionPane.showMessageDialog(null,"Vous n'avais pas saisis un champ obligatoire");
        }
        else{
            
        
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO consultation(idpatient,idmedecin,pression,poids,coeur,idmedicament,observation) " // Change it to idmed
            + "VALUES('"+jComboBox3.getSelectedItem()+"',"+idmed+","+jTextField2.getText()+","+jTextField3.getText()+","+jTextField4.getText()+",'"+medicament[jComboBox2.getSelectedIndex()]+"','"+jTextArea1.getText()+"')";
            int res = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Les informations sont inseres");

        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,s.getMessage());
        }
        jComboBox4.removeAllItems();
                //Get The Observation Table FROM The Database
                try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM consultation WHERE idmedecin = "+idmed+""; //Change it to idmed variable
          ResultSet res = s.executeQuery(sql);
          
          while(res.next()){
              jComboBox4.addItem(res.getString("idconsultation"));
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM consultation WHERE idconsultation = "+jComboBox4.getSelectedItem()+"";
            int a = JOptionPane.showConfirmDialog(null, "Voulez vraiment supprimer cet consultation?");
            if(a == 0){
                int res = stmt.executeUpdate(sql);}

        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,s.getMessage());
        }
                        jComboBox4.removeAllItems();
                //Get The Observation Table FROM The Database
                try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM consultation WHERE idmedecin = "+idmed+"";
          ResultSet res = s.executeQuery(sql);
          
          while(res.next()){
              jComboBox4.addItem(res.getString("idconsultation"));
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
        new dashboard().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jTextField2.getText().length() <= 0 ||jTextField3.getText().length() <= 0 ||jTextField4.getText().length() <= 0 ||jTextArea1.getText().length() <= 0){
                    JOptionPane.showMessageDialog(null,"Vous n'avais pas saisis un champ obligatoire");
        }
        else{
               
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = "UPDATE consultation SET idpatient='"+jComboBox3.getSelectedItem()+"',pression='"+jTextField2.getText()+"',poids='"+jTextField3.getText()+"',coeur='"+jTextField4.getText()+"',idmedicament = "+medicament[jComboBox2.getSelectedIndex()]+",observation = '"+jTextArea1.getText()+"' WHERE idconsultation = "+jComboBox4.getSelectedItem()+"  ";
            int res = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Les informations sont modifiés");

        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,s.getMessage());
        } }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        show_consultation();
        try{

            Class.forName(driverName);
            Connection con = null;
            con = DriverManager.getConnection(url,username,password);
            Statement s = con.createStatement();
            String sql = "SELECT * FROM consultation c INNER JOIN medicament m ON c.idmedicament = m.idmedicament INNER JOIN catalogue s "
                    + "ON s.idcatalogue = m.idcatalogue WHERE idconsultation = "+jComboBox4.getSelectedItem()+" ";
            
            ResultSet res = s.executeQuery(sql);

            while(res.next()){
                jComboBox3.setSelectedItem(res.getString("c.idpatient"));
                jTextField2.setText(res.getString("c.pression"));
                jTextField3.setText(res.getString("c.poids"));
                jTextField4.setText(res.getString("c.coeur"));
                jComboBox1.setSelectedItem(res.getString("s.lib") );
                jComboBox2.setSelectedItem(res.getString("m.libmedicament"));
                jTextArea1.setText(res.getString("c.observation"));
            }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote");
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                 model.setRowCount(0); 
                 
        jComboBox3.setSelectedItem("Choisir...");
        jComboBox1.setSelectedItem("Cardiologie et angéiologie");
        jComboBox2.removeAllItems();
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new choixmedic().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int i = 0;
        try{

            Class.forName(driverName);
            Connection con = null;
            con = DriverManager.getConnection(url,username,password);
            Statement s = con.createStatement();
            String sql = "SELECT * FROM medicament WHERE idcatalogue = '"+catalogue[jComboBox1.getSelectedIndex()]+"' ";
            jComboBox2.removeAllItems();
            ResultSet res = s.executeQuery(sql);

            while(res.next()){
                jComboBox2.addItem(res.getString("libmedicament"));
                medicament[i] = res.getLong(1);
                i++;
            }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote");
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
