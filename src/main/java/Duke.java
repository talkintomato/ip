import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo + "\n what is your command?");

        while (true) {
            Scanner sc = new Scanner(System.in);
            String cmd = sc.nextLine();
            findCmd(cmd.split(" ", 2));
        }
    }

    private static void findCmd(String[] cmd) {
        switch(cmd[0]) {
            case "list" :
                todoList.printList();
                break;
            case "mark" :
                todoList.mark(cmd[1]);
                break;
            case "unmark" :
                todoList.unmark(cmd[1]);
                break;
            case "blah" :
                System.out.println("blah");
                break;
            case "bye" :
                System.out.println("Bye. See you later! ");
                System.exit(0);
            case "todo":
                Todo todo = new Todo(cmd[1]);
                todoList.addList(todo);
                break;
            case "deadline":
                String[] deadlineDetails =  cmd[1].split("/", 2);
                Deadline deadline = new Deadline(deadlineDetails[0], deadlineDetails[1]);
                todoList.addList(deadline);
                break;
            case "event":
                String[] EventDetails =  cmd[1].split("/", 2);
                Event event = new Event(EventDetails[0], EventDetails[1]);
                todoList.addList(event);
                break;
            default:
                System.out.println("Invalid Input! ");
        }
    }
}