package ui.tabs;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.AsmTrackingUI;

// Represents the save and load assignments tab that can save or load assignments to the program
public class SaveAndLoadTab extends JPanel {
    
    private AsmTrackingUI controller;

    private JLabel saveAndLoadInstruction;
    private JButton saveButton;
    private JButton loadButton;

    // REQUIRES: AsmTrackingUI controller that holds this tab
    // EFFECTS: Construct the save and load tab that sets the layout and adds buttons to the panel
    public SaveAndLoadTab(AsmTrackingUI controller) {
        this.controller = controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addAndPlaceInstruction();
        addAndPlaceSaveButton();
        placeLoadButton();
                
        this.add(saveAndLoadInstruction);
        this.add(Box.createVerticalStrut(40));
        this.add(saveButton);
        this.add(loadButton);
                
    }
           
    // EFFECTS: Return the controller (for other methods doing further operations)
    public AsmTrackingUI getController() {
        return controller;
    }

    // MODIFIES: this
    // EFFECTS: Add and place the instruction to the panel
    private void addAndPlaceInstruction() {

    }

    // MODIFIES: this, JsonWriter
    // EFFECTS: Add and place the save button to the panel
    //          If the button is pressed, saves all information about list of assignments to the JSON file
    //          If the file is not found, catch FileNotFoundException
    private void addAndPlaceSaveButton() {
        
    }

    // MODIFIES: this, AsmTrackingUI
    // EFFECTS: Add and place the load button to the panel
    //          If the button is pressed, loads all information about list of assignments to the computer program
    //          If the file is not found, catch FileNotFoundException
    private void placeLoadButton() {
        
    }
}
