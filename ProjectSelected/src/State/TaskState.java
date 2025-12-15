package State;

/**
 * State Pattern Interface
 * Represents different states a task can be in
 */
public interface TaskState {
    void handle(TaskContext context);
    String getStateName();
    String getColor(); // Color for GUI representation
}
