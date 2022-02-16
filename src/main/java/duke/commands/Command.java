package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.controllers.Ui;

public abstract class Command {

    protected Ui ui = new Ui();

    abstract public String execute(TaskList taskList, Storage storage);
}
