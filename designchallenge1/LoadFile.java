package designchallenge1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFile{
    private JButton loadCSVButton;
    private JButton loadPSFButton;
    private JPanel frmLoadFile;

    public JPanel getFrmLoadFile() {
        return frmLoadFile;
    }

    public LoadFile(CalendarProgram cp) {


        loadCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CSVRead csvRead = new CSVRead();
                csvRead.getFilePath();
                cp.setEventList(csvRead.fileLoad());
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
