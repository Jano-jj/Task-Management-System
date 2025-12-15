package Observer;

import State.TaskContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Concrete Observer: Notification System
 * Logs notifications when tasks change state
 */
public class NotificationObserver implements TaskObserver {
    private String observerName;
    private StringBuilder notificationLog;
    
    public NotificationObserver(String observerName) {
        this.observerName = observerName;
        this.notificationLog = new StringBuilder();
    }
    
    @Override
    public void update(TaskContext task) {
        String timestamp = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String notification = String.format("[%s] NOTIFICATION: Task '%s' is now %s\n", 
            timestamp, 
            task.getTaskName(), 
            task.getState().getStateName());
        
        notificationLog.append(notification);
        System.out.println(notification);
    }
    
    public String getNotificationLog() {
        return notificationLog.toString();
    }
    
    public void clearLog() {
        notificationLog.setLength(0);
    }
}
