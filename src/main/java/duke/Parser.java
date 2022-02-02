package duke;

public class Parser {

    public static Command parseCommand(String cmd) {
        return new Command(cmd.split(" ", 2));
    }

    public static String[] parseHashtable(String cmd) {
        return cmd.split(" " );
    }

}
