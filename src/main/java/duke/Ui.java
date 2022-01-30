package duke;

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
}
