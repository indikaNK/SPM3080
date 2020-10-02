/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage.ManageSession;

import java.time.LocalTime;


/**
 *
 * @author Vinoth
 */
public class NotAvailableTime {
    
    public String choosed;
    public String name;
    public String day;
    public String from;
    public String to;
    
    
    public NotAvailableTime(String choosed,String name,String day,String from,String to){
    
        this.choosed=choosed;
        this.name=name;
        this.day=day;
        this.from=from;
        this.to=to;
    }
}
