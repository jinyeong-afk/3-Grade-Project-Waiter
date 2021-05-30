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
          StoreRegister Takeout = new TakeoutStore();
          StoreRegister Forhere = new ForhereStore();
          
          Store store = Takeout.RegisterStore("asd123", "Coffee");
          System.out.println(store.getstorename()); 
          store.prepare();
          
          store = Takeout.RegisterStore("asd1224", "Bakery");
          System.out.println(store.getstorename()); 
          store.prepare();
          
          store = Forhere.RegisterStore("asd123", "Coffee");
          System.out.println(store.getstorename()); 
          store.prepare();
          
          store = Forhere.RegisterStore("asd124", "Bakery");
          System.out.println(store.getstorename()); 
          store.prepare();
          
          
          
        
    }
   
  
        
}