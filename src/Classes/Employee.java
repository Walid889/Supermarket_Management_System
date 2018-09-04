/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.derby.client.am.DateTime;

/**
 *
 * @author Walid
 */
public class Employee{// Common_Methods is an Interface include Add , Update , Delete
    private String employeeName;
    private String employeeId;
    private String employeePhone;
    private String employeeAddress;
    private String employeeExpensesReason;
    private double employeeSalaryHours;
    private double employeeExpensesCost;
    private double employeeHourlyWage;

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
    
     

}