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
public class SubGroupID {
    
    public String GID;
    public String SubNum;
    public String SID;
    
    public SubGroupID(String GID,String SubNum){
        this.GID =  GID;
        this.SubNum = SubNum;
        this.SID = GID+"."+SubNum;
    }
    
}
