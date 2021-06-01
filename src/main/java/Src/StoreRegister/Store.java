/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.StoreRegister;

import DB.StoreDAO;
import javafx.scene.control.Alert;

/**
 *
 * @author sejin
 */
public abstract class Store {
    protected String id;
    protected String tabletype;
    protected String storename;
    protected String storeaddress;
    protected String storetel; 
    protected int open_time;
    protected int close_time;
    protected int max;   
     private StoreDAO sd = new StoreDAO();
   
    public String getid() { return this.id; };

    public String getstorename() { return this.storename; };
  
    public  String getstoretype() { return this.tabletype; };
 
    public  String getstoreaddress(){ return this.storeaddress; };
  
    public  String getstoretel(){ return this.storetel; };
   
    public  int getopen_time(){ return this.open_time; };
  
    public  int getclose_time(){ return this.close_time; };
   
    public  int getmax(){ return this.max; };
    
  
    public void Business_registration (){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("음식 예약 프로그램 : Waiter");
        alert.setHeaderText(null);
        alert.setContentText("사업자 등록증 확인 완료");
        alert.showAndWait();
        System.out.println("사업자 등록증 확인 완료");
    };

   
    public void store_view_check() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("음식 예약 프로그램 : Waiter");
        alert.setHeaderText(null);
        alert.setContentText("매장 사진 확인 완료");
        alert.showAndWait();
        System.out.println("매장 사진 확인 완료");
      
    };
       public void dbsignup() {
      sd.signUpStore(id, tabletype, storename, storetel, storeaddress, open_time, close_time, max);
    };
    
}
