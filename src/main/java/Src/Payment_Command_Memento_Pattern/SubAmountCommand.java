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
    Client client = new Client();
    public SubAmountCommand(int amountPaid, int amountNotPaid) { // 먹은 음식들의 값을 리스트로 받아온다.
        this.amountPaid = amountPaid;
        this.amountNotPaid = amountNotPaid;
    }
    @Override
    public String execute() {
        amountNotPaid = amountNotPaid - amountPaid;
       return Integer.toString(amountNotPaid);
    }
}
