
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kobinath
 */
public class Doctor extends javax.swing.JFrame {

    /**
     * Creates new form employee
     */
    public Doctor() {
        initComponents();
       
    }
    int id;
    String uctype;
    int newid;
    public Doctor(int id,String utype) {
        initComponents();
        this.id=id;
        this.uctype=uctype;
        newid=id;
        //JOptionPane.showMessageDialog(this,newid);
         connect();
        AutoID();
        doctor_table();
  
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public void connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/ehealthcare","root","root");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.ALL, null, ex);
        } catch(SQLException ex)
                {
                    Logger.getLogger(User.class.getName()).log(Level.ALL, null, ex);
                }
    }
    public void AutoID()
    {
        try {
            
            Statement s=con.createStatement();
            rs=s.executeQuery("select MAX(doctorno)from doctor");
            rs.next();
            rs.getString("MAX(doctorno)");
            if(rs.getString("MAX(doctorno)")==null)
                    {
                        lbldno.setText("DS001");
                    }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(doctorno)").substring(2,rs.getString("MAX(doctorno)").length()));
                id++;
                lbldno.setText("DS"+String.format("%03d",id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void doctor_table()
    {
        try {
            pst=con.prepareStatement("select * from doctor where log_id = ?");
            pst.setInt(1,newid);
             rs=pst.executeQuery();
             ResultSetMetaData Rsm=rs.getMetaData();
            int c;
            c=Rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next())
            {
                Vector v2=new Vector();
                for(int i=1;i<=c;i++)
                {//name,special,qualification,channelfee,phone,room,log_id
                v2.add(rs.getString("doctorno"));
                v2.add(rs.getString("name"));
                v2.add(rs.getString("special"));
                v2.add(rs.getString("qualification"));
                v2.add(rs.getString("channelfee"));
                v2.add(rs.getString("phone"));
                v2.add(rs.getString("room"));
                v2.add(rs.getString("log_id"));
                
                
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtdname = new javax.swing.JTextField();
        txtspl = new javax.swing.JTextField();
        lbldno = new javax.swing.JLabel();
        txtqul = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtchfee = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtroom = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doctor Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setText("Doctot No");

        jLabel2.setText("Doctor name");

        jLabel3.setText("Specialization");

        jLabel4.setText("Qualification");

        lbldno.setText("Number");

        jLabel6.setText(" Fee");

        jLabel7.setText("Phone");

        jLabel8.setText("Room No");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(lbldno, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtqul)
                            .addComponent(txtspl)
                            .addComponent(txtdname)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtroom, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtphone)
                            .addComponent(txtchfee))))
                .addGap(106, 106, 106))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbldno))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtspl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtqul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtchfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 460));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, -1, -1));

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 650, -1, -1));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 650, -1, -1));

        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor No", "Doctor Name", "Specialization", "Qualification", "Channel fee", "Phone", "Room No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 740, 460));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DOCTOR REGISTRATION");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background1.jpg"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1290, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String pno=lbldno.getText();
        String pname=txtdname.getText();
        String spl=txtspl.getText();
        String qul=txtdname.getText();
        String chefee=txtchfee.getText();
        String phone=txtphone.getText();
        String room=txtroom.getValue().toString();
        try {
            pst=con.prepareStatement("insert into doctor(doctorno,name,special,qualification,channelfee,phone,room,log_id)values(?,?,?,?,?,?,?,?)");
            pst.setString(1,pno);
            pst.setString(2,pname);
            pst.setString(3,spl);
            pst.setString(4,qul);
            pst.setString(5,chefee);
            pst.setString(6,phone);
            pst.setString(7,room);
            pst.setInt(8,newid);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Doctor Inserted ");
            
            AutoID();
            txtdname.setText("");
            txtspl.setText("");
            txtqul.setText("");
            txtchfee.setText("");
            txtphone.setText("");
            txtroom.setValue(0);
            doctor_table();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int SelectIndex=jTable1.getSelectedRow();
        lbldno.setText(d1.getValueAt(SelectIndex,0).toString());
        txtdname.setText(d1.getValueAt(SelectIndex,1).toString());
        txtspl.setText(d1.getValueAt(SelectIndex,2).toString());
        txtqul.setText(d1.getValueAt(SelectIndex,3).toString());
        txtchfee.setText(d1.getValueAt(SelectIndex,4).toString());
        txtphone.setText(d1.getValueAt(SelectIndex,5).toString());
        txtroom.setValue(Integer.parseInt(d1.getValueAt(SelectIndex,6).toString()));
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String pno=lbldno.getText();
        String pname=txtdname.getText();
        String spl=txtspl.getText();
        String qul=txtqul.getText();
        String chefee=txtchfee.getText();
        String phone=txtphone.getText();
        String room=txtroom.getValue().toString();
        try {
            pst=con.prepareStatement("update doctor set name = ?, special= ?, qualification= ?,channelfee=?, phone=?, room=? where doctorno=?");
            pst.setString(1,pname);
            pst.setString(2,spl);
            pst.setString(3,qul);
            pst.setString(4,chefee);
            pst.setString(5,phone);
            pst.setString(6,room);
            pst.setString(7,pno);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Doctor updated");
            
            AutoID();
            txtdname.setText("");
            txtspl.setText("");
            txtqul.setText("");
            txtchfee.setText("");
            txtphone.setText("");
            txtroom.setValue(0);
            doctor_table();
            jButton1.setEnabled(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String pno=lbldno.getText();
        try {
            pst=con.prepareStatement("delete from doctor where doctorno = ?");
            pst.setString(1,pno);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Doctor information is deleted");
            
            AutoID();
            txtdname.setText("");
            txtspl.setText("");
            txtqul.setText("");
            txtchfee.setText("");
            txtphone.setText("");
            txtroom.setValue(0);
            doctor_table();
            jButton1.setEnabled(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbldno;
    private javax.swing.JTextField txtchfee;
    private javax.swing.JTextField txtdname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtqul;
    private javax.swing.JSpinner txtroom;
    private javax.swing.JTextField txtspl;
    // End of variables declaration//GEN-END:variables

    private JTextField setInt(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JTextField setText(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
