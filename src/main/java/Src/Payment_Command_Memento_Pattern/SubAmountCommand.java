/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Payment_Command_Memento_Pattern;

import Src.Payment_Command_Memento_Pattern.Client;

/**
 *
 * @author jin
 */
public class SubAmountCommand implements PaymentCommand { // 먹은 음식 값에서 지불 금액을 빼는 커맨드
    public int amountPaid, amountNotPaid;
    Receive receive;
    public SubAmountCommand(int amountPaid, int amountNotPaid, Receive receive) { // 지불하는 금액과 결제해야 하는 금액을 가져온다.
        this.amountPaid = amountPaid;
        this.amountNotPaid = amountNotPaid;
        this.receive = receive;
    }
    @Override
    public String execute() {
        return receive.subAmount(amountPaid, amountNotPaid);
    }
}
