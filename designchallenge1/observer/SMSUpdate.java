package designchallenge1.observer;
import designchallenge1.Event;
import sms.SMS;
import sms.SMSView;
import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Calendar;

import java.time.LocalDateTime;

import java.util.List;
public class SMSUpdate implements Observer {

        SMSView smsview = new SMSView();
    public void update(List<Event> event) {
        LocalDateTime today;
        today= LocalDateTime.now();
        int i;
        for (i = 0; i < event.size(); i++) {
            if (event.get(i).getnMonth() == today.getMonthValue() && event.get(i).getnYear() == today.getYear() && event.get(i).getnDay() == today.getDayOfMonth()) {

               // Calendar dateup;
                Color color;
                try {
                    Field field = Class.forName("java.awt.Color").getField(event.get(i).getTextColor());
                    color = (Color)field.get(null);
                } catch (Exception e) {
                    color = null; // Not defined
                }
              ///  dateup.set(event.get(i).getnYear(), event.get(i).getnMonth(), event.get(i).getnDay());

                smsview.sendSMS(      new SMS(event.get(i).getEventName(), Calendar.getInstance(), color)   );

            }
        }
    }
}
