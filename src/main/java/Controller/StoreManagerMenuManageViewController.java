/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DTO;
import DB.LoginDTO;
import DB.StoreDAO;
import Src.StoreRegister.StoreFactory;
import Src.StoreRegister.StoreRegister;
import Src.StoreRegister.TableStore;
import Src.StoreRegister.TakeoutStore;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author 박성호, 허세진
 */
public class StoreManagerMenuManageViewController implements Initializable{
     
    @FXML
    private Button btn_menu_registor;
    @FXML
    private Button btn_menu_modify;
    @FXML
    private Button btn_menu_delete;
    @FXML
    private Button btn_store_modify;
    @FXML
    private Button btn_store_register;
    @FXML
    private ListView list_menuname;
    @FXML
    private ListView list_price;
    @FXML
    private Label label_name;

    @FXML
    private TextField field_storename;
    @FXML
    private TextField field_storetel;
    @FXML
    private TextField field_storeaddress;
    @FXML
    private TextField field_max;
    @FXML
    private TextField field_open_time;
    @FXML
    private TextField field_end_time;
    @FXML
    private TextField field_storetype;
    @FXML
    private TextField field_registor_menuname;
    @FXML
    private TextField field_registor_price;
    
    StoreDAO sd = new StoreDAO();
    ArrayList<String> stringStoreList = new ArrayList<>();
    ArrayList<Integer> IntegerStoreList = new ArrayList<>();
    LoginDTO db = new LoginDTO();
    String a;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        if(!(sd.checkRegist(IntroViewController.getField))){
            btn_store_modify.setVisible(false);
            btn_store_register.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if( !(field_end_time.getText().equals("")
                    & !(field_storename.getText().equals(""))
                    & !(field_storetel.getText().equals(""))
                    & !(field_storeaddress.getText().equals(""))
                    & !(field_max.getText().equals(""))
                    & !(field_storetype.getText().equals(""))
                    & !(field_storetype.getText().equalsIgnoreCase("forhere") || field_storetype.getText().equalsIgnoreCase("takeout"))
                    & !(field_open_time.getText().equals(""))))
                    {
                        StoreRegister store = StoreFactory.getStore(IntroViewController.getField, field_storetype.getText(), field_storename.getText(), field_storeaddress.getText(),
                                field_storetel.getText(), Integer.parseInt(field_open_time.getText()), Integer.parseInt(field_end_time.getText()), Integer.parseInt(field_max.getText()));
                        sd.signUpStore(store.getid(), store.getstoretype(), store.getstorename(), store.getstoretel(), store.getstoreaddress(),
                        store.getopen_time(), store.getclose_time(), store.getmax());
                        
                        System.out.println("매장 객체 생성");
                    }
                }
            }
        );
      } else{
            try {
                stringStoreList = sd.getStringStoreInformaiton(IntroViewController.getField);
                IntegerStoreList = sd.getIntStoreInformaiton(IntroViewController.getField);                
                btn_store_register.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(StoreManagerMenuManageViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              field_storename.setText(stringStoreList.get(0));
              field_storeaddress.setText(stringStoreList.get(1));
              field_storetel.setText(stringStoreList.get(2));
              field_open_time.setText(Integer.toString(IntegerStoreList.get(0)));
              field_end_time.setText(Integer.toString(IntegerStoreList.get(1)));
              field_max.setText(Integer.toString(IntegerStoreList.get(2)));
              field_storetype.setText(stringStoreList.get(3));
            
            
            btn_store_modify.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if( !(field_end_time.getText().equals("")
                        & !(field_storename.getText().equals(""))
                        & !(field_storetel.getText().equals(""))
                        & !(field_storeaddress.getText().equals(""))
                        & !(field_max.getText().equals(""))
                        & !(field_storetype.getText().equals(""))
                        & !(field_storetype.getText().equalsIgnoreCase("forhere") || field_storetype.getText().equalsIgnoreCase("takeout"))
                        & !(field_open_time.getText().equals(""))))
                       { 
                      
                     //ChangeStore(String ID, String storename, String storeaddress, String storetel, int open_time, int close_time, int Max){
                      
                        sd.ChangeStore(IntroViewController.getField, field_storename.getText(), field_storeaddress.getText(),   
                        field_storetel.getText(), Integer.parseInt(field_open_time.getText()), Integer.parseInt(field_end_time.getText()), Integer.parseInt(field_max.getText()));
                        System.out.println("매장 정보 변경");
                    }
            }
        }
        );
              btn_menu_registor.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                System.out.println("메뉴 추가 됐냐"); 
                           System.out.println(a);
                    if( !(field_registor_menuname.getText().equals("")
                        & !(field_registor_price.getText().equals(""))))
                       { 
                           
                    
                            
                            sd.signUpMenu(field_storename.getText(), field_registor_menuname.getText(), Integer.parseInt(field_registor_price.getText()));
                                                     
                   
                    }
            }
        }
        );
        }
    }
}
