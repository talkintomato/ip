import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<String> todo = new ArrayList<String>();

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo + "\n what is your command?");

        while (true) {
            Scanner scn = new Scanner(System.in);
            String cmd = scn.nextLine();
            findCmd(cmd);
        }
    }

    private static void findCmd(String cmd) {
        switch(cmd) {
            case "list" :
                printList();
                break;
            case "blah" :
                System.out.println("blah");
                break;
            case "bye" :
                System.out.println("Bye. See you later! ");
                System.exit(0);
            default:
                addList(cmd);
        }
    }

    private static void addList(String item) {
        todo.add(item);
        System.out.println("Added: " + item);
    }

    private static void printList() {
        for (int i = 1; i < todo.size() + 1; i++ ) {
            System.out.println(i + ". " + todo.get(i - 1));
        }
    }
}