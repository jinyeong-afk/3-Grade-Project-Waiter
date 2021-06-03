/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.TemplateMethodPattern;

import DB.UserDAO;
import java.util.List;

/**
 *
 * @author 박성호
 */
public class DeleteTask extends AdministratorTask{
    

    @Override
    public void task(String id, String pw){
        UserDAO ud = new UserDAO();
        ud.DelInfo(id, pw);
        if(ud.isStore(id)){
            ud.DelStoreInfo(id);
        }
    }
    
    @Override
    public void result() {
        System.out.println( "사용자를 삭제하였습니다.");
       
    }
    
}
