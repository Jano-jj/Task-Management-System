package Observer;

import State.TaskContext;
import javax.swing.JTextArea;

/**
 * Concrete Observer: UI Update Observer
 * Updates GUI components when tasks change state
 */
public class UIObserver implements TaskObserver {
    private JTextArea displayArea;
    
    public UIObserver(JTextArea displayArea) {
        this.displayArea = displayArea;
    }
    
    @Override
    public void update(TaskContext task) {
        if (displayArea != null) {
            String currentText = displayArea.getText();
            displayArea.setText(currentText + "\nTask Updated: " + task.toString());
        }
    }
    
    public void setDisplayArea(JTextArea displayArea) {
        this.displayArea = displayArea;
    }
}
