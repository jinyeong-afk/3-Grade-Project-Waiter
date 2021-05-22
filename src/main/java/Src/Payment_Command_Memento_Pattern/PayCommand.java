/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Payment_Command_Memento_Pattern;

/**
 *
 * @author jin
 */
public class PayCommand implements PaymentCommand { // 결제 시작할 때 커맨드
    public Receive receive;
    
    public PayCommand(Receive receive) { // receive 클래스를 넘겨받는다
        this.receive = receive;
    }
    
    @Override
    public String execute() { 
        return receive.pay();
    }

}
