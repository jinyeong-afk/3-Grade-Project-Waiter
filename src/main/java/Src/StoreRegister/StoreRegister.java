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
public abstract class StoreRegister {

    public abstract Store createStore(String id, String tabletype, String storename, String storeaddress, String storetel, int open_time,
      int close_time, int max);

}