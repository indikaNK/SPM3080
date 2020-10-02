/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import DBUtils.DBManager;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

/**
 *
 * @author Vinoth
 */
public class AddGrpNumber extends javax.swing.JFrame {

    
     ObjectId ID;
    /**
     * Creates new form AddGrpNumber
     */
    public AddGrpNumber() {
        initComponents();
        update1();
         update2();
           update3();
           displayTable1();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        GIDList = new javax.swing.JTable();
        GenerateButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        AddYearButton = new javax.swing.JButton();
        CreateSubGrpButton = new javax.swing.JButton();
        AddTagButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Gorup ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Programme");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Year");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Group Number");

        jComboBox1.setBackground(new java.awt.Color(153, 153, 153));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox3.setBackground(new java.awt.Color(153, 153, 153));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setBackground(new java.awt.Color(153, 153, 153));

        GIDList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Group ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        GIDList.setFocusable(false);
        GIDList.setRowHeight(35);
        GIDList.setShowHorizontalLines(false);
        GIDList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GIDListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(GIDList);

        GenerateButton.setBackground(new java.awt.Color(102, 255, 204));
        GenerateButton.setText("Generate Group ID");
        GenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateButtonActionPerformed(evt);
            }
        });

        RemoveButton.setBackground(new java.awt.Color(255, 102, 102));
        RemoveButton.setText("Remove Group ID");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(134, 134, 134)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RemoveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GenerateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(98, 98, 98)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(GenerateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        AddYearButton.setBackground(new java.awt.Color(153, 153, 255));
        AddYearButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AddYearButton.setForeground(new java.awt.Color(255, 255, 255));
        AddYearButton.setText("Add Year&Semester");
        AddYearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddYearButtonActionPerformed(evt);
            }
        });

        CreateSubGrpButton.setBackground(new java.awt.Color(102, 102, 255));
        CreateSubGrpButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        CreateSubGrpButton.setForeground(new java.awt.Color(255, 255, 255));
        CreateSubGrpButton.setText("Create SubGroup ID");
        CreateSubGrpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateSubGrpButtonActionPerformed(evt);
            }
        });

        AddTagButton.setBackground(new java.awt.Color(102, 51, 255));
        AddTagButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AddTagButton.setForeground(new java.awt.Color(255, 255, 255));
        AddTagButton.setText("Add Tag");
        AddTagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTagButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(AddYearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(CreateSubGrpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(AddTagButton, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddYearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateSubGrpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddTagButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void GIDListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GIDListMouseClicked
        // TODO add your handling code here:
          DefaultTableModel model = (DefaultTableModel) GIDList.getModel();
        int selectedIndex = GIDList.getSelectedRow();
        ID= (ObjectId) model.getValueAt(selectedIndex,0);

    }//GEN-LAST:event_GIDListMouseClicked

    private void GenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateButtonActionPerformed
        // TODO add your handling code here:
        
          String ySem =(String) jComboBox1.getSelectedItem();
         String programme =(String) jComboBox3.getSelectedItem();
         String gnum = (String) jComboBox4.getSelectedItem();
         String Sid = ySem+"."+programme+"."+gnum;
         
        if(ySem.length()==0){
             JOptionPane.showMessageDialog(null, "Select the year");
        
        }
        else if(programme.length()==0){
             JOptionPane.showMessageDialog(null, "Selectr the programme");
        }  
        else{
         
            try{
         
          
          
          GroupID grpId = new GroupID(ySem,programme,gnum);
         
          DBObject doc = createDBObject(grpId);
          DB MyDb = null;
          
             try
            {
                MyDb = DBManager.getDatabase();
            }
            catch (UnknownHostException ex)
            {
                JOptionPane.showMessageDialog(null, "Error When Connecting to DB");
            }
            DBCollection col = MyDb.getCollection("GroupID");
             BasicDBObject theQuery = new BasicDBObject("GrpID", Sid);
            DBObject result = col.findOne(theQuery);
            
            if(result==null){
            WriteResult result1 = col.insert(doc);
            JOptionPane.showMessageDialog(null, "added Successfully");
            
                 jComboBox1.setSelectedItem(null);
              jComboBox3.setSelectedItem(null);
                jComboBox4.setSelectedItem(null);
              
      
                displayTable1();

            }
            else{
             JOptionPane.showMessageDialog(null, "Already Added");
            
            }} catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Insertion Failed  please Fill Details to add!" + e.toString());
           
        }}
      
    }//GEN-LAST:event_GenerateButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) GIDList.getModel();
           int row = GIDList.getSelectedRow();
        ID = (ObjectId) GIDList.getModel().getValueAt(row, 0);
        
        DB MyDb = null;
        try
          {
            MyDb = DBManager.getDatabase();
          }
          catch (UnknownHostException e)
           {
                JOptionPane.showMessageDialog(null, "Error When Connecting to DB" + e);
           }
        DBCollection col = MyDb.getCollection("GroupID");
        BasicDBObject theQuery = new BasicDBObject();
        theQuery.put("_id", ID);
        WriteResult result = col.remove(theQuery);
          JOptionPane.showMessageDialog(null, "Deleted Succesfully!");
         
        displayTable1();
      

    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void CreateSubGrpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateSubGrpButtonActionPerformed
        // TODO add your handling code here:
           this.setVisible(false);
        new AddSubNumber().setVisible(true);
        
    }//GEN-LAST:event_CreateSubGrpButtonActionPerformed

    private void AddYearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddYearButtonActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
     
        new AddStudent().setVisible(true);
    }//GEN-LAST:event_AddYearButtonActionPerformed

    private void AddTagButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTagButtonActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        new AddTag().setVisible(true);
    }//GEN-LAST:event_AddTagButtonActionPerformed

    
    private void update1(){
    
     DB MyDb = null;
        DBCursor cursor = null;
        try {
            MyDb = DBManager.getDatabase();
            DBCollection coll = MyDb.getCollection("Student");
            cursor = coll.find();

        
           

            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
               // String id = (String)obj.get(".id");
             
                        jComboBox1.addItem((String) obj.get("Ysem"));
               
              
            }
          
            cursor.close(); 
             jComboBox1.setSelectedItem(null);
            //MyDb.close();
        }catch(Exception e){
            System.err.println("Error in displayTable() method === "+e);
        }
    
    
    
    
    
    
    }
    
    private void update2(){
    
     DB MyDb = null;
        DBCursor cursor = null;
        try {
            MyDb = DBManager.getDatabase();
            DBCollection coll = MyDb.getCollection("Programme");
            cursor = coll.find();

        
           

            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
               // String id = (String)obj.get(".id");
             
                        jComboBox3.addItem((String) obj.get("programme"));
                           
              
            }
          
            cursor.close(); 
             jComboBox3.setSelectedItem(null);
            //MyDb.close();
        }catch(Exception e){
            System.err.println("Error in displayTable() method === "+e);
        }
    }
    
     private void update3(){
    
     DB MyDb = null;
        DBCursor cursor = null;
        try {
            MyDb = DBManager.getDatabase();
            DBCollection coll = MyDb.getCollection("GroupNumber");
            cursor = coll.find();

        
           

            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
               // String id = (String)obj.get(".id");
             
                        jComboBox4.addItem((String) obj.get("GrpNum").toString());
             
              
            }
          
            cursor.close(); 
             jComboBox4.setSelectedItem(null);
            //MyDb.close();
        }catch(Exception e){
            System.err.println("Error in displayTable() method === "+e);
        }
    }
     
     private void displayTable1(){
          DB MyDb = null;
        DBCursor cursor = null;
        try {
            MyDb = DBManager.getDatabase();
            DBCollection coll = MyDb.getCollection("GroupID");
            cursor = coll.find();

            String[] columnNames = {"ID","GroupID" };
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
           

            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
               
                String GrpID = (String)obj.get("GrpID");
              
                ObjectId id = (ObjectId)obj.get("_id");
                model.addRow(new Object[] {id,GrpID});
            }
            GIDList.setModel(model);
              GIDList.getColumnModel().getColumn(0).setMinWidth(0);
             GIDList.getColumnModel().getColumn(0).setMaxWidth(0);
            cursor.close(); 
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
            java.util.logging.Logger.getLogger(AddGrpNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddGrpNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddGrpNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGrpNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddGrpNumber().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTagButton;
    private javax.swing.JButton AddYearButton;
    private javax.swing.JButton CreateSubGrpButton;
    private javax.swing.JTable GIDList;
    private javax.swing.JButton GenerateButton;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private DBObject createDBObject(GroupID grpId) {
      BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        
         docBuilder.append("Ysem", grpId.Ysem);
        docBuilder.append("programme", grpId.programme);
        docBuilder.append("Gnum", grpId.Gnum);
         docBuilder.append("GrpID", grpId.GrpID);
        return docBuilder.get();
    }
}
