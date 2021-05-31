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
public class CompletionCommand implements PaymentCommand { // 결제 완료했을 때 커맨드
    public Receive receive;
    int AmountNotPaid;
    String paymentType;
    
    public CompletionCommand(Receive receive, int AmountNotPaid, String paymentType) { // receive 클래스를 넘겨받는다.
        this.receive = receive;
        this.AmountNotPaid = AmountNotPaid;
        this.paymentType = paymentType;
    }
    
    @Override
    public String execute() {
        return receive.completion(AmountNotPaid, paymentType);
    }

}

