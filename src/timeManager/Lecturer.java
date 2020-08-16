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
public class Lecturer {
    
        public Lecturer(String EID, String Name, String faculty, String dept, String center, String Building, String level) {
        this.EID = EID;
        this.Name = Name;
        this.faculty = faculty;
        this.dept = dept;
        this.center = center;
        this.Building = Building;
        this.level = level;
    }
    
    private String  EID;    //lecturer ID
    private String Name;
    private String faculty;
    private String dept; //department
    private String center;
    private String Building;
    private String level;

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getBuilding() {
        return Building;
    }

    public void setBuilding(String Building) {
        this.Building = Building;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    
   
}
