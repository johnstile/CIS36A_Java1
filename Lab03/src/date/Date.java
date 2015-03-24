package date;

public class Date implements Comparable<Date> {
	private int month;
	private int day;
	/*
	 * Constructor that takes 2 int First represents month Second represents day
	 */
	public Date(int m, int d) {
		month = m;
		day = d;
	}

	/*
	 * toString is needed for printing the date
	 */
	public String toString() {
		String month_day_string;
		month_day_string = month + "/" + day;
		return month_day_string;
	}
	/*
	 * Implement the Comparable interface
	 */
	@Override
	public int compareTo(Date o) {
		int return_int = 0;
		// this will be negative, zero, or positive
		int month_comp = this.getMonth() - o.getMonth();
		int day_comp = this.getDay() - o.getDay();
		/*
		 * if months are equal, compare days
		 */
		return_int = ( month_comp != 0 ) ? month_comp : day_comp;
		return  return_int;
	}

	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
}
