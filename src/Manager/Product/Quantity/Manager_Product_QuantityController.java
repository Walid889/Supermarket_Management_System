/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Product.Quantity;

import Classes.Alerts;
import Manager.Main.HomeController;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Manager_Product_QuantityController implements Initializable {
    HomeController x = new HomeController ();
    
    @FXML
    private AnchorPane Product_Quantity;
    @FXML
    private Label P_Quantity;
    @FXML
    private JFXTextField P_TSearch;
    @FXML
    private JFXTextField P_CQuantity;
    @FXML
    private JFXTextField P_BQuantity;
    @FXML
    private JFXTextField P_UQuantity;
    @FXML
    private RadioButton R_packet;
    @FXML
    private ToggleGroup T_R_quan;
    @FXML
    private RadioButton R_item;
    @FXML
    private ToggleGroup T_R_quan1;
    @FXML
    private RadioButton R_box;
    @FXML
    private ToggleGroup T_R_quan2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void P_Search(ActionEvent event) {
         this.P_Search();
    }

    @FXML
    private void Edit_Product(ActionEvent event) {
        this.Edit_Product();
    }

    @FXML
    private void Back(ActionEvent event) {
        x.loadwindow(Product_Quantity, "/Manager/Products/Manager_Products.fxml");
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
        x.loadwindow(Product_Quantity, "/Manager/Main/Home.fxml");
    }
    
    
    
    
    //////////////////////////
    
    
    private void P_Search ()
    {
       if (!P_TSearch.getText().equals(""))
       {
          System.out.println("اكتب الكوووووووووود"); // yoooooooooour code
       }
       else {
       Alerts.showErrorAlert("برجاء ادخال الباكورد ..");
       }
    }
    
    private void Edit_Product(){
       if (!P_CQuantity.getText().equals("") && !P_BQuantity.getText().equals("") && !P_UQuantity.getText().equals(""))
       {
          System.out.println("اكتب الكوووووووووود"); // yoooooooooour code
       }
       else {
       Alerts.showErrorAlert("برجاء التأكد من ملىء الحقول المطلوبة ..");
       }
    }

    @FXML
    private void AllowEditRadio(MouseEvent event) {
    }
}
