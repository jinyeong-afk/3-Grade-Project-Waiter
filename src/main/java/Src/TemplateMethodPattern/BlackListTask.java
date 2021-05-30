/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.TemplateMethodPattern;

import DB.UserDAO;

/**
 *
 * @author 박성호
 */
public class BlackListTask extends AdministratorTask{
    

    @Override
    public void task(String id, String pw) {
        UserDAO ud = new UserDAO();
        ud.blacklist(id, pw);
    }

    @Override
    public void result() {
        System.out.println( "사용자를 블랙리스트에 추가하였습니다.");
       
    }
}
