/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import java.awt.Dimension;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.text.Document;
/**
 *
 * @author Thisura
 */


public class TimeTable extends javax.swing.JPanel {

        DB db = null;
        DBCollection col=null;
        DBCollection col2=null;
        DBCollection col3=null;
        DBCollection col4=null;
        DBCursor sessionObjects = null;
        DBCursor prlsessioObjects = null;
        DBCursor cnvsessionObjects = null;
        String startingTime = "";
        String noOfWorkingHours = "";
        String timeSlotDuration = "";
        ArrayList<String> timeSlotArray = null;
        int tableHieght = 10;
        int tableWidth = 6;
        String[] workingDays = null;
        Object[] titles =null;
        HashMap<String, String> lectureList = null;
        HashMap<String, String> stdGroupList = null;
        HashMap<String, String> roomList = null;
    /**
     * Creates new form TimeTable
     */
    public TimeTable() {
        initComponents();
         try
        {
        db = DBManager.getDatabase();
        }
        catch (UnknownHostException ex)
        {
        JOptionPane.showMessageDialog(null, "Error When Connecting to DB");
        }
        
        DBObject settingsObject=null;
        try {
            //get settings table data
            col = db.getCollection("Setting");
            BasicDBObject searchQuery = new BasicDBObject().append("SettingId", 2);
            settingsObject= col.findOne(searchQuery);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error When getting data from collection");
        }
        
        startingTime = settingsObject.get("StartTime").toString();
        noOfWorkingHours = settingsObject.get("WorkingTimePerDay").toString();
        timeSlotDuration = settingsObject.get("TimeSlot").toString();
        
        
        //generate time slots for table
        timeSlotArray = generateTimeSlotsTable(startingTime, noOfWorkingHours, timeSlotDuration);
        
        tableHieght = timeSlotArray.size();
        tableWidth = Integer.parseInt(settingsObject.get("NoOfWorkingDays").toString());
        
        String str = settingsObject.get("WorkingDays").toString();
                str = str.replaceAll("[^a-zA-Z0-9,]", ""); 
                workingDays = str.split(",");
                
        titles = createTableTitles();
        
        lectureList = getItemList("Employee ","Employee ID","Employee_Name");
        roomList = getItemList("Rooms", "roomNumber", "type");
        
        lectureList.forEach((k, v) -> {
            jComboBox3.addItem(v);
        });
        roomList.forEach((k, v) -> {
            jComboBox2.addItem(k);
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setText("Select Lecture");

        jButton4.setText("Generate");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jDesktopPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("  Lecturer  ", jPanel1);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        jLabel1.setText("Select Student Group");

        jButton2.setText("Generate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Y1.S1.IT.01", "Y3.S1.SE.01" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("  Student Group  ", jPanel2);

        jLabel2.setText("Select Room");

        jButton3.setText("Generate");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("  Room  ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        //Get selected student group
        String stdGroup = jComboBox1.getSelectedItem().toString();
        ArrayList<String> sessionIdArray = new ArrayList<String>();
        
        Object[][] ttable  = new Object[tableHieght][tableWidth+1];
        
        
        
        //get sessions table data
        col = db.getCollection("Sessions");
        sessionObjects =col.find();
        
        
        //Get sessions which matches the student group
        if(sessionObjects != null){
            while(sessionObjects.hasNext()){
                DBObject sessionObj = sessionObjects.next();
                if(sessionObj.get("Group_ID").equals(stdGroup)){
                    if(sessionObj.get("Session_ID") != null){
                        sessionIdArray.add(sessionObj.get("Session_ID").toString());
                    }
                    
                }
            }
        }
        
        //get Schedule table data
        col2 = db.getCollection("RE_Schedules");
        DBCursor scheduleObjects =col2.find();
        
        
        
        //Get schedules which matches the sessionid
        if(scheduleObjects != null){
            while(scheduleObjects.hasNext()){
                DBObject scheduleObj = scheduleObjects.next();
                
                int i=0;
                while(i<sessionIdArray.size()){
                    
                    if(scheduleObj.get("session").equals(sessionIdArray.get(i++))){
                        
                        sessionObjects =col.find();
                        if(sessionObjects != null){
                            while(sessionObjects.hasNext()){
                                DBObject sessionObj = sessionObjects.next();
                                
                                if(sessionObj.get("Session_ID").equals(scheduleObj.get("session"))){
                                    
                                    int[] x = searchTimeSlot(scheduleObj.get("day").toString(),scheduleObj.get("startTime").toString());
                                    int duration = Integer.parseInt(sessionObj.get("Duration").toString());
                                    int j=0;
                                    while(j<duration){
                                        ttable[(x[0]+j)][x[1]] = sessionObj.get("Group_ID")+"\n"+sessionObj.get("Subject_Code")+"-"
                                            +sessionObj.get("Subject")+" ("+sessionObj.get("Tag")+")\n"+scheduleObj.get("room");
                                        j++;
                                    }
                                    
                                }
                            }
                        }
                        
                    }
                }
            }
        }
        
        //Set times in timetable
            int i = 0;
            while(i<tableHieght){
                ttable[i][0] = timeSlotArray.get(i);
                i++;
            }
            
        //Set titles
//        Object[] titles = createTableTitles();
        
        jDesktopPane1.removeAll();
        try {
           CustomTableModel tt = new CustomTableModel(ttable,titles);           
            jDesktopPane1.add(tt).setVisible(true);
            tt.setSize(jDesktopPane1.getWidth(), jDesktopPane1.getHeight());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        //Get selected room
        String room = jComboBox2.getSelectedItem().toString();
        
        ArrayList<String> sessionIdArray = new ArrayList<String>();
        
        
        Object[][] ttable  = new Object[tableHieght][tableWidth+1];
        
        
        
        //get sessions table data
        col = db.getCollection("Sessions");
//        sessionObjects =col.find();
        
        
        
        //get Schedule table data
        col2 = db.getCollection("RE_Schedules");
        DBCursor scheduleObjects1 =col2.find();
        
        
        //Get session IDs which matches the room
        if(scheduleObjects1 != null){
            while(scheduleObjects1.hasNext()){
                DBObject scheduleObj1 = scheduleObjects1.next();
                if(scheduleObj1.get("room").equals(room)){
                    if(scheduleObj1.get("session") != null){
                        sessionIdArray.add(scheduleObj1.get("session").toString());
                    }
                    
                }
            }
        }
        
        DBCursor scheduleObjects =col2.find();
        
        //Get schedules which matches the sessionid
        if(scheduleObjects != null){
            while(scheduleObjects.hasNext()){
                DBObject scheduleObj = scheduleObjects.next();
                int i=0;
                while(i<sessionIdArray.size()){
                    if(scheduleObj.get("session").equals(sessionIdArray.get(i++))){
                        sessionObjects =col.find();
                        if(sessionObjects != null){
                            while(sessionObjects.hasNext()){
                                DBObject sessionObj = sessionObjects.next();
                                if(sessionObj.get("Session_ID").equals(scheduleObj.get("session"))){
                                    int[] x = searchTimeSlot(scheduleObj.get("day").toString(),scheduleObj.get("startTime").toString());
                                    int duration = Integer.parseInt(sessionObj.get("Duration").toString());
                                    int j=0;
                                    while(j<duration){
                                        ttable[(x[0]+j)][x[1]] = sessionObj.get("Subject_Code")+"-"+sessionObj.get("Subject")+" ("+sessionObj.get("Tag")+")\n"+sessionObj.get("Group_ID");
                                        j++;
                                    }
                                    
                                }
                            }
                        }
                        
                    }
                }
            }
        }
        
        //Set times in timetable
            int i = 0;
            while(i<tableHieght){
                ttable[i][0] = timeSlotArray.get(i);
                i++;
            }
            
        //Set titles
//        Object[] titles = createTableTitles();
        
        jDesktopPane2.removeAll();
        try {
           CustomTableModel tt = new CustomTableModel(ttable,titles);           
            jDesktopPane2.add(tt).setVisible(true);
            tt.setSize(jDesktopPane2.getWidth(), jDesktopPane2.getHeight());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        //Get selected student group
        String lectureStr = jComboBox3.getSelectedItem().toString();
        String lecture = "";
        for (Map.Entry ele : lectureList.entrySet()) {
            String key = (String)ele.getKey();
            if(ele.getValue().toString().equals(lectureStr)){
                lecture = ele.getKey().toString();
            }
        }
        
        ArrayList<String> sessionIdArray = new ArrayList<String>();
        
        Object[][] ttable  = new Object[tableHieght][tableWidth+1];
        
        
        
        //get sessions table data
        col = db.getCollection("Sessions");
        sessionObjects =col.find();
        
        
        //Get sessions which matches the lecturer
        if(sessionObjects != null){
            while(sessionObjects.hasNext()){
                DBObject sessionObj = sessionObjects.next();
                
                String str = sessionObj.get("Lecturers").toString();
                str = str.replaceAll("[^a-zA-Z0-9,]", ""); 
                String[] lecturers = str.split(",");
                int k=0;
                while(k<lecturers.length){
                    if(lecturers[k].equals(lecture)){
                        if(sessionObj.get("Session_ID") != null){
                            sessionIdArray.add(sessionObj.get("Session_ID").toString());
                        }

                    }
                    k++;
                }
                
            }
        }
        
        //get parallel sessions table data
        col = db.getCollection("ParallelSessions");
        prlsessioObjects =col.find();
        
        //Get parallel sessions which matches the lecturer
        if(prlsessioObjects != null){
            while(prlsessioObjects.hasNext()){
                DBObject prlsessionObj = prlsessioObjects.next();
                
                List<Document> sesList =(List<Document>) prlsessionObj.get("session");
                boolean lecIsHere = false;
                int i = 0;
                while(i<sesList.size()){
                    HashMap<String,String> ses = (HashMap<String,String>) sesList.get(i);
                    String lec = ses.get("lecturer").toString();
                    if(lec.equals(lectureStr)){
                            
                            lecIsHere = true;
                    }
                    i++;
                }
                if(lecIsHere){
                    sessionIdArray.add(prlsessionObj.get("P_id").toString());
                }
                
            }
            
        }
        
        //get consecutive sessions table data
        col = db.getCollection("ConstSession");
        cnvsessionObjects =col.find();
        
        //Get consecutive sessions which matches the lecturer
        if(cnvsessionObjects != null){
            while(cnvsessionObjects.hasNext()){
                DBObject cnvsessionObj = cnvsessionObjects.next();
                
                ArrayList<String> list = new ArrayList<String>();
                ListIterator<Object> lecList;
                try {
                    lecList = ((BasicDBList) cnvsessionObj.get("lecturer")).listIterator();


                    while(lecList.hasNext()){

                        Object nextItem = lecList.next();



                        list.add((String) nextItem);


                    }
                } catch (Exception e) {
                }
                
                boolean lecIsHere = false;
                int i = 0;
                while(i<list.size()){
                    String lec = list.get(i);
                    if(lec.equals(lectureStr)){
                            lecIsHere = true;
                    }
                    i++;
                }
                if(lecIsHere){
                    sessionIdArray.add(cnvsessionObj.get("C_id").toString());
                }
                
            }
        }
        
        //testing
            for(int i=0;i<sessionIdArray.size();i++){
                System.out.println("with pids:"+sessionIdArray.get(i));
            }
        
        //get Schedule table data
        col2 = db.getCollection("RE_Schedules");
        DBCursor scheduleObjects =col2.find();
        
        col = db.getCollection("Sessions");
        DBCursor sessionObjects =col.find();
        
        col3 = db.getCollection("ParallelSessions");
        DBCursor prlsessObjects =col3.find();
        
        col4 = db.getCollection("ConstSession");
        DBCursor cnvsessObjects =col4.find();
        
        //Get schedules which matches the sessionid
        if(scheduleObjects != null){
            while(scheduleObjects.hasNext()){
                DBObject scheduleObj = scheduleObjects.next();
                
                int i=0;
                while(i<sessionIdArray.size()){
                    
                    if(scheduleObj.get("session").equals(sessionIdArray.get(i))){
                        String arrItemSessId = sessionIdArray.get(i);
                        String idType= arrItemSessId.substring(0,1);
                        
                        if(idType.equals("S")){
                            
                            sessionObjects =col.find();
                            
                            if(sessionObjects != null){
                                while(sessionObjects.hasNext()){
                                    DBObject sessionObj = sessionObjects.next();
                                    
                                    if(sessionObj.get("Session_ID").equals(scheduleObj.get("session"))){
                                        System.out.println("day-"+scheduleObj.get("day").toString());
                                        System.out.println("stime-"+scheduleObj.get("startTime").toString());
                                        System.out.println("dur-"+sessionObj.get("Duration").toString());
                                        int[] x = searchTimeSlot(scheduleObj.get("day").toString(),scheduleObj.get("startTime").toString());
                                        System.out.println("x-"+x[0]+","+x[1]);
                                        int duration = Integer.parseInt(sessionObj.get("Duration").toString());
                                        int j=0;
                                        while(j<duration){
                                            System.out.println("j:"+j);
                                            ttable[(x[0]+j)][x[1]] = sessionObj.get("Group_ID")+"\n"+sessionObj.get("Subject_Code")+"-"
                                                +sessionObj.get("Subject")+" ("+sessionObj.get("Tag")+")\n"+scheduleObj.get("room");
                                            System.out.println("result->"+ttable[(x[0]+j)][x[1]]);
                                            j++;
                                        }

                                    }
                                }
                            }
                        }else if(idType.equals("P")){
                            System.out.println("inside P");
                        }
                        else if(idType.equals("C")){
                            System.out.println("inside C");
                        }
                        
                        
                    }
                    i++;
                }
            }
        }
        
        //Set times in timetable
            int i = 0;
            while(i<tableHieght){
                ttable[i][0] = timeSlotArray.get(i);
                i++;
            }
            
        //Set titles
        Object[] titles = createTableTitles();
        
        jDesktopPane3.removeAll();
        try {
           CustomTableModel tt = new CustomTableModel(ttable,titles);           
            jDesktopPane3.add(tt).setVisible(true);
            tt.setSize(jDesktopPane3.getWidth(), jDesktopPane3.getHeight());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    ////search time slot
    public int[] searchTimeSlot(String day, String starttime){
        int[] loc = new int[2];
        
        int i = 0;
        while(i<tableHieght){
            String start= timeSlotArray.get(i).substring(0, 5);
            if(starttime.equals(start)){
                loc[0] = i;
            }
            i++;
        }
        
        int j = 0;
        while(j<tableWidth){
            String daay= workingDays[j];
            if(day.equals(daay)){
                loc[1] = j+1;
            }
            j++;
        }
        return loc;
    }
    
    
    //generate time slots
    public ArrayList<String> generateTimeSlotsTable(String starttime, String noOfWorkingTime, String timeslot){
     
        // show time slots in a table
        String[] parts = starttime.split(":");
        int time = Integer.parseInt(parts[0])*60+Integer.parseInt(parts[1]);
        String[] partss = noOfWorkingTime.split(":");
        int workingTime = Integer.parseInt(partss[0])*60+Integer.parseInt(partss[1]);
        
        int end = time+workingTime;
        
        int slottime ;
        if(timeslot.equals("30_MINUTES")){
            slottime = 30;
        }else{
            slottime = 60;
        }
        
        ArrayList<String> time_slots_arr = new ArrayList<String>();
        
        
        
        while(time< end){
            String start_h = String.valueOf(time/60);
            if(start_h.length()<2){
                start_h = "0"+start_h;
            }
            String start_m = String.valueOf(time%60);
            if(start_m.length()<2){
                start_m = start_m+"0";
            }
            String end_h = String.valueOf((time+slottime)/60);
            if(end_h.length()<2){
                end_h = "0"+end_h;
            }
            String end_m = String.valueOf((time+slottime)%60);
            if(end_m.length()<2){
                end_m = end_m+"0";
            }
            String slot = start_h+":"+start_m+" - "+end_h+":"+end_m;
            time_slots_arr.add(slot);
            time = time+slottime;
        }
        
//        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
//        
//        model.setRowCount(0);
//        int a=0;
//        while(a<time_slots_arr.size()){
//            model.addRow(new Object[]{time_slots_arr.get(a++)});
//        }
        return time_slots_arr;
        
    }
    
    public Object[] createTableTitles(){
        Object[] titles=null;
        if(tableWidth==7){
             titles = new Object[] {"", workingDays[0], workingDays[1], workingDays[2], workingDays[3], workingDays[4], workingDays[5], workingDays[6]};
        }else if(tableWidth==6){
             titles = new Object[] {"", workingDays[0], workingDays[1], workingDays[2], workingDays[3], workingDays[4], workingDays[5]};
        }else if(tableWidth==5){
             titles = new Object[] {"", workingDays[0], workingDays[1], workingDays[2], workingDays[3], workingDays[4]};
        }else if(tableWidth==4){
             titles = new Object[] {"", workingDays[0], workingDays[1], workingDays[2], workingDays[3]};
        }else if(tableWidth==3){
             titles = new Object[] {"", workingDays[0], workingDays[1], workingDays[2]};
        }else if(tableWidth==2){
             titles = new Object[] {"", workingDays[0], workingDays[1]};
        }else if(tableWidth==1){
             titles = new Object[] {"", workingDays[0]};
        }else if(tableWidth==0){
             titles = new Object[] {""};
        }
        
        return titles;
    }
    
    public HashMap<String, String> getItemList(String table_name, String id_col, String name_col){
        
        DB database=null;
        HashMap<String, String> data = new HashMap<String, String>();
        
        
        try
        {
        database = DBManager.getDatabase();
        }
        catch (UnknownHostException ex)
        {
        JOptionPane.showMessageDialog(null, "Error When Connecting to DB");
        }
        
        //get sessions table data
        col = database.getCollection(table_name);
        DBCursor objects =col.find();
        
        if(objects != null){
            while(objects.hasNext()){
                DBObject obj = objects.next();
                data.put(obj.get(id_col).toString(),obj.get(name_col).toString());
            }
        }
        return data;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
