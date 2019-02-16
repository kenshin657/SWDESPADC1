package designchallenge1.template;

import designchallenge1.Event;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVPhilippineHoliday extends  FileRead {
    @Override
    public void getFilePath() {
        super.getFilePath();
    }

    @Override
    List<Event> fileLoad() {
        System.out.println(super.filePath + "\n\n\n");

        String csvFile = super.filePath;

        BufferedReader br = null;
        String line = "";
        String csvSplit =", ";

        List<Event> eventList = new ArrayList<Event>(); //events received from csv file

        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                Event eventInfo = new Event();

                String[] event = line.split(csvSplit);
                String date = event[0];
                String[] sepDate = date.split("/");
                eventInfo.setnMonth(Integer.parseInt(sepDate[0]));
                eventInfo.setnDay(Integer.parseInt(sepDate[1]));
                eventInfo.setnYear(9999);
                //eventInfo.setDate(event[0]);
                eventInfo.setEventName(event[1]);
                eventInfo.setTextColor(event[2]);

                eventList.add(eventInfo);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return eventList;
    }
}
