
package Classes;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.derby.client.am.DateTime;


public class Employee{// Common_Methods is an Interface include Add , Update , Delete
    private long number;
    private Time time;
    private String employeeName;
    private String employeeId;
    private String employeePhone;
    private String employeeAddress;
    private String employeeExpensesReason;
    private double employeeSalaryHours ;
    private double employeeExpensesCost;
    private double employeeHourlyWage;
    private Time start;
    private Time end ;
    private double difference;

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }


    public Employee(String id, String name, String phone, String address, double salary) {
       employeeId=id;
       employeeName=name;
       employeePhone=phone;
       employeeAddress=address;
       employeeSalaryHours=salary;
    }
    public Employee(double a , String b)
    {
        employeeExpensesCost=a;
        employeeExpensesReason=b;
    }
    public Employee(){
        
    }

    

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeExpensesReason() {
        return employeeExpensesReason;
    }

    public void setEmployeeExpensesReason(String employeeExpensesReason) {
        this.employeeExpensesReason = employeeExpensesReason;
    }

    public double getEmployeeSalaryHours() {
        return employeeSalaryHours;
    }

    public void setEmployeeSalaryHours(double employeeWorkingHours) {
        this.employeeSalaryHours = employeeWorkingHours;
    }

    public double getEmployeeExpensesCost() {
        return employeeExpensesCost;
    }

    public void setEmployeeExpensesCost(double employeeExpensesCost) {
        this.employeeExpensesCost = employeeExpensesCost;
    }

    public double getEmployeeHourlyWage() {
        return employeeHourlyWage;
    }

    public void setEmployeeHourlyWage(double employeeHourlyWage) {
        this.employeeHourlyWage = employeeHourlyWage;
    }
    
  
    
    
    
    
    
    
    
    
    
    
    
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
    ///////////////////////////ATTENDENCE//////////////////////////////
    
  
// Main function which finds difference 
public String getTimeDiff(Date dateOne, Date dateTwo) {        
    String diff = "";        
    long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime());        
    diff = String.format("%d hour(s) %d min(s)", 
        TimeUnit.MILLISECONDS.toHours(timeDiff),                
        TimeUnit.MILLISECONDS.toMinutes(timeDiff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff)));        
return diff;}
//////////////////////////////////////////////

    public void setStart(String time2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}