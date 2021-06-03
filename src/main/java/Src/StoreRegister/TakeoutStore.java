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
public class TakeoutStore extends StoreRegister{
    

    @Override
    protected Store createStore(String id, String type) {
        switch(type){
            case "Cafe":
                return new TakeoutCoffeeStore(id);
            case "Bakery":
                return new TakeoutbakeryStore(id);
            default : 
                return null;
            }
    }
   
   
}
