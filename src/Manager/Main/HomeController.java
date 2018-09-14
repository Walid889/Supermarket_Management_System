
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
import javafx.scene.layout.AnchorPane;



public class HomeController implements Initializable {

    @FXML
    private AnchorPane Home;
    
    DatabaseHandler databaseHandler;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    databaseHandler= DatabaseHandler.getInstance();
    }    

    @FXML
    private void loadManager_Products(ActionEvent event) throws IOException {
        loadwindow(Home, "/Manager/Products/Manager_Products.fxml");
    }

    @FXML
    private void loadManager_Employee(ActionEvent event) throws IOException {
         loadwindow(Home, "/Manager/Employee/Manager_Employee.fxml");
    }

    @FXML
    private void loadReports(ActionEvent event) throws IOException {
        loadwindow(Home, "/Manager/Reports/Reports.fxml");
    }

    @FXML
    private void LoadManager_Suppliers(ActionEvent event) throws IOException {
         loadwindow(Home, "/Manager/Suppliers/Manager_Suppliers.fxml");
    } 
    
    public void loadwindow(AnchorPane p , String loc) { //
        AnchorPane pane = null;
           try {
               pane = FXMLLoader.load(getClass().getResource(loc));
           } catch (IOException ex) {
               Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
           }
        p.getChildren().setAll(pane);
    }    

    @FXML
    private void loadEmployee(ActionEvent event) {
        loadwindow(Home , "/employees/main/employees.fxml");
    }

    @FXML
    private void loadManager_Account(ActionEvent event) {
        loadwindow(Home ,"/Manager/Account/Manager_Account.fxml");
    }
    
}
