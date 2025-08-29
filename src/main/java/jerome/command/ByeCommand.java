package jerome.command;

import jerome.Storage;
import jerome.TaskList;
import jerome.Ui;

/**
 * Represents a command to exit bot.
 */
public class ByeCommand extends Command {
    /**
     * Shows bye message.
     *
     * @param tasks   The task list the command operates on.
     * @param ui      The UI to show bye message.
     * @param storage The storage to save or load task data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.goodbye();
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
