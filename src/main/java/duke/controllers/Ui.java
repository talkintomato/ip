package duke.controllers;

import duke.tasks.Task;

import java.util.ArrayList;


public class Ui {

    public void showError(String error) {
        System.out.println(error);
    }

    public String showExitMessage() {
        return "Bye. See you later!";
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

    public String help() {
        String helpText = "Main Commands: \n"
                + "\n1. todo <description> ---> Creates a Todo Task"
                + "\n2. deadline <description> /by <date in yyyy-mm-d> ---> Creates a Deadline Task"
                + "\n3. event <description> /on <date in yyyy-mm-d> ---> Creates an Event Task"
                + "\n4. list ---> Shows Task List "
                + "\n5. find <Keyword> ---> Shows tasks with related keyword"
                + "\n6. delete <Index> ---> Removes a task form the Task List"
                + "\n7. mark <Index> ---> Marks task as done"
                + "\n8. bye ---> closes duke";

        return helpText;
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
