/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage;


/**
 *
 * @author Thisura
 */
public class Setting {
    private int settingid;
    private int noOfWorkingDays;
    private String[] workingDays;
    private String startingTime;
    private String timeSlot;
    private String workingTimePerDay;

    public Setting() {
    }

    public Setting(int settingid, int noOfWorkingDays, String[] workingDays, String startingTimeHrs, String timeSlot, String workingTimePerDay) {
        this.settingid = settingid;
        this.noOfWorkingDays = noOfWorkingDays;
        this.workingDays = workingDays;
        this.startingTime = startingTimeHrs;
        this.timeSlot = timeSlot;
        this.workingTimePerDay = workingTimePerDay;
    }

    /**
     * @return the settingid
     */
    public int getSettingid() {
        return settingid;
    }

    /**
     * @param settingid the settingid to set
     */
    public void setSettingid(int settingid) {
        this.settingid = settingid;
    }

    /**
     * @return the noOfWorkingDays
     */
    public int getNoOfWorkingDays() {
        return noOfWorkingDays;
    }

    /**
     * @param noOfWorkingDays the noOfWorkingDays to set
     */
    public void setNoOfWorkingDays(int noOfWorkingDays) {
        this.noOfWorkingDays = noOfWorkingDays;
    }

    /**
     * @return the workingDays
     */
    public String[] getWorkingDays() {
        return workingDays;
    }

    /**
     * @param workingDays the workingDays to set
     */
    public void setWorkingDays(String[] workingDays) {
        this.workingDays = workingDays;
    }

    /**
     * @return the startingTime
     */
    public String getStartingTime() {
        return startingTime;
    }

    /**
     * @param startingTime the startingTime to set
     */
    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    /**
     * @return the timeSlot
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * @param timeSlot the timeSlot to set
     */
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    /**
     * @return the workingHrsPerDay
     */
    public String getWorkingTimePerDay() {
        return workingTimePerDay;
    }

    /**
     * @param workingHrsPerDay the workingHrsPerDay to set
     */
    public void setWorkingTimePerDay(int workingHrsPerDay) {
        this.workingTimePerDay = workingTimePerDay;
    }   
    
}
