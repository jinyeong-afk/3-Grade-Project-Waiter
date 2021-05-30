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
public abstract class Store {
    protected String id;
    protected String tabletype;
    protected String storename;
    protected String storeaddress;
    protected String storetel; 
    protected int open_time;
    protected int close_time;
    protected int max;   
    
   
    public String getid() { return this.id; };

    public String getstorename() { return this.storename; };
  
    public  String getstoretype() { return this.tabletype; };
 
    public  String getstoreaddress(){ return this.storeaddress; };
  
    public  String getstoretel(){ return this.storetel; };
   
    public  int getopen_time(){ return this.open_time; };
  
    public  int getclose_time(){ return this.close_time; };
   
    public  int getmax(){ return this.max; };
    
    public void prepare() {
    System.out.print("테이블 셋팅 완료");
    };
    
}
