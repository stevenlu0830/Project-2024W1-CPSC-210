package ui.tabs;

import javax.swing.*;

import ui.AsmTrackingUI;

// Represents the unfinished assignments tab that implemented user stories related to unfinished assignments
public class UnfinishedAsmsTab extends JPanel {
    
    private AsmTrackingUI controller;

    private JButton viewAssignmentButton;
    private JButton addAssignmentButton;
    private JButton editInformationButton;
    private JButton removeAssignmentButton;
    private JButton viewNumberOfAssignmentButton;
    private JButton moveAssignmentButton;
    private JTextArea textArea;

    // REQUIRES: AsmTrackingUI controller that holds this tab
    // EFFECTS: Construct the unfinished assignment tab that sets the layout and adds textArea and buttons to the panel
    public UnfinishedAsmsTab(AsmTrackingUI controller) {
        this.controller = controller;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        textArea = new JTextArea();
        textArea.setEditable(false);
        this.add(new JScrollPane(textArea));

        addViewAssignmentButton();
        addAddAssignmentButton();
        addEditInformationButton();
        addRemoveAssignmentButton();
        addViewNumberOfAssignmentButton();
        addMoveAssignmentButton();
                
        this.add(viewAssignmentButton);
        this.add(addAssignmentButton);
        this.add(editInformationButton);
        this.add(removeAssignmentButton);
        this.add(viewNumberOfAssignmentButton);
        this.add(moveAssignmentButton);
    }

    // EFFECTS: Return the controller (for other methods doing further operations)
    public AsmTrackingUI getController() {
        return controller;
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that views the unfinished assignments
    private void addViewAssignmentButton() {
        
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that adds an unfinished assignment
    private void addAddAssignmentButton() {
        
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that edit information of an unfinished assignment
    private void addEditInformationButton() {
       
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that remove an unfinished assignment
    private void addRemoveAssignmentButton() {
        
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that views the number of unfinished assignments
    private void addViewNumberOfAssignmentButton() {
        
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that move an assignment to finished assignment list
    private void addMoveAssignmentButton() {
        
    }

    
}
