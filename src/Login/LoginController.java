/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
<<<<<<< HEAD

import Classes.Alerts;

import Classes.Login;
=======
import Classes.Login;
import Classes.Alerts;
import Manager.Main.HomeController;
>>>>>>> c4bf01618b6337bae8361d5fe17a8918fe880359
import database.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
<<<<<<< HEAD
import org.apache.commons.codec.digest.DigestUtils;
=======
>>>>>>> c4bf01618b6337bae8361d5fe17a8918fe880359

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
<<<<<<< HEAD
        Login a = new Login();
 
            a.setcode(TEnterCode.getText());
            a.setPassword(TPassword.getText());
          
 
            if(a.getcode().equals("admin") && a.getPassword().equals("admin")){
                JOptionPane.showMessageDialog(null, "Login with Admin");
                
                }
 
            else{
                JOptionPane.showMessageDialog(null, "Failed Login");
                
                }
        //JOptionPane.showMessageDialog(null , "Login With Admin");
        //Alerts.ConfirmAlert("login with admin", "");    
=======
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
    
>>>>>>> c4bf01618b6337bae8361d5fe17a8918fe880359
    }
    
}
    private void clear (){
        TEnterCode.setText("");
        TPassword.setText("");
    }
}
