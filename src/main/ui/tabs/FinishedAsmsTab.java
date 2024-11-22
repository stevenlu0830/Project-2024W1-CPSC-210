package ui.tabs;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
        
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that views the number of finished assignments
    private void addAndPlaceViewNumberOfFinishedAsmsButton() {
        
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that sort the finished assignments in increasing order of duration
    private void addAndPlaceSortFinishedAsmsButton() {
        
    }

    

}
