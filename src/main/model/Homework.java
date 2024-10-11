package model;


import java.util.*;


// Represent a homework that has id, name, course, type, startTime, description and finishTime.
public class Homework {

    private int hwID;

    private String name;
    private String course;
    private AsmType type;
    private String dueDate;
    private String startTime;
    private String description;

    private String finishTime;

    // EFFECTS: Construct an assignment with given name, course, type, dueDate, startTime and description
    public Homework(int hwID, String name, String course, AsmType type, String dueDate, String startTime, String description) {
        this.hwID = hwID;
        this.name = name;
        this.course = course;
        this.type = type;
        this.dueDate = dueDate;
        this.startTime = startTime;
        this.description = description;
        this.finishTime = "";
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



    // MODIFIES: this
    // EFFECTS: Set a new dueDate
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    // MODIFIES: this
    // EFFECTS: Set a new description
    public void setDescription(String description) {
        this.description = description;
    }

    // MODIFIES: this
    // EFFECTS: Set a new finishTime
    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
    
        
}



