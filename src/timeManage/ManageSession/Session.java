/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageSession;

/**
 *
 * @author Vinoth
 */
public class Session {
    
    
    String lecturer;
    String subject;
    String scode;
    String group;
    String tag;
    int count;
    
        public Session(String lecturer,String subject,String scode,String group,String tag,int count){
        
            this.lecturer=lecturer;
            this.subject=subject;
            this.scode=scode;
            this.group=group;
            this.tag=tag;
            this.count=count;
        }
}
