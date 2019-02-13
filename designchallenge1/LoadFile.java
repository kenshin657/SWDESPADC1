package designchallenge1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFile extends CalendarProgram{
    private JButton loadCSVButton;
    private JButton loadPSFButton;
    private JPanel frmLoadFile;

    public JPanel getFrmLoadFile() {
        return frmLoadFile;
    }

    public LoadFile() {


        loadCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CSVRead csvRead = new CSVRead();
                csvRead.getFilePath();
                setEventList(csvRead.fileLoad());
            }
        });
        loadPSFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PSFRead psfRead = new PSFRead();
                psfRead.getFilePath();
                setEventList(psfRead.fileLoad());
            }
        });
    }
}
