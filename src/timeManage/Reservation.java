/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage;

/**
 *
 * @author Shimran Kuwailid
 */
public class Reservation {
    public String type, date, startTime, endTime, note, buildingName, buildingCenter, buildingDepartment, buildingLocation, roomNumber;
    
    public Reservation(String type, String date, String startTime, String endTime, String note, String roomNumber, String buildingName, String buildingCenter, String buildingDepartment, String buildingLocation){
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
    }
}
