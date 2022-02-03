package duke;
import duke.exception.DukeException;
import duke.tasks.*;
import duke.controllers.Ui;

import java.time.format.DateTimeParseException;


public class Command {

    private String[] cmd;
    private Ui ui = new Ui();
    private boolean isExiting = false;

    public Command(String[] cmd) {
        this.cmd = cmd;
    }

    /**
     * Determines the Nature of the command to be executed
     * @param taskList the TaskList which is active
     * @param storage The object used to write and save state of Tasklist
     * @throws DukeException
     */
    public String execute(TaskList taskList, Storage storage) {
        String response = "";
        try {
            switch (cmd[0]) {
            case "list":
                response = ui.printList(taskList.getList());
                break;
            case "mark":
                response = taskList.mark(cmd[1]);
                break;
            case "unmark":
                response = taskList.unmark(cmd[1]);
                break;
            case "find":
                response = taskList.searchKeyword(cmd[1]);
                break;
            //Event creation
            case "todo":
                response = createTodo(cmd, taskList);
                break;
            case "deadline":
                response = createDeadline(cmd, taskList);
                break;
            case "event":
                response = createEvent(cmd, taskList);
                break;
            case "delete":
                response = ui.showTaskRemoved(taskList.removeTask(cmd[1]));
                break;
            case "bye":
                isExiting = true;
                break;
            default:
                //TODO: make it a exception
                throw new DukeException("I'm not sure what that means :((");
            }} catch (Exception e) {
                response = e.getMessage();
            } finally {
            storage.saveList();
            return response;
        }
    }


    public boolean getExitStatus() {
        return this.isExiting;
    }

//    public void validateTaskCreation(String[] cmd) {
//        if (cmd.length != 2) {
//    }

    /**
     * Creates a todo and adds it to TaskList
     * @param cmd The parameters of the todo to be created
     * @param taskList the TaskList which is active
     * @throws DukeException
     */
    private String createTodo(String[] cmd, TaskList taskList) throws DukeException {
        String response = "";
        if (cmd.length == 2) {
            Todo todo = new Todo(cmd[1]);
            taskList.addTask(todo);
            response = ui.showTaskAdded(todo);
        } else {
            throw new DukeException("The description of a todo cannot be empty.");
        }
        return response;
    }

    /**
     * Creates a Deadline and adds it to TaskList
     * @param cmd The parameters of the deadline to be created
     * @param taskList the TaskList which is active
     * @throws DukeException
     */
    private String createDeadline(String[] cmd, TaskList taskList) throws DukeException {
        String response = "";
        if (cmd.length == 2) {
            String[] deadlineDetails = cmd[1].split(" /by ", 2);
            if (deadlineDetails.length == 2) {
                try {
                    Deadline deadline = new Deadline(deadlineDetails[0], deadlineDetails[1]);
                    taskList.addTask(deadline);
                    response = ui.showTaskAdded(deadline);
                } catch (DateTimeParseException e) {
                    System.out.println(e.getMessage() + "\nPlease input deadline in yyyy-mm-dd");
                }
            } else {
                throw new DukeException("Please indicate a time for the Deadline!");
            }
        } else {
            throw new DukeException("The description of a Deadline date cannot be empty.");
        }
        return response;
    }

    /**
     * Creates a event and adds it to TaskList
     * @param cmd The parameters of the event to be created
     * @param taskList the TaskList which is active
     * @throws DukeException
     */
    private String createEvent(String[] cmd, TaskList taskList) throws DukeException {
        String response = "";
        if (cmd.length == 2) {
            String[] EventDetails = cmd[1].split(" /at ", 2);
            if (EventDetails.length == 2) {
                try {
                    Event event = new Event(EventDetails[0], EventDetails[1]);
                    taskList.addTask(event);
                    response = ui.showTaskAdded(event);
                } catch (DateTimeParseException e) {
                    System.out.println(e.getMessage() + "\nPlease input Event date in yyyy-mm-dd");
                }
            } else {
                throw new DukeException("Please indicate a time for the Event!");
            }
        } else {
            throw new DukeException("The description of a Event cannot be empty.");
        }
        return response;
    }
}
