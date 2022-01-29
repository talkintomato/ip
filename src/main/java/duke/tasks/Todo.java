package duke.tasks;

public class Todo extends Task {


    private final static String INITIAL  = "T";

    public Todo(String description) {
        super(description);
    }

    public Todo(String isDone, String description) {
        super(description);
        if (isDone.equals("true")) {
            this.done();
        }
    }

    public static String getInitial() {
        return INITIAL;
    }

    public String getTime() {return null;}

    public String getStatus() {
        return (isDone ? "[X] " + this.description : "[ ] " + this.description); // mark done task with X}
    }

    @Override
    public String toString() {
        return "[" + getInitial() + "]" + super.toString() ;
    }
}
