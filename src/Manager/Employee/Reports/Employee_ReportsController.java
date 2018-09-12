/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Employee.Reports;

import Classes.Alerts;
import Manager.Main.HomeController;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import database.DatabaseHandler;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Employee_ReportsController implements Initializable {
  
    HomeController x = new HomeController();
    
    @FXML
    private AnchorPane E_Reports;
    @FXML
    private Label E_lable_name;
    @FXML
    private Label E_label_date1;
    @FXML
    private Label E_label_date2;
    @FXML
    private JFXDatePicker E_field_date1;
    @FXML
    private JFXDatePicker E_field_date2;
     @FXML
    private JFXComboBox<String> E_cname;

    /**
     * Initializes the controller class.
     */
    DatabaseHandler databaseHandler;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       databaseHandler = DatabaseHandler.getInstance();
        ObservableList<String> list= FXCollections.observableArrayList("وائل","محمود","احمد");
        E_cname.setItems(list);
        
    }    

    @FXML
    private void Salary_Report(ActionEvent event) {
       try {
         if (!E_field_date1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") &&!E_field_date2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") && !E_cname.getValue().equals("")){
            System.out.println("غلطططططط "); // yoooooooooour code
         }
         }
        catch(NullPointerException e){
                 Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
                 }
    }

    @FXML
    private void Purchases_Report(ActionEvent event) {
        try {
         if (!E_field_date1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") &&!E_field_date2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") && !E_cname.getValue().equals("")){
            System.out.println("غلطططططط "); // yoooooooooour code
         }
         }
        catch(NullPointerException e){
                 Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
                 }
        
         
        
    }

    @FXML
    private void Attendance_Report(ActionEvent event) {
        try {
         if (!E_field_date1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") &&!E_field_date2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") && !E_cname.getValue().equals("")){
            System.out.println("غلطططططط "); // yoooooooooour code
         }
         }
        catch(NullPointerException e){
                 Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
                 }
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
        x.loadwindow(E_Reports, "/Manager/Main/Home.fxml");
    }

    @FXML
    private void Back(ActionEvent event) {
        x.loadwindow(E_Reports, "/Manager/Reports/Reports.fxml");
    }
    
}
