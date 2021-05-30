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
public abstract class StoreRegister {

    protected abstract Store createStore(String id, String type);
    public Store RegisterStore(String id, String type){
        Store new_store = createStore(id, type);
        System.out.println("매장 생성");
        return new_store;
    }

}