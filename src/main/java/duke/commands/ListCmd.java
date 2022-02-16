package duke.commands;

import duke.Storage;
import duke.TaskList;


public class ListCmd extends Command{

    /**
     * Executes the listing of Task in TaskList.
     * @param taskList the instance of the TaskList.
     * @param storage instance of storage.
     * @return Response from Duke.
     */
    @Override
    public String execute(TaskList taskList, Storage storage) {
            return ui.printList(taskList.getList());
    }

}
