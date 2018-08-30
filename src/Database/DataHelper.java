package database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Classes.*;
//import datamodel.employee1;
//import library.assistant.data.model.MailServerInfo;
//import library.assistant.ui.listmember.MemberListController.Member;

public class DataHelper {

   /* public static boolean insertNewemployee(employee1 emp) {
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO employee1(id,name,phone,address,isAvail) VALUES(?,?,?,?,?)");
            statement.setString(1, emp.getId());
            statement.setString(2, emp.getName());
            statement.setString(3, emp.getPhone());
            statement.setString(4, emp.getAddress());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }*/
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
}
