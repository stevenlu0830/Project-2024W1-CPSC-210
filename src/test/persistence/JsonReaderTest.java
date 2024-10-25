package persistence;

import org.junit.Test;
import java.util.List;

import java.io.IOException;

import model.ListOfAsms;
import model.AsmType;
import model.Homework;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {
    
    @Test
    public void testReadNonExistFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ListOfAsms loa = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderEmptyLists() {
        JsonReader reader = new JsonReader("./data/testReadEmptyList.json");
        try {
            ListOfAsms loa = reader.read();
            assertEquals(0, loa.viewNumberUnfinishedAssignments());
            assertEquals(0, loa.viewNumberFinishedAssignments());
            assertEquals(0, loa.getSortedFinishedAssignments().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralLists() {
        JsonReader reader = new JsonReader("./data/testReadGeneralList.json");
        try {
            ListOfAsms loa = reader.read();
            List<Homework> unfinishedAssignments = loa.getUnfinishedAssignments();
            List<Homework> finishedAssignments = loa.getFinishedAssignments();
            List<Homework> sortedFinishedAssignments = loa.getSortedFinishedAssignments();

            assertEquals(2, unfinishedAssignments.size());
            assertEquals(2, finishedAssignments.size());
            assertEquals(2, sortedFinishedAssignments.size());

            checkHomework(3, "Webwork 1", "MATH 200", AsmType.ShortQuestions, "2024-10-24 10:00", "2024-10-23 13:00",
                    "", "", 0, unfinishedAssignments.get(0));
            checkHomework(4, "PSet1", "CPSC 110", AsmType.ShortQuestions, "2024-10-26 22:00", "2024-10-25 20:00",
                    "Rent a computer", "", 0, unfinishedAssignments.get(1));
            checkHomework(1, "Research Paper", "WRDS 150", AsmType.Essay, "2024-10-28 23:59", "2024-10-27 20:00",
                    "At least 2000 words", "2024-10-27 20:10", 10, finishedAssignments.get(0));
            checkHomework(2, "Newspaper Reading", "GEOG 121", AsmType.Readings, "2024-10-30 23:59", "2024-10-29 01:00",
                    "", "2024-10-29 01:05", 5, finishedAssignments.get(1));
            checkHomework(2, "Newspaper Reading", "GEOG 121", AsmType.Readings, "2024-10-30 23:59", "2024-10-29 01:00",
                    "", "2024-10-29 01:05", 5, sortedFinishedAssignments.get(0));
            checkHomework(1, "Research Paper", "WRDS 150", AsmType.Essay, "2024-10-28 23:59", "2024-10-27 20:00",
                    "At least 2000 words", "2024-10-27 20:10", 10, sortedFinishedAssignments.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}

