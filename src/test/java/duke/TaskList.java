package duke;

import duke.exception.DukeException;
import duke.tasks.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TaskListTest {


    @Test
    public void markTest() {
        TaskList tasks = new TaskList();
        Todo todo = new Todo("false", "read book");
        tasks.addTask(todo);
        try {
            tasks.mark(0);
            assertEquals(todo.getIsDone(), true);
        } catch (DukeException e) {
            assertEquals(todo.getIsDone(), true);
        }
    }

    @Test
    public void unmarkTest() {
        TaskList tasks = new TaskList();
        Todo todo = new Todo("true", "read book");
        tasks.addTask(todo);
        try {
            tasks.unmark(0);
            assertEquals(todo.getIsDone(), false);
        } catch (DukeException e) {
            assertEquals(todo.getIsDone(), false);
        }
    }

}
