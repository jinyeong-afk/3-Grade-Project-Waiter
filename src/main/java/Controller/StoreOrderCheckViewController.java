/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author qwe98
 */
public class StoreOrderCheckViewController implements Initializable{
    
    @FXML
    private Button btn_table_check;
    @FXML
    private Button btn_pay_card;
    @FXML
    private Button btn_pay_cash;
    @FXML
    private ListView list_now_table;
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
    }
}
