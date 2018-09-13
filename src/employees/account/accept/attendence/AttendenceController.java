/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.account.accept.attendence;

import Classes.Alerts;
import Classes.Employee;
import com.jfoenix.controls.JFXButton;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import employees.main.EmployeesController;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import Serial_dinamic.NewSerial;
import static Serial_dinamic.NewSerial.getTime;
import com.jfoenix.controls.JFXTextField;
import database.DataHelper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TextField start;
    private TextField end;
    @FXML
    private JFXTextField start_work;
    @FXML
    private JFXTextField finish_work;
    @FXML
    private JFXTextField difference;

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
    public void attt()
    {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date cal = new Date();
        start_work.setText(dateFormat.format(cal.getTime()));
    }
    public void left()
    {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date finish = new Date();
        finish_work.setText(dateFormat.format(finish.getTime()));
    
    }
    
    @FXML
    private void att_btn(ActionEvent event) {
        this.attt();
    }
    
    @FXML
    private void leave_dtn(ActionEvent event) {
        this.left();
    }
    @FXML
    private void difference()
    {
        
      
      //  difference.setText(String.valueOf(diff));
    }
    
    
    
    
    
    
    
    
    
    
    /*private void left()
    {
        Date two = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String time2 = sdf.format(two);
        end.setText(time2);
    }*/
}
