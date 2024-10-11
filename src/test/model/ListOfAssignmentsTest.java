package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class ListOfAssignmentsTest {

    private ListOfAssignments testList;
    private ArrayList<Homework> testUnfinishedList;
    private ArrayList<Homework> testFinishedList;
    private ArrayList<Homework> testSortedFinishedList;

    @Before
    public void setUp() {
        testList = new ListOfAssignments();
        testUnfinishedList = testList.getUnfinishedAssignments();
        testFinishedList = testList.getFinishedAssignments();
        testSortedFinishedList = testList.getSortedFinishedAssignments();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testList.viewNumberUnfinishedAssignments());
        assertEquals(0, testList.viewNumberFinishedAssignments());
    }

    @Test
    public void testAddAssignments() {
        Homework hw1 = new Homework(1, "WW3", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        Homework hw2 = new Homework(1, "WW4", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        
        testList.addAssignment(hw1);
        assertEquals(1, testList.viewNumberUnfinishedAssignments());

        testList.addAssignment(hw2);
        assertEquals(2, testList.viewNumberUnfinishedAssignments());
    }

    @Test
    public void testEditDueDate() {
        Homework hw1 = new Homework(1, "WW3", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        Homework hw2 = new Homework(2, "WW4", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        testList.addAssignment(hw1);
        testList.addAssignment(hw2);
        testList.editDueDate(1, "2024-10-21 11:22");
        assertEquals("2024-10-21 11:22", testList.getHWbyID(1).getDueDate());
        assertEquals(null, testList.getHWbyID(0));
        testList.editDueDate(0, "2024-10-10 11:11");
        assertEquals("2024-10-21 11:22", testList.getHWbyID(1).getDueDate());
    } 

    @Test
    public void testEditDescription() {
        Homework hw1 = new Homework(1, "WW3", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        Homework hw2 = new Homework(2, "WW4", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        testList.addAssignment(hw1);
        testList.addAssignment(hw2);
        testList.editDescription(2, "use a calculator");
        assertEquals("use a calculator", testList.getHWbyID(2).getDescription());
        assertEquals(null, testList.getHWbyID(0));
        testList.editDescription(0, "use a calculator");
        assertEquals("use a calculator", testList.getHWbyID(2).getDescription());
    }

    @Test
    public void testRemoveAssignment() {
        Homework hw1 = new Homework(1, "WW3", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        Homework hw2 = new Homework(2, "WW4", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        testList.addAssignment(hw1);
        testList.addAssignment(hw2);
        assertEquals(2, testList.viewNumberUnfinishedAssignments());

        testList.removeAssignment(1);
        testList.removeAssignment(1);
        assertEquals(1, testList.viewNumberUnfinishedAssignments());

        testList.removeAssignment(2);
        assertEquals(0, testList.viewNumberUnfinishedAssignments());
    }

    @Test
    public void testMoveToFinished() {
        Homework hw1 = new Homework(1, "WW3", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        Homework hw2 = new Homework(2, "WW4", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        testList.addAssignment(hw1);
        testList.addAssignment(hw2);
        assertEquals(2, testList.viewNumberUnfinishedAssignments());

        testList.moveToFinished(1, "2024-10-16 00:01");
        assertEquals(1, testList.viewNumberUnfinishedAssignments());
        assertEquals(1, testList.viewNumberFinishedAssignments());
        assertEquals(1, hw1.getDuration());

        testList.moveToFinished(0, "2024-10-16 00:02");
        assertEquals(1, testList.viewNumberUnfinishedAssignments());
        assertEquals(1, testList.viewNumberFinishedAssignments());

        testList.moveToFinished(2, "2024-10-16 00:02");
        assertEquals(0, testList.viewNumberUnfinishedAssignments());
        assertEquals(2, testList.viewNumberFinishedAssignments());
    }

    @Test
    public void testSortFinishedAssignments() {
        Homework hw1 = new Homework(1, "WW3", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        Homework hw2 = new Homework(2, "WW4", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", 
                "2024-10-16 00:00", "");
        testList.addAssignment(hw1);
        testList.addAssignment(hw2);
        testList.moveToFinished(1, "2024-10-16 00:02");
        testList.moveToFinished(2, "2024-10-16 00:01");
        testList.sortFinishedAssignments();
        assertEquals(hw2, testSortedFinishedList.get(0));
    }

    
}
