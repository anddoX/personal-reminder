import java.awt.Font;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class ReminderProgramClass {
	
	private String setToTomorrow(Calendar date, int day) {
		date.set(Calendar.DAY_OF_YEAR, day+1);
		return "tomorrow"; //sets the variable to tomorrow for printing
	}
		
	public void startProgram() {
		
		/*The code from the frame to text area are all for the frame that 
		pops up when it's time for the reminder to pop up*/
		JFrame frame = new JFrame();
		frame.setSize(600,600);
		frame.setResizable(false);
		frame.setTitle("REMINDER");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.getContentPane().add(scrollPane);
		textArea.setFont(new Font("Work Sans", Font.PLAIN, 20));
		
		
		
		//When the program starts running
		System.out.println(ConsoleColors.TEXT_GREEN + "If you don't see the reminder prompt immediately, "
		+ "wait for a moment or restart the program.\nYou can also try removing all windows."
		+ ConsoleColors.TEXT_RESET);
		System.out.println("------");
		
		//*****Input dialog #1*****
		String userReminder = JOptionPane.showInputDialog(
		null,
		"Type your reminder",
		"Add Reminder",
		JOptionPane.INFORMATION_MESSAGE
		);
		
		/*For each dialog, the user can press close or cancel to
		 * terminate this program
		 */
		if (userReminder == null) {
			System.out.println("Program terminated.");
			System.exit(0);
		}
		
		//This code is to prevent users from entering reminders without any text
		if (userReminder.length() == 0) {
			JOptionPane.showMessageDialog(null, 
			"A reminder cannot be empty. Try again!",
			"Error Message",
			JOptionPane.WARNING_MESSAGE);
			System.out.println("A reminder cannot be empty. Try again!");
			System.exit(0);
		}
		
		
			

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			//Once the reminder time is reached, this is reached
			public void run() {
				frame.setVisible(true);
				System.out.println("Here's your reminder: " + userReminder);
			}	
		};
		
		String userTimeInput = "";
		int userHourInput = 0;
		int userMinuteInput = 0;
		
		try {
			//*****Input dialog #2*****
			userTimeInput = JOptionPane.showInputDialog(
			null,
			"Set the time using format → hour:minute "
			+ "\nDon't include spaces and use 12-hour system",
			"Set Time for Reminder",
			JOptionPane.INFORMATION_MESSAGE);
			
			if (userTimeInput == null) {
				System.out.println("Program terminated.");
				System.exit(0);
			}
			
			String[] getTimeComponents = userTimeInput.split(":");
			userHourInput = Integer.parseInt(getTimeComponents[0]);
			userMinuteInput = Integer.parseInt(getTimeComponents[1]);
		}
		
		/*Exception caused by bad formatting with the time, e.g. 5:
		 * By default the format must be hour:minute, no spaces too*/
		catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, 
			"Please type the time with the correct format.",
			"Error Message",
			JOptionPane.WARNING_MESSAGE);
			System.out.println("Please type the time with the correct format.");
			System.exit(0);
		}
		//Exception caused by not entering a time
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, 
			"Please enter a time for the reminder.",
			"Error Message",
			JOptionPane.WARNING_MESSAGE);
			System.out.println("Please enter a time for the reminder.");
			System.exit(0);
		}
		
		//The time must adhere to the 12 hour system
		if (userMinuteInput >= 60 || userHourInput > 12 || userMinuteInput < 0 || 
		userHourInput < 0) {
			JOptionPane.showMessageDialog(null, 
			"Please enter a valid time! Program doesn't support 24 hour system.",
			"Error Message",
			JOptionPane.WARNING_MESSAGE);
			System.out.println("This program doesn't support time of the 24 hour system.");
			System.exit(0);
		}
		
		
		//*****Input dialog #3*****
		String[] timeAbbrevationButtons = {"AM", "PM"};
		String printTimeAbbrevation = "";
		
		int AM = 0;
		int PM = 1;
		
		int setTimeAbbrevation = JOptionPane.showOptionDialog( null,
	            "Choose between AM or PM.",
	            "Choose Time Abbrevation",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.INFORMATION_MESSAGE,
	            null,
	            timeAbbrevationButtons,
	            timeAbbrevationButtons[0]);
		
		/*Note that setTimeAbbrevation equals its enum value here
		AM = 0 & PM = 1*/
		switch(setTimeAbbrevation) {
			case 0: 		
			printTimeAbbrevation = "AM";
			break;
			
			case 1:
			printTimeAbbrevation = "PM";
			break;
			
			default:
			System.out.println("Program terminated.");
			System.exit(0);
			break;
		}
						
	
/*The current time will be compared to the reminder time, to determine whether
the reminder should be scheduled today or tomorrow*/
		Calendar date = Calendar.getInstance();
		int day = date.get(Calendar.DAY_OF_YEAR);
		int currentHour = date.get(Calendar.HOUR);
		int currentMinute = date.get(Calendar.MINUTE);
		int currentTimeAbbrevation = date.get(Calendar.AM_PM);
		
		
		String printedDay = "today"; 
		boolean isTimeAbbSame = (setTimeAbbrevation == currentTimeAbbrevation);
		
		//Must be set to 0, this equates to 12'o clock in the calendar class
		if (userHourInput == 12) {
			userHourInput = 0;
		}
		
		
		/*Case 1: if the reminder hour already passed, must have
		same time abbrevation as well as case 2*/
		if (userHourInput < currentHour && (isTimeAbbSame)) {
			//Info on the method is found at beginning of class
			printedDay = setToTomorrow(date, day);
		}
		
		/*Case 2: if the hours are the same, but the reminder minute has either
		passed or is equal to current minute*/
		else if ((userHourInput == currentHour) && (userMinuteInput <= currentMinute)
		&& (isTimeAbbSame)) {
			printedDay = setToTomorrow(date, day);
		}
		
		/*Final case: If the current time is in PM and the user 
		 * wishes to set a reminder in AM.*/
		else if (setTimeAbbrevation == AM && currentTimeAbbrevation == PM) {
			printedDay = setToTomorrow(date, day);
		}
		
		
		
		/*After scheduling a reminder, a message pops up with info on the reminder,
		this code follows last*/	
		String printMinute = Integer.toString(userMinuteInput);	
		String printHour = Integer.toString(userHourInput);
			
			
			if (userMinuteInput < 10) {
				printMinute = "0" + printMinute;
			}
			
			if (userHourInput == 0) {
				printHour = "12";
			}
			

		JOptionPane.showMessageDialog(null,"Reminder is set to " + 
		printHour + ":" + printMinute + printTimeAbbrevation
		+ " " + printedDay + ". Please keep this program open to receive the reminder.");
		System.out.println("REMINDER: " + userReminder + " | " + printHour + ":" 
		+ printMinute + printTimeAbbrevation);
		textArea.setText("REMINDER: " + userReminder + " at " + printHour + ":" + printMinute + printTimeAbbrevation);	
		
		//Now the actual reminder gets scheduled here
		date.set(Calendar.AM_PM, setTimeAbbrevation);
		date.set(Calendar.HOUR, userHourInput);
		date.set(Calendar.MINUTE,userMinuteInput); 
		date.set(Calendar.SECOND, 0);
		System.out.println("PRECISE TIME: " + date.getTime());
		timer.schedule(task, date.getTime());
	}
}
