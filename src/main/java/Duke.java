import java.util.Scanner;

public class Duke {
    private static Todo todo = new Todo();

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
            findCmd(cmd);
        }
    }

    private static void findCmd(String cmd) {
        switch(cmd) {
            case "list" :
                todo.printList();
                break;
            case "mark" :
                todo.mark();
                break;
            case "unmark" :
                todo.unmark();
                break;
            case "blah" :
                System.out.println("blah");
                break;
            case "bye" :
                System.out.println("Bye. See you later! ");
                System.exit(0);
            default:
                Task task = new Task(cmd);
                todo.addList(task);
        }
    }
}