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

// 정보 삭제 작업
public class DeleteTask extends AdministratorTask{
    
    @Override
    public void task(String id, String pw){
        UserDAO ud = new UserDAO();
        ud.DelInfo(id, pw); // ID와 PW 값을 받아 DB에서 해당하는 정보를 삭제한다.
        if(ud.isStore(id)){  // 만약 매장 관리자의 계정이면
            ud.DelStoreInfo(id);  // 매장의 정보 또한 DB로부터 삭제한다.
        }
    }
    
    @Override
    public void result() {  // 작업에 대한 결과를 출력한다.
        System.out.println( "사용자를 삭제하였습니다.");
       
    }
    
}
