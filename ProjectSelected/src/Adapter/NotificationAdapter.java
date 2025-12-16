/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

/**
 *
 * @author A1
 */
public class NotificationAdapter implements NotificationService {

    private OldLegacyNotifier oldNotifier;

    public NotificationAdapter(OldLegacyNotifier oldNotifier) {
        this.oldNotifier = oldNotifier;
    }

    @Override
    public void sendNotification(String message) {
        
        oldNotifier.pushMessage(message);
    }
}
    

