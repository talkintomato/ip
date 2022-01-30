package duke;

public class Parser {

    public static Command commandParse(String cmd) {
        return new Command(cmd.split(" ", 2));
    }

    public static String[] hashtableParse(String cmd) {
        return cmd.split(" " );
    }

}
