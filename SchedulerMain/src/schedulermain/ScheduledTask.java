package schedulermain;

import java.util.Date;
import java.util.TimerTask;

public class ScheduledTask  extends TimerTask {
    
        Date now;
	public void run() {
		now = new Date(); // initialize date
		System.out.println("Time is :" + now); // Display current time
	}
    
}
