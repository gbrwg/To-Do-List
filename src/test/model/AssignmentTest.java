package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    private Assignment testAssignment;

    @BeforeEach
    void runBefore() {
        testAssignment = new Assignment("Test Project");
    }

    @Test
    void testConstructor() {
        assertFalse(testAssignment.getStatus());
        assertEquals("Test Project", testAssignment.getTaskName());
    }

    @Test
    void testGetName() {
        assertEquals("Test Project", testAssignment.getName());
    }

    @Test
    void testMarkDone() {
        assertFalse(testAssignment.getStatus());
        testAssignment.markDone();
        assertTrue(testAssignment.getStatus());
    }

    @Test
    void testMarkIncomplete() {
        assertFalse(testAssignment.getStatus());
        testAssignment.markDone();
        assertTrue(testAssignment.getStatus());
        testAssignment.markIncomplete();
        assertFalse(testAssignment.getStatus());
    }

}