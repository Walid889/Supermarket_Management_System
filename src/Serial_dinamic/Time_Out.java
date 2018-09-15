/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serial_dinamic;

import java.util.Calendar;

/**
 *
 * @author Walid
 */
public class Time_Out {
    
    public int getHoursUntilTarget() {
        int targetHour=2;
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY); //21.....>> 22
        return hour < targetHour ? targetHour - hour : targetHour - hour + 24;      // 4
    } 
    
}
