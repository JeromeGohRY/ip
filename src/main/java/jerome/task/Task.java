package jerome.task;

/**
 * Represents a task in the system.
 * Holds task details like description and whether it is completed.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Provides string representation for whether task is completed
     * @return corresponding symbol as a string depending on isDone
     */
    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] "+ this.description;
    }

    /**
     * Marks the task as done
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    public boolean getStatus() {
        return this.isDone;
    }

    public String toSaveFormat() { return this.description; }

    public String getDescription() {
        return this.description;
    }
}
