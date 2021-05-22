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
    Client client = new Client();
    CareTaker careTaker = new CareTaker();
    int AmountNotPaid = client.getAmountNotPaid();
    String paymentType = client.getPaymentType();
    int payCheck = 0;
    public CompletionCommand(Receive receive, int AmountNotPaid, String paymentType) { // receive 클래스를 넘겨받는다.
        this.receive = receive;
        this.AmountNotPaid = AmountNotPaid;
        this.paymentType = paymentType;
    }
    
    @Override
    public String execute() {
        String returnValue ="";
        if(AmountNotPaid < 0)
        {
            if(paymentType.equals("card"))
            {
                returnValue = receive.payError() + "," + payCheck;
            }
            else if(paymentType.equals("cash"))
            {
                payCheck = 1; // 결제 확인을 set 해준다
                returnValue = receive.completion() + "," + payCheck;
            }
        }
        else if(AmountNotPaid > 0)
        {
            returnValue = receive.payAgain() + "," + payCheck;
        }
        else if(AmountNotPaid == 0)
        {
            payCheck = 1; // 결제 확인을 set 해준다
            returnValue = receive.completion() + "," + payCheck;
        }
        return returnValue;
    }

}

