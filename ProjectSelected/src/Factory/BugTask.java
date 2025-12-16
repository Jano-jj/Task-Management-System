/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import State.TaskContext;

/**
 *
 * @author Dell
 */
public class BugTask implements Task{

    @Override
    public String getTypeName() {
      return "Bug";
    }

    
}
