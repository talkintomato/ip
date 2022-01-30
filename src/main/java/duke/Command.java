package duke;
import duke.exception.DukeException;
import duke.tasks.*;

import java.time.format.DateTimeParseException;


public class Command {

    private String[] cmd;

    private boolean isExit = false;

    public Command(String[] cmd) {
        this.cmd = cmd;
    }

    /**
     * Determines the Nature of the command to be executed
     * @param taskList the TaskList which is active
     * @param ui the user interface
     * @param storage The object used to write and save state of Tasklist
     * @throws DukeException
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        switch(cmd[0]) {
            case "list" :
                taskList.printList();
                break;
            case "mark" :
                taskList.mark(cmd[1]);
                break;
            case "unmark" :
                taskList.unmark(cmd[1]);
                break;
            //Event creation
            case "todo":
                createTodo(cmd, taskList);
                break;
            case "deadline":
                createDeadline(cmd, taskList);
                break;
            case "event":
                createEvent(cmd, taskList);
                break;
            case "delete":
                taskList.removeTask(cmd[1]);
                break;
            case "bye" :
                isExit = true;
                break;
            default:
                throw new DukeException("I'm not sure what that means :((");
        }
        storage.saveList();
    }

    public boolean getExitStatus() {
        return isExit;
    }

    /**
     * Creates a todo and adds it to TaskList
     * @param cmd The parameters of the todo to be created
     * @param taskList the TaskList which is active
     * @throws DukeException
     */
    private void createTodo(String[] cmd, TaskList taskList) throws DukeException {
        if (cmd.length == 2) {
            Todo todo = new Todo(cmd[1]);
            taskList.addTask(todo);
        } else {
            throw new DukeException("The description of a todo cannot be empty.");
        }
    }

    /**
     * Creates a Deadline and adds it to TaskList
     * @param cmd The parameters of the deadline to be created
     * @param taskList the TaskList which is active
     * @throws DukeException
     */
    private void createDeadline(String[] cmd, TaskList taskList) throws DukeException {
        if (cmd.length == 2) {
            String[] deadlineDetails = cmd[1].split(" /by ", 2);
            if (deadlineDetails.length == 2) {
                try {
                    Deadline deadline = new Deadline(deadlineDetails[0], deadlineDetails[1]);
                    taskList.addTask(deadline);
                } catch (DateTimeParseException e) {
                    System.out.println(e.getMessage() + "\nPlease input deadline in yyyy-mm-dd");
                }
            } else {
                throw new DukeException("Please indicate a time for the Deadline!");
            }
        } else {
            throw new DukeException("The description of a Deadline date cannot be empty.");
        }
    }

    /**
     * Creates a event and adds it to TaskList
     * @param cmd The parameters of the event to be created
     * @param taskList the TaskList which is active
     * @throws DukeException
     */
    private void createEvent(String[] cmd, TaskList taskList) throws DukeException {
        if (cmd.length == 2) {
            String[] EventDetails = cmd[1].split(" /at ", 2);
            if (EventDetails.length == 2) {
                try {
                    Event event = new Event(EventDetails[0], EventDetails[1]);
                    taskList.addTask(event);
                } catch (DateTimeParseException e) {
                    System.out.println(e.getMessage() + "\nPlease input Event date in yyyy-mm-dd");
                }
            } else {
                throw new DukeException("Please indicate a time for the Event!");
            }
        } else {
            throw new DukeException("The description of a Event cannot be empty.");
        }
    }
}
