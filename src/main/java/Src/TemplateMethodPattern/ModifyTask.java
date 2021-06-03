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
// 정보 수정 작업
public class ModifyTask extends AdministratorTask{


    @Override
    public void task(String id, String pw) {
        UserDAO ud = new UserDAO();
        ud.ModifyInfo(id, pw); // ID와 PW를 활용하여 정보를 변경한다.
    }

    @Override
    public void result() {  // 변경된 정보를 반영한다.
        System.out.println( "사용자 정보를 수정하였습니다.");
       
    }
}
