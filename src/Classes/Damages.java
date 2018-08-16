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
public class Damages extends Common_Properties{// Common_Methods is an Interface include Add , Update , Delete
    private String Code;

    public Damages(String Code,Quantity quantity,long serial,String Date) {
        this.Code = Code;
        this.Quan.Qua_Item = quantity.Qua_Item;
        this.Quan.Qua_Packet = quantity.Qua_Packet;
        this.Quan.Qua_Box = quantity.Qua_Box;
        this.Serial = serial;
        this.Date = Date;
        
    }
    /*
        this.Quan.Qua
        this.Serial;
        this.Date;
        
        Are public variables extends from Common_Properties ..
    */
    
    
    public String getCode() {
        return Code;
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

    
    
    
    
    
    public void setCode(String Code) {
        this.Code = Code;
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
