/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Products.Reports;

import Manager.Main.HomeController;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.itextpdf.text.pdf.PdfWriter.RUN_DIRECTION_RTL;
import database.DatabaseHandler;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lolo
 */



public class Products_ReportsController implements Initializable {
     HomeController x = new HomeController();
    @FXML
    private AnchorPane Product_Reports;
    @FXML
    private Label Products;

    
    
    private static String FILE = "c:/temp/FirstPdf.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    public static Font normal=FontFactory.getFont("C:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, 14, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
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
    private void Damadge_Reports(ActionEvent event) throws FileNotFoundException, DocumentException {
        
        checkDamaged();
    }

    @FXML
    private void Inventory_Reports(ActionEvent event) throws DocumentException {
         try {
             checkGoods();
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Products_ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
        x.loadwindow(Product_Reports, "/Manager/Main/Home.fxml");
    }

    @FXML
    private void Back(ActionEvent event) {
         x.loadwindow(Product_Reports, "/Manager/Reports/Reports.fxml");
    }
 
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    /*****************************************************Report Methods********************************************************/
    
    
    /***********************************************Goods Reports**************************************************************/
    
    private void checkGoods() throws FileNotFoundException, DocumentException{
        String qu="SELECT * FROM product";
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
         
             PdfWriter.getInstance(document, new FileOutputStream("جرد الاصناف "+ft.format(date)+".pdf"));
         } catch (DocumentException ex) {
             Logger.getLogger(Products_ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }
        System.out.println("Writrer insrance Created");
        document.open();  // Open the document to append in it .
        System.out.println("Document Opened");
        /************Title of Document*************/
      
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        
        PdfPTable t = new PdfPTable(1);
         PdfPCell cell = new PdfPCell();
        Paragraph p=new Paragraph("الجرد", normal);
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
        PdfPTable table = new PdfPTable(4);
        table.setRunDirection(RUN_DIRECTION_RTL);//To Make arabic works well
        
          /***Header of table*****/
        PdfPCell c1 = new PdfPCell(new Phrase("الاسم",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setRunDirection(RUN_DIRECTION_RTL);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("عدد الوحدات",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("عدد العلب",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("عدد الكراتين",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        
        /***********retrive data from database and but them in cells***************/
        try {
            while(rs.next()){
          
                String x1=rs.getString("pro_name");        
                int x2=rs.getInt("pro_qty_item");
                int x3=rs.getInt("pro_qty_packet");
                int x4=rs.getInt("pro_All_qty");
                System.out.println(x1+"  "+x2+"  "+x3+"  "+x4);
                //cell 1
                c1 = new PdfPCell(new Phrase(x1,normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setRunDirection(RUN_DIRECTION_RTL);
                table.addCell(c1);
                //cell 1
                c1 = new PdfPCell(new Phrase(String.valueOf(x2),normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                //cell 3
                c1 = new PdfPCell(new Phrase(String.valueOf(x3),normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                //cell 4
                c1 = new PdfPCell(new Phrase(String.valueOf(x4),normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
            }
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
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /******************************************* Damaged items Report******************************************************************/
    
    
    private void checkDamaged() throws FileNotFoundException, DocumentException{
        String qu="SELECT * FROM damages";
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
         
             PdfWriter.getInstance(document, new FileOutputStream("التوالف  "+ft.format(date)+".pdf"));
         } catch (DocumentException ex) {
             Logger.getLogger(Products_ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }
        System.out.println("Writrer insrance Created");
        document.open();  // Open the document to append in it .
        System.out.println("Document Opened");
        /************Title of Document*************/
      
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        
        PdfPTable t = new PdfPTable(1);
         PdfPCell cell = new PdfPCell();
        Paragraph p=new Paragraph("التوالف", normal);
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
        PdfPTable table = new PdfPTable(2);
        table.setRunDirection(RUN_DIRECTION_RTL);//To Make arabic works well
        
          /***Header of table*****/
        PdfPCell c1 = new PdfPCell(new Phrase("الاسم",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setRunDirection(RUN_DIRECTION_RTL);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("الكمية",normal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        table.setHeaderRows(1);
        
        /***********retrive data from database and but them in cells***************/
        try {
            while(rs.next()){
          
                String x1=rs.getString("product_name");        
                int x2=rs.getInt("current_qty");
                ;
                System.out.println(x1+"  "+x2);
                //cell 1
                c1 = new PdfPCell(new Phrase(x1,normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setRunDirection(RUN_DIRECTION_RTL);
                table.addCell(c1);
                //cell 2
                c1 = new PdfPCell(new Phrase(String.valueOf(x2),normal));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
               
            }
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
