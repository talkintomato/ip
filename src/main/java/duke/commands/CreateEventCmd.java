package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.exception.DukeException;
import duke.tasks.Event;

import java.time.format.DateTimeParseException;

public class CreateEventCmd extends Command {
    private Event event;

    public CreateEventCmd(String[] cmdVar) throws DukeException {
        String[] eventDetails = cmdVar[1].split(" /at ", 2);
        if (eventDetails.length != 2) {
            throw new DukeException("Invalid event input!");
        }
        this.event = new Event(eventDetails[0], eventDetails[1]);
    }

    /**
     * Executes creation of Event Task.
     * @param taskList the instance of the TaskList.
     * @param storage instance of storage.
     * @return Response from Duke.
     */
    @Override
    public String execute(TaskList taskList, Storage storage) throws DukeException {
        try {
            taskList.addTask(event);
            return ui.showTaskAdded(event);
        } catch (DateTimeParseException e) {
            throw new DukeException(e.getMessage());
        }
    }
}