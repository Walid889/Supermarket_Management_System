/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Walid
 */
public class Login {
     
public static final String CONFIG_FILE = "config.txt";
    
    String code;
    String password;

    public Login() {
        
        
    }

    public String getcode() {
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
public static Login getPreferences() {
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
}
