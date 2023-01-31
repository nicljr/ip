public class AddCommand extends Command {

    protected TaskAssigner taskAssigner;
    public AddCommand(String textCmd) {
        super(textCmd);
        this.taskAssigner = new TaskAssigner();
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList taskList) throws DukeException {
        Task to_add = taskAssigner.assignTask(textCmd);
        taskList.add(to_add);
        ui.printAddTask(to_add, taskList.num_tasks);
    }
}
