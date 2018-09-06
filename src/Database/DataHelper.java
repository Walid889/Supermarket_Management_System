package database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Classes.*;
import java.sql.ResultSet;
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
    
    
    /****************************************************************************************************************/
    /*********************************MANAGER_PRODUCT_CONTROLLER********GOODS****************************************/
    
    
    public static boolean insertNewProduct(Goods go) {
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO product(pro_bar,pro_name,pro_category,pro_supplier_name,"
                    + "pro_qty_item,pro_qty_packet,pro_qty_box,pro_All_qty,pro_price_item,pro_price_packet,"
                    + "pro_price_box,pro_minimum,pro_expiration_date) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, go.getProductBarCode());
            statement.setString(2, go.getProductName());
            statement.setString(3, go.getProductCategory());
            statement.setString(4, go.getProductSupplier());
            statement.setInt(5, go.getItemsInPacket());
            statement.setInt(6, go.getPacketsInBox());
            statement.setInt(7, go.getBoxes());
            statement.setLong(8, go.getAllQuantity());
            statement.setDouble(9, go.getItemPrice());
            statement.setDouble(10, go.getPacketPrice());
            statement.setDouble(11, go.getBoxPrice());
            statement.setInt(12, go.getProductMinQuantity());
            statement.setString(13, go.getProductExpirationdate());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            
        }
        return false;
    }
    
    
    
    
    
    
    /****************************************************************************************************************/
    /****************************************************************************************************************/
    
    
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
    public static int getLastSerialToday(String D_date){
        String qu="SELECT sale_id FROM sales where sale_date = '"+D_date+"'"+" ORDER BY sale_id DESC FETCH FIRST ROW ONLY ";
        ResultSet rs=DatabaseHandler.getInstance().execQuery(qu);
        int srl=0;
        try {
            if(rs.next()){
                srl=rs.getInt("sale_id")+1;
                System.out.println("llllllllllll");}
            else
           {
                srl=1;
                System.out.println("لسااااا");
           }
        } catch (SQLException ex) {
            Alerts.showErrorAlert("لايوجد بيانات");
        }
        return srl;
    }
    
    public static long getLastOrderNumber(){
        String qu="SELECT number FROM sales ORDER BY number DESC FETCH FIRST ROW ONLY"; 
        ResultSet rs=DatabaseHandler.getInstance().execQuery(qu);
        long num = 0;
        try {
            if(rs.next()){
                num=rs.getLong("number")+1;
                System.out.println("llllllllllll");}
            else
           {
                num=1;
                System.out.println("لسااااا");
//              Alerts.showInfoAlert("اول فواتير اليوم ..");
           }
        } catch (SQLException ex) {
            Alerts.showErrorAlert("لايوجد بيانات");
        }
        return num;
    }
    
    /****************************************************************************************************************/
    /****************************************************************************************************************/
    /*public static boolean cleanDBEfficiently(){
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement( 
                    "DELETE FROM sales WHERE number>1 and number<100000000000 ");
=======
>>>>>>> 505b484313aca1b58227f05bd083b7b3401771f7
            int res = statement.executeUpdate();
            if (res == 1) {
                return true;
            }
        }
        catch (SQLException ex) {//    
<<<<<<< HEAD
=======
        }
        return false;
    }
    
    public static boolean deleteAllRowsInSalesTV(int serial) {
        String qu = "DELETE FROM sales WHERE sale_id ="+serial+""; //
        if(DatabaseHandler.getInstance().execAction(qu)){
            return true;
>>>>>>> 505b484313aca1b58227f05bd083b7b3401771f7
        }
        return false;
    }
    /****************************************************************************************************************/
    /****************************************************************************************************************/
    /****************************************************************************************************************/
    /****************************************************************************************************************/
    
    
    
    
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
