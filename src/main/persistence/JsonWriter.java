package persistence;

import java.io.*;

import model.ListOfAsms;

// // Represents a writer that writes JSON representation of assignment lists to file
public class JsonWriter {

    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens the writer; 
    //          throws FileNotFoundException if destination file cannot be opened for writing
    public void open() throws FileNotFoundException {

    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of assignment lists to file
    public void write(ListOfAsms loa) {

    } 

    // MODIFIES: this
    // EFFECTS: closes the writer
    public void close() {

    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        
    }

}

