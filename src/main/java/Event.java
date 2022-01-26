public class Event extends Task{
    protected String time;

    private String initial  = "E";

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    public String getInitial() {
        return initial;
    }

    public String getTime() {return this.time;}


    public Event(String done, String description, String time) {
        super(description);
        this.time = time;
        if (done.equals("true")) {
            this.done();
        }
    }


    @Override
    public String toString() {
        return "[" + initial + "]" + super.toString() + " (at: " + time + ")";
    }
}
