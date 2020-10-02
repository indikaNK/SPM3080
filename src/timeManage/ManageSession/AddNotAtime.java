/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage.ManageSession;

import timeManage.DBManager;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinoth
 */
public class AddNotAtime extends javax.swing.JFrame {

    /**
     * Creates new form AddNotAtime
     */
    public AddNotAtime() {
        initComponents();
      
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
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        timePicker1 = new com.github.lgooddatepicker.components.TimePicker();
        timePicker2 = new com.github.lgooddatepicker.components.TimePicker();
        addconstSession = new javax.swing.JButton();
        AddParallelSession = new javax.swing.JButton();
        AddTagButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Not Available Time", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jLabel1.setText("Choose");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Lecturer");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Group");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Sub-Group");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Day");

        jLabel4.setText("From");

        jLabel5.setText("To");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None","MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY","FRIDAY" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(134, 134, 134)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(27, 27, 27)
                                .addComponent(jRadioButton2)))
                        .addGap(53, 53, 53)
                        .addComponent(jRadioButton3))
                    .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(timePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        addconstSession.setBackground(new java.awt.Color(153, 153, 255));
        addconstSession.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addconstSession.setForeground(new java.awt.Color(255, 255, 255));
        addconstSession.setText("Add Consecutive Sessions ");
        addconstSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addconstSessionActionPerformed(evt);
            }
        });

        AddParallelSession.setBackground(new java.awt.Color(102, 102, 255));
        AddParallelSession.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AddParallelSession.setForeground(new java.awt.Color(255, 255, 255));
        AddParallelSession.setText("Add ParallelSessions");
        AddParallelSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddParallelSessionActionPerformed(evt);
            }
        });

        AddTagButton3.setBackground(new java.awt.Color(102, 51, 255));
        AddTagButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AddTagButton3.setForeground(new java.awt.Color(255, 255, 255));
        AddTagButton3.setText("Not Overlap Session");
        AddTagButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTagButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(addconstSession)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(AddParallelSession, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(AddTagButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addconstSession, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddTagButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddParallelSession, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
         if(jRadioButton1.isSelected()){
            update3();
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       // update3();
            try{
           String choosed = null;
           
           if(jRadioButton2.isSelected()){
                choosed= jRadioButton2.getText();
           }
           else  if(jRadioButton3.isSelected()){
               choosed= jRadioButton3.getText();
           }
           else if(jRadioButton1.isSelected()){
                choosed= jRadioButton1.getText();
           }
           
        
          String name =(String) jComboBox1.getSelectedItem();
          String day =(String) jComboBox3.getSelectedItem();
          LocalTime Stime= timePicker1.getTime();
          LocalTime Etime = timePicker2.getTime();
          String t1= Stime.toString();
          String t2= Etime.toString();
         
          long minutesBetween = ChronoUnit.MINUTES.between(Stime,Etime);
          long minutesBetween1 = ChronoUnit.HOURS.between(Stime,Etime);
           System.out.println(minutesBetween);
           System.out.println(minutesBetween1);
           System.out.println(choosed+',' +name+','+day+','+t1+','+t2);

//          GroupID grpId = new GroupID(ySem,programme,gnum);
            NotAvailableTime NotAvailable= new NotAvailableTime(choosed,name,day,t1,t2);
        
             DBObject doc = createDBObject(NotAvailable);
            DB MyDb = null;
          
             try
            {
                MyDb = DBManager.getDatabase();
            }
            catch (UnknownHostException ex)
            {
                JOptionPane.showMessageDialog(null, "Error When Connecting to DB");
            }
            DBCollection col = MyDb.getCollection("NotAvailable");
            
            WriteResult result1 = col.insert(doc);
            JOptionPane.showMessageDialog(null, "added Successfully");
//            
                 jComboBox1.setSelectedItem(null);
              jComboBox3.setSelectedItem(null);
               
              timePicker1.clear();
              timePicker2.clear();
//      
//               

           
                 
               
               
            } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Insertion Failed  please Fill Details to add!" + e.toString());
           
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton2.isSelected()){
            update1();
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
         if(jRadioButton3.isSelected()){
            update2();
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void addconstSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addconstSessionActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);

        new AddConstSession().setVisible(true);
    }//GEN-LAST:event_addconstSessionActionPerformed

    private void AddParallelSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddParallelSessionActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AddParallelSession().setVisible(true);
    }//GEN-LAST:event_AddParallelSessionActionPerformed

    private void AddTagButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTagButton3ActionPerformed
        // TODO add your handling code here:
//        this.setVisible(false);
//        new AddTag().setVisible(true);
    }//GEN-LAST:event_AddTagButton3ActionPerformed

     private void update1(){
    
     DB MyDb = null;
        DBCursor cursor = null;
        try {
            MyDb = DBManager.getDatabase();
            DBCollection coll = MyDb.getCollection("GroupID");
            cursor = coll.find();
              jComboBox1.removeAllItems();

        
           

            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
               // String id = (String)obj.get(".id");
                      
                        jComboBox1.addItem((String) obj.get("GrpID"));
               
              
            }
          
            cursor.close(); 
             jComboBox1.setSelectedItem(null);
            //MyDb.close();
        }catch(Exception e){
            System.err.println("Error in displayTable() method === "+e);
        }}
     
      private void update2(){
     jComboBox1.removeAllItems();
     DB MyDb = null;
        DBCursor cursor = null;
        try {
            MyDb = DBManager.getDatabase();
            DBCollection coll = MyDb.getCollection("SubGroupID");
            cursor = coll.find();
                
        
           

            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
               // String id = (String)obj.get(".id");
                       
                        jComboBox1.addItem((String) obj.get("SID"));
               
              
            }
          
            cursor.close(); 
             jComboBox1.setSelectedItem(null);
            //MyDb.close();
        }catch(Exception e){
            System.err.println("Error in displayTable() method === "+e);
        }}
      
        private void update3(){
     jComboBox1.removeAllItems();
     DB MyDb = null;
        DBCursor cursor = null;
        try {
            MyDb = DBManager.getDatabase();
            DBCollection coll = MyDb.getCollection("lec");
            cursor = coll.find();
                
       
            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
               // String id = (String)obj.get(".id");
                       
                        jComboBox1.addItem((String) obj.get("name").toString());
                        System.out.println("update3");
              
            }
          
            cursor.close(); 
             jComboBox1.setSelectedItem(null);
            //MyDb.close();
        }catch(Exception e){
            System.err.println("Error in displayTable() method === "+e);
        }
        }
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
            java.util.logging.Logger.getLogger(AddNotAtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNotAtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNotAtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNotAtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNotAtime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddParallelSession;
    private javax.swing.JButton AddTagButton3;
    private javax.swing.JButton addconstSession;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private com.github.lgooddatepicker.components.TimePicker timePicker1;
    private com.github.lgooddatepicker.components.TimePicker timePicker2;
    // End of variables declaration//GEN-END:variables

    private DBObject createDBObject(NotAvailableTime NotAvailable) {
       
         BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        
         docBuilder.append("choosed", NotAvailable.choosed);
        docBuilder.append("name", NotAvailable.name);
        docBuilder.append("day", NotAvailable.day);
         docBuilder.append("startTime", NotAvailable.from);
         docBuilder.append("endTime", NotAvailable.to);
        return docBuilder.get();
    }
}
