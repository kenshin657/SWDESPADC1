package designchallenge1.adapter;

import designchallenge1.Event;

public class YearlyAdapter implements AddEvent {
    @Override
    public Event addEvent(String name, int month, int day, int year, String color) {
        return new YearlyEvent().addYearly(name,month,day,year,color);
    }
}
