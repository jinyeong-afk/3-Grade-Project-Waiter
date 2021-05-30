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
public class Silver extends MembershipCardDecorator{
    Membership membership;
    
    public Silver(Membership membership)
    {
        this.membership = membership;
    }
    
    public String getType()
    {
        return membership.getType() + " Silver 10% 할인 적용";
    }
    
    public int pay()
    {
        return membership.pay() - (membership.pay() * 10 / 100);
    }
}
