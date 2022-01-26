public class Deadline extends Task {

    private String initial = "D";
    protected String time;

    public Deadline(String description, String time) {
        super(description);
        this.time = time;
    }

    public String getInitial() {
        return initial;
    }

    public String getTime() {return this.time;}


    public Deadline(String done, String description, String time) {
        super(description);
        this.time = time;
        if (done.equals("true")) {
            this.done();
        }
    }

    @Override
    public String toString() {
        return "[" + initial + "]" + super.toString() + " (by: " + time + ")";
    }
}
