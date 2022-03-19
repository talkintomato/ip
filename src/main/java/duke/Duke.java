package duke;


import duke.commands.Command;
import duke.controllers.Parser;
import duke.exception.DukeException;

public class Duke {

    private TaskList taskList;
    private Storage storage;

    /**
     * Constructor for class
     * @param filePath The path which to save and load taskList state from
     */
    public Duke(String filePath) {
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            this.taskList = new TaskList();
            System.out.println(e.getMessage());
        }
    }

    public String getResponse(String userInput) {
        try {
            Command c = Parser.parseCommand(userInput);
            String response = c.execute(taskList, storage);
            storage.saveList(taskList.getList());
            return "KRAW!! Kraw!! \n" + response;
        } catch (DukeException e) {
            return "KRAW!! Kraw!! \n" + e.getMessage();
        } catch (Exception e) {
            return "KRAW!! Kraw!! \n Invalid Input!! use <help> to see commands!";
        }
    }

}