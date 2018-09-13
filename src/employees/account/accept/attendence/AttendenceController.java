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
import database.DataHelper;
import java.text.DateFormat;
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
    private TableView<Employee> table;
    @FXML
    private TableColumn<Employee, Time> start_work;
    @FXML
    private TableColumn<Employee, Time> end_work;
    @FXML
    private TableColumn<Employee, Double> hours_work;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        start_work.setCellValueFactory(new PropertyValueFactory<>("start"));
        end_work.setCellValueFactory(new PropertyValueFactory<>("end"));
        hours_work.setCellValueFactory(new PropertyValueFactory<>("difference"));
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
    private void getCurrentTimeUsingDate() {
        Employee e = new Employee();
        try{
        Time statrt = Time.valueOf(getTime());
        
        boolean result = DataHelper.insertAttendence(e);
     
        if(result){
           table.getItems().add(e);
           Alerts.showInfoAlert("تم الاضافة !!");
        }
        
        }
        catch(Exception x){
            
        }
}
    @FXML
    private void att_btn(ActionEvent event) {
        
        this.getCurrentTimeUsingDate();
    }
    
    @FXML
    private void leave_dtn(ActionEvent event) {
        
    }
    @FXML
    private void difference()
    {
        
    }
    
    
    
    
    
    
    
    
    
    
    /*private void left()
    {
        Date two = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String time2 = sdf.format(two);
        end.setText(time2);
    }*/
}
