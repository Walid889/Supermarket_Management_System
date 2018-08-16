
package supermarket.Manager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Manager_ProductsController implements Initializable {
     HomeController x = new HomeController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Products_Reports(ActionEvent event) {
         x.loadwindow("/supermarket/Manager/Products_Reports.fxml", "products_Reports");
    }
    
    @FXML
    private void Manager_Home(ActionEvent event) {
         x.loadwindow("/supermarket/Manager/Home.fxml", "Manager_Home");
    }
    
}
