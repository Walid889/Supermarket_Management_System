/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Opening.OpeningController;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author lolo
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
       /* Parent op = FXMLLoader.load(getClass().getResource("/Opening/opening.fxml"));
       
        Scene sc = new Scene(op);
        Image ico = new Image("/icons/supermarket.png");
        Stage st = new Stage();
        st.getIcons().add(ico);
        st.setTitle("سوبر ماركت ابو طارق");
        st.setResizable(false);
        st.setScene(sc);
        st.show();*/
        
        
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
       
            Scene scene = new Scene(root);
            Image icon = new Image("/icons/supermarket.png");
            stage.getIcons().add(icon);
            stage.setTitle("سوبر ماركت ابو طارق");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
           
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

