
package Manager.Products;

import Manager.Main.HomeController;
import database.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Manager_ProductsController implements Initializable {
     HomeController x = new HomeController();
    @FXML
    private AnchorPane Manager_Products;
    @FXML
    private Label P_Code;
    @FXML
    private Label P_Type;
    @FXML
    private Label P_Supplier;
    @FXML
    private Label P_UPrice;
    @FXML
    private Label P_name;
    @FXML
    private Label P_Quantity;
    @FXML
    private ChoiceBox<?> P_Csupplier;
    @FXML
    private Label P_Bprice;
    @FXML
    private Label P_Cprice;
    @FXML
    private Label P_Minimm;
    @FXML
    private Label P_date;
    @FXML
    private TableView<?> P_table;
    @FXML
    private ChoiceBox<?> P_Ctype;
    @FXML
    private TextField P_TSearch;
    @FXML
    private TextField P_Tname;
    @FXML
    private TextField P_Tcode;
    @FXML
    private TextField P_Tquantity;
    @FXML
    private TextField P_TUprice;
    @FXML
    private TextField P_TBprice;
    @FXML
    private TextField P_TCprice;
    @FXML
    private TextField P_Tminimun;
    @FXML
    private TextField P_Tdate;
    @FXML
    private ChoiceBox<?> P_Cquantity;
    /**
     * Initializes the controller class.
     */
    DatabaseHandler databaseHandler;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databaseHandler=DatabaseHandler.getInstance();
    }    

    @FXML
    private void Products_Reports(ActionEvent event) {
         x.loadwindow(Manager_Products,"/Manager/Products/Reports/Products_Reports.fxml");
    }
    
    @FXML
    private void Manager_Home(ActionEvent event) {
         x.loadwindow(Manager_Products,"/Manager/Main/Home.fxml");
    }

    @FXML
    private void Add_Product(ActionEvent event) {
    }

    @FXML
    private void Edit_Product(ActionEvent event) {
    }

    @FXML
    private void Delete_Product(ActionEvent event) {
    }

    @FXML
    private void Product_Search(ActionEvent event) {
    }
    
}
