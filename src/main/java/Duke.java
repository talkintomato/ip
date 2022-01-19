import java.util.Scanner;

public class Duke {
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
                System.out.println("list");
                break;
            case "blah" :
                System.out.println("blah");
                break;
            case "bye" :
                System.out.println("Bye. See you later! ");
                System.exit(0);
            default:
                System.out.println("Invalid Command! ");
        }
    }
}