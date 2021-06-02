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
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
<<<<<<< Updated upstream
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
    
=======

    private UserDAO ud = new UserDAO();

    private List<String> listGuest = new ArrayList<>();
    private List<String> listManager = new ArrayList<>();
    private List<String> listIDPW = new ArrayList<>();
    private List<String> listBlacklist = new ArrayList<>();
    
    private ObservableList<String> userList;//게스트 출력 리스트
    private ObservableList<String> userList2;//매니저 출력 리스트
    private ObservableList<String> userIDPW;//현재 IDPW출력 리스트
    private ObservableList<String> blackList;//현재 IDPW출력 리스트
        private ObservableList<String> userList3;//블랙리스트 출력 리스트

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        userList = FXCollections.observableArrayList(); // 게스트 배열화
        userList2 = FXCollections.observableArrayList(); // 매장관리자 배열화
      
   userList3 = FXCollections.observableArrayList(); // 매장관리자 배열화
        listGuest = ud.getGuestIDName();
        for (int i = 0; i < listGuest.size(); i++) {
            userList.add(listGuest.get(i));
            list_adminguest.setItems(userList);
        }
        listManager = ud.getManagerIDName();
        for (int i = 0; i < listManager.size(); i++) {
            userList2.add(listManager.get(i));
            list_adminstormanager.setItems(userList2);
        }

            listBlacklist = ud.getBlackIDName();
        for (int i = 0; i < listBlacklist.size(); i++) {
            userList3.add(listBlacklist.get(i));
            list_blacklist.setItems(userList3);
        }
        list_adminguest.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    Object obj = list_adminguest.getSelectionModel().getSelectedItem();
                    Object currentItemSelected = list_adminguest.getSelectionModel().getSelectedItem();
                    userIDPW = FXCollections.observableArrayList(); // 현재 IDPW출력 배열화
                    try { // 현재 선택한 id를 IDPW 리스트에 디비를 통해 ID,PW를 받아옴
                        listIDPW = ud.getIDPW((String) currentItemSelected);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminmodifyController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (int i = 0; i < listIDPW.size(); i++) {
                        userIDPW.add(listIDPW.get(i));
                    }
                    field_modifyID.setText(userIDPW.get(0));
                    field_modifyPW.setText(userIDPW.get(1));
                }

            }
        });

        list_adminstormanager.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    Object obj = list_adminstormanager.getSelectionModel().getSelectedItem();
                    Object currentItemSelected = list_adminstormanager.getSelectionModel().getSelectedItem();
                    userIDPW = FXCollections.observableArrayList(); // 현재 IDPW출력 배열화
                    try {
                        listIDPW = ud.getIDPW((String) currentItemSelected);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminmodifyController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (int i = 0; i < listIDPW.size(); i++) {
                        userIDPW.add(listIDPW.get(i));
                    }
                    field_modifyID.setText(userIDPW.get(0));
                    field_modifyPW.setText(userIDPW.get(1));
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
//                list_do.getSelectionModel().getSelectedItems().removeAll();

                System.out.println("이용 정보 변경");
                ModifyTask mt = new ModifyTask();
                if (field_modifyPW.getText().equals(feld_modifyPWcheck.getText())) {
                    mt.task(field_modifyID.getText(), field_modifyPW.getText());
                }

                // 바뀐 게스트ID는 옆의 리스트에 반영됨
                userList = FXCollections.observableArrayList(); // 게스트 배열화
                listGuest = ud.getGuestIDName();
                for (int i = 0; i < listGuest.size(); i++) {
                    userList.add(listGuest.get(i));
                    list_adminguest.setItems(userList);
                }
                // 바뀐 매장관리자ID는 옆의 리스트에 반영됨 
                userList2 = FXCollections.observableArrayList();//매장관리자 배열화
                listManager = ud.getManagerIDName();
                for (int i = 0; i < listManager.size(); i++) {
                    userList2.add(listManager.get(i));
                    list_adminstormanager.setItems(userList2);
                }
                // ID,PW 수정 후 필드 값들을 지워줌
                field_modifyID.setText("");
                field_modifyPW.setText("");
                feld_modifyPWcheck.setText("");

//                for(Object task : taskList){
//                    if(field_modifyID.getText().equals(task.toString())){
//                        taskList.remove(task);
//                    }
//                }
            }
        });

        //사용자 삭제 버튼
        btn_admindelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                System.out.println("이용자 삭제");
                DeleteTask dt = new DeleteTask();
                dt.task(field_modifyID.getText(), field_modifyPW.getText());
            }
        });

        btn_addblacklist.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("이용자 블랙리스트 추가");
                BlackListTask bt = new BlackListTask();
                bt.task(field_modifyID.getText(), field_modifyPW.getText());
                
                 userList = FXCollections.observableArrayList(); // 게스트 배열화
                userList2 = FXCollections.observableArrayList(); // 매장관리자 배열화
                userList3 = FXCollections.observableArrayList(); // 매장관리자 배열화

                listGuest = ud.getGuestIDName();
                for (int i = 0; i < listGuest.size(); i++) {
                    userList.add(listGuest.get(i));
                    list_adminguest.setItems(userList);
                }

                listManager = ud.getManagerIDName();
                for (int i = 0; i < listManager.size(); i++) {
                    userList2.add(listManager.get(i));
                    list_adminstormanager.setItems(userList2);
                }
                listBlacklist = ud.getBlackIDName();
                for (int i = 0; i < listBlacklist.size(); i++) {
                    userList3.add(listBlacklist.get(i));
                    list_blacklist.setItems(userList3);
                }
             
            }
        });

>>>>>>> Stashed changes
    }
}
