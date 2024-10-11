package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class UnfinishedAssignmentsTest {

    private UnfinishedAssignments testList;

    @Before
    public void setUp() {
        testList = new UnfinishedAssignments();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testList.viewNumberUnfinishedAssignments());
    }

    @Test
    public void testAddAssignments() {
        Homework hw1 = new Homework(1, "WW3", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", "2024-10-16 00:00", "");
        Homework hw2 = new Homework(1, "WW4", "MATH 200", AsmType.ShortQuestions, "2024-10-20 12:34", "2024-10-16 00:00", "");
        
        testList.addAssignment(hw1);
        assertEquals(1, testList.viewNumberUnfinishedAssignments());

        testList.addAssignment(hw2);
        assertEquals(2, testList.viewNumberUnfinishedAssignments());
    }



}
