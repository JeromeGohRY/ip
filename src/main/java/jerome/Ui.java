package jerome;

import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);

    public void hello() {
        System.out.println("Hello! I'm Jerome.\nWhat can I do for you?");
    }

    public void goodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLength(TaskList t) {
        System.out.println(String.format("Now you have %d tasks in the list.", t.size()));

    }

    public void showTask(Task t) {
        System.out.println(t);
    }

    public void showMark(Task t) {
        System.out.println("Nice! I've marked this task as done:");
        showTask(t);
    }

    public void showUnmark(Task t) {
        System.out.println("Okay, I've marked this task as not done yet:");
        showTask(t);
    }

    public void showDeleted(Task task, TaskList tasks) {
        System.out.println("Noted. I've removed this task:");
        showTask(task);
        showLength(tasks);
    }

    public void showAddition(Task task, TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        showTask(task);
        showLength(tasks);
    }

}
