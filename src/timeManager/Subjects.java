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
    public String subjectCode;
    private String subjectName;
    private String nLhrs;//number of lecture Hours
    private String nThrs;//number of tutorial Hours
    private String nLabhrs;//number of lab Hours
    private String nEvhrs;//number of evaluation Hours

    //construcor
    public Subjects(String subjectCode,String subjectName ,String offeredYear, String offeredSemester, String nLhrs, String nThrs, String nLabhrs, String nEvhrs) {

        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.offeredYear = offeredYear;
        this.offeredSemester = offeredSemester;
        this.nLhrs = nLhrs;
        this.nThrs = nThrs;
        this.nLabhrs = nLabhrs;
        this.nEvhrs = nEvhrs;
        
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

    public String getnLhrs() {
        return nLhrs;
    }

    public void setnLhrs(String nLhrs) {
        this.nLhrs = nLhrs;
    }

    public String getnThrs() {
        return nThrs;
    }

    public void setnThrs(String nThrs) {
        this.nThrs = nThrs;
    }

    public String getnLabhrs() {
        return nLabhrs;
    }

    public void setnLabhrs(String nLabhrs) {
        this.nLabhrs = nLabhrs;
    }

    public String getnEvhrs() {
        return nEvhrs;
    }

    public void setnEvhrs(String nEvhrs) {
        this.nEvhrs = nEvhrs;
    }

    public Subjects(String subjectCode ){
    this.subjectCode = subjectCode;
    }
    
}
