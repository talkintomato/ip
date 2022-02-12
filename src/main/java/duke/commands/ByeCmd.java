package duke.commands;

import duke.Storage;
import duke.TaskList;

public class ByeCmd extends Command {

    public ByeCmd() {}

    @Override
    public String execute(TaskList taskList, Storage storage) {
        System.exit(0);;
        return ui.showExitMessage();
    }

}
