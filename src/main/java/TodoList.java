import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class TodoList {
    protected ArrayList<Task> todo = new ArrayList<>();


    /**
     * Contructor for TodoList. Loads previous save state.
     */
    public TodoList() {
        try {
            File myObj = new File("src/data/duke.txt");
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] taskData = data.split(" , ");
                Task task = Task.createTask(taskData);
                todo.add(task);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No previous save state");
        } catch (DukeException e) {
            System.out.println("Data corrupted");
        }
    }

    /**
     * Adds a Task to the List
     * @param task task that has been created
     */
    public void addList(Task task) {
        todo.add(task);
        this.saveList();
        System.out.println("Added: " + task.description);
    }


    /**
     * Removes an task form the todoList
     * @param index Index of task in the list
     * @throws DukeException
     */
    public void removeList(String index) throws DukeException {
        if (Integer.parseInt(index) < todo.size()) {
            Task task = todo.remove(Integer.parseInt(index));
            this.saveList();
            System.out.println("Noted. I've removed this task: \n" + task + " you now have " + todo.size() + " tasks in the list.");
        } else {
            throw new DukeException("Index out of range!!");
        }
    }

    /**
     * Prints all tasks in the todoList
     */
    public void printList() {
        if (todo.size() == 0) {
            System.out.println("There are no items in your Todo List!");
        }
        for (int i = 0; i < todo.size(); i++ ) {
            Task task = todo.get(i);
            System.out.println(task);
        }
    }

    /**
     * Mark a task on the list as completed
     * @param index Index of Task to be unmarked as completed
     */
    public void mark(String index) {
        Task task = todo.get(Integer.parseInt(index));
        if (task.isDone) {
            System.out.println("Task already completed!");
        } else {
            task.done();
            System.out.println("Nice! I've marked this task as done:\n" + task);
            saveList();
        }
    }

    /**
     * unmark a task on the list as completed
     * @param index Index of Task to be unmarked
     */
    public void unmark(String index) {
        Task task = todo.get(Integer.parseInt(index));
        if (!task.isDone) {
            System.out.println("Task not yet completed!");
        } else {
            task.notDone();
            System.out.println("Oh no! one more thing that needs to be done:\n" + task);
            saveList();
        }
    }

    /**
     * save a task to the drive
     */
    private void saveList() {
        try {
            FileWriter myWriter = new FileWriter("./src/data/duke.txt");
            for (int i = 0; i < todo.size(); i = i + 1) {
                Task currTask = todo.get(i);
                if (currTask instanceof Todo) {
                    Todo currTodo = (Todo) currTask;
                    myWriter.write(currTodo.getInitial() + " , " + currTodo.getIsDone() + " , " + currTodo.getDescription() + " , " + currTodo.getTime() +"\n");
                }
                else if (currTask instanceof Event) {
                    Event currEvent = (Event) currTask;
                    myWriter.write(currEvent.getInitial() + " , " + currEvent.getIsDone() + " , " + currEvent.getDescription() + " , " + currEvent.getTime() +"\n");
                }
                else if (currTask instanceof Deadline) {
                    Deadline currDeadline = (Deadline) currTask;
                    myWriter.write(currDeadline.getInitial() + " , " + currDeadline.getIsDone() + " , " + currDeadline.getDescription() + " , " + currDeadline.getTime() +"\n");
                }
                else throw new DukeException("Unknown Task");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (DukeException e) {
            System.out.println(e);
        }
    }
}
