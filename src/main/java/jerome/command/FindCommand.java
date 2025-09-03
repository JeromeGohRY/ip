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
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        storage.save(tasks.getAll());
        return tasks.filter(this.keyword);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
