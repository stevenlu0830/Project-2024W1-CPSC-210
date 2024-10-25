package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.AsmType;
import model.Homework;

public class JsonTest {
    protected void checkHomework(int hwID, String name, String course, AsmType type, String dueDate, String startTime,
            String description, String finishTime, long duration, Homework h1) {
        assertEquals(hwID, h1.getID());
        assertEquals(name, h1.getName());
        assertEquals(course, h1.getCourse());
        assertEquals(type, h1.getType());
        assertEquals(dueDate, h1.getDueDate());
        assertEquals(startTime, h1.getStartTime());
        assertEquals(description, h1.getDescription());
        assertEquals(finishTime, h1.getFinishTime());
    }
}

