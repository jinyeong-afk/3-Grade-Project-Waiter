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
public abstract class Store {
    
    public abstract String getid();
    public abstract String getstoretype();
    public abstract String getstoreaddress();
    public abstract String getstoretel();
    public abstract int getopen_time();
    public abstract int getclose_time();
    public abstract int getmax();
    public abstract String getstorename();
    
}
