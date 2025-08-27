import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Jerome {
    public static void main(String[] args) {
        String start = "Hello! I'm Jerome.\n"
                + "What can I do for you?";
        String end = "Bye. Hope to see you again soon!";
        Scanner scn = new Scanner(System.in);
        System.out.println(start);
        Storage s = new Storage("data.txt");

        ArrayList<Task> tasks = s.load();
        while (true) {
            String input = scn.nextLine();
            String[] separated = input.split(" ");
            if (input.equals("bye")) {
                break;
            } else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(String.valueOf(i + 1) + ". " + tasks.get(i));
                }
            } else if (separated[0].equals("mark")) {
                try {
                    int i = Integer.parseInt(separated[1]) - 1;
                    tasks.get(i).markAsDone();
                    s.save(tasks);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(tasks.get(i));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Input error: The input is missing the index of the task you wish to mark as done.");
                } catch (NumberFormatException e) {
                    System.out.println("Input error: The provided index is not a valid number.");
                }
            } else if (separated[0].equals("unmark")) {
                try {
                    int i = Integer.parseInt(separated[1]) - 1;
                    tasks.get(i).markAsNotDone();
                    s.save(tasks);
                    System.out.println("Okay,  I've marked this task as not done yet:");
                    System.out.println(tasks.get(i));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Input error: The input is missing the index of the task you wish to mark as not done.");
                } catch (NumberFormatException e) {
                    System.out.println("Input error: The provided index is not a valid number.");
                }
            } else if (separated[0].equals("delete")) {
                try {
                    int i = Integer.parseInt(separated[1]) - 1;
                    Task toBeRemoved = tasks.get(i);
                    tasks.remove(i);
                    s.save(tasks);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(toBeRemoved);
                    System.out.println(String.format("Now you have %d tasks in the list.", tasks.size()));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Input error: The input is missing the index of the task you wish to delete.");
                } catch (NumberFormatException e) {
                    System.out.println("Input error: The provided index is not a valid number.");
                }
            } else {
                Task t;
                try {
                    if (separated[0].equals("todo")) {
                        if (separated.length < 2) {
                            throw new JeromeException("Input error: The description of a todo task cannot be empty.");
                        }
                        t = new Todo(String.join(" ", Arrays.copyOfRange(separated, 1, separated.length)));
                    } else if (separated[0].equals("deadline")) {
                        if (separated.length < 3) {
                            throw new JeromeException("Input error: Invalid deadline format.");
                        }
                        String cutString = String.join(" ", Arrays.copyOfRange(separated, 1, separated.length));
                        String[] formatted = cutString.split(" /by ");
                        if (formatted.length != 2) {
                            throw new JeromeException("Input error: Invalid deadline format.");
                        }
                        t = new Deadline(formatted[0], formatted[1]);
                    } else if (separated[0].equals("event")){
                        String cutString = String.join(" ", Arrays.copyOfRange(separated, 1, separated.length));
                        String[] formatted = cutString.split(" /");
                        if (formatted.length != 3) {
                            throw new JeromeException("Input error: Invalid event format.");
                        }
                        t = new Event(formatted[0], formatted[1], formatted[2]);
                    } else {
                        throw new JeromeException("Unknown command: " + input + " Please use todo, deadline, event, list, delete, mark, unmark and bye.");
                    }
                    tasks.add(t);
                    s.save(tasks);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(t);
                    System.out.println(String.format("Now you have %d tasks in the list.", tasks.size()));
                } catch (JeromeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println(end);
    }
}
