package model;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


// Represent a homework that has id, name, course, type, dueDate, startTime, description, finishTime, duration
public class Homework {

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
            String description) {
        this.hwID = hwID;
        this.name = name;
        this.course = course;
        this.type = type;
        this.dueDate = dueDate;
        this.startTime = startTime;
        this.description = description;
        this.finishTime = "";
        this.duration = 0;
    }

    // Getters
    public int getID() {
        return 0; // stub
    }

    public String getName() {
        return ""; // stub
    }

    public String getCourse() {
        return ""; // stub
    }

    public AsmType getType() {
        return null; // stub
    }

    public String getDueDate() {
        return ""; // stub
    }

    public String getStartTime() {
        return ""; // stub
    }

    public String getDescription() {
        return ""; // stub
    }

    public String getFinishTime() {
        return ""; // stub
    }

    public long getDuration() {
        return 0; // stub
    }

    // REQUIRES: The date-time must be in the format in string "yyyy-mm-dd hh:mm"
    // MODIFIES: this
    // EFFECTS: Set a new dueDate
    public void setDueDate(String dueDateandTime) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: Set a new description
    public void setDescription(String description) {
        // stub
    }

    // REQUIRES: The date-time must be in the format in string "yyyy-mm-dd hh:mm". finishTime must be
    //           later than the startTime
    // MODIFIES: this
    // EFFECTS: Set a new finishTime
    public void setFinishTime(String finishTime) {
        // stub
    }

    // REQUIRES: The duration must be non-negative
    // MODIFIES: this
    // EFFECTS: Set a duration for the assignment
    public void setDuration(long duration) {
        // stub
    }
    
    // REQUIRES: The date-time must be in the format in string "yyyy-mm-dd hh:mm". 
    //           finishTime must be later than startTime
    // EFFECTS: Return the time difference (in minutes) between startTime and finishTime 
    public long getTimeDifference(String startTime, String finishTime) {
        return 0; // stub
    }
        
}



