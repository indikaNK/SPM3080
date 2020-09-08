/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManager;

/**
 *
 * @author NK
 */
public class Sessions {
    
    String sessionID,sessionName,lecturer,tags,groupID,subjectCode,subject;
    int studentCount;

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
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

    public Sessions(String sessionID, String sessionName, String lecturer, String tags, String groupID, String subjectCode, String subject, int studentCount) {
        this.sessionID = sessionID;
        this.sessionName = sessionName;
        this.lecturer = lecturer;
        this.tags = tags;
        this.groupID = groupID;
        this.subjectCode = subjectCode;
        this.subject = subject;
        this.studentCount = studentCount;
    }
    
    
    
}
