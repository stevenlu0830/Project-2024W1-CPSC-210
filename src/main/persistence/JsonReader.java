package persistence;

import model.ListOfAsms;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.experimental.categories.Category;

public class JsonReader {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    //          throws IOException if an error occurs reading data from file
    public ListOfAsms read() throws IOException {
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return "";
    }

    // EFFECTS: parses list of assignments from JSON object and returns it
    private ListOfAsms parseListOfAsms(JSONObject jsonObject) {
        return null;
    }

    // MODIFIES: loa
    // EFFECTS: parses assignments from JSON object and adds them to list of assignments
    private void addAssignments(ListOfAsms loa, JSONObject jsonObject) {
        
    }

    // MODIFIES: loa
    // EFFECTS: parses an assignmnet from JSON object and adds it to list of assignments
    private void addOneAssignment(ListOfAsms loa, JSONObject jsonObject) {
        
    }

}
