package model;

import java.util.*;

// Represent a list of unfinished, finished and sorted finished assignments
public class ListOfAssignments {

    private ArrayList<Homework> unfinishedAssignments;
    private ArrayList<Homework> finishedAssignments;
    private ArrayList<Homework> sortedFinishedAssignments;
        
    // EFFECTS: Construct the list of unfinished assignments, finished assignments and sorted assignments, which is originally empty
    public ListOfAssignments() {
        unfinishedAssignments = new ArrayList<Homework>();
        finishedAssignments = new ArrayList<Homework>();
        sortedFinishedAssignments = new ArrayList<Homework>();
    }

    
    // Getters
    public ArrayList<Homework> getUnfinishedAssignments() {
        return null; // stub
    }

    public ArrayList<Homework> getFinishedAssignments() {
        return null; // stub
    }

    public ArrayList<Homework> getSortedFinishedAssignments() {
        return null; // stub
    }

    // REQUIRES: The format of dueDate and startTime must be "yyyy-mm-dd hh:mm", in string type.
    // MODIFIES: this
    // EFFECTS: Add a new assignment to a list of unfinished assignments
    public void addAssignment(Homework homework) {
        // stub
    } 

    // REQUIRES: id > 0. The format of dueDate must be "yyyy-mm-dd hh:mm", in string type.
    // MODIFIES: Homework
    // EFFECTS: Edit the due date of a particular assignment
    public void editDueDate(int id, String dueDate) {
        // stub
    }

    // REQUIRES: id > 0. 
    // MODIFIES: Homework
    // EFFECTS: Edit the description of a particular assignment based on given ID.
    public void editDescription(int id, String description) {
        // stub
    }

    // REQUIRES: id > 0. 
    // MODIFIES: this
    // EFFECTS: Remove a particular assignment from the unfinished assignment list based on given ID.
    public void removeAssignment(int id) {
        // stub
    }

    // EFFECTS: View the number of unfinished assignments in the list
    public int viewNumberUnfinishedAssignments() {
        return 0; // stub
    }

    // EFFECTS: View the number of finished assignments in the list
    public int viewNumberFinishedAssignments() {
        return 0; // stub
    }

    // REQUIRES: id > 0. The format of finishTime must be "yyyy-mm-dd hh:mm", in string type.
    // MODIFIES: this, Homework
    // EFFECTS: Move a particular assignment from unfinished list to finished list
    public void moveToFinished(int id, String finishTime) {
        // stub
    }


    // MODIFIES: this
    // EFFECTS: Sort the finished assignment in increasing order of time spent
    public void sortFinishedAssignments() {
        // stub
    }

    // REQUIRES: id > 0
    // EFFECTS: Given ID and return the corresponding homework. Otherwise return null.
    public Homework getHWbyID(int id) {
        return null; // stub
    }

}
