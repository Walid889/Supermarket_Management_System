/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.personalexpenses;

import Classes.Employee;
<<<<<<< HEAD
import Serial_dinamic.NewSerial;
=======
import static Serial_dinamic.NewSerial.gettDate;
>>>>>>> fe0f9164e9b958f28dff5a1994cb130809846ff8
import database.*;
import employees.main.EmployeesController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class PersonalexpensesController extends NewSerial implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private AnchorPane loadPane;
    @FXML
    private TableColumn<Employee, String> t_value;
    @FXML
    private TableColumn<Employee, String> t_reason;
    @FXML
    private TextField value;
    @FXML
    private TextArea reason;
    DatabaseHandler databaseHandler;
    @FXML
    private TableView<Employee> personal_table;
    /**
     * Initializes the controller class.
     */
    DatabaseHandler databaseHandler;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databaseHandler=DatabaseHandler.getInstance();
<<<<<<< HEAD
=======
        DataHelper.loadpersonalExpensesData(personal_table,gettDate());
        showTable();
    }
    private void showTable(){
>>>>>>> fe0f9164e9b958f28dff5a1994cb130809846ff8
        t_value.setCellValueFactory(new PropertyValueFactory<>("employeeExpensesCost"));
        t_reason.setCellValueFactory(new PropertyValueFactory<>("employeeExpensesReason"));
        DataHelper.loadpersonalExpensesData(personal_table, gettDate());
        
    }    

    @FXML
    private void loadMAinOfExpenses(ActionEvent event) {
        //loadWindow("/employees/main/employees.fxml");
        x.loadwindow(loadPane,"/employees/main/employees.fxml");
    }

    @FXML
    private void loadBack(ActionEvent event) {
        //loadWindow("/employees/account/accepted/acoountaccept.fxml");
        x.loadwindow(loadPane,"/employees/account/accepted/accountaccept.fxml");
    }
    
  /*  void loadWindow(String loc)
    {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(loc));
            loadPane.getChildren().setAll(pane);
           
        } catch (IOException ex) {
            Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    private void add(){
                Employee e = new Employee();
                e.setEmployeeExpensesCost(Double.parseDouble(value.getText()));
                e.setEmployeeExpensesReason(reason.getText());
                Date JDBC_Date = Date.valueOf(gettDate());
                e.setDate(JDBC_Date);
                boolean result = DataHelper.insertNewPersonalExpences(e);
                personal_table.getItems().add(e);
                if(result){
                    System.out.println("yeeeees");
                    Alert AT=new Alert(Alert.AlertType.INFORMATION);
                    AT.setHeaderText(null);
                    AT.setContentText("تم اضافة المصاريف الشخصية");
                    AT.showAndWait();
                    return;
                }
            }
    @FXML
    private void confirm(ActionEvent event) {
        this.add();
    }
    
}
