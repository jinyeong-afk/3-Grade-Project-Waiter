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
    protected int table_set;
    protected int takeout_set;
    protected int open_time;
    protected int close_time;

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

    public int getTable_set() {
        return table_set;
    }

    public int getTakeout_set() {
        return takeout_set;
    }

    public int getOpen_time() {
        return open_time;
    }

    public int getClose_time() {
        return close_time;
    }
    
    
}
