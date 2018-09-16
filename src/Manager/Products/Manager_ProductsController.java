
package Manager.Products;

import Classes.*;

import database.*;
import Manager.Main.HomeController;

import database.DatabaseHandler;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Manager_ProductsController implements Initializable {
    HomeController x = new HomeController(); // used for load windows
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
    private ComboBox<String> P_Csupplier;
    @FXML
    private Label P_Bprice;
    @FXML
    private Label P_Cprice;
    @FXML
    private Label P_Minimm;
    @FXML
    private TableView<Goods> P_table;
    @FXML
    private ComboBox<String> P_Ctype;
    @FXML
    private TextField P_TSearch;
    @FXML
    private TextField P_Tname;
    @FXML
    private TextField P_Tcode;
    @FXML
    private TextField P_TUprice;
    @FXML
    private TextField P_TBprice;
    @FXML
    private TextField P_TCprice;
    @FXML
    private TextField P_Tminimun;
    @FXML
    private TableColumn<Goods, String> t_minimum_Q;
    @FXML
    private TableColumn<Goods, String> t_p_box;
    @FXML
    private TableColumn<Goods, String> t_p_packet;
    @FXML
    private TableColumn<Goods, String> t_p_item;
    @FXML
    private TableColumn<Goods, String> t_supplier;
    @FXML
    private TableColumn<Goods, String> t_q_packet;
    @FXML
    private TableColumn<Goods, String> t_q_item;
    @FXML
    private TableColumn<Goods, String> t_cate;
    @FXML
    private TableColumn<Goods, String> t_code;
    @FXML
    private TableColumn<Goods, String> t_name;
    @FXML
    private TextField Q_item;
    @FXML
    private TextField Q_packet;
    @FXML
    private TextField Q_box;    
    
    private static String oldBar=""; // this var used foe edit .. when you focus on any row it take the barcode of the product from table
    DatabaseHandler databaseHandler;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databaseHandler=DatabaseHandler.getInstance();
        initTableViewCols();
        ObservableList<String> list1= FXCollections.observableArrayList("أخرى","منظفات","معلبات","مجمدات","عصائر","شيكولاتات","شيبسي وحلويات","شاي وبن","سمنة وزيوت","جبن","ايس كريم","ألبان");
        ObservableList<String> list2= FXCollections.observableArrayList("باندا","عبور لاند","جهينة");
        P_Ctype.setItems(list1);
        P_Csupplier.setItems(list2);
        Q_box.setText("1");
        DataHelper.loadProductsData(P_table,P_TSearch);
    } 
    private void initTableViewCols(){
        t_name.setCellValueFactory(new PropertyValueFactory<>("productName"));
        t_code.setCellValueFactory(new PropertyValueFactory<>("productBarCode"));
        t_cate.setCellValueFactory(new PropertyValueFactory<>("productCategory"));
        t_supplier.setCellValueFactory(new PropertyValueFactory<>("productSupplier"));
        t_q_item.setCellValueFactory(new PropertyValueFactory<>("itemsInPacket"));
        t_q_packet.setCellValueFactory(new PropertyValueFactory<>("PacketsInBox"));
        t_p_item.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        t_p_packet.setCellValueFactory(new PropertyValueFactory<>("packetPrice"));
        t_p_box.setCellValueFactory(new PropertyValueFactory<>("boxPrice"));
        t_minimum_Q.setCellValueFactory(new PropertyValueFactory<>("productMinQuantity"));
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
    private void Product_Quantity(ActionEvent event) {
        x.loadwindow(Manager_Products, "/Manager/Product/Quantity/Manager_Product_Quantity.fxml");
    }

    @FXML
    private void Add_Product(ActionEvent event) {
        this.Add_Product();
    }
    @FXML
    private void AddProduct(KeyEvent event) {
        try{
            if(event.getCode().equals(KeyCode.ENTER)){
                this.Add_Product();
            }
        }catch(Exception e){}
    }
    
    @FXML
    private void Edit_Product(ActionEvent event) {
        this.Edit_Product();
    }
    @FXML
    private void Delete_Product(ActionEvent event) {
         this.Delete_Product();
    }
    
    
    
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    private void Add_Product() {
        if(!P_Tname.getText().equals("") && !P_Tcode.getText().equals("") && !P_Ctype.getValue().equals("")
                && !P_Csupplier.getValue().equals("") && !Q_item.getText().equals("") && !Q_packet.getText().equals("")
                && !P_TUprice.getText().equals("") && !P_TBprice.getText().equals("") && !P_TCprice.getText().equals("")
                && !P_Tminimun.getText().equals("")){
            try {
                Goods G=new Goods();
                G.setProductName(P_Tname.getText());
                G.setProductBarCode(P_Tcode.getText());
                G.setProductCategory((String) P_Ctype.getValue());
                G.setProductSupplier((String) P_Csupplier.getValue());
                G.setItemsInPacket(Integer.parseInt(Q_item.getText()));
                G.setPacketsInBox(Integer.parseInt(Q_packet.getText()));
                G.setItemPrice(Double.parseDouble(P_TUprice.getText()));
                G.setPacketPrice(Double.parseDouble(P_TBprice.getText()));
                G.setBoxPrice(Double.parseDouble(P_TCprice.getText()));
                G.setProductMinQuantity(Integer.parseInt(P_Tminimun.getText()));
                G.setAllQuantity(0); // Set Quantity to ZERO in first time product entered to System
                boolean result=DataHelper.insertNewProduct(G);
                if(result){
                    P_table.getItems().add(G);
                    Alerts.showInfoAlert("تم اضافة المنتج !!");
                    clear();
                }
                else
                    Alerts.showInfoAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
                
            }catch(NumberFormatException e) {Alerts.showErrorAlert("لقد ادخلت قيمة غير صحيحة ");}
        }
        else 
             Alerts.showErrorAlert("برجاء ملىء جميع الحقول المطلوبة");
    }

    

    private void Edit_Product() {
        
        if(!P_Tname.getText().equals("") && !P_Tcode.getText().equals("") && !P_Ctype.getValue().equals("")
                && !P_Csupplier.getValue().equals("") && !Q_item.getText().equals("") && !Q_packet.getText().equals("")
                && !P_TUprice.getText().equals("") && !P_TBprice.getText().equals("") && !P_TCprice.getText().equals("")
                && !P_Tminimun.getText().equals("")){
            try {
                String name=P_Tname.getText();
                String bar=P_Tcode.getText();
                String cate=(String) P_Ctype.getValue();
                String sup=(String) P_Csupplier.getValue();
                int it=Integer.parseInt(Q_item.getText());
                int pa=Integer.parseInt(Q_packet.getText());
                double Pi=Double.parseDouble(P_TUprice.getText());
                double Pp=Double.parseDouble(P_TBprice.getText());
                double Pb=Double.parseDouble(P_TCprice.getText());
                int mP=Integer.parseInt(P_Tminimun.getText());

                Goods G=new Goods(name, bar, cate, sup, it, pa, Pi, Pp, Pb, mP);

                boolean result=DataHelper.updateProductInfo(G,oldBar);
                if(result){
                    Alerts.showInfoAlert("تم تعديل بيانات :"+G.getProductName());
                    clear();
                    DataHelper.loadProductsData(P_table,P_TSearch);
                }
            }catch (NumberFormatException e) {Alerts.showErrorAlert("لقد ادخللت قيمة غير صحيحة");}
        }
        else
            Alerts.showErrorAlert("برجاء ملىء جميع الحقول المطلوبة"); 
    }
  
    
    private void Delete_Product() {
        if(!P_Tname.getText().equals("") && !P_Tcode.getText().equals("") && !P_Ctype.getValue().equals("")
                && !P_Csupplier.getValue().equals("") && !Q_item.getText().equals("") && !Q_packet.getText().equals("")
                && !P_TUprice.getText().equals("") && !P_TBprice.getText().equals("") && !P_TCprice.getText().equals("")
                && !P_Tminimun.getText().equals("")){
            try{
                Goods G=P_table.getSelectionModel().getSelectedItem();

                if (Alerts.ConfirmAlert("هل تريد مسح"+":", G.getProductName())) {
                   Boolean result = DataHelper.deleteProduct(G);
                   if (result) {
                       Alerts.showInfoAlert("تم المسح !!");
                       clear();
                       DataHelper.loadProductsData(P_table,P_TSearch);
                   }
                    else 
                       Alerts.showErrorAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
                }
                System.out.println(oldBar);
            }catch(Exception e) {Alerts.showErrorAlert("لم يتم تحديد منتج من الجدول");}
        }
        else
            Alerts.showErrorAlert("برجاء ملىء جميع الحقول المطلوبة");
    }
    
    @FXML
    private void Product_Search(ActionEvent event) { // Search Button 
    }
    
    private void clear(){
        P_Tname.clear();
        P_TCprice.clear();
        P_TUprice.clear();
        P_TBprice.clear();
        P_Tcode.clear();
        Q_packet.clear();
        Q_item.clear();
        P_Tminimun.clear();
        P_Ctype.setValue("");
        P_Csupplier.setValue("");
    }

    @FXML
    private void selectFromTable(MouseEvent event) {
        try{
        Goods good=P_table.getSelectionModel().getSelectedItem();
        P_Tname.setText(good.getProductName());
        P_Tcode.setText(good.getProductBarCode());
        Q_item.setText(good.getItemsInPacket()+"");
        Q_packet.setText(good.getPacketsInBox()+"");
        P_TUprice.setText(good.getItemPrice()+"");
        P_TBprice.setText(good.getPacketPrice()+"");
        P_TCprice.setText(good.getBoxPrice()+"");
        P_Csupplier.setValue(good.getProductSupplier());
        P_Ctype.setValue(good.getProductCategory());
        P_Tminimun.setText(good.getProductMinQuantity()+"");
        oldBar=P_Tcode.getText();
        }catch(Exception e){
            
        }
        
    }
    
    ObservableList<Goods> list= FXCollections.observableArrayList();    
    FilteredList filter=new FilteredList(list,e->true);
    @FXML
    private void autoSearch(KeyEvent event) {
        DataHelper.autos(list);
        P_TSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(    (Predicate<? super Goods>)    (Goods go)->{
                if(newValue.isEmpty() || newValue == null)
                    return true;
                if(newValue.contains(go.getProductBarCode()))
                    return true;
                
                return false;
            });
        });
        
        SortedList st=new SortedList(filter);
        st.comparatorProperty().bind(P_table.comparatorProperty());
        P_table.setItems(st);
    }

    @FXML
    private void ClearNew(ActionEvent event){
        clear();
    } 

    @FXML
    private void Key_Pressed(KeyEvent event) {
          try{
        if(event.getCode().equals(KeyCode.S)){
          this.Add_Product(); }
        else if (event.getCode().equals(KeyCode.DELETE)){
          this.Delete_Product();
        }
    }catch(Exception e){}
    }

   
}
