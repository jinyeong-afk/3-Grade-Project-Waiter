/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.StoreRegister;

/**
 *
 * @author sejin
 */
public class ForherebakeryStore extends Store {
        public ForherebakeryStore(String id){
            storename= "빵집";
            this.id = id;
            tabletype = "ForHere";
            storeaddress = "주소를 변경하세요";
            storetel = "전화번호를 변경하세요";
            open_time = 11;
            close_time = 22;
            max = 30;
    }
    
}
