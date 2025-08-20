import java.util.Arrays;
import java.util.Scanner;
public class Jerome {
    public static void main(String[] args) {
        String start = "Hello! I'm Jerome.\n"
                + "What can I do for you?";
        String end = "Bye. Hope to see you again soon!";
        Scanner scn = new Scanner(System.in);
        System.out.println(start);
        Task tasks[] = new Task[100];
        int idx = 0;
        while (true) {
            String input = scn.nextLine();
            String[] separated = input.split(" ");
            if (input.equals("bye")) {
                break;
            } else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < idx; i++) {
                    System.out.println(String.valueOf(i + 1) + ". " + tasks[i]);
                }
            } else if (separated[0].equals("mark")) {
                int i = Integer.parseInt(separated[1]) - 1;
                tasks[i].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(tasks[i]);
            } else if (separated[0].equals("unmark")) {
                int i = Integer.parseInt(separated[1]) - 1;
                tasks[i].markAsNotDone();
                System.out.println("Okay,  I've marked this task as not done yet:");
                System.out.println(tasks[i]);
            } else {
                Task t;
                if (separated[0].equals("todo")) {
                    t = new Todo(String.join(" ", Arrays.copyOfRange(separated, 1, separated.length)));
                } else if (separated[0].equals("deadline")) {
                    String cutString = String.join(" ", Arrays.copyOfRange(separated, 1, separated.length));
                    String[] formatted = cutString.split(" /by ");
                    t = new Deadline(formatted[0], formatted[1]);
                } else {
                    String cutString = String.join(" ", Arrays.copyOfRange(separated, 1, separated.length));
                    String[] formatted = cutString.split(" /");
                    t = new Event(formatted[0], formatted[1], formatted[2]);

                }
                tasks[idx] = t;
                idx += 1;
                System.out.println("Got it. I've added this task:");
                System.out.println(t);
                System.out.println(String.format("Now you have %d tasks in the list.", idx));
            }
        }
        System.out.println(end);
    }
}
