package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.AsmType;
import model.Homework;
import model.ListOfAssignments;

public class App {

    int hwID = 1;
    boolean operating = true;
    int input;
    Scanner scanner = new Scanner(System.in);

    ListOfAssignments listOfAssignments;
    ArrayList<Homework> unfinishedAssignments;
    ArrayList<Homework> finishedAssignments;
    ArrayList<Homework> sortedFinishedAssignments;

    String name;
    String course;
    AsmType type;
    String dueDate;
    String startTime;
    String description;
        

    // EFFECTS: Construct an object that runs the assignment tracking app
    public App() {
        System.out.println("Welcome to the Assignment Tracking App!");
        listOfAssignments = new ListOfAssignments();
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: Running the assignment tracking app
    public void runApp() {
        
    }

    // EFFECTS: Display both unfinished assignments and finished assignments
    private void viewAssignments() {
        
    }

    // EFFECTS: Display error message when the input for selecting feature is incorrect
    private void errorMessage() {
        
    }

    // MODIFIES: this
    // EFFECTS: Display a thank you message and finish operation by changing the boolean variable to false
    private void thankYouMessage() {
        
    }

    // MODIFIES: listOfAssignments
    // EFFECTS: Sort the finished assignments by increasing order of duration and print the sorted list of homework
    private void sortFinishedAssignmentsByDuration() {
        
    }

    // REQUIRES: enteredID > 0, finishedTime is in yyyy-mm-dd hh:mm format and it is later than startTime
    // MODIFIES: this, listOfAssignments
    // EFFECTS: Move an assignment from unfinished list to the finished list, and enter the finished time
    private void moveAssignmentToFinishedList() {
        
    }

    // EFFECTS: View the number of unfinished and finished assignments
    public void viewNumberUnfinishedandFinishedAssignments() {
        
    }

    // REQUIRES: enteredID > 0
    // MODIFIES: listOfAssignments
    // EFFECTS: Delete an assignment from a list of unfinished assignments
    public void deleteOneAssignment() {
        
    }

    // REQUIRES: whatToChange must be either 1 or 2
    // EFFECTS: Decide what to change based on entered choice
    public void editInformation() {
        
    }

    // REQUIRES: enteredID > 0
    // EFFECTS: listOfAssignments
    // MODIFIES: Ask user to enter the assignment ID and new description to edit an assignment 
    private void newDescription() {
        
    }

    // REQUIRES: enteredID > 0, newDueDate is in yyyy-mm-dd hh:mm format
    // MODIFIES: listOfAssignments
    // EFFECTS: Ask user to enter the assignment ID and new due date to edit an assignment
    private void newDueDate() {
        
    }

    // REQUIRES: localWhatToChange must be either 1 or 2
    // EFFECTS: Ask user to decide a choice of what to change and check whether the choice is valid 
    public int getWhatToChange() {
        
        return 0;
    }

    // EFFECTS: View a list of unfinished assignments
    public void viewUnfinishedAssignments() {
        
    }

    // EFFECTS: View a list of finished assignments
    public void viewFinishedAssignments() {
        
    }

    // EFFECTS: Return the corresponding type of assignment in String data type
    public static String getTypeInString(AsmType t) {
        return "";
    }

    // REQUIRES: dueDate, startTime is in yyyy-mm-dd hh:mm format
    // MODIFIES: Homework, listOfAssignments, this
    // EFFECTS: Add an assignment to the list
    public void addOneAssignment() {
        
    }

    // EFFECTS: Ask user to enter description for the new homework
    public String enterDescription() {
        return "";
    }

    // REQUIRES: The starting time must be in yyyy-mm-dd hh:mm format
    // EFFECTS: Ask user to enter startTime for the new homework
    public String enterStartTime() {
        return "";
    }

    // REQUIRES: The dueDate must be in yyyy-mm-dd hh:mm format
    // EFFECTS: Ask user to enter due date for the new homework
    public String enterDueDate() {
        return "";
    }

    // EFFECTS: Ask user to enter related course for the new homework
    public String enterCourse() {
        return "";
    }

    // EFFECTS: Ask user to enter name for the new homework
    public String enterName() {
        return "";
    }

    // EFFECTS: Ask user to enter the type and then check it for the new homework
    public AsmType enterAndCheckType() {
        return null;
    }

    // EFFECTS: Displays all features in the app.
    public static void displayMenu() {
        
    }

    // EFFECTS: Display a horizontal line
    public static void displayHorizontalLine() {
        
    }

    // EFFECTS: Return the corresponding type of assignment in AsmType data type 
    public static AsmType determineType(String typeEntered) {
        return null;
    }

}
