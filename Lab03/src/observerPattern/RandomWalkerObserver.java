package observerPattern;

import java.util.Observable;
import java.util.Observer;

public class RandomWalkerObserver implements Observer {
    private Integer  steps = 0;
    private Integer  spaces = 0;
	@Override
	public void update(Observable arg0, Object arg1) {
		steps++; 
		spaces +=  (int)arg1 ;
		String direction = ( spaces == 0 ) ? "where they started": (spaces > 0 ) ?  (spaces + " spaces to the right" ) : (Math.abs(spaces) + " spaces to the left"); 
		
		// Every multiple of 10 spaces print a message
		if ( (spaces%10) == 0 ){
            System.out.println("The walker reached " +  direction  + " after " +steps + "  steps.");
		}
	}

}
