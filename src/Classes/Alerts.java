/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Walid
 */
public class Alerts extends Throwable{
    public static void showInfoAlert(String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("رسالة تأكيد");
        alert.setContentText(content);
        alert.showAndWait();
        return;
    }
    public static void showErrorAlert(String content){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطأ");
            alert.setContentText(content);
            Thread thread = new Thread(() -> {
            try {
                // Wait for 5 secs
                Thread.sleep(1400);
                if (alert.isShowing()) {
                    Platform.runLater(() -> alert.close());
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        Optional<ButtonType> result = alert.showAndWait(); 
        alert.setTitle("خطأ");
        alert.setHeaderText(null);
        alert.setContentText(content);
        
       ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/icons/supermarket.png"));
        alert.showAndWait();
        return;
    }
    public static boolean ConfirmAlert(String content,String Choise){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("إنتبه");
        //alert.setResult(ButtonType.CANCEL);
        alert.setContentText(content+Choise);
        Optional<ButtonType> answer = alert.showAndWait();
        return answer.get() == ButtonType.OK;
    }
    public static void showWorningAlert(String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("رسالة تأكيد");
        alert.setContentText(content);
        alert.showAndWait();
        
    }
    
//    Alert alert = new Alert(Alert.AlertType.NONE);
//            alert.setTitle("خطأ");
//            alert.setContentText("لم يتم ادخال بيانات الفاتورة بشكل صحيح!!");
//            alert.setHeaderText(null);
//            alert.setResult(ButtonType.CLOSE);
//            alert.show();
//            PauseTransition delay = new PauseTransition(javafx.util.Duration.seconds(1.5));
//            delay.setOnFinished( event -> alert.close() );
//            delay.play();
}
/*
    private void deleteAllRows(){
        Sales S=new Sales();
        if(AllCheckbox.isSelected()){
            billTabel.setFocusTraversable(true);
            if(Alerts.ConfirmAlert("هل تريد مسح جميع عناصر الجدول ؟","")){
                boolean result=DataHelper.deleteAllRowsInSalesTV(S);
                if(result){
                    billTabel.getItems().clear();
                    Alerts.showInfoAlert("تم مسح جميع العناصر");
                }
                else
                    Alerts.showErrorAlert("لم يتم المسح");
            }
        }
        else{
            Alerts.showErrorAlert("اضغط على مربع "+" \"الكل\" "+"لتتم عملية مسح جميع العناصر");
        }
        
    }
*/

/*
public static boolean deleteAllRowsInSalesTV(int serial) {
        String qu = "DELETE FROM sales WHERE sale_id ="+serial+""; //
        if(DatabaseHandler.getInstance().execAction(qu)){
            return true;
        }
        return false;
    }

*/