<<<<<<< HEAD
package model;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDisplay {
    private long createdMillis;

   public TimerDisplay(){
       createdMillis = System.currentTimeMillis();
    }

    public int getCountDownSeconds() { //counts down 3 seconds before game starts
        long nowMillis=System.currentTimeMillis();
        return 3-(int) ((nowMillis - this.createdMillis) / 1000);

    }

    public int getElapsedTime() { //counts time when game is started

        long nowMillis = System.currentTimeMillis();
        return (int) ((nowMillis - this.createdMillis) / 1000);
    }
}
/*
Start the timer
Show time in action (sec)
Return the time elapsed in total
Return the countdown time
 */
=======
package model;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDisplay {
    private long createdMillis;

   public TimerDisplay(){
       createdMillis = System.currentTimeMillis();
    }

    public int getCountDownSeconds() { //counts down 3 seconds before game starts
        long nowMillis=System.currentTimeMillis();
        return 3-(int) ((nowMillis - this.createdMillis) / 1000);

    }

    public int getElapsedTime() { //counts time when game is started

        long nowMillis = System.currentTimeMillis();
        return (int) ((nowMillis - this.createdMillis) / 1000);
    }
}
/*
Start the timer
Show time in action (sec)
Return the time elapsed in total
Return the countdown time
 */
>>>>>>> de77b63f8efce10dd1e2a6689b8f03c8e3e5a713
