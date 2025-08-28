package jerome.command;

import jerome.Storage;
import jerome.TaskList;
import jerome.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.listTasks();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
