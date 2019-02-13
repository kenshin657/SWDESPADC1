package designchallenge1.template;

import designchallenge1.Event;
import designchallenge1.template.FileRead;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PSFRead extends FileRead {

    @Override
    public void getFilePath() {
        super.getFilePath();
    }

    @Override
    List<Event> fileLoad() {
        System.out.println(super.filePath + "\n\n\n");

        String psvFile = super.filePath;

        BufferedReader br = null;
        String line = "";
        String psvSplit = "[|]";

        List<Event> eventList = new ArrayList<Event>(); //events received from psv file

        try {
            br = new BufferedReader(new FileReader(psvFile));

            while ((line = br.readLine()) != null) {
                Event eventInfo = new Event();

                String[] event = line.split(psvSplit);

                eventInfo.setEventName(event[0]);
                eventInfo.setDate(event[1]);
                eventInfo.setTextColor(event[2].trim());

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
