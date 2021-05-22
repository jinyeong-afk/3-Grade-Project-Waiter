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
public class AddAmountCommand implements PaymentCommand { // 먹은 음식들의 가격을 더하는 커멘드
    int sum = 0;
    Client client = new Client();
    CareTaker careTaker = new CareTaker();
    ArrayList<Integer> allprice = new ArrayList<>();
    public AddAmountCommand(ArrayList<Integer> allprice) { // 먹은 음식들의 값을 리스트로 받아온다.
        this.allprice = allprice;
    }
    
    @Override
    public String execute() { // 리스트의 값들을 다 더해준다.
        sum = allprice.stream().mapToInt(Integer::intValue).sum();
        
        return Integer.toString(sum);
    }

}