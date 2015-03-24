
package observerPattern;

import java.util.Observable;
import java.util.Observer;

public class Runner {
    
    public static void main(String[] args) {
        RandomWalker  rw = new RandomWalker();
        Observer rwo = new RandomWalkerObserver();
        rw.addObserver(rwo);
        //System.out.println( rw.countObservers() );
        //rw.hasChanged()
        rw.start(1000);
    }
            
}
