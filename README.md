Personal Reminder Program

LAST UPDATED: 7/13/2026


1) *****PROJECT OVERVIEW*****

Title: Personal Reminder Program

Note: this is my first complete programming project, so it may be rough around the edges.

---------------------------------------------------------------------------------------------------

Description: The purpose of this program is very simple, it's just like 
a reminder app that you have on your phone. Basically, the reminder will pop up 
on your screen, making it hard to miss!

Purpose: The purpose of this program is to help people remember to do short-term tasks. 
Although other reminder apps do exist, this program is more "in-your-face," as it can
take up a decent chunk of the screen. Some people may use their phone for reminders, but you
can sometimes miss it or end up being distracted by the phone. For example, if you're listening to 
music while working on the computer, you can potentially miss the reminder that you put on the phone
nearby. 


This program is mainly suited for scheduling nearby tasks because you can only schedule
the reminder up to tomorrow. You also have to make sure the computer doesn't turn off or else the
reminder can be very delayed. Also, closing the IDE will deactivate the program and the reminder is lost.
Therefore, it's best to use this program if you have tasks that you have to do soon.

---------------------------------------------------------------------------------------------------

The Problem Solved: 
A big problem that this problem solves is that people don't have to use their
phones to schedule reminders. Not only can you potentially miss the phone reminders, but
the phone can be a source of distraction. With this program, you don't have to
worry about missing your reminders or getting distracted!


Target Audience:
This program is mainly for people who are working on a computer since the program requires an
IDE to be in the background. In particular, students could benefit from this because they
can do work and then have reminders to help them remember to do other tasks.


---------------------------------------------------------------------------------------------------

For users:

2) *****HOW TO USE THIS PROGRAM*****
To start, you must go to the Main.java and make sure to have this code in the main method:

	ReminderProgramClass reminder = new ReminderProgramClass();
	reminder.startProgram();
	
If the reminder doesn't seem to show up immediately, you either have to minimize all windows
or rerun the program if the first option doesn't work.


IMPORTANT: 
If you're someone who is accustomed to the 24-hour system, you may have to adjust a bit for this
program. When setting your time, make sure the time adheres to the 12-hour 
system and type the time using this format without spaces:

HOUR:MINUTE

Finally, please note that turning off the computer can potentially delay the reminder, sometimes
causing the reminder to pop up very late.

---------------------------------------------------------------------------------------------------

Not for users

3) *****TECHNICAL DETAILS*****

In addition to this README text file, comments can also help assess with
navigating through the code.

METHODS/CLASSES USED IN THE PROGRAM:
The program functions using the ReminderProgramClass, here is the class layout:


	private String setToTomorrow(Calendar date, int day) {
		date.set(Calendar.DAY_OF_YEAR, day+1);
		return "tomorrow";
	}
	
DESCRIPTION: As implied, the method will set the date to tomorrow if necessary,	
but it also returns tomorrow because we want the message to say that the
reminder is being scheduled to tomorrow instead of today.


	
	public void startProgram() {
	//insert code here
	}
	
DESCRIPTION: This is where the code starts. There are comments that should
help with navigating a bit. This is where the program asks you to write your
reminder, set the time, and choose the time abbrevation. 




After that, the reminder will be scheduled and, once the reminder's time is reached, the run() 
method will execute, which can be found between input dialog #1 and #2.

	Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			//Once the reminder time is reached, this is reached
			public void run() {
				frame.setVisible(true);
				System.out.println("Here's your reminder: " + userReminder);
			}	
		};


ConsoleColors.java class
This class is mainly only used for improved readability.


---------------------------------------------------------------------------------------------------


EXCEPTION HANDLING:
The program will throw an exception because of these two reasons:
1) The user doesn't enter any time, leading to NumberFormatException

```
    catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, 
			"Please enter a time for the reminder.",
			"Error Message",
			JOptionPane.WARNING_MESSAGE);
			System.out.println("Please enter a time for the reminder.");
			System.exit(0);
	}
```
	


2) The user's time has an incorrect format or has space(s), which causes
IndexOutOfBoundsException. The split method is used to split to hour and minute
to schedule, so good formatting is key here.

		catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, 
			"Please type the time with the correct format.",
			"Error Message",
			JOptionPane.WARNING_MESSAGE);
			System.out.println("Please type the time with the correct format.");
			System.exit(0);
		}



-Other actions might not necessarily cause errors, but they will also terminate 
the program:

1) Entering an empty reminder
2) Entering a time that doesn't adhere to the 12 hour system, although 22:57
is an acceptable time (meaning 10:57PM), in this program, it won't be accepted
3) Exiting out the app at any point, like pressing cancel or the X button

---------------------------------------------------------------------------------------------------

4) *****CONCLUSION*****

This program is a reminder app that sends reminders by having the reminders pop up on the screen.
This is generally recommended for people who often work on the computer and have things
they have to remember to do for the day. For example, college students would fit well in this
category.

This can be better than a phone because phones can be a distraction, and you can sometimes not
notice the phone's reminders. For these reasons, this program is good for mitigating distractions 
while making sure that you aren't missing your reminders. However, you should note that if
the computer does turn off, it may delay your reminder, and the time delayed is unclear. 
However, you should be fine if the computer screen is off rather than the computer itself.

Final note: As long as you don't turn off the computer or leave the IDE, the program should
execute as intended.
