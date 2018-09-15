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
import org.apache.derby.client.am.DateTime;

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
    private JFXTextField start_work;
    @FXML
    private JFXTextField finish_work;
    private JFXTextField difference;
    @FXML
    private JFXTextField differenceText;
    @FXML
    private JFXButton difference_btn;

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
    private void attt()
    {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
            Date cal = new Date();
        start_work.setText(dateFormat.format(cal.getTime()));
    }
<<<<<<< HEAD
    
    public void left()
=======
    private void left()
>>>>>>> e5317c64f9084381ea66bf14d8f0b3b80297a98c
    {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
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
<<<<<<< HEAD
    private void difference()      
    {
        String s=start_work.getText();
        String f=finish_work.getText();
        
        int d1=Integer.parseInt(s.charAt(0)+""+s.charAt(1));
        int d2=Integer.parseInt(f.charAt(0)+""+f.charAt(1));

        difference.setText((d2-d1) +"");
      //  difference.setText(String.valueOf(diff));
=======
    private void differenceAction(ActionEvent event) {
        double salary;
        String start = start_work.getText();
        String finish = finish_work.getText();
         long differenceCalc=0;

        try{SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss aa");
            Date date1 = format.parse(start);
            Date date2 = format.parse(finish);
            differenceCalc = date2.getTime() - date1.getTime(); 
        }catch(Exception e){
            System.out.println("test");
        }
        long timeDifference = differenceCalc/1000;
        int h = (int) (timeDifference / (3600));
        int m = (int) ((timeDifference - (h * 3600)) / 60);
        int s = (int) (timeDifference - (h * 3600) - m * 60);
        
         String finalTime = String.format("%02d:%02d:%02d", h,m,s);
        
        salary = h*m * 20;
        
        System.out.println(salary);
        differenceText.setText(finalTime);
        //this.diff();
>>>>>>> e5317c64f9084381ea66bf14d8f0b3b80297a98c
    }
}
