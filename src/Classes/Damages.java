/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;
import java.sql.Time;


public class Damages extends Common_Properties{// Common_Methods is an Interface include Add , Update , Delete
    
    private String barcodfiled;
    private String name;
    private double UintPrice;
    private int CurrentQuantity;
    private double cost;
    private String quantityKind;
    private Time time;

    public Damages(){
        
    }
    public Damages(String barcodfiled, String name, double UintPrice, int CurrentQuantity, String quantityKind, double cost,Date d, Time time) {
        this.barcodfiled = barcodfiled;
        this.name = name;
        this.UintPrice = UintPrice;
        this.CurrentQuantity = CurrentQuantity;
        this.cost = cost;
        this.quantityKind = quantityKind;
        this.time = time;
        Date=d;
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

    public String getQuantityKind() {
        return quantityKind;
    }

    public void setQuantityKind(String quantityKind) {
        this.quantityKind = quantityKind;
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
   
    }
    /*
        this.Quan.Qua
        this.Serial;
        this.Date;
        
        Are public variables extends from Common_Properties ..
    */
    
    


