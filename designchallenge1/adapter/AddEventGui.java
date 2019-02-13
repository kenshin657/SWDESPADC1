package designchallenge1.adapter;

import designchallenge1.CalendarProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class AddEventGui {
    private JPanel panel;
    private JTextField eventNameTxtField;
    private JComboBox Month;
    private JComboBox Year;
    private JComboBox Day;
    private JLabel Color;
    private JComboBox colorChooser;
    private JButton addEventButton;
    private JCheckBox yearlyCheckBox;

    GregorianCalendar calendar = new GregorianCalendar();

    public JPanel getPanel() {
        return panel;
    }


    public AddEventGui(CalendarProgram cp) {
        int yearBound = calendar.get(GregorianCalendar.YEAR);
        int mounthBound = calendar.get(GregorianCalendar.MONTH);
        int dayBound = calendar.get(GregorianCalendar.DAY_OF_MONTH);

        for(int i = yearBound-100; i<=yearBound+100;i++)
            Year.addItem(i);

        for (int i = 1; i <= 31; i++)
            Day.addItem(i);

        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEventCal eventCal = new AddEventCal();
                cp.addEventList(eventCal.addEvent(eventNameTxtField.getText(),Integer.parseInt(Month.getSelectedItem().toString()),
                        Integer.parseInt(Day.getSelectedItem().toString()),Integer.parseInt(Year.getSelectedItem().toString()),colorChooser.getSelectedItem().toString()));

            }
        });
    }

    }

