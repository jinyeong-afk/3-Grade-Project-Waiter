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
abstract public class Membership {
    private int price;
    private String type;
    abstract public int pay();
    abstract public String getType();
}
