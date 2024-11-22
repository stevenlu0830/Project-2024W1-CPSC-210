package ui.tabs;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.ListOfAsms;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

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
        saveAndLoadInstruction = new JLabel("Save or Load all assignments using the button below!");
        saveAndLoadInstruction.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveAndLoadInstruction.setFont(new Font("Arial", Font.BOLD, 26));
    }

    // MODIFIES: this, JsonWriter
    // EFFECTS: Add and place the save button to the panel
    //          If the button is pressed, saves all information about list of assignments to the JSON file
    //          If the file is not found, catch FileNotFoundException
    private void addAndPlaceSaveButton() {
        saveButton = new JButton("Save to Computer", new ImageIcon("./src/images/ul.png"));
        saveButton.setFont(new Font("Arial", Font.PLAIN, 25));
        saveButton.setPreferredSize(new Dimension(500, 200));
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        saveButton.addActionListener(e -> {
            try {
                getController().getJsonWriter().open();
                getController().getJsonWriter().write(getController().getListOfAsms());
                getController().getJsonWriter().close();
                JOptionPane.showMessageDialog(null, "Assignments have saved to the computer!", "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException e1) {
                System.out.println("File not found!");
            }
        });
    }

    // MODIFIES: this, AsmTrackingUI
    // EFFECTS: Add and place the load button to the panel
    //          If the button is pressed, loads all information about list of assignments to the computer program
    //          If the file is not found, catch FileNotFoundException
    private void placeLoadButton() {
        loadButton = new JButton("Load from Computer", new ImageIcon("./src/images/dl.png"));
        loadButton.setFont(new Font("Arial", Font.PLAIN, 25));
        loadButton.setPreferredSize(new Dimension(500, 200));
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loadButton.addActionListener(e -> {
            try {
                ListOfAsms listOfAssignments = getController().getJsonReader().read();
                getController().setListOfAssignments(listOfAssignments);
                int hwIdStart = 1 + listOfAssignments.viewNumberFinishedAssignments() + listOfAssignments.viewNumberUnfinishedAssignments();
                getController().sethwId(hwIdStart);
                JOptionPane.showMessageDialog(null, "Assignments have loaded to the program!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e2) {
                System.out.println("Unable to read from file");
            }
        });
    }
}
