package duke.tasks;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    private final static String INITIAL = "D";
    protected LocalDate time;

    public static String getInitial() {
        return INITIAL;
    }

    public String getTime() {return this.time.toString();}

    public String getFormattedTime() {return time.format(DateTimeFormatter.ofPattern("MMM d yyyy"));}

    public Deadline(String done, String description, String time) {
        super(description);
        LocalDate date = LocalDate.parse(time);
        this.time = date;
        if (done.equals("true")) {
            this.done();
        }
    }

    public Deadline(String description, String by) throws DateTimeParseException{
        super(description);
        LocalDate date = LocalDate.parse(by);
        this.time = date;
    }

    @Override
    public String toString() {
        return "[" + getInitial() + "]" + super.toString() + " (by: " + getFormattedTime() + ")";
    }
}
