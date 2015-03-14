package Lab1;
/*
 * By: John Stile
 * Assignment: Lab1 (part A)
 */
public class Nametag {
	public static void main (String[] args)
	{
		int total_chars = 80;
		/*
		 * First line 8 chars
		 */
		print_hash(78); 
		print_return();
		/*
		 * Second line 
		 */
		print_hash(3); 
		print_space(26); 
		System.out.print("ANNUAL CONFERENCE"); //$NON-NLS-1$
		print_space(26);
		print_hash(3);
		print_return();
		/*
		 * Third line (same as first)
		 */
		print_hash(78); 
		print_return();
		/*
		 * Fourth line
		 */
		print_hash(3);
		print_space(2);
		System.out.print("NAME:"); //$NON-NLS-1$
		print_space(62);
		print_hash(3);
		print_return();
		/*
		 * Fifth line
		 */
		print_hash(3);
		print_space(70);
		print_hash(3);
		print_return();
        /*
         * Sixth line (same as first)
         */
		print_hash(78); 
		print_return();
		/*
		 * Seventh line
		 */
		print_hash(3);
		print_space(2);
		System.out.print("ORGANIZATION:"); //$NON-NLS-1$
		print_space(54);
		print_hash(3);
		print_return();
		/*
		 * Eighth line (same as fifth line)
		 */
		print_hash(3);
		print_space(70);
		print_hash(3);
		print_return();
		/*
		 * Ninth line (Same as first line)
		 */
		print_hash(78); 
		print_return();
	}
	/*
	 * Takes the number of '#' to print
	 */
	public static void print_hash(int x){
		for(int y = 0; y <= x; y++){
			System.out.print("#"); //$NON-NLS-1$
		}
	}
	/*
	 * Takes the number of ' ' to print
	 */
	public static void print_space(int x){
		for(int y = 0; y <= x; y++){
		    System.out.print(' '); //$NON-NLS-1$
		}
	}
	/*
	 * Add new line
	 */
	public static void print_return(){
		System.out.println();
	}
}
