/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.MembershipDecoratorPattern;

/**
 *
 * @author 송진영
 */
public class Guest extends Membership{
    private int price;
    public Guest(int price)
    {
        this.price = price;
    }
    public int pay()
    {
        return price;
    }
    public String getType()
    {
        return "고객님의 등급으로 인해";
    }
}
