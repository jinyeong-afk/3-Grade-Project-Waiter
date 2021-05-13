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
public class test {
    
    public static void main(String[] args) {
        StoreRegister table = StoreFactory.getStore("asd123", "table", "김밥집", "부산시 사하구", "0105215231", 9, 18, 30);
        StoreRegister takeout =  StoreFactory.getStore("qwe345", "takeout", "빵집", "부산시 남구", "01099997777", 9, 18, 1000);
        System.out.println("Factory table::"+table);
        System.out.println("Factory takeout::"+takeout);
        
    }
}