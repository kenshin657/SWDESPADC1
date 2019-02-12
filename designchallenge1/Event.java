package designchallenge1;

public class Event {
    private String date;
    private String eventName;
    private String textColor;
    private int nMonth;
    private int nYear;
    private int nDay;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

        String[] sepDate = date.split("/");
        this.nMonth = Integer.parseInt(sepDate[0]);
        this.nDay = Integer.parseInt(sepDate[1]);
        this.nYear = Integer.parseInt(sepDate[2]);
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public int getnMonth() {
        return nMonth;
    }

    public int getnYear() {
        return nYear;
    }

    public int getnDay() {
        return nDay;
    }
}
