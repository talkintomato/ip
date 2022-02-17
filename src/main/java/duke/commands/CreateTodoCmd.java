package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.exception.DukeException;
import duke.tasks.Todo;

import java.time.format.DateTimeParseException;

public class CreateTodoCmd extends Command {
    private Todo todo;

    public CreateTodoCmd(String[] cmdVar) {
        this.todo = new Todo(cmdVar[1]);
    }

    /**
     * Executes creation of Todo Task.
     * @param taskList the instance of the TaskList.
     * @param storage instance of storage.
     * @return Response from Duke.
     */
    @Override
    public String execute(TaskList taskList, Storage storage) throws DukeException {
        taskList.addTask(todo);
        return ui.showTaskAdded(todo);
    }
}
