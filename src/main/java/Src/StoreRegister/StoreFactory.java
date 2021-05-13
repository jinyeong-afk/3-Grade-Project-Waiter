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
public class StoreFactory {
    public static StoreRegister getStore(String id, String tabletype, String storename, String storeaddress, String storetel, int open_time,
      int close_time, int max) {
        
       switch(tabletype){
        case "forhere":
            return new TableStore( id,  storename,  storeaddress,  storetel,  open_time, close_time,  max);
        case "takeout":
            return new TakeoutStore(id,  tabletype,  storename,  storeaddress,  storetel,  open_time, close_time,  max);
        default : 
            return null;
               }
}
}
