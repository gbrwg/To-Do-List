package ui;

import model.Assignment;
import model.ToDoList;

import java.util.Scanner;

// Planner application
// UI Functionality and methods are implemented from Teller App.
public class PlannerApp {
    private ToDoList list;
    private Scanner input;

    // EFFECTS: run the teller application
    public PlannerApp() {
        runPlanner();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runPlanner() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nHave a great day!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("1")) {
            addAssignment();
        } else if (command.equals("2")) {
            removeAssignment();
        } else if (command.equals("3")) {
            markAssignmentComplete();
        } else if (command.equals("4")) {
            getUnfinishedAssignments();
        } else {
            System.out.println("Invalid selection, try again.");
        }
    }

    // MODIFIES: this
    // initializes a list
    private void init() {
        list = new ToDoList();
        input = new Scanner(System.in);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\t1 -> Add an assignment");
        System.out.println("\t2 -> Remove an assignment");
        System.out.println("\t3 -> Mark an assignment finished");
        System.out.println("\t4 -> Show all unfinished assignments");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: prints list of unfinished tasks to the screen
    //          then marks assignment complete according to the users input
    private void markAssignmentComplete() {
        System.out.println("Which assignment would you like to mark as complete? \n");
        System.out.println(list.getIncompleteTasks());
        if (list.getIncompleteTasks().contains(input.next())) {
            list.checkOffToDoList(input.next());
            System.out.println("Assignment marked as completed. \n");
        } else {
            System.out.println("This assignment does not exist, try again.");
        }
    }


    // EFFECTS: prints list of unfinished items to the screen
    private void getUnfinishedAssignments() {
        System.out.println(list.getIncompleteTasks());
    }

    // MODIFIES: this
    // EFFECTS: prints list of all tasks, removes an assignment from the list from user input
    private void removeAssignment() {
        System.out.println("Which assignment would you like to remove? \n");
        System.out.println(list.getAllTasks());
        if (list.getAllTasks().contains(input.next())) {
            list.removeTask(input.next());
            System.out.println("Assignment removed \n");
        } else {
            System.out.println("This assignment does not exist, try again.");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a new task to the to-do list
    private void addAssignment() {
        System.out.println("Name assignment: ");
        Assignment task = new Assignment(input.next());
        list.addTask(task);
        System.out.println("Assignment added \n");
    }


}

