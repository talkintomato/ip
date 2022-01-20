public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public String getStatus() {
        return (isDone ? "[X] " + this.description : "[ ] " + this.description); // mark done task with X}
    }

    @Override
    public String toString() {
        return "[T]" + super.toString() ;
    }
}
