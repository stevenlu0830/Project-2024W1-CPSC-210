package persistence;

import model.AsmType;
import model.Homework;
import model.ListOfAsms;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

// Represents a reader that reads list of assignments from JSON data stored in file
public class JsonReader {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads list of assignments from file and returns it;
    //          throws IOException if an error occurs reading data from file
    public ListOfAsms read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseListOfAsms(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses list of assignments from JSON object and returns it
    private ListOfAsms parseListOfAsms(JSONObject jsonObject) {
        ListOfAsms loa = new ListOfAsms();
        addAssignments(loa, jsonObject);
        return loa;
    }

    // MODIFIES: loa
    // EFFECTS: parses assignments from JSON object and adds them to list of assignments
    private void addAssignments(ListOfAsms loa, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("unfinishedAssignments");
        for (Object json : jsonArray) {
            JSONObject nextAsm = (JSONObject) json;
            addUnfinishedAssignment(loa, nextAsm);
        }

        JSONArray jsonArray2 = jsonObject.getJSONArray("finishedAssignments");
        for (Object json : jsonArray2) {
            JSONObject nextAsm = (JSONObject) json;
            addFinishedAssignment(loa, nextAsm);
        }

        JSONArray jsonArray3 = jsonObject.getJSONArray("sortedFinishedAssignments");
        for (Object json : jsonArray3) {
            JSONObject nextAsm = (JSONObject) json;
            addSortedFinishedAssignment(loa, nextAsm);
        }
    }

    // MODIFIES: loa
    // EFFECTS: parses an assignmnet from JSON object and adds it to list of unfinished assignments
    private void addUnfinishedAssignment(ListOfAsms loa, JSONObject jsonObject) {
        int hwID = jsonObject.getInt("hwID");
        String name = jsonObject.getString("name");
        String course = jsonObject.getString("course");
        AsmType type = AsmType.valueOf(jsonObject.getString("type"));
        String dueDate = jsonObject.getString("dueDate");
        String startTime = jsonObject.getString("startTime");
        String description = jsonObject.getString("description");
        String finishTime  = jsonObject.getString("finishTime");
        int duration = jsonObject.getInt("duration");
        Homework hw = new Homework(hwID, name, course, type, dueDate, startTime, description, finishTime, duration);
        loa.addAssignment(hw);
    }

    // MODIFIES: loa
    // EFFECTS: parses an assignmnet from JSON object and adds it to list of finished assignments
    private void addFinishedAssignment(ListOfAsms loa, JSONObject jsonObject) {
        int hwID = jsonObject.getInt("hwID");
        String name = jsonObject.getString("name");
        String course = jsonObject.getString("course");
        AsmType type = AsmType.valueOf(jsonObject.getString("type"));
        String dueDate = jsonObject.getString("dueDate");
        String startTime = jsonObject.getString("startTime");
        String description = jsonObject.getString("description");
        String finishTime  = jsonObject.getString("finishTime");
        int duration = jsonObject.getInt("duration");
        Homework hw = new Homework(hwID, name, course, type, dueDate, startTime, description, finishTime, duration);
        loa.addFinishAssignment(hw);
    }

    // MODIFIES: loa
    // EFFECTS: parses an assignmnet from JSON object and adds it to list of sorted finished assignments
    private void addSortedFinishedAssignment(ListOfAsms loa, JSONObject jsonObject) {
        int hwID = jsonObject.getInt("hwID");
        String name = jsonObject.getString("name");
        String course = jsonObject.getString("course");
        AsmType type = AsmType.valueOf(jsonObject.getString("type"));
        String dueDate = jsonObject.getString("dueDate");
        String startTime = jsonObject.getString("startTime");
        String description = jsonObject.getString("description");
        String finishTime  = jsonObject.getString("finishTime");
        int duration = jsonObject.getInt("duration");
        Homework hw = new Homework(hwID, name, course, type, dueDate, startTime, description, finishTime, duration);
        loa.addSortedFinishAssignment(hw);
    }

}
