/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.SignIn_StrategyPattern;

import DB.LoginDTO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 박성호
 */
public class StoreManagerLoginBehavior implements LoginBehavior {//매장 관리자 화면으로 넘겨주기

    LoginDTO loginDTO = new LoginDTO();
    
    @Override
    public int login(String id, String pw){
        int flag = 0;
        try {
            if(loginDTO.getIdx(id, pw) == 2){
                if(loginDTO.checkLogin(2, id, pw)){
                flag = 2;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestLoginBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }  

}
