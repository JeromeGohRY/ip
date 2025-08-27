import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Event extends Task{
    protected LocalDate start;
    protected LocalDate end;

    public Event(String description, String start, String end) {
        super(description);
        String[] temp;
        temp = start.split(" ");
        this.start = LocalDate.parse(String.join(" ", Arrays.copyOfRange(temp, 1, temp.length)));
        temp = end.split(" ");
        this.end = LocalDate.parse(String.join(" ", Arrays.copyOfRange(temp, 1, temp.length)));
    }


    public Event(String description, boolean isDone, String start, String end) {
        super(description, isDone);
        String[] temp;
        temp = start.split(" ");
        this.start = LocalDate.parse(String.join(" ", Arrays.copyOfRange(temp, 1, temp.length)));
        temp = end.split(" ");
        this.end = LocalDate.parse(String.join(" ", Arrays.copyOfRange(temp, 1, temp.length)));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (" +  "from: " + this.start.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " " + "to: " + this.end.format(DateTimeFormatter.ofPattern("MMM d yyyy")) +")";
    }

    @Override
    public String toSaveFormat() {
        return "E | " + (this.isDone ? "1" : "0") + " | " + this.description + " | " + "from " +  this.start + " | " + "to " + this.end;
    }
}
