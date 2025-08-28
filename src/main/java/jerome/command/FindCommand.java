package jerome.command;

import java.util.ArrayList;

import jerome.Storage;
import jerome.TaskList;
import jerome.Ui;

public class FindCommand extends Command{
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.filter(this.keyword);
        storage.save(tasks.getAll());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
