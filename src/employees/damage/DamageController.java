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
    private TableView<Damages> D_table;
    @FXML
    private TableColumn<Damages, String> t_cost;
    @FXML
    private TableColumn<Damages, String> t_kquan;
    @FXML
    private TableColumn<Damages, String> t_quan;
    @FXML
    private TableColumn<Damages, String> t_price;
    @FXML
    private TableColumn<Damages, String> t_cate;
    @FXML
    private TableColumn<Damages, String> t_bar;
    @FXML
    private TableColumn<Damages, String> t_num;
    DatabaseHandler databasehandeler;
    Price pri;
    /**
     * Initializes the controller class.
     */
    ObservableList<String> listB=FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databasehandeler=DatabaseHandler.getInstance();
        ObservableList<String> list= FXCollections.observableArrayList("قطعة","علبة","كرتونة");
        quntityComboBox.setItems(list);
        quntityComboBox.setValue("قطعة");
        date.setText(gettDate());
        DataHelper.checkDataBar(SearchField,listB); // get barcode of all products
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
    
    @FXML
    private void loadMainOfDamage(ActionEvent event) {
       // loadWindow ("/employees/main/employees.fxml");
       x.loadwindow(loadPane,"/employees/main/employees.fxml");
    }
    
    
   /* void loadWindow(String loc)
    {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(loc));
            loadPane.getChildren().setAll(pane);
           
        } catch (IOException ex) {
            Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    @FXML
    private void addQuntity(ActionEvent event) {
        this.addQuntity();
    } 

    @FXML
    private void addPaid(ActionEvent event) {
        this.addPaid();
    }

    @FXML
    private void saveDamage(ActionEvent event) {
        this.saveDamage();
    }

    @FXML
    private void cancelDamage(ActionEvent event) {
        this.cancelDamage();
    }
    
    
    /***************************************************************************************************************/
    /***************************************************************************************************************/
    /******************************************IMPLEMENTATION METHODS***********************************************/
    /***************************************************************************************************************/
    /***************************************************************************************************************/

    
    private void saveDamage()
    {
        if(!Quntity.getText().equals("") && !productBarcode.getText().equals(""))
        {
            Damages D=new Damages();
            D.setCurrentQuantity(Integer.parseInt(Quntity.getText()));
            Date JDBC_Date = Date.valueOf(this.date.getText());
            D.setDate(JDBC_Date);
            D.setTime(gettTime());
            D.setBarcodfiled(productBarcode.getText());
            D.setName(productName.getText());
            D.setQuantityKind(quntityComboBox.getValue());
            
            if(quntityComboBox.getValue().equals("قطعة")){
            D.setUintPrice(pri.getItemPrice());
            D.setCost(D.CalcCostOfSoldItem(pri.getItemPrice(),Double.parseDouble(Quntity.getText())));
            }
            else if(quntityComboBox.getValue().equals("علبة")){
            D.setUintPrice(pri.getPacketPrice());
            D.setCost(D.CalcCostOfSoldItem(pri.getPacketPrice(),Double.parseDouble(Quntity.getText())));
            }
            else if(quntityComboBox.getValue().equals("كرتونة")){
            D.setUintPrice(pri.getBoxPrice());
            D.setCost(D.CalcCostOfSoldItem(pri.getBoxPrice(),Double.parseDouble(Quntity.getText())));
            }
            
            boolean result = DataHelper.insertDamages(D);
            
            int qty=Integer.parseInt(Quntity.getText());
            boolean s= DataHelper.InterAction_B_Sales__Products_addQuan(productBarcode,qty,quntityComboBox.getValue());
            
            if(s){
                if(result){
                    D_table.getItems().add(D);
                    Alerts.showInfoAlert("تمت الاضافة !!");
                }
                else
                Alerts.showErrorAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
            }
        }
        else
            Alerts.showErrorAlert("لم يتم ادخال البيانات بشكل صحيح ! .. يرجى التأكد من ملئ جميع الحقول المطلوبه");
        
    }
    
    private void cancelDamage()
    {
        if(Alerts.ConfirmAlert("هل تريد مسح كل العناصر",""))
        {
            //yoooooour cooooode
        }
    }
    
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
    
    private void addPaid()
    {
        if(!paid.getText().equals(""))
        {
           //yooooooour coooooode 
        }
        else
        {
            Alerts.showErrorAlert("يرجى ادخال القيمة المدفوعة");
        }
        
    }

    @FXML
    private void SearchButton(ActionEvent event) {
        searrch();
    }
    
    private void searrch(){
        pri=new Price();
        DataHelper.fillSalesWithInfoOfProduct(SearchField.getText(),productBarcode,productName,productPrice,pri);
        System.out.println(pri.getItemPrice());  
    }

    @FXML
    private void D_SearchField(KeyEvent event) {
        searrch();
    }
    
    
   private void checkData(){
        String qu="SELECT * FROM damages"; 
        ResultSet rs=databasehandeler.execQuery(qu);
        try {
            while(rs.next()){
                String titlex=rs.getString("product_name");
                System.out.println(titlex);
                //list.add(titlex);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DamageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
