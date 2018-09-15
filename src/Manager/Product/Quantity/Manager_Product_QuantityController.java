/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Product.Quantity;

import Classes.Alerts;
import Manager.Main.HomeController;
import com.jfoenix.controls.JFXTextField;
import database.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Manager_Product_QuantityController implements Initializable {
    HomeController x = new HomeController (); // used for load main page
    
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
    private RadioButton R_item;
    @FXML
    private RadioButton R_box;
    @FXML
    private Label LName;
    @FXML
    private ToggleGroup choiceQuan;
    @FXML
    private Label L_InP; // in this label I take the value of ItemInPackets of specific product From Database
    @FXML
    private Label L_PnB; // like L_InP but take PacketsInBox 
    
    
    DatabaseHandler databaseHandler;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        databaseHandler=DatabaseHandler.getInstance();
        
        P_UQuantity.setEditable(false);
        P_BQuantity.setEditable(false);
        P_CQuantity.setEditable(false);
        DataHelper.getBarcodesInEditQuanPage(P_TSearch);
        P_TSearch.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (P_TSearch.isFocused() && !P_TSearch.getText().isEmpty()) {
                        P_TSearch.selectAll();
                    }
                }
                });
            }
        });

            
    }    

    @FXML
    private void P_Search(ActionEvent event) {
         
        if (!P_TSearch.getText().equals(""))
            this.P_Search();
       else 
            Alerts.showErrorAlert("برجاء ادخال الباكورد ..");
       
    }
    @FXML
    private void AutoCompSearch(KeyEvent event) {
        P_Search();
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
        DataHelper.ProductQuantity(P_TSearch.getText(),P_UQuantity,P_BQuantity,P_CQuantity,LName);
    }
    
    
    private void Edit_Product(){
       if (!P_CQuantity.getText().equals("") && !P_BQuantity.getText().equals("") && !P_UQuantity.getText().equals(""))
       {
            try{
                if(R_item.isSelected() || R_packet.isSelected() || R_box.isSelected() ){
                  int it=Integer.parseInt(P_UQuantity.getText());
                  int pa=Integer.parseInt(P_BQuantity.getText());
                  int bo=Integer.parseInt(P_CQuantity.getText());
                  
                  DataHelper.getQuanDetails(P_TSearch.getText(), L_InP, L_PnB);
                  int inp=Integer.parseInt(L_InP.getText());
                  int pnb=Integer.parseInt(L_PnB.getText());
                  if(R_item.isSelected()){ 
                      DataHelper.QuickEditQuantity(it,P_TSearch.getText());  Alerts.showInfoAlert("تم التعديل");
                  }
                  else if(R_packet.isSelected()){
                      DataHelper.QuickEditQuantity(pa*inp,P_TSearch.getText()); Alerts.showInfoAlert("تم التعديل");
                  }
                  else if(R_box.isSelected()){
                      DataHelper.QuickEditQuantity(bo*pnb*inp,P_TSearch.getText()); Alerts.showInfoAlert("تم التعديل");
                  }
                  //P_Search();
              }
              else
                  Alerts.showErrorAlert("لم يتم تحديد خلية محددة");
            }catch(NumberFormatException e){Alerts.showErrorAlert("لقد ادخلت قيمة خاطئة");}
        }
       else {
       Alerts.showErrorAlert("برجاء التأكد من ملىء الحقول المطلوبة ..");
       }
    }

    @FXML
    private void AllowEditRadio(MouseEvent event) {
        selectRadio();
    }
    private void selectRadio(){
        if(R_item.isSelected()){
            P_UQuantity.setEditable(true);
            P_BQuantity.setEditable(false);
            P_CQuantity.setEditable(false);
        }
        else if(R_packet.isSelected()){
            P_UQuantity.setEditable(false);
            P_BQuantity.setEditable(true);
            P_CQuantity.setEditable(false);
        }
        else if(R_box.isSelected()){
            P_UQuantity.setEditable(false);
            P_BQuantity.setEditable(false);
            P_CQuantity.setEditable(true);
        }
    }


    @FXML
    private void EditByKey(KeyEvent event) {
        
        if(P_UQuantity.isFocused() && !R_item.isSelected()){
            try{
            if(event.getCode().equals(KeyCode.ENTER)) {
                 R_item.setSelected(true);
                 selectRadio();
            }
            }catch(Exception e){}
        }
        else if(P_BQuantity.isFocused() && !R_packet.isSelected()){
            try{
            if(event.getCode().equals(KeyCode.ENTER)) {
                 R_packet.setSelected(true);
                 selectRadio();
            }
            }catch(Exception e){}
        }
        else if(P_CQuantity.isFocused() && !R_box.isSelected()){
            try{
            if(event.getCode().equals(KeyCode.ENTER)) {
                 R_box.setSelected(true);
                 selectRadio();
            }
            }catch(Exception e){}
        }
        
        else{
        try{
        if(event.getCode().equals(KeyCode.ENTER)) {
             Edit_Product();
        }
        }catch(Exception e){}
        }
        
    }
}
/*try{
        if(event.getCode().equals(KeyCode.ENTER)) {
             this.Edit_Product();
        }
        
        
        /*
        else if(event.getCode().equals(KeyCode.ADD)){
            if(P_UQuantity.isFocused()){
                R_item.setSelected(true);
                
            }
            else if(P_BQuantity.isFocused()){
                R_packet.setSelected(true);
            }
            else if(P_CQuantity.isFocused()){
                R_box.setSelected(true);
                
            }
            selectRadio();
        }
        */ 