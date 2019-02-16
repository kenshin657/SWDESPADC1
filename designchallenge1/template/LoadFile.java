package designchallenge1.template;

import designchallenge1.CalendarProgram;
import designchallenge1.template.CSVRead;
import designchallenge1.template.PSFRead;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFile{
    private JButton loadCSVButton;
    private JButton loadPSFButton;
    private JPanel frmLoadFile;
    private JCheckBox holidayCSVCheckBox;

    public JPanel getFrmLoadFile() {
        return frmLoadFile;
    }

    public LoadFile(CalendarProgram cp) {


        loadCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CSVRead csvRead = new CSVRead();
                CSVPhilippineHoliday csvPhilippineHoliday = new CSVPhilippineHoliday();
                if(holidayCSVCheckBox.isSelected()) {
                    csvPhilippineHoliday.getFilePath();
                    cp.setEventList(csvPhilippineHoliday.fileLoad());
                }
                else {
                    csvRead.getFilePath();
                    cp.setEventList(csvRead.fileLoad());
                }
            }
        });
        loadPSFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PSFRead psfRead = new PSFRead();
                psfRead.getFilePath();
                cp.setEventList(psfRead.fileLoad());
            }
        });
    }
}
