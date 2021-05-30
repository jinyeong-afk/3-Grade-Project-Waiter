/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.PermissionDAO;
import DB.ReservationDAO;
import DB.StoreDAO;
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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author 박성호, 허세진
 */
public class AdminPermissionController implements Initializable{
     @FXML
    private ListView list_permissionstore;
     @FXML
    private ListView list_permissioninfo;
     @FXML
    private ListView list_permissionmenu;
     @FXML
    private Button btn_permissionbtn;
    @FXML
    private TextField field_permissiontext;
    @FXML
    private TextField field_storename;
    @FXML
    private TextField field_storetel;
    @FXML
    private TextField field_storeaddress;
    @FXML
    private TextField field_storetable;
    @FXML
    private TextField field_stock;
    @FXML
    private TextField field_open_time;
    @FXML
    private TextField field_end_time;
    @FXML
    private Label Lable_AdStoreInfo;
    @FXML
    private Label Lable_AdStoremeun;
    
    
    
    private ReservationDAO rd = new ReservationDAO();
    private PermissionDAO pd = new PermissionDAO();
    private StoreDAO sd = new StoreDAO();
    
    private ArrayList<String> listStoreName = new ArrayList<>(); //가게 이름 배열
    private ArrayList<String> listStoreMenuName = new ArrayList<>(); //가게 메뉴이름 배열
    private ArrayList<String> listStringInfo = new ArrayList<>(); //가게 정보(String)
    private ArrayList<Integer> listIntInfo = new ArrayList<>(); //가게 정보(Int)
    
    private ObservableList<String> cStoreList;
    private ObservableList<String> MenuStoreList;
    private ObservableList<String> StringInfoList;
    private ObservableList<Integer> IntInfoList;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        //가게 이름 배열에 값 넣음
        cStoreList = FXCollections.observableArrayList();  // 배열화
        listStoreName = rd.getStoreNameList(0);
        for(int i=0; i<listStoreName.size(); i++){
            cStoreList.add(listStoreName.get(i));
            list_permissionstore.setItems(cStoreList);
        }
        
            list_permissionstore.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent click) {

                    if (click.getClickCount() == 2) { // 더블클릭했을 때
                        // 리스트 박스에서 현재 선택한 가게 이름
                        Object currentItemSelected = list_permissionstore.getSelectionModel().getSelectedItem();
                            
                            StringInfoList = FXCollections.observableArrayList();  // 배열화
                        try { //현재 선택한 값 매장정보(String형)을  리스트에 넣어줌
                            listStringInfo = pd.getStringStoreInfo((String) currentItemSelected);
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminPermissionController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //넣어준 리스트를 배열화 시킨 배열에 값을 넣어줌
                            for(int i=0; i<listStringInfo.size(); i++){
                                StringInfoList.add(listStringInfo.get(i));
                            }
                            field_storename.setText( StringInfoList.get(0));
                            field_storetel.setText( StringInfoList.get(1));
                            field_storeaddress.setText( StringInfoList.get(2));
                        
                          IntInfoList = FXCollections.observableArrayList();  // 배열화
                        try { //현재 선택한 값 매장정보(int형)을 리스트에 넣어줌
                            listIntInfo = pd.getIntStoreInfo((String) currentItemSelected);
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminPermissionController.class.getName()).log(Level.SEVERE, null, ex);
                        }  
                            //넣어준 리스트를 배열화 시킨 배열에 값을 넣어줌
                            for(int i=0; i<listIntInfo.size(); i++){ //db의 int 값을 
                                IntInfoList.add(listIntInfo.get(i));
                            }
                            field_storetable.setText(Integer.toString(IntInfoList.get(0)));
                            field_stock.setText(Integer.toString(IntInfoList.get(1)));
                            field_open_time.setText(Integer.toString(IntInfoList.get(2)));
                            field_end_time.setText(Integer.toString(IntInfoList.get(3)));
                        //허가 버튼 옆 현재 선택한 매장            
                        field_permissiontext.setText((String) currentItemSelected);
                        
                                //가게 메뉴 배열에 값 넣음
                            MenuStoreList = FXCollections.observableArrayList();  // 배열화
                            listStoreMenuName = sd.getMenuNameList((String) currentItemSelected);
                            for(int i=0; i<listStoreMenuName.size(); i++){
                                MenuStoreList.add(listStoreMenuName.get(i));
                                list_permissionmenu.setItems(MenuStoreList);
                            }
                            
                            btn_permissionbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    //허가 버튼을 누르면 db값을 1로 바꿔줌
                                @Override
                                public void handle(MouseEvent event) { 
                                    try { 
                                        pd.PermissionStore((String) currentItemSelected);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(AdminPermissionController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    //허가가 된 매장들은 현재 매장 이름에서 빠져야함
                                        cStoreList = FXCollections.observableArrayList();  // 배열화
                                        listStoreName = rd.getStoreNameList();
                                        for(int i=0; i<listStoreName.size(); i++){
                                        cStoreList.add(listStoreName.get(i));
                                        list_permissionstore.setItems(cStoreList);
                                        }
                                        
                                    // 허가가 된 후 필드에 적혀있는 것을 지움
                                    list_permissionmenu.setItems(null);
                                    field_permissiontext.setText("");
                                    field_storename.setText("");
                                    field_storetel.setText("");
                                    field_storeaddress.setText("");
                                    field_storetable.setText("");
                                    field_stock.setText("");
                                    field_open_time.setText("");
                                    field_end_time.setText("");
                                }
                                
                            });
                    }
                }
            });
    }
}
