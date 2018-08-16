
package supermarket.Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class HomeController implements Initializable {
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadManager_Products(ActionEvent event) {
        loadwindow("/supermarket/Manager/Manager_Products.fxml", "products");
    }

    @FXML
    private void loadManager_Employee(ActionEvent event) {
        loadwindow("/supermarket/Manager/Manager_Employee.fxml", "Employee");
    }

    @FXML
    private void loadReports(ActionEvent event) {
        loadwindow("/supermarket/Manager/Reports.fxml", "Reports");
    }

    @FXML
    private void LoadManager_Suppliers(ActionEvent event) {
        loadwindow("/supermarket/Manager/Manager_Suppliers.fxml", "Suppliers");
    }
    
    public void loadwindow(String loc , String Title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(Title);
            stage.setScene(new Scene(parent));
            stage.show();
            } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
