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
    
    
    
    
    
    /****************************************************************************************************************/
    /***********************************************SALES CONTROLLER*************************************************/

    public static boolean insertNewSale(Sales sal){
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO sales (number,sale_id,sale_date,product_name,qty_kind,unit_price,current_qty,cost,t_time) VALUES(?,?,?,?,?,?,?,?,?)");
            statement.setLong(1, sal.getNumber());
            statement.setInt(2,sal.getSerial());
            statement.setDate(3,sal.getDate() );
            statement.setString(4,sal.getName());
            statement.setString(5,sal.getQuantityKind());
            statement.setDouble(6,sal.getUintPrice());
            statement.setInt(7,sal.getCurrentQuantity());
            statement.setDouble(8,sal.getCost());
            statement.setTime(9, sal.getTime());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
        }
        return false;
    }
    public static boolean insertNewBill(Sales sal){
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO bills (sale_id,sale_date,t_time,total_price,paid_money,reminder_money) VALUES(?,?,?,?,?,?)");
            
            statement.setInt(1,sal.getSerial());
            statement.setDate(2,sal.getDate() );
            statement.setTime(3, sal.getTime());
            statement.setDouble(4,sal.getTotalPrice());
            statement.setDouble(5,sal.getPaid());
            statement.setDouble(6,sal.getReminderMoney());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
        }
        return false;
    }
    
    public static boolean deleteSale(Sales sal) {
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement( 
                    "DELETE FROM sales WHERE number = ?");
            
            statement.setLong(1, sal.getNumber());
            int res = statement.executeUpdate();
            if (res == 1) {
                return true;
            }
        }
        catch (SQLException ex) {//    
        }
        return false;
    }
    
    public static boolean deleteAllRowsInSalesTV(int serial) {
        String qu = "DELETE FROM sales WHERE sale_id ="+serial+""; //
        if(DatabaseHandler.getInstance().execAction(qu)){
            return true;
        }
        return false;
    }
    /****************************************************************************************************************/
    /*public static boolean cleanDBEfficiently(){
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement( 
                    "DELETE FROM sales WHERE number>1 and number<100000000000 ");
            int res = statement.executeUpdate();
            if (res == 1) {
                return true;
            }
        }
        catch (SQLException ex) {//    
        }
        return false;
    }
    /****************************************************************************************************************/
    /****************************************************************************************************************/
}
