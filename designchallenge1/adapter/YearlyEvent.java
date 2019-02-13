package designchallenge1.adapter;

import designchallenge1.Event;

import java.util.ArrayList;
import java.util.List;

public class YearlyEvent {

    public Event addYearly(String name, int month, int day, int year, String color) {
        Event e = new Event();
        e.setEventName(name);
        e.setnMonth(month);
        e.setnDay(day);
        e.setnYear(9999);
        e.setTextColor(color);

        return e;
    }
}
