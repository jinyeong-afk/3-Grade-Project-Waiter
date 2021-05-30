/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.StoreRegister;

/**
 *
 * @author 허세진
 */
public class test {
    
      public static void main(String[] args) {
              
        StoreFactory sf = new StoreFactory();
		
        Store table = sf.createStore("asd123", "forhere", "김밥집", "부산시 사하구", "0105215231", 9, 18, 30);
        Store takeout =  sf.createStore("qwe345", "takeout", "빵집", "부산시 남구", "01099997777", 9, 18, 1000);
      
        System.out.println("Factory table::" + table.getstorename());
        System.out.println("Factory takeout::" + takeout.getstorename());
        
    }
   
  
        
}