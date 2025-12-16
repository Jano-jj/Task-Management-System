/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project1;

/**
 *
 * @author A1
 */
public class Project1 {

    public static void main(String[] args) {

        // 1) Create the legacy system (Adaptee)
        OldLegacyNotifier legacy = new OldLegacyNotifier();

        // 2) Create the adapter (Adapter)
        NotificationService notification =
                new NotificationAdapter(legacy);

        // 3) Client depends only on the interface
        TaskManager manager =
                new TaskManager(notification);

        // 4) Perform action
        manager.addTask("Fix login bug");
    }
}


