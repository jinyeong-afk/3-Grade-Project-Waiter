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
public abstract class AdministratorTask { // 공통된 로직을 구현할 추상 클래스

    String userId;
    String userPw;
    
    final void batchTask(String id, String pw){
        
        setIdPw(id, pw);  // ID, 패스워드를 입력하고
        task(userId, userPw);  // ID, PW를 가지고 공통된 로직 실행
        result(); // 로직의 결과값 출력
    }
    
    public void setIdPw(String id, String pw){
        this.userId = id;
        this.userPw = pw;
    }
    
    abstract void task(String id, String pw);
    abstract void result();
}
