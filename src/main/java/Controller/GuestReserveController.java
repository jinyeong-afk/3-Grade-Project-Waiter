/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.ReservationDAO;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
public class GuestReserveController implements Initializable{
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
    private ListView<String> list_odercheck;
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
    private TextField field_check_time;
    @FXML
    private Label label_totalprice;

    private ObservableList<String> cStoreList;
    private ReservationDAO rd = new ReservationDAO();
    private ArrayList<String> listStoreName = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cStoreList = FXCollections.observableArrayList();  // 배열화
//        choice_time.getItems().removeAll(choice_time.getItems());
//        choice_time.getItems().addAll(오픈시간 ~ 마감시간 까지 1시간 간격으로 for문을 통해 주입);
//        choice_time.getSelectionModel().select("Option B"); // 처음 실행됐을 때 클릭되는 부분

        listStoreName = rd.getStoreNameList();
        for(int i=0; i<listStoreName.size(); i++){
            cStoreList.add(listStoreName.get(i));
            list_Storelist.setItems(cStoreList);
            
        }
        btn_guestreserve_check.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
    }
    
}
