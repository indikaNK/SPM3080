/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage;

import java.util.ArrayList;

/**
 *
 * @author NK
 */
public class Sessions {
    
    String sessionID,tags,groupID,subjectCode,subject;
    String studentCount,duration;
    ArrayList<String> lecturers = new ArrayList<String>();

    public Sessions(){
        
    }
    
    public ArrayList<String> getLecturers() {
        return lecturers;
    }

    public void setLecturers(ArrayList<String> lecturers) {
        this.lecturers = lecturers;
    }


    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    //String [] lecturers;



//    public String[] getLecturers() {
//        return lecturers;
//    }
//
//    public void setLecturers(String[] lecturers) {
//        this.lecturers = lecturers;
//    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }


//    public String getSLecturer() {
//        return lecturer;
//    }
//
//    public void setSLecturer(String lecturer) {
//        this.lecturer = lecturer;
//    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getSSubjectCode() {
        return subjectCode;
    }

    public void setSSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSSubject() {
        return subject;
    }

    public void setSSubject(String subject) {
        this.subject = subject;
    }

    public String getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(String studentCount) {
        this.studentCount = studentCount;
    }

    public Sessions(String sessionID, ArrayList<String> lecturer, String tags, String groupID, String subjectCode, String subject, String studentCount,String duration) {
        this.sessionID = sessionID;
        this.lecturers = lecturer;
        this.tags = tags;
        this.groupID = groupID;
        this.subjectCode = subjectCode;
        this.subject = subject;
        this.studentCount = studentCount;
        this.duration = duration;
    }
    
    
    
}
