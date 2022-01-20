abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return (isDone ? "[X] " + this.description : "[ ] " + this.description);
    }

    public void done() {
        isDone = true;
    }

    public void notDone() {
        isDone = false;
    }

    public static Task createTask(String[] description) {

        if (description.length == 1) {
            return new Todo(description[0]);
        } else if (description[1].substring(0,3).equals("by ")) {
            return new Deadline(description[0], description[1]);
        } else if (description[1].substring(0,3).equals("at ")) {
            return new Event(description[0], description[1]);
        } else {
            //TODO: throw error
            System.out.println("invalid tasking input");
            return null;
        }
    }
}