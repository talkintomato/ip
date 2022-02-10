package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.tasks.Todo;

public class CreateTodoCmd extends Command {
    private Todo todo;

    public CreateTodoCmd(String[] cmdVar) {
        this.todo = new Todo(cmdVar[1]);
    }

    public String execute(TaskList taskList, Storage storage) {
        taskList.addTask(todo);
        return ui.showTaskAdded(todo);
    }
}
