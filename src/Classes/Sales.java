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
public class Sales extends Common_Properties{// Common_Methods is an Interface include Add , Update , Delete
    private double Total_Price;
    private double Paid;
    private double Rest_Price;
    
    public Sales(String Date,long Serial,Quantity quantity,double Total_Price, double Paid, double Rest_Price) {
        this.Date=Date;
        this.Serial=Serial;
        this.Quan.Qua_Item=quantity.Qua_Item;
        this.Quan.Qua_Packet=quantity.Qua_Packet;
        this.Quan.Qua_Box=quantity.Qua_Box;
        this.Total_Price = Total_Price;
        this.Paid = Paid;
        this.Rest_Price = Rest_Price;
    }

    /*
        this.Quan;
        this.Serial;
        this.Date;
        
        Are public variables extends from Common_Properties ..
    */
    
    public double getTotal_Price() {
        return Total_Price;
    }

    public double getPaid() {
        return Paid;
    }

    public double getRest_Price() {
        return Rest_Price;
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

    
    
    
    public void setTotal_Price(double Total_Price) {
        this.Total_Price = Total_Price;
    }

    public void setPaid(double Paid) {
        this.Paid = Paid;
    }

    public void setRest_Price(double Rest_Price) {
        this.Rest_Price = Rest_Price;
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

    
    /*********************************METHODS**********************************/
    
    public boolean Delete_Row(){
        return true; // return true tell execute its code
    }
    
    public boolean Freeze(){
        return true; // return true tell execute its code
    }
    
    public boolean Next_Process(){
        return true; // return true tell execute its code
    }
    
    public boolean Last_Process(){
        return true; // return true tell execute its code
    }
    
    public double Calc_Total_Price(){
        
        return Total_Price;
    }
    
}
