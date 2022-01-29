import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    protected ArrayList<Task> todos = new ArrayList<>();
    private String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
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

    public ArrayList<Task> load() {
        return todos;
    }

    /**
     * save a task to the drive
     */
    public void saveList() {
        try {
            FileWriter myWriter = new FileWriter(filepath);
            for (int i = 0; i < todos.size(); i = i + 1) {
                Task currTask = todos.get(i);
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
