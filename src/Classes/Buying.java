/*
 * To Make changes about every thing belongs to buying goods
 * from traiders or supplierd
 */
package Classes;

import java.sql.Time;
import javafx.scene.control.Alert;


public class Buying extends Common_Properties{ // Common_Methods is an Interface include Add , Update , Delete
    private long number;
    private Time time;
    private String barcodfiled;
    private String supplier;
    private double paid;
    private double totalPrice;
    private String name;
    private double UintPrice;
    private int CurrentQuantity;
    private double cost;
    private double reminderMoney;
    private String quantityKind;
    /*
        this.Quan;
        this.Serial;
        this.Date;
        
        Are public variables extends from Common_Properties ..
    */

    public String getQuantityKind() {
        return quantityKind;
    }

    public void setQuantityKind(String quantityKind) {
        this.quantityKind = quantityKind;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getBarcodfiled() {
        return barcodfiled;
    }

    public void setBarcodfiled(String barcodfiled) {
        this.barcodfiled = barcodfiled;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public int getCurrentQuantity() {
        return CurrentQuantity;
    }

    public void setCurrentQuantity(int CurrentQuantity) {
        this.CurrentQuantity = CurrentQuantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getReminderMoney() {
        return reminderMoney;
    }

    public void setReminderMoney(double reminderMoney) {
        this.reminderMoney = reminderMoney;
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
           Alerts.showErrorAlert("القيمة المدفوعة اقل من سعر المشتريات");
           return 0;
       }else{
           return paid-totalprice;
       }
   }
    
 
    }

  
    
    
    

