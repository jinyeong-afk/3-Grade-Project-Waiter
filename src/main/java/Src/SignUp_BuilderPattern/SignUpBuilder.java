/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.SignUp_BuilderPattern;

/**
 *
 * @author qwe98
 */
public class SignUpBuilder {
    
    private int idx; // 1: 사용자, 2 : 매장 관리자, 3 : 시스템 관리자
    private String id;
    private String pw;
    private String name;
    private String address;
    private String tel;
    private int balance;
    private int table_set;
    private int takeout_set;
    private int open_time;
    private int close_time;

    public SignUpBuilder setIdx(int idx) {
        this.idx = idx;
        return this;
    }

    public SignUpBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public SignUpBuilder setPw(String pw) {
        this.pw = pw;
        return this;
    }

    public SignUpBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SignUpBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public SignUpBuilder setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public SignUpBuilder setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public SignUpBuilder setTable_set(int table_set) {
        this.table_set = table_set;
        return this;
    }

    public SignUpBuilder setTakeout_set(int takeout_set) {
        this.takeout_set = takeout_set;
        return this;
    }

    public SignUpBuilder setOpen_time(int open_time) {
        this.open_time = open_time;
        return this;
    }

    public SignUpBuilder setClose_time(int close_time) {
        this.close_time = close_time;
        return this;
    }
    
    

    public Member build(MemberType membertype){
        switch(membertype){
            case GUEST:
                return new Guest(idx, id, pw, name, tel, address, balance);
                
            case STOREMANAGER:
                return new StoreManager(idx, id, pw, name, tel, address, table_set, takeout_set, open_time, close_time);
            
            default:
                return null;
        }
    }
    
}
