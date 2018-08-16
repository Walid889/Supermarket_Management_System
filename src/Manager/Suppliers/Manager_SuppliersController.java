/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Suppliers;

import Manager.Main.HomeController;
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
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Manager_SuppliersController implements Initializable {
      HomeController x = new HomeController();
    @FXML
    private AnchorPane Manager_Suppliers;
    @FXML
    private ChoiceBox<?> S_Ctype;
    @FXML
    private VBox VBox;
    @FXML
    private Label Suppliers;
    @FXML
    private Label S_name;
    @FXML
    private Label S_Type;
    @FXML
    private Label S_Phone;
    @FXML
    private Label S_Saller;
    @FXML
    private TableView<?> S_Table;
    @FXML
    private TextField S_TSearch;
    @FXML
    private TextField S_Tname;
    @FXML
    private TextField S_TPhone;
    @FXML
    private TextField S_TSaller;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Suppliers_Reports(ActionEvent event) {
         x.loadwindow("/Manager/Suppliers/Reports/Sppliers_Reports.fxml", "Suppliers_Reports");
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
         x.loadwindow("/Manager/Main/Home.fxml", "Home");
    }

    @FXML
    private void Add_Supplier(ActionEvent event) {
    }

    @FXML
    private void Edit_Supplier(ActionEvent event) {
    }

    @FXML
    private void Delete_Supplier(ActionEvent event) {
    }

    @FXML
    private void Suppliers_Search(ActionEvent event) {
    }
    
    
}
