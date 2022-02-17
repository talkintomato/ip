package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.exception.DukeException;


public class MarkCmd extends Command{

    private int index;

    /**
     * Constructor for MarkCmd takes in the index of the task to be marked as
     * done.
     *
     * @param index the index of the task to be marked as done
     */
    public MarkCmd(int index) {
        this.index = index;
    }

    /**
     * Executes marking task as completed.
     * @param taskList the instance of the TaskList.
     * @param storage instance of storage.
     * @return Response from Duke.
     */
    @Override
    public String execute(TaskList taskList, Storage storage) throws DukeException {
        return taskList.mark(index);
    }

}
