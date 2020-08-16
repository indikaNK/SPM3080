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
public class Subjects {
    
    //properties
    private String offeredYear;
    private String offeredSemester;
    private String subjectCode;
    private String subjectName;
    private int nLhrs;//number of lecture Hours
    private int nThrs;//number of tutorial Hours
    private int nLabhrs;//number of lab Hours
    private int nEvhrs;//number of evaluation Hours

    //construcor
    public Subjects(String subjectName,String offeredYear, String offeredSemester, String subjectCode, int nLhrs, int nThrs, int nLabhrs, int nEvhrs) {
        this.offeredYear = offeredYear;
        this.offeredSemester = offeredSemester;
        this.subjectCode = subjectCode;
        this.nLhrs = nLhrs;
        this.nThrs = nThrs;
        this.nLabhrs = nLabhrs;
        this.nEvhrs = nEvhrs;
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
//getters setters
    public String getOfferedYear() {
        return offeredYear;
    }

    public void setOfferedYear(String offeredYear) {
        this.offeredYear = offeredYear;
    }

    public String getOfferedSemester() {
        return offeredSemester;
    }

    public void setOfferedSemester(String offeredSemester) {
        this.offeredSemester = offeredSemester;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public float getnLhrs() {
        return nLhrs;
    }

    public void setnLhrs(int nLhrs) {
        this.nLhrs = nLhrs;
    }

    public float getnThrs() {
        return nThrs;
    }

    public void setnThrs(int nThrs) {
        this.nThrs = nThrs;
    }

    public float getnLabhrs() {
        return nLabhrs;
    }

    public void setnLabhrs(int nLabhrs) {
        this.nLabhrs = nLabhrs;
    }

    public float getnEvhrs() {
        return nEvhrs;
    }

    public void setnEvhrs(int nEvhrs) {
        this.nEvhrs = nEvhrs;
    }

    
}
