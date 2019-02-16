/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

/**
 *
 * @author Arturo III
 */

import designchallenge1.adapter.AddEventGui;
import designchallenge1.template.LoadFile;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class CalendarProgram{
	
        /**** Day Components ****/
	public int yearBound, monthBound, dayBound, yearToday, monthToday;

        /**** Swing Components ****/
        public JLabel monthLabel, yearLabel;
	public JButton btnPrev, btnNext;
        public JComboBox cmbYear;
	public JFrame frmMain;
	public Container pane;
	public JScrollPane scrollCalendarTable;
	public JPanel calendarPanel;
	// savebutton
	public JButton btnAddEvent, btnLoadFiles, btnSave;



	/***EVENTS COMPONENTS****/
	private List<Event> eventList = new ArrayList<Event>();

        
        /**** Calendar Table Components ***/
	public JTable calendarTable;
        public DefaultTableModel modelCalendarTable;
        
        public void refreshCalendar(int month, int year)
        {
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nod, som, i, j;
			
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		if (month == 0 && year <= yearBound-10)
                    btnPrev.setEnabled(false);
		if (month == 11 && year >= yearBound+100)
                    btnNext.setEnabled(false);
                
		monthLabel.setText(months[month]);
		monthLabel.setBounds(320-monthLabel.getPreferredSize().width/2, 50, 360, 50);
                
		cmbYear.setSelectedItem(""+year);
		
		for (i = 0; i < 6; i++)
			for (j = 0; j < 7; j++)
				modelCalendarTable.setValueAt(null, i, j);
		
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);


		/*****Adds Events to the Calendar***/
		for (i = 1; i <= nod; i++)
                {
			int row = new Integer((i+som-2)/7);
			int column  =  (i+som-2)%7;
			modelCalendarTable.setValueAt(i, row, column);
        for (int x = 0; x < eventList.size(); x++) {
        	if(eventList.get(x).getnYear()== 9999) {
				if (eventList.get(x).getnMonth() - 1 == month && eventList.get(x).getnDay() == i) {


					String eventName;
					String day = Integer.toString(i);
					eventName = "<html><font color=\"" + eventList.get(x).getTextColor() + "\">" + day + "<br>" +
							eventList.get(x).getEventName() + "</font></html>";
					modelCalendarTable.setValueAt(eventName, row, column);
				}
			}
           else{
           	if(eventList.get(x).getnYear() == year && eventList.get(x).getnMonth()-1 == month && eventList.get(x).getnDay() == i) {
					String eventName;
					String day = Integer.toString(i);
					eventName = "<html><font color=\""+eventList.get(x).getTextColor()+"\">" + day +" " +
							eventList.get(x).getEventName()+ "</font></html>" ;
					modelCalendarTable.setValueAt(eventName, row, column);
				}
			}
        }

		}

		calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new TableRenderer());
	}
        
	public CalendarProgram()
        {
		try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
		catch (Exception e) {}
                
		frmMain = new JFrame ("Calendar Application");
                frmMain.setSize(660, 750);
		pane = frmMain.getContentPane();
		pane.setLayout(null);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//added code
			btnAddEvent = new JButton("Add Event");
			btnLoadFiles = new JButton("Load Files");
			btnSave = new JButton("Save Calendar");
		monthLabel = new JLabel ("January");
		yearLabel = new JLabel ("Change year:");
		cmbYear = new JComboBox();
		btnPrev = new JButton ("<<");
		btnNext = new JButton (">>");
		modelCalendarTable = new DefaultTableModel()
                {
                    public boolean isCellEditable(int rowIndex, int mColIndex)
                    {
                        return true;
                    }
                };
                
		calendarTable = new JTable(modelCalendarTable);
                calendarTable.addMouseListener(new MouseAdapter()   
                {  
                    public void mouseClicked(MouseEvent evt)  
                    {  
                        int col = calendarTable.getSelectedColumn();  
                        int row = calendarTable.getSelectedRow();  
                    }
                });
                
		scrollCalendarTable = new JScrollPane(calendarTable);
		calendarPanel = new JPanel(null);

		calendarPanel.setBorder(BorderFactory.createTitledBorder("Calendar"));
		
		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());

		/**added code**/
		btnLoadFiles.addActionListener(new loadFile_Action());
		btnAddEvent.addActionListener(new addEvent_Action());
		btnSave.addActionListener(new save_Action());
		pane.add(calendarPanel);
		calendarPanel.add(btnAddEvent);//added
		calendarPanel.add(btnLoadFiles);//added
			calendarPanel.add(btnSave);


		calendarPanel.add(monthLabel);
		calendarPanel.add(yearLabel);
		calendarPanel.add(cmbYear);
		calendarPanel.add(btnPrev);
		calendarPanel.add(btnNext);
		calendarPanel.add(scrollCalendarTable);
		
                calendarPanel.setBounds(0, 0, 640, 670);
                monthLabel.setBounds(320-monthLabel.getPreferredSize().width/2, 50, 200, 50);
		yearLabel.setBounds(20, 610, 160, 40);

		btnAddEvent.setBounds(20,635,100,20);
		btnLoadFiles.setBounds(20,655,100,20);
		btnSave.setBounds(150, 635, 150, 20);

		cmbYear.setBounds(460, 610, 160, 40);
		btnPrev.setBounds(20, 50, 100, 50);
		btnNext.setBounds(520, 50, 100, 50);
		scrollCalendarTable.setBounds(20, 100, 600, 500);
                
		frmMain.setResizable(false);
		frmMain.setVisible(true);
		
		GregorianCalendar cal = new GregorianCalendar();
		dayBound = cal.get(GregorianCalendar.DAY_OF_MONTH);
		monthBound = cal.get(GregorianCalendar.MONTH);
		yearBound = cal.get(GregorianCalendar.YEAR);
		monthToday = monthBound; 
		yearToday = yearBound;
		
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i=0; i<7; i++){
			modelCalendarTable.addColumn(headers[i]);
		}
		
		calendarTable.getParent().setBackground(calendarTable.getBackground()); //Set background

		calendarTable.getTableHeader().setResizingAllowed(false);
		calendarTable.getTableHeader().setReorderingAllowed(false);

		calendarTable.setColumnSelectionAllowed(true);
		calendarTable.setRowSelectionAllowed(true);
		calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		calendarTable.setRowHeight(76);
		modelCalendarTable.setColumnCount(7);
		modelCalendarTable.setRowCount(6);
		
		for (int i = yearBound-100; i <= yearBound+100; i++)
                {
			cmbYear.addItem(String.valueOf(i));
		}
		
		refreshCalendar (monthBound, yearBound); //Refresh calendar
	}
	

	class btnPrev_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
			if (monthToday == 0)
                        {
				monthToday = 11;
				yearToday -= 1;
			}
			else
                        {
				monthToday -= 1;
			}
			refreshCalendar(monthToday, yearToday);
		}
	}
	class btnNext_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
			if (monthToday == 11)
                        {
				monthToday = 0;
				yearToday += 1;
			}
			else
                        {
				monthToday += 1;
			}
			refreshCalendar(monthToday, yearToday);
		}
	}
	class cmbYear_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
			if (cmbYear.getSelectedItem() != null)
                        {
				String b = cmbYear.getSelectedItem().toString();
				yearToday = Integer.parseInt(b);
				refreshCalendar(monthToday, yearToday);
			}
		}
	}

	public class addEvent_Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame jFrame = new JFrame("Add Event");
			jFrame.setContentPane(new AddEventGui(CalendarProgram.this).getPanel());
			jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			jFrame.pack();
			jFrame.setLocationRelativeTo(null);
			jFrame.setVisible(true);

		}
	}

	public class loadFile_Action implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame jFrame = new JFrame("File Load");
			jFrame.setContentPane(new LoadFile(CalendarProgram.this).getFrmLoadFile());
			jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			jFrame.setSize(450,100);
			jFrame.setLocationRelativeTo(null);
			jFrame.setVisible(true);
		}
	}


	public class save_Action implements ActionListener{


        @Override

			public void actionPerformed(ActionEvent e) {
        		CSVSave savefile= new CSVSave();

					savefile.saveEvent(eventList);
				}
			}

	public void setEventList(List<Event> e) {
                this.eventList.addAll(e);
    }




    public void addEventList(Event e) {
        	/*if (e.getnYear() == 9999)
        		for(int i = 1919; i <= 2119; i++) {
        			Event event = new Event();
        			event.setEventName(e.getEventName());
        			event.setnMonth(e.getnMonth());
        			event.setnDay(e.getnDay());
        			event.setnYear(i);
        			event.setTextColor(e.getTextColor());

        			this.eventList.add(event);
				}
        	else*/
        	this.eventList.add(e);




	}

}
