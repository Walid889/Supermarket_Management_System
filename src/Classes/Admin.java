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
public class Admin {
    private String Log_Code;
    private String Password;
    
    public Admin(String Log_Code, String Password) {
        this.Log_Code = Log_Code;
        this.Password = Password;
    }
    
    

    public String getLog_Code() {
        return Log_Code;
    }

    public String getPassword() {
        return Password;
    }

    public void setLog_Code(String Log_Code) {
        this.Log_Code = Log_Code;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
        
    
    public boolean Update_My_Data(){
        return true; // return true tell execute its code
    }
    
}
