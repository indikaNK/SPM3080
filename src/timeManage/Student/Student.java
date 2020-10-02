/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage.Student;

/**
 *
 * @author Vinoth
 */
public class Student {
    public String year;
    public String semester;
    public String Ysem;
    
    public Student(String year,String semester){
        this.year=year;
        this.semester = semester;
        this.Ysem = year+"."+semester;
    }
}
