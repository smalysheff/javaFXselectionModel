package ru.smal;

import javafx.animation.Timeline;

import java.util.Timer;
import java.util.TimerTask;

public class MainConsole {
    public static void main(String[] args) {


        Timer timer = new Timer("Timer");

        TimerTask timerTask = new TimerTask() {
            int count = 15;
            @Override
            public void run() {

                System.out.printf("running %d\n", count--);
                if(count == 0){
                    System.out.println("stop");
                    timer.cancel();
                }
            }
        };

//        timer.schedule(timerTask, 0, 1000);

        timer.schedule(timerTask, 0, 1000);


    }
}
