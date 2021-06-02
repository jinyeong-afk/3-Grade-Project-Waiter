/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.SignUp_BuilderPattern;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author qwe98
 */
public class SignUpBuildertest {
    
    @Test
    public void Test(){
        System.out.println("BuilderPatternTest");
        
        SignUpProduct guestBuilder = new GuestBuilder()
                .setBalance(1000)
                .setIdx(1)
                .setId("test")
                .setPw("test")
                .setName("test")
                .setTel("010-1234-1234")
                .setAddress("부산")
                .build();
        
        assertEquals(guestBuilder.getIdx(), 1);
        assertEquals(guestBuilder.getId(),"test");
        assertEquals(guestBuilder.getPw(),"test");
        assertEquals(guestBuilder.getName(),"test");
        assertEquals(guestBuilder.getTel(),"010-1234-1234");
        assertEquals(guestBuilder.getAddress(),"부산");
        assertEquals(guestBuilder.getBalance(), 1000);
        
    }
}
