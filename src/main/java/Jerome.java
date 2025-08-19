import java.util.Scanner;
public class Jerome {
    public static void main(String[] args) {
        String start = " Hello! I'm Jerome.\n"
                + " What can I do for you? \n";
        String end = " Bye. Hope to see you again soon!";
        Scanner scn = new Scanner(System.in);
        System.out.println(start);
        while (true) {
            String echo = scn.nextLine();
            if (echo.equals("bye")) {
                break;
            } else{
                System.out.println(echo);
            }
        }
        System.out.println(end);
    }
}
