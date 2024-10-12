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
        while (operating) {
            displayMenu();
            input = scanner.nextInt();
            if (input == 1) {
                addOneAssignment();
            } else if (input == 2) {
                viewAssignments();
            } else if (input == 3) {
                editInformation();
            } else if (input == 4) {
                deleteOneAssignment();
            } else if (input == 5) {
                viewNumberUnfinishedandFinishedAssignments();
            } else if (input == 6) {
                moveAssignmentToFinishedList();
            } else if (input == 7) {
                sortFinishedAssignmentsByDuration();
            } else if (input == 8) {
                thankYouMessage();
            } else {
                errorMessage();
            }
        }
    }

    // EFFECTS: Display both unfinished assignments and finished assignments
    private void viewAssignments() {
        viewUnfinishedAssignments();
        viewFinishedAssignments();
    }

    // EFFECTS: Display error message when the input for selecting feature is incorrect
    private void errorMessage() {
        displayHorizontalLine();
        System.out.println("Oops...You have entered an invalid value. Please re-enter again :(");
    }

    // MODIFIES: this
    // EFFECTS: Display a thank you message and finish operation by changing the boolean variable to false
    private void thankYouMessage() {
        displayHorizontalLine();
        System.out.println("Thank you for using the app! Good luck on your studies :)");
        operating = false;
    }

    // MODIFIES: listOfAssignments
    // EFFECTS: Sort the finished assignments by increasing order of duration and print the sorted list of homework
    private void sortFinishedAssignmentsByDuration() {
        String typeInString;
        displayHorizontalLine();
        listOfAssignments.sortFinishedAssignments();
        System.out.println("Your list of assignments is sorted!");
        sortedFinishedAssignments = listOfAssignments.getSortedFinishedAssignments();
        for (Homework h : sortedFinishedAssignments) {
            typeInString = getTypeInString(h.getType());
            System.out.println("ID: " + h.getID() + " " + h.getName() + " " + h.getCourse() + " " + typeInString 
                    + ". Due at " + h.getDueDate() + ". Managed to start at " + h.getStartTime() + " Description: "
                    + h.getDescription() + ". Finished at " + h.getFinishTime() + ". Spent " + h.getDuration() 
                    + " minutes");
        }
    }

    // REQUIRES: enteredID > 0, finishedTime is in yyyy-mm-dd hh:mm format and it is later than startTime
    // MODIFIES: this, listOfAssignments
    // EFFECTS: Move an assignment from unfinished list to the finished list, and enter the finished time
    private void moveAssignmentToFinishedList() {
        int enteredID;
        String finishTime;
        displayHorizontalLine();
        System.out.println("Enter the assignment ID that represents the assignment you have finished: ");
        enteredID = scanner.nextInt();
        System.out.println("What time have you finished? Please enter " 
                + "in yyyy-mm-dd hh:mm format: "); 
        scanner.nextLine();
        finishTime = scanner.nextLine();
        listOfAssignments.moveToFinished(enteredID, finishTime);
        System.out.println("Assignment has been moved to finished assignment list!");
    }

    // EFFECTS: View the number of unfinished and finished assignments
    public void viewNumberUnfinishedandFinishedAssignments() {
        int numUnfinished;
        int numFinished;
        displayHorizontalLine();
        numUnfinished = listOfAssignments.viewNumberUnfinishedAssignments();
        System.out.println("You have " + numUnfinished + " unfinished assignments.");
        numFinished = listOfAssignments.viewNumberFinishedAssignments();
        System.out.println("You have " + numFinished + " finished assignments.");
    }

    // REQUIRES: enteredID > 0
    // MODIFIES: listOfAssignments
    // EFFECTS: Delete an assignment from a list of unfinished assignments
    public void deleteOneAssignment() {
        displayHorizontalLine();
        int enteredID;
        System.out.println("Enter the assignment ID that represents an assignment you want to delete:");
        enteredID = scanner.nextInt();
        listOfAssignments.removeAssignment(enteredID);
        System.out.println("Assignment deleted!");
    }

    // REQUIRES: whatToChange must be either 1 or 2
    // EFFECTS: Decide what to change based on entered choice
    public void editInformation() {
        int whatToChange;
        displayHorizontalLine();
        whatToChange = getWhatToChange();        
        if (whatToChange == 1) {
            newDueDate();
        } else if (whatToChange == 2) {
            newDescription();
        }
    }

    // REQUIRES: enteredID > 0
    // EFFECTS: listOfAssignments
    // MODIFIES: Ask user to enter the assignment ID and new description to edit an assignment 
    private void newDescription() {
        int enteredID;
        String newDescription;
        System.out.println("Enter the assignment ID that represents a assignment.");
        enteredID = scanner.nextInt();
        System.out.println("Enter a new description: "); 
        scanner.nextLine();
        newDescription = scanner.nextLine();
        listOfAssignments.editDescription(enteredID, newDescription);
        System.out.println("Description changed!");
    }

    // REQUIRES: enteredID > 0, newDueDate is in yyyy-mm-dd hh:mm format
    // MODIFIES: listOfAssignments
    // EFFECTS: Ask user to enter the assignment ID and new due date to edit an assignment
    private void newDueDate() {
        int enteredID;
        String newDueDate;
        System.out.println("Enter the assignment ID that represents a assignment. ");
        enteredID = scanner.nextInt();
        System.out.println("Enter the new due date in yyyy-mm-dd hh:mm format: "); 
        scanner.nextLine();
        newDueDate = scanner.nextLine();
        listOfAssignments.editDueDate(enteredID, newDueDate);
        System.out.println("Due date changed!");
    }

    // REQUIRES: localWhatToChange must be either 1 or 2
    // EFFECTS: Ask user to decide a choice of what to change and check whether the choice is valid 
    public int getWhatToChange() {
        boolean invalidInput = false;
        int localWhatToChange;
        do {
            System.out.println("What would you like to change? 1. Due date 2. Description");
            localWhatToChange = scanner.nextInt();
            if (localWhatToChange != 1 && localWhatToChange != 2) {
                System.out.println("Oops...You have entered an invalid value. Please re-enter again :(");
                invalidInput = true;
            } else {
                invalidInput = false;
            }
        } while (invalidInput);
        return localWhatToChange;
    }

    // EFFECTS: View a list of unfinished assignments
    public void viewUnfinishedAssignments() {
        String typeInString;
        displayHorizontalLine();
        unfinishedAssignments = listOfAssignments.getUnfinishedAssignments();
        System.out.println("Unfinished assignments:");
        if (unfinishedAssignments.size() == 0) {
            System.out.println("You don't have unfinished assignments.");
        } else {
            for (Homework h : unfinishedAssignments) {
                typeInString = getTypeInString(h.getType());
                System.out.println("ID: " + h.getID() + ", " + h.getName() + ", " + h.getCourse() + ", " + typeInString
                        + ", Due at " + h.getDueDate() + ", Managed to start at " + h.getStartTime() 
                        + ", Description: " + h.getDescription());
            }
        }
    }

    // EFFECTS: View a list of finished assignments
    public void viewFinishedAssignments() {
        System.out.println("\n");
        String typeInString2;
        finishedAssignments = listOfAssignments.getFinishedAssignments();
        System.out.println("Finished assignments:");
        if (finishedAssignments.size() == 0) {
            System.out.println("You don't have finished assignments.");
        } else {
            for (Homework h : finishedAssignments) {
                typeInString2 = getTypeInString(h.getType());
                System.out.println("ID: " + h.getID() + " " + h.getName() + " " + h.getCourse() + " " + typeInString2
                        + ". Due at " + h.getDueDate() + ". Managed to start at " + h.getStartTime() + " Description: "
                        + h.getDescription() + ". Finished at " + h.getFinishTime() + ". Spent " + h.getDuration() 
                        + " minutes");
            }
        }
    }

    // EFFECTS: Return the corresponding type of assignment in String data type
    public static String getTypeInString(AsmType t) {
        if (t == AsmType.Quiz) {
            return "Quiz";
        } else if (t == AsmType.ShortQuestions) {
            return "Short Questions";
        } else if (t == AsmType.Essay) {
            return "Essay";
        } else if (t == AsmType.ExtraPractices) {
            return "Extra Practices";
        } else if (t == AsmType.Readings) {
            return "Readings";
        } else if (t == AsmType.Others) {
            return "Others";
        } else {
            return "";
        }
    }

    // REQUIRES: dueDate, startTime is in yyyy-mm-dd hh:mm format
    // MODIFIES: Homework, listOfAssignments, this
    // EFFECTS: Add an assignment to the list
    public void addOneAssignment() {
        Homework hw;
        displayHorizontalLine();
        name = enterName();
        course = enterCourse();
        type = enterAndCheckType();
        dueDate = enterDueDate();
        startTime = enterStartTime();
        description = enterDescription();
        hw = new Homework(hwID, name, course, type, dueDate, startTime, description);
        hwID++;
        listOfAssignments.addAssignment(hw);
        System.out.println("Assignment added!");
    }

    // EFFECTS: Ask user to enter description for the new homework
    public String enterDescription() {
        String localDescription;
        System.out.println("Enter the description for the homework.");
        localDescription = scanner.nextLine();
        return localDescription;
    }

    // REQUIRES: The starting time must be in yyyy-mm-dd hh:mm format
    // EFFECTS: Ask user to enter startTime for the new homework
    public String enterStartTime() {
        String localStartTime;
        System.out.println("Enter the time you planned to start. It must be in yyyy-mm-dd hh:mm format.");
        localStartTime = scanner.nextLine();
        return localStartTime;
    }

    // REQUIRES: The dueDate must be in yyyy-mm-dd hh:mm format
    // EFFECTS: Ask user to enter due date for the new homework
    public String enterDueDate() {
        String localDueDate;
        System.out.println("Enter the due date. It must be in yyyy-mm-dd hh:mm format.");
        localDueDate = scanner.nextLine();
        return localDueDate;
    }

    // EFFECTS: Ask user to enter related course for the new homework
    public String enterCourse() {
        String localCourse;
        System.out.println("Enter its related course:");
        localCourse = scanner.nextLine();
        return localCourse;
    }

    // EFFECTS: Ask user to enter name for the new homework
    public String enterName() {
        String localName;
        System.out.println("Enter the name of the assignment:"); 
        scanner.nextLine();
        localName = scanner.nextLine();
        return localName;
    }

    // EFFECTS: Ask user to enter the type and then check it for the new homework
    public AsmType enterAndCheckType() {
        boolean invalidType = false;
        String typeEntered;
        AsmType localType;
        do {
            System.out.println("Enter the type of assignment " 
                    + "(quiz/short questions/essay/extra practices/readings/others)");
            typeEntered = scanner.nextLine();
            localType = determineType(typeEntered);
            if (localType == null) {
                System.out.println("Oops...You have entered an invalid type. Please re-enter again :(");
                invalidType = true;
            } else {
                invalidType = false;
            }
        } while (invalidType);
        return localType;
    }

    // EFFECTS: Displays all features in the app.
    public static void displayMenu() {
        displayHorizontalLine();
        System.out.println("Select a feature below: ");
        System.out.println("1. Add an assignment to the list");
        System.out.println("2. View a list of unfinished and finished assignments");
        System.out.println("3. Edit the information (due date/description) of an unfinished assignment");
        System.out.println("4. Remove an assignment");
        System.out.println("5. View the number of unfinished and finished assignments");
        System.out.println("6. Move an unfinished assignmnet to finished assignment list");
        System.out.println("7. Sort the list of finished assignments in increasing order of duration");
        System.out.println("8. Quit application");
        displayHorizontalLine();
    }

    // EFFECTS: Display a horizontal line
    public static void displayHorizontalLine() {
        System.out.println("---------------------------------------------");
    }

    // EFFECTS: Return the corresponding type of assignment in AsmType data type 
    public static AsmType determineType(String typeEntered) {
        if (typeEntered.equals("quiz")) {
            return AsmType.Quiz;
        } else if (typeEntered.equals("short questions")) {
            return AsmType.ShortQuestions;
        } else if (typeEntered.equals("essay")) {
            return AsmType.Essay;
        } else if (typeEntered.equals("extra practices")) {
            return AsmType.ExtraPractices;
        } else if (typeEntered.equals("readings")) {
            return AsmType.Readings;
        } else if (typeEntered.equals("others")) {
            return AsmType.Others;
        } else {
            return null;
        }
    }

}