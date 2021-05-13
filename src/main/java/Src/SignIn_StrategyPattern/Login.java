/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.SignIn_StrategyPattern;

/**
 *
 * @author qwe98
 */
public class Login {
    
    private LoginBehavior loginBehavior;
    
    public Login(LoginBehavior loginBehavior){
        this.loginBehavior = loginBehavior;
    }
    
    public int unLock(String id, String pw){
        return loginBehavior.login(id, pw);
    }
    
    public void setLoginBehavior(LoginBehavior loginBehavior){
        this.loginBehavior = loginBehavior;
    }
}
