/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.rackshortages;

import Classes.Defects;
import database.*;
import employees.main.EmployeesController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class RackshortagesController implements Initializable {
    EmployeesController x =  new EmployeesController();

    @FXML
    private AnchorPane loadPane;
    @FXML
    private TableView<Defects> rackshortagesTable;
    @FXML
    private TableColumn<Defects, String> t_quan;
    @FXML
    private TableColumn<Defects, String> t_cate;
    @FXML
    private TableColumn<Defects, String> t_bar;

    /**
     * Initializes the controller class.
     */
        
    DatabaseHandler databaseHandler;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databaseHandler=DatabaseHandler.getInstance();
        initTableViewCols();
        DataHelper.loadDEFECTSData(rackshortagesTable);
    }    
    private  void initTableViewCols(){
        t_bar.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        t_cate.setCellValueFactory(new PropertyValueFactory<>("productName"));
        t_quan.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }
    @FXML
    private void loadRackMain(ActionEvent event) {
    //loadWindow("/employees/main/employees.fxml");
        x.loadwindow(loadPane,"/employees/main/employees.fxml");
    }
}
