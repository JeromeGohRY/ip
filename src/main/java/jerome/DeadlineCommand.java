package jerome;

import java.time.format.DateTimeParseException;

public class DeadlineCommand extends Command {
    private String description;
    private String by;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeromeException {
        try {
            Task task = new Deadline(description, by);
            tasks.add(task);
            storage.save(tasks.getAll());
            ui.showAddition(task, tasks);
        } catch (DateTimeParseException e) {
            throw new JeromeException("Please provide a valid date in this format yyyy-mm-dd");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
