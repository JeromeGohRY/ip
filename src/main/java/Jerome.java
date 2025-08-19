import java.util.Scanner;
public class Jerome {
    public static void main(String[] args) {
        String start = " Hello! I'm Jerome.\n"
                + " What can I do for you? \n";
        String end = " Bye. Hope to see you again soon!";
        Scanner scn = new Scanner(System.in);
        System.out.println(start);
        String tasks[] = new String[100];
        int idx = 0;
        while (true) {
            String echo = scn.nextLine();
            if (echo.equals("bye")) {
                break;
            } else if (echo.equals("list")) {
                for (int i = 0; i < idx; i++) {
                    System.out.println(String.valueOf(i + 1) + ". " + tasks[i]);
                }
            } else {
                tasks[idx] = echo;
                idx += 1;
                System.out.println("added: " + echo);
            }
        }
        System.out.println(end);
    }
}
