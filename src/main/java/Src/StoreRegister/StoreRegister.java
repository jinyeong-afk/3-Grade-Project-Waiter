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
   
    public abstract String getid();
    public abstract String getstoretype();
    public abstract String getstoreaddress();
    public abstract String getstoretel();
    public abstract int getopen_time();
    public abstract int getclose_time();
    public abstract int getmax();
    public abstract String getstorename();
    
    @Override
    public String toString(){
    return "id : "+getid() + "/ type : "+getstoretype()+" address : "+getstoreaddress()+" tel :"+getstoretel()
            + " open_time: " +getopen_time()+ " close_time: " + getclose_time()+ " 테이블 수: " + getmax();
    }
}