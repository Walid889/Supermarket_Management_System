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
public class Goods extends Common_Properties{
    private String Name;
    private String BarCode;
    private String Category;
    private String Supplier;
    private Price Price;
    private Quantity Quantity;
    private int Min_Quantity;
    private String Expiration;

    public Goods(String Name, String Code, String Category, String Supplier, Price Price,
            Quantity quantity, int Min_Quantity, String Expiration) {
        this.Name = Name;
        this.BarCode = Code;
        this.Category = Category;
        this.Supplier = Supplier;
        this.Price = Price;
        this.Quantity.Qua_Item = quantity.Qua_Item;
        this.Quantity.Qua_Packet = quantity.Qua_Packet;
        this.Quantity.Qua_Box = quantity.Qua_Box;
        this.Min_Quantity = Min_Quantity;
        this.Expiration = Expiration;
    }

    public String getName() {
        return Name;
    }

    public String getCode() {
        return BarCode;
    }

    public String getCategory() {
        return Category;
    }

    public String getSupplier() {
        return Supplier;
    }

    public Price getPrice() {
        return Price;
    }

    public Quantity getQuantity() {
        return Quantity;
    }

    public int getMin_Quantity() {
        return Min_Quantity;
    }

    public String getExpiration() {
        return Expiration;
    }

    public String getBarCode() {
        return BarCode;
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
    
    
    
    

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setBarCode(String BarCode) {
        this.BarCode = BarCode;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    public void setPrice(Price Price) {
        this.Price = Price;
    }

    public void setQuantity(Quantity Quantity) {
        this.Quantity = Quantity;
    }

    public void setMin_Quantity(int Min_Quantity) {
        this.Min_Quantity = Min_Quantity;
    }

    public void setExpiration(String Expiration) {
        this.Expiration = Expiration;
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
