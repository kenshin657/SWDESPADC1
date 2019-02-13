package designchallenge1.adapter;

import designchallenge1.Event;

public class AddEventCal implements AddEvent {

    @Override
    public Event addEvent(String name, int month, int day, int year, String color) {
        Event event = new Event();
        event.setEventName(name);
        event.setTextColor(color);
        event.setnYear(year);
        event.setnDay(day);
        event.setnMonth(month);

        return event;
    }
}
