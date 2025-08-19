import java.util.Arrays;

public class Event extends Task{
    protected String start;
    protected String end;

    public Event(String description, String start, String end) {
        super(description);
        String[] temp;
        temp = start.split(" ");
        this.start = temp[0] + ": " + String.join(" ", Arrays.copyOfRange(temp, 1, temp.length));
        temp = end.split(" ");
        this.end = temp[0] + ": " + String.join(" ", Arrays.copyOfRange(temp, 1, temp.length));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (" + this.start + " " + this.end +")";
    }
}
