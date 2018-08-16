/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Employee;

import Manager.Main.HomeController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private TableView<?> E_tables;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }    

    @FXML
    private void Employee_Reports(ActionEvent event) {
        x.loadwindow("/Manager/Employee/Reports/Employee_Reports.fxml", "Employee_Reports");
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
        x.loadwindow("/Manager/Main/Home.fxml", "Home");
    }

    @FXML
    private void Add_Employee(ActionEvent event) {
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
       
}
