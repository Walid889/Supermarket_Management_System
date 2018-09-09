/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.damage;

import Classes.Alerts;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class DamageController implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private AnchorPane loadPane;
    @FXML
    private Label date;
    @FXML
    private TextField Quntity;
    @FXML
    private TextField paid;
    @FXML
    private JFXComboBox<?> quntityComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadMainOfDamage(ActionEvent event) {
       // loadWindow ("/employees/main/employees.fxml");
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
    private void addQuntity(ActionEvent event) {
        this.addQuntity();
    } 

    @FXML
    private void addPaid(ActionEvent event) {
        this.addPaid();
    }

    @FXML
    private void saveDamage(ActionEvent event) {
        this.saveDamage();
    }

    @FXML
    private void cancelDamage(ActionEvent event) {
        this.cancelDamage();
    }
    
    
    /***************************************************************************************************************/
    /***************************************************************************************************************/
    /******************************************IMPLEMENTATION METHODS***********************************************/
    /***************************************************************************************************************/
    /***************************************************************************************************************/

    
    private void saveDamage()
    {
        if(!Quntity.getText().equals("")&& !paid.getText().equals(""))
        {
            //yoooour coooode
        }
        else
        {
            Alerts.showErrorAlert("لم يتم ادخال البيانات بشكل صحيح ! .. يرجى التأكد من ملئ جميع الحقول المطلوبه");
        }
    }
    
    private void cancelDamage()
    {
        if(Alerts.ConfirmAlert("هل تريد مسح كل العناصر",""))
        {
            //yoooooour cooooode
        }
    }
    
    private void addQuntity()
    {
        if(!Quntity.getText().equals(""))
        {
            //yoooour coooode
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
           //yooooooour coooooode 
        }
        else
        {
            Alerts.showErrorAlert("يرجى ادخال القيمة المدفوعة");
        }
        
    }
}
