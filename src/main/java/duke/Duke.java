package duke;

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
        } catch (Exception e) {
            this.taskList = new TaskList();
        }
    }

    public String getResponse(String userInput) {
        Command c = Parser.parseCommand(userInput);
        String response = c.execute(taskList, storage);
        //TODO: throw end exception
//        if (c.getExitStatus()) {
//
//        }
        return response;
    }

    /**
     *  Starts running Duke
     */
//    public String run() {
//        boolean isExit = false;
//        while (!isExit) {
//            try {
//                c.execute(taskList, ui, storage);
//                isExit = c.getExitStatus();
//            } catch (DukeException e) {
//                ui.showError(e.getMessage());
//            } finally {
//                ui.showLine();
//            }
//        }
//        ui.showExitMessage();
//    }
}