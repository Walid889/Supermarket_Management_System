package database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Classes.*;
import employees.sales.SalesController;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;
//import datamodel.employee1;
//import library.assistant.data.model.MailServerInfo;
//import library.assistant.ui.listmember.MemberListController.Member;

public class DataHelper {

    
    
    /****************************************************************************************************************/
    /*********************************MANAGER_PRODUCT_CONTROLLER********GOODS****************************************/
    
    
    public static boolean insertNewProduct(Goods go) {
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO product(pro_bar,pro_name,pro_category,pro_supplier_name,"
                    + "pro_qty_item,pro_qty_packet,pro_All_qty,pro_price_item,pro_price_packet,"
                    + "pro_price_box,pro_minimum) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, go.getProductBarCode());
            statement.setString(2, go.getProductName());
            statement.setString(3, go.getProductCategory());
            statement.setString(4, go.getProductSupplier());
            statement.setInt(5, go.getItemsInPacket());
            statement.setInt(6, go.getPacketsInBox());
            statement.setLong(7, go.getAllQuantity());
            statement.setDouble(8, go.getItemPrice());
            statement.setDouble(9, go.getPacketPrice());
            statement.setDouble(10, go.getBoxPrice());
            statement.setInt(11, go.getProductMinQuantity());
            //statement.setString(13, go.getProductExpirationdate());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            
        }
        return false;
    }
    
    public static boolean updateProductInfo(Goods go,String bar) {
        try {
            
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "UPDATE product SET  pro_bar=?,pro_name=?,pro_category=?,pro_supplier_name=?,"
                            + "pro_qty_item=?,pro_qty_packet=?,pro_All_qty=?,pro_price_item=?,"
                            + "pro_price_packet=?,pro_price_box=?,pro_minimum=?  WHERE pro_bar= '"+bar+"' ");
            
            statement.setString(1, go.getProductBarCode());
            statement.setString(2, go.getProductName());
            statement.setString(3, go.getProductCategory());
            statement.setString(4, go.getProductSupplier());
            statement.setInt(5, go.getItemsInPacket());
            statement.setInt(6, go.getPacketsInBox());
            statement.setLong(7, go.getAllQuantity());
            statement.setDouble(8, go.getItemPrice());
            statement.setDouble(9, go.getPacketPrice());
            statement.setDouble(10, go.getBoxPrice());
            statement.setInt(11, go.getProductMinQuantity());
            //statement.setString(13, go.getProductExpirationdate());
            return statement.executeUpdate() > 0;
        }
        catch (SQLException ex) {
        }
        return false;
    }
    public static boolean QuickEditQuantity(int quan,String bar) {
        String qu="UPDATE product SET  pro_All_qty="+quan+" WHERE pro_bar = '"+bar+"' ";
        if(DatabaseHandler.getInstance().execAction(qu))
            return true;
        return false;
    }

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    //////////////////////Employee//////////////////////////////////
    //////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
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
    public static boolean deleteEmployee(Employee emp) {
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement( 
                    "DELETE FROM employee1 WHERE number = ?");
            
            statement.setLong(1, emp.getNumber());
            int res = statement.executeUpdate();
            if (res == 1) {
                return true;
            }
        }
        catch (SQLException ex) {//    
        }
        return false;
    }
    public static boolean updateEmployee(Employee E )
    {
        try {
            
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "UPDATE Employee1 SET  emp_id=?,emp_name=?,emp_phone=?,emp_address=?,,emp_salary_hours=?");
            statement.setString(1, E.getEmployeeId());
            statement.setString(1, E.getEmployeeName());
            statement.setString(1, E.getEmployeePhone());
            statement.setString(1, E.getEmployeeAddress());
            statement.setDouble(1, E.getEmployeeSalaryHours());
          
            return statement.executeUpdate() > 0;
        }
        catch (SQLException ex) {
        }
        return false;
    }
    
    
    ///////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    /////////////////End employee///////////////////////////////
    ///////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////
    
    
    ///////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ///////////////////////////Suppliers////////////////////
    /////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////
    public static boolean insertNewSupplier(Suppliers s)
    {
        try{
        PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO suppliers1 (sup_name,sup_company_name,sup_category,sup_phone) VALUES(?,?,?,?)");
        statement.setString(1, s.getSupplierName());
        statement.setString(2, s.getSupplierCategory());
        statement.setString(3, s.getSupplierPhone());
        statement.setString(4, s.getSalespersonName());
        return statement.executeUpdate() > 0;
        } catch (SQLException ex)
        {
        }
        return false;
    }
    public static boolean deleteSupplier(Suppliers sup) {
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement( 
                    "DELETE FROM suppliers1 WHERE number = ?");
            
            statement.setLong(1, sup.getNumber());
            int res = statement.executeUpdate();
            if (res == 1) {
                return true;
            }
        }
        catch (SQLException ex) {//    
        }
        return false;
    }
    public static boolean updateSupplier(Suppliers s )
    {
        try {
            
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "UPDATE suppliers1 SET  sup_name=?,sup_company_name=?,sup_category=?,sup_phone=?,");
            
            statement.setString(1, s.getSupplierName());
            statement.setString(2, s.getSupplierPhone());
            statement.setString(3, s.getSupplierCategory());
            statement.setString(4, s.getSalespersonName());
           
            return statement.executeUpdate() > 0;
        }
        catch (SQLException ex) {
        }
        return false;
    }
    public static void loadSuppliersData(TableView TV,TextField TF) {
        ObservableList<Suppliers> list = FXCollections.observableArrayList();
        ObservableList<String> list2 = FXCollections.observableArrayList();
        list.clear();
        String qu = "SELECT * FROM suppliers1";
        ResultSet rs =DatabaseHandler.getInstance().execQuery(qu);
        try {
            while (rs.next()) {
                String name=rs.getString("supplierName");
                String phone=rs.getString("supplierPhone");
                String category=rs.getString("supplierCategory");
                String sales_name=rs.getString("salespersonName");
                list.add(new Suppliers(name,phone,category,sales_name));
                list2.add(phone);
            }
        } catch (SQLException ex) {
            Alerts.showInfoAlert("لا يوجد موردين");
        }
        TV.setItems(list);
        TextFields.bindAutoCompletion(TF, list2);
    }
    public static ObservableList<Suppliers> o(ObservableList<Suppliers> list){
        list.clear();
        String qu = "SELECT * FROM suppliers1";
        ResultSet rs =DatabaseHandler.getInstance().execQuery(qu);
        try {
            while (rs.next()) {
                String name=rs.getString("supplierName");
                String phone=rs.getString("supplierPhone");
                String category=rs.getString("supplierCategory");
                String sales_name=rs.getString("salespersonName");
               list.add(new Suppliers(name,phone,category,sales_name));
            }
        } catch (SQLException ex) {
            Alerts.showInfoAlert("لا يوجد موردين");
        }
        return list;
    }
    //////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    /////////////////////////End Suppliers///////////////////////////////
    /////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////
    public static void loadProductsData(TableView TV,TextField TF) {
        ObservableList<Goods> list = FXCollections.observableArrayList();
        ObservableList<String> list2 = FXCollections.observableArrayList();
        list.clear();
        String qu = "SELECT * FROM product";
        ResultSet rs =DatabaseHandler.getInstance().execQuery(qu);
        try {
            while (rs.next()) {
                String name=rs.getString("pro_name");
                String bar=rs.getString("pro_bar");
                String cate=rs.getString("pro_category");
                String sup=rs.getString("pro_supplier_name");
                int it=rs.getInt("pro_qty_item");
                int pa=rs.getInt("pro_qty_packet");
                double Pi=rs.getDouble("pro_price_item");
                double Pp=rs.getDouble("pro_price_packet");
                double Pb=rs.getDouble("pro_price_box");
                int mP=rs.getInt("pro_minimum");
                //G.setProductExpirationdate(P_Tdate.getText());
                int aq=rs.getInt("pro_All_qty");
                list.add(new Goods(name, bar, cate, sup, it, pa, Pi, Pp, Pb, mP,aq));
                list2.add(bar);
            }
        } catch (SQLException ex) {
            Alerts.showInfoAlert("لا يوجد اصناف");
        }
        TV.setItems(list);
        TextFields.bindAutoCompletion(TF, list2);
    }
    public static ObservableList<Goods> autos(ObservableList<Goods> list){
        list.clear();
        String qu = "SELECT * FROM product";
        ResultSet rs =DatabaseHandler.getInstance().execQuery(qu);
        try {
            while (rs.next()) {
                String name=rs.getString("pro_name");
                String bar=rs.getString("pro_bar");
                String cate=rs.getString("pro_category");
                String sup=rs.getString("pro_supplier_name");
                int it=rs.getInt("pro_qty_item");
                int pa=rs.getInt("pro_qty_packet");
                double Pi=rs.getDouble("pro_price_item");
                double Pp=rs.getDouble("pro_price_packet");
                double Pb=rs.getDouble("pro_price_box");
                int mP=rs.getInt("pro_minimum");
                //G.setProductExpirationdate(P_Tdate.getText());
                int aq=rs.getInt("pro_All_qty");
                list.add(new Goods(name, bar, cate, sup, it, pa, Pi, Pp, Pb, mP,aq));
            }
        } catch (SQLException ex) {
            Alerts.showInfoAlert("لا يوجد اصناف");
        }
        return list;
    }
    public static boolean deleteProduct(Goods go) {
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement( 
                    "DELETE FROM product WHERE pro_bar = ?");
            
            statement.setString(1, go.getProductBarCode());
            return statement.executeUpdate() > 0;
        }
        catch (SQLException ex) {//    
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
    /////////////////////////////////////
    ////////////////delete/////////////////////
    //////////////////////////////////////////
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
    
    
    
    /////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    public static boolean deleteAllRowsInSalesTV(int serial) {
        String qu = "DELETE FROM sales WHERE sale_id ="+serial+""; //
        if(DatabaseHandler.getInstance().execAction(qu)){
            return true;
        }
        return false;
    }
    
    /////////////////////////////////////////////////////
    ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////
    public static int getLastSerialTodaySales(String D_date){
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
    ///////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////
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
                            /**************************************/
    public static void checkDataBar(TextField TX,ObservableList<String> listBar){
        listBar= FXCollections.observableArrayList();
        String qu="SELECT pro_bar FROM product"; 
        ResultSet rs=DatabaseHandler.getInstance().execQuery(qu);
        try {
            while(rs.next()){
                String barcode=rs.getString("pro_bar");
                listBar.add(barcode);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SalesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        TextFields.bindAutoCompletion(TX, listBar);
    }
    
    public static void fillSalesWithInfoOfProduct(String bar,Label PBar,Label PName,Price pra){ // 
        String qu="SELECT pro_bar,pro_name,pro_price_item,pro_price_packet,pro_price_box FROM product WHERE pro_bar='"+bar+"'"; 
        ResultSet rs=DatabaseHandler.getInstance().execQuery(qu);
        try {
            if(rs.next()){
                PBar.setText(rs.getString("pro_bar"));
                PName.setText(rs.getString("pro_name"));
                pra.setItemPrice(rs.getDouble("pro_price_item"));
                pra.setPacketPrice(rs.getDouble("pro_price_packet"));
                pra.setBoxPrice(rs.getDouble("pro_price_box"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean InterAction_B_Sales__Products_addQuan(Label PBar,int XQuantity,String kquan){
        String bar=PBar.getText();
        String qu="SELECT pro_All_qty,pro_qty_item,pro_qty_packet FROM product WHERE pro_bar='"+bar+"'";
        ResultSet rs=DatabaseHandler.getInstance().execQuery(qu);
        int allQuan = 0,iteminbox=0,packetinbox=0,subQuan=0;
        try {
            if(rs.next()){
                allQuan=rs.getInt("pro_All_qty");
                iteminbox=rs.getInt("pro_qty_item");
                packetinbox=rs.getInt("pro_qty_packet");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(kquan.equals("قطعة")){
            if((allQuan-XQuantity)>0)
                subQuan=allQuan-XQuantity;
            else {Alerts.showErrorAlert("لا توجد كمية كافية"); return false;}
        }
        else if(kquan.equals("علبة")){
            if((allQuan- (XQuantity*iteminbox))>0)
                subQuan=allQuan- (XQuantity*iteminbox);
            else{ Alerts.showErrorAlert("لا توجد كمية كافية"); return false;}
        }
        else{
            if((allQuan- (XQuantity*iteminbox*packetinbox) ) > 0)
                subQuan=allQuan- (XQuantity*iteminbox*packetinbox);
            else
            {Alerts.showErrorAlert("لا توجد كمية كافية"); return false;}
        }
        String qu2="UPDATE product SET pro_All_qty= "+subQuan+" WHERE pro_bar = '"+bar+"'";
        if(DatabaseHandler.getInstance().execAction(qu2))
            return true;
        
        return false;
    }
    
    public static boolean InterAction_B_Sales__Products_DeleteQuan(String bar,int XQuantity,String kquan){
        String qu="SELECT pro_All_qty,pro_qty_item,pro_qty_packet FROM product WHERE pro_bar='"+bar+"'";
        ResultSet rs=DatabaseHandler.getInstance().execQuery(qu);
        int allQuan = 0,iteminbox=0,packetinbox=0,AddQuan=0;
        try {
            if(rs.next()){
                allQuan=rs.getInt("pro_All_qty");
                iteminbox=rs.getInt("pro_qty_item");
                packetinbox=rs.getInt("pro_qty_packet");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(kquan.equals("قطعة")){
            AddQuan=allQuan+XQuantity;
        }
        else if(kquan.equals("علبة")){
            AddQuan=allQuan+ (XQuantity*iteminbox);
        }
        else{
            AddQuan=allQuan+ (XQuantity*iteminbox*packetinbox);
        }
        
        String qu2="UPDATE product SET pro_All_qty= "+AddQuan+" WHERE pro_bar = '"+bar+"'";
        if(DatabaseHandler.getInstance().execAction(qu2))
            return true;
        
        return false;
    }
    
    
    
                        /***************************************/
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
    
    
    /****************************************************************************************************************/
    /**********************************************BUYING CONTROLLER*************************************************/
    /****************************************************************************************************************/
    /****************************************************************************************************************/
    
    
    public static boolean insertBuyGoods(Buying buy){
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO buying (number,buy_id,buy_date,product_name,qty_kind,unit_price,current_qty,cost,t_time) VALUES(?,?,?,?,?,?,?,?,?)");
            statement.setLong(1, buy.getNumber());
            statement.setInt(2,buy.getSerial());
            statement.setDate(3,buy.getDate() );
            statement.setString(4,buy.getName());
            statement.setString(5,buy.getQuantityKind());
            statement.setDouble(6,buy.getUintPrice());
            statement.setInt(7,buy.getCurrentQuantity());
            statement.setDouble(8,buy.getCost());
            statement.setTime(9, buy.getTime());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            
        }
        return false;
    }
    public static boolean insertBuyGoodsNewBill(Buying buy){
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO buy_bills (bill_id,bill_date,t_time,supplier_name,total_price) VALUES(?,?,?,?,?)");
            statement.setInt(1, buy.getSerial());
            statement.setDate(2,buy.getDate());
            statement.setTime(3,buy.getTime());
            statement.setString(4,buy.getSupplier());
            statement.setDouble(5, buy.getTotalPrice());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            
        }
        return false;
    }
    
    
    
    public static int getLastSerialTodayBuying(String D_date){
        String qu="SELECT buy_id FROM buying where buy_date = '"+D_date+"'"+" ORDER BY buy_id DESC FETCH FIRST ROW ONLY ";
        ResultSet rs=DatabaseHandler.getInstance().execQuery(qu);
        int srl=0;
        try {
            if(rs.next()){
                srl=rs.getInt("buy_id")+1;
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
    
    
    
    
    
    public static boolean insertNewPersonalExpences(Employee E)
    {
        try{
        PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO employee2 (emp_reason,emp_price_product) VALUES(?,?)");
        statement.setDouble(1, E.getEmployeeExpensesCost());
        statement.setString(2, E.getEmployeeExpensesReason());
       
        return statement.executeUpdate() > 0;
        } catch (SQLException ex)
        {
        }
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
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
    
    public static long getLastOrderNumberBuying(){
        String qu="SELECT number FROM buying ORDER BY number DESC FETCH FIRST ROW ONLY"; 
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
    
    
    
}
