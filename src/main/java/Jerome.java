import java.util.Scanner;
public class Jerome {
    public static void main(String[] args) {
        String start = " Hello! I'm Jerome.\n"
                + " What can I do for you? \n";
        String end = " Bye. Hope to see you again soon!";
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
                    System.out.println(String.valueOf(i + 1) + ". " + "[" + tasks[i].getStatusIcon() + "] "+ tasks[i].getDescription());
                }
            } else if (separated[0].equals("mark")) {
                int i = Integer.parseInt(separated[1]) - 1;
                tasks[i].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + tasks[i].getStatusIcon() + "] "+ tasks[i].getDescription());
            } else if (separated[0].equals("unmark")) {
                int i = Integer.parseInt(separated[1]) - 1;
                tasks[i].markAsNotDone();
                System.out.println("Okay,  I've marked this task as not done yet:");
                System.out.println("[" + tasks[i].getStatusIcon() + "] "+ tasks[i].getDescription());
            } else {
                tasks[idx] = new Task(input);
                idx += 1;
                System.out.println("added: " + input);
            }
        }
        System.out.println(end);
    }
}
