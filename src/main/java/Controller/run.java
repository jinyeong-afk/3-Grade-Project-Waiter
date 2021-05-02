/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 박성호
 */
public class run extends Application  {

    /**
     * @param args the command line arguments
     */
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/IntroView.fxml"));
        
        //Font.loadFont(getClass().getResource("NanumSquareB.ttf").toExternalForm(),15);
//        Font.loadFont(getClass().getResource("/NanumSquareR.ttf").toExternalForm(),15);
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("/styles/theme.css").toString());
//        scene.getStylesheets().add("/styles/Styles.css");
      
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("2분반 6조 (박성호, 박경민, 송진영, 이규철, 허세진)");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
