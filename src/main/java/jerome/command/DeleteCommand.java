package jerome.command;

import jerome.Storage;
import jerome.task.Task;
import jerome.TaskList;
import jerome.Ui;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.remove(index);
        ui.showDeleted(t, tasks);
        storage.save(tasks.getAll());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
