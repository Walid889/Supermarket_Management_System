/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Walid
 */
public class Buying extends Common_Properties{ // Common_Methods is an Interface include Add , Update , Delete
    private String Supplier;
    private double Paid;
    private double Total_Price;

    public Buying(String Date,long Serial,Quantity quantity,String Supplier, double Paid, double Total_Price) {
        this.Date=Date;
        this.Serial=Serial;
        this.Quan.Qua_Item=quantity.Qua_Item;
        this.Quan.Qua_Packet=quantity.Qua_Packet;
        this.Quan.Qua_Box=quantity.Qua_Box;
        this.Supplier = Supplier;
        this.Paid = Paid;
        this.Total_Price = Total_Price;   
    }
    /*
        this.Quan;
        this.Serial;
        this.Date;
        
        Are public variables extends from Common_Properties ..
    */
    
    public String getSupplier() {
        return Supplier;
    }

    public double getPaid() {
        return Paid;
    }

    public double getTotal_Price() {
        return Total_Price;
    }

    public long getSerial() {
        return Serial;
    }

    public String getDate() {
        return Date;
    }

    public Quantity getQuan() {
        return Quan;
    }

    
    
    
    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    public void setPaid(double Paid) {
        this.Paid = Paid;
    }

    public void setTotal_Price(double Total_Price) {
        this.Total_Price = Total_Price;
    }

    public void setSerial(long Serial) {
        this.Serial = Serial;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setQuan(Quantity Quan) {
        this.Quan = Quan;
    }
    
    
    
    
    
}
