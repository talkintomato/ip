import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    private String initial = "D";
    protected LocalDate time;

    public String getInitial() {
        return initial;
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
        return "[" + initial + "]" + super.toString() + " (by: " + getFormattedTime() + ")";
    }
}
