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
                taskList.removeList(cmd[1]);
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

    private void createTodo(String[] cmd, TaskList taskList) throws DukeException {
        if (cmd.length == 2) {
            Todo todo = new Todo(cmd[1]);
            taskList.addList(todo);
        } else {
            throw new DukeException("The description of a todo cannot be empty.");
        }
    }

    private void createDeadline(String[] cmd, TaskList taskList) throws DukeException {
        if (cmd.length == 2) {
            String[] deadlineDetails = cmd[1].split(" /by ", 2);
            if (deadlineDetails.length == 2) {
                try {
                    Deadline deadline = new Deadline(deadlineDetails[0], deadlineDetails[1]);
                    taskList.addList(deadline);
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

    private void createEvent(String[] cmd, TaskList taskList) throws DukeException {
        if (cmd.length == 2) {
            String[] EventDetails = cmd[1].split(" /at ", 2);
            if (EventDetails.length == 2) {
                try {
                    Event event = new Event(EventDetails[0], EventDetails[1]);
                    taskList.addList(event);
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
