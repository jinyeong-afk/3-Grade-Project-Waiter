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
public abstract class MemberBuilder {
    
    protected int idx; //구현 빌더 클래스에 필요한 공통적인 요소
    protected String id;
    protected String pw;
    protected String name;
    protected String address;
    protected String tel;

    public MemberBuilder setIdx(int idx) {
        this.idx = idx;
        return this;
    }

    public MemberBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public MemberBuilder setPw(String pw) {
        this.pw = pw;
        return this;
    }

    public MemberBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MemberBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public MemberBuilder setTel(String tel) {
        this.tel = tel;
        return this;
    }
    
    
    public abstract SignUpProduct build();
}
