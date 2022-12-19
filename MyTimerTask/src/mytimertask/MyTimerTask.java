package mytimertask;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;


public class MyTimerTask extends TimerTask {
private final static long ONCE_PER_DAY = 1000*60*60*24;

    //private final static int ONE_DAY = 1;
    private final static int TEN_AM = 10;
    private final static int ZERO_MINUTES = 0;


    @Override
    public void run() {
        long currennTime = System.currentTimeMillis();
        long stopTime = currennTime +1000*60*60*2;//provide the 2hrs time it should execute 1000*60*60*2
          while(stopTime != System.currentTimeMillis()){
              // Do your Job Here
            System.out.println("Start Job at everday at 10 am");
            System.out.println("End Job"+System.currentTimeMillis());
          }
    }
    private static Date getTomorrowMorning2AM(){

        Date date10am = new java.util.Date(); 
           date10am.setHours(TEN_AM); 
           date10am.setMinutes(ZERO_MINUTES); 

           return date10am;
      }
    //call this method from your servlet init method
    public static void startTask(){
        MyTimerTask task = new MyTimerTask();
        Timer timer = new Timer();  
        timer.schedule(task,getTomorrowMorning2AM(),1000*60*60*24);// for your case u need to give 1000*60*60*24
    }
    public static void main(String args[]){
        startTask();

    }
    
}
