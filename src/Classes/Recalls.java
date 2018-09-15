package Classes;

import java.sql.Date;
import java.sql.Time;

public class Recalls extends Common_Properties{// Common_Methods is an Interface include Add , Update , Delete
 
    private String source;

    public Recalls() {
    }

    
    public Recalls(String barcodfiled, String name, double UintPrice, int CurrentQuantity, String quantityKind, double cost,Date d, Time time, String source,long num) {
        this.barcodfiled = barcodfiled;
        this.name = name;
        this.UintPrice = UintPrice;
        this.CurrentQuantity = CurrentQuantity;
        this.quantityKind = quantityKind;
        this.cost = cost;
        this.Date=d;
        this.time = time;
        this.source = source;
        this.number=num;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
    
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getQuantityKind() {
        return quantityKind;
    }

    public void setQuantityKind(String quantityKind) {
        this.quantityKind = quantityKind;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date Date) {
        this.Date = Date;
    }

}
