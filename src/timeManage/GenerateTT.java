/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import static java.lang.Integer.max;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

/**
 *
 * @author Thisura
 */
public class GenerateTT extends javax.swing.JPanel {

    
    HashMap<String, ArrayList<String>> timeslot = new HashMap<String, ArrayList<String>>();
    String starttime,noOfWorkingHrs, slot_time,dayendtime = "";
    ArrayList<String> sessions =new ArrayList<String>();
    ArrayList<String> keyList =new ArrayList<String>();
    DB db = null;
    
    /**
     * Creates new form GenerateTT
     */
    public GenerateTT() {
        initComponents();
        
        
    
    }
    
    
    //get starting time, no of working hour & tyme slot type
    public void getSettingsPageDetails(){
        
        DB SettingDB = null;
        DBCollection col=null;
    
         try
        {
        SettingDB = DBManager.getDatabase();
        }
        catch (UnknownHostException ex)
        {
        JOptionPane.showMessageDialog(null, "Error When Connecting to DB");
        }
        
        DBObject settingsObject=null;
        try {
            //get settings table data
            col = SettingDB.getCollection("Setting");
            BasicDBObject searchQuery = new BasicDBObject().append("SettingId", 2);
            settingsObject= col.findOne(searchQuery);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error When getting data from collection");
        }
        
       if(settingsObject != null){
            starttime = settingsObject.get("StartTime").toString();
            noOfWorkingHrs= settingsObject.get("WorkingTimePerDay").toString();
            slot_time = settingsObject.get("TimeSlot").toString();
            
            int startHrs = Integer.parseInt(starttime.substring(0,2));
            String endMin = starttime.substring(3,5);
            int workingHrs = Integer.parseInt(noOfWorkingHrs.substring(0,2));
            int eetime = startHrs+workingHrs;
            
            DecimalFormat formatter = new DecimalFormat("00");
            String hrsFormatted = formatter.format(eetime);
            
            dayendtime = hrsFormatted+":"+endMin;
       }
        
    }
    
    
    public void addTimeSlotsToHashMap(){
        ArrayList<String> tslot = generateTimeSlots(starttime, noOfWorkingHrs, slot_time);
        String[] weekdays = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
        
        for(int j=0;j<7;j++){
            for(int i=0;i<tslot.size();i++){
                timeslot.put(weekdays[j]+"-"+tslot.get(i), sessions);
                keyList.add(weekdays[j]+"-"+tslot.get(i));
            }
        }
    }
    
    public ArrayList<String> generateTimeSlots(String starttime, String noOfWorkingTime, String timeslot){
     
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
            String slot = start_h+":"+start_m+"-"+end_h+":"+end_m;
            time_slots_arr.add(slot); 
            time = time+slottime;
        }
        
        return time_slots_arr;
        
    }
    
    public void getParallelSessions(){
        
        DBCollection col=null;
        
        DBCursor parSessionObject=null;
        try {
            //get settings table data
            col = db.getCollection("ParallelSessions");
            parSessionObject =col.find();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error When getting data from collection");
        }
        
        if(parSessionObject != null){
            while(parSessionObject.hasNext()){
                DBObject parSession = parSessionObject.next();
                
                String pid = parSession.get("P_id").toString();
                String day= parSession.get("day").toString();
                String stime = parSession.get("stime").toString();
                int duration = Integer.parseInt(parSession.get("duration").toString());
                
                String start = stime;
                if(slot_time.equals("30_MINUTES")){
                    int due = duration*2;
                    while(due>=1){
                    
                        //generate end time
//                        int hrs = Integer.parseInt(start.substring(0, 2))+1;
//                        DecimalFormat formatter = new DecimalFormat("00");
//                        String hrsFormatted = formatter.format(hrs);  
//
//                        String min = start.substring(3, 5);
//                        String etime = hrsFormatted+":"+min;
                        int hrs = Integer.parseInt(start.substring(0,2));
                        int min = Integer.parseInt(start.substring(3,5));
                        String etime="";
                        if(min == 30){
                            DecimalFormat formatter = new DecimalFormat("00");
                            String hrsFormatted = formatter.format(hrs+1);
                            
                            min = 0;
                            String minFormatted = formatter.format(min);
                            
                            etime = hrsFormatted+":"+minFormatted;
                        }else{
                            min = min+30;
                            DecimalFormat formatter = new DecimalFormat("00");
                            String minFormatted = formatter.format(min);
                            String hrsFormatted = formatter.format(hrs);
                            
                            etime = hrsFormatted+":"+minFormatted;
                        }
                        
                        nextHourTimeSLot(day, start, etime, pid);
                        due--;
                        start = etime;
                    }
                }else{
                    int due = duration;
                    while(due>=1){
                    
                        //generate end time
                        int hrs = Integer.parseInt(start.substring(0, 2))+1;
                        DecimalFormat formatter = new DecimalFormat("00");
                        String hrsFormatted = formatter.format(hrs);  

                        String min = start.substring(3, 5);
                        String etime = hrsFormatted+":"+min;

                        nextHourTimeSLot(day, start, etime, pid);

                        due--;
                        start = etime;
                    }
                }
                
            }
        }
        
    }
    
    public void nextHourTimeSLot(String day, String stime,String etime, String pid){

        //generate key
        String key = day+"-"+stime+"-"+etime;

        //add pid to hashmap
        ArrayList<String> list1=new ArrayList<String>();
        ArrayList<String> list = timeslot.get(key);
        int i=0;
        while(i<list.size()){
            list1.add(list.get(i++));
        }
        list1.add(pid);
        timeslot.put(key,list1);
    }
    
    public void getConsecutiveSession(){
        DBCollection col=null;
        
        DBCursor conSessionObject=null;
        try {
            //get settings table data
            col = db.getCollection("ConstSession");
            conSessionObject =col.find();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error When getting data from collection");
        }
        if(conSessionObject != null){
            while(conSessionObject.hasNext()){
                DBObject conSession = conSessionObject.next();
                String csId = conSession.get("C_id").toString();
                int duration = Integer.parseInt(conSession.get("duration").toString());
                
                List<Document> lecList =(List<Document>) conSession.get("lecturer");
                setAtAvailableSlot(csId,lecList,conSession.get("groupId").toString(),"",duration);
            }
        }
    }
    
    public void getSession(){
        DBCollection col=null;
        
        DBCursor sessionObject=null;
        try {
            //get settings table data
            col = db.getCollection("Sessions");
            sessionObject =col.find();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error When getting data from collection");
        }
        
        if(sessionObject != null){
            while(sessionObject.hasNext()){
                DBObject ssession = sessionObject.next();
                String SId = ssession.get("Session_ID").toString();
                int duration = Integer.parseInt(ssession.get("Duration").toString());
                
                List<Document> lecList =(List<Document>) ssession.get("Lecturers");
            
                setAtAvailableSlot(SId,lecList,ssession.get("Group_ID").toString(),"",duration);
                
            }
        }
        
    }
    
    public void setAtAvailableSlot(String cid, List<Document> lecList,String group, String room, int duration){
        String lecturer="";
        boolean res = true;
        int dur = duration;
        if(slot_time.equals("30_MINUTES")){
            dur = dur*2;
        }
        int r = getRandomNumber();
        int i = 0;
        while(i<lecList.size()){
            Object lec = lecList.get(i);
            lecturer = lec.toString();
            
            //check lecturer in name or id
            try {
                int l =Integer.parseInt(lecturer);
                lecturer = getLecturerNameFromEmployeeTable(lecturer);
            } catch (Exception e) {
                System.out.println(e);
            }
            
            res = checkAvailability(keyList.get(r),lecturer,group,room);
            if(!res){
                break;
            }
            i++;
        }
        
        String key = keyList.get(r);
        String[] strArr = key.split("-");
        String keyT= strArr[1];
        
        int hrs = Integer.parseInt(dayendtime.substring(0,2));
        int min = Integer.parseInt(dayendtime.substring(3,5));
        int time = (hrs*60)+min;
        
        int keyHrs = Integer.parseInt(keyT.substring(0,2));
        int keyMin = Integer.parseInt(keyT.substring(3,5));
        int keyTime = (keyHrs*60)+keyMin;
        
        boolean isSuitable = true;
        
        if(duration==3 && keyTime>(time-180)){
            isSuitable = false;
        }else if(duration==2 && keyTime>(time-120)){
            isSuitable = false;
        }else if(duration==1 && keyTime>(time-60)){
            isSuitable = false;
        }
        
        if(res && isSuitable){
            
            while(dur>0){
                ArrayList<String> list1=new ArrayList<String>();
                ArrayList<String> list = timeslot.get(key);
                
                int j=0;
                while(j<list.size()){
                    list1.add(list.get(j++));
                }
                list1.add(cid);
                timeslot.put(key,list1);
                
                dur--;
                key = getNextKey(key);
            }
            
        }else{
            setAtAvailableSlot( cid, lecList, group, room, duration);
        }
        
    }
    
    public String getNextKey(String key){
    
        String[] str= key.split("-");
        String stime = str[2];
        String etime = str[2];
        if(slot_time.equals("30_MINUTES")){
            
            int hrs = Integer.parseInt(etime.substring(0,2));
            int min = Integer.parseInt(etime.substring(3,5));
            
            if(min==30){
                min = 0;
                hrs++;
                
                DecimalFormat formatter = new DecimalFormat("00");
                String hrsFormatted = formatter.format(hrs);
                String minFormatted = formatter.format(min);
                
                etime = hrsFormatted+":"+minFormatted;
                
            }else{
                min = 30;
                
                DecimalFormat formatter = new DecimalFormat("00");
                String hrsFormatted = formatter.format(hrs);
                String minFormatted = formatter.format(min);
                
                etime = hrsFormatted+":"+minFormatted;
            }
            
        }else{
            int hrs = Integer.parseInt(etime.substring(0,2))+1;
            DecimalFormat formatter = new DecimalFormat("00");
            String hrsFormatted = formatter.format(hrs);
            String etimeMM = etime.substring(3,5);
            etime = hrsFormatted+":"+etimeMM;
        }
        
        return str[0]+"-"+stime+"-"+etime;
    }
    
    
    
    public int getRandomNumber(){
        
        int randomNum = ThreadLocalRandom.current().nextInt(0, keyList.size());
        
        return randomNum;
    }
    
    public boolean checkAvailability(String key, String lecture, String group, String room){
        
        boolean retValue = true;
        String lec = "";
        String grp = "";
        String rm = "";
        
        ArrayList<String> sessionidArray= timeslot.get(key);
        
        int i=0;
        while(i<sessionidArray.size()){
            String sessionId = sessionidArray.get(i);
            if(sessionId.substring(0, 1).equals("S")){
               retValue = checkWithSessions(sessionId,lecture,group,room);
            }else if(sessionId.substring(0, 1).equals("P")){
               retValue = checkWithParallelSessions(sessionId,lecture,group,room);
            }else if(sessionId.substring(0, 1).equals("C")){
               retValue = checkWithConsecutiveSessions(sessionId,lecture,group,room);
            }else{
                System.out.println("error in checkavailability : wrong sessionID");
            }
            
            i++;
        }
        
        return retValue;
    }
    
    public boolean checkWithParallelSessions(String id, String lecture,String group, String room){
        
        DBCollection col=null;
        
        DBObject psObject=null;
        try {
            //get settings table data
            col = db.getCollection("ParallelSessions");
            BasicDBObject searchQuery = new BasicDBObject().append("P_id", id);
            psObject= col.findOne(searchQuery);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error When getting data from collection");
        }
        
        if(psObject != null){
            List<Document> sesList =(List<Document>) psObject.get("session");
            
            int i = 0;
            while(i<sesList.size()){
                HashMap<String,String> ses = (HashMap<String,String>) sesList.get(0);
                String lec = ses.get("lecturer").toString();
                String grp = ses.get("group").toString();
                    if(lec.equals(lecture)){
                        return false;
                    }
                    if(grp.equals(group)){
                        return false;
                    }
                    i++;
            }
            
        }
        
        return true;
    }
    
    public boolean checkWithConsecutiveSessions(String id, String lecture,String group, String room){
        
         DBCollection col=null;
        
        DBObject csObject=null;
        try {
            //get settings table data
            col = db.getCollection("ConstSession");
            BasicDBObject searchQuery = new BasicDBObject().append("C_id", id);
            csObject= col.findOne(searchQuery);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error When getting data from collection");
        }
        
        if(csObject != null){
            List<Document> lecList =(List<Document>) csObject.get("lecturer");
            
            int i = 0;
            while(i<lecList.size()){
                Object lec = lecList.get(i);
                
                if(lec.equals(lecture)){
                    return false;
                }
                i++;
            }
            String grp = csObject.get("groupId").toString();
            if(grp.equals(group)){
                    return false;
                }
        }
        
        return true;
    }
    
    public boolean checkWithSessions(String id, String lecture,String group, String room){
        
        DBCollection col=null;
        
        DBObject psObject=null;
        try {
            //get settings table data
            col = db.getCollection("Sessions");
            BasicDBObject searchQuery = new BasicDBObject().append("Session_ID", id);
            psObject= col.findOne(searchQuery);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error When getting data from collection");
        }
        
        if(psObject != null){
            List<Document> lecList =(List<Document>) psObject.get("Lecturers");
            int i = 0;
            while(i<lecList.size()){
                Object lec = lecList.get(i);
                String lecc = lec.toString();
                //check lecturer in name or id
                try {
                    
                    int l = Integer.parseInt(lecc);
                    lecc = getLecturerNameFromEmployeeTable(lecc);
                } catch (Exception e) {
                }
                
                if(lecc.equals(lecture)){
                    return false;
                }
                i++;
            }
            String grp = psObject.get("Group_ID").toString();
            if(grp.equals(group)){
                    return false;
                }
        }
        
        return true;
    }

    public String getLecturerNameFromEmployeeTable(String id){
        DBCollection col=null;
        
        DBObject empObject=null;
        try {
            //get settings table data
            col = db.getCollection("Employee ");
            BasicDBObject searchQuery = new BasicDBObject().append("Employee ID", id);
            empObject= col.findOne(searchQuery);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error When getting data from collection");
        }
        
        if(empObject != null){
            return empObject.get("Employee_Name").toString();
        }else{
            JOptionPane.showMessageDialog(null, "There is no any Lecturer with id:"+id);
        }
        return null;
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Please confirm to generate time tables.");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("By generating time tables, it will  replace the timetables already generated.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         try
        {
        db = DBManager.getDatabase();
        }
        catch (UnknownHostException ex)
        {
        JOptionPane.showMessageDialog(null, "Error When Connecting to DB");
        }
         
        try {
            getSettingsPageDetails();
            addTimeSlotsToHashMap();
            getParallelSessions();
            getConsecutiveSession();
            getSession();
            
            timeslot.forEach((k, v) -> {
                System.out.println(k+"-"+v);
            });
            
            JOptionPane.showMessageDialog(null, "Successfully generated!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error When generating time tables");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
