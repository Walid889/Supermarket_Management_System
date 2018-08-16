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
public class Employee{// Common_Methods is an Interface include Add , Update , Delete
    private String Name;
    private String ID;
    private String Phone;
    private String Address;
    private String Expenses_Reason;
    private int Working_Hours;
    private double Cost_of_my_Expenses;
    private double Hourly_wage;

    public Employee(String Name, String ID, String Phone, String Address, String Expenses_Reason, int Working_Hours, double Cost_of_my_Expenses) {
        this.Name = Name;
        this.ID = ID;
        this.Phone = Phone;
        this.Address = Address;
        this.Expenses_Reason = Expenses_Reason;
        this.Working_Hours = Working_Hours;
        this.Cost_of_my_Expenses = Cost_of_my_Expenses;
    }
    
    /******************************VARIABLES***********************************/
    public String getName() {
        return Name;
    }

    public String getID() {
        return ID;
    }

    public String getPhone() {
        return Phone;
    }

    public String getAddress() {
        return Address;
    }

    public String getExpenses_Reason() {
        return Expenses_Reason;
    }

    public int getWorking_Hours() {
        return Working_Hours;
    }

    public double getCost_of_my_Expenses() {
        return Cost_of_my_Expenses;
    }

    
    
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setExpenses_Reason(String Expenses_Reason) {
        this.Expenses_Reason = Expenses_Reason;
    }

    public void setWorking_Hours(int Working_Hours) {
        this.Working_Hours = Working_Hours;
    }

    public void setCost_of_my_Expenses(double Cost_of_my_Expenses) {
        this.Cost_of_my_Expenses = Cost_of_my_Expenses;
    }

    public void setHourly_wage(double Hourly_wage) {
        this.Hourly_wage = Hourly_wage;
    }
    
    
    /******************************METHODS*************************************/
    public void Attendance(){
        
    }
    
    public int Leaving(){
        
        return this.Working_Hours;
    }
    
    public void Add_Expenses(){
        
    }
}
