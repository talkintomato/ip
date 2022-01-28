import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task{

    private LocalDate time;
    private String initial  = "E";

    public Event(String description, String time) {
        super(description);
        LocalDate date = LocalDate.parse(time);
        this.time = date;
    }

    public String getInitial() {
        return initial;
    }

    public String getTime() {return this.time.toString();}

    public String getFormattedTime() {return time.format(DateTimeFormatter.ofPattern("MMM d yyyy"));}



    public Event(String done, String description, String time) {
        super(description);
        LocalDate date = LocalDate.parse(time);
        this.time = date;
        if (done.equals("true")) {
            this.done();
        }
    }

    @Override
    public String toString() {
        return "[" + initial + "]" + super.toString() + " (at: " + getFormattedTime() + ")";
    }

}
