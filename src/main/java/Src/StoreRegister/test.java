/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.StoreRegister;

import java.util.Scanner;

/**
 *
 * @author sejin
 */
public class test {
    
      public static void main(String[] args) {
          
        String id;
        int type;
        String storetitle;
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요 :");
        StoreRegister Forhere = new ForhereStore();
        StoreRegister Takeout = new TakeoutStore();
        Store store=null;
        
        id = sc.next();
        
        System.out.print("매장 type을 입력하세요 (1)\"takeout\" or (2)s\"forhere\"  :");
        type = sc.nextInt();
        if(type==1){
            System.out.print("매장 title을 입력하세요 \"Coffee\" or \"Bakery\"  :");
            storetitle = sc.next();
            store = Takeout.RegisterStore(id, storetitle);
        }
        else if(type==2){
            System.out.print("매장 title을 입력하세요 \"Coffee\" or \"Bakery\"  :");
            storetitle = sc.next();
            store = Forhere.RegisterStore(id, storetitle);
        }
        
        
        
         System.out.println("매장 이름 : " + store.getstorename());
         System.out.println("매장 타입 : " + store.getstoretype());
         System.out.println("매장 주소 : " + store.getstoreaddress());
         System.out.println("매장 번호 : " + store.getstoretel());
         System.out.println("오픈 시간 : " + store.getopen_time());
         System.out.println("마감 시간 : " + store.getclose_time());

        
   
          
        
    }
   
  
        
}