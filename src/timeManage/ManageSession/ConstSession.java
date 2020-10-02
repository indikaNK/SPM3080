/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage.ManageSession;

import java.util.ArrayList;

/**
 *
 * @author Vinoth
 */
public class ConstSession {
    
    
   
   
    ArrayList<String> lecturer = new ArrayList<String>();
    String c_id;
    String subject;
    String Scode;
    ArrayList<String> tag = new ArrayList<String>();
   
    String groupId;
    int count;
    int duration;
    
    public ConstSession(String c_id,ArrayList lecturer,String subject,String Scode,ArrayList tag,String groupId,int count,int duration ){
        this.c_id=c_id;
        this.lecturer=lecturer;
        this.subject=subject;
        this.Scode=Scode;
        this.tag=tag;
        this.groupId=groupId;
        this.count=count;
        this.duration=duration;
    }
}
