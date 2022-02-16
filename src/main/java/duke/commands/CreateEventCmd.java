package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.tasks.Event;

public class CreateEventCmd extends Command {
    private Event event;

    public CreateEventCmd(String[] cmdVar) {
        String[] eventDetails = cmdVar[1].split(" /at ", 2);
        this.event = new Event(eventDetails[0], eventDetails[1]);
    }

    /**
     * Executes creation of Event Task.
     * @param taskList the instance of the TaskList.
     * @param storage instance of storage.
     * @return Response from Duke.
     */
    @Override
    public String execute(TaskList taskList, Storage storage) {
        taskList.addTask(event);
        return ui.showTaskAdded(event);
    }
}