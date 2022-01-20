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
            findCmd(cmd.split(" "));
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
            default:
                String[] refactor = String.join(" ", cmd).split("/", 2);
                Task task = Task.createTask(refactor);
                todoList.addList(task);
        }
    }
}