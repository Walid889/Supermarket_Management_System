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
public class Recalls extends Common_Properties{// Common_Methods is an Interface include Add , Update , Delete
    private String Source;

    public Recalls(String Date,long Serial,Quantity quantity,String Source) {
        this.Date=Date;
        this.Serial=Serial;
        this.Quan.Qua_Item=quantity.Qua_Item;
        this.Quan.Qua_Packet=quantity.Qua_Packet;
        this.Quan.Qua_Box=quantity.Qua_Box;
        this.Source = Source; // from Supplier or Customer
    }
    /*
        this.Date;
        this.Serial;
        this.Quan;
        
        Are public variables extends from Common_Properties ..
    */

    public String getSource() {
        return Source;
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

    
    
    public void setSource(String Source) {
        this.Source = Source;
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
