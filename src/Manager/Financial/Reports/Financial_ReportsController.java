
package Manager.Financial.Reports;

import Classes.Alerts;
import Manager.Main.HomeController;
import static Manager.Products.Reports.Products_ReportsController.normal;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.itextpdf.text.pdf.PdfWriter.RUN_DIRECTION_RTL;
import com.jfoenix.controls.JFXDatePicker;
import database.DatabaseHandler;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Financial_ReportsController implements Initializable {
    HomeController x = new HomeController();
    
    @FXML
    private AnchorPane Financial_Reports;
    @FXML
    private Label financial;
    @FXML
    private Label F_date1;
    @FXML
    private Label F_date2;
    @FXML
    private JFXDatePicker F_Tdate1;
    @FXML
    private JFXDatePicker F_Tdate2;

    /**
     * Initializes the controller class.
     */
    DatabaseHandler databaseHandler;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databaseHandler=DatabaseHandler.getInstance();
    }    

    @FXML
    private void Expenses_Reports(ActionEvent event) throws FileNotFoundException, DocumentException {
         try {
         if (!F_Tdate1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") &&!F_Tdate2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") ){
            System.out.println("غلطططططط "); // yoooooooooour code
            expences();
         }
         }
        catch(NullPointerException e){
                 Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
                 }
    }

    @FXML
    private void invoices_Reports(ActionEvent event) throws FileNotFoundException, DocumentException {
         try {
         if (!F_Tdate1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") &&!F_Tdate2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") ){
            System.out.println("غلطططططط "); 
            invoices(F_Tdate1.getValue().toString(),F_Tdate2.getValue().toString());
         }
         }
        catch(NullPointerException e){
                 Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
                 }
    }

    @FXML
    private void Daily_Report(ActionEvent event) {
         try {
         if (!F_Tdate1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") &&!F_Tdate2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals("") ){
            System.out.println("غلطططططط "); // yoooooooooour code
         }
         }
        catch(NullPointerException e){
                 Alerts.showErrorAlert("برجاءالتأكد من  ملىء جميع الحقول المطلوبة");
                 }
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
        x.loadwindow(Financial_Reports, "/Manager/Main/Home.fxml");
    }

    @FXML
    private void Back(ActionEvent event) {
         x.loadwindow(Financial_Reports, "/Manager/Reports/Reports.fxml");
    }
    

/*******************************************************Reports Methods****************************************************/





    private void invoices(String startDate ,String endDate) throws FileNotFoundException, DocumentException{
        String qu="SELECT * FROM sales Right JOIN bills ON sales.sale_id=bills.sale_id   ";
        ResultSet rs=DatabaseHandler.getInstance().execQuery(qu);
                
        
         /**********Create Document******************/
        Document document =new Document(PageSize.A4); 
        System.out.println("Document Created");
        /***********Method to calculate Date******/
             Date date=new Date();
            SimpleDateFormat ft = 
            new SimpleDateFormat (" yyyy.MM.dd ");
            
        /***************The Name of Pdf************/
         try {
         
             PdfWriter.getInstance(document, new FileOutputStream("الفواتير"+ft.format(date)+".pdf"));
         } catch (DocumentException ex) {
             Logger.getLogger(Financial_ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }
        System.out.println("Writrer insrance Created");
        document.open();  // Open the document to append in it .
        System.out.println("Document Opened");
        /************Title of Document*************/
      
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        
        PdfPTable t = new PdfPTable(1);
         PdfPCell cell = new PdfPCell();
        Paragraph p=new Paragraph("فواتير اليوم", normal);
        p.setAlignment(PdfPCell.ALIGN_CENTER);
        cell.addElement(p);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setRunDirection(RUN_DIRECTION_RTL); //To Make arabic works well
        t.addCell(cell);
        document.add(t);
        
       /************Date  of Document*************/
        preface.add(new Paragraph(
                "" + ft.format(date),normal));
                
        addEmptyLine(preface, 1); //add line space
        preface.add("----------------------------------------------------------------------------------------------------------------------------------");
        addEmptyLine(preface, 2);
        document.add(preface);   // Add paragraph of name preface to document
        
        
        
        /************************Start of content*********/
 
        /*****Creat table has 4 column*******/
        PdfPTable table = new PdfPTable(6);
        table.setRunDirection(RUN_DIRECTION_RTL);//To Make arabic works well
          preface.add("----------------------------------------------------------------------------------------------------------------------------------");
 addEmptyLine(preface, 2);
        PdfPTable table2 = new PdfPTable(1);
        table.setRunDirection(RUN_DIRECTION_RTL);//To Make arabic works well
        
          /***Header of table*****/
        PdfPCell c1 = new PdfPCell(new Phrase("الاسم",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setRunDirection(RUN_DIRECTION_RTL);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("السعر",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("الكمية",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("نوع الكمية",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("التكلفة",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("تسلسل ",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        table.setHeaderRows(1);
        
        /***********retrive data from database and but them in cells***************/
        try {
            int x=1;
            
            while(rs.next()  ){
               double y=rs.getDouble("sale_id"); 
                if (y==x){
                String x1=rs.getString("product_name");        
                double x2=rs.getDouble("unit_price");
                int x3=rs.getInt("current_qty");
                String x4=rs.getString("qty_kind");
                double x5=rs.getDouble("cost");
                double x6=rs.getDouble("sale_id");
                
                System.out.println(x1+"  "+x2+" "+x3+"  "+x4+"  "+x5);
                //cell 1
                c1 = new PdfPCell(new Phrase(x1,normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setRunDirection(RUN_DIRECTION_RTL);
                table.addCell(c1);
                //cell 2
                c1 = new PdfPCell(new Phrase(String.valueOf(x2),normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
               //cell 3
                c1 = new PdfPCell(new Phrase(String.valueOf(x3),normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                //cell 4
                 c1 = new PdfPCell(new Phrase(x4,normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setRunDirection(RUN_DIRECTION_RTL);
                table.addCell(c1);
                  //cell 5
                c1 = new PdfPCell(new Phrase(String.valueOf(x5),normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                    //cell 5
                c1 = new PdfPCell(new Phrase(String.valueOf(x6),normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
              // Add table to document
              document.add(table);
              y++;
                }
            
//            addEmptyLine(preface, 2);
//            preface.add("-------------------------------------");
//            x++;
            }
            
 
            /////////////////ِTo show that pdf is printed///////////////
            Alert AT=new Alert(Alert.AlertType.INFORMATION);
            AT.setHeaderText(null);
            AT.setContentText("تمت طباعة التقرير");
            AT.showAndWait();
            
                   } catch(Exception e){
            System.out.println(e);
        }
        // close document
        document.close();
        System.out.println("Document Closed");


    }
    
    
    
    
    
    /**********************************************************************Expenses*****************************************************************/
    
    
    //String startDate ,String endDate,String name
    private void expences() throws FileNotFoundException, DocumentException{
        String qu="SELECT * FROM expenses Right OUTER JOIN buy_bills on  expenses.tab=buy_bills.tab ";  
        ResultSet rs=DatabaseHandler.getInstance().execQuery(qu);
                
        
         /**********Create Document******************/
        Document document =new Document(PageSize.A4); 
        System.out.println("Document Created");
        /***********Method to calculate Date******/
             Date date=new Date();
            SimpleDateFormat ft = 
            new SimpleDateFormat (" yyyy.MM.dd ");
            
        /***************The Name of Pdf************/
         try {
         
             PdfWriter.getInstance(document, new FileOutputStream("أجر الموظف"+ft.format(date)+".pdf"));
         } catch (DocumentException ex) {
             Logger.getLogger(Financial_ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }
        System.out.println("Writrer insrance Created");
        document.open();  // Open the document to append in it .
        System.out.println("Document Opened");
        /************Title of Document*************/
      
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        
        PdfPTable t = new PdfPTable(1);
         PdfPCell cell = new PdfPCell();
        Paragraph p=new Paragraph("أجر الموظف", normal);
        p.setAlignment(PdfPCell.ALIGN_CENTER);
        cell.addElement(p);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setRunDirection(RUN_DIRECTION_RTL); //To Make arabic works well
        t.addCell(cell);
        document.add(t);
        
       /************Date  of Document*************/
        preface.add(new Paragraph(
                "" + ft.format(date),normal));
                
        addEmptyLine(preface, 1); //add line space
        preface.add("----------------------------------------------------------------------------------------------------------------------------------");
        addEmptyLine(preface, 2);
        document.add(preface);   // Add paragraph of name preface to document
        
        
        
        /************************Start of content*********/
 
        /*****Creat table has 4 column*******/
        PdfPTable table = new PdfPTable(5);
        table.setRunDirection(RUN_DIRECTION_RTL);//To Make arabic works well
        
          /***Header of table*****/
        PdfPCell c1 = new PdfPCell(new Phrase("مصاريف المحل",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setRunDirection(RUN_DIRECTION_RTL);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("مصاريف الشراء",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
//        c1 = new PdfPCell(new Phrase("الأجر ",normal));
//        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c1);
//        c1 = new PdfPCell(new Phrase("المصاريف ",normal));
//        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c1);
//        c1 = new PdfPCell(new Phrase("صافي المرتب ",normal));
//        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c1);
//        
        table.setHeaderRows(1);
        
        /***********retrive data from database and but them in cells***************/
        try {
            
            double z=0,y=0;
            while(rs.next()){
          
                double x1 =rs.getDouble("e_cost");
                double x2 =rs.getDouble("total_price");
                 z=z+x1;
                 y=y+x2;
                 System.out.println(x1+"  "+x2);
                }
            
                 
                
                
               
                //cell 2
                c1 = new PdfPCell(new Phrase(String.valueOf(z),normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setRunDirection(RUN_DIRECTION_RTL);
                table.addCell(c1);
                 //cell 2
                c1 = new PdfPCell(new Phrase(String.valueOf(y),normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setRunDirection(RUN_DIRECTION_RTL);
                table.addCell(c1);
                
                
                
            
            // Add table to document
            document.add(table);
 
            /////////////////ِTo show that pdf is printed///////////////
            Alert AT=new Alert(Alert.AlertType.INFORMATION);
            AT.setHeaderText(null);
            AT.setContentText("تمت طباعة التقرير");
            AT.showAndWait();
            
                   } catch(Exception e){
            System.out.println(e);
        }
        // close document
        document.close();
        System.out.println("Document Closed");


    }

    
    
    
    
    
    
    
    
    
    
    
    
    /**************************  addEmptyLine method to make an Empty line in document*************/
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    
    
    
    
    

    }
