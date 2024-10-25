package model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeworkTest {
    
    private Homework h1;
    private Homework h2;

    @BeforeEach
    public void setUp() {
        h1 = new Homework(1, "WW1", "MATH 100", AsmType.ShortQuestions, "2024-10-11 23:59", "2024-10-10 12:00", "", "", 0);
        h2 = new Homework(2, "Research Paper", "WRDS 150", AsmType.Essay, "2024-10-11 23:59", "2024-10-10 12:01", 
        ">= 2000 words", "", 0);
    }

    @Test
    public void testConstructor() {
        assertEquals(1, h1.getID());
        assertEquals("WW1", h1.getName());
        assertEquals("MATH 100", h1.getCourse());
        assertEquals(AsmType.ShortQuestions, h1.getType());
        assertEquals("2024-10-11 23:59", h1.getDueDate());
        assertEquals("2024-10-10 12:00", h1.getStartTime());
        assertEquals("", h1.getDescription());
        assertEquals("", h1.getFinishTime());

        assertEquals(2, h2.getID());
        assertEquals("Research Paper", h2.getName());
        assertEquals("WRDS 150", h2.getCourse());
        assertEquals(AsmType.Essay, h2.getType());
        assertEquals("2024-10-11 23:59", h2.getDueDate());
        assertEquals("2024-10-10 12:01", h2.getStartTime());
        assertEquals(">= 2000 words", h2.getDescription());
        assertEquals("", h1.getFinishTime());

    }

    @Test
    public void testSetters() {
        assertEquals("2024-10-11 23:59", h1.getDueDate());
        h1.setDueDate("2024-10-12 00:00");
        assertEquals("2024-10-12 00:00", h1.getDueDate());

        assertEquals("", h1.getDescription());
        h1.setDescription("ask ta for help");
        assertEquals("ask ta for help", h1.getDescription());

        h1.setFinishTime("2024-10-10 12:01");
        assertEquals("2024-10-10 12:01", h1.getFinishTime());

        h1.setDuration(10);
        assertEquals(10, h1.getDuration());
    }

    @Test
    public void testTimeDifferenceinMinutes() {
        h1.setFinishTime("2024-10-10 12:01");
        assertEquals(1, h1.getTimeDifference(h1.getStartTime(), h1.getFinishTime()));
    }
}
