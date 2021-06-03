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
public class ForhereStore extends StoreRegister{
    
    @Override
    public Store createStore(String id, String type) {
        switch(type){
            case "Cafe":
                System.out.println("forhere 커피 생성");
                return new ForhereCoffeeStore(id);
            case "Bakery":
                return new ForherebakeryStore(id);
            default : 
                return null;
            }
    }
    
}
