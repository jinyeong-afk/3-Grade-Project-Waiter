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
public class Invoke { // 커맨드를 넘겨받아서 실행할 커맨드를 지정해준다
    public PaymentCommand command;
 
    public Invoke(PaymentCommand command){
        this.command = command;
    }
    public void setCommand(PaymentCommand command){ // 커맨드 지정
        this.command = command;
    }
    public String pressed() { // 버튼을 눌렀을 때 커맨드 실행
        return command.execute();
    }

}
