package jerome.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * Represents a Event task in the system.
 * A <code>Event</code>  object holds details like description, start date, end date and whether it is completed.
 */
public class Event extends Task {
    protected LocalDate start;
    protected LocalDate end;

    /**
     * Constructs a new <code>Event</code> with description, start date, end date and the status for whether it is done set to false.
     *
     * @param description Description of the deadline.
     * @param start The date of the event.
     * @param end The date of the event.
     */
    public Event(String description, String start, String end) {
        super(description);
        String[] temp;
        temp = start.split(" ");
        this.start = LocalDate.parse(String.join(" ", Arrays.copyOfRange(temp, 1, temp.length)));
        temp = end.split(" ");
        this.end = LocalDate.parse(String.join(" ", Arrays.copyOfRange(temp, 1, temp.length)));
    }

    /**
     * Constructs a new <code>Event</code> with description, start date, end date and the status for whether it is done.
     *
     * @param description Description of the deadline.
     * @param start The date of the event.
     * @param end The date of the event.
     * @param isDone Whether this event task is done.
     */
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

    /**
     * Provides string representation to save in .txt file
     * @return corresponding string representation for a Event task
     */
    @Override
    public String toSaveFormat() {
        return "E | " + (this.isDone ? "1" : "0") + " | " + this.description + " | " + "from " +  this.start + " | " + "to " + this.end;
    }
}
