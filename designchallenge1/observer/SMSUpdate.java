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
        int notifonce= 0;
    public void update(List<Event> event) {
        LocalDateTime today;
        today= LocalDateTime.now();
        int i;

        Color color;
        for (i = 0; i < event.size(); i++) {


            if (event.get(i).getnYear() == 9999) {
                if (event.get(i).getnMonth() == today.getMonthValue() && event.get(i).getnDay() == today.getDayOfMonth()) {

                    try {
                        Field field = Class.forName("java.awt.Color").getField(event.get(i).getTextColor());
                        color = (Color)field.get(null);
                    } catch (Exception e) {
                        color = null;
                    }

                    smsview.sendSMS(      new SMS(event.get(i).getEventName(), Calendar.getInstance(), color)   );
                    setNotifOnce();
                }
            }
                    if (event.get(i).getnMonth() == today.getMonthValue() && event.get(i).getnYear() == today.getYear() && event.get(i).getnDay() == today.getDayOfMonth()) {



                try {
                    Field field = Class.forName("java.awt.Color").getField(event.get(i).getTextColor());
                    color = (Color)field.get(null);
                } catch (Exception e) {
                    color = null;
                }

                smsview.sendSMS(      new SMS(event.get(i).getEventName(), Calendar.getInstance(), color)   );
                setNotifOnce();

            }
        }
    }
    public void setNotifOnce(){
        notifonce = 1;
    }
    public int getNotifOnce(){
        return notifonce;
    }
}
