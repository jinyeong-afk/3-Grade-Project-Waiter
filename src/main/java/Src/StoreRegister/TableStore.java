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
public class TableStore extends StoreRegister {
    
    private String id;
    private String tabletype;
    private String storename;
    private String storeaddress;
    private String storetel; 
    private int open_time;
    private int close_time;
    private int max_table;   
    
    public TableStore(String id, String storename, String storeaddress, String storetel, int open_time,
      int close_time, int max_table){
        this.id = id;
        this.tabletype = "forHere";
        this.storename = storename;
        this.storeaddress = storeaddress;
        this.storetel = storetel;
        this.open_time = open_time;
        this.close_time = close_time;
        this.max_table = max_table;
    }
    
    @Override
    public String getid() { return this.id; };
    @Override
    public String getstorename() { return this.storename; };
    @Override
    public  String getstoretype() { return this.tabletype; };
    @Override
    public  String getstoreaddress(){ return this.storeaddress; };
    @Override
    public  String getstoretel(){ return this.storetel; };
    @Override
    public  int getopen_time(){ return this.open_time; };
    @Override
    public  int getclose_time(){ return this.close_time; };
    @Override
    public  int getmax(){ return this.max_table; };
    

}
