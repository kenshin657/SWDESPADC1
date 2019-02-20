package designchallenge1;
import designchallenge1.Event;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVSave {

    public void saveEvent(List<Event> event){

            PrintWriter fileWriter= null;

        try{
           fileWriter = new PrintWriter(new File("CalendarEvent.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        int i =0;
        for(i=0; i<event.size(); i++) {

            fileWriter.append(event.get(i).getnMonth() + "/");
            fileWriter.append(event.get(i).getnDay() + "/");
            fileWriter.append(event.get(i).getnYear() + ", ");
            fileWriter.append(event.get(i).getEventName() + ", ");

            fileWriter.append(event.get(i).getTextColor());
            fileWriter.append("\r\n");



        }
        fileWriter.flush();
        fileWriter.close();
    }
}
