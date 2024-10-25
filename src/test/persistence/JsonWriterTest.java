package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import model.AsmType;
import model.Homework;
import model.ListOfAsms;

import java.util.List;

public class JsonWriterTest extends JsonTest {
    
    @Test
    public void testWriterInvalidFile() {
        try {
            ListOfAsms loa = new ListOfAsms();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyLists() {
        try {
            ListOfAsms loa = new ListOfAsms();
            JsonWriter writer = new JsonWriter("./data/testWriteEmptyList.json");
            writer.open();
            writer.write(loa);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriteEmptyList.json");
            loa = reader.read();
            assertEquals(0, loa.viewNumberUnfinishedAssignments());
            assertEquals(0, loa.viewNumberFinishedAssignments());
            assertEquals(0, loa.getSortedFinishedAssignments().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterGeneralLists() {
        try {
            ListOfAsms loa = new ListOfAsms();
            loa.addAssignment(new Homework(5, "Webwork 1", "MATH 200", AsmType.ShortQuestions, "2024-10-24 10:00", 
                    "2024-10-23 13:00", "", "", 0));
            loa.addAssignment(new Homework(6, "PSet1", "CPSC 110", AsmType.ShortQuestions, "2024-10-26 22:00",
                    "2024-10-25 20:00", "Rent a computer", "", 0));
            loa.addAssignment(new Homework(7, "Research Paper", "WRDS 150", AsmType.Essay, "2024-10-28 23:59",
                    "2024-10-27 20:00", "At least 2000 words", "", 0));
            loa.addAssignment(new Homework(8, "Newspaper Reading", "GEOG 121", AsmType.Readings, "2024-10-30 23:59",
                    "2024-10-29 01:00", "", "", 0));
            loa.moveToFinished(7, "2024-10-27 20:10");
            loa.moveToFinished(8, "2024-10-29 01:05");
            JsonWriter writer = new JsonWriter("./data/testWriteGeneralList.json");
            writer.open();
            writer.write(loa);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriteGeneralList.json");
            loa = reader.read();
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
            fail("Exception should not have been thrown");
        }
    }

}

