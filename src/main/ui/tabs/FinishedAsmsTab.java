package ui.tabs;

import javax.swing.*;

import model.AsmType;
import model.Homework;

import java.awt.event.*;
import java.util.ArrayList;

import ui.AsmTrackingUI;

// Represents the finished assignments tab that implemented user stories related to finished assignments
public class FinishedAsmsTab extends JPanel {

    private AsmTrackingUI controller;
    private JButton viewFinishedAsmsButton;
    private JButton viewNumberOfFinishedAsmsButton;
    private JButton sortFinishedAsmsButton;
    private JTextArea textArea;

    // REQUIRES: AsmTrackingUI controller that holds this tab
    // EFFECTS: Construct the finished assignment tab that sets the layout and adds textArea and buttons to the panel
    public FinishedAsmsTab(AsmTrackingUI controller) {
        this.controller = controller;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        textArea = new JTextArea();
        textArea.setEditable(false);
        this.add(new JScrollPane(textArea));

        addAndPlaceViewFinishedAsmsButton();
        addAndPlaceViewNumberOfFinishedAsmsButton();
        addAndPlaceSortFinishedAsmsButton();
        
        this.add(viewFinishedAsmsButton);
        this.add(viewNumberOfFinishedAsmsButton);
        this.add(sortFinishedAsmsButton);
    }

    // EFFECTS: Return the controller (for other methods doing further operations)
    public AsmTrackingUI getController() {
        return controller;
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that views the list of finished assignments
    private void addAndPlaceViewFinishedAsmsButton() {
        viewFinishedAsmsButton = new JButton("View Assignments");
        viewFinishedAsmsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadAssignments(); 
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Load the list finished assignments and view on the textbox 
    protected void loadAssignments() {
        ArrayList<Homework> unfinishedAssignments = getController().getListOfAsms().getFinishedAssignments();
        String list = "";

        if (unfinishedAssignments.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You don't have finished assignments!", "Null List", JOptionPane.WARNING_MESSAGE);
        } else {
            for (Homework h : unfinishedAssignments) {
                list = list + "ID: " + h.getID() + "\n" 
                        + "Name: " + h.getName() + "\n" 
                        + "Related Course: " + h.getCourse() + "\n"
                        + "Assignment Type: " + convertToString(h.getType()) + "\n" 
                        + "Due Date: " + h.getDueDate() + "\n" 
                        + "Start Time: " + h.getStartTime() + "\n" 
                        + "Description: " + h.getDescription() + "\n" 
                        + "Finish Time: " + h.getFinishTime() + "\n" 
                        + "Duration: " + h.getDuration() + "\n\n";
            }
        }

        textArea.setText(list);
    }

    // EFFECTS: Return the assignment type in string format
    private String convertToString(AsmType t) {
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

    // MODIFIES: this
    // EFFECTS: Add and place a button that views the number of finished assignments
    private void addAndPlaceViewNumberOfFinishedAsmsButton() {
        viewNumberOfFinishedAsmsButton = new JButton("View Number of Assignments");
        viewNumberOfFinishedAsmsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = getController().getListOfAsms().viewNumberFinishedAssignments();
                if (number == 1) {
                    JOptionPane.showMessageDialog(null, "You have " + number + " finished assignment!", "Number of Unfinished Assignments", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "You have " + number + " finished assignments!", "Number of Unfinished Assignments", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that sort the finished assignments in increasing order of duration
    private void addAndPlaceSortFinishedAsmsButton() {
        sortFinishedAsmsButton = new JButton("Sort Assignments (Increasing Duration)");
        sortFinishedAsmsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortFinishedAsms();
            }
        });
    }

    // MODIFIES: this, ListOfAsms
    // EFFECTS: Sort the list of finished assignments in increasing order of duration and display the list immediately 
    protected void sortFinishedAsms() {
        String list = "";

        if (getController().getListOfAsms().getFinishedAssignments().isEmpty()) {
            JOptionPane.showMessageDialog(null, "You don't have finished assignments!", "Null List", JOptionPane.WARNING_MESSAGE);
        } else {
            getController().getListOfAsms().sortFinishedAssignments();

            ArrayList<Homework> sortedFinishedAsms = getController().getListOfAsms().getSortedFinishedAssignments();

            for (Homework h : sortedFinishedAsms) {
                list = list + "ID: " + h.getID() + "\n" 
                        + "Name: " + h.getName() + "\n" 
                        + "Related Course: " + h.getCourse() + "\n"
                        + "Assignment Type: " + convertToString(h.getType()) + "\n" 
                        + "Due Date: " + h.getDueDate() + "\n" 
                        + "Start Time: " + h.getStartTime() + "\n" 
                        + "Description: " + h.getDescription() + "\n" 
                        + "Finish Time: " + h.getFinishTime() + "\n" 
                        + "Duration: " + h.getDuration() + "\n\n";
            }
            JOptionPane.showMessageDialog(null, "Assignments have sorted in increasing order of duration!", "Success", JOptionPane.INFORMATION_MESSAGE);

        }

        textArea.setText(list);
    }

    

}
