import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TaskFactory {

    public interface Task {
        void execute();
    }

    public static class BugTask implements Task {
        @Override
        public void execute() {
            System.out.println("Executing Bug Task...");
        }
    }

    public static class FeatureTask implements Task {
        @Override
        public void execute() {
            System.out.println("Executing Feature Task...");
        }
    }

    public static class ImprovementTask implements Task {
        @Override
        public void execute() {
            System.out.println("Executing Improvement Task...");
        }
    }

    private static final Map<String, Supplier<Task>> taskRegistry = new HashMap<>();

    static {
        taskRegistry.put("bug", BugTask::new);
        taskRegistry.put("feature", FeatureTask::new);
        taskRegistry.put("improvement", ImprovementTask::new);
    }

    public static void registerTask(String type, Supplier<Task> constructor) {
        taskRegistry.put(type.toLowerCase(), constructor);
    }

    public static Task createTask(String type) {
        Supplier<Task> taskSupplier = taskRegistry.get(type.toLowerCase());
        if (taskSupplier != null) {
            return taskSupplier.get();
        }
        throw new IllegalArgumentException("Unknown task type: " + type);
    }

    public static void main(String[] args) {
        Task task1 = TaskFactory.createTask("bug");
        Task task2 = TaskFactory.createTask("feature");
        Task task3 = TaskFactory.createTask("improvement");

        task1.execute();
        task2.execute();
        task3.execute();

        registerTask("research", () -> () -> System.out.println("Executing Research Task..."));
        Task task4 = createTask("research");
        task4.execute();
    }
}
