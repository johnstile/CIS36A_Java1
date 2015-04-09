
package observerPattern;

import java.util.Random;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Observable;

public class RandomWalker extends Observable {
    
    private Random r = new Random();
    private Timer t = new Timer();
    /*
     *  sleepTime is in milliseconds (thousands of a second)
     */
    public void start(int repetitions) {
        for (int i=0; i<repetitions; i++) {
            walk();
            try {
                Thread.sleep(50);     // this waits 50/1000 of a second before repeating
            } catch (InterruptedException ex) {
                System.out.println("Got interrupted before the time was up!");
            }
        }
    }
    
    private void walk() {
    	this.setChanged();
        if (r.nextBoolean()) {
            // walk left
        	notifyObservers(new Integer( -1 ) );
        } else {
            // walk right
        	notifyObservers( new Integer( 1 ) );
        }
    }

}
