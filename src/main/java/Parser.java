import java.time.format.DateTimeParseException;

public class Parser {
    public static Command parse(String cmd) {
        return new Command(cmd.split(" ", 2));
    }

}
