/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.TemplateMethodPattern;

import DB.UserDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 박성호
 */
public abstract class AdministratorTask {

    String userId;
    String userPw;
    
    final void batchTask(String id, String pw){
        
        setIdPw(id, pw);
        task(userId, userPw);
        result();
    }
    
    public void setIdPw(String id, String pw){
        this.userId = id;
        this.userPw = pw;
    }
    
    abstract void task(String id, String pw);
    abstract void result();
}
