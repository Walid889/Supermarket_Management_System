/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.recall;



import com.jfoenix.controls.JFXRadioButton;

import Classes.Alerts;
import Classes.Price;
import Classes.Recalls;
import Serial_dinamic.NewSerial;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import database.DataHelper;
import database.DatabaseHandler;
import employees.main.EmployeesController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class RecallController extends NewSerial implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private AnchorPane loadPane;
    @FXML
    private Label date;
    @FXML
    private JFXTextField R_SearchField;
    @FXML
    private JFXRadioButton R_FCustomer;
    @FXML
    private ToggleGroup RecallFrom;
    @FXML
    private Label productBarcode;
    @FXML
    private Label productName;
    @FXML
    private Label productPrice;
    @FXML
    private JFXRadioButton R_ToCampany;
    @FXML
    private TableView<Recalls> R_table;
    @FXML
    private TableColumn<Recalls, String> t_cost;
    @FXML
    private TableColumn<Recalls, String> t_kquan;
    @FXML
    private TableColumn<Recalls, String> t_quan;
    @FXML
    private TableColumn<Recalls, String> t_price;
    @FXML
    private TableColumn<Recalls, String> t_cate;
    @FXML
    private TableColumn<Recalls, String> t_bar;
    @FXML
    private TableColumn<Recalls, String> t_source;
    @FXML
    private JFXComboBox<String> quntityComboBox;
    @FXML
    private TextField Quntity;

    /**
     * Initializes the controller class.
     */
    Price pri;
    ObservableList<String> listB=FXCollections.observableArrayList();
    DatabaseHandler databasehandeler;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databasehandeler=DatabaseHandler.getInstance();
        ObservableList<String> list= FXCollections.observableArrayList("قطعة","علبة","كرتونة");
        quntityComboBox.setItems(list);
        quntityComboBox.setValue("قطعة");
        date.setText(gettDate());
        DataHelper.checkDataBar(R_SearchField,listB); // get barcode of all products
        DataHelper.loadRecallsData(R_table, gettDate());
        initTableViewCols();
    }    
    private  void initTableViewCols(){
        t_source.setCellValueFactory(new PropertyValueFactory<>("source"));
        t_bar.setCellValueFactory(new PropertyValueFactory<>("barcodfiled"));
        t_cate.setCellValueFactory(new PropertyValueFactory<>("name"));
        t_price.setCellValueFactory(new PropertyValueFactory<>("UintPrice"));
        t_quan.setCellValueFactory(new PropertyValueFactory<>("CurrentQuantity"));
        t_kquan.setCellValueFactory(new PropertyValueFactory<>("quantityKind"));
        t_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
    }
    

    @FXML
    private void AddRecall(ActionEvent event) {
        if(!Quntity.getText().equals("") && !productBarcode.getText().equals("")){
            Recalls R=new Recalls();
            try{
            R.setCurrentQuantity(Integer.parseInt(Quntity.getText()));
            Date JDBC_Date = Date.valueOf(this.date.getText());
            R.setDate(JDBC_Date);
            R.setTime(gettTime());
            R.setBarcodfiled(productBarcode.getText());
            R.setName(productName.getText());
            if(R_FCustomer.isSelected())
                R.setSource("من عميل");
            else
                R.setSource("للشركة");
            R.setQuantityKind(quntityComboBox.getValue());
            
            if(quntityComboBox.getValue().equals("قطعة")){
            R.setUintPrice(pri.getItemPrice());
            R.setCost(R.CalcCostOfSoldItem(pri.getItemPrice(),Double.parseDouble(Quntity.getText())));
            }
            else if(quntityComboBox.getValue().equals("علبة")){
            R.setUintPrice(pri.getPacketPrice());
            R.setCost(R.CalcCostOfSoldItem(pri.getPacketPrice(),Double.parseDouble(Quntity.getText())));
            }
            else if(quntityComboBox.getValue().equals("كرتونة")){
            R.setUintPrice(pri.getBoxPrice());
            R.setCost(R.CalcCostOfSoldItem(pri.getBoxPrice(),Double.parseDouble(Quntity.getText())));
            }
            boolean result=DataHelper.insertNewRecall(R);
            int qty=Integer.parseInt(Quntity.getText());
            boolean s=DataHelper.InterAction_B_Sales__Products_DeleteQuan(productBarcode.getText(), qty, quntityComboBox.getValue());
            if(s){
                if(result){
                    R_table.getItems().add(R);
                    Alerts.showInfoAlert("تمت الاضافة !!");
                }
                else
                Alerts.showErrorAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
            }
            }catch(NumberFormatException e){Alerts.showErrorAlert("لقد ادخلت قيمة غير صحيحة ");}
        }
        else
            Alerts.showErrorAlert("لم يتم ادخال البيانات بشكل صحيح ! .. يرجى التأكد من ملئ جميع الحقول المطلوبه");
    }

    @FXML
    private void cancelRecall(ActionEvent event) {
        clear();
    }
    private void clear(){
        R_SearchField.clear();
        quntityComboBox.setValue("قطعة");
        Quntity.clear();
        productBarcode.setText("");
        productName.setText("");
        productPrice.setText("");
    }

    
    
    
    
    
    
    
    @FXML
    private void R_SearchButton(ActionEvent event) {
        searrch();
    }
    private void searrch(){
        pri=new Price();
        DataHelper.fillSalesWithInfoOfProduct(R_SearchField.getText(),productBarcode,productName,productPrice,pri);
        System.out.println(pri.getItemPrice());  
    }

    @FXML
    private void R_SearchField(KeyEvent event) {
        searrch();
    }
 
    
        @FXML
    private void loadMainOfRecall(ActionEvent event) {
    //loadWindow ("/employees/main/employees.fxml");
        x.loadwindow(loadPane, "/employees/main/employees.fxml");
    }

}
