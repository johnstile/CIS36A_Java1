package Lab1;
/*
 * By: John Stile <john@stilen.com>
 * Assignment: Lab1 (part A)
 */
import java.util.Scanner;

public class DateConverter {

    // Asks user for a integer between 1 and 366, a day number in a leap year
    //  (a year with 29 days in February, such as 2016).
    // Prints the date in month/day format.
    // Example: 
    //   if the user enters 365, this should print 12/30
    //
    // Fill in missing code where indicated (***), although perhaps not in every spot
    public static void main(String[] args) {
        int dayOfYear = 0;
        System.out.print(Messages.getString("DateConverter.Promp_Input_String")); //$NON-NLS-1$

        // *** store user entry in dayOfYear;
        boolean valid_days = false;
        while( !valid_days ){
			Scanner s = new Scanner(System.in);
			/*
			 * Wait for an int
			 */
			while (!s.hasNextInt()){
				s.next();
			}
			dayOfYear = s.nextInt();
			/*
			 * Validate
			 */
			if (dayOfYear > 0){
				valid_days = true;
			} else {
				System.out.print( Messages.getString("DateConverter.Prompt_ReInput_String") ); //$NON-NLS-1$
			}
        }
        /*
         * 
         */
        convertDayOfYear(dayOfYear);
    }

    public static void convertDayOfYear(int dayOfYear) {
        int month, dateInMonth, daysInMonth;
        month = 1;
        daysInMonth = 31;

        while (dayOfYear > daysInMonth) {
            
        	// *** Here is one possible place to put assignment statements.
        	dayOfYear -= daysInMonth;  	
        	month++;
        	
        	// returns days of the month or -1... 
        	daysInMonth = daysInMonth(month);  
        	
            // *** Here is another possible place to put assignment statements
        }

        dateInMonth = dayOfYear;
        System.out.println(month + Messages.getString("DateConverter.Delimiter_Month_Day") + dateInMonth); //$NON-NLS-1$
    }

    // *** change this to a switch statement...
    /*
     * Returns the number of days in a given month
     * Returns -1 if invalid month given
     */
    public static int daysInMonth(int month) {
        /*
        if (month == 2) {
            return 29;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
        */
    	int days = 0;
        switch(month)
        {
        	// Feb is special in Leap Year
        	case 2: 
        		days = 29;
        		break;
        	// April, June, Sept, Nov have 30 days
        	case 4:
        	case 6:
        	case 9:
        	case 11:
        		days = 30;
        		break;
        	case 1:
        	case 3:
        	case 5:
        	case 7:
        	case 8:
        	case 10:
        	case 12:
        		days = 30;
        		break;
        	default:
        		days = -1;
        }
        return days;
    }
}


