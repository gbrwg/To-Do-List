package model;

import java.util.LinkedList;


// Represents a list of assignments
// removeTask method implemented from link below
// https://www.baeldung.com/java-concurrentmodificationexception
// getIncompleteTasks and getAllTasks method implemented from link below
// https://stackoverflow.com/questions/27816933/how-to-access-object-list-elements-in-java/27817269

public class ToDoList {

    private LinkedList<Assignment> toDoList;

    // EFFECTS: creates a to do list that is empty
    public ToDoList() {
        toDoList = new LinkedList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a task to the end of the queue
    public void addTask(Assignment t) {
        toDoList.add(t);
    }

    // REQUIRES: a non-empty to do list, with unique task names
    // MODIFIES: this
    // EFFECTS: Removes the task given its name
    public void removeTask(String name) {
        LinkedList<Assignment> toRemove = new LinkedList<>();
        for (Assignment item : toDoList) {
            if (name.equals(item.getName())) {
                toRemove.add(item);
            }
        }
        toDoList.removeAll(toRemove);
    }


    // MODIFIES: item
    // EFFECTS: marks a task as done in the to do list
    public void checkOffToDoList(String name) {
        for (Assignment item : toDoList) {
            if (name.equals(item.getName())) {
                item.markDone();
            }
        }
    }

    // REQUIRES: a non-empty to do list
    // EFFECTS: prints all incomplete tasks in to-do list
    public String getIncompleteTasks() {
        StringBuilder s = new StringBuilder();
        for (Assignment item : toDoList) {
            if (!item.getStatus()) {
                s.append(item.getName()).append("\n");
            }
        }
        return s.toString();
    }

    // REQUIRES: a non-empty to do list
    // EFFECTS: prints all incomplete tasks in to-do list
    public String getAllTasks() {
        StringBuilder s = new StringBuilder();
        for (Assignment item : toDoList) {
            s.append(item.getName()).append("\n");
        }
        return s.toString();
    }

    public boolean isEmpty() {
        return toDoList.isEmpty(); //stub
    }

    public int length() {
        return toDoList.size(); //stub
    }

    public boolean contains(Assignment assignment) {
        return toDoList.contains(assignment);
    }

}



