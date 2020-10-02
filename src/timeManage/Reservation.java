/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage;

import java.util.ArrayList;

/**
 *
 * @author Shimran Kuwailid
 */
public class Reservation {
    public String roomId, sessionId, type, date, startTime, endTime, note, buildingName, buildingCenter, buildingDepartment, buildingLocation, roomNumber, buildingId;
    public ArrayList<String> unavailableTimes;
    
    public Reservation(String type, String date, String startTime, String endTime, String note, String roomNumber, String buildingName, String buildingCenter, String buildingDepartment, String buildingLocation, ArrayList<String> unavailableTimes, String buildingId){
        this.type = type;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.note = note;
        this.buildingName = buildingName;
        this.buildingCenter = buildingCenter;
        this.buildingDepartment = buildingDepartment;
        this.buildingLocation = buildingLocation;
        this.roomNumber = roomNumber;
        this.unavailableTimes = unavailableTimes;
        this.buildingId = buildingId;
    }
    
    public Reservation(String roomId, String sessionId){
        this.roomId = roomId;
        this.sessionId = sessionId;
    }
}
