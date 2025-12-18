Task Management System - Design Patterns Implementation Guide
A Comprehensive Guide to Six Design Patterns in Action
📋 Table of Contents
Project Overview
Architecture Diagram
Design Patterns Summary
Pattern 1: Factory Pattern
Pattern 2: State Pattern
Pattern 3: Observer Pattern
Pattern 4: Proxy Pattern
Pattern 5: Singleton Pattern
Pattern 6: Adapter Pattern
Pattern Collaboration
Complete User Journey

Project Overview
The Task Management System is a Java Swing desktop application that demonstrates professional software engineering through the implementation of six major design patterns. The application allows users to create, track, and manage tasks through different lifecycle states while receiving real-time notifications.
Key Features
🔐 Secure user authentication
✅ Task creation with multiple types (Bug, Feature, Improvement)
🔄 Task lifecycle management (TODO → IN PROGRESS → REVIEW → DONE)
🔔 Real-time state change notifications
📊 Centralized task management
Technologies
Language: Java 8+
GUI Framework: Java Swing
Design Patterns: 6 patterns (Factory, State, Observer, Proxy, Singleton, Adapter)
Architecture Diagram
┌─────────────────────────────────────────────────────────────────┐
│ TASK MANAGEMENT SYSTEM │
│ │
│ ┌─────────────────────────────────────────────────────────┐ │
│ │ GUI Layer (Swing) │ │
│ │ │ │
│ │ ┌──────────┐ ┌───────────┐ ┌─────────────┐ │ │
│ │ │LoginPage │─→ │ Dashboard │─→ │AddTaskPage │ │ │
│ │ └──────────┘ └───────────┘ └─────────────┘ │ │
│ └────────────────────┬────────────────────────────────────┘ │
│ │ │
│ ┌────────────────────┼────────────────────────────────────┐ │
│ │ Business Logic Layer │ │
│ │ │ │
│ │ ┌──────────────┴──────────────┐ │ │
│ │ │ TaskManager (Singleton) │ │ │
│ │ └──────────────┬──────────────┘ │ │
│ │ │ │ │
│ │ ┌─────────┼─────────┐ │ │
│ │ ▼ ▼ ▼ │ │
│ │ ┌────────┐ ┌──────┐ ┌────────┐ │ │
│ │ │Factory │ │State │ │Observer│ │ │
│ │ │Pattern │ │Pattern│ │Pattern │ │ │
│ │ └────────┘ └──────┘ └────────┘ │ │
│ └─────────────────────────────────────────────────────────┘ │
│ │
│ ┌─────────────────────────────────────────────────────────┐ │
│ │ Security & Integration Layer │ │
│ │ │ │
│ │ ┌──────────────┐ ┌──────────────┐ │ │
│ │ │Proxy Pattern │ │Adapter Pattern│ │ │
│ │ │(Login Auth) │ │(Notifications)│ │ │
│ │ └──────────────┘ └──────────────┘ │ │
│ └─────────────────────────────────────────────────────────┘ │
└─────────────────────────────────────────────────────────────────┘

This diagram illustrates the layered architecture of the Task Management System, highlighting the distinct responsibilities of each layer and the strategic placement of various design patterns to manage complexity and promote modularity.
Design Patterns Summary
This table summarizes the six design patterns implemented in our Task Management System, detailing their type, purpose, and key classes involved. This overview provides a quick reference for understanding each pattern's role.
1
Factory
Creational - Create different task types
TaskFactory, BugTask, FeatureTask, ImprovementTask
2
State
Behavioral - Manage task lifecycle states
TaskContext, TodoState, InProgressState, ReviewState, DoneState
3
Observer
Behavioral - Notify when tasks change
TaskObserver, NotificationObserver, UIObserver
4
Proxy
Structural - Control access to login
LoginProxy, RealLoginService
5
Singleton
Creational - Single task manager instance
TaskManager
6
Adapter
Structural - Integrate legacy notifications
NotificationAdapter, OldLegacyNotifier

1. Factory Pattern
   The Factory Pattern is a creational design pattern that allows us to encapsulate the logic for creating objects. It delegates the responsibility of instantiating objects to a "factory" method, rather than having the client directly instantiate objects using the new keyword.
   1
   🎯 Purpose
   The Factory Pattern creates objects without exposing the creation logic to the client. In our project, it's used to create different types of tasks (Bug, Feature, Improvement) based on user selection.
   2
   ✅ Benefits in Our Project
   Flexibility: Easy to add new task types (just add a new class and case)
   Loose Coupling: TaskContext doesn't need to know about concrete task classes
   Centralized Logic: All task creation happens in one place
   Type Safety: Switch statement catches unknown types at runtime

📐 Class Diagram
<<interface>> Task
┌──────────┐
│+getTypeName()│
└──────────┘
△
│ implements
┌────────────┼────────────┐
│ │ │
┌─────────┐ ┌──────────┐ ┌─────────────┐
│BugTask │ │FeatureTask│ │ImprovementTask│
└─────────┘ └──────────┘ └─────────────┘
△ △ △
│ │ │
└────────────┼────────────┘
│ creates
┌──────────────┐
│ TaskFactory │
├──────────────┤
│+createTask() │
└──────────────┘

💻 Implementation Snippets
// Interface: Defines contract for all task types
public interface Task { String getTypeName(); }

// Concrete Product 1: Bug Task
public class BugTask implements Task {
@Override public String getTypeName() { return "Bug"; }
}

// Concrete Product 2: Feature Task
public class FeatureTask implements Task {
@Override public String getTypeName() { return "Feature"; }
}

// Factory: Creates the appropriate task
public class TaskFactory {
public static Task createTask(String type) {
switch (type) {
case "Bug": return new BugTask();
case "Feature": return new FeatureTask();
case "Improvement": return new ImprovementTask();
default: throw new IllegalArgumentException("Unknown task type");
}
}
}

🔄 How It Works in Our Project
User Flow:
──────────

1. User opens AddTaskPage
2. Selects "Bug" from dropdown
3. Fills in task details
4. Clicks "Save"
   │
   ▼
   AddTaskPage
   │ taskManager.addTask(name, description, "Bug")
   ▼
   TaskManager
   │ new TaskContext(name, description, type)
   ▼
   TaskContext Constructor
   │ TaskFactory.createTask("Bug") ← FACTORY PATTERN IN ACTION
   ▼
   TaskFactory
   ├─ Checks type == "Bug"
   └─ return new BugTask()
   │
   ▼
   BugTask Instance (stored in taskType field)

📊 Usage Example from Code
// In TaskContext.java constructor:
public TaskContext(String taskName, String taskDescription, String taskType) {
this.taskName = taskName;
this.taskDescription = taskDescription;
// Factory creates the appropriate task type
this.taskType = TaskFactory.createTask(taskType); // ← Factory Pattern
this.currentState = new TodoState();
this.observers = new ArrayList<>();
} 2. State Pattern
The State Pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes. The object appears to change its class, providing a clean way to manage state-dependent logic without complex conditional statements.
🎯 Purpose
The State Pattern allows an object to alter its behavior when its internal state changes. In our project, tasks transition through four states: TODO → IN PROGRESS → REVIEW → DONE.
✅ Benefits in Our Project
No Conditionals: No if/else chains - each state handles its own logic
Easy to Extend: Add new states without modifying existing code
Encapsulation: State-specific behavior is encapsulated in state classes
Type Safety: Compiler ensures all states implement required methods

📐 State Transition Diagram
​
DONE
REVIEW
IN PROGRESS
TODO
​
📐 Class Diagram
<<interface>> TaskState
┌────────────────────────┐
│ +handle(TaskContext) │
│ +getStateName() │
│ +getColor() │
└────────────────────────┘
△
│ implements
┌───────────┼───────────┬───────────┐
│ │ │ │
┌──────────┐ ┌────────────┐ ┌────────┐ ┌──────────┐
│TodoState │ │InProgressState│ │ReviewState│ │DoneState│
└──────────┘ └────────────┘ └────────┘ └──────────┘
△ △ △ △
│ │ │ │
└────────────┴───────────┴────────────┘
│ manages state
┌────────────┐
│TaskContext │
├────────────┤
│-currentState│
│+setState() │
│+nextState()│
└────────────┘

💻 Implementation Snippets
// State Interface
public interface TaskState {
void handle(TaskContext context);
String getStateName();
String getColor();
}

// State 1: TODO
public class TodoState implements TaskState {
@Override public void handle(TaskContext context) {
context.setState(new InProgressState());
}
@Override public String getStateName() { return "TODO"; }
@Override public String getColor() { return "#FF6B6B"; }
}

// State 2: IN PROGRESS
public class InProgressState implements TaskState {
@Override public void handle(TaskContext context) {
context.setState(new ReviewState());
}
@Override public String getStateName() { return "IN PROGRESS"; }
@Override public String getColor() { return "#FFD93D"; }
}

// Context Class
public class TaskContext {
private TaskState currentState;
public TaskContext(...) {
this.currentState = new TodoState(); // Initial state
}
public void setState(TaskState state) {
this.currentState = state;
notifyObservers(); // Notify when state changes
}
public void nextState() {
currentState.handle(this); // Delegate to current state
}
}

🔄 How It Works in Our Project
User Action: View Task → Select Task → Click "Move to Next State"
Step-by-Step Execution:
───────────────────────

1. Initial State
   ┌─────────────────┐
   │ Task: "Fix Bug" │
   │ State: TODO │ ← currentState = TodoState instance
   └─────────────────┘

2. User Clicks "Yes" to Transition
   │
   ▼
   Dashboard.java calls: task.nextState()
   │
   ▼
   TaskContext.nextState()
   │ └─→ currentState.handle(this)
   │ └─→ TodoState.handle(context) is called
   │ ├─ Prints: "Task moved from TODO to IN PROGRESS"
   │ └─→ context.setState(new InProgressState())
   │ ├─ currentState = new InProgressState()
   │ └─→ notifyObservers() ← Triggers Observer Pattern

3. New State
   ┌─────────────────────┐
   │ Task: "Fix Bug" │
   │ State: IN PROGRESS │ ← currentState = InProgressState
   └─────────────────────┘

4. Next Transition
   User clicks "Yes" again
   │
   └─→ task.nextState()
   └─→ InProgressState.handle(context)
   └─→ context.setState(new ReviewState())
   And so on...

📊 Real Code Flow
// In Dashboard.java - ViewTaskButton handler
private void ViewTaskButtonActionPerformed(ActionEvent evt) {
// Get selected task
TaskContext task = tasks.get(selectedIndex);
// Show current state
String oldState = task.getState().getStateName();
// Transition to next state
task.nextState(); // ← STATE PATTERN IN ACTION
// Show new state
String newState = task.getState().getStateName();
JOptionPane.showMessageDialog(this, "Task state updated!\\n" +
"From: " + oldState + "\\n" + "To: " + newState);
} 3. Observer Pattern
The Observer Pattern is a behavioral design pattern where an object, called the subject, maintains a list of its dependents, called observers, and notifies them of any state changes, usually by calling one of their methods. This pattern promotes loose coupling between the subject and its observers.
1
🎯 Purpose
The Observer Pattern defines a one-to-many dependency between objects. When one object (Subject) changes state, all its dependents (Observers) are notified automatically. In our project, when a task changes state, all observers (notification system, UI) are notified.
2
✅ Benefits in Our Project
Loose Coupling: Subject doesn't know concrete observer classes
Dynamic Registration: Observers can be added/removed at runtime
Broadcast: One event notifies multiple observers automatically
Extensibility: Easy to add new observers (email, SMS, etc.)

📐 Pattern Diagram
Client (LoginPage)
│
│ login(username, password)
▼
<<interface>> LoginService
┌──────────┐
│ +login() │
└──────────┘
△
│ implements
┌───────┴────────┐
│ │
┌─────────┐ ┌──────────────┐
│Proxy │───→│RealLogin │
│ │ │Service │
│+login() │ │+login() │
└─────────┘ └──────────────┘
│ ├─ Validates input
├─ Lazy initialization
└─ Delegates to real service

💻 Implementation Snippets
// Observer Interface
public interface TaskObserver {
void update(TaskContext task);
}

// Concrete Observer 1: Notification Logger
public class NotificationObserver implements TaskObserver {
private StringBuilder notificationLog;
public NotificationObserver(String observerName) {
this.notificationLog = new StringBuilder();
}
@Override public void update(TaskContext task) {
String notification = String.format(
"[%s] NOTIFICATION: Task '%s' is now %s\\n",
LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
task.getTaskName(), task.getState().getStateName());
notificationLog.append(notification);
System.out.println(notification);
}
public String getNotificationLog() { return notificationLog.toString(); }
}

// Subject Implementation (in TaskContext)
public class TaskContext {
private List observers;
public TaskContext(...) { this.observers = new ArrayList<>(); }
public void attach(TaskObserver observer) {
if (!observers.contains(observer)) { observers.add(observer); }
}
public void notifyObservers() {
for (TaskObserver observer : observers) { observer.update(this); }
}
public void setState(TaskState state) {
this.currentState = state;
notifyObservers(); // ← OBSERVER PATTERN IN ACTION
}
}

🔄 How It Works in Our Project
Complete Notification Flow:
═══════════════════════════
Step 1: Task Creation
─────────────────────
TaskManager.addTask()
│
├─→ Creates TaskContext
│ └─→ task.attach(notificationObserver) ← Observer attached
│ └─→ observers list: [NotificationObserver]

Step 2: Task State Change
──────────────────────────
User clicks "Move to Next State"
│
▼
task.nextState()
│ └─→ currentState.handle(this)
│ └─→ setState(new InProgressState()) ← State changes
│ ├─→ currentState = new InProgressState()
│ └─→ notifyObservers() ┐
│ │
▼ ┌──────────────────────────────┐
│ Loop through all observers │
└──────────────────────────────┘
│
▼
NotificationObserver.update(task)
├─→ Get current time
├─→ Get task name
├─→ Get new state
├─→ Format message
├─→ Append to log
└─→ Print to console

Step 3: User Views Notifications
─────────────────────────────────
User clicks "Notifications" button
│
▼
Dashboard.NotificationButtonActionPerformed()
│ └─→ notificationObserver.getNotificationLog()
│ └─→ Returns all logged notifications
│
▼
JOptionPane shows:
[2025-12-18 14:30:15] NOTIFICATION: Task 'Fix Bug' is now IN PROGRESS
[2025-12-18 14:35:22] NOTIFICATION: Task 'Fix Bug' is now REVIEW
[2025-12-18 14:40:10] NOTIFICATION: Task 'Fix Bug' is now DONE

📊 Real Example Output
Console Output:
───────────────
[2025-12-18 10:15:30] NOTIFICATION: Task 'Fix login validation' is now TODO
[2025-12-18 10:16:45] NOTIFICATION: Task 'Fix login validation' is now IN PROGRESS
[2025-12-18 11:30:20] NOTIFICATION: Task 'Fix login validation' is now REVIEW
[2025-12-18 14:22:55] NOTIFICATION: Task 'Fix login validation' is now DONE

4. Proxy Pattern
   The Proxy Pattern is a structural design pattern that provides a substitute or placeholder for another object to control access to it. It acts as an intermediary, adding a layer of control or functionality before or after the real object's operations.
   1
   🎯 Purpose
   The Proxy Pattern provides a surrogate or placeholder to control access to another object. In our project, it adds validation before allowing access to the login service.
   2
   ✅ Benefits in Our Project
   Input Validation: Checks for empty fields before expensive operations
   Lazy Initialization: RealLoginService created only when needed
   Security: Can add logging, rate limiting, encryption
   Single Responsibility: Proxy handles validation, Real service handles auth

📐 Pattern Diagram
Client (LoginPage)
│
│ login(username, password)
▼
<<interface>> LoginService
┌──────────┐
│ +login() │
└──────────┘
△
│ implements
┌───────┴────────┐
│ │
┌─────────┐ ┌──────────────┐
│Proxy │───→│RealLogin │
│ │ │Service │
│+login() │ │+login() │
└─────────┘ └──────────────┘
│ ├─ Validates input
├─ Lazy initialization
└─ Delegates to real service

💻 Implementation Snippets
// Service Interface
public interface LoginService {
boolean login(String username, String password);
}

// Real Service (Real Subject)
public class RealLoginService implements LoginService {
@Override
public boolean login(String username, String password) {
return username.equals("admin") && password.equals("123456");
}
}

// Proxy
public class LoginProxy implements LoginService {
private RealLoginService realLogin; // Lazy initialization

    @Override
    public boolean login(String username, String password) {
        // Pre-processing: Input validation
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        // Lazy initialization: Create real service only when needed
        if (realLogin == null) {
            realLogin = new RealLoginService();
        }
        // Delegate to real service
        return realLogin.login(username, password);
    }

}

🔄 How It Works in Our Project
Login Flow with Proxy:
══════════════════════
Scenario 1: Empty Username
──────────────────────────
User enters: username = "", password = "123456"
│
▼
LoginPage.buttonLoginActionPerformed()
│ └─→ loginservice.login("", "123456")
│
▼
LoginProxy.login()
├─ Check: username.isEmpty()? → YES
└─→ return false (without creating RealLoginService)
│
▼
LoginPage shows: "Invalid username or password"

Scenario 2: Valid Credentials (First Time)
───────────────────────────────────────────
User enters: username = "admin", password = "123456"
│
▼
loginservice.login("admin", "123456")
│
▼
LoginProxy.login()
├─ Check: isEmpty()? → NO
├─ Check: realLogin == null? → YES (first time)
├─→ realLogin = new RealLoginService() ← Lazy initialization
└─→ return realLogin.login("admin", "123456")
│
▼
RealLoginService.login()
├─ Check: username.equals("admin")? → YES
├─ Check: password.equals("123456")? → YES
└─→ return true
│
▼
LoginPage: Opens Dashboard

Scenario 3: Valid Credentials (Second Time)
────────────────────────────────────────────
loginservice.login("admin", "123456")
│
▼
LoginProxy.login()
├─ Check: isEmpty()? → NO
├─ Check: realLogin == null? → NO (already created)
└─→ return realLogin.login("admin", "123456")
└─→ Directly uses existing instance

📊 Usage in Code
// In LoginPage.java
public class LoginPage extends JFrame {
LoginService loginservice = new LoginProxy(); // ← Use proxy, not real service
private void buttonLoginActionPerformed(ActionEvent evt) {
String username = TextFieldUsername1.getText();
String password = jPasswordField1.getText();
// Call through proxy
if (loginservice.login(username, password)) {
JOptionPane.showMessageDialog(null, "Login Successful");
new Dashboard().setVisible(true);
this.dispose();
} else {
JOptionPane.showMessageDialog(null, "Invalid username or password");
}
}
} 5. Singleton Pattern
The Singleton Pattern is a creational design pattern that restricts the instantiation of a class to a single object. This is useful when exactly one object is needed to coordinate actions across the system, ensuring all components access the same shared resource.
🎯 Purpose
The Singleton Pattern ensures a class has only one instance and provides a global point of access to it. In our project, TaskManager is a singleton to ensure all GUI components access the same task list.
✅ Benefits in Our Project
Shared State: All GUI components see the same task list
Single Source of Truth: No data synchronization issues
Global Access: Easy access from any component
Memory Efficient: Only one instance exists

📐 Pattern Diagram
TaskManager (Singleton)
┌───────────────────────────────────────────┐
│ -instance: TaskManager (static) │
│ -tasks: List<TaskContext> │
│ -notificationObserver: NotificationObs │
├───────────────────────────────────────────┤
│ -TaskManager() (private constructor) │
│ +getInstance(): TaskManager (static) │
│ +addTask() │
│ +getAllTasks() │
│ +getTasksByState() │
└───────────────────────────────────────────┘
△ △ △
│ │ │
│ │ │
┌───────┘ │ └───────┐
│ │ │
┌──────────────┐ ┌─────────────┐ ┌─────────────┐
│ LoginPage │ │ Dashboard │ │AddTaskPage │
│ │ │ │ │ │
│ getInstance()│ │getInstance()│ │getInstance()│
└──────────────┘ └─────────────┘ └─────────────┘
│ │ │
└─────────────────┼─────────────────┘
Same TaskManager Instance

💻 Implementation Snippets
public class TaskManager {
// Static instance variable (only one exists)
private static TaskManager instance;
private List<TaskContext> tasks;
private NotificationObserver notificationObserver;

    // Private constructor prevents external instantiation
    private TaskManager() {
        tasks = new ArrayList<>();
        notificationObserver = new NotificationObserver("System");
    }

    // Global access point
    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager(); // Create once
        }
        return instance; // Always return same instance
    }

    // Business methods
    public void addTask(TaskContext task) {
        tasks.add(task);
        task.attach(notificationObserver);
    }
    public List<TaskContext> getAllTasks() {
        return new ArrayList<>(tasks);
    }
    public NotificationObserver getNotificationObserver() {
        return notificationObserver;
    }

}

🔄 How It Works in Our Project
Singleton Instance Creation and Access:
═══════════════════════════════════════
Application Start:
─────────────────
instance = null (static variable initialized)

First Access (from LoginPage or any component):
────────────────────────────────────────────────
Dashboard constructor calls:
│ └─→ TaskManager.getInstance()
│ ├─ Check: instance == null? → YES
│ ├─→ instance = new TaskManager()
│ │ ├─ tasks = new ArrayList<>()
│ │ └─ notificationObserver = new NotificationObserver("System")
│ └─→ return instance
│ └─→ Dashboard.taskManager = [TaskManager@1a2b3c]

Second Access (from AddTaskPage):
──────────────────────────────────
AddTaskPage constructor calls:
│ └─→ TaskManager.getInstance()
│ ├─ Check: instance == null? → NO (already created)
│ └─→ return instance
│ └─→ AddTaskPage.taskManager = [TaskManager@1a2b3c]
↑ Same memory address!

Result:
───────
Dashboard.taskManager === AddTaskPage.taskManager
↓
Both reference the SAME TaskManager instance
↓
Share the SAME task list and notification system

📊 Usage Across Components
// In Dashboard.java
public class Dashboard extends JFrame {
private TaskManager taskManager;
public Dashboard() {
initComponents();
taskManager = TaskManager.getInstance(); // Get singleton
}
private void ViewTaskButtonActionPerformed(ActionEvent evt) {
List<TaskContext> tasks = taskManager.getAllTasks(); // Access shared data
// ... display tasks
}
}
// In AddTaskPage.java
public class AddTaskPage extends JFrame {
private TaskManager taskManager;
public AddTaskPage() {
initComponents();
taskManager = TaskManager.getInstance(); // Same singleton
}
private void SaveButton1ActionPerformed(ActionEvent evt) {
taskManager.addTask(name, description, type); // Adds to shared list
}
}
// Both components see the same tasks!
🔍 Visualization
Memory Layout:
─────────────
┌─────────────────────────────────────────┐
│ Singleton Instance │
│ TaskManager@1a2b3c │
│ ┌───────────────────────────────────┐ │
│ │ tasks: ArrayList │ │
│ │ ├─ Task 1: "Fix login bug" │ │
│ │ ├─ Task 2: "Add dark mode" │ │
│ │ └─ Task 3: "Improve UI" │ │
│ │ │ │
│ │ notificationObserver │ │
│ │ └─ notificationLog (shared) │ │
│ └───────────────────────────────────┘ │
└─────────────────────────────────────────┘
▲ ▲
│ │
┌────────┴────────┐ ┌───────┴─────────┐
│ Dashboard │ │ AddTaskPage │
│ taskManager ──┘ │ taskManager ───┘
└─────────────────┘ └─────────────────┘
Both references point to the SAME object in memory