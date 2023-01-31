public abstract class Command {
    protected boolean isExit;
    protected String textCmd;

    public Command(String textCmd) {
        this.textCmd = textCmd;
        this.isExit = true;
    }

    public void execute(Ui ui, Storage storage, TaskList taskList) throws DukeException {}
    public boolean isExit() {
        return isExit;
    }
}
