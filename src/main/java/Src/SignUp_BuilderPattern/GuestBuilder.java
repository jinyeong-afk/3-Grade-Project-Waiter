/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.SignUp_BuilderPattern;

/**
 *
 * @author 박성호
 */
public class GuestBuilder extends MemberBuilder{
    
    protected int balance;
    
//    public GuestBuilder(int idx, String id, String pw, String name, String tel, String address, int balance){
//        this.idx = idx;
//        this.id = id;
//        this.pw = pw;
//        this.name = name;
//        this.tel = tel;
//        this.address = address;
//        this.balance = balance;
//    }

    public GuestBuilder setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public int getBalance() {
        return balance;
    }
    
    
    @Override
    public SignUpProduct build(){
        
        return new SignUpProduct(this);
    }
  
}
