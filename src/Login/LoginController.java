/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;


import Classes.Alerts;
import Classes.Login;








import Classes.Alerts;
import Classes.Login;

import Classes.Login;
import Classes.Alerts;
import Manager.Main.HomeController;
import database.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class LoginController implements Initializable {
    
HomeController y = new HomeController(); 
    @FXML
    private AnchorPane login;
    @FXML
    private Label EnterCode;
    @FXML
    private Label Password;
    @FXML
    private TextField TEnterCode;
    @FXML
    private TextField TPassword;

    DatabaseHandler databaseHandler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        databaseHandler = DatabaseHandler.getInstance();
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        Login a = new Login();
 
            
        //JOptionPane.showMessageDialog(null , "Login With Admin");
        //Alerts.ConfirmAlert("login with admin", "");    

        this.login();
        
    }
    private void login() {
        //JOptionPane.showMessageDialog(null , "HI");
        //Alerts.ConfirmAlert("login with admin", "");    
       System.out.println("HI");
        Login log=new Login();
        log.setuserName(TEnterCode.getText().trim().toLowerCase()); // store userName to check   trim() to ignore space toLowerCase() to transfer Cpital to small  
        log.setuserPassword(TPassword.getText().trim());      // store userName to check   trim() to ignore space
        int x=log.checkPassword();      // call function check password 
        switch (x){
            
            case 1: 
                y.loadwindow(login ,"/Manager/Main/Home.fxml");
                
                 break;
                 
            case 2: 
                y.loadwindow(login ,"/employees/main/employees.fxml");
               ;       
                break;
            case 3: 
                   Alerts.showErrorAlert("خطا ف كود الدخول او كلمة السر");
                   clear();
                   break;
            default : Alerts.showErrorAlert("خطا ف كود الدخول او كلمة السر");
                      
                    clear();
                    break;
    }
    
}
    private void clear (){
        TEnterCode.setText("");
        TPassword.setText("");
    }

    @FXML
    private void Key_Enter(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)){
          this.login(); }
    }

  
    
}
