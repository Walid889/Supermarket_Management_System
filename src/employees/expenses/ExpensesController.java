/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.expenses;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import Classes.*;
import database.DataHelper;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.S;
import javafx.scene.input.KeyEvent;
/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class ExpensesController implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private AnchorPane loadPane;
    @FXML
    private TableView<Expences> table;
    @FXML
    private TextField value;
    @FXML
    private TextArea reason;
    @FXML
    private JFXButton add;
    @FXML
    private JFXButton home;
    @FXML
    private TextField total_price;
    @FXML
    private TableColumn<Expences, Double> t_value;
    @FXML
    private TableColumn<Expences, Double> t_total;
    @FXML
    private TableColumn<Expences, String> t_reason;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        t_value.setCellValueFactory(new PropertyValueFactory<>("cost"));
        t_total.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        t_reason.setCellValueFactory(new PropertyValueFactory<>("Reason"));
    }    

    @FXML
    private void loadMAinOfExpenses(ActionEvent event) {
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
    private void AddValue(){
         Expences E =new Expences();
        E.setCost(Double.parseDouble(value.getText()));
        E.setReason((this.reason.getText()));
        E.setTotalCost(Double.parseDouble(total_price.getText()));
        
        boolean result = DataHelper.insertNewExpences(E);
        table.getItems().add(E);
        if(result){
            Alert AT=new Alert(Alert.AlertType.INFORMATION);
            AT.setHeaderText(null);
            AT.setContentText("Successfully Added !!");
            AT.showAndWait();
            return;
    }
    }

    

    

    @FXML
    private void AddValue(ActionEvent event) {
        this.AddValue();
    }
    
}
