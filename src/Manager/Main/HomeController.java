
package Manager.Main;

import database.DatabaseHandler;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class HomeController implements Initializable {

    @FXML
    private AnchorPane Home;
    @FXML
    private Label Manager;
    
    DatabaseHandler databaseHandler;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    databaseHandler= DatabaseHandler.getInstance();
    }    

    @FXML
    private void loadManager_Products(ActionEvent event) throws IOException {
        loadwindow("/Manager/Products/Manager_Products.fxml", "products");
     //  AnchorPane pane= FXMLLoader.load(getClass().getResource("/supermarket/Manager/Manager_Products.fxml")); 
       //Home.getChildren().setAll(pane);
       
    }

    @FXML
    private void loadManager_Employee(ActionEvent event) throws IOException {
         loadwindow("/Manager/Employee/Manager_Employee.fxml", "Employee");
        /* AnchorPane pane= FXMLLoader.load(getClass().getResource("/supermarket/Manager/Manager_Employee.fxml")); 
         Home.getChildren().setAll(pane);*/
    }

    @FXML
    private void loadReports(ActionEvent event) throws IOException {
        loadwindow("/Manager/Reports/Reports.fxml", "Reports");
        /* AnchorPane pane= FXMLLoader.load(getClass().getResource("/supermarket/Manager/Reports.fxml")); 
        Home.getChildren().setAll(pane);*/
    }

    @FXML
    private void LoadManager_Suppliers(ActionEvent event) throws IOException {
        loadwindow("/Manager/Suppliers/Manager_Suppliers.fxml", "Suppliers");
        /* AnchorPane pane= FXMLLoader.load(getClass().getResource("/supermarket/Manager/Manager_Suppliers.fxml")); 
        Home.getChildren().setAll(pane);*/
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
