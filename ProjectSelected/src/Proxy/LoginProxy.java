/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

/**
 *
 * @author Dell
 */
public class LoginProxy implements LoginService{
private RealLoginService realLogin;
    @Override
    public boolean login(String username, String password) {
       if (username.isEmpty() || password.isEmpty()){
           return false;
       }
       if (realLogin == null){
           realLogin = new RealLoginService();
       }
         return realLogin.login(username, password);
    }
    
    
    
}
