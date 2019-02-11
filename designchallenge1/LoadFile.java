package designchallenge1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFile {
    private JButton loadCSVButton;
    private JButton loadPDFButton;
    private JPanel frmLoadFile;

    public JPanel getFrmLoadFile() {
        return frmLoadFile;
    }

    public LoadFile() {


        loadCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CSVRead csvRead = new CSVRead();
                csvRead.fileLoad();
            }
        });
        loadPDFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PDFRead pdfRead = new PDFRead();
                pdfRead.fileLoad();
            }
        });
    }
}
