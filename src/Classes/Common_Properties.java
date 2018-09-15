/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Walid
 */
public class Common_Properties extends Quantity{
    public int Serial;
    public Date Date;
    protected Time time;
    protected String name;
    protected String barcodfiled;
    protected double UintPrice;
    protected int CurrentQuantity;
    protected double cost;
    protected String quantityKind;
    protected long number;
    protected double TotalPrice;
    public Common_Properties(){
        
    }
    
    
    public Common_Properties(String barcode, String productName, int quantity){  // this constructor for Defects Items
        this.barcodfiled = barcode;
        this.name = productName;
        this.CurrentQuantity = quantity;
    }

    
    public Common_Properties(String barcodfiled, String name, double UintPrice, int CurrentQuantity, String quantityKind, double cost,Date d, Time time,long num) { // this constructor for Damages Items
        // this constructor for Damages Items
        this.barcodfiled = barcodfiled; 
        this.name = name;
        this.UintPrice = UintPrice;
        this.CurrentQuantity = CurrentQuantity;
        this.cost = cost;
        this.quantityKind = quantityKind;
        this.time = time;
        this.Date=d;
        this.number=num;
    }

    public int getSerial() {
        return Serial;
    }

    public Date getDate() {
        return Date;
    }

    public Time getTime() {
        return time;
    }

    public double getUintPrice() {
        return UintPrice;
    }

    public double getCost() {
        return cost;
    }

    public String getQuantityKind() {
        return quantityKind;
    }
    
    
    public String getBarcodfiled() {
        return barcodfiled;
    }

    public int getCurrentQuantity() {
        return CurrentQuantity;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }
    
    public double CalcCostOfSoldItem(double price,double quantity){
       return price*quantity;
   }
}
