package jerome;

import jerome.command.ByeCommand;
import jerome.command.Command;
import jerome.command.DeadlineCommand;
import jerome.command.DeleteCommand;
import jerome.command.EventCommand;
import jerome.command.FindCommand;
import jerome.command.ListCommand;
import jerome.command.MarkCommand;
import jerome.command.TodoCommand;
import jerome.command.UnmarkCommand;

/**
 * The <code>Parser</code> class is responsible for interpreting user input
 * and converting it into a <code>Command</code> that can be executed.
 */
public class Parser {
    /**
     * Parses the given user input and returns the corresponding Command to be executed.
     *
     * @param input The input string entered by the user.
     * @return A Command object representing the user's instruction.
     * @throws JeromeException If the input is invalid.
     */
    public static Command parse(String input) throws JeromeException {
        String[] separated = input.split(" ", 2);
        String command = separated[0];
        String args = separated.length > 1  ? separated[1] : "";

        switch (command) {
        case "bye":
            return new ByeCommand();
        case "list":
            return new ListCommand();
        case "find":
            return new FindCommand(args);
        case "mark":
            try {
                return new MarkCommand(Integer.parseInt(args) - 1);
            } catch (IndexOutOfBoundsException e) {
                throw new JeromeException("Input error: The input is missing the index of the task you wish to mark as done.");
            } catch (NumberFormatException e) {
                throw new JeromeException("Input error: The provided index is not a valid number.");
            }
        case "unmark":
            try {
                return new UnmarkCommand(Integer.parseInt(args) - 1);
            } catch (IndexOutOfBoundsException e) {
                throw new JeromeException("Input error: The input is missing the index of the task you wish to mark as not done.");
            } catch (NumberFormatException e) {
                throw new JeromeException("Input error: The provided index is not a valid number.");
            }
        case "delete":
            try {
                return new DeleteCommand(Integer.parseInt(args) - 1);
            } catch (IndexOutOfBoundsException e) {
                throw new JeromeException("Input error: The input is missing the index of the task you wish to delete.");
            } catch (NumberFormatException e) {
                throw new JeromeException("Input error: The provided index is not a valid number.");
            }
        case "todo":
            if (args.isEmpty()) {
                throw new JeromeException("The description of a todo task cannot be empty.");
            }
            return new TodoCommand(args);
        case "deadline":
            String[] formatted = args.split(" /by ");
            if (formatted.length != 2) {
                throw new JeromeException("Input error: Invalid deadline format.");
            }
            return new DeadlineCommand(formatted[0], formatted[1]);
        case "event":
            String[] deadline = args.split(" /");
            if (deadline.length != 3) {
                throw new JeromeException("Input error: Invalid event format.");
            }
            return new EventCommand(deadline[0], deadline[1], deadline[2]);
        default:
            throw new JeromeException("Unknown command: " + input + " Please use todo, deadline, event, list, delete, mark, unmark and bye.");

        }
    }
}
