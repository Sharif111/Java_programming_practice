package schedulermain;

import duplicatearrayfind.CallingJar;
import java.io.IOException;
import java.util.Timer;

public class SchedulerMain {

    public static void main(String args[]) throws InterruptedException, IOException {

        Timer time = new Timer();
        ScheduledTask st = new ScheduledTask();
        time.schedule(st, 0, 1000);
        //1000*60*1(For 1 min)

        //for demo only.
        for (int i = 1; i > 0; i++) {
            System.out.println("Execution in Main Thread...." + i);
            Thread.sleep(1000);
            // CallingJar callingJar = new CallingJar();
            // int calculate = callingJar.calculate(5, 10);
            //System.out.println("calculate = " + calculate);
            if (i == 0) {
                System.out.println("Application Terminates");
                System.exit(0);
            }
        }
    }

}
