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
public class Defects {
    private String Name;
    private String Quantity;

    public Defects(String Name, String Quantity) {
        this.Name = Name;
        this.Quantity = Quantity;
    }

    public String getName() {
        return Name;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }
    
    /**************************************************************************/
    
    
    public void Get_Defects_Items(){
        
    }
}
