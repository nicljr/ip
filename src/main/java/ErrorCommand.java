public class ErrorCommand extends Command {
    public ErrorCommand(String textCmd) {
        super(textCmd);
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList taskList) throws DukeException {
        throw new DukeException("I have no idea whats that command mate!\n");
    }
}