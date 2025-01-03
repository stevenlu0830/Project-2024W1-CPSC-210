package ui.tabs;

import javax.swing.*;

import model.AsmType;
import model.Homework;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

        addAndPlaceViewAssignmentButton();
        addAndPlaceAddAssignmentButton();
        addAndPlaceEditInformationButton();
        addAndPlaceRemoveAssignmentButton();
        addAndPlaceViewNumberOfAssignmentButton();
        addAndPlaceMoveAssignmentButton();
                
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
    private void addAndPlaceViewAssignmentButton() {
        viewAssignmentButton = new JButton("View Assignments");
        viewAssignmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAssignments(); 
            }
        });
    }
    
    // MODIFIES: this
    // EFFECTS: Load the list unfinished assignments and view on the textbox
    protected void viewAssignments() {
        ArrayList<Homework> unfinishedAssignments = getController().getListOfAsms().getUnfinishedAssignments();
        String list = "";

        if (unfinishedAssignments.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You don't have unfinished assignments!", "Null List", 
                    JOptionPane.WARNING_MESSAGE);
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
            getController().getListOfAsms().viewUnfinishedAsmsLog();
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
        } else if (t == AsmType.ExtraPractice) {
            return "Extra Practices";
        } else if (t == AsmType.Readings) {
            return "Readings";
        } else if (t == AsmType.Coding) {
            return "Coding";
        } else if (t == AsmType.Project) {
            return "Project";
        } else if (t == AsmType.Others) {
            return "Others";
        } else {
            return "";
        }
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that adds an unfinished assignment
    private void addAndPlaceAddAssignmentButton() {
        addAssignmentButton = new JButton("Add Assignment");
        addAssignmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOneAssignmentNewFrame(); 
            }
        });
    }

    // EFFECTS: Create a new frame that allow us to enter the information and add the assignment to unfinished 
    //          assignments list
    protected void addOneAssignmentNewFrame() {
        JFrame inputFrame = new JFrame("Add an assignment");
        gridFrameSetUp(inputFrame, 600, 400, 10, 2);

        JLabel nameLabel = new JLabel("Assignment Name:");
        JTextField nameField = new JTextField();

        JLabel courseLabel = new JLabel("Related Course:");
        JTextField courseField = new JTextField();

        JLabel typeLabel = new JLabel("Assignment Type: ");
        String[] options = {"Quiz", "Short Questions", "Essay", "Extra Practices", "Readings", "Coding", "Project", 
                "Others"};
        JComboBox<String> comboBox = new JComboBox<>(options);

        JLabel dueDateLabel = new JLabel("Due Date and Time (yyyy-mm-dd hh:mm):");
        JTextField dueDateField = new JTextField();

        JLabel startDateLabel = new JLabel("Date and Time to Start (yyyy-mm-dd hh:mm):");
        JTextField startDateField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description (Optional):");
        JTextArea textArea = new JTextArea(5, 30); 
        textAreaSetUp(textArea);       
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton submitButton = new JButton("Add the assignment");

        addAsm(inputFrame, nameField, courseField, comboBox, dueDateField, startDateField, textArea, submitButton);
        setLayoutAndAdd(inputFrame, nameLabel, nameField, courseLabel, courseField, typeLabel, comboBox, dueDateLabel,
                dueDateField, startDateLabel, startDateField, descriptionLabel, scrollPane, submitButton);
    }

    // EFFECTS: Sets up the grid frame such as the size, close operation and the layout
    private void gridFrameSetUp(JFrame inputFrame, int width, int height, int rows, int cols) {
        inputFrame.setSize(width, height);
        inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        inputFrame.setLayout(new GridLayout(rows, cols));
        inputFrame.setLocationRelativeTo(null);
    }

    // EFFECTS: Sets up the flow frame
    private void flowFrameSetUp(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        frame.setSize(width, height);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
    }

    
    // EFFECTS: Sets up the text area in the add-assignment frame
    private void textAreaSetUp(JTextArea textArea) {
        textArea.setWrapStyleWord(true);  
        textArea.setLineWrap(true);
    }

    // MODIFIES: AsmTrackingUI, ListOfAsms
    // EFFECTS: Do the action (adding an assignment) as the button is pressed 
    private void addAsm(JFrame inputFrame, JTextField nameField, JTextField courseField, JComboBox<String> comboBox,
            JTextField dueDateField, JTextField startDateField, JTextArea textArea, JButton submitButton) {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dueDate = dueDateField.getText();
                String startDate = startDateField.getText();

                if (!isValidTime(dueDate) || !isValidTime(startDate)) {
                    JOptionPane.showMessageDialog(null, "Invalid date format!", "Date Format Issue", 
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    int hwId = getController().getCurrentID();
                    String name = nameField.getText();
                    String course = courseField.getText();
                    AsmType type = getAsmType((String) comboBox.getSelectedItem());
                    String description = textArea.getText();

                    Homework hw = new Homework(hwId, name, course, type, dueDate, startDate, description, "", 0);
                    getController().idIncrementByOne();
                    getController().getListOfAsms().addAssignment(hw);
                    JOptionPane.showMessageDialog(null, "Assignment added!", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    inputFrame.dispose();
                }
            }
        });
    }

    // EFFECTS: Sets the layout and add labels and fields to the add-assignment frame
    private void setLayoutAndAdd(JFrame inputFrame, JLabel nameLabel, JTextField nameField, JLabel courseLabel,
            JTextField courseField, JLabel typeLabel, JComboBox<String> comboBox, JLabel dueDateLabel,
            JTextField dueDateField, JLabel startDateLabel, JTextField startDateField, JLabel descriptionLabel,
            JScrollPane scrollPane, JButton submitButton) {
        inputFrame.setLayout(new GridLayout(7,2));

        inputFrame.add(nameLabel);
        inputFrame.add(nameField);
        inputFrame.add(courseLabel);
        inputFrame.add(courseField);
        inputFrame.add(typeLabel);
        inputFrame.add(comboBox);
        inputFrame.add(dueDateLabel);
        inputFrame.add(dueDateField);
        inputFrame.add(startDateLabel);
        inputFrame.add(startDateField);
        inputFrame.add(descriptionLabel);
        inputFrame.add(scrollPane);
        inputFrame.add(submitButton);

        inputFrame.setVisible(true);
    }

    // EFFECTS: Determine whether the date format is valid
    protected boolean isValidTime(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);  
        try {
            dateFormat.parse(time);
            String[] dateTimeParts = time.split(" ");
            String date = dateTimeParts[0];
            String timePart = dateTimeParts[1];
            String[] timeComponents = timePart.split(":");
            int hour = Integer.parseInt(timeComponents[0]);
            int minute = Integer.parseInt(timeComponents[1]);
            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // EFFECTS: Return the assignment type in AsmType type
    protected AsmType getAsmType(String typeEntered) {
        if (typeEntered.equals("Quiz")) {
            return AsmType.Quiz;
        } else if (typeEntered.equals("Short Questions")) {
            return AsmType.ShortQuestions;
        } else if (typeEntered.equals("Essay")) {
            return AsmType.Essay;
        } else if (typeEntered.equals("Extra Practices")) {
            return AsmType.ExtraPractice;
        } else if (typeEntered.equals("Readings")) {
            return AsmType.Readings;
        } else if (typeEntered.equals("Coding")) {
            return AsmType.Coding;
        } else if (typeEntered.equals("Project")) {
            return AsmType.Project;
        } else if (typeEntered.equals("Others")) {
            return AsmType.Others;
        } else {
            return null;
        }
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that edit information of an unfinished assignment
    private void addAndPlaceEditInformationButton() {
        editInformationButton = new JButton("Edit Assignment Information");
        editInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkNullAsmsBeforeEdit();
            }
        });
    }

    // EFFECTS: Check whether there is at least one assignment before editing its information
    protected void checkNullAsmsBeforeEdit() {
        ArrayList<Homework> unfinishedAssignments = getController().getListOfAsms().getUnfinishedAssignments();
        if (unfinishedAssignments.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No unfinished assignments to edit", "Null List", 
                    JOptionPane.WARNING_MESSAGE);
        } else {
            chooseWhichPartNewFrame();
        }
    }

    // EFFECTS: Create a new frame for user to choose edit due date or description
    private void chooseWhichPartNewFrame() {
        JFrame frame = new JFrame("Select a part");
        flowFrameSetUp(frame, 350, 100);

        JLabel questionLabel = new JLabel("Select which part of the assignment you want to edit:");
        JRadioButton option1 = new JRadioButton("Due Date");
        JRadioButton option2 = new JRadioButton("Description");

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);

        frame.add(questionLabel);
        frame.add(option1);
        frame.add(option2);

        JButton saveButton = new JButton("Edit");
        frame.add(saveButton);

        decideFrame(frame, option1, option2, saveButton);

        frame.setVisible(true);
    }

    // EFFECTS: Determine which frame to be displayed based on the option selected
    private void decideFrame(JFrame frame, JRadioButton option1, JRadioButton option2, JButton saveButton) {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = 0;
                if (option1.isSelected()) {
                    option = 1;
                } else if (option2.isSelected()) {
                    option = 2;
                } 
                frame.dispose();

                if (option == 1) {
                    dueDateNewFrame();
                } else if (option == 2) {
                    descriptionNewFrame();
                }
            }
        });
    }

    // EFFECTS: Create a new frame that allows users to edit the due date of the particular assignment
    protected void dueDateNewFrame() {
        JFrame newFrame = new JFrame("Edit Due Date");
        gridFrameSetUp(newFrame, 600, 200, 3, 2);

        JLabel idLabel = new JLabel("Assignment ID that represents an assignment:");
        JTextField idField = new JTextField();

        JLabel dueDateLabel = new JLabel("New Due Date and Time (yyyy-mm-dd hh:mm):");
        JTextField dueDateField = new JTextField();

        JButton submitButton = new JButton("Edit Due Date");

        editDueDate(newFrame, idField, dueDateField, submitButton);

        newFrame.add(idLabel);
        newFrame.add(idField);
        frameAddElements(newFrame, dueDateLabel, dueDateField, submitButton);
    }

    // EFFECTS: Add the frame, label and the button to the frame
    private void frameAddElements(JFrame frame, JLabel label, JTextField field, JButton submitButton) {
        frame.add(label);
        frame.add(field);
        frame.add(submitButton);
        
        frame.setVisible(true);
    }

    // MODIFIES: ListOfAsms
    // EFFECTS: Do the action (edit due date) as the button is pressed
    private void editDueDate(JFrame newFrame, JTextField idField, JTextField dueDateField, JButton submitButton) {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int enteredID = Integer.parseInt(idField.getText());
                String dueDate = dueDateField.getText();
                
                if (!isValidTime(dueDate)) {
                    JOptionPane.showMessageDialog(null, "Invalid date format!", "Due Date", 
                            JOptionPane.WARNING_MESSAGE);
                } else if (getController().getListOfAsms().getHWbyID(enteredID) == null) {
                    JOptionPane.showMessageDialog(null, "Assignment not found!", "Null Assignment", 
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    getController().getListOfAsms().editDueDate(enteredID, dueDate);
                    JOptionPane.showMessageDialog(null, "Due date edited!", "Success", JOptionPane.INFORMATION_MESSAGE);
    
                    newFrame.dispose();
                }
            }
        });
    }

    // EFFECTS: Create a new frame that allows users to edit the description of the particular assignment
    protected void descriptionNewFrame() {
        JFrame newFrame = new JFrame("Edit Description");
        gridFrameSetUp(newFrame, 600, 300, 3, 2);

        JLabel idLabel = new JLabel("Assignment ID that represents an assignment:");
        JTextField idField = new JTextField();

        JLabel descriptionLabel = new JLabel("New Description:");
        JTextArea textArea = new JTextArea(5, 30); 
        textAreaSetUp(textArea);       
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton submitButton = new JButton("Edit Description");

        editDescription(newFrame, idField, textArea, submitButton);
        descripFrameAddElements(newFrame, idLabel, idField, descriptionLabel, scrollPane, submitButton);
    }

    // EFFECTS: Add the elements to the description frame
    private void descripFrameAddElements(JFrame newFrame, JLabel idLabel, JTextField idField, JLabel descriptionLabel,
            JScrollPane scrollPane, JButton submitButton) {
        newFrame.add(idLabel);
        newFrame.add(idField);
        newFrame.add(descriptionLabel);
        newFrame.add(scrollPane);
        newFrame.add(submitButton);
        
        newFrame.setVisible(true);
    }

    // MODIFIES: ListOfAsms
    // EFFECTS: Do the action (edit description) as the button is pressed
    private void editDescription(JFrame newFrame, JTextField idField, JTextArea textArea, JButton submitButton) {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int enteredID = Integer.parseInt(idField.getText());
                String description = textArea.getText();
                
                if (getController().getListOfAsms().getHWbyID(enteredID) == null) {
                    JOptionPane.showMessageDialog(null, "Assignment not found!", "Null Assignment", 
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    getController().getListOfAsms().editDescription(enteredID, description);
                    JOptionPane.showMessageDialog(null, "Description edited!", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
    
                    newFrame.dispose();
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that remove an unfinished assignment
    private void addAndPlaceRemoveAssignmentButton() {
        removeAssignmentButton = new JButton("Remove an Assignment");
        removeAssignmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getController().getListOfAsms().getUnfinishedAssignments().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No unfinished assignments to remove", "Null List", 
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    removeAssignmentWindow();
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Create a new frame that allows users to remove a particular assignment
    protected void removeAssignmentWindow() {
        JFrame frame = new JFrame("Remove an assignment");
        gridFrameSetUp(frame, 600, 100, 2, 2);

        JLabel idLabel = new JLabel("Assignment ID that represents an assignment:");
        JTextField idField = new JTextField();

        JButton submitButton = new JButton("Remove the Assignment");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int enteredID = Integer.parseInt(idField.getText());
                
                if (getController().getListOfAsms().getHWbyID(enteredID) == null) {
                    JOptionPane.showMessageDialog(null, "Assignment not found!", "Null Assignment", 
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    getController().getListOfAsms().removeAssignment(enteredID);
                    JOptionPane.showMessageDialog(null, "Assignment deleted!", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
    
                    frame.dispose();
                }
            }
        });

        frameAddElements(frame, idLabel, idField, submitButton);
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that views the number of unfinished assignments
    private void addAndPlaceViewNumberOfAssignmentButton() {
        viewNumberOfAssignmentButton = new JButton("View Number of Assignments");
        viewNumberOfAssignmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = getController().getListOfAsms().viewNumberUnfinishedAssignments();
                if (number == 1) {
                    JOptionPane.showMessageDialog(null, "You have " + number + " unfinished assignment!", 
                            "Number of Unfinished Assignments", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "You have " + number + " unfinished assignments!", 
                            "Number of Unfinished Assignments", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Add and place a button that move an assignment to finished assignment list
    private void addAndPlaceMoveAssignmentButton() {
        moveAssignmentButton = new JButton("Finish an Assignment");
        moveAssignmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getController().getListOfAsms().getUnfinishedAssignments().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You have no unfinished assignments!", "Null List", 
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    moveAssignmentWindow();
                }
            }
        });
    }

    // EFFECTS: Create a new frame that allows users to finish a particular assignment
    protected void moveAssignmentWindow() {
        JFrame frame = new JFrame("Finish an assignment");
        gridFrameSetUp(frame, 600, 250, 3, 2);

        JLabel idLabel = new JLabel("Assignment ID that represents an assignment:");
        JTextField id2Field = new JTextField();

        JLabel finishDateLabel = new JLabel("Finish Date and Time (yyyy-mm-dd hh:mm):");
        JTextField finishDateField = new JTextField();

        JButton submitButton = new JButton("Finish the Assignment");

        finishAsm(frame, id2Field, finishDateField, submitButton);

        frame.add(idLabel);
        frame.add(id2Field);
        frameAddElements(frame, finishDateLabel, finishDateField, submitButton);
    }

    // MODIFIES: ListOfAsms
    // EFFECTS: Do the action (finish assignment) as the button is pressed
    private void finishAsm(JFrame frame, JTextField id2Field, JTextField finishDateField, JButton submitButton) {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int enteredID = Integer.parseInt(id2Field.getText());
                String finishDate = finishDateField.getText();
                
                if (getController().getListOfAsms().getHWbyID(enteredID) == null) {
                    JOptionPane.showMessageDialog(null, "Assignment not found!", "Null Assignment", 
                            JOptionPane.WARNING_MESSAGE);
                } else if (!isValidTime(finishDate)) {
                    JOptionPane.showMessageDialog(null, "Invalid date format!", "Due Date", 
                            JOptionPane.WARNING_MESSAGE);
                } else if (finishDateIsEarly(getController().getListOfAsms().getHWbyID(enteredID).getStartTime(), 
                        finishDate)) {
                    JOptionPane.showMessageDialog(null, "Finish date shouldn't be earlier than start date!", 
                            "Early Finish Date", JOptionPane.WARNING_MESSAGE);
                } else {
                    getController().getListOfAsms().moveToFinished(enteredID, finishDate);
                    JOptionPane.showMessageDialog(null, "Well done! You have finished an assignment!", 
                            "Success", JOptionPane.INFORMATION_MESSAGE);
    
                    frame.dispose();
                }
            }
        });
    }

    // EFFECTS: Return true when the finish date is earlier than the start date
    protected boolean finishDateIsEarly(String startDate, String finishDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date parsedDate1 = sdf.parse(finishDate);
            Date parsedDate2 = sdf.parse(startDate);
            
            return parsedDate1.before(parsedDate2);
        } catch (ParseException e) {
            return false;
        }
    }
}
