/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author Dell
 */
public class taskFactory {
    public static Task createTask(String type) {
        switch (type) {
            case "Bug":
                return new BugTask();
            case "Feature":
                return new FeatureTask();
            case "Improvement":
                return new ImprovementTask();
            default:
                throw new IllegalArgumentException("Unknown task type");
        }
    }
}
