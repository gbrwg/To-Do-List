package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    private ToDoList testToDoList;

    @BeforeEach
    void runBefore() {
        testToDoList = new ToDoList();
    }

    @Test
    void testConstructor() {
        assertTrue(testToDoList.isEmpty());
    }

    @Test
    void testAddTask() {
        Assignment testAssignment = new Assignment("Test");
        testToDoList.addTask(testAssignment);
        assertEquals(1, testToDoList.length());
        assertTrue(testToDoList.contains(testAssignment));
    }

    @Test
    void testAddMultipleTask() {
        Assignment testAssignment = new Assignment("Test");
        Assignment anotherAssignment = new Assignment("second assignment");
        testToDoList.addTask(testAssignment);
        testToDoList.addTask(anotherAssignment);
        assertEquals(2, testToDoList.length());
        assertTrue(testToDoList.contains(testAssignment));
        assertTrue(testToDoList.contains(anotherAssignment));
    }

    @Test
    void testRemoveTask() {
        Assignment testAssignment = new Assignment("Test");
        Assignment anotherAssignment = new Assignment("second assignment");
        testToDoList.addTask(testAssignment);
        testToDoList.addTask(anotherAssignment);
        testToDoList.removeTask("Test");
        assertEquals(1, testToDoList.length());
        assertTrue(testToDoList.contains(anotherAssignment));
        assertFalse(testToDoList.contains(testAssignment));
    }

    @Test
    void testRemoveMultipleTasks() {
        Assignment testAssignment = new Assignment("Test");
        Assignment anotherAssignment = new Assignment("second assignment");
        Assignment moreAssignment = new Assignment("third assignment");
        testToDoList.addTask(testAssignment);
        testToDoList.addTask(anotherAssignment);
        testToDoList.addTask(moreAssignment);
        testToDoList.removeTask("Test");
        testToDoList.removeTask("second assignment");
        assertTrue(testToDoList.contains(moreAssignment));
        assertFalse(testToDoList.contains(testAssignment));
        assertFalse(testToDoList.contains(anotherAssignment));
    }

    @Test
    void testCheckOffOneToDo() {
        Assignment testAssignment = new Assignment("Test");
        Assignment anotherAssignment = new Assignment("second assignment");
        testToDoList.addTask(testAssignment);
        testToDoList.addTask(anotherAssignment);
        testToDoList.checkOffToDoList("Test");
        assertTrue(testAssignment.getStatus());
        assertFalse(anotherAssignment.getStatus());
    }

    @Test
    void testCheckOffMultipleToDo() {
        Assignment testAssignment = new Assignment("Test");
        Assignment anotherAssignment = new Assignment("second assignment");
        testToDoList.addTask(testAssignment);
        testToDoList.addTask(anotherAssignment);
        testToDoList.checkOffToDoList("Test");
        testToDoList.checkOffToDoList("second assignment");
        assertTrue(testAssignment.getStatus());
        assertTrue(anotherAssignment.getStatus());

    }

    @Test
    void getOneTask() {
        Assignment testAssignment = new Assignment("Test");
        testToDoList.addTask(testAssignment);
        String expected;
        expected = ("Test" + "\n");
        assertEquals(expected, testToDoList.getIncompleteTasks());
    }

    @Test
    void getMultipleTasks() {
        Assignment testAssignment = new Assignment("Test");
        Assignment anotherAssignment = new Assignment("second test");
        testToDoList.addTask(testAssignment);
        testToDoList.addTask(anotherAssignment);
        String expected;
        expected = ("Test" + "\n" + "second test" + "\n");
        assertEquals(expected, testToDoList.getAllTasks());
    }

    @Test
    void getOneFinishedOneUnfinishedTask() {
        Assignment testAssignment = new Assignment("Test");
        Assignment anotherAssignment = new Assignment("second test");
        testToDoList.addTask(testAssignment);
        testToDoList.addTask(anotherAssignment);
        anotherAssignment.markDone();
        String expected;
        expected = ("Test" + "\n" + "second test" + "\n");
        assertEquals(expected, testToDoList.getAllTasks());

    }

    @Test
    void testGetOneIncompleteTask() {
        Assignment testAssignment = new Assignment("Test");
        testToDoList.addTask(testAssignment);
        String expected;
        expected = ("Test" + "\n");
        assertEquals(expected, testToDoList.getIncompleteTasks());

    }

    @Test
    void testGetMultipleIncompleteTasks() {
        Assignment testAssignment = new Assignment("Test");
        Assignment anotherAssignment = new Assignment("second test");
        testToDoList.addTask(testAssignment);
        testToDoList.addTask(anotherAssignment);
        String expected;
        expected = ("Test" + "\n" + "second test" + "\n");
        assertEquals(expected, testToDoList.getIncompleteTasks());

    }

    @Test
    void testGetNotAllIncompleteTasks() {
        Assignment testAssignment = new Assignment("Test");
        Assignment anotherAssignment = new Assignment("second test");
        testToDoList.addTask(testAssignment);
        testToDoList.addTask(anotherAssignment);
        testToDoList.checkOffToDoList("second test");
        String expected;
        expected = ("Test" + "\n");
        assertEquals(expected, testToDoList.getIncompleteTasks());

    }


}

