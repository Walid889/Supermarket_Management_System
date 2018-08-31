/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.sales;

import Serial_dinamic.*;
import Classes.*;
import database.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import employees.main.EmployeesController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class SalesController extends NewSerial implements Initializable {
    @FXML
    private Label date;
    @FXML
    private JFXButton saveBill;
    @FXML
    private JFXButton cancelBill;
    @FXML
    private JFXButton freezeBill;
    @FXML
    private JFXButton PreviousProcess;
    @FXML
    private JFXButton nextProcess;
    @FXML
    private JFXButton loadMain;
    @FXML
    private JFXButton search;
    @FXML
    private TextField billNumber;
    
    @FXML
    private JFXButton delete;
    @FXML
    private Label productName;
    @FXML
    private Label productVolume;
    @FXML
    private Label productPrice;
    @FXML
    private TextField Quntity;
    @FXML
    private TextField paid;
    @FXML
    private TextField rest;
    @FXML
    private JFXComboBox<String> quntityComboBox;
    @FXML
    private AnchorPane loadPane;
    @FXML
    private TableView<Sales> billTabel;
    @FXML
    private TableColumn<Sales, String> c_cost;
    @FXML
    private TableColumn<Sales, String> c_quantity;
    @FXML
    private TableColumn<Sales, String> c_price;
    @FXML
    private TableColumn<Sales, String> c_item;
    @FXML
    private TableColumn<Sales, String> c_quantityKind;
    @FXML
    private TextField totalPrice;
    
    private static double TOTAL=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list= FXCollections.observableArrayList("قطعة","علبة","كرتونة");
        quntityComboBox.setItems(list);
        quntityComboBox.setValue("قطعة");
        c_item.setCellValueFactory(new PropertyValueFactory<>("name"));
        c_price.setCellValueFactory(new PropertyValueFactory<>("UintPrice"));
        c_quantity.setCellValueFactory(new PropertyValueFactory<>("CurrentQuantity"));
        c_quantityKind.setCellValueFactory(new PropertyValueFactory<>("quantityKind"));
        c_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        date.setText(gettDate());
        billNumber.setText(getSalesSerial()+"");
        ser(); // Set Dinamic Serial Number and Date
    }    
    private void ser(){
        Serial_S z;
        Time_Out t=new Time_Out();
        int s=t.getHoursUntilTarget();
        z=new Serial_S(s);
    }
    
    /************************* ADD BILL TO DATABASE ***************************/
    @FXML
    private void AddNewBill(ActionEvent event) {
        this.AddNewBill();
        clear();
    }
    @FXML
    private void A_N_B(KeyEvent event) {    // AddNewBill(); do it by pressing into enter key while focus on "جديد" Button
        if(event.getCode().equals(KeyCode.SHIFT.Z)) {
             // do something
             this.AddNewBill();
             clear();
        }
    }
    /**************************************************************************/
    
    /************************* ADD ITEMS TO BILL TABLE VIEW *******************/
    @FXML
    private void AddQuantity(ActionEvent event) {
        this.AddQuantity();
    }
    @FXML
    private void Q_A_K(KeyEvent event) {    // AddQuantity(); do it by pressing into enter key while focus on Quantity textfield
        if(event.getCode().equals(KeyCode.ENTER)) {
             // do something
             this.AddQuantity();
        }
    }
    /**************************************************************************/
    
    /********************* DELETE ROW FROM TABLE VIEW *************************/
    @FXML
    private void DeleteRow(ActionEvent event) {
        this.DeleteRow();
    }
    @FXML
    private void D_I_T(KeyEvent event) {
        if(event.getCode().equals(KeyCode.DELETE)) {
             // do something
             this.DeleteRow();
        }
    }
    /**************************************************************************/
    
    /*********************** ADD PAID MONEY ***********************************/
    @FXML
    private void AddPaid(ActionEvent event) {
        this.AddPaid();
        
    }
    @FXML
    private void E_P(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)) {
             // do something
             this.AddPaid();
             
        }
    }
    /**************************************************************************/
    
    
    @FXML
    private void loadMainOfSales(ActionEvent event) {
        loadWindow("/employees/main/employees.fxml");
    }
    
    void loadWindow(String loc)
    {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(loc));
            loadPane.getChildren().setAll(pane);
           
        } catch (IOException ex) {
            Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    private void AddNewBill(){
        billNumber.setText(getSalesSerial()+"");
        Sales S=new Sales();
        S.setSerial(Integer.parseInt(billNumber.getText()));
        Date JDBC_Date = Date.valueOf(this.date.getText());
        S.setDate(JDBC_Date);
        S.setTotalPrice(Double.parseDouble(totalPrice.getText()));
        S.setPaid(Double.parseDouble(this.paid.getText()));
        S.setReminderMoney(Double.parseDouble(this.rest.getText()));
        
        boolean result = DataHelper.insertNewBill(S);
        increment_Sales(); // increment_Serial_Sales
        billNumber.setText(getSalesSerial()+"");
        System.out.println(getSalesSerial());
        TOTAL=0;
        if(result){
            Alert AT=new Alert(Alert.AlertType.INFORMATION);
            AT.setHeaderText(null);
            AT.setContentText("Successfully Added !!");
            AT.showAndWait();
            return;
        }
    }
    private void AddQuantity() {
        
        Sales S=new Sales();  
        S.setSerial(Integer.parseInt(billNumber.getText()));
        Date JDBC_Date = Date.valueOf(this.date.getText());
        S.setDate(JDBC_Date);
        S.setName(productName.getText());
        S.setUintPrice(Double.parseDouble(productPrice.getText()));
        S.setCurrentQuantity(Integer.parseInt(Quntity.getText()));
        if(quntityComboBox.getValue().equals("قطعة")){
            //S.setItemsQuantity(S.getCurrentQuantity());
            S.setQuantityKind("قطعة");
        }
        else if(quntityComboBox.getValue().equals("علبة")){
            //S.setPacketsQuantity(S.getCurrentQuantity());
            S.setQuantityKind("علبة");
        }
        else if(quntityComboBox.getValue().equals("كرتونة")){
            //S.setBoxesQuantity(S.getCurrentQuantity());
            S.setQuantityKind("كرتونة");
        }
        
        S.setCost(S.CalcCostOfSoldItem(Double.parseDouble(productPrice.getText()),Double.parseDouble(Quntity.getText())));
        
        boolean result = DataHelper.insertNewSale(S);
        billTabel.getItems().add(S);
        
        TOTAL+=S.getCost();
        totalPrice.setText(TOTAL+"");
        
        if(result){
            Alert AT=new Alert(Alert.AlertType.INFORMATION);
            AT.setHeaderText(null);
            AT.setContentText("Successfully Added !!");
            AT.showAndWait();
            return;
        }

    }
    
    private void AddPaid(){
        Sales S=new Sales();
        double reminder=S.CalcReminderMoney(Double.parseDouble(paid.getText()),
                     Double.parseDouble(totalPrice.getText()));
        rest.setText(reminder+"");
    }
    
    private void DeleteRow(){
        
        double c=billTabel.getSelectionModel().getSelectedItem().getCost();
        Sales S=billTabel.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting book");
        alert.setContentText("Are you sure want to delete the book " + S.getName() + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            
            Boolean result = DataHelper.deleteSale(S);
            
            if (result) {
                try{
                double p=Double.parseDouble(rest.getText());
                rest.setText((c+p)+"");
                }catch(Exception ex){}

                billTabel.getItems().removeAll(billTabel.getSelectionModel().getSelectedItem()); // delete item from ui table

                TOTAL-=c;
                totalPrice.setText(TOTAL+"");
                
                Alert AT=new Alert(Alert.AlertType.INFORMATION);
                AT.setHeaderText(null);
                AT.setContentText("Successfully Deleted !!");
                AT.showAndWait();
                return;
            } else {
                Alert AT=new Alert(Alert.AlertType.ERROR);
                AT.setHeaderText(null);
                AT.setContentText("Failed to Delete !!");
                AT.showAndWait();
                return;
            }
        } else {
            Alert AT=new Alert(Alert.AlertType.ERROR);
                AT.setHeaderText(null);
                AT.setContentText("Deletion Canceled !!");
                AT.showAndWait();
                return;
        }
        
    }

    private void clear(){
        productName.setText("");
        productPrice.setText("");
        Quntity.clear();
        totalPrice.clear();
        paid.clear();
        rest.clear();
        billTabel.getItems().clear();
    }

    
    

    
}























       /* try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage= new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            Image icon = new Image("/icons/my_account.png");
            stage.getIcons().add(icon);
            stage.setScene(new Scene(parent));
            stage.show();
        } 
        catch (IOException ex) {
            Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }*/