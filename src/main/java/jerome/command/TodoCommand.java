package jerome.command;

import jerome.Storage;
import jerome.TaskList;
import jerome.Ui;
import jerome.task.Task;
import jerome.task.Todo;

/**
 * Represents a command to add a Todo task.
 */
public class TodoCommand extends Command {
    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    /**
     * Adds Todo task to task list and saves updated task list to storage.
     *
     * @param tasks   The task list the command operates on.
     * @param ui      The UI to interact with the user.
     * @param storage The storage to save or load task data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = new Todo(description);
        tasks.add(task);
        ui.showAddition(task,tasks);
        storage.save(tasks.getAll());
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
