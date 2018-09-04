/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Employee;

import Classes.Employee;
import Manager.Main.HomeController;
import database.DataHelper;
import database.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Manager_EmployeeController implements Initializable {
     HomeController x = new HomeController();
    @FXML
    private AnchorPane Manger_Employee;
    @FXML
    private VBox Vbox;
    @FXML
    private Label Employees;
    @FXML
    private Label E_name;
    @FXML
    private Label E_Code;
    @FXML
    private Label E_phone;
    @FXML
    private Label E_Address;
    @FXML
    private Label E_Salary;
    @FXML
    private TableView<Employee> E_tables;
    @FXML
    private TextField E_Tname;
    @FXML
    private TextField E_Tcode;
    @FXML
    private TextField E_Tphone;
    @FXML
    private TextArea E_Taddress;
    @FXML
    private TextField E_Tsalary;
    @FXML
    private TableColumn<Employee, String> t_address;
    @FXML
    private TableColumn<Employee, Double> t_salary;
    @FXML
    private TableColumn<Employee, String> t_phone;
    @FXML
    private TableColumn<Employee, String> t_code;
    @FXML
    private TableColumn<Employee, String> t_name;
    /**
     * Initializes the controller class.
     */
    
    DatabaseHandler databaseHandler; 
    @FXML
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     databaseHandler= DatabaseHandler.getInstance();
     t_name.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
     t_code.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
     t_phone.setCellValueFactory(new PropertyValueFactory<>("employeePhone"));
     t_salary.setCellValueFactory(new PropertyValueFactory<>("employeeSalaryHours"));
     t_address.setCellValueFactory(new PropertyValueFactory<>("employeeAddress"));
    }    

    @FXML
    private void Employee_Reports(ActionEvent event) {
        x.loadwindow(Manger_Employee,"/Manager/Employee/Reports/Employee_Reports.fxml");
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
        x.loadwindow(Manger_Employee,"/Manager/Main/Home.fxml");
    }
    @FXML
    private void Add_Employee(ActionEvent event) {
        this.AddEmployee();
    }

    @FXML
    private void Edit_Employee(ActionEvent event) {
    }

    @FXML
    private void Delete_Employee(ActionEvent event) {
    }

    @FXML
    private void Employee_Choice(ActionEvent event) {
    }
     private void AddEmployee(){
        Employee E =new Employee();
        E.setEmployeeName(E_Tname.getText());
        E.setEmployeeId(E_Tcode.getText());
        E.setEmployeePhone(E_Tphone.getText());
        E.setEmployeeSalaryHours(Integer.parseInt(E_Tsalary.getText()));
        E.setEmployeeAddress(E_Taddress.getText());
        
        
        boolean result = DataHelper.insertNewemployee(E);
        E_tables.getItems().add(E);
        if(result){
            Alert AT=new Alert(Alert.AlertType.INFORMATION);
            AT.setHeaderText(null);
            AT.setContentText("Successfully Added !!");
            AT.showAndWait();
            return;
    }
    }  

}
