package State;

/**
 * Concrete State: In Progress
 * Task is currently being worked on
 */
public class InProgressState implements TaskState {
    
    @Override
    public void handle(TaskContext context) {
        System.out.println("Task '" + context.getTaskName() + "' moved from IN PROGRESS to REVIEW");
        context.setState(new ReviewState());
    }
    
    @Override
    public String getStateName() {
        return "IN PROGRESS";
    }
    
    @Override
    public String getColor() {
        return "#FFD93D"; // Yellow
    }
}
