
package Manager.Products;

import Classes.*;
import Classes.Quantity;
import database.*;
import Manager.Main.HomeController;
import database.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Manager_ProductsController implements Initializable {
     HomeController x = new HomeController();
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
    private ChoiceBox<String> P_Csupplier;
    @FXML
    private Label P_Bprice;
    @FXML
    private Label P_Cprice;
    @FXML
    private Label P_Minimm;
    @FXML
    private Label P_date;
    @FXML
    private TableView<Goods> P_table;
    @FXML
    private ChoiceBox<String> P_Ctype;
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
    private TextField P_Tdate;
    /**
     * Initializes the controller class.
     */
    DatabaseHandler databaseHandler;
    @FXML
    private TableColumn<Goods, String> t_ExpirationDate;
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
    private TableColumn<Goods, String> t_q_box;
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
    @FXML
    private TableColumn<?, ?> t_allQuan;
    @FXML
    private Label P_date1;
    @FXML
    private TextField P_CQuan;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databaseHandler=DatabaseHandler.getInstance();
        initTableViewCols();
        ObservableList<String> list1= FXCollections.observableArrayList("مكرونات","عصائر","جبن");
        ObservableList<String> list2= FXCollections.observableArrayList("باندا","عبور لاند","جهينة");
        P_Ctype.setItems(list1);
        P_Csupplier.setItems(list2);
        
    } 
    private void initTableViewCols(){
        t_name.setCellValueFactory(new PropertyValueFactory<>("productName"));
        t_code.setCellValueFactory(new PropertyValueFactory<>("productBarCode"));
        t_cate.setCellValueFactory(new PropertyValueFactory<>("productCategory"));
        t_supplier.setCellValueFactory(new PropertyValueFactory<>("productSupplier"));
        t_q_item.setCellValueFactory(new PropertyValueFactory<>("itemsInPacket"));
        t_q_packet.setCellValueFactory(new PropertyValueFactory<>("PacketsInBox"));
        t_q_box.setCellValueFactory(new PropertyValueFactory<>("Boxes"));
        t_p_item.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        t_p_packet.setCellValueFactory(new PropertyValueFactory<>("packetPrice"));
        t_p_box.setCellValueFactory(new PropertyValueFactory<>("boxPrice"));
        t_minimum_Q.setCellValueFactory(new PropertyValueFactory<>("productMinQuantity"));
        //t_ExpirationDate.setCellValueFactory(new PropertyValueFactory<>("productExpirationdate"));
        t_allQuan.setCellValueFactory(new PropertyValueFactory<>("allQuantity"));
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
    private void Add_Product(ActionEvent event) {
        Goods G=new Goods();
        G.setProductName(P_Tname.getText());
        G.setProductBarCode(P_Tcode.getText());
        G.setProductCategory((String) P_Ctype.getValue());
        G.setProductSupplier((String) P_Csupplier.getValue());
        G.setItemsInPacket(Integer.parseInt(Q_item.getText()));
        G.setPacketsInBox(Integer.parseInt(Q_packet.getText()));
        G.setBoxes(Integer.parseInt(Q_box.getText()));
        G.setItemPrice(Double.parseDouble(P_TUprice.getText()));
        G.setPacketPrice(Double.parseDouble(P_TBprice.getText()));
        G.setBoxPrice(Double.parseDouble(P_TCprice.getText()));
        G.setProductMinQuantity(Integer.parseInt(P_Tminimun.getText()));
        //G.setProductExpirationdate(P_Tdate.getText());
        G.setAllQuantity(Long.parseLong(P_CQuan.getText()));
        boolean result=DataHelper.insertNewProduct(G);
        if(result){
            P_table.getItems().add(G);
            Alerts.showInfoAlert("تم اضافة المنتج !!");
            clear();
        }
        else
            Alerts.showInfoAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
    }

    @FXML
    private void Edit_Product(ActionEvent event) {
    }

    @FXML
    private void Delete_Product(ActionEvent event) {
    }

    @FXML
    private void Product_Search(ActionEvent event) {
    }
    private void clear(){
        P_Tname.clear();
        P_TCprice.clear();
        P_TUprice.clear();
        P_TBprice.clear();
        P_Tcode.clear();
        Q_box.clear();
        Q_packet.clear();
        Q_item.clear();
        P_Tminimun.clear();
        P_CQuan.clear();
    }
}
