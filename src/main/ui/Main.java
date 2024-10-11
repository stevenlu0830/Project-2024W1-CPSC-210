package ui;

import java.util.*;

import model.AsmType;
import model.Homework;
import model.ListOfAssignments;

public class Main {

    public static void main(String[] args) {
        int hwID = 1;
        boolean operating = true;
        int input;
        Scanner scanner = new Scanner(System.in);
        ListOfAssignments listOfAssignments;
        ArrayList<Homework> unfinishedAssignments;
        ArrayList<Homework> finishedAssignments;
        ArrayList<Homework> sortedFinishedAssignments;
        listOfAssignments = new ListOfAssignments();
        System.out.println("Welcome to the Assignment Tracking App!");
        while (operating) {
            displayMenu();
            input = scanner.nextInt();
            if (input == 1) {
                
                boolean invalidType = false;

                String name;
                String course;
                AsmType type;
                String typeEntered;
                String dueDate;
                String startTime;
                String description;
                Homework hw;

                displayHorizontalLine();
                System.out.println("Enter the name of the assignment:"); scanner.nextLine();

                name = scanner.nextLine();
                System.out.println("Enter its related course:");
                course = scanner.nextLine();
                do {
                    System.out.println("Enter the type of assignment " + 
                            "(quiz/short questions/essay/extra practices/readings/others)");
                    typeEntered = scanner.nextLine();
                    type = determineType(typeEntered);
                    if (type == null) {
                        System.out.println("Oops...You have entered an invalid type. Please re-enter again :(");
                        invalidType = true;
                    } else {
                        invalidType = false;
                    }
                } while (invalidType);
                System.out.println("Enter the due date. It must be in yyyy-mm-dd hh:mm format.");
                dueDate = scanner.nextLine();
                System.out.println("Enter the time you planned to start. It must be in yyyy-mm-dd hh:mm format.");
                startTime = scanner.nextLine();
                System.out.println("Enter the description for the homework.");
                description = scanner.nextLine();

                hw = new Homework(hwID, name, course, type, dueDate, startTime, description);
                hwID++;
                listOfAssignments.addAssignment(hw);
                System.out.println("Assignment added!");

            } else if (input == 2) {

                String typeInString;
                displayHorizontalLine();
                unfinishedAssignments = listOfAssignments.getUnfinishedAssignments();
                System.out.println("Unfinished assignments:");
                if (unfinishedAssignments.size() == 0) {
                    System.out.println("You don't have unfinished assignments.");
                } else {
                    for (Homework h : unfinishedAssignments) {
                        typeInString = getTypeInString(h.getType());
                        System.out.println("ID: " + h.getID() + ", " + h.getName() + ", " + h.getCourse() + ", " + 
                                typeInString + ", Due at " + h.getDueDate() + ", Managed to start at " + 
                                h.getStartTime() + ", Description: " + h.getDescription());
                    }
                }
                System.out.println("\n");
                String typeInString2;
                finishedAssignments = listOfAssignments.getFinishedAssignments();
                System.out.println("Finished assignments:");
                if (finishedAssignments.size() == 0) {
                    System.out.println("You don't have finished assignments.");
                } else {
                    for (Homework h : finishedAssignments) {
                        typeInString2 = getTypeInString(h.getType());
                        System.out.println("ID: " + h.getID() + " " + h.getName() + " " + h.getCourse() + " " 
                                + typeInString2 + ". Due at " + h.getDueDate() + ". Managed to start at " 
                                + h.getStartTime() + " Description: " + h.getDescription() + ". Finished at " 
                                + h.getFinishTime() + ". Spent " + h.getDuration() + " minutes");
                    }
                }

            } else if (input == 3) {

                int whatToChange;
                int enteredID;
                boolean invalidInput = false;
                String newDueDate;
                String newDescription;

                displayHorizontalLine();
                
                do {
                    System.out.println("What would you like to change? 1. Due date 2. Description");
                    whatToChange = scanner.nextInt();
                    if (whatToChange != 1 && whatToChange != 2) {
                        System.out.println("Oops...You have entered an invalid value. Please re-enter again :(");
                        invalidInput = true;
                    } else {
                        invalidInput = false;
                    }
                } while (invalidInput);
                
                if (whatToChange == 1) {
                    System.out.println("Enter the assignment ID that represents a assignment. ");
                    enteredID = scanner.nextInt();
                    System.out.println("Enter the new due date in yyyy-mm-dd hh:mm format: "); scanner.nextLine();

                    newDueDate = scanner.nextLine();
                    listOfAssignments.editDueDate(enteredID, newDueDate);
                    System.out.println("Due date changed!");
                } else if (whatToChange == 2) {
                    System.out.println("Enter the assignment ID that represents a assignment.");
                    enteredID = scanner.nextInt();
                    System.out.println("Enter a new description: "); scanner.nextLine();

                    newDescription = scanner.nextLine();
                    listOfAssignments.editDescription(enteredID, newDescription);
                    System.out.println("Description changed!");
                }

            } else if (input == 4) {

                displayHorizontalLine();
                int enteredID;

                System.out.println("Enter the assignment ID that represents an assignment you want to delete:");
                enteredID = scanner.nextInt();
                listOfAssignments.removeAssignment(enteredID);
                System.out.println("Assignment deleted!");

            } else if (input == 5) {

                int numUnfinished;
                int numFinished;

                displayHorizontalLine();
                numUnfinished = listOfAssignments.viewNumberUnfinishedAssignments();
                System.out.println("You have " + numUnfinished + " unfinished assignments.");
                numFinished = listOfAssignments.viewNumberFinishedAssignments();
                System.out.println("You have " + numFinished + " finished assignments.");

            } else if (input == 6) {

                int enteredID;
                String finishTime;

                displayHorizontalLine();
                System.out.println("Enter the assignment ID that represents the assignment you have finished: ");
                enteredID = scanner.nextInt();
                System.out.println("What time have you finished? Please enter " 
                        + "in yyyy-mm-dd hh:mm format: "); scanner.nextLine();

                finishTime = scanner.nextLine();
                listOfAssignments.moveToFinished(enteredID, finishTime);
                System.out.println("Assignment has been moved to finished assignment list!");

            } else if (input == 7) {

                String typeInString;

                displayHorizontalLine();
                listOfAssignments.sortFinishedAssignments();
                System.out.println("Your list of assignments is sorted!");
                sortedFinishedAssignments = listOfAssignments.getSortedFinishedAssignments();
                for (Homework h : sortedFinishedAssignments) {
                    typeInString = getTypeInString(h.getType());
                    System.out.println("ID: " + h.getID() + " " + h.getName() + " " + h.getCourse() + " " + 
                                typeInString + ". Due at " + h.getDueDate() + ". Managed to start at " + 
                                h.getStartTime() + " Description: " + h.getDescription() + ". Finished at " + 
                                h.getFinishTime() + ". Spent " + h.getDuration() + " minutes");
                }

            } else if (input == 8) {

                displayHorizontalLine();
                System.out.println("Thank you for using the app! Good luck on your studies :)");
                operating = false;

            } else {

                displayHorizontalLine();
                System.out.println("Oops...You have entered an invalid value. Please re-enter again :(");

            }
        }
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

    
}


