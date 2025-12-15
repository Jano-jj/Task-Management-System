package State;

/**
 * Concrete State: Done
 * Task is completed
 */
public class DoneState implements TaskState {
    
    @Override
    public void handle(TaskContext context) {
        System.out.println("Task '" + context.getTaskName() + "' is already DONE. No further state changes.");
    }
    
    @Override
    public String getStateName() {
        return "DONE";
    }
    
    @Override
    public String getColor() {
        return "#4D96FF"; // Blue
    }
}
