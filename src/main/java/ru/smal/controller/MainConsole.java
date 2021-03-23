package ru.smal.controller;

import java.util.Timer;
import java.util.TimerTask;

public class MainConsole {
    public static void main(String[] args) {

        Timer timer = new Timer("Timer");

        TimerTask timerTask = new TimerTask() {
            int count = 1;
            @Override
            public void run() {

                System.out.printf("running %d\n", count++);
                if(count == 15){
                    System.out.println("it's work");
                    timer.cancel();
                }
            }
        };

//        timer.schedule(timerTask, 0, 1000);

        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
}
