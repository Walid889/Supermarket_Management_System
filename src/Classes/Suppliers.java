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
public class Suppliers{// Common_Methods is an Interface include Add , Update , Delete
    private String Name;
    private String Phone;
    private String Category;
    private String Salesperson;

    public Suppliers(String Name, String Phone, String Category, String Salesperson) {
        this.Name = Name;
        this.Phone = Phone;
        this.Category = Category;
        this.Salesperson = Salesperson;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getCategory() {
        return Category;
    }

    public String getSupplier() {
        return Salesperson;
    }    

    
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setSalesperson(String Salesperson) {
        this.Salesperson = Salesperson;
    }
    
}
