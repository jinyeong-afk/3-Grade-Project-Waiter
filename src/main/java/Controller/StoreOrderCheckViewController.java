/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.IntroViewController.getField;
import DB.DTO;
import DB.LoginDTO;
import Src.Payment_Command_Memento_Pattern.AddAmountCommand;
import Src.Payment_Command_Memento_Pattern.CareTaker;
import Src.Payment_Command_Memento_Pattern.Client;
import Src.Payment_Command_Memento_Pattern.CompletionCommand;
import Src.Payment_Command_Memento_Pattern.Invoke;
import Src.Payment_Command_Memento_Pattern.PayCommand;
import Src.Payment_Command_Memento_Pattern.Receive;
import Src.Payment_Command_Memento_Pattern.SubAmountCommand;
import Src.ReservationConfirm_Observer.ReservationData;
import Src.ReservationConfirm_Observer.WaitingNumberDisplay;
import Src.ReservationConfirm_Observer.WaitingTimeDisplay;
import Src.ReservationConfirm_Observer.TableDisplay;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author 박성호, 허세진
 */
public class StoreOrderCheckViewController implements Initializable{
    
    @FXML
    private Button btn_table_check;
    @FXML
    private Button btn_pay_card;
    @FXML
    private Button btn_pay_cash;
    @FXML
    private ListView<String>list_now_table;
    @FXML
    private ListView list_menuname;
    @FXML
    private ListView list_price;
    @FXML
    private TextField field_total_price;
    @FXML
    private TextField field_registor_price;
    @FXML
    private TextField field_give_card;
    @FXML
    private TextField field_give_cash;
    @FXML
    private TextField field_table_check;
    private ObservableList<String> cGuestList;
    
    LoginDTO LD = new LoginDTO();
        String allprice_query, allprice_value, allprice_value2, id;
        String store_name = "";
     
        ArrayList<Integer> allprice = new ArrayList<>();
        Client client = new Client();
        DTO db = new DTO();
        Receive receive = new Receive();
        
        PayCommand payCommand = new PayCommand(receive);
        CareTaker careTaker = new CareTaker();
    
        String store_id = IntroViewController.getField;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ReservationData reservationInfo = new ReservationData();        
        //ReservationDisplay d1 = new ReservationDisplay(reservationInfo);

        TableDisplay d4 = new TableDisplay(reservationInfo);
        
        try {
            reservationInfo.setReservation(IntroViewController.getField);
        } catch (SQLException ex) {
            Logger.getLogger(StoreOrderCheckViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          cGuestList = FXCollections.observableArrayList(); 
          
         for(int i = 0; i < d4.display(getField).size();i++){
             cGuestList.add(d4.display(getField).get(i));
         }
        list_now_table.setItems(cGuestList);
        
        list_now_table.setOnMouseClicked(new EventHandler<MouseEvent>() {  //현재 테이블 클릭시 테이블 필드에 테이블 값이 set 된다.
                @Override
                public void handle(MouseEvent event) {
                Object obj = list_now_table.getSelectionModel().getSelectedItem();
                field_table_check.setText(obj.toString());
                
                }
        });
        
        btn_table_check.setOnMouseClicked(new EventHandler<MouseEvent>() { // 테이블 조회 버튼 클릭시
            @Override
            public void handle(MouseEvent event) {
                       try {
                     db.loadDB();
                        } catch (SQLException ex) {
                         Logger.getLogger(StoreOrderCheckViewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            String tableID =  field_table_check.getText();

            client.setID(tableID);
            String store_query = "select * from store where store_id = '" + store_id + "'";
            String store_value = "storename";
        
            try {
                store_name = db.getDBString(store_query , store_value);
            } catch (SQLException ex) {
                Logger.getLogger(StoreOrderCheckViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            id = client.getID();
        
        allprice_query = "select * from store join guest on store.STORENAME = guest.STORENAME where store_id = '" + store_id + "'and guest_id = '" + id + "'";
        allprice_value = "price";
        allprice_value2 = "amount";
        try { // DB에서 손님이 먹은 음식 값들을 List에 모두 가져온다
            allprice = db.getDBListPrice(allprice_query, allprice_value, allprice_value2);
        } catch (SQLException ex) {
            Logger.getLogger(StoreOrderCheckViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
            AddAmountCommand addAmountCommand = new AddAmountCommand(allprice);
            Invoke invoke = new Invoke(addAmountCommand);
            invoke.setCommand(addAmountCommand); // 실행할 커맨드 지정
            client.setAmountNotPaid(Integer.parseInt(invoke.pressed()));
            System.out.println(client.getAmountNotPaid());
            field_total_price.setText(Integer.toString(client.getAmountNotPaid()));
            }
            }
         
        );
        btn_pay_card.setOnMouseClicked(new EventHandler<MouseEvent>() { // 카드 결제 버튼 클릭시
            @Override
            public void handle(MouseEvent event) {
                char tmp;
                boolean isString = false;
                for(int i=0; i<field_give_card.getText().length(); i++) 
                {
                    tmp = field_give_card.getText().charAt(i);
                    if(Character.isDigit(tmp) == false)  // 필드 값이 String형인지, int형인지 비교
                    {
                        isString = true;
                        break;
                    }
                }
                if(field_give_card.getText().equals("") || isString == true || Integer.parseInt(field_give_card.getText()) <= 0) // 0이상의 숫자가 아닐 경우
                {
                    setWindow("결제 금액을 잘못 입력하셨습니다.");
                }
                else
                {
                    client.setPaymentType("card");
                    client.setAmountPaid(Integer.parseInt(field_give_card.getText()));
                    careTaker.push(client.CreateMemento());
                    SubAmountCommand subAmountCommand = new SubAmountCommand(client.getAmountPaid(), client.getAmountNotPaid());
                    
                    Invoke invoke_pay = new Invoke(payCommand);
                    invoke_pay.setCommand(payCommand);
                    
                    setWindow(invoke_pay.pressed());
                    
                    Invoke invoke_sub = new Invoke(subAmountCommand);
                    invoke_sub.setCommand(subAmountCommand);
                    client.setAmountNotPaid(Integer.parseInt(invoke_sub.pressed()));
                    
                    CompletionCommand completionCommand = new CompletionCommand(receive,client.getAmountNotPaid(), client.getPaymentType());
                    Invoke invoke_com = new Invoke(completionCommand);
                    String[] com = invoke_com.pressed().split(",");
                    setWindow(com[0]);
                    client.setPayCheck(Integer.parseInt(com[1]));
                    if(com[0].equals(receive.payError())) // 결제 에러가 뜰 경우
                    {
                        client.RestorMemento(careTaker.pop()); // 계산되기 전의 값들을 불러온다
                    }
                    else if(com[0].equals(receive.completion()))
                    {
                        String change_query = "update guest set pay_check = " + client.getPayCheck() + " where storename = '" + store_name + "'" + "and guest_id = '" + client.getID() + "'";
                        try {
                            db.changeDB(change_query); // DB에 pay_check 값 변경
                            //db.closeDB();
                        } catch (SQLException ex) {
                            Logger.getLogger(StoreOrderCheckViewController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    field_total_price.setText(Integer.toString(client.getAmountNotPaid()));
                }
            }
            }
         
        );
        
        btn_pay_cash.setOnMouseClicked(new EventHandler<MouseEvent>() { // 현금 결제 버튼 클릭시
            @Override
            public void handle(MouseEvent event) 
            {
                char tmp;
                boolean isString = false;
                for(int i=0; i<field_give_cash.getText().length(); i++)
                {
                    tmp = field_give_cash.getText().charAt(i);
                    if(Character.isDigit(tmp) == false) 
                    {
                        isString = true;
                        break;
                    }
                }
                if(field_give_cash.getText().equals("") || isString == true || Integer.parseInt(field_give_cash.getText()) <= 0)
                {
                    setWindow("결제 금액을 잘못 입력하셨습니다.");
                }
                else
                {
                    client.setPaymentType("cash");
                    client.setAmountPaid(Integer.parseInt(field_give_cash.getText()));
 
                    SubAmountCommand subAmountCommand = new SubAmountCommand(client.getAmountPaid(), client.getAmountNotPaid());
                    
                    Invoke invoke_pay = new Invoke(payCommand);
                    invoke_pay.setCommand(payCommand);
                    
                    setWindow(invoke_pay.pressed());
                    
                    Invoke invoke_sub = new Invoke(subAmountCommand);
                    invoke_sub.setCommand(subAmountCommand);
                    client.setAmountNotPaid(Integer.parseInt(invoke_sub.pressed()));
                    
                    CompletionCommand completionCommand = new CompletionCommand(receive,client.getAmountNotPaid(), client.getPaymentType());
                    Invoke invoke_com = new Invoke(completionCommand);
                    String[] com = invoke_com.pressed().split(",");
                    setWindow(com[0]);
                    client.setPayCheck(Integer.parseInt(com[1]));


                    String change_query = "update guest set pay_check = " + client.getPayCheck() + " where storename = '" + store_name + "'" + "and guest_id = '" + client.getID() + "'";
                    try {
                            db.changeDB(change_query);// DB에 pay_check 값 변경
                            //db.closeDB();
                        } 
                    catch (SQLException ex) {
                            Logger.getLogger(StoreOrderCheckViewController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    
                    field_total_price.setText(Integer.toString(client.getAmountNotPaid()));
                }
                
                
            }
            }
         
        );        
    }
    public static void setWindow(String text) { // String 매개 변수를 받아 메시지창을 띄우는 함수
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("음식 예약 프로그램 : Waiter");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
