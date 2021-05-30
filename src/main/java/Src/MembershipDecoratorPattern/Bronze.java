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
public class Bronze extends MembershipCardDecorator 
{
    Membership membership;
    
    public Bronze(Membership membership)
    {
        this.membership = membership;
    }
    
    public String getType()
    {
        return membership.getType() + " Bronze 1% 할인 적용";
    }
    
    public int pay()
    {
        return membership.pay() - (membership.pay() * 1 / 100);
    }
}
