package model;

import java.util.*;
import java.text.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.ArrayList;

// Represents a list of finished assignments for recording
public class FinishedAssignments {

    private ArrayList<Homework> finishedAssignments;
    private ArrayList<Homework> sortedFinishedAssignments;
    private ArrayList<Long> timeSpent;

    private int ID = 1;
    private String name;
    private String course;
    private AsmType type;
    private String startTime;
    private String description;

    private String finishTime;
    private Homework homework;


    // Getters:
    public ArrayList<Homework> getFinishedAssignments() {
        return finishedAssignments;
    }

    public ArrayList<Homework> getSortedFinishedAssignments() {
        return sortedFinishedAssignments;
    }

    public ArrayList<Long> getTimeSpent() {
        return timeSpent;
    }


    // EFFECTS: Construct a list of finished assignments, which is originally empty. 
    //          Construct a list of sorted finished assignments, which is originally empty. 
    public FinishedAssignments() {

    }

    // MODIFIES: this
    // EFFECTS: Add an assignment from the unfinished list to the finished assignment list
    public void addFinishedAssignment(Homework homework) {

    }

    // MODIFIES: this
    // EFFECTS: Sort the finished assignment in increasing order to time spent
    public void sortFinishedAssignments() {

    }

    // EFFECTS: Return the number of time spent based on different assignment types
    public ArrayList<Long> showStatistics() {
        return timeSpent;
    }

}
