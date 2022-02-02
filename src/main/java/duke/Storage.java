package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import duke.exception.DukeException;
import duke.tasks.*;

public class Storage {

    private ArrayList<Task> todos = new ArrayList<>();
    private String filePath;

    /**
     * Constructor for Storage.
     *
     * @param filepath the path of the file to be written to and loaded from
     */
    public Storage(String filepath) {
        this.filePath = filepath;
        try {
            File savedFile = new File(filepath);
            Scanner scanner = new Scanner(savedFile);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] taskData = data.split(" , ");
                Task task = Task.createTask(taskData);
                todos.add(task);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No previous save state");
        } catch (DukeException e) {
            System.out.println("Data corrupted");
        }
    }

    /**
     * Loaded the Task List from the saved file.
     * @return the Task List from the saved file
     */
    public ArrayList<Task> load() {
        return todos;
    }

    /**
     * Save the current List to a file.
     */
    public void saveList() {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            for (int i = 0; i < todos.size(); i = i + 1) {
                Task currTask = todos.get(i);
                if (currTask instanceof Todo) {
                    Todo currTodo = (Todo) currTask;
                    myWriter.write(currTodo.getInitial() + " , "
                            + currTodo.getIsDone() + " , " + currTodo.getDescription()
                            + " , " + currTodo.getTime() + "\n");
                } else if (currTask instanceof Event) {
                    Event currEvent = (Event) currTask;
                    myWriter.write(currEvent.getInitial() + " , "
                            + currEvent.getIsDone() + " , " + currEvent.getDescription()
                            + " , " + currEvent.getTime() + "\n");
                } else if (currTask instanceof Deadline) {
                    Deadline currDeadline = (Deadline) currTask;
                    myWriter.write(currDeadline.getInitial() + " , "
                            + currDeadline.getIsDone() + " , " + currDeadline.getDescription()
                            + " , " + currDeadline.getTime() + "\n");
                } else {
                    throw new DukeException("Unknown Task");
                }
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
