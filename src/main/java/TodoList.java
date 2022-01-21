import java.util.ArrayList;


public class TodoList {
    protected ArrayList<Task> todo = new ArrayList<Task>();

    public void addList(Task task) {
        todo.add(task);
        System.out.println("Added: " + task.description);
    }

    public void removeList(String index) throws DukeException {
        Task task = todo.remove(Integer.parseInt(index));
        System.out.println("Noted. I've removed this task: \n" + task + " you now have " + todo.size() + " tasks in the list.");
    }

    public void printList() {
        if (todo.size() == 0) {
            System.out.println("There are no items in your Todo List!");
        }
        for (int i = 0; i < todo.size(); i++ ) {
            Task task = todo.get(i);
            System.out.println(task);
        }
    }

    public void mark(String index) {
        Task task = todo.get(Integer.parseInt(index));
        if (task.isDone) {
            System.out.println("Task already completed!");
        } else {
            task.done();
            System.out.println("Nice! I've marked this task as done: \n" + task);
        }
    }

    public void unmark(String index) {
        Task task = todo.get(Integer.parseInt(index));
        if (!task.isDone) {
            System.out.println("Task not yet completed!");
        } else {
            task.notDone();
            System.out.println("Oh no! one more thing that needs to be done: \n" + task);
        }
    }
}
