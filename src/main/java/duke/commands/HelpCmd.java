package duke.commands;

import duke.Storage;
import duke.TaskList;

public class HelpCmd extends Command {

    /**
     * Shows possible commands.
     * @param taskList the instance of the TaskList.
     * @param storage instance of storage.
     * @return Response from Duke.
     */
    @Override
    public String execute(TaskList taskList, Storage storage) {
        return ui.help();
    }
}
