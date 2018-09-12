/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Supplier.Reports;

import Classes.Alerts;
import Manager.Main.HomeController;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Walid
 */
public class Sppliers_ReportsController implements Initializable {
 
    HomeController x = new HomeController();
    
    @FXML
    private AnchorPane Suppliers_Reports;
    @FXML
    private Label S_name;
    @FXML
    private ComboBox<String> S_Cname;
    @FXML
    private Label S_Date1;
    @FXML
    private Label S_Date2;
    @FXML
    private JFXDatePicker S_TData1;
    @FXML
    private JFXDatePicker S_TDate2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> list= FXCollections.observableArrayList("وائل","محمود","احمد");
        S_Cname.setItems(list);
        
        // TODO
    }    


    @FXML
    private void Supplier_Returns(ActionEvent event) {
         try {
         if (!S_TData1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") &&!S_TDate2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") && !S_Cname.getValue().equals("") ){
            System.out.println("غلطططططط "); // yoooooooooour code
         }
         }
        catch(NullPointerException e){
                 Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
                 }
    }

    @FXML
    private void Supplier_Financial(ActionEvent event) {
        try {
         if (!S_TData1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") &&!S_TDate2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") && !S_Cname.getValue().equals("") ){
            System.out.println("غلطططططط "); // yoooooooooour code
         }
         }
        catch(NullPointerException e){
                 Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
                 }
    }

    @FXML
    private void Suppliers_Invoices(ActionEvent event) {
        try {
         if (!S_TData1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") &&!S_TDate2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") && !S_Cname.getValue().equals("") ){
            System.out.println("غلطططططط "); // yoooooooooour code
         }
         }
        catch(NullPointerException e){
                 Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
                 }
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
        x.loadwindow(Suppliers_Reports,"/Manager/Main/Home.fxml");
    }

    @FXML
    private void Back(ActionEvent event) {
        x.loadwindow(Suppliers_Reports, "/Manager/Reports/Reports.fxml");

    }
    
}
