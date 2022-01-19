public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatus() {
        return (isDone ? "[X] " + this.description : "[ ] " + this.description); // mark done task with X
    }

    public void done() {
        isDone = true;
    }

    public void notDone() {
        isDone = false;
    }
}