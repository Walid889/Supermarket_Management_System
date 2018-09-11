/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Time;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 *
 * @author Walid
 */
public class Sales extends Common_Properties{// Common_Methods is an Interface include Add , Update , Delete
    private long number;
    private Time time;
    private String barcodfiled;

    public String getBarcodfiled() {
        return barcodfiled;
    }

    public void setBarcodfiled(String barcodfiled) {
        this.barcodfiled = barcodfiled;
    }
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
    
    private String name;
    private double UintPrice;
    private int CurrentQuantity;
    private double cost;
    private double TotalPrice;
    private double paid;
    private double reminderMoney;

    public double getReminderMoney() {
        return reminderMoney;
    }

    public void setReminderMoney(double reminderMoney) {
        this.reminderMoney = reminderMoney;
    }
   
    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }
    public int getCurrentQuantity() {
        return CurrentQuantity;
    }

    public void setCurrentQuantity(int CurrentQuantity) {
        this.CurrentQuantity = CurrentQuantity;
    }
    private String quantityKind;

    public String getQuantityKind() {
        return quantityKind;
    }

    public void setQuantityKind(String quantityKind) {
        this.quantityKind = quantityKind;
    }
    
    
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUintPrice() {
        return UintPrice;
    }

    public void setUintPrice(double UintPrice) {
        this.UintPrice = UintPrice;
    }

    

    

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    
    public int getSerial() {
        return Serial;
    }

    public void setSerial(int Serial) {
        this.Serial = Serial;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date Date) {
        this.Date = Date;
    }

    
   public double CalcCostOfSoldItem(double price,double quantity){
       return price*quantity;
   }
   
   public double CalcReminderMoney(double paid,double totalprice){
       if(paid<totalprice){
           Alert AT=new Alert(Alert.AlertType.ERROR);
            AT.setHeaderText(null);
            AT.setContentText("القيمة المدفوعة اقل من سعر المشتريات");
            AT.showAndWait();
            return 0;
       }else{
           return paid-totalprice;
       }
   }
   
   
}
