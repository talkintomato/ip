import java.time.format.DateTimeParseException;
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
        System.out.println("Hello from\n" + logo + "\nwhat is your command?");
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String cmd = sc.nextLine();
            try {
                findCmd(cmd.split(" ", 2));
            } catch (DukeException ex) {
                System.out.println("☹ OOPS!!! " + ex);
            }
        }
    }

    private static void findCmd(String[] cmd) throws DukeException{
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
            //Event creation
            case "todo":
                createTodo(cmd);
                break;
            case "deadline":
                createDeadline(cmd);
                break;
            case "event":
                createEvent(cmd);
                break;
            case "delete":
                todoList.removeList(cmd[1]);
                break;
            case "bye" :
                System.out.println("Bye. See you later!");
                System.exit(0);
            default:
                throw new DukeException("I'm not sure what that means :((");
        }
    }

    private static void createTodo(String[] cmd) throws DukeException {
        if (cmd.length == 2) {
            Todo todo = new Todo(cmd[1]);
            todoList.addList(todo);
        } else {
            throw new DukeException("The description of a todo cannot be empty.");
        }
    }

    private static void createDeadline(String[] cmd) throws DukeException {
        if (cmd.length == 2) {
            String[] deadlineDetails = cmd[1].split(" /by ", 2);
            if (deadlineDetails.length == 2) {
                try {
                    Deadline deadline = new Deadline(deadlineDetails[0], deadlineDetails[1]);
                    todoList.addList(deadline);
                } catch (DateTimeParseException e) {
                    System.out.println(e.getMessage() + "\nPlease input deadline in yyyy-mm-dd");
                }
            } else {
                throw new DukeException("Please indicate a time for the Deadline!");
            }
        } else {
            throw new DukeException("The description of a Deadline date cannot be empty.");
        }
    }

    private static void createEvent(String[] cmd) throws DukeException {
        if (cmd.length == 2) {
            String[] EventDetails = cmd[1].split(" /at ", 2);
            if (EventDetails.length == 2) {
                try {
                    Event event = new Event(EventDetails[0], EventDetails[1]);
                    todoList.addList(event);
                } catch (DateTimeParseException e) {
                    System.out.println(e.getMessage() + "\nPlease input Event date in yyyy-mm-dd");
                }
            } else {
                throw new DukeException("Please indicate a time for the Event!");
            }
        } else {
            throw new DukeException("The description of a Event cannot be empty.");
        }
    }
}