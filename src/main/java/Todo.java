public class Todo extends Task {


    private String initial  = "T";

    public Todo(String description) {
        super(description);
    }

    public Todo(String done, String description) {
        super(description);
        if (done.equals("true")) {
            this.done();
        }
    }

    public String getInitial() {
        return initial;
    }

    public String getTime() {return null;}

    public String getStatus() {
        return (isDone ? "[X] " + this.description : "[ ] " + this.description); // mark done task with X}
    }

    @Override
    public String toString() {
        return "[" + initial + "]" + super.toString() ;
    }
}
