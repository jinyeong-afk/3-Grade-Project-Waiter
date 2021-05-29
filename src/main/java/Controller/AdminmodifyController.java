/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.UserDAO;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author 박성호, 허세진
 */
public class AdminmodifyController implements Initializable{
    @FXML
    private ListView list_adminguest;
    @FXML
    private ListView list_adminstormanager;
    @FXML
    private Button btn_adminmodify;
    @FXML
    private Button btn_admindelete;
    @FXML
    private TextField field_modifyID;
    @FXML
    private TextField field_modifyPW;
    @FXML
    private TextField feld_modifyPWcheck;
    
    private UserDAO ud = new UserDAO();
    
    private ArrayList<String> listGuest = new ArrayList<>();
    private ArrayList<String> listManager = new ArrayList<>();
    private ArrayList<String> listIDPW = new ArrayList<>();
    
    private ObservableList<String> UserList;//게스트 출력 리스트
    private ObservableList<String> UserList2;//매니저 출력 리스트
    private ObservableList<String> UserIDPW;//현재 IDPW출력 리스트
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        UserList = FXCollections.observableArrayList(); // 게스트 배열화
        UserList2 = FXCollections.observableArrayList(); // 매장관리자 배열화
        
        
        listGuest = ud.getGuestIDName();
        for(int i = 0; i<listGuest.size(); i++){
            UserList.add(listGuest.get(i));
            list_adminguest.setItems(UserList);
        }
        listManager = ud.getManagerIDName();
        for(int i = 0; i<listManager.size(); i++){
            UserList2.add(listManager.get(i));
            list_adminstormanager.setItems(UserList2);
        }
       
        list_adminguest.setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            @Override
                public void handle(MouseEvent click) {
                   if(click.getClickCount() == 2){
                       Object currentItemSelected = list_adminguest.getSelectionModel().getSelectedItem();
                       UserIDPW = FXCollections.observableArrayList(); // 현재 IDPW출력 배열화
                       try{ // 현재 선택한 id를 IDPW 리스트에 디비를 통해 ID,PW를 받아옴
                           listIDPW = ud.getIDPW((String) currentItemSelected);
                       }catch (SQLException ex) {
                           Logger.getLogger(AdminmodifyController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       for(int i=0; i<listIDPW.size(); i++){
                                UserIDPW .add(listIDPW.get(i));
                            }
                       field_modifyID.setText( UserIDPW.get(0));
                       field_modifyPW.setText( UserIDPW.get(1));
                   } 
                }
        });
        
        list_adminstormanager.setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            @Override
                public void handle(MouseEvent click) {
                    if(click.getClickCount() == 2){
                       Object currentItemSelected = list_adminstormanager.getSelectionModel().getSelectedItem();
                       UserIDPW = FXCollections.observableArrayList(); // 현재 IDPW출력 배열화
                       try{
                           listIDPW = ud.getIDPW((String) currentItemSelected);
                       }catch (SQLException ex) {
                           Logger.getLogger(AdminmodifyController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       for(int i=0; i<listIDPW.size(); i++){
                                UserIDPW .add(listIDPW.get(i));
                            }
                       field_modifyID.setText( UserIDPW.get(0));
                       field_modifyPW.setText( UserIDPW.get(1));
                   }                     
                }
        });
        

        // 수정 버튼
        btn_adminmodify.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                //baseComponent mu = new ModifyUser(); //리프 - 수정
                //Composite composite = new Composite();
                //composite.Modify(mu);

                    System.out.println("이용 정보 변경"); 
                    ud.ModifyInfo(field_modifyID.getText(),field_modifyPW.getText());
                    System.out.println( field_modifyPW.getText());
                
                        // 바뀐 게스트ID는 옆의 리스트에 반영됨
                        UserList = FXCollections.observableArrayList(); // 게스트 배열화
                        listGuest = ud.getGuestIDName();
                                for(int i = 0; i<listGuest.size(); i++){
                                   UserList.add(listGuest.get(i));
                                   list_adminguest.setItems(UserList);
                                }
                        // 바뀐 매장관리자ID는 옆의 리스트에 반영됨 
                        UserList2 = FXCollections.observableArrayList();//매장관리자 배열화
                        listManager = ud.getManagerIDName();
                                for(int i = 0; i<listManager.size(); i++){
                                    UserList2.add(listManager.get(i));
                                    list_adminstormanager.setItems(UserList2);
                                }
                        // ID,PW 수정 후 필드 값들을 지워줌
                        field_modifyID.setText("");
                        field_modifyPW.setText("");
                        feld_modifyPWcheck.setText("");
                
                
            }
        });
        
        //삭제 버튼
        btn_admindelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if( !(field_modifyID.getText().equals(""))&&!(field_modifyPW.getText().equals(""))){
                
               // baseComponent du = new DeleteUser(); //리프 - 수정
               // Composite composite = new Composite();
               // composite.Modify(du);
                System.out.println("이용자 정보 삭제");
                ud.DelInfo(field_modifyID.getText(), field_modifyPW.getText());
                
                // 삭제된 게스트ID는 옆의 리스트에서 사라짐
                UserList = FXCollections.observableArrayList(); // 게스트 배열화
                listGuest = ud.getGuestIDName();
                       for(int i = 0; i<listGuest.size(); i++){
                           UserList.add(listGuest.get(i));
                           list_adminguest.setItems(UserList);
                       }
                // 삭제된 매장관리자ID는 옆의 리스트에서 사라짐    
                UserList2 = FXCollections.observableArrayList();//매장관리자 배열화
                listManager = ud.getManagerIDName();
                        for(int i = 0; i<listManager.size(); i++){
                            UserList2.add(listManager.get(i));
                            list_adminstormanager.setItems(UserList2);
                        }
                        // 삭제 된 후 필드 값들을 지워줌
                        field_modifyID.setText("");
                        field_modifyPW.setText("");
                }
            }
        });
                
                        
    }
}
