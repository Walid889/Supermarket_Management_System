/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.damage;

import Classes.*;
import Serial_dinamic.*;
import database.*;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.DataHelper;
import employees.main.EmployeesController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class DamageController extends NewSerial implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private AnchorPane loadPane;
    @FXML
    private Label date;
    @FXML
    private TextField Quntity;
    @FXML
    private TextField paid;
    @FXML
    private JFXComboBox<String> quntityComboBox;
    @FXML
    private TextField damNumber;
    @FXML
    private Label productBarcode;
    @FXML
    private Label productName;
    @FXML
    private Label productPrice;
    @FXML
    private JFXTextField SearchField;
    @FXML
    private TableView<Common_Properties> D_table;
    @FXML
    private TableColumn<Common_Properties, String> t_cost;
    @FXML
    private TableColumn<Common_Properties, String> t_kquan;
    @FXML
    private TableColumn<Common_Properties, String> t_quan;
    @FXML
    private TableColumn<Common_Properties, String> t_price;
    @FXML
    private TableColumn<Common_Properties, String> t_cate;
    @FXML
    private TableColumn<Common_Properties, String> t_bar;
    DatabaseHandler databasehandeler;
    Price pri;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databasehandeler=DatabaseHandler.getInstance();
        ObservableList<String> list= FXCollections.observableArrayList("قطعة","علبة","كرتونة");
        quntityComboBox.setItems(list);
        quntityComboBox.setValue("قطعة");
        date.setText(gettDate());
        DataHelper.checkDataBar(SearchField); // get barcode of all products
        initTableViewCols();
        DataHelper.loadDamageData(D_table, gettDate());
    }    
    private  void initTableViewCols(){
        t_bar.setCellValueFactory(new PropertyValueFactory<>("barcodfiled"));
        t_cate.setCellValueFactory(new PropertyValueFactory<>("name"));
        t_price.setCellValueFactory(new PropertyValueFactory<>("UintPrice"));
        t_quan.setCellValueFactory(new PropertyValueFactory<>("CurrentQuantity"));
        t_kquan.setCellValueFactory(new PropertyValueFactory<>("quantityKind"));
        t_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
    }
    
    /******************* Search with button or pressing enter ******************/
    @FXML
    private void SearchButton(ActionEvent event) {
        searrch();
    }
    
    private void searrch(){
        pri=new Price();
        DataHelper.fillSalesWithInfoOfProduct(SearchField.getText(),productBarcode,productName,productPrice,pri);
        // fill Search Field with barcodes of all products in market
        // pri : initialize price of item,packet,box of specific product you search about
        System.out.println(pri.getItemPrice());  
    }

    @FXML
    private void D_SearchField(KeyEvent event) {
        searrch();
    }
    /**************************************************************************/
    
    /************************* ADD DAMAGES TO DATABASE ************************/
    @FXML
    private void saveDamage(ActionEvent event) {
        this.saveDamage();
    }
    
    @FXML
    private void A_Q(KeyEvent event) {
        try{
        if(event.getCode().equals(KeyCode.ENTER)) 
             this.saveDamage();
        }catch(Exception e){}
    }
    /**************************************************************************/
    
    @FXML
    private void addQuntity(ActionEvent event) {
        this.addQuntity();
    } 

//    @FXML
//    private void addPaid(ActionEvent event) {
//        this.addPaid();
//    }

    

    @FXML
    private void cancelDamage(ActionEvent event) {
        this.cancelDamage();
    }
    
    
    /***************************************************************************************************************/
    /***************************************************************************************************************/
    /******************************************IMPLEMENTATION METHODS***********************************************/
    /***************************************************************************************************************/
    /***************************************************************************************************************/

    /************************************************** saveDamage()______*/
    private void saveDamage()
    {
        if(!Quntity.getText().equals("") && !productBarcode.getText().equals(""))
        {
            if (Integer.parseInt(Quntity.getText())>0){
                
            
            Common_Properties D =new Common_Properties() ,D1;
            double UintPrice=0,cost=0;
            
            int CurrentQuantity=Integer.parseInt(Quntity.getText());
            Date JDBC_Date = Date.valueOf(this.date.getText());
            //D.setDate(JDBC_Date);
            Time time=gettTime();
            String barcodfiled=productBarcode.getText();
            String name=productName.getText();
            String QuantityKind=quntityComboBox.getValue();
            if(quntityComboBox.getValue().equals("قطعة")){
            UintPrice=pri.getItemPrice();
            cost=D.CalcCostOfSoldItem(pri.getItemPrice(),Double.parseDouble(Quntity.getText()));
            }
            else if(quntityComboBox.getValue().equals("علبة")){
            UintPrice=pri.getPacketPrice();
            cost=D.CalcCostOfSoldItem(pri.getPacketPrice(),Double.parseDouble(Quntity.getText()));
            }
            else if(quntityComboBox.getValue().equals("كرتونة")){
            UintPrice=pri.getBoxPrice();
            cost=D.CalcCostOfSoldItem(pri.getBoxPrice(),Double.parseDouble(Quntity.getText()));
            }
            long k=DataHelper.getLastOrderNumberDamage();
            
            //boolean result = DataHelper.insertDamages(D);
            D1 =new Common_Properties(barcodfiled, name, UintPrice, CurrentQuantity, QuantityKind, cost, JDBC_Date, time,k);
            boolean result = DataHelper.insertDamages(D1);
            
            int qty=Integer.parseInt(Quntity.getText());
            boolean s= DataHelper.InterAction_B_Sales__Products_addQuan(productBarcode,qty,quntityComboBox.getValue());
            
            if(s){
                if(result){
                    D_table.getItems().add(D1);
                    clear();
                    Alerts.showInfoAlert("تمت الاضافة !!");
                }
                else
                Alerts.showErrorAlert("لم تتم العملية بشكل صحيح ");
            }
        }else  Alerts.showErrorAlert("البيانات الذي ادخلتها غير صحيحة");
//        else
//            Alerts.showErrorAlert("لم يتم ادخال البيانات بشكل صحيح ! .. يرجى التأكد من ملئ جميع الحقول المطلوبه");
//        
    }
    }
    
    private void cancelDamage()
    {
        if(Alerts.ConfirmAlert("هل تريد مسح كل العناصر",""))
        {
            //yoooooour cooooode
        }
    }
    
    private void clear(){
        SearchField.clear();
        productName.setText("");
        productPrice.setText("");
        productBarcode.setText("");
        Quntity.clear();
    }
    
    /**********************************************************************************************/
    /**********************************************************************************************/
    /**********************************************************************************************/
    /**********************************************************************************************/
    /**********************************************************************************************/
    
    private void addQuntity()
    {
        if(!Quntity.getText().equals(""))
        {
            //yoooour coooode
        }
        else
        {
            Alerts.showErrorAlert("يرجى ادخال الكمية");
        }
    }
    
//    private void addPaid()
//    {
//        if(!paid.getText().equals(""))
//        {
//           //yooooooour coooooode 
//        }
//        else
//        {
//            Alerts.showErrorAlert("يرجى ادخال القيمة المدفوعة");
//        }
//        
    
    
    /*********************************      LOAD PAGES     ***************************************/
    @FXML
    private void loadMainOfDamage(ActionEvent event) {
       x.loadwindow(loadPane,"/employees/main/employees.fxml");
    }

    /***************************_____________THE END______________********************************/ 
    
}
