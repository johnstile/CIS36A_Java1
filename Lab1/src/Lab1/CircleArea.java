package Lab1;
/*
 * By: John Stile <john@stilen.com>
 * Assignment: Lab1 (part A)
 */

import java.util.Scanner;


public class CircleArea {
	
	public static void main (String[] args)
	{
		
		/*
		 * Prompt user for input
		 */
		System.out.print("Please enter radius: ");
		/*
		 * Loop designed to break when we have a valid number
		 */
		float r = 0; // set default to zero
		boolean valid_radius = false;
		while( !valid_radius ){
			Scanner s = new Scanner(System.in);
			/*
			 * Wait for an int
			 */
			while (!s.hasNextFloat()){
				s.next();
			}
			r = s.nextFloat();
			/*
			 * Validate
			 */
			if (r > 0){
				valid_radius = true;
			}
	    } // Exit while loop, we have good radius
		System.out.println("radius:" + r );
		/*
		 * Print area and circumference of circle
		 */
		System.out.println(
		    "With a radius of " + r + " a circle will have " +
		    "area:" + area(r)
		    + " and " +
		    "circumference:" + circumference(r) 
		);
		/*
		 * Print volume and surface area of a sphere with that radious
		 */
		System.out.println(
		    "With a radius of " + r + " a sphere will have "
		    + "volume:" + volume(r)
		    + " and "
		    + "surface area:" + surface_area(r)
		);
		return;
	}
	public static double circumference(float r){
		double c = 0;
		c = 2 * Math.PI * r;
		return r;
	}
	public static double area(float r){
		double a = 0;
		a = Math.PI * ( r * r );
		return a;
	}
	public static double volume(float r){
		double v = 0;
		v = ( 4 * Math.PI * (r*r*r) ) / 3;
		return v;
	}
	public static double surface_area( float r){
		double sa = 0;
		sa = 4 * Math.PI * ( r * r );
		return sa;
	}
}
