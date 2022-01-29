package duke;

import duke.exception.DukeException;
import duke.tasks.Task;
import java.util.ArrayList;


public class TaskList {
    protected ArrayList<Task> todos = new ArrayList<>();

    /**
     * Contructor for TodoList. Loads previous save state.
     */
    public TaskList(ArrayList<Task> todos) {
        this.todos = todos;
    }

    public TaskList() {}

    /**
     * Adds a Task to the List
     * @param task task that has been created
     */
    public void addList(Task task) {
        todos.add(task);
        System.out.println("Added: " + task.getDescription());
    }


    /**
     * Removes an task form the todosList
     * @param index Index of task in the list
     * @throws DukeException
     */
    public void removeList(String index) throws DukeException {
        if (Integer.parseInt(index) < todos.size()) {
            Task task = todos.remove(Integer.parseInt(index));
            System.out.println("Noted. I've removed this task: \n" + task + " you now have " + todos.size() + " tasks in the list.");
        } else {
            throw new DukeException("Index out of range!!");
        }
    }

    /**
     * Prints all tasks in the todosList
     */
    public void printList() {
        if (todos.size() == 0) {
            System.out.println("There are no items in your Todo List!");
        }
        for (int i = 0; i < todos.size(); i++ ) {
            Task task = todos.get(i);
            System.out.println(task);
        }
    }

    /**
     * Mark a task on the list as completed
     * @param index Index of Task to be unmarked as completed
     */
    public void mark(String index) {
        Task task = todos.get(Integer.parseInt(index));
        if (task.getIsDone()) {
            System.out.println("Task already completed!");
        } else {
            task.done();
            System.out.println("Nice! I've marked this task as done:\n" + task);
        }
    }

    /**
     * unmark a task on the list as completed
     * @param index Index of Task to be unmarked
     */
    public void unmark(String index) {
        Task task = todos.get(Integer.parseInt(index));
        if (!task.getIsDone()) {
            System.out.println("Task not yet completed!");
        } else {
            task.notDone();
            System.out.println("Oh no! one more thing that needs to be done:\n" + task);
        }
    }

}
