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
public class Receive{ // 요구 사항을 수행한다
    String receive;
    public String pay(){ // 결제를 시작할 때
        receive = "결제를 진행합니다.";
        return receive;
    }
    public String completion(){ // 결제를 완료했을 때
        receive = "결제를 종료합니다.";
        return receive;
    }
    public String payAgain() {
        receive = "금액이 모자랍니다.";
        return receive;
    }
    public String payError(){
        System.out.println("결제 오류가 발생했습니다.");
        receive = "결제 오류가 발생했습니다.";
        return receive;
    }
}
