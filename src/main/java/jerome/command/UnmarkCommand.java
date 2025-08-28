package jerome.command;

import jerome.JeromeException;
import jerome.Storage;
import jerome.TaskList;
import jerome.Ui;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeromeException {
        tasks.get(index).markAsNotDone();
        storage.save(tasks.getAll());
        ui.showUnmark(tasks.get(index));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
