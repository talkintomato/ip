package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import duke.exception.DukeException;
import duke.tasks.*;

//Solution below adapted from https://github.com/lamwj98/ip/blob/master/src/main/java/siri/Storage.java

public class Storage {
    private File directory;
    private File dataFile;
    protected ArrayList<Task> todos = new ArrayList<>();
    private String fileDirectoryPath;
    private String filePath;


    /**
     * Constructor of Storage class.
     *
     * @param filePath string representation of the file path to allow loading from the file.
     * If file doesn't exist, file will be created based on the path provided.
     * If empty String is provided, cwd will create a data folder and a data.txt file inside to be saved.
     */
    public Storage(String filePath) {

        if (filePath == "") {
            this.filePath = System.getProperty("user.home") + "/dukeData/data.txt";
        } else {
            this.filePath = filePath;
        }
        this.fileDirectoryPath = this.filePath.substring(0, filePath.lastIndexOf('/'));
        this.directory = new File(fileDirectoryPath);
        this.dataFile = new File(filePath);
    }

    /**
     * Loads the file data (if there is a valid data file).
     *
     * @return String representation of the data being loaded.
     * @throws DukeException if file doesn't exist, directory doesn't exist, or when file consist no data.
     */
    public ArrayList<Task> load() throws DukeException {


        if (dataFile.exists() == false) {
            throw new DukeException("File does not exist!");
        }

        if (directory.exists() == false) {
            directory.mkdir();
            throw new DukeException("Directory and file does not exist!");
        }

        try {
            Scanner sc = new Scanner(dataFile);

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] taskData = data.split(" , ");
                Task task = Task.createTask(taskData);
                todos.add(task);
            }

            sc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return todos;

    }

    /**
     * Saves data passed into the destination as stated when Storage instance is being initialised.
     */
    public void saveList(ArrayList<Task> todoNew) {
        todos = todoNew;
        try {
            if (dataFile.exists() == true) {
                dataFile.delete();
            }
            dataFile.createNewFile();
        } catch (IOException ioe) {
            System.out.println("Error creating data file!");
            System.out.println(ioe.getMessage());
        }

        try {
            FileWriter myWriter = new FileWriter(dataFile);
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

