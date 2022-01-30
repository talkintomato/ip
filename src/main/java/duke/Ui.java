package duke;
import duke.tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    public void launch() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo + "\nwhat is your command?");
    }

    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();

        return cmd;
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

    public void showTaskAdded(Task task) {System.out.println("Added: " + task.getDescription());}

    public void showSearchResults(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void printList(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("There are no items in your Todo List!");
        }
        for (int i = 0; i < tasks.size(); i = i + 1) {
            System.out.println(String.valueOf(i + 1)+ ". " + tasks.get(i));
        }
    }

}
