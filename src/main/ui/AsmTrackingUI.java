package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import persistence.JsonReader;
import persistence.JsonWriter;

import model.ListOfAsms;
import ui.tabs.FinishedAsmsTab;
import ui.tabs.SaveAndLoadTab;
import ui.tabs.UnfinishedAsmsTab;


// Represents the central controller of GUI Assignment Tracking Application 
public class AsmTrackingUI {

    private static final String JSON_STORE = "./data/listOfAssignments.json";
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 750;
    private static final ImageIcon CROSS_ICON = new ImageIcon("./src/images/cross.png");
    private static final ImageIcon TICK_ICON = new ImageIcon("./src/images/tick.png");
    private static final ImageIcon DL_OR_UL_ICON = new ImageIcon("./src/images/dlul.png");

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
    // EFFECTS: Set the given list of assignments
    public void setListOfAssignments(ListOfAsms listOfAssignments) {
        this.listOfAssignments = listOfAssignments;
    }

    // EFFECTS: Set the given hwId (hwId acts as a counter) 
    public void sethwId(int hwId) {
        this.hwId = hwId;
    }

    // MODIFIES: this
    // EFFECTS: Add unfinished assignment tab, finished assignment tab and save/load assignment tab to the sidebar
    private void addTabsToSidebar() {
        JPanel unfAsmTab = new UnfinishedAsmsTab(this);
        JPanel finAsmTab = new FinishedAsmsTab(this);
        JPanel saveAndLoadTab = new SaveAndLoadTab(this);

        sidebar.addTab("Unfinished Assignments", CROSS_ICON, unfAsmTab, "Unfinished Assignments");
        sidebar.addTab("Finished Assignments", TICK_ICON, finAsmTab, "Finished Assignments");
        sidebar.addTab("Save/Load Assignments", DL_OR_UL_ICON, saveAndLoadTab, "Save/Load Assignments");
    }

    


}


