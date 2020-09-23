/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage;

/**
 *
 * @author NK
 */
public class Sessions {
    
    String sessionID,lecturer,tags,groupID,subjectCode,subject;
    int studentCount,duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    String [] lecturers;

    Sessions(String session_ID, String lecturers, String tag, String group_ID, String subject_Code, String subject, int student_coun,int duration) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String[] getLecturers() {
        return lecturers;
    }

    public void setLecturers(String[] lecturers) {
        this.lecturers = lecturers;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }


    public String getSLecturer() {
        return lecturer;
    }

    public void setSLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

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

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public Sessions(String sessionID, String sessionName, String lecturer, String tags, String groupID, String subjectCode, String subject, int studentCount,int duration) {
        this.sessionID = sessionID;
        this.lecturer = lecturer;
        this.tags = tags;
        this.groupID = groupID;
        this.subjectCode = subjectCode;
        this.subject = subject;
        this.studentCount = studentCount;
        this.duration = duration;
    }
    
    
    
}
