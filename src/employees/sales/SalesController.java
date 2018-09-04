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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
import javafx.scene.control.CheckBox;
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
    private JFXButton loadMain;
    @FXML
    private JFXButton search;
    @FXML
    private TextField billNumber;
    @FXML
    private Label productName;
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
    @FXML
    private CheckBox AllCheckbox;
    @FXML
    private TableColumn<Sales, String> c_num;
    @FXML
    private TableView<Sales> SalesTabel;
    /**
     * Initializes the controller class.
     */
    
    /***************************************************************************************************************/
    /******************************************INITIALIZATION*******************************************************/
    /***************************************************************************************************************/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list= FXCollections.observableArrayList("قطعة","علبة","كرتونة");
        quntityComboBox.setItems(list);
        quntityComboBox.setValue("قطعة");
        date.setText(gettDate());
        billNumber.setText(getSalesSerial()+"");
        initTableViewCols();
        ser(); // Set Dinamic Serial Number and Date
    }    
    private  void initTableViewCols(){
        c_item.setCellValueFactory(new PropertyValueFactory<>("name"));
        c_price.setCellValueFactory(new PropertyValueFactory<>("UintPrice"));
        c_quantity.setCellValueFactory(new PropertyValueFactory<>("CurrentQuantity"));
        c_quantityKind.setCellValueFactory(new PropertyValueFactory<>("quantityKind"));
        c_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        c_num.setCellValueFactory(new PropertyValueFactory<>("number"));
    }
    private void ser(){ // set dinamic serial to bills .. every 24 hours it set serial to 1 
        Serial_S z;
        Time_Out t=new Time_Out();
        int s=t.getHoursUntilTarget();
        z=new Serial_S(s);
    }
    /***************************************************************************************************************/
    /***************************************************************************************************************/
    /***************************************************************************************************************/
    
    
    
    
    
    /************************* ADD BILL TO DATABASE ***************************************************************/
    @FXML
    private void AddNewBill(ActionEvent event) { // AddNewBill(); do it by mouse click on button "جديد"
        this.AddNewBill();
    }
    @FXML
    private void A_N_B(KeyEvent event) {    // AddNewBill(); do it by pressing into enter key while focus on "جديد" Button
        try{
        if(event.getCode().equals(KeyCode.SHIFT.Z)) {
             this.AddNewBill();
        }
        }catch(Exception e){}
    }
    /*************************************************************************************************************/
    
    /************************* ADD ITEMS TO BILL TABLE VIEW ******************************************************/
    @FXML
    private void AddQuantity(ActionEvent event) { // AddQuantity(); do it by mouse click on button "إدخال الكمية"
        this.AddQuantity();
    }
    @FXML
    private void Q_A_K(KeyEvent event) {    // AddQuantity(); do it by pressing into enter key while focus on Quantity textfield
        try{
        if(event.getCode().equals(KeyCode.ENTER)) {
             this.AddQuantity();
        }
        }catch(Exception e){}
    }
    /***************************************************************************************************/
    
    /********************* DELETE ROW FROM TABLE VIEW **************************************************/
    @FXML
    private void DeleteRow(ActionEvent event) {
            this.DeleteRow(); 
    }
    
    @FXML
    private void D_I_T(KeyEvent event) { 
        try{
        if(event.getCode().equals(KeyCode.DELETE)) { // DeleteRow(); do it by pressing in Delete key while focus on row in table view
             // do something
             this.DeleteRow();
        }}catch(Exception e){
            if(event.getCode().equals(KeyCode.DELETE)){
            this.deleteAllRows();
            }
        }
        
    }
    /************************************************************************************************/
    
    /********************* DELETE ALL ROWS FROM TABLE VIEW *************************/
    @FXML
    private void DeleteAllRows(ActionEvent event) { // it's KeyEvent in D_I_T method
        deleteAllRows();
    }
    /*******************************************************************************/
    
    /*********************** ADD PAID MONEY ***********************************/
    @FXML
    private void AddPaid(ActionEvent event) {
        this.AddPaid();
    }
    @FXML
    private void E_P(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)) {
             this.AddPaid();
        }
    }
    
    
    /***************************** CANCEL BILL ********************************/
    @FXML
    private void cancelBill(ActionEvent event) {
        if (Alerts.ConfirmAlert("هل تريد مسح جميع عناصر الفاتورة ؟!!","")) {
        deleteAllRows();
        clear();
        }
    }
    /**************************************************************************/
                /****************************************************/
                            /**********************/
    
    /* * * * @ @ @           NEW TABLE FOR FREEZING           @ @ @ * * * * /
    
    */
    /***************************** FREEZE BILL ********************************/
    @FXML
    private void freezeBill(ActionEvent event) {
       checksales();
    }
    /**************************************************************************/
    /***********************Previous Process***********************************/
    @FXML
    private void PreviousProcess(ActionEvent event) {
        
    }
    /***********************Next Process***************************************/
    @FXML
    private void NextProcess(ActionEvent event) {
        
    }
    /**************************************************************************/
    
    
                        /********************************/
                /****************************************************/
    /**************************************************************************/
    
    
    /**************************************************************************/
    private long checkData(){
        String qu="SELECT number FROM sales ORDER BY number DESC FETCH FIRST ROW ONLY"; 
        ResultSet rs=DatabaseHandler.getInstance().execQuery(qu);
        long num = 0;
        try {
            if(rs.next()){
                num=Integer.parseInt(rs.getString("number"))+1;
                System.out.println("llllllllllll");}
            else
           {
                num=1;
                System.out.println("لسااااا");
//              Alerts.showInfoAlert("اول فواتير اليوم ..");
           }
        } catch (SQLException ex) {
            Logger.getLogger(SalesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
    private void checksales(){
        String qu="SELECT * FROM sales";
        ResultSet rs=DatabaseHandler.getInstance().execQuery(qu);
        try {
            while(rs.next()){
                int x1=rs.getInt("number");
                int x2=rs.getInt("sale_id");
                Date x3=rs.getDate("sale_date");
                String x4=rs.getString("product_name");
                String x5=rs.getString("qty_kind");
                double x6=rs.getDouble("unit_price");
                int x7=rs.getInt("current_qty");
                double x8=rs.getDouble("cost");
                Time t=rs.getTime("t_time");
                
                System.out.println(x1+" "+x2+" "+x3+" "+x4+" "+x5+" "+x6+" "+x7+" "+x8);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SalesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*****************************************************************************************************************/
    /*****************************************************************************************************************/
    /*****************************************************************************************************************/
    /*****************************************************************************************************************/
    /***************************************IMPLEMENTATION OF METHODS*************************************************/
    /*****************************************************************************************************************/
    private void AddNewBill(){
        if(!totalPrice.getText().equals("")&&!this.paid.getText().equals("") && !this.rest.getText().equals("")){
            billNumber.setText(getSalesSerial()+"");
            Sales S=new Sales();
            S.setSerial(Integer.parseInt(billNumber.getText()));
            Date JDBC_Date = Date.valueOf(this.date.getText());
            S.setDate(JDBC_Date);
            S.setTime(gettTime());
            S.setTotalPrice(Double.parseDouble(totalPrice.getText()));
            S.setPaid(Double.parseDouble(this.paid.getText()));
            S.setReminderMoney(Double.parseDouble(this.rest.getText()));

            boolean result = DataHelper.insertNewBill(S);
            billNumber.setText(getSalesSerial()+"");
            increment_Sales(); // increment_Serial_Sales
            System.out.println(getSalesSerial());
            TOTAL=0;
            
            paid.setText(gettTime()+"");
            clear();
            if(result){
                Alerts.showInfoAlert("تم اضافة الفاتورة رقم  بنجاح !!");
            }
            else
                Alerts.showErrorAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
        }
        else
        {
            Alerts.showErrorAlert("لم يتم ادخال بيانات الفاتورة بشكل صحيح !!");
        }
    }
    private void AddQuantity() {
        
            Sales S=new Sales(); 
            try{
            S.setCurrentQuantity(Integer.parseInt(Quntity.getText()));
            
            S.setSerial(Integer.parseInt(billNumber.getText()));
            Date JDBC_Date = Date.valueOf(this.date.getText());
            S.setDate(JDBC_Date);
            S.setName(productName.getText());
            S.setUintPrice(Double.parseDouble(productPrice.getText()));
            
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
            
            long k=checkData();
            S.setNumber(k);
            boolean result = DataHelper.insertNewSale(S);
            SalesTabel.getItems().add(S);

            TOTAL+=S.getCost();
            totalPrice.setText(TOTAL+"");
            System.out.println(k);
            if(result){
                Alerts.showInfoAlert("تمت الاضافة !!");
            }
            else
                Alerts.showErrorAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
        
            }catch(NumberFormatException es){
                Alerts.showErrorAlert("لقد ادخلت قيمة غير صحيحة !!");
            }
            
    }
    
    private void AddPaid(){
        Sales S=new Sales();
        try{
            if(paid.getText().equals(""))
                {Alerts.showErrorAlert("يرجى ادخال المبلغ المدفوع");}
            else{
                double reminder=S.CalcReminderMoney(Double.parseDouble(paid.getText()),
                             Double.parseDouble(totalPrice.getText()));
                rest.setText(reminder+"");
            }
        }catch(NumberFormatException ex){
            Alerts.showErrorAlert("لقد ادخلت قيمةغير صحيحة");
        }
    }
    
    private void DeleteRow(){
        if(SalesTabel.getItems().isEmpty()){
            Alerts.showErrorAlert("لا يوجد بيانات فى الجدول !!");
        }
        else{
            double c=SalesTabel.getSelectionModel().getSelectedItem().getCost();
            Sales S =SalesTabel.getSelectionModel().getSelectedItem();
            if (Alerts.ConfirmAlert("هل تريد مسح", S.getName())) {
                Boolean result = DataHelper.deleteSale(S);
                if (result) {
                    try{
                    double p=Double.parseDouble(rest.getText());
                    rest.setText((c+p)+"");
                    }catch(Exception ex){}
                    SalesTabel.getItems().removeAll(SalesTabel.getSelectionModel().getSelectedItem()); // delete item from ui table
                    TOTAL-=c;
                    totalPrice.setText(TOTAL+"");
                    AllCheckbox.setSelected(false); 
                    Alerts.showInfoAlert("تم المسح !!");
                    return;
                } else {
                    Alerts.showErrorAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
                }
            }
        }
    }
    private void deleteAllRows(){  
        if(SalesTabel.getItems().isEmpty()){
            Alerts.showErrorAlert("لا يوجد بيانات فى الجدول !!");
        }
        else{
            if(AllCheckbox.isSelected()){
                if(Alerts.ConfirmAlert("هل تريد مسح جميع عناصر الجدول ؟","")){
                    boolean result=DataHelper.deleteAllRowsInSalesTV(getSalesSerial());
                    if(result){
                        SalesTabel.getItems().clear();
                        Alerts.showInfoAlert("تم مسح جميع العناصر");
                    }
                    else
                        Alerts.showErrorAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
                }
            }
            else{
                Alerts.showErrorAlert("اضغط على مربع "+" \"الكل\" "+"لتتم عملية مسح جميع العناصر");
            }
            AllCheckbox.setSelected(false);
        }
    }
    private void clear(){
        productName.setText("");
        productPrice.setText("");
        Quntity.clear();
        totalPrice.clear();
        paid.clear();
        rest.clear();
        SalesTabel.getItems().clear();
    }
    /**********************_____________END OF IMPELMTNTAION______________************************/
    
    
    /********************************* LOAD PAGES ************************************************/
    @FXML
    private void loadMainOfSales(ActionEvent event) {
        loadWindow("/employees/main/employees.fxml");
    }
    
    void loadWindow(String loc){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource(loc));
            loadPane.getChildren().setAll(pane);
           
        }catch(IOException ex){}
    }
    /*********************************************************************************************/
    
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