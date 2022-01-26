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

    public static Task createTask(String[] description) throws DukeException{
        switch (description[0]) {
            case "T":
                return new Todo(description[1], description[2]);
            case "E":
                return new Event(description[1], description[2], description[3]);
            case "D":
                return new Deadline(description[1], description[2], description[3]);
            default:
                throw new DukeException("Invalid Task");
        }

//        if (description.length == 1) {
//            return new Todo(description[0]);
//        } else if (description[1].substring(0,3).equals("by ")) {
//            return new Deadline(description[0], description[1]);
//        } else if (description[1].substring(0,3).equals("at ")) {
//            return new Event(description[0], description[1]);
//        } else {
//            //TODO: throw error
//            System.out.println("invalid tasking input");
//            return null;
//        }
    }

    abstract public String getTime();

    public Boolean getIsDone() {return this.isDone;}

    public String getDescription() {return this.description;}

    abstract public String getInitial();
}