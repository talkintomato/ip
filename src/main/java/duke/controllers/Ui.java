package duke.controllers;

import duke.tasks.Task;

import java.util.ArrayList;


public class Ui {

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    private String getResponse(String input) {
        return "Duke heard: " + input;
    }

    public void showLine() {
        System.out.println("_______________");
    }

    public void showError(String error) {
        System.out.println(error);
    }

    public void showExitMessage() {
        System.out.println("Bye. See you later!");
    }

    public String showTaskAdded(Task task) {return "Added: " + task.getDescription();}

    public String showTaskRemoved(Task task) {
        return "Noted. I've removed this task: \n" + task;
    }

    public void showSearchResults(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public String printList(ArrayList<Task> tasks) {
        String response = "";
        if (tasks.size() == 0) {
            response = "There are no items in your Todo List!";
        }
        for (Task task : tasks) {
            response = response + task + "\n";
        }
        return response;
    }

}
