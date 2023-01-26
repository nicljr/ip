import java.util.List;
import java.util.ArrayList;

public class TaskAssigner {

    public static ArrayList<String> task_t = new ArrayList<>(List.of("todo", "event", "deadline"));

    public TaskAssigner() {}

    public Task assignTask(String command) throws DukeException {
        String[] seq = command.split(" ");
        String ref = seq[0];

        if (!task_t.contains(ref)) {
            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(\n");
        }

        if (seq.length == 1) {
            throw new DukeException("OOPS!!! I'm sorry, but the description of a task cannot be empty\n");
        }

        if (ref.equals("todo")) {
            return new ToDos(command.substring(5));

        } else if (ref.equals("event")) {

            int s_index = command.indexOf("/from") + 6;
            int e_index = command.indexOf("/to") + 4;
            String start_date = command.substring(s_index, e_index - 5);
            String end_date = command.substring(e_index);
            String e_desc = command.substring(6, s_index - 7);
            return new Events(e_desc, start_date, end_date);

        } else {
            int d_index = command.indexOf("/by ") + 4;
            String deadline = command.substring(d_index);
            String d_desc = command.substring(9, d_index - 5);
            return new Deadline(d_desc, deadline);
        }
    }
}
