/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

/**
 *
 * @author Dell
 */
public class RealLoginService implements LoginService{

    @Override
    public boolean login(String username, String password) {
        return username.equals("admin") && password.equals("123456");
    }
    
    
}
