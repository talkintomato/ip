package duke;

import duke.exception.DukeException;

public class Duke {
    private TaskList taskList;
    private Storage storage;
    private Ui ui;

        public static void main(String[] args) {
        new Duke("./src/data/duke.txt").run();
    }

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.load());
        } catch (Exception e) {
//            ui.showLoadingError();
            this.taskList = new TaskList();
        }
    }

    public void run() {
        ui.launch();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.commandParse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.getExitStatus();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
        ui.showExitMessage();
    }
}