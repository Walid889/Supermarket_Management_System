package Classes;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


public class Login {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private String username;
    private String password;
    private String[][] accounts = {{"abotarek", "admin@55555"},{"emp", "12345678"}}; 

    public Login() 
    {
         
        
    }
    public  void setuserName(String user){   // Set Usernamer to check
        username=user;
        
    }
    public  void setuserPassword(String pass){ // Set Password to check
        password=pass;
        
    }

    public int checkPassword()  // check if it admin or Empolyee or error login
    {

        if((username.equals(accounts[0][0])) && (password.equals(accounts[0][1]))) //admin
            return 1;
        
        else if ((username.equals(accounts[1][0])) && (password.equals(accounts[1][1]))) //Employee
            return 2;
        else
            return 3;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
/*    public String getcode() {
        return code;
    }

    public void setcode(String username) {
        this.code = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() < 16) {
            this.password = password;
        }else
            this.password = password;
    }
/*public static Login getPreferences() {
        Gson gson = new Gson();
        Login preferences = new Login();
        try {
            preferences = gson.fromJson(new FileReader(CONFIG_FILE), Login.class);
        } catch (FileNotFoundException ex) {
            initConfig();
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return preferences;
    }
     public static void initConfig() {
        Writer writer = null;
        try {
            Login preference = new Login();
            Gson gson = new Gson();
            writer = new FileWriter(CONFIG_FILE);
            gson.toJson(preference, writer);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void writePreferenceToFile(Login preference) {
        Writer writer = null;
        try {
            Gson gson = new Gson();
            writer = new FileWriter(CONFIG_FILE);
            gson.toJson(preference, writer);

            Alert AT=new Alert(Alert.AlertType.INFORMATION);
            AT.setHeaderText(null);
            AT.setContentText("Successfully  !!");
            AT.showAndWait();
            return;
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            Alert AT=new Alert(Alert.AlertType.INFORMATION);
            AT.setHeaderText(null);
            AT.setContentText("Failed !!");
            AT.showAndWait();
            return;
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
*/
}
