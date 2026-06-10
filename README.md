# personal-reminder

Personal Reminder Program

LAST UPDATED: 1/14/2026

//Note to self: may need to revise this

1) *****PROJECT OVERVIEW*****

Title: Personal Reminder Program


Description: The purpose of this program is very simple, it's just like 
a reminder app except you can't miss it because the reminder will pop up 
in front of your screen!

Purpose: The purpose of this program is for people to get reminders that pop up
on their screen so that they can't miss them. Although other reminder apps do
exist, this program is more "in-your-face," which makes it impossible not
to miss the reminder. Sometimes, you may have a reminder on your phone but you
can sometimes miss it or be a distraction having it nearby, which is
where this program can be better to use. For example, listening to music
while working on the computer can sometimes make it easier to miss a reminder
on a phone, so the pop-up reminder is helpful here.


This is better for scheduling nearby tasks because this program can only 
schedule reminders up to tomorrow, also turning off the computer can affect
the reminder and lead to them getting out late. Therefore, it's best to use
this program if you often have things that you have to remember doing on the
day and if you're on the computer often.

The Problem Solved: 
A big problem that this problem solves is that people don't have to use their
phones to schedule imminent reminders. The problem with using phone is that it
can be a distraction if you are working on the computer. You can also
potentially miss the reminder because you might not always notice the notification,
especially if you're listening to music. With this program, you don't have to
worry about missing your reminders!


Target Audience:
This program is mainly for people who might be working or using a computer. 
In particular, the program is best for people who might have various things 
they must remember to do for the day while also working on/using the computer;
college students would benefit a lot for that reason.







2) *****HOW TO USE THIS PROGRAM*****
To start, you must go to the Main.java and make sure this code is active:

	Remind_function startProgram = new Remind_function();
	startProgram.remindProgram();
	
Additionally, make sure no other code after is active, which in this case is
code used for testing. The program asks the user to write their reminder, set
the hour and minute, and then the time abbrevation (either AM or PM).

If the reminder doesn't seem to show up, you may have to minimize the window to
find it or you just have to rerun the program.


IMPORTANT: When setting your time, make sure the time adheres to the 12-hour 
system and don't include spaces because the program is space-sensitive.
Format for the time -> (start)HOUR:MINUTE(end)

Finally, beware that turning off the computer can potentially delay the reminder,
so please be aware of that!





3) *****TECHNICAL DETAILS (For the developer(s))*****

In addition to this README text file, comments can also help assess with
navigating through the code.

METHODS/CLASSES USED IN THE PROGRAM:
The program is run through the Reminder_function.java class, here is the format:



<-----START OF CLASS----->

	private String setToTomorrow(Calendar date, int day) {
		date.set(Calendar.DAY_OF_YEAR, day+1);
		return "tomorrow";
	}
	
DESCRIPTION: As implied, the method will set the date to tomorrow if necessary,	
but it also returns tomorrow because we want the message to say that the
reminder is being scheduled to tomorrow instead of today.

	
	private enum timeAbbrevation {
		AM(0),
		PM(1);
		
		private final int timeAbbVal;
		
		private timeAbbrevation(int timeAbbVal) {
			this.timeAbbVal = timeAbbVal;
		}
	}
DESCRIPTION: AM and PM values are based on their value in the Calendar class.
The enum is primarily used for better code readability.
	
	public void remindProgram() {
	//insert code here
	}
DESCRIPTION: This is where the code starts. There are comments that should
help with navigating a bit. This is where the program asks you to write your
reminder and set the time as well as the time abbrevation, plus the reminder
gets scheduled there. Once the time for the reminder is reached, the run() 
method, which can be found between input dialog #1 and #2 will execute and
your reminder ends up popping up on the screen.


<-----END OF CLASS----->

ConsoleColors.java class
This class is only used for the testing class SimulateTime for better readability.
You can safely ignore this class, it's mostly trivial.




EXCEPTION HANDLING:
The program only throws exceptions for two reasons:
1) The user doesn't enter any time, leading to NumberFormatException

2) The user's time has an incorrect format or has space(s), which causes
IndexOutOfBoundsException. The split method is used to split to hour and minute
to schedule, so good formatting is key here.



-Other actions might not necessarily cause errors, but it will terminate 
the program:

1) Entering an empty reminder, pretty self-explainatory why the program won't
accept this
2) Entering a time that doesn't adhere to the 12 hour system, although 22:57
is an acceptable time (meaning 10:57PM), in this program, it won't be accepted
3) Exiting out the app at any point, like pressing cancel or the X button



4) *****CONCLUSION*****
This program is a reminder app that sends reminders by popping up on the screen.
Generally recommended for people who often work on the computer and have things
they have to remember to do for the day; college students would fit well in this
category.

This can be better than a phone because phones can be a distraction but also
sometimes easy to miss, especially if you're playing music in the background.
For those reasons, this program is good for mitigating distractions while making
sure that you aren't missing your reminders. However, you should note that if
the computer does turn off, it may delay your reminder and when it pops up is
a bit unpredictable. You should be fine if the computer screen is only off.

Final note: AS LONG AS THE COMPUTER ITSELF REMAINS ON AND YOU DON'T EXIT THE IDE, 
THE PROGRAM SHOULD EXECUTE
AS EXPECTED!
