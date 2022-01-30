package duke;

import duke.exception.DukeException;
import duke.tasks.Task;
import java.util.ArrayList;
import java.util.Hashtable;


public class TaskList {

    private ArrayList<Task> tasks = new ArrayList<>();
    private Hashtable<String, ArrayList<Task>> keywordHt = new Hashtable<>();

    /**
     * Contructor for TodoList. Loads previous save state.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
        for (Task task : tasks) {
            addTaskToHt(task);
        }
    }

    public TaskList() {}

    /**
     * Adds a Task to the List
     * @param task task that has been created
     */
    public void addTask(Task task) {
        tasks.add(task);
        addTaskToHt(task);
    }

    private void addTaskToHt(Task task) {
        String[] keywords = Parser.parseHashtable(task.getDescription());
        for (String keyword : keywords) {
            if (keywordHt.containsKey(keyword)) {
                ArrayList<Task> valueList = keywordHt.get(keyword);
                valueList.add(task);
            } else {
                ArrayList<Task> valueList = new ArrayList<>();
                valueList.add(task);
                keywordHt.put(keyword, valueList);
            }
        }
    }

    private void removeTaskFromHt(Task task) {
        String[] keywords = Parser.parseHashtable(task.getDescription());
        for (String keyword : keywords) {
            ArrayList<Task> valueList = keywordHt.get(keyword);
            valueList.remove(task);
        }
    }

    public ArrayList<Task> searchKeyword(String keyword) throws DukeException {
        if (keywordHt.containsKey(keyword)) {
            return keywordHt.get(keyword);
        } else {
            throw new DukeException("No Search Results found");
        }
    }


    /**
     * Removes an task form the todosList
     * @param index Index of task in the list
     * @throws DukeException
     */
    public void removeTask(String index) throws DukeException {

        if (Integer.parseInt(index) - 1 < tasks.size()) {
            Task task = tasks.remove(Integer.parseInt(index) - 1);
            removeTaskFromHt(task);
            System.out.println("Noted. I've removed this task: \n" + task + " you now have "
                    + tasks.size() + " tasks in the list.");
        } else {
            throw new DukeException("Index out of range!!");
        }
    }

    /**
     * gets all tasks in the todosList
     */
    public ArrayList<Task> getList() {
        return tasks;
    }

    //TODO throw exception for out of index
    /**
     * Mark a task on the list as completed
     * @param index Index of Task to be unmarked as completed
     */
    public void mark(String index) {
        Task task = tasks.get(Integer.parseInt(index) - 1);
        if (task.getIsDone()) {
            System.out.println("Task already completed!");
        } else {
            task.done();
            System.out.println("Nice! I've marked this task as done:\n" + task);
        }
    }

    //TODO throw exception for out of index
    /**
     * unmark a task on the list as completed
     * @param index Index of Task to be unmarked
     */
    public void unmark(String index) {
        Task task = tasks.get(Integer.parseInt(index) - 1);
        if (!task.getIsDone()) {
            System.out.println("Task not yet completed!");
        } else {
            task.notDone();
            System.out.println("Oh no! one more thing that needs to be done:\n" + task);
        }
    }

}
