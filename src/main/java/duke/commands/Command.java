package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.controllers.Ui;
import duke.exception.DukeException;

public abstract class Command {

    protected Ui ui = new Ui();

    abstract public String execute (TaskList taskList, Storage storage) throws DukeException;
}
