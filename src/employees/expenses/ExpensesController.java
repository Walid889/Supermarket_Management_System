/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.expenses;


import com.jfoenix.controls.JFXButton;
import employees.main.EmployeesController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import Classes.*;
import database.*;
import Serial_dinamic.NewSerial;
import database.DataHelper;
import java.sql.Date;
import java.sql.ResultSet;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.S;
import javafx.scene.input.KeyEvent;
/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class ExpensesController extends NewSerial implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private AnchorPane loadPane;
    @FXML
    private TextField value;
    @FXML
    private JFXButton add;
    @FXML
    private JFXButton home;
    @FXML
    private TextField total_price;

    DatabaseHandler databaseHandler;
    @FXML
    private TableView<Expences> E_table;
    @FXML
    private TableColumn<Expences, String> t_cost;
    @FXML
    private TableColumn<Expences, String> t_reason;
    @FXML
    private TextArea reasonBox;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databaseHandler=DatabaseHandler.getInstance();
        DataHelper.loadExpensesData(E_table, gettDate());
        
        
        initTableViewCols();
        total();
    }    
    private  void initTableViewCols(){
        t_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        t_reason.setCellValueFactory(new PropertyValueFactory<>("reason"));
    }
    @FXML
    private void loadMAinOfExpenses(ActionEvent event) {
    //loadWindow ("/employees/main/employees.fxml");
        x.loadwindow(loadPane,"/employees/main/employees.fxml");
    }
    
    
    private double total=0;
    
    private void AddValue(){
        Expences E =new Expences();
        try{
        Date JDBC_Date = Date.valueOf(gettDate());
        E.setDate(JDBC_Date);
        E.setCost(Double.parseDouble(value.getText()));
        E.setReason((this.reasonBox.getText()));
        
        boolean result = DataHelper.insertNewExpences(E);
     
        if(result){
           E_table.getItems().add(E);
           Alerts.showInfoAlert("تم الاضافة !!");
        }
        total();
        clear();
        }catch(NumberFormatException e){
            Alerts.showErrorAlert("لقد ادخلت قيمة غير صحيحة ..");
        }
    }
    private void total(){
        E_table.getItems().forEach((t) -> {
            total+=t.getCost();
        });
        total_price.setText(total+"");
        total=0;
    }
    @FXML
    private void AddValue(ActionEvent event) {
        this.AddValue();
        
    }
    
    private void clear(){
        value.clear();
        reasonBox.clear();
    }
    
}

/*
String qu = "SELECT * FROM expenses";
        ResultSet rs =DatabaseHandler.getInstance().execQuery(qu);
        try {
            while (rs.next()) {
                String s1=rs.getString("e_reason");
                double s2=rs.getDouble("e_cost");
                System.out.println(s1+"    "+s2);
            }
        }
            catch(Exception e){}
*/
