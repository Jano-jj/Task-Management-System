package State;

import Observer.TaskObserver;
import java.util.ArrayList;
import java.util.List;

/**
 * Context class that maintains the current state of a task
 * Also acts as Subject in Observer pattern
 */
public class TaskContext {
    private TaskState currentState;
    private String taskName;
    private String taskDescription;
    private String taskType;
    private List<TaskObserver> observers;
    
    public TaskContext(String taskName, String taskDescription , String tasktype) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskType = tasktype;
        this.currentState = new TodoState();
        this.observers = new ArrayList<>();
    }
    
    public void setState(TaskState state) {
        this.currentState = state;
        notifyObservers();
    }
    
    public TaskState getState() {
        return currentState;
    }
    
    public String getTaskName() {
        return taskName;
    }
     public String getTaskType() {
        return taskType;
    }
    
    public String getTaskDescription() {
        return taskDescription;
    }
    
    public void nextState() {
        currentState.handle(this);
    }
    
    // Observer pattern methods
    public void attach(TaskObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
    
    public void detach(TaskObserver observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers() {
        for (TaskObserver observer : observers) {
            observer.update(this);
        }
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - %s", 
            currentState.getStateName(), 
            taskName, 
            taskDescription ,
            taskType);
    }
}
