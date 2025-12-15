package State;

/**
 * Concrete State: Todo
 * Initial state when a task is created
 */
public class TodoState implements TaskState {
    
    @Override
    public void handle(TaskContext context) {
        System.out.println("Task '" + context.getTaskName() + "' moved from TODO to IN PROGRESS");
        context.setState(new InProgressState());
    }
    
    @Override
    public String getStateName() {
        return "TODO";
    }
    
    @Override
    public String getColor() {
        return "#FF6B6B"; // Red
    }
}
