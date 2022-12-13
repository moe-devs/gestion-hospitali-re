package gesrdvv;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class medecinRDV extends javax.swing.JFrame {
 private static String url = "jdbc:mysql://localhost:3306/gesrdv";    
    private static String driverName = "com.mysql.cj.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "";
    private static Connection con;
    private static String urlstring;
        Login login = new Login();
    int idmed = login.getMedId();
    public medecinRDV() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage((new ImageIcon(getClass().getResource("/images/hospital.png")).getImage()));
        getPatient();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rendez-vous de médecin");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nom", "Prenom", "Genre", "CIN", "dateNaissance", "CNSS", "dateRDV", "heureRDV"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(jButton1)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(65, 65, 65)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new dashboard().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    public ArrayList<rdvMed> rdvMed(){
        ArrayList<rdvMed> medList = new ArrayList<>();
                try{
          Class.forName(driverName);
          Connection con = null;
          con = DriverManager.getConnection(url,username,password);
          Statement s = con.createStatement();
          String sql = "SELECT * FROM rdv r INNER JOIN patient p ON p.idpatient = r.idpatient  "
                  + "INNER JOIN medecin m on m.idmedecin = r.idmedecin WHERE r.idmedecin = "+idmed+" ";
          ResultSet res = s.executeQuery(sql);
          
          rdvMed med;
          while(res.next()){
              jLabel2.setText("Liste des rendez-vous du docteur : " + res.getString("m.nom") + " " + res.getString("m.prenom"));
              med = new rdvMed(res.getInt("p.idpatient"),res.getString("p.nom"),res.getString("p.prenom"),res.getString("p.genre"),res.getString("p.cin"),res.getString("p.date_naissance"),res.getInt("p.cnss"),res.getString("r.daterdv"),res.getString("r.heurerdv"));
              medList.add(med);
          }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"err de pilote"); 
        }
        catch(SQLException s){
            JOptionPane.showMessageDialog(null,"err de connexion"); 
        }
                return medList;
    }
    public void getPatient(){
               ArrayList<rdvMed> list = rdvMed();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        Object[] row = new Object[9];
        for(int i = 0;i<list.size();i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getNom();
            row[2] = list.get(i).getPre();
            row[3] = list.get(i).getGen();
            row[4] = list.get(i).getCin();
            row[5] = list.get(i).getNaiss();
            row[6] = list.get(i).getCnss();
            row[7] = list.get(i).getDrdv();
            row[8] = list.get(i).getHrdv();
            model.addRow(row);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
