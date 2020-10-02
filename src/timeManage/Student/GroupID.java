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
public class GroupID {
    
    public String Ysem;
    public String programme;
    public String Gnum;
    public String GrpID;
    
    
    public GroupID(String Ysem,String programme,String Gnum){
        
        this.Ysem=Ysem;
        this.programme = programme;
        this.Gnum = Gnum;
        this.GrpID = Ysem+"."+programme+"."+Gnum;
        
    }
    
}
