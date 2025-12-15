package State;

/**
 * Concrete State: Review
 * Task is under review
 */
public class ReviewState implements TaskState {
    
    @Override
    public void handle(TaskContext context) {
        System.out.println("Task '" + context.getTaskName() + "' moved from REVIEW to DONE");
        context.setState(new DoneState());
    }
    
    @Override
    public String getStateName() {
        return "REVIEW";
    }
    
    @Override
    public String getColor() {
        return "#6BCB77"; // Light Green
    }
}
