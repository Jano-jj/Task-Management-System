package Sigelton;

import State.TaskContext;
import Observer.TaskObserver;
import Observer.NotificationObserver;
import java.util.ArrayList;
import java.util.List;

/**
 * Centralized Task Manager
 * Manages all tasks and observers in the system
 */
public class taskSingelton {
    private static taskSingelton instance;
    private List<TaskContext> tasks;
    private NotificationObserver notificationObserver;
    
    private taskSingelton() {
        tasks = new ArrayList<>();
        notificationObserver = new NotificationObserver("System");
    }
    
    public static taskSingelton getInstance() {
        if (instance == null) {
            instance = new taskSingelton();
        }
        return instance;
    }
    
    public void addTask(TaskContext task) {
        tasks.add(task);
        task.attach(notificationObserver);
    }
    
    public void addTask(String name, String description , String type) {
        TaskContext task = new TaskContext(name, description , type);
        addTask(task);
    }
    
    public void removeTask(TaskContext task) {
        tasks.remove(task);
    }
    
    public List<TaskContext> getAllTasks() {
        return new ArrayList<>(tasks);
    }
    
    public List<TaskContext> getTasksByState(String stateName) {
        List<TaskContext> filtered = new ArrayList<>();
        for (TaskContext task : tasks) {
            if (task.getState().getStateName().equals(stateName)) {
                filtered.add(task);
            }
        }
        return filtered;
    }
    
    public void attachObserverToAllTasks(TaskObserver observer) {
        for (TaskContext task : tasks) {
            task.attach(observer);
        }
    }
    
    public NotificationObserver getNotificationObserver() {
        return notificationObserver;
    }
    
    public void clearAllTasks() {
        tasks.clear();
    }
    
    public int getTaskCount() {
        return tasks.size();
    }
}
