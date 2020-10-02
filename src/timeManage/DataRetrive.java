package timeManage;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.management.Query;

public class DataRetrive {

    String eID = null;
    String employee_Name = null;
    String faculty = null;
    String department = null;
    String centre = null;
    String building = null;
    String occupation = null;

    //sessions
    String session_ID = null;
    String lecturers = null;
    String tag = null;
    String group_ID = null;
    String subject_Code = null;
    String subject = null;
    String scount = null;
    String duration = null;

    //subjects
    String code = null;
    String name = null;
    String year = null;
    String semester = null;
    String nLhrs = null;
    String nThrs = null;
    String nLabhrs = null;
    String nEVhrs = null;

    public DBCursor getAllEmployees() {
        DB edb = null;
        DBCollection col1;
        try {
            edb = DBManager.getDatabase();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Error Connecting To DB");
        }
        col1 = edb.getCollection("Employee ");
        DBObject resultdb = col1.findOne();
        if (resultdb != null) {
            eID = (String) resultdb.get("Employee ID");
            employee_Name = (String) resultdb.get("Employee_Name");
            faculty = (String) resultdb.get("Faculty");
            department = (String) resultdb.get("Department");
            centre = (String) resultdb.get("Center");
            building = (String) resultdb.get("Building");
            occupation = (String) resultdb.get("Occupation");
        }
        return col1.find();
    }

    public DBCursor getAllSession() {
        DB edb = null;
        DBCollection col1;
        try {
            edb = DBManager.getDatabase();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Error Connecting To DB");
        }
        col1 = edb.getCollection("Sessions");
        DBObject resultdb = col1.findOne();
        if (resultdb != null) {
            session_ID = (String) resultdb.get("Session_ID");
            lecturers = resultdb.get("Lecturers").toString();
            tag = (String) resultdb.get("Tag");
            group_ID = (String) resultdb.get("Group_ID");
            subject_Code = resultdb.get("Subject_Code").toString();
            subject = (String) resultdb.get("Subject").toString();
            scount = (String) resultdb.get("Student_Count").toString();
            duration = (String) resultdb.get("Duration").toString();
        }
        return col1.find();
    }

    public DBCursor getAllSubject() {
        DB edb = null;
        DBCollection col1;
        try {
            edb = DBManager.getDatabase();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Error Connecting To DB");
        }
        col1 = edb.getCollection("Subjects ");
        DBObject resultdb = col1.findOne();
        if (resultdb != null) {
            code = (String) resultdb.get("Subject Code");
            name = (String) resultdb.get("SubjectName");
            year = (String) resultdb.get("Offered Year");
            semester = (String) resultdb.get("Offerd Semester");
            nLhrs = resultdb.get("Lecture Hours").toString();
            nLabhrs = (String) resultdb.get("Lab Hours").toString();
            nThrs = (String) resultdb.get("Tutorial Hours").toString();
            nEVhrs = (String) resultdb.get("Evaluation Hours").toString();
        }
        return col1.find();
    }

    //search method
    public ArrayList<Sessions> testSearch(String subject, String groupId, String lecturers) {
        DB edb = null;
        DBCollection col1;
        System.out.println("mula lec"+lecturers); //archana

//        dummy values
//        String subject = "SE3050";
//        String groupId = "Y1.S1.IT.01";
//          String lecturers = "000150";  
        ArrayList<Sessions> sessions = new ArrayList<>();

        try {
            edb = DBManager.getDatabase();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Error Connecting To DB");
        }
        col1 = edb.getCollection("Sessions");

        DBObject query = new BasicDBObject("Group_ID", groupId).append("Subject_Code", subject).append("Lecturers", lecturers);

        System.out.println("groupID" + groupId + "\nscode" + subject+ "\nslecturers" + lecturers);

        //{{"Subject_Code": subject}, {"Group_ID": groupId}}
        DBCursor resultdb = col1.find(query);

        System.out.println("dbcursor : " + resultdb.toString());
        if (resultdb.hasNext()) {

            DBObject obj = resultdb.next();
            System.out.println("obj : " + obj.toString());

            Sessions s = new Sessions();
            s.setDuration(obj.get("Duration").toString());
            s.setGroupID(obj.get("Group_ID").toString());
            s.setLecturers((ArrayList<String>) obj.get("Lecturers"));
            s.setSSubject(obj.get("Subject").toString());
            s.setSessionID(obj.get("Session_ID").toString());
            s.setSSubjectCode(obj.get("Subject_Code").toString());
            s.setStudentCount(obj.get("Student_Count").toString());
            s.setTags(obj.get("Tag").toString());

            sessions.add(s);
        }

        return sessions;
    }

    public String getLecName(String ID) {
        DB edb = null;
        DBCollection col1;
        try {
            edb = DBManager.getDatabase();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Error Connecting To DB");

        }

        col1 = edb.getCollection("Employee ");
        BasicDBObject searchQuery = new BasicDBObject().append("Employee ID", ID);
        DBObject result = col1.findOne(searchQuery);
        System.out.println("beforeif:"+searchQuery);
        
        if (result != null) {
            System.out.println("result:"+result);
            return result.get("Employee_Name").toString();
        }

        return null;
    }

        public String getLecID(String Name) {
        DB edb = null;
        DBCollection col1;
        try {
            edb = DBManager.getDatabase();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Error Connecting To DB");

        }

        col1 = edb.getCollection("Employee ");
        BasicDBObject searchQuery = new BasicDBObject().append("Employee_Name", Name);
        DBObject result = col1.findOne(searchQuery);
        System.out.println("beforeif:"+searchQuery);
        
        if (result != null) {
            System.out.println("result:"+result);
            return result.get("Employee ID").toString();
        }

        return null;
    }
}
