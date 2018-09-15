/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.main;

import com.jfoenix.controls.JFXButton;
import database.DatabaseHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class EmployeesController implements Initializable {

    
    @FXML
    private JFXButton buyButton;
    @FXML
    private JFXButton salesButton;
    @FXML
    private JFXButton accountButton;
    @FXML
    private JFXButton damageButton;
    @FXML
    private JFXButton expensesButton;
    @FXML
    private JFXButton recallButton;
    @FXML
    private JFXButton shortfallsButton;
    @FXML
    private AnchorPane loadPane;
    DatabaseHandler databaseHandler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       /* loadPane.heightProperty().addListener(new ChangeListener(){

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                double height = (double) newValue;
                loadPane.getChildren().set(index, loadPane);
            }
        });*/
       databaseHandler=DatabaseHandler.getInstance();
    }    

    @FXML
    private void loadSales(ActionEvent event) {
        loadwindow(loadPane,"/employees/sales/sales.fxml");
    }

    @FXML
    private void loadAccount(ActionEvent event) {
        loadwindow(loadPane,"/employees/account/account.fxml");
    }

    @FXML
    private void loadDamage(ActionEvent event) {
        loadwindow(loadPane,"/employees/damage/damage.fxml");
    }

    @FXML
    private void loadExpenses(ActionEvent event) {
        loadwindow(loadPane,"/employees/expenses/Expenses.fxml");
    }

    @FXML
    private void loadRecall(ActionEvent event) {
        loadwindow(loadPane, "/employees/recall/recall.fxml");
        
    }

    @FXML
    private void loadShortfalls(ActionEvent event) {
        loadwindow(loadPane,"/employees/rackshortages/rackshortages.fxml");
    }

    @FXML
    private void loadBuying(ActionEvent event) {
        loadwindow(loadPane,"/employees/buying/Buying.fxml");
    }
    
<<<<<<< HEAD
    @FXML
    private void signAsAdmin(ActionEvent event) {
        loadwindow(loadPane,"/Manager/Main/Home.fxml");
    }
=======
  

    
>>>>>>> e5317c64f9084381ea66bf14d8f0b3b80297a98c
    
    public void loadwindow(AnchorPane p , String loc) { 
        AnchorPane pane = null;
           try {
               pane = FXMLLoader.load(getClass().getResource(loc));
           } catch (IOException ex) {
               Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
           }
        p.getChildren().setAll(pane);
    }
    
   /* void loadWindow(String loc)
    {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(loc));
            loadPane.getChildren().setAll(pane);
           
        } catch (IOException ex) {
            Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       /* try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage= new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            Image icon = new Image("/icons/my_account.png");
            stage.getIcons().add(icon);
            stage.setScene(new Scene(parent));
            stage.show();
        } 
        catch (IOException ex) {
            Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }*/

<<<<<<< HEAD
=======
   

>>>>>>> e5317c64f9084381ea66bf14d8f0b3b80297a98c
    
    }

    

