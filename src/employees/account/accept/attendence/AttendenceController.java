/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.account.accept.attendence;

import Classes.Employee;
import com.jfoenix.controls.JFXButton;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import employees.main.EmployeesController;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class AttendenceController implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private AnchorPane loadPane;
    @FXML
    private JFXButton attendence;
    @FXML
    private JFXButton leaves;
    @FXML
    private TextField start;
    @FXML
    private TextField end;
    @FXML
    private TextField difference;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadBack(ActionEvent event) {
        //loadWindow("/employees/account/accepted/accountaccept.fxml");
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
    Date one = new Date();
    Date two = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String time1 = sdf.format(one);
    String time2 = sdf.format(two);
    
    
    
    @FXML
    private void att_btn(ActionEvent event) {
        start.setText(time1);
    }

    @FXML
    private void leave_dtn(ActionEvent event) {
        end.setText(time2);
    }
    private void difference()
    {
        Employee e = new Employee();
        difference.setText(e.getTimeDiff(one, two));
    }
}
