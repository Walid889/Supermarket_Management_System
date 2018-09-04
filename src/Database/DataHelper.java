package database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Classes.*;
//import datamodel.employee1;
//import library.assistant.data.model.MailServerInfo;
//import library.assistant.ui.listmember.MemberListController.Member;

public class DataHelper {

    public static boolean insertNewemployee(Employee emp) {
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO employee1(emp_id,emp_name,emp_phone,emp_salary_hours,emp_address) VALUES(?,?,?,?,?)");
            statement.setString(1, emp.getEmployeeId());
            statement.setString(2, emp.getEmployeeName());
            statement.setString(3, emp.getEmployeePhone());
            statement.setDouble(4, emp.getEmployeeSalaryHours());
            statement.setString(5, emp.getEmployeeAddress());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            
        }
        return false;
    }
  /*public static boolean isEmployeeExists(String id) {
        try {
            String checkstmt = "SELECT COUNT(*) FROM employee1 WHERE id=?";
            PreparedStatement stmt = DatabaseHandler.getInstance().getConnection().prepareStatement(checkstmt);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println(count);
                return (count > 0);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }*/
    public static boolean insertNewSale(Sales sal){
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO sales (sale_id,sale_date,product_name,qty_kind,unit_price,current_qty,cost) VALUES(?,?,?,?,?,?,?)");
            
            statement.setInt(1,sal.getSerial());
            statement.setDate(2,sal.getDate() );
            statement.setString(3,sal.getName());
            statement.setString(4,sal.getQuantityKind());
            statement.setDouble(5,sal.getUintPrice());
            statement.setInt(6,sal.getCurrentQuantity());
            statement.setDouble(7,sal.getCost());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
        }
        return false;
    }
    public static boolean insertNewBill(Sales sal){
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO bills (sale_id,sale_date,total_price,paid_money,reminder_money) VALUES(?,?,?,?,?)");
            
            statement.setInt(1,sal.getSerial());
            statement.setDate(2,sal.getDate() );
            statement.setDouble(3,sal.getTotalPrice());
            statement.setDouble(4,sal.getPaid());
            statement.setDouble(5,sal.getReminderMoney());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
        }
        return false;
    }
    public static boolean insertNewExpences(Expences E)
    {
        try{
        PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO shop_costs (price,reason,total) VALUES(?,?,?)");
        statement.setDouble(1, E.getCost());
        statement.setString(2, E.getReason());
        statement.setDouble(3, E.getTotalCost());
        return statement.executeUpdate() > 0;
        } catch (SQLException ex)
        {
        }
        return false;
    }
    public static boolean insertNewSupplier(Suppliers s)
    {
        try{
        PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO suppliers1 (sup_name,sup_company_name,sup_category,sup_phone) VALUES(?,?,?,?)");
        statement.setString(1, s.getSupplierName());
        statement.setString(2, s.getSupplierCategory());
        statement.setInt(3, s.getSupplierPhone());
        statement.setString(4, s.getSalespersonName());
        return statement.executeUpdate() > 0;
        } catch (SQLException ex)
        {
        }
        return false;
    }
}
