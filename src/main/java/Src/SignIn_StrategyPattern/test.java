/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.SignIn_StrategyPattern;

import DB.LoginDTO;
import java.sql.SQLException;

/**
 *
 * @author 박성호
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        Login login = new Login(new GuestLoginBehavior());
        LoginDTO loginDTO = new LoginDTO();

//        System.out.println(login.unLock("G001", "123"));
        System.out.println(loginDTO.getIdx("M001", "123"));
//          if((login.unLock(loginDTO.getIdx("G001","123"), "G001", "123")) == 1){
//              System.out.println("성공");
//          }else
//              System.out.println("..");
    }
    
}
