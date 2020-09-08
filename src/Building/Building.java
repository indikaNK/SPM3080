/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Building;

/**
 *
 *
 */
public class Building {
 public String buildingName;
 public String center;
 public String location;
 public String department;
 public String numberOfFloors;

 public Building(String buildingName, String center, String location, String department, String
numberOfFloors) {
 this.buildingName = buildingName;
 this.center = center;
 this.location = location;
 this.department = department;
 this.numberOfFloors = numberOfFloors;
 }

 public Building(String ISBN_) {
 this.buildingName = buildingName;
 }
}
