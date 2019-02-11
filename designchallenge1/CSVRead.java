package designchallenge1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVRead extends FileRead {

    @Override
    public void getFilePath() {
        super.getFilePath();
    }

    @Override
    List<Event> fileLoad() {
        System.out.println(super.filePath + "\n\n\n");

        Scanner sc = new Scanner(System.in);

        String csvFile = super.filePath;

        BufferedReader br = null;
        String line = "";
        String csvSplit =", ";

        List<Event> eventList = new ArrayList<Event>(); //events received from csv file

        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();

            while ((line = br.readLine()) != null) {
                Event eventInfo = new Event();

                String[] event = line.split(csvSplit);

                eventInfo.setDate(event[0]);
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
        
        return null;
    }
}
