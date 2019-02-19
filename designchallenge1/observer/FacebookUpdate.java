package designchallenge1.observer;

import designchallenge1.Event;
import facebook.FBView;
import java.awt.Color;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

import java.util.List;

public class FacebookUpdate implements Observer {
    FBView fb = new FBView();
    public void update(List<Event> event) {

        LocalDateTime today;
        today= LocalDateTime.now();

        int i;
        for (i = 0; i < event.size(); i++) {
            if (event.get(i).getnMonth() == today.getMonthValue() && event.get(i).getnYear() == today.getYear() && event.get(i).getnDay() == today.getDayOfMonth()) {
                Color eventcolor;
                try {
                    Field field = Class.forName("java.awt.Color").getField(event.get(i).getTextColor());
                    eventcolor = (Color)field.get(null);
                } catch (Exception e) {
                   eventcolor = null; // Not defined
                }
                    System.out.print("Correct");
                fb.showNewEvent(event.get(i).getEventName(), event.get(i).getnMonth(), event.get(i).getnDay(), event.get(i).getnYear(), eventcolor);
            }
        }
    }
}
