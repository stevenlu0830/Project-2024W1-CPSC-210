package model;

import java.time.LocalTime;
import java.util.*;
import java.util.*;
import java.text.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.ArrayList;

// Represent a homework that has id, name, course, type, startTime, description and finishTime.
public class Homework {

    private int hwID;
    private String name;
    private String course;
    private AsmType type;
    private String startTime;
    private String description;

    private String finishTime;

    // EFFECTS: Construct an assignment with given name, course, type, startTime and description
    public Homework() {
        
    }

    // Getters
    public int getID() {
        return hwID;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public AsmType getType() {
        return type;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getDescription() {
        return description;
    }

    public String getFinishTime() {
        return finishTime;
    }

    // MODIFIES: this
    // EFFECTS: Set a new finishTime
    public void setFinishTime(String finishTime) {
        
    }

    // MODIFIES: this
    // EFFECTS: Set a new description
    public void setDescription(String description) {
        
    }
    
        
}



