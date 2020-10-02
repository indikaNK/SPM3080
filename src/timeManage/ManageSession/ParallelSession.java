/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageSession;

import java.util.ArrayList;

/**
 *
 * @author Vinoth
 */
public class ParallelSession {
    
    
    
  
     ArrayList<Session>session = new ArrayList<Session>();
        String p_id;
        String day;
        String stime;
        int duration;
        
        
        public ParallelSession(String p_id,ArrayList<Session> session,String day,String stime,int duration){
            this.p_id=p_id;
            this.session=session;
            this.day=day;
            this.stime=stime;
            this.duration=duration;
        }
}
