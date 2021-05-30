/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Payment_Command_Memento_Pattern;

/**
 *
 * @author 송진영
 */
public class PaymentMemento {
    static int AmountPaid_2; // 결제된 금액
    static int AmountNotPaid_2; // 결제 안된 금액
    static int payCheck_2; // 결제 확인

    public PaymentMemento(int AmountPaid, int AmountNotPaid, int payCheck)
    {
        this.AmountPaid_2 = AmountPaid;
        this.AmountNotPaid_2 = AmountNotPaid;
        this.payCheck_2 = payCheck;
    }
    
    public int getAmountPaid() {
        return this.AmountPaid_2;
    }

    public int getAmountNotPaid() {
        return this.AmountNotPaid_2;
    }

    public int getPayCheck() {
        return this.payCheck_2;
    }

    
}
