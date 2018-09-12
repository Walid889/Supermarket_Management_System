/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Suppliers;

import Classes.Alerts;
import Classes.Suppliers;
import Manager.Main.HomeController;
import database.DataHelper;
import database.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
    private ComboBox<String> S_Ctype;
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
         ObservableList<String> list= FXCollections.observableArrayList("وائل","محمود","احمد");
        S_Ctype.setItems(list);
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
        this.Edit_Supplier();
    }

    @FXML
    private void Delete_Supplier(ActionEvent event) {
         this.Delete_Supplier();
    }

    @FXML
    private void Suppliers_Search(ActionEvent event) {
          this.Suppliers_Search();
    }
    
    
       ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
     private void Edit_Supplier() {
         try {
         
         if ( !S_Tname.getText().equals("") && !S_TPhone.getText().equals("") && !S_TSaller.getText().equals("") &&!S_Ctype.getValue().equals("")  ){
            
             try{
                //yooooour coooode
            }catch (NumberFormatException es)
            {
                Alerts.showErrorAlert("لقد ادخلت قيمة غير صحيحة !!");
            }
         }else {
             Alerts.showErrorAlert("برجاء ملىء جميع الحقول المطلوبة");
                }
         }catch (NullPointerException e){
              Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
         }
         
        
    }
    
    
    private void Delete_Supplier() {
        
        try {
         if ( !S_Tname.getText().equals("") && !S_TPhone.getText().equals("") && !S_TSaller.getText().equals("") &&!S_Ctype.getValue().equals("") ){
            
             try{
                //yooooour coooode
            }catch (NumberFormatException es)
            {
                Alerts.showErrorAlert("لقد ادخلت قيمة غير صحيحة !!");
            }
         }else {
             Alerts.showErrorAlert("برجاء ملىء جميع الحقول المطلوبة");
                }
        }catch(NullPointerException e){
              Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
         }
    }
    
    
    private void Suppliers_Search() {
        
         if ( !S_TSearch.getText().equals("") && !S_Ctype.getValue().equals("") ){
            
             try{
                //yooooour coooode
            }catch (NumberFormatException es)
            {
                Alerts.showErrorAlert("لقد ادخلت قيمة غير صحيحة !!");
            }
         }
          else 
        {  
            Alerts.showErrorAlert("برجاء ادخال اسم المورد او التصنيف  ");
            
        }
    }
    private void AddSupplier()
    {
        try {
        if ( !S_Tname.getText().equals("") && !S_TPhone.getText().equals("") && !S_TSaller.getText().equals("")  && !S_Ctype.getValue().equals(""))
        {
            
             try{
                 
         Suppliers s =new Suppliers();
        s.setSupplierName(S_Tname.getText());
        s.setSupplierCategory(S_Ctype.getTypeSelector());
//        s.setSupplierPhone(Integer.parseInt(S_TPhone.getText()));
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
            }catch (NumberFormatException es)
            {
                Alerts.showErrorAlert("لقد ادخلت قيمة غير صحيحة !!");
            }
         }
        else {
             Alerts.showErrorAlert("برجاء ملىء جميع الحقول المطلوبة");
                }
        }catch (NullPointerException e){
              Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
         }

    }
    

    private void chechbox(DragEvent event) {
        ChoiceBox cd = new ChoiceBox();
    cd.setItems(FXCollections.observableArrayList(
    "new", "Electronic ", 
    new Separator(), "liquied", "meats")
); 
    }

    @FXML
    private void Key_Pressed(KeyEvent event) {
         try{
        if(event.getCode().equals(KeyCode.CONTROL.S)){
          this.AddSupplier(); }
        else if (event.getCode().equals(KeyCode.SHIFT.DELETE)){
             this.Delete_Supplier();
        }
    }catch(Exception e){}
       
    }

    @FXML
    private void key_Search(KeyEvent event) {
        try{
        if(event.getCode().equals(KeyCode.ENTER)){
          this.Suppliers_Search();
        }
    }catch(Exception e){}
    }

    @FXML
    private void selectFromTable(MouseEvent event) {
    }
}

