package reminderProgramPackage;
public class SimulateTimeForTesting {
	
	private enum timeAbbrevation {
		AM(0),
		PM(1);
		
		private final int timeAbbVal;
		
		private timeAbbrevation(int timeAbbVal) {
			this.timeAbbVal = timeAbbVal;
		}
	}
	
	
	private int currentHour;
	private int currentMinute;
	private int currentAbbrevation;
	private final int AM;
	private final int PM;
	private static int testCaseNumber;
	
	public SimulateTimeForTesting(int currentHour, int currentMinute, int currentAbbrevation) {
		AM = timeAbbrevation.AM.timeAbbVal;
		PM = timeAbbrevation.PM.timeAbbVal;
		
		if (!isTimeValid(currentHour, currentMinute, currentAbbrevation)) {
			System.out.println(ConsoleColors.TEXT_RED + "Time is not valid. "
			+ "Can't use this for testing!" + ConsoleColors.TEXT_RESET);
			System.out.print("The time: ");
			printTime(currentHour, currentMinute, currentAbbrevation);
		}
		
		else {
			
			testCaseNumber++; //This should increase for each new instance
			System.out.println(ConsoleColors.TEXT_GREEN + "Test case #" + testCaseNumber + ":"
			+ ConsoleColors.TEXT_RESET);
			
			this.currentHour = currentHour;
			this.currentMinute = currentMinute;
			this.currentAbbrevation = currentAbbrevation;
			
			System.out.print("The current time is ");
			printTime(currentHour, currentMinute, currentAbbrevation);
			
			if (currentHour == 12) {
				this.currentHour = 0;
			}
		}
	}
	
	public int getCurrentHour() {
		return currentHour;
	}
	
	public int getCurrentMinute() {
		return currentMinute;
	}
	
	public int getCurrentAbbrevation() {
		return currentAbbrevation;
	}
	
	private boolean isTimeValid(int hour, int minute, int timeAbb) {
		
		//Fix this test time abbrevation please
		if (timeAbb > PM || timeAbb < AM) {
			return false;
		}
		
		else if (hour > 12 || hour < 1) {
			return false;
		}
		
		else if (minute > 59 || minute < 0) {
			return false;
		}
		
		return true;
	}
	
	private void setToTomorrow() {
		System.out.println("The reminder should be sent tomorrow.");
		System.out.println("------------------------------");
	}
	
	private void printTime(int hour, int minute, int timeAbb) {
		String printAbbrevation = "";
		String printMinute = minute + "";
		
		if (minute < 10) {
			printMinute = "0" + minute;
		}
		
		if (timeAbb == AM) {
			printAbbrevation = "AM";
		}
		
		else if (timeAbb == PM) {
			printAbbrevation = "PM";
		}
		
		else {
			printAbbrevation = "N/A";
		}
		
		System.out.println(hour + ":" + printMinute + printAbbrevation);
		
		
	}
		
	public void ReminderTime(int hourToConvert, int reminderMinute, int reminderTimeAbb) {

		int reminderHour = hourToConvert;
		
		if (hourToConvert == 12) {
			reminderHour = 0;
		}
		
		if (!isTimeValid(reminderHour, reminderMinute, reminderTimeAbb)) {
			System.out.println(ConsoleColors.TEXT_RED + "Time is not valid. "
			+ "Can't use this for testing!" + ConsoleColors.TEXT_RESET);
			System.out.print("The time: ");
			printTime(reminderHour, reminderMinute, reminderTimeAbb);
		}
		
		else {
			
			System.out.print("The reminder is set to ");
			printTime(reminderHour, reminderMinute, reminderTimeAbb);

			
			boolean isTimeAbbSame = (reminderTimeAbb == currentAbbrevation);
			
			
			if (reminderHour < currentHour && (isTimeAbbSame)) {
				setToTomorrow();
			}
			

			else if ((reminderHour == currentHour) && (reminderMinute <= currentMinute)
		    && (isTimeAbbSame)) {
				setToTomorrow();
			}
			
			else if (reminderTimeAbb == AM && currentAbbrevation == PM) {
				setToTomorrow();
			}
						
			else {
				System.out.println("The reminder should be sent today.");
				System.out.println("------------------------------");
			}
		}
	}
 }
