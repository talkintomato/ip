package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import duke.exception.DukeException;
import duke.tasks.*;

//Solution below adapted from https://github.com/lamwj98/ip/blob/master/src/main/java/siri/Storage.java

public class Storage {

    protected ArrayList<Task> todos = new ArrayList<>();
    private String filePath;


    /**
     * Constructor of Storage class.
     *
     * @param filePath string representation of the file path to allow loading from the file.
     * If file doesn't exist, file will be created based on the path provided.
     * If empty String is provided, cwd will create a data folder and a data.txt file inside to be saved.
     */
    public Storage(String filePath) {
        assert(filePath != null && !filePath.equals(""));
        this.filePath = filePath;
    }

    /**
     * Loads the file data (if there is a valid data file).
     *
     * @return ArrayList of Tasks from data being loaded.
     * @throws DukeException if file doesn't exist, directory doesn't exist, or when file consist no data.
     */
    public ArrayList<Task> load() throws DukeException {

        try {
            File directory = new File("data");
            if (directory.mkdirs()) {
                System.out.println("Created new directory /data");
            }
            File taskTextFile = new File("data/task.txt");
            if (taskTextFile.createNewFile()) {
                System.out.println("Created text file as /data/task.txt");
            }
            Scanner sc = new Scanner(Paths.get("data/task.txt")); // create a Scanner using the File as the source

            ArrayList<Task> todos = new ArrayList<Task>();

            while (sc.hasNext()) {
                String data = sc.nextLine();
                String[] taskData = data.split(" , ");
                Task task = Task.createTask(taskData);
                todos.add(task);
            }
            return todos;
        } catch (IOException e) {
            throw new DukeException(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException(e.getMessage());
        }

    }

    /**
     * Saves TaskList passed into the destination.
     */
    public void saveList(ArrayList<Task> todoNew) {
        todos = todoNew;

        try {
            FileWriter myWriter = new FileWriter("data/task.txt");
            for (int i = 0; i < todos.size(); i = i + 1) {
                Task currTask = todos.get(i);
                if (currTask instanceof Todo) {
                    Todo currTodo = (Todo) currTask;
                    myWriter.write(currTodo.getInitial() + " , " + currTodo.getIsDone() + " , "
                            + currTodo.getDescription() + " , " + currTodo.getTime() +"\n");
                }
                else if (currTask instanceof Event) {
                    Event currEvent = (Event) currTask;
                    myWriter.write(currEvent.getInitial() + " , " + currEvent.getIsDone() + " , "
                            + currEvent.getDescription() + " , " + currEvent.getTime() +"\n");
                }
                else if (currTask instanceof Deadline) {
                    Deadline currDeadline = (Deadline) currTask;
                    myWriter.write(currDeadline.getInitial() + " , " + currDeadline.getIsDone() + " , "
                            + currDeadline.getDescription() + " , " + currDeadline.getTime() +"\n");
                }
                else System.out.println("unknown data");
            }
            myWriter.close();
        } catch (IOException ioe) {
            System.out.println("Error writing to file!");
        }
    }

}

