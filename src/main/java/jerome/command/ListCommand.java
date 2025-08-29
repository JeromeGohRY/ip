package jerome.command;

import jerome.Storage;
import jerome.TaskList;
import jerome.Ui;
/**
 * Represents a command to list all tasks previously added by user.
 */
public class ListCommand extends Command {
    /**
     * Lists all the tasks in the tasks list using the ui.
     *
     * @param tasks   The task list the command operates on.
     * @param ui      The UI to interact with the user.
     * @param storage The storage to save or load task data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.listTasks();
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
