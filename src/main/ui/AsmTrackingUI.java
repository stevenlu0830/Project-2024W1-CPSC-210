package ui;


import javax.swing.JFrame;

import javax.swing.JTabbedPane;

import model.ListOfAsms;
import persistence.JsonReader;
import persistence.JsonWriter;


// Represents the central controller of GUI Assignment Tracking Application 
public class AsmTrackingUI {

    private static final String JSON_STORE = "./data/listOfAssignments.json";
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 750;
    
    
    

    private JFrame frame;
    private JTabbedPane sidebar;
    private ListOfAsms listOfAssignments;
    private int hwId = 1;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: Main method that starts the GUI
    public static void main(String[] args) {
        new AsmTrackingUI();
    }

    // MODIFIES: this
    // EFFECTS: creates the GUI frame, a sidebar on the left, new lists of assignments
    public AsmTrackingUI() {
        frame = new JFrame("Assignment Tracking Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);

        listOfAssignments = new ListOfAsms();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);
        addTabsToSidebar();
        frame.add(sidebar);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Getters
    public ListOfAsms getListOfAssignments() {
        return listOfAssignments;
    }

    public int getHwId() {
        return hwId;
    }

    public JsonWriter getJsonWriter() {
        return jsonWriter;
    }

    public JsonReader getJsonReader() {
        return jsonReader;
    }

    // MODIFIES: this
    // EFFECTS: Add unfinished assignment tab, finished assignment tab and save/load assignment tab to the sidebar
    private void addTabsToSidebar() {
        
    }

    



}


