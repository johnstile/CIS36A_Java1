/*
 Draw this:
	*
	**
	***
	****
	*****
	******
	*******
	********
	*********
	**********
*/
public class Triangle {
	public static void main ( String[] args){
		triangle_while();
		triangle_for();
		System.exit(0);  // break out of the program
	}
	public static void triangle_while()
	{
        int row = 0;
        int SIZE = 10;
        
        // Print 10 rows of starts
        while (row < SIZE) {
        	
        	// Each round make row a little bigger
        	row = row + 1;
        	
        	// Each round start from column zero
        	int col = 0;
        	
        	// Print same number of columns as we have rows
        	while ( col < row  ){
        		
        		// print star, no carriage return
        		System.out.print ("*" );
        		
        		// add one more star 
        		col = col + 1;
        		
        	} // end row loop 
        	
        	// This starts the next row.
        	System.out.println ();
        	
        } // end column loop 
	}	
	public static void triangle_for()
	{
		int row = 0;
		int SIZE = 10;
		while ( row < SIZE)
		{
			for ( int col=0; col <= row; col++ )
			{
				System.out.print("*");
			}
			System.out.println();
			row++;
		}
	}

}
