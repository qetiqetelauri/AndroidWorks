package com.example.final_ketiketelauri.Model;
public class Schedule {
    int id;
    String scheduleTime;
    String scheduleAbout;
    int  scheduleDuration;


    // constructors
    public Schedule() {
    }

    public Schedule(int id, String scheduleTime, String scheduleAbout, int scheduleDuration ) {
        this.id = id;
        this.scheduleTime = scheduleTime;
        this.scheduleAbout = scheduleAbout;
        this.scheduleDuration = scheduleDuration;

    }
    public Schedule( String scheduleTime, String scheduleAbout, int scheduleDuration) {

        this.scheduleTime = scheduleTime;
        this.scheduleAbout = scheduleAbout;
        this.scheduleDuration = scheduleDuration;

    }


    public Schedule(String scheduleAbout, int scheduleDuration) {
        this.scheduleAbout = scheduleAbout;
        this.scheduleDuration = scheduleDuration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getScheduleAbout() {
        return scheduleAbout;
    }

    public void setScheduleAbout(String scheduleAbout) {
        this.scheduleAbout = scheduleAbout;
    }

    public int getScheduleDuration() {
        return scheduleDuration;
    }

    public void setScheduleDuration(int scheduleDuration) {
        this.scheduleDuration = scheduleDuration;
    }
}