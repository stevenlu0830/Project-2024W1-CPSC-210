package model;

import java.time.LocalTime;
import java.util.*;
import java.text.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Represent a list of unfinished assignments for keeping track
public class UnfinishedAssignments {

    private ArrayList<Homework> unfinishedAssignments;

    private int hwID = 1;
    private String name;
    private String course;
    private AsmType type;
    private String startTime;
    private String description;

    private String finishTime;
    private Homework homework;
    
    // EFFECTS: Construct the list of unfinished assignments, which is originally empty
    public UnfinishedAssignments() {

    }

    // Getters
    public ArrayList<Homework> getUnfinishedAssignments() {
        return unfinishedAssignments;
    }


    // MODIFIES: this
    // EFFECTS: Add a new assignment to a list of unfinished assignments
    public void addAssignment(String name, String course, AsmType type, LocalTime startTime, String description) {

    } 

    // MODIFIES: this
    // EFFECTS: Edit the due date or description of a particular assignment
    public void editAssignment(int id, String attribute) {

    }

    // MODIFIES: this
    // EFFECTS: Remove a particular assignment from the unfinished assignment list
    public void removeAssignment(int id) {

    }

    // EFFECTS: View the number of unfinished assignments in the list
    public int viewNumberUnfinishedAssignments() {
        return 0;
    }

    // MODIFIES: this
    // EFFECTS: Move a particular assignment from unfinished to finished
    public void moveToFinished(int id) {

    }

    // EFFECTS: Return the time difference (in minutes) between finishTime and startTime
    public long timeDifferenceinMinutes(String startTime, String finishTime) {
        return 0;
    }

}
