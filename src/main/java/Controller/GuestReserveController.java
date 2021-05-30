/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.ReservationDAO;
import DB.StoreDAO;
import Src.Reservation_StatePattern.ReservationSystem;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author 박성호, 허세진
 */
public class GuestReserveController implements Initializable {

    @FXML
    private Button btn_guestreserve_check;
    @FXML
    private Button btn_guest_menuorder;
    @FXML
    private ListView<String> list_Storelist;
    @FXML
    private ListView<String> list_showreview;
    @FXML
    private ListView<String> list_storeinfo;
    @FXML
    private ListView<String> list_ordercheck;
    @FXML
    private ListView<String> list_menuname;
    @FXML
    private ListView<String> list_price;
    @FXML
    private DatePicker datepicker;
    @FXML
    private ChoiceBox choice_time;
    @FXML
    private TextField field_check_store;
    @FXML
    private TextField field_check_date;
    @FXML
    private TextField field_storeinfo;
    @FXML
    private TextField field_storeinfo_address;
    @FXML
    private TextField field_storeinfo_tel;
    @FXML
    private TextField field_check_time;
    @FXML
    private Label label_totalprice;
    @FXML
    private ListView<String> list_showscore;

    private ObservableList<String> cStoreList;
    private ObservableList<String> MenuStoreList;
    private ObservableList<String> PriceStoreList;
    private ObservableList<String> OderCheckList;
    private ReservationDAO rd = new ReservationDAO();
    private ArrayList<String> listStoreName = new ArrayList<>();
    private ArrayList<String> listStoreInfo = new ArrayList<>();
    private ArrayList<String> listStoreMenu = new ArrayList<>();
    private ArrayList<String> listStoreReview = new ArrayList<>();
    private ArrayList<String> listStoreScore = new ArrayList<>();
    private ArrayList<String> listStorePrice = new ArrayList<>();
    private ArrayList<Integer> listStoreOperateTime = new ArrayList<>();

    private StoreDAO sd = new StoreDAO();
    protected static String field_store;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cStoreList = FXCollections.observableArrayList();  // 배열화
        OderCheckList = FXCollections.observableArrayList();  // 배열화

        listStoreName = rd.getStoreNameList();
        for (int i = 0; i < listStoreName.size(); i++) {
            cStoreList.add(listStoreName.get(i));
            list_Storelist.setItems(cStoreList);

        }

        btn_guestreserve_check.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                listStoreInfo = rd.getMenuNameList(field_check_store.getText());
                field_storeinfo.setText(listStoreInfo.get(0));
                field_storeinfo_address.setText(listStoreInfo.get(1));
                field_storeinfo_tel.setText(listStoreInfo.get(2));
                
                
                field_store= field_check_store.getText();
                 cStoreList = FXCollections.observableArrayList();  // 배열화
                 listStoreReview = rd.getStoreReview(field_check_store.getText());
                for(int i=0; i<listStoreReview.size(); i++){
                    cStoreList.add(listStoreReview.get(i));
                 list_showreview.setItems(cStoreList);
                }
                 
                cStoreList = FXCollections.observableArrayList();  // 배열화
                listStoreScore = rd.getStoreScore(field_check_store.getText());
                for(int i=0; i<listStoreScore.size(); i++){
                  cStoreList.add(listStoreScore.get(i));
                 list_showscore.setItems(cStoreList);
                }
                
                listStoreOperateTime = rd.getStoreOperatertime(field_storeinfo.getText());
                choice_time.getItems().removeAll(choice_time.getItems());
                for (int i = listStoreOperateTime.get(0); i < listStoreOperateTime.get(1); i++) {
                    choice_time.getItems().addAll(i);
                }
                choice_time.getSelectionModel().select(0); // 처음 실행됐을 때 클릭되는 부분

                list_menuname.getItems().clear();
                list_price.getItems().clear();

                MenuStoreList = FXCollections.observableArrayList();  // 배열화
                listStoreMenu = sd.getMenuNameList(field_check_store.getText());
                for (int i = 0; i < listStoreMenu.size(); i++) {
                    MenuStoreList.add(listStoreMenu.get(i));
                    list_menuname.setItems(MenuStoreList);
                }

                //가격 리스트박스에 현재 store의 가격 모두 출력
                PriceStoreList = FXCollections.observableArrayList();  // 배열화
                listStorePrice = sd.getPriceList(field_check_store.getText());
                for (int i = 0; i < listStorePrice.size(); i++) {
                    PriceStoreList.add(listStorePrice.get(i));
                    list_price.setItems(PriceStoreList);
                }
                
                
            }
        });

        list_Storelist.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    Object obj = list_Storelist.getSelectionModel().getSelectedItem();
                    field_check_store.setText(obj.toString());
                }
            }
        });

        list_menuname.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    Object obj = list_menuname.getSelectionModel().getSelectedItem();
                    OderCheckList.add(obj.toString());
//                    System.out.println(obj.toString());
                    list_ordercheck.setItems(OderCheckList);
                }
            }
        });

        list_ordercheck.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    int obj = list_ordercheck.getSelectionModel().getSelectedIndex();
                    list_ordercheck.getItems().remove(obj);

                }
            }
        });

        btn_guest_menuorder.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ArrayList<String> listCheck = new ArrayList<>();
                ArrayList<Integer> listCheckAmount = new ArrayList<>();
                int loop = 0;
                OderCheckList = list_ordercheck.getItems();
//                 OderCheckList = list_ordercheck.getItems();
//                    System.out.println(OderCheckList.get(0));

                for (Object item : OderCheckList) { //향상된 foreach 문 사용
                    if (!(listCheck.contains(item.toString()))) {
                        listCheck.add(item.toString());
                        loop += 1;
//                    System.out.println(item.toString());
                    }
                }

                for (int idx = 0; idx < loop; idx++) {
                    int amount = 0; // 주문한 음식 개수
                    for (int i = 0; i < OderCheckList.size(); i++) {
                        if (OderCheckList.get(i).toString() == listCheck.get(idx)) {
                            amount += 1;
                        }
                    }
                    listCheckAmount.add(amount);
//                    System.out.println(listCheckAmount.get(idx));
                }

                for (int idx = 0; idx < listCheck.size(); idx++) {
//                    System.out.println(java.sql.Date.valueOf(datepicker.getValue()).toString());
//                    System.out.println(Integer.parseInt(choice_time.getValue().toString()));
                    ReservationSystem rs = new ReservationSystem(null, IntroViewController.getField, field_check_store.getText(),
                            java.sql.Date.valueOf(datepicker.getValue()), Integer.parseInt(choice_time.getValue().toString()),
                            listCheck.get(idx), listCheckAmount.get(idx), 0);
                    
                    rs.update();
                }

            }
        }
        );
    }
}
