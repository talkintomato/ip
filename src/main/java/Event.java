import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    private LocalDate on;

    public Event(String description, String on) {
        super(description);
        LocalDate date = LocalDate.parse(on);
        this.on = date;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + on.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
