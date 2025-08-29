package jerome.command;

import jerome.Storage;
import jerome.task.Task;
import jerome.TaskList;
import jerome.Ui;

/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Deletes task from task list with the provided index.
     *
     * @param tasks   The task list the command operates on.
     * @param ui      The UI to interact with the user.
     * @param storage The storage to save or load task data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.remove(index);
        ui.showDeleted(t, tasks);
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
