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
public class Expences {// Common_Methods is an Interface include Add , Update , Delete
    private double Cost;
    private String Reason;
    private double Total_Cost;

    public Expences(double Cost, String Reason, double Total_Cost) {
        
        this.Cost = Cost;
        this.Reason = Reason;
        this.Total_Cost = Total_Cost;
    }

    public double getCost() {
        return Cost;
    }

    public String getReason() {
        return Reason;
    }

    public double getTotal_Cost() {
        return Total_Cost;
    }

    
    
    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public void setTotal_Cost(double Total_Cost) {
        this.Total_Cost = Total_Cost;
    }
    
    
    
}
