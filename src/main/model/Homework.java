package model;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;

import persistence.Writable;


// Represent a homework that has id, name, course, type, dueDate, startTime, description, finishTime, duration
public class Homework implements Writable {

    private int hwID;

    private String name;
    private String course;
    private AsmType type;
    private String dueDate;
    private String startTime;
    private String description;

    private String finishTime;
    private long duration;

    // EFFECTS: Construct an assignment with given ID, name, course, type, dueDate, startTime, description, but having
    //          no finishTime and duration.
    public Homework(int hwID, String name, String course, AsmType type, String dueDate, String startTime, 
            String description, String finishTime, int duration) {
        this.hwID = hwID;
        this.name = name;
        this.course = course;
        this.type = type;
        this.dueDate = dueDate;
        this.startTime = startTime;
        this.description = description;
        this.finishTime = finishTime;
        this.duration = duration;
    }

    // Getters
    public int getID() {
        return this.hwID;
    }

    public String getName() {
        return this.name;
    }

    public String getCourse() {
        return this.course;
    }

    public AsmType getType() {
        return this.type;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFinishTime() {
        return this.finishTime;
    }

    public long getDuration() {
        return this.duration;
    }

    // REQUIRES: The date-time must be in the format in string "yyyy-mm-dd hh:mm"
    // MODIFIES: this
    // EFFECTS: Set a new dueDate
    public void setDueDate(String dueDateandTime) {
        this.dueDate = dueDateandTime;        
    }

    // MODIFIES: this
    // EFFECTS: Set a new description
    public void setDescription(String description) {
        this.description = description;
    }

    // REQUIRES: The date-time must be in the format in string "yyyy-mm-dd hh:mm". finishTime must be
    //           later than the startTime
    // MODIFIES: this
    // EFFECTS: Set a new finishTime
    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    // REQUIRES: The duration must be non-negative
    // MODIFIES: this
    // EFFECTS: Set a duration for the assignment
    public void setDuration(long duration) {
        this.duration = duration;
    }
    
    // REQUIRES: The date-time must be in the format in string "yyyy-mm-dd hh:mm". 
    //           finishTime must be later than startTime
    // EFFECTS: Return the time difference (in minutes) between startTime and finishTime 
    public long getTimeDifference(String startTime, String finishTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String dateTime1 = startTime;
        String dateTime2 = finishTime;

        LocalDateTime startDateTime = LocalDateTime.parse(dateTime1, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(dateTime2, formatter);

        Duration duration = Duration.between(startDateTime, endDateTime);

        long minutes = duration.toMinutes();
        return minutes;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        // json.put("name", name);
        // json.put("category", category);
        json.put("hwID", hwID);
        json.put("name", name);
        json.put("course", course);
        json.put("type", type);
        json.put("dueDate", dueDate);
        json.put("startTime", startTime);
        json.put("description", description);
        json.put("finishTime", finishTime);
        json.put("duration", duration);
        return json;
    }
        
}



