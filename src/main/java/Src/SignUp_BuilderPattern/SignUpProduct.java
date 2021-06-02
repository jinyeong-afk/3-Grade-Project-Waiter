/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.SignUp_BuilderPattern;

import DB.MemberDAO;

/**
 *
 * @author 박성호
 */
public class SignUpProduct {

    private final int idx; // 1: 사용자, 2 : 매장 관리자, 3 : 시스템 관리자
    private final String id;
    private final String pw;
    private final String name;
    private final String address;
    private final String tel;

    private int balance;
    private String storetype;

    public SignUpProduct(GuestBuilder builder) {
        this.idx = builder.idx;
        this.id = builder.id;
        this.pw = builder.pw;
        this.name = builder.name;
        this.tel = builder.tel;
        this.address = builder.address;
        this.balance = builder.balance;
    }

    public SignUpProduct(StoreManagerBuilder builder) {
        this.idx = builder.idx;
        this.id = builder.id;
        this.pw = builder.pw;
        this.name = builder.name;
        this.address = builder.address;
        this.tel = builder.tel;
        this.storetype = builder.storetype;
    }

    public void SignUp(int index) {  //DB 에 값 주입
        MemberDAO md = new MemberDAO();
        if (index == 1) { // 손님 회원가입
            md.signUpGuest(this.idx, this.id, this.pw, this.name, this.tel, this.address, this.balance);
        } else if(index == 2){  // 매니저 회원가입
            md.signUpStoreManager(this.idx, this.id, this.pw, this.name, this.tel, this.address, this.storetype);
        }
    }

    public int getIdx() {
        return idx;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public int getBalance() {
        return balance;
    }

    public String getStoretype() {
        return storetype;
    }
    
    
}
