/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import Manager.TaskManager;
import State.TaskContext;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Dashboard extends javax.swing.JFrame {

    private TaskManager taskManager;
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        taskManager = TaskManager.getInstance();
    }

   
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        AddTaskButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        NotificationButton = new javax.swing.JButton();
        ViewTaskButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        AddTaskButton.setBackground(new java.awt.Color(102, 102, 255));
        AddTaskButton.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        AddTaskButton.setForeground(new java.awt.Color(255, 255, 255));
        AddTaskButton.setText("Add Task");
        AddTaskButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTaskButtonActionPerformed(evt);
            }
        });

        LogoutButton.setBackground(new java.awt.Color(102, 102, 255));
        LogoutButton.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogoutButton.setText("Logout");
        LogoutButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        NotificationButton.setBackground(new java.awt.Color(102, 102, 255));
        NotificationButton.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        NotificationButton.setForeground(new java.awt.Color(255, 255, 255));
        NotificationButton.setText("Notification");
        NotificationButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NotificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificationButtonActionPerformed(evt);
            }
        });

        ViewTaskButton.setBackground(new java.awt.Color(102, 102, 255));
        ViewTaskButton.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        ViewTaskButton.setForeground(new java.awt.Color(255, 255, 255));
        ViewTaskButton.setText("View Task");
        ViewTaskButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ViewTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewTaskButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Task Management system");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(AddTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NotificationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(ViewTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(495, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NotificationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(317, Short.MAX_VALUE)
                    .addComponent(ViewTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(105, 105, 105)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTaskButtonActionPerformed
      new AddTaskPage().setVisible(true);
          this.dispose();
    }//GEN-LAST:event_AddTaskButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void NotificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificationButtonActionPerformed
        String notifications = taskManager.getNotificationObserver().getNotificationLog();
        
        if (notifications.isEmpty()) {
            notifications = "No notifications yet.\nTasks state changes will appear here.";
        }
        
        JOptionPane.showMessageDialog(this, 
            notifications, 
            "Task Notifications (Observer Pattern)", 
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_NotificationButtonActionPerformed

    private void ViewTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewTaskButtonActionPerformed
        java.util.List<TaskContext> tasks = taskManager.getAllTasks();
        
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "No tasks available.\nUse 'Add Task' to create tasks.", 
                "View Tasks", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String[] taskOptions = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            TaskContext task = tasks.get(i);
            taskOptions[i] = String.format("[%s] %s", 
                task.getState().getStateName(), 
                task.getTaskName());
        }
        
        String selectedTask = (String) JOptionPane.showInputDialog(this,
            "Select a task to change its state:\n(State Pattern Demonstration)",
            "View Tasks",
            JOptionPane.QUESTION_MESSAGE,
            null,
            taskOptions,
            taskOptions[0]);
        
        if (selectedTask != null) {
            int selectedIndex = java.util.Arrays.asList(taskOptions).indexOf(selectedTask);
            TaskContext task = tasks.get(selectedIndex);
            
            int choice = JOptionPane.showConfirmDialog(this,
                "Task: " + task.getTaskName() + "\n" +
                "Description: " + task.getTaskDescription() + "\n" +
                "Current State: " + task.getState().getStateName() + "\n" +
                "Type: "+ task.getTaskType() +"\n\n" +
                "Move to next state?",
                "Task Details",
                JOptionPane.YES_NO_OPTION);
            
            if (choice == JOptionPane.YES_OPTION) {
                String oldState = task.getState().getStateName();
                task.nextState();
                String newState = task.getState().getStateName();
                
                JOptionPane.showMessageDialog(this,
                    "Task state updated!\n" +
                    "From: " + oldState + "\n" +
                    "To: " + newState + "\n\n" +
                    "Check Notifications to see Observer pattern in action!",
                    "State Changed",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_ViewTaskButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTaskButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton NotificationButton;
    private javax.swing.JButton ViewTaskButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
