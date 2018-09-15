/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serial_dinamic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Walid
 */
public class Serial_B extends NewSerial{
    Timer timer;
    public Serial_B(int Hours) {
        timer = new Timer();
        timer.schedule(new RemindTask2(), Hours*60*60*1000);
	}
    
    class RemindTask2 extends TimerTask {
        public void run() {
            setBuyingSerial(1);
            rep_buying();
            timer.cancel(); //Terminate the timer thread
        }
    }
    
        private void rep_buying(){
        try {
            Thread.sleep(24*60*60*1000);
            setBuyingSerial(1);
            Thread.sleep(24*60*60*1000);
            setBuyingSerial(1);
            Thread.sleep(24*60*60*1000);
            setBuyingSerial(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Serial_S.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
