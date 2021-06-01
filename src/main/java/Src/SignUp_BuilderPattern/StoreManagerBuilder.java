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
public class StoreManagerBuilder extends MemberBuilder{
    
    protected String storetype;
    
    public StoreManagerBuilder setStoretype(String storetype) {
        this.storetype = storetype;
        return this;
    }
    
       @Override
    public SignUpProduct build(){
        
        return new SignUpProduct(this);
    } 
}
