package duke;

import duke.exception.DukeException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Duke extends Application {

    private TaskList taskList;

    private Storage storage;

    private Ui ui;

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }


//    public static void main(String[] args) {
//        new Duke("./src/data/duke.txt").run();
//    }

    /**
     * Constructor for class
     * @param filePath The path which to save and load taskList state from
     */
//    public Duke(String filePath) {
//        ui = new Ui();
//        storage = new Storage(filePath);
//        try {
//            taskList = new TaskList(storage.load());
//        } catch (Exception e) {
////            ui.showLoadingError();
//            this.taskList = new TaskList();
//        }
//    }

    /**
     *  Starts running Duke
     */
    public void run() {
        ui.launch();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parseCommand(fullCommand);
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