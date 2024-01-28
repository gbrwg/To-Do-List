package model;

// Represents an assignment with a task name, and a finished/unfinished status
public class Assignment {
    private String task;
    private boolean isCompleted;


    // REQUIRES: taskName has a non-zero length
    // EFFECTS: create an assignment with its name and a unfinished status
    public Assignment(String taskName) {
        this.task = taskName;
        isCompleted = false;
    }

    public String getName() {
        return task;
    }

    // MODIFIES: this
    // EFFECTS: marks an assignment as completed
    public void markDone() {
        isCompleted = true;
    }

    // REQUIRES: isCompleted = true
    // MODIFIES: this
    // EFFECTS: marks an assignment as incomplete
    public void markIncomplete() {
        isCompleted = false;
    }

    public boolean getStatus() {
        return isCompleted;
    }

    public String getTaskName() {
        return task;
    }
}
