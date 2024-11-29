package model;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

// Represent a list of unfinished, finished and sorted finished assignments
public class ListOfAsms implements Writable {

    private ArrayList<Homework> unfinishedAssignments;
    private ArrayList<Homework> finishedAssignments;
    private ArrayList<Homework> sortedFinishedAssignments;
        
    // EFFECTS: Construct the list of unfinished assignments, finished assignments and sorted assignments, which is
    //          originally empty
    public ListOfAsms() {
        unfinishedAssignments = new ArrayList<Homework>();
        finishedAssignments = new ArrayList<Homework>();
        sortedFinishedAssignments = new ArrayList<Homework>();
    }

    
    // Getters
    public ArrayList<Homework> getUnfinishedAssignments() {
        return unfinishedAssignments;
    }

    public ArrayList<Homework> getFinishedAssignments() {
        return finishedAssignments;
    }

    public ArrayList<Homework> getSortedFinishedAssignments() {
        return sortedFinishedAssignments;
    }

    // REQUIRES: The format of dueDate and startTime must be "yyyy-mm-dd hh:mm", in string type.
    // MODIFIES: this
    // EFFECTS: Add a new assignment to a list of unfinished assignments
    public void addAssignment(Homework homework) {
        unfinishedAssignments.add(homework);
        EventLog.getInstance().logEvent(new Event("Added an unfinished assignment"));
    } 

    // REQUIRES: The format of dueDate and startTime must be "yyyy-mm-dd hh:mm", in string type.
    // MODIFIES: this
    // EFFECTS: Add a new assignment to a list of finished assignments
    public void addFinishAssignment(Homework hw) {
        finishedAssignments.add(hw);
    }

    // REQUIRES: The format of dueDate and startTime must be "yyyy-mm-dd hh:mm", in string type.
    // MODIFIES: this
    // EFFECTS: Add a new assignment to a list of sorted finished assignments
    public void addSortedFinishAssignment(Homework hw) {
        sortedFinishedAssignments.add(hw);
    }

    // REQUIRES: id > 0. The format of dueDate must be "yyyy-mm-dd hh:mm", in string type.
    // MODIFIES: Homework
    // EFFECTS: Edit the due date of a particular assignment
    public void editDueDate(int id, String dueDate) {
        Homework hw = getHWbyID(id);
        if (hw != null) {
            hw.setDueDate(dueDate);
        }
        EventLog.getInstance().logEvent(new Event("Edited the due date of an assignment"));
    }

    // REQUIRES: id > 0. 
    // MODIFIES: Homework
    // EFFECTS: Edit the description of a particular assignment based on given ID.
    public void editDescription(int id, String description) {
        Homework hw = getHWbyID(id);
        if (hw != null) {
            hw.setDescription(description);
        }
        EventLog.getInstance().logEvent(new Event("Edited the description of an assignment"));
    }

    // REQUIRES: id > 0. 
    // MODIFIES: this
    // EFFECTS: Remove a particular assignment from the unfinished assignment list based on given ID.
    public void removeAssignment(int id) {
        Homework hw = getHWbyID(id);
        if (hw != null) {
            unfinishedAssignments.remove(hw);
        }
        EventLog.getInstance().logEvent(new Event("Removed an unfinished assignment"));
    }

    // EFFECTS: View the number of unfinished assignments in the list
    public int viewNumberUnfinishedAssignments() {
        EventLog.getInstance().logEvent(new Event("Viewed the number of unfinished assignments"));
        return unfinishedAssignments.size();
    }

    // EFFECTS: View the number of finished assignments in the list
    public int viewNumberFinishedAssignments() {
        EventLog.getInstance().logEvent(new Event("Viewed the number of finished assignments"));
        return finishedAssignments.size();
    }

    // REQUIRES: id > 0. The format of finishTime must be "yyyy-mm-dd hh:mm", in string type.
    // MODIFIES: this, Homework
    // EFFECTS: Move a particular assignment from unfinished list to finished list
    public void moveToFinished(int id, String finishTime) {
        Homework hw = getHWbyID(id);
        long duration;

        if (hw != null) {
            String startTime = hw.getStartTime();
            hw.setFinishTime(finishTime);
            duration = hw.getTimeDifference(startTime, finishTime);
            hw.setDuration(duration);

            finishedAssignments.add(hw);
            unfinishedAssignments.remove(hw);
        }
        EventLog.getInstance().logEvent(new Event("Finished an assignment"));
    }


    // MODIFIES: this
    // EFFECTS: Sort the finished assignment in increasing order of time spent
    public void sortFinishedAssignments() {
        sortedFinishedAssignments.clear();
        for (Homework h : finishedAssignments) {
            sortedFinishedAssignments.add(h);
        }
        sortedFinishedAssignments.sort(Comparator.comparingLong(Homework::getDuration));
        EventLog.getInstance().logEvent(new Event("Sorted finished assignments in increasing order of time spent"));
    }

    // REQUIRES: id > 0
    // EFFECTS: Given ID and return the corresponding homework. Otherwise return null.
    public Homework getHWbyID(int id) {
        for (Homework h : unfinishedAssignments) {
            if (h.getID() == id) {
                return h;
            }
        }
        return null;

    }

    // EFFECTS: Put the three array lists into the json file, later on we add every elements in every list
    //          in the file. Return json object contains of array lists.
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("unfinishedAssignments", unfinishedAsmsToJson());
        json.put("finishedAssignments", finishedAsmsToJson());
        json.put("sortedFinishedAssignments", sortedFinishedAsmsToJson());
        return json;
    }

    // EFFECTS: returns assignments in this unfinished assignments list as a JSON array
    private JSONArray unfinishedAsmsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Homework hw : unfinishedAssignments) {
            jsonArray.put(hw.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns assignments in this finished assignments list as a JSON array
    private JSONArray finishedAsmsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Homework hw : finishedAssignments) {
            jsonArray.put(hw.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns assignments in this sorted finished assignments list as a JSON array
    private JSONArray sortedFinishedAsmsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Homework hw : sortedFinishedAssignments) {
            jsonArray.put(hw.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: log the view the list of unfinished assignments event into the list
    public void viewUnfinishedAsmsLog() {
        EventLog.getInstance().logEvent(new Event("Viewed the list of unfinished assignments"));
    }

    // EFFECTS: log the view the list of finished assignments event into the list
    public void viewFinishedAsmsLog() {
        EventLog.getInstance().logEvent(new Event("Viewed the list of finished assignments"));
    }
}
