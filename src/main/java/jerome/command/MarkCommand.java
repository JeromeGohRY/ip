package jerome.command;

import jerome.JeromeException;
import jerome.Storage;
import jerome.TaskList;
import jerome.Ui;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeromeException {
        tasks.get(index).markAsDone();
        storage.save(tasks.getAll());
        ui.showMark(tasks.get(index));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
