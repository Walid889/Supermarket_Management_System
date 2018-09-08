/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.buying;

import Classes.Alerts;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class BuyingController implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton loadMain;
    @FXML
    private Label date;
    @FXML
    private JFXButton search;
    @FXML
    private TextField billNumber;
    @FXML
    private Label productName;
    @FXML
    private Label productVolume;
    @FXML
    private Label productPrise;
    @FXML
    private TextField Quntity;
    @FXML
    private TextField tatalPrice;
    @FXML
    private TextField paid;
    @FXML
    private TextField rest;
    @FXML
    private JFXComboBox<?> quntityComboBox;
    @FXML
    private AnchorPane loadPane;
    @FXML
    private JFXComboBox<?> supplier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void addPaid(ActionEvent event) {
        this.addPaid();
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
        if(!tatalPrice.getText().equals("")&&!this.paid.getText().equals("") && !this.rest.getText().equals(""))
        {
            //yooour coooode
        }
        else
        {
            Alerts.showErrorAlert("لم يتم ادخال البيانات بشكل صحيح!  .. يرجى التأكد من ملئ جميع الحقول المطلوبة");
        }
    }
     
    
    private void addQuntity()
    {
        if(!Quntity.getText().equals(""))
        {
            
        }
        else
        {
            Alerts.showErrorAlert("يرجى ادخال الكمية");
        }
    }
    
    
    private void addPaid()
    {
        if(!paid.getText().equals(""))
        {
            
        }
        else
        {
            Alerts.showErrorAlert("يرجى ادخال القيمة المدفوعة");
        }
    }
    
}
