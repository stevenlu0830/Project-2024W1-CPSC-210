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
    private int hwID;

    private String name;
    private String course;
    private AsmType type;
    private String dueDate;
    private String startTime;
    private String description;

    private String finishTime;
    private HomeworkTest homework;
    
    // EFFECTS: Construct the list of unfinished assignments, which is originally empty
    public UnfinishedAssignments() {
        unfinishedAssignments = new ArrayList<>();
    }

    // REQUIRES: The format of dueDate and startTime must be "yyyy-mm-dd hh:mm", in string type.
    // MODIFIES: this
    // EFFECTS: Add a new assignment to a list of unfinished assignments
    public void addAssignment(Homework homework) {
        unfinishedAssignments.add(homework);
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
        return unfinishedAssignments.size();
    }

    // MODIFIES: this
    // EFFECTS: Move a particular assignment from unfinished to finished
    public void moveToFinished(int id) {

    }

    // REQUIRES: finishTime must be later than startTime
    // EFFECTS: Return the time difference (in minutes) between finishTime and startTime
    public long timeDifferenceinMinutes(String startTime, String finishTime) {
        return 0;
    }

}
