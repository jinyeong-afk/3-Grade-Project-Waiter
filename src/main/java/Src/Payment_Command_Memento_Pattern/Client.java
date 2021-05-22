/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Payment_Command_Memento_Pattern;

import java.util.ArrayList;

/**
 *
 * @author 송진영
 */
public class Client { // 고객의 정보를 가져옴

    private int AmountPaid; // 결제된 금액
    private int AmountNotPaid; // 결제 안된 금액
    private int payCheck; // 결제 확인
    private String PaymentType; // 결제 유형
    private String ID; // 고객 아이디
    ArrayList<Integer> allprice = new ArrayList<>();

    public PaymentMemento CreateMemento() // PaymentMemento를 생성(상태 저장)
    {
        return new PaymentMemento(this.AmountPaid, this.AmountNotPaid, this.payCheck);
    }
    
    public void RestorMemento(PaymentMemento memento) // PaymentMemento를 복원(상태 복원)
    {
        this.AmountPaid = memento.getAmountPaid();
        this.AmountNotPaid = memento.getAmountNotPaid();
        this.payCheck = memento.getPayCheck();
    }
    
    public int getPayCheck() {
        return payCheck;
    }

    public void setPayCheck(int payCheck) {
        this.payCheck = payCheck;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    } 

    public String getID() {
        return ID;
    }

    public void setAllprice(ArrayList<Integer> allprice) {
        this.allprice = allprice;
    }

    public ArrayList<Integer> getAllprice() {
        return allprice;
    }
    
    public void setAmountPaid(int AmountPaid) {
        this.AmountPaid = AmountPaid;
    }

    public void setAmountNotPaid(int AmountNotPaid) {
        this.AmountNotPaid = AmountNotPaid;
    }

    public void setPaymentType(String PaymentType) {
        this.PaymentType = PaymentType;
    }

    public int getAmountPaid() {
        return this.AmountPaid;
    }

    public int getAmountNotPaid() {
        return this.AmountNotPaid;
    }

    public String getPaymentType() {
        return this.PaymentType;
    }
    

}
