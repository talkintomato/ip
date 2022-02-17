package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.exception.DukeException;

public class FindCmd extends Command{

    private String keyword;

    /**
     * Constructor for FindCommand takes in the index of the task to be marked as
     * done.
     *
     * @param keyword the keyword which is to be searched for in TaskList
     */
    public FindCmd(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes finding of task which match the keyword provided.
     * @param taskList the instance of the TaskList.
     * @param storage instance of storage.
     * @return Response from Duke.
     */
    @Override
    public String execute(TaskList taskList, Storage storage) throws DukeException {
        try {
            return taskList.searchKeyword(keyword);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
