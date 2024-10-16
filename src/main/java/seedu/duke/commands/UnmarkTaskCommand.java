package seedu.duke.commands;
import seedu.duke.data.task.TaskList;
    
public class UnmarkTaskCommand extends Command {
    public static final String COMMAND_WORD = "mark";
    public static final String MESSAGE_SUCCESS = "Task unmarked successfully: %1$s";
    public static final String MESSAGE_TASK_NOT_FOUND = "Task not found in the list!";
    
    private final int index;
    public UnmarkTaskCommand(int index) {
        this.index = index;
    }

    @Override
    public CommandResult execute() {
        try {
            tasks.markAsUndone(index);
            return new CommandResult(String.format(MESSAGE_SUCCESS, tasks.getTask(index)));
        } catch (TaskList.TaskNotFoundException e) {
            return new CommandResult(MESSAGE_TASK_NOT_FOUND);
        }
    }
}
