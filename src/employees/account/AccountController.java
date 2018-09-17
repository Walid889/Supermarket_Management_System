/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.account;

import Classes.Alerts;
import database.DataHelper;
import employees.main.EmployeesController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class AccountController implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private AnchorPane loadPane;
    @FXML
    private TextField code_employee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadMainOfAccount(ActionEvent event) {
        //loadWindow("/employees/main/employees.fxml");
        x.loadwindow(loadPane,"/employees/main/employees.fxml");
    }

    private void loadAccount(ActionEvent event) {
       // loadWindow("/employees/account/accepted/accountaccept.fxml");
        x.loadwindow(loadPane,"/employees/account/accepted/accountaccept.fxml");
    }
    
    /*void loadWindow(String loc)
    {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(loc));
            loadPane.getChildren().setAll(pane);
           
        } catch (IOException ex) {
            Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    private void login_employee()
    { 
        String id =  code_employee.getText();
        if (DataHelper.isEmployeeisEXits(id))
        {
            Alerts.showInfoAlert("كود صحيح");
            x.loadwindow(loadPane,"/employees/account/accepted/accountaccept.fxml");
        }
        else{
            Alerts.showErrorAlert("كود خطأ");
        }
    }
    @FXML
    private void confirm(ActionEvent event){
        
            this.login_employee();
        
    }
}
