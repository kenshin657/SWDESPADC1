package designchallenge1.observer;

import designchallenge1.Event;
import facebook.FBView;
import java.awt.Color;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

import java.util.List;

public class FacebookUpdate implements Observer {
    FBView fb = new FBView();
    int notifonce =0;
    public void update(List<Event> event) {

        Color eventcolor;
        LocalDateTime today;
        today= LocalDateTime.now();

        int i;
        for (i = 0; i < event.size(); i++) {
            if (event.get(i).getnYear() == 9999) {
                if (event.get(i).getnMonth() == today.getMonthValue() && event.get(i).getnDay() == today.getDayOfMonth()) {


                    try {
                        Field field = Class.forName("java.awt.Color").getField(event.get(i).getTextColor());
                        eventcolor = (Color)field.get(null);
                    } catch (Exception e) {
                        eventcolor = null;
                    }
                    fb.showNewEvent(event.get(i).getEventName(), event.get(i).getnMonth(), event.get(i).getnDay(), today.getYear(), eventcolor);
                    setNotifOnce();
                }
                }else  if (event.get(i).getnMonth() == today.getMonthValue() && event.get(i).getnYear() == today.getYear() && event.get(i).getnDay() == today.getDayOfMonth()) {


                try {
                    Field field = Class.forName("java.awt.Color").getField(event.get(i).getTextColor());
                    eventcolor = (Color)field.get(null);
                } catch (Exception e) {
                   eventcolor = null;
                }
                    System.out.print("Correct");
                fb.showNewEvent(event.get(i).getEventName(), event.get(i).getnMonth(), event.get(i).getnDay(), event.get(i).getnYear(), eventcolor);
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
