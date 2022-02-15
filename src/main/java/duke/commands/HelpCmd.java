package duke.commands;

import duke.Storage;
import duke.TaskList;

public class HelpCmd extends Command {

    @Override
    public String execute(TaskList taskList, Storage storage) {
        return ui.help();
    }
}
