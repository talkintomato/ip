package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.exception.DukeException;


public class ListCmd extends Command{

    /**
     * Executes the listing of Task in TaskList.
     * @param taskList the instance of the TaskList.
     * @param storage instance of storage.
     * @return Response from Duke.
     */
    @Override
    public String execute(TaskList taskList, Storage storage) throws DukeException {
            return ui.printList(taskList.getList());
    }

}
