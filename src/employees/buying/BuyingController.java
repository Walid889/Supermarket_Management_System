/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.buying;

import Classes.*;
import Serial_dinamic.*;
import static Serial_dinamic.NewSerial.getSalesSerial;
import Serial_dinamic.Time_Out;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.DataHelper;
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
import javafx.scene.control.Alert;
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
public class BuyingController  extends NewSerial implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton loadMain;
    @FXML
    private Label date;
    @FXML
    private TextField billNumber;
    @FXML
    private Label productName;

    @FXML
    private Label productPrise;
    @FXML
    private TextField Quntity;
    private TextField tatalPrice;
    private TextField paid;
    private TextField rest;
    @FXML
    private JFXComboBox<String> quntityComboBox;
    @FXML
    private AnchorPane loadPane;
    @FXML
    private JFXComboBox<String> supplier;
    @FXML
    private TableView<Buying> B_table;
    @FXML
    private TableColumn<Buying, String> t_cost;
    @FXML
    private TableColumn<Buying, String> t_kquan;
    @FXML
    private TableColumn<Buying, String> t_quan;
    @FXML
    private TableColumn<Buying, String> t_price;
    @FXML
    private TableColumn<Buying, String> t_cate;
    
    @FXML
    private TableColumn<Buying, String> t_bar;
    @FXML
    private JFXTextField B_searchField;
    Price pri;
    private static double TOTAL=0;
    /**
     * Initializes the controller class.
     */
    ObservableList<String> listB=FXCollections.observableArrayList();
    @FXML
    private TextField totalPrice;
    @FXML
    private Label productBarcode;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list= FXCollections.observableArrayList("قطعة","علبة","كرتونة");
        ObservableList<String> list2= FXCollections.observableArrayList("اتش","ياسر","ليدا");
        quntityComboBox.setItems(list);
        supplier.setItems(list2);
        date.setText(gettDate());
        setSalesSerial(DataHelper.getLastSerialTodayBuying(gettDate()));
        billNumber.setText(getSalesSerial()+"");
        initTableViewCols();
        DataHelper.checkDataBar(B_searchField,listB); // get barcode of all products
    }    
    private  void initTableViewCols(){
        t_bar.setCellValueFactory(new PropertyValueFactory<>("barcodfiled"));
        t_cate.setCellValueFactory(new PropertyValueFactory<>("name"));
        t_price.setCellValueFactory(new PropertyValueFactory<>("number"));
        t_quan.setCellValueFactory(new PropertyValueFactory<>("CurrentQuantity"));
        t_kquan.setCellValueFactory(new PropertyValueFactory<>("quantityKind"));
        t_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
    }
    private void ser(){ // set dinamic serial to bills .. every 24 hours it set serial to 1 
        Serial_B z;
        Time_Out t=new Time_Out();
        int s=t.getHoursUntilTarget();
        z=new Serial_B(s);
    }
    @FXML
    private void loadMainOfBuying(ActionEvent event) {
        //loadWindow ("/employees/main/employees.fxml");
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
    private void addBuying(ActionEvent event) {
        this.addBuying();
    }

    @FXML
    private void addQuntity(ActionEvent event) {
        this.addQuntity();
    }

    
    @FXML
    private void cancelBuying(ActionEvent event) {
        if(Alerts.ConfirmAlert("هل تريد مسج جميع عناصر فاتورة الشراء؟",""))
        {
            
        }

    }
    
    
    
    /**************************************************************************************************************/
    /**************************************************************************************************************/
    /**************************************************************************************************************/
    /**************************************************************************************************************/
    /*****************************************IMPLEMENTATION OF METHODS********************************************/

    
    private void addBuying()
    {
        if(!totalPrice.getText().equals(""))
        {
            billNumber.setText(getSalesSerial()+"");
            Buying B=new Buying();
            B.setSerial(Integer.parseInt(billNumber.getText()));
            Date JDBC_Date = Date.valueOf(this.date.getText());
            B.setDate(JDBC_Date);
            B.setTime(gettTime());
            B.setSupplier(supplier.getValue());
            B.setTotalPrice(Double.parseDouble(totalPrice.getText()));

            boolean result = DataHelper.insertBuyGoodsNewBill(B);
            
            increment_Sales(); //
            billNumber.setText(getSalesSerial()+"");
            System.out.println(getSalesSerial());
            TOTAL=0;
            clear();
            if(result){
                Alerts.showInfoAlert("تم اضافة الفاتورة رقم  بنجاح !!");
            }
            else
                Alerts.showErrorAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
        }
        else
            Alerts.showErrorAlert("لم يتم ادخال البيانات بشكل صحيح!  .. يرجى التأكد من ملئ جميع الحقول المطلوبة");
        
    }
     
    
    private void addQuntity()
    {
        if(!Quntity.getText().equals(""))
        {
            Buying B=new Buying();
            
            try{
            B.setCurrentQuantity(Integer.parseInt(Quntity.getText()));
            
            B.setSerial(Integer.parseInt(billNumber.getText()));
            Date JDBC_Date = Date.valueOf(this.date.getText());
            B.setDate(JDBC_Date);
            B.setBarcodfiled(productBarcode.getText());
            B.setName(productName.getText());
            B.setQuantityKind(quntityComboBox.getValue());
            if(quntityComboBox.getValue().equals("قطعة")){
            B.setUintPrice(pri.getItemPrice());
            B.setCost(B.CalcCostOfSoldItem(pri.getItemPrice(),Double.parseDouble(Quntity.getText())));
            }
            else if(quntityComboBox.getValue().equals("علبة")){
            B.setUintPrice(pri.getPacketPrice());
            B.setCost(B.CalcCostOfSoldItem(pri.getPacketPrice(),Double.parseDouble(Quntity.getText())));
            }
            else if(quntityComboBox.getValue().equals("كرتونة")){
            B.setUintPrice(pri.getBoxPrice());
            B.setCost(B.CalcCostOfSoldItem(pri.getBoxPrice(),Double.parseDouble(Quntity.getText())));
            }
            long k=DataHelper.getLastOrderNumberBuying();
            B.setNumber(k);
            boolean result =DataHelper.insertBuyGoods(B);
            

            TOTAL+=B.getCost();
            totalPrice.setText(TOTAL+"");
            System.out.println(k);
            int qty=Integer.parseInt(Quntity.getText());
            boolean s= DataHelper.InterAction_B_Sales__Products_DeleteQuan(productBarcode.getText(),qty,quntityComboBox.getValue());
            if(s){
                if(result){
                    B_table.getItems().add(B);
                    Alerts.showInfoAlert("تمت الاضافة !!");
                }
                else
                Alerts.showErrorAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
            }
            
            }catch(NumberFormatException es){
                Alerts.showErrorAlert("لقد ادخلت قيمة غير صحيحة !!");
            }
            
        }
        else
        {
            Alerts.showErrorAlert("يرجى ادخال الكمية");
        }
    }
    
 

    @FXML
    private void B_SearchButton(ActionEvent event) {
        searrch();
        productPrise.setText(pri.getItemPrice()+"");
    }
    private void searrch(){
        pri=new Price();
        DataHelper.fillSalesWithInfoOfProduct(B_searchField.getText(),productBarcode,productName,productPrise,pri);
        System.out.println(pri.getItemPrice());  
    }

    @FXML
    private void B_SearchField(KeyEvent event) {
        searrch();  
    }
    private void clear(){
        B_searchField.clear();
        B_table.getItems().clear();
        productBarcode.setText("");
        productName.setText("");
        productPrise.setText("");
        supplier.setValue("");
        Quntity.clear();
        totalPrice.clear();
    }
}
