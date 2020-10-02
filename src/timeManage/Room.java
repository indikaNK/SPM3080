package timeManage;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 */
public class Room {
 public String roomNumber;
 public String type;
 public String location;
 public String section;
 public String floorNumber;
 public String bname;

 public Room(String roomNumber, String type, String floorNumber, String location, String section, String bname) {
 this.roomNumber = roomNumber;
 this.type = type;
 this.location = location;
 this.section = section;
 this.floorNumber = floorNumber;
 this.bname = bname;
 }

 public Room(String roomNumber) {
 this.roomNumber = roomNumber;
 }
}

