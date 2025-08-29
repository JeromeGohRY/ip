package jerome.command;

import jerome.TaskList;
import jerome.Ui;
import jerome.Storage;
import jerome.JeromeException;
import jerome.task.Event;
import jerome.task.Task;

import java.time.format.DateTimeParseException;

public class EventCommand extends Command {
    private String description;
    private String start;
    private String end;

    public EventCommand(String description, String start, String end) {
        this.description = description;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeromeException {
        try {
            Task task = new Event(description, start, end);
            tasks.add(task);
            ui.showAddition(task, tasks);
            storage.save(tasks.getAll());
        } catch (DateTimeParseException e) {
            throw new JeromeException("Please provide a valid date in this format yyyy-mm-dd");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
