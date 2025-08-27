import java.util.Arrays;

public class Event extends Task{
    protected String start;
    protected String end;

    public Event(String description, String start, String end) {
        super(description);
        String[] temp;
        temp = start.split(" ");
        this.start = String.join(" ", Arrays.copyOfRange(temp, 1, temp.length));
        temp = end.split(" ");
        this.end = String.join(" ", Arrays.copyOfRange(temp, 1, temp.length));
    }


    public Event(String description, boolean isDone, String start, String end) {
        super(description, isDone);
        String[] temp;
        temp = start.split(" ");
        this.start = String.join(" ", Arrays.copyOfRange(temp, 1, temp.length));
        temp = end.split(" ");
        this.end = String.join(" ", Arrays.copyOfRange(temp, 1, temp.length));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (" +  "from: " + this.start + " " + "to: " + this.end +")";
    }

    @Override
    public String toSaveFormat() {
        return "E | " + (this.isDone ? "1" : "0") + " | " + this.description + " | " + this.start + " | " + this.end;
    }
}
