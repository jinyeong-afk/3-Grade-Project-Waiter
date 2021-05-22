/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Payment_Command_Memento_Pattern;

import java.util.Stack;

/**
 *
 * @author jin
 */
public class CareTaker {
    static Stack<PaymentMemento> mementos = new Stack<>(); //PaymentMemento 관리를 위한 Stack
    
    public void push(PaymentMemento memento) // 특정 시점에 생성된 Memento를 Push
    {
        mementos.push(memento);
    }
    
    public PaymentMemento pop() // 복원을 위한 PaymentMemento 객체 반환
    {
        return mementos.pop();
    }
}
