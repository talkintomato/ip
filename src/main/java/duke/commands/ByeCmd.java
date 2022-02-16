package duke.commands;

import duke.Storage;
import duke.TaskList;

public class ByeCmd extends Command {

    public ByeCmd() {}

    /**
     * Ends Duke.
     * @param taskList the instance of the TaskList.
     * @param storage instance of storage.
     * @return Response from Duke.
     */
    @Override
    public String execute(TaskList taskList, Storage storage) {
        System.exit(0);;
        return ui.showExitMessage();
    }

}
