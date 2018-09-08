/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Suppliers;

import Classes.Suppliers;
import Manager.Main.HomeController;
import database.DataHelper;
import database.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
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
    private ChoiceBox<Suppliers> S_Ctype;
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
    private TableView<Suppliers> S_Table;
    @FXML
    private TextField S_TSearch;
    @FXML
    private TextField S_Tname;
    @FXML
    private TextField S_TPhone;
    @FXML
    private TextField S_TSaller;
    @FXML
    private TableColumn<Suppliers, String> t_supplier;
    @FXML
    private TableColumn<Suppliers, String> t_phone;
    @FXML
    private TableColumn<Suppliers, String> t_category;
    @FXML
    private TableColumn<Suppliers, String> t_name;
    DatabaseHandler databaseHandler;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databaseHandler=DatabaseHandler.getInstance();
        t_name.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        t_category.setCellValueFactory(new PropertyValueFactory<>("supplierCategory"));
        t_phone.setCellValueFactory(new PropertyValueFactory<>("supplierPhone"));
        t_supplier.setCellValueFactory(new PropertyValueFactory<>("salespersonName"));
    }    

    @FXML
    private void Suppliers_Reports(ActionEvent event) {
         x.loadwindow(Manager_Suppliers,"/Manager/Suppliers/Reports/Sppliers_Reports.fxml");
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
         x.loadwindow(Manager_Suppliers,"/Manager/Main/Home.fxml");
    }

    @FXML
    private void Add_Supplier(ActionEvent event) {
        this.AddSupplier();
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
    
    private void AddSupplier(){
         Suppliers s =new Suppliers();
        s.setSupplierName(S_Tname.getText());
        s.setSupplierCategory(S_Ctype.getTypeSelector());
        s.setSupplierPhone(Integer.parseInt(S_TPhone.getText()));
        s.setSalespersonName(S_TSaller.getText());
        
        boolean result = DataHelper.insertNewSupplier(s);
        S_Table.getItems().add(s);
        if(result){
            Alert AT=new Alert(Alert.AlertType.INFORMATION);
            AT.setHeaderText(null);
            AT.setContentText("Successfully Added !!");
            AT.showAndWait();
            return;
    }
    }

    private void chechbox(DragEvent event) {
        ChoiceBox cd = new ChoiceBox();
    cd.setItems(FXCollections.observableArrayList(
    "new", "Electronic ", 
    new Separator(), "liquied", "meats")
); 
    }

}
