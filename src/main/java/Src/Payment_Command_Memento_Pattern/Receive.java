/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Payment_Command_Memento_Pattern;

import java.util.ArrayList;

/**
 *
 * @author jin
 */
public class Receive{ // 요구 사항을 수행한다
    String receive;
    int sum = 0;
    public String pay(){ // 결제를 시작할 때
        receive = "결제를 진행합니다.";
        return receive;
    }
    
    public String completion(int AmountNotPaid, String paymentType){
         String returnValue ="";
         int payCheck = 0;
        if(AmountNotPaid < 0)
        {
            if(paymentType.equals("card"))
            {
                receive = "결제 오류가 발생했습니다." + "," + payCheck;
                return receive;
            }
            else if(paymentType.equals("cash"))
            {
                payCheck = 1; // 결제 확인을 set 해준다
                receive = "결제를 종료합니다."  + "," + payCheck;
                return receive;
            }
        }
        else if(AmountNotPaid > 0)
        {
            receive = "금액이 모자랍니다." + "," + payCheck;
            return receive;
        }
        else if(AmountNotPaid == 0)
        {
            payCheck = 1; // 결제 확인을 set 해준다
            receive = "결제를 종료합니다." + "," + payCheck;
            return receive;
        }
        return receive;
    }
    public String addAmount(ArrayList<Integer> allprice){ // AddAmountPaidCommand 동작
        sum = allprice.stream().mapToInt(Integer::intValue).sum();
        receive = Integer.toString(sum);
        return receive;
    }
    public String subAmount(int amountPaid, int amountNotPaid){ //SubAmountPaidCommand 동작
        amountNotPaid = amountNotPaid - amountPaid;
        receive = Integer.toString(amountNotPaid);
        return receive;
    }
}
