/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src;

/**
 *
 * @author qwe98
 */
public class SignUpBuilder {
    
    private int idx;
    private String id;
    private String pw;
    private String name;
    private String tel;
    private String address;
    private int balance;
    

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

    public SignUpBuilder setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public SignUpBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public SignUpBuilder setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public Member build(MemberType membertype){
        switch(membertype){
            case GUEST:
                return new Guest(idx, id, pw, name, tel, address, balance);
            
            default:
                return null;
        }
    }
    
}
