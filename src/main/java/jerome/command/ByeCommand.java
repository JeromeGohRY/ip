package jerome.command;

import jerome.Storage;
import jerome.TaskList;
import jerome.Ui;

public class ByeCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.goodbye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
