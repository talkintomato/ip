package duke;
import duke.tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a Ui which deals with interactions with the user.
 */
public class Ui {

    private Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Shows the greeting message to user.
     */
    public void launch() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo + "\nwhat is your command?");
    }

    /**
     * Reads user input
     * @return the string input of the user
     */
    public String readCommand() {
        String cmd = this.sc.nextLine();
        return cmd;
    }

    /**
     * Shows line break.
     */
    public static void showLine() {
        System.out.println("_______________");
    }

    /**
     * Shows the error message to user.
     * @param error message to be printed
     */
    public static void showError(String error) {
        System.out.println(error);
    }

    /**
     * Shows the exit message to user.
     */
    public static void showExitMessage() {
        System.out.println("Bye. See you later!");
    }

    /**
     * Shows the task added to user.
     * @param task Shows the task which was added
     */
    public static void showTaskAdded(Task task) {
        System.out.println("Added: " + task.getDescription());
    }

    /**
     * Shows the user's search results.
     * @param tasks the list of tasks to be displayed
     */
    public static void showSearchResults(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    /**
     * Shows the list of tasks to user.
     * @param tasks the list of tasks to be displayed
     */
    public static void printList(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("There are no items in your Todo List!");
        }
        for (int i = 0; i < tasks.size(); i = i + 1) {
            System.out.println(String.valueOf(i + 1) + ". " + tasks.get(i));
        }
    }

}
