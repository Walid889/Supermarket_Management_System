
package Manager.Employee;

import Classes.Alerts;
import Classes.Employee;
import Manager.Main.HomeController;
import database.DataHelper;
import database.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class Manager_EmployeeController implements Initializable {
     HomeController x = new HomeController();
    @FXML
    private AnchorPane Manger_Employee;
    @FXML
    private VBox Vbox;
    @FXML
    private Label Employees;
    @FXML
    private Label E_name;
    @FXML
    private Label E_Code;
    @FXML
    private Label E_phone;
    @FXML
    private Label E_Address;
    @FXML
    private Label E_Salary;
    @FXML
    private TableView<Employee> E_tables;
    private static String oldBar="";
    @FXML
    private TextField E_Tname;
    @FXML
    private TextField E_Tcode;
    @FXML
    private TextField E_Tphone;
    @FXML
    private TextArea E_Taddress;
    @FXML
    private TextField E_Tsalary;
     @FXML
    private TableColumn<Employee, String> t_address;
     @FXML
    private TableColumn<Employee, Double> t_salary;
     @FXML
    private TableColumn<Employee, String> t_phone;
     @FXML
    private TableColumn<Employee, String> t_code;
     @FXML
    private TableColumn<Employee, String> t_name;
    /**
     * Initializes the controller class.
     */
    
    DatabaseHandler databaseHandler; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     databaseHandler= DatabaseHandler.getInstance();
     t_name.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
     t_code.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
     t_phone.setCellValueFactory(new PropertyValueFactory<>("employeePhone"));
     t_salary.setCellValueFactory(new PropertyValueFactory<>("employeeSalaryHours"));
     t_address.setCellValueFactory(new PropertyValueFactory<>("employeeAddress"));
     DataHelper.loadEmployeesData(E_tables);
     
    }    

    @FXML
    private void Employee_Reports(ActionEvent event) {
        x.loadwindow(Manger_Employee,"/Manager/Employee/Reports/Employee_Reports.fxml");
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
        x.loadwindow(Manger_Employee,"/Manager/Main/Home.fxml");
    }
    @FXML
    private void Add_Employee(ActionEvent event) {
        this.AddEmployee();
    }
    @FXML
    private void Delete_Employee(ActionEvent event){
        this.Delete_Employee();
    }

    
    
    
    
    
    
    
    
    
    /***************************************************************************** Add new Employee*********************************************/
     private void AddEmployee(){
         if ( !E_Tname.getText().equals("") && !E_Tcode.getText().equals("") && !E_Tphone.getText().equals("") && !E_Taddress.getText().equals("") && !E_Tsalary.getText().equals("")  ){
              try{
                    Employee E =new Employee();
                    E.setEmployeeName(E_Tname.getText());
                    E.setEmployeeId(E_Tcode.getText());
                    E.setEmployeePhone(E_Tphone.getText());
                    E.setEmployeeSalaryHours(Double.parseDouble(E_Tsalary.getText()));
                    E.setEmployeeAddress(E_Taddress.getText());
        
        
                    boolean result = DataHelper.insertNewemployee(E);
                    E_tables.getItems().add(E);
                    if(result){
                        Alert AT=new Alert(Alert.AlertType.INFORMATION);
                        AT.setHeaderText(null);
                        AT.setContentText("تمت الأضافة بنجاح");
                        AT.showAndWait();
                        clear();
                        return;
                    }
                        }catch (NumberFormatException es)
                        {
                            Alerts.showErrorAlert("لقد ادخلت قيمة غير صحيحة !!");
                        }

                     }
                    else 
                    {  
                        Alerts.showErrorAlert("برجاء ملىء جميع الحقول المطلوبة");
                        
                    }

                }

     
     
     /*********************************************************************************Edit Employee************************************************/
    @FXML
    private void Edit_Employee(ActionEvent event) {
         if ( !E_Tname.getText().equals("") && !E_Tcode.getText().equals("") && !E_Tphone.getText().equals("") && !E_Taddress.getText().equals("") && !E_Tsalary.getText().equals("")  ){
            
             try{
           
                 String name=E_Tname.getText();
                  String phone=E_Tphone.getText();
                  String id =E_Tcode.getText();
                  String address=E_Taddress.getText();
                  double salary=Double.parseDouble(E_Tsalary.getText());
           
                     
                    Employee e = new Employee(id,name,phone,address,salary);
                  
                boolean result=DataHelper.updateEmployee(e,oldBar);
        if(result){
            Alerts.showInfoAlert("تم تعديل بيانات :"+e.getEmployeeName());
            DataHelper.loadEmployeesData(E_tables);
        }
        else
            Alerts.showInfoAlert("لم تتم العملية بشكل صحيح ");
    
            }catch (NumberFormatException es)
            {
                Alerts.showErrorAlert("لقد ادخلت قيمة غير صحيحة !!");
            }
         }
         else 
        {  
            Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
            
        }
         
    }
    
    
    
     /*********************************************************************************Delete Employee************************************************/
    
    private void Delete_Employee() {
        if ( !E_Tname.getText().equals("") && !E_Tcode.getText().equals("") && !E_Tphone.getText().equals("") && !E_Taddress.getText().equals("") && !E_Tsalary.getText().equals("")  ){  
           Employee G=E_tables.getSelectionModel().getSelectedItem();
        
        if (Alerts.ConfirmAlert("هل تريد مسح"+":", G.getEmployeeId())) {
                Boolean result = DataHelper.deleteEmployee(G);
                if (result) {
                    Alerts.showInfoAlert("تم المسح !!");
                    E_tables.getItems().removeAll(E_tables.getSelectionModel().getSelectedItem());
                    clear();
                }
                 else 
                    Alerts.showErrorAlert("لم تتم العملية بشكل صحيح .. يرجى التواصل مع الدعم الفنى");
            }
    } else 
        {
             Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
        }
    }    

    @FXML
    private void Employee_Choice(ActionEvent event) {
        
        if(!E_tables.getItems().equals(""))
        {
            
            Alerts.showErrorAlert("برجاء اختيار الصف ");
          
        }
         else 
        {  
            
            System.out.println("اكتب الكووووود");
        }
    }

     
     /***************************************************TO get items of table in  textFields*************************************************/
    
    @FXML
    private void selectFromTable(MouseEvent event) {
         Employee emp=E_tables.getSelectionModel().getSelectedItem();
        
         E_Tname.setText(emp.getEmployeeName());
        E_Tcode.setText(emp.getEmployeeId());
        E_Tphone.setText(emp.getEmployeePhone());
        E_Tsalary.setText(""+emp.getEmployeeHourlyWage()+"");
        E_Taddress.setText(emp.getEmployeeAddress());
        oldBar=E_Tcode.getText();
    }
    

   /***************************************************TO clear what in TextFields*************************************************/
    
    private void clear()
    {
        E_Tname.setText("");
        E_Tcode.setText("");
        E_Tphone.setText("");
        E_Tsalary.setText("");
        E_Taddress.setText("");
    }

   


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*************************************************************** Methods of keyWORDS************************************/



@FXML
    private void Key_pressed(KeyEvent event) {
            try{
        if(event.getCode().equals(KeyCode.S)){
          this.AddEmployee(); }
        else if (event.getCode().equals(KeyCode.DELETE)){
          this.Delete_Employee();
        }
    }catch(Exception e){}
       
    }

    
       
  
}