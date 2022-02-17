package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.exception.DukeException;
import duke.tasks.Deadline;

import java.time.format.DateTimeParseException;

public class CreateDeadlineCmd extends Command {
    private Deadline deadline;

    public CreateDeadlineCmd(String[] cmdVar) throws DukeException {
        String[] deadlineDetails = cmdVar[1].split(" /by ", 2);
        if (deadlineDetails.length != 2) {
            throw new DukeException("Invalid deadline input!");
        }
        this.deadline = new Deadline(deadlineDetails[0], deadlineDetails[1]);
    }

    /**
     * Executes creation of Deadline Task.
     * @param taskList the instance of the TaskList.
     * @param storage instance of storage.
     * @return Response from Duke.
     */
    @Override
    public String execute (TaskList taskList, Storage storage) throws DukeException {
        try {
            taskList.addTask(deadline);
            return ui.showTaskAdded(deadline);
        } catch (DateTimeParseException e) {
            throw new DukeException(e.getMessage());
        }
    }
}