import java.util.ArrayList;
import java.util.Scanner;

public class Todo {
    protected ArrayList<Task> todo = new ArrayList<Task>();

    public void addList(Task task) {
        todo.add(task);
        System.out.println("Added: " + task.description);
    }

    public void printList() {
        for (int i = 0; i < todo.size(); i++ ) {
            Task task = todo.get(i);
            System.out.println(task.getStatus());
        }
    }

    public void mark() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter task index?");
        int index = sc.nextInt();
        Task task = todo.get(index);
        if (task.isDone) {
            System.out.println("Task already completed!");
        } else {
            task.done();
            System.out.println("Nice! I've marked this task as done: \n" + task.getStatus());
        }
    }

    public void unmark() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter task index?");
        int index = sc.nextInt();
        Task task = todo.get(index);
        if (!task.isDone) {
            System.out.println("Task not yet completed!");
        } else {
            task.notDone();
            System.out.println("Oh no! one more thing that needs to be done: \n" + task.getStatus());
        }
    }
}
