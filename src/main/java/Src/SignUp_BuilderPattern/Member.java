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
public class Member {
    
    protected int idx; // 1: 사용자, 2 : 매장 관리자, 3 : 시스템 관리자
    protected String id;
    protected String pw;
    protected String name;
    protected String address;
    protected String tel;
    protected int balance;
    protected String storetype;

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
