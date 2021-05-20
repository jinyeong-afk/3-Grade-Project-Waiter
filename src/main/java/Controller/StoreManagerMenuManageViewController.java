/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import DB.LoginDTO;
import DB.StoreDAO;
import Src.StoreRegister.Store;
import Src.StoreRegister.StoreFactory;
import Src.StoreRegister.StoreRegister;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    private ListView<String> list_menuname;
    @FXML
    private ListView<String> list_price;
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
    
    private LoginDTO db = new LoginDTO();
    private StoreDAO sd = new StoreDAO();
    StoreFactory sf = new StoreFactory();
    
    private ObservableList<String> MenuStoreList;
    private ObservableList<String> PriceStoreList;                    
    private ArrayList<String> stringStoreList = new ArrayList<>();    // 가게 정보 출력 : String  (가게이름, 가게, 가게타입, 가게연락처 )
    private ArrayList<Integer> IntegerStoreList = new ArrayList<>();  // 가게 정보 출력 : Integer (오픈시간, 마감시간, 최대 테이블 수(재고 수))
    private ArrayList<String> listStoreMenu = new ArrayList<>();      // 가게 메뉴 출력 : String  (메뉴이름)
    private ArrayList<String> listStorePrice = new ArrayList<>();     // 가게 가격 출력 : String  (가격)
      
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //로그인한 ID가 store에 없다면 
        if(!(sd.checkRegist(IntroViewController.getField))){
            btn_store_modify.setVisible(false); //수정 버튼은 사라진다
            btn_store_register.setOnMouseClicked(new EventHandler<MouseEvent>() { //마우스 등록버튼 클릭시 발생 이벤트 현재 매장 정보 등록
                @Override
                public void handle(MouseEvent event) { //유효성 검사
                    if( !(field_end_time.getText().equals("")
                    & !(field_storename.getText().equals(""))
                    & !(field_storetel.getText().equals(""))
                    & !(field_storeaddress.getText().equals(""))
                    & !(field_max.getText().equals(""))
                    & !(field_storetype.getText().equals(""))
                    & !(field_storetype.getText().equalsIgnoreCase("forhere") || field_storetype.getText().equalsIgnoreCase("takeout"))
                    & !(field_open_time.getText().equals(""))))
                    {
                        //팩토리 메서드 패턴으로 매장 객체 생성
                        Store store;
                        store = sf.createStore(IntroViewController.getField, field_storetype.getText(), field_storename.getText(), 
                                field_storeaddress.getText(),field_storetel.getText(), Integer.parseInt(field_open_time.getText()), Integer.parseInt(field_end_time.getText()),
                                Integer.parseInt(field_max.getText()));
                         
                        //생성된 매장 객체를 DB에 저장
                        sd.signUpStore(store.getid(), store.getstoretype(), store.getstorename(), store.getstoretel(), store.getstoreaddress(),
                        store.getopen_time(), store.getclose_time(), store.getmax());
                        
                        System.out.println("매장 객체 생성");
                    }
                }
            }
        );} 
        else{//로그인한 ID가 store에 있으면
            try {
                stringStoreList = sd.getStringStoreInformaiton(IntroViewController.getField);
                IntegerStoreList = sd.getIntStoreInformaiton(IntroViewController.getField);                
                btn_store_register.setVisible(false); //등록버튼 사라짐
            } catch (SQLException ex) {
                Logger.getLogger(StoreManagerMenuManageViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
              //DB에 넣어둔 값을 fieldtext에 출력
              field_storename.setText(stringStoreList.get(0));
              field_storeaddress.setText(stringStoreList.get(1));
              field_storetel.setText(stringStoreList.get(2));
              field_open_time.setText(Integer.toString(IntegerStoreList.get(0)));
              field_end_time.setText(Integer.toString(IntegerStoreList.get(1)));
              field_max.setText(Integer.toString(IntegerStoreList.get(2)));
              field_storetype.setText(stringStoreList.get(3));
            
              //메뉴 리스트박스에 현재 store의 메뉴 모두 출력
              MenuStoreList = FXCollections.observableArrayList();  // 배열화
              listStoreMenu = sd.getMenuNameList(field_storename.getText());
              for(int i=0; i<listStoreMenu.size(); i++){
                   MenuStoreList.add(listStoreMenu.get(i));
                   list_menuname.setItems(MenuStoreList);  
               }
              
              //가격 리스트박스에 현재 store의 가격 모두 출력
              PriceStoreList = FXCollections.observableArrayList();  // 배열화
              listStorePrice = sd.getPriceList(field_storename.getText());
              for(int i=0; i<listStorePrice.size(); i++){
                   PriceStoreList.add(listStorePrice.get(i));
                   list_price.setItems(PriceStoreList);  
               }
              
            }
        
           
            btn_store_modify.setOnMouseClicked(new EventHandler<MouseEvent>() { //수정 버튼 클릭시 현재 매장 정보 수정   
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
                     
                        sd.ChangeStore(IntroViewController.getField, field_storename.getText(), field_storeaddress.getText(),   
                        field_storetel.getText(), Integer.parseInt(field_open_time.getText()), Integer.parseInt(field_end_time.getText()), 
                        Integer.parseInt(field_max.getText()));
                        
                        System.out.println("매장 정보 변경");
                        }
            }
        }
        );
              btn_menu_registor.setOnMouseClicked(new EventHandler<MouseEvent>() {//메뉴 등록 버튼 클릭시 현재 매장 메뉴 등록
                @Override
                public void handle(MouseEvent event) {
                System.out.println("메뉴 추가"); 
                     
                    if( !(field_registor_menuname.getText().equals("")
                        & !(field_registor_price.getText().equals(""))))
                       { 
                            sd.signUpMenu(field_storename.getText(), field_registor_menuname.getText(), Integer.parseInt(field_registor_price.getText()));
                             
                            //메뉴 리스트박스에 현재 store의 메뉴 모두 출력
                            MenuStoreList = FXCollections.observableArrayList();  // 배열화
                            listStoreMenu = sd.getMenuNameList(field_storename.getText());
                            for(int i=0; i<listStoreMenu.size(); i++){
                                 MenuStoreList.add(listStoreMenu.get(i));
                                 list_menuname.setItems(MenuStoreList);  
                            }
              
                            //가격 리스트박스에 현재 store의 가격 모두 출력
                            PriceStoreList = FXCollections.observableArrayList();  // 배열화
                            listStorePrice = sd.getPriceList(field_storename.getText());
                            for(int i=0; i<listStorePrice.size(); i++){
                                 PriceStoreList.add(listStorePrice.get(i));
                                 list_price.setItems(PriceStoreList);  
                            }
                       }
            }
        }
        );
               
              
              btn_menu_modify.setOnMouseClicked(new EventHandler<MouseEvent>() {//메뉴 수정 버튼 클릭시 현재 매장 메뉴 가격 수정
                @Override
                public void handle(MouseEvent event) {
                 
                           String A=field_registor_menuname.getText(); 
                    if( !(field_registor_menuname.getText().equals("")
                        & !(field_registor_price.getText().equals(""))))
                        { 
                                System.out.println("메뉴 수정");
                                sd.Modifymenu(field_storename.getText(), field_registor_menuname.getText(), Integer.parseInt(field_registor_price.getText()));
                                //메뉴 리스트박스에 현재 store의 메뉴 모두 출력
                                
                                MenuStoreList = FXCollections.observableArrayList();  // 배열화
                                listStoreMenu = sd.getMenuNameList(field_storename.getText());
                                for(int i=0; i<listStoreMenu.size(); i++){
                                       MenuStoreList.add(listStoreMenu.get(i));
                                       list_menuname.setItems(MenuStoreList);  
                                   }

                                //가격 리스트박스에 현재 store의 가격 모두 출력
                                PriceStoreList = FXCollections.observableArrayList();  // 배열화
                                listStorePrice = sd.getPriceList(field_storename.getText());
                                for(int i=0; i<listStorePrice.size(); i++){
                                         PriceStoreList.add(listStorePrice.get(i));
                                 list_price.setItems(PriceStoreList);  
                                 }
                        }
            }
        }
        );
              
                btn_menu_delete.setOnMouseClicked(new EventHandler<MouseEvent>() {//메뉴 삭제 버튼 클릭시 현재 매장 메뉴 삭제
                @Override
                public void handle(MouseEvent event) {
                 
                           
                    if( !(field_registor_menuname.getText().equals("")))
                       { 
                                System.out.println("메뉴 삭제");
                                sd.Delmenu(field_storename.getText(), field_registor_menuname.getText());
                                
                                MenuStoreList = FXCollections.observableArrayList();  // 배열화
                                listStoreMenu = sd.getMenuNameList(field_storename.getText());
                                for(int i=0; i<listStoreMenu.size(); i++){
                                       MenuStoreList.add(listStoreMenu.get(i));
                                       list_menuname.setItems(MenuStoreList);  
                                   }

                                //가격 리스트박스에 현재 store의 가격 모두 출력
                                PriceStoreList = FXCollections.observableArrayList();  // 배열화
                                listStorePrice = sd.getPriceList(field_storename.getText());
                                for(int i=0; i<listStorePrice.size(); i++){
                                         PriceStoreList.add(listStorePrice.get(i));
                                list_price.setItems(PriceStoreList);  
                                   }
                        }
                    }
        });
                list_menuname.setOnMouseClicked(new EventHandler<MouseEvent>() {  //리스트뷰 클릭 시 메뉴이름 텍스트박스에 출력
                @Override
                public void handle(MouseEvent event) {
                Object obj = list_menuname.getSelectionModel().getSelectedItem();
                field_registor_menuname.setText(obj.toString());
                
                }
        });
    }
}
