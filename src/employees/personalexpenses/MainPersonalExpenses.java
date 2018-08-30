
package employees.personalexpenses;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainPersonalExpenses extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("personalexpenses.fxml"));
        
        Scene scene = new Scene(root);
        Image icon = new Image("/icons/my_account.png");
        stage.getIcons().add(icon);
        stage.setTitle("المصاريف الشخصية");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
