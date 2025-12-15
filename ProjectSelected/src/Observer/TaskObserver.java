package Observer;

import State.TaskContext;

/**
 * Observer Pattern Interface
 * Observers are notified when task state changes
 */
public interface TaskObserver {
    void update(TaskContext task);
}
