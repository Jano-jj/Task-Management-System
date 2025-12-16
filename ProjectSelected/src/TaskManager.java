/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

/**
 *
 * @author A1
 */
public class TaskManager {

    private NotificationService notificationService;

    public TaskManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void addTask(String taskName) {
        System.out.println("Task added: " + taskName);
        notificationService.sendNotification(
            "New Task Created: " + taskName
        );
    }
}


