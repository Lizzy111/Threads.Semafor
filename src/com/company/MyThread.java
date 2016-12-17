package com.company;


/**
 * Created by liza on 17/12/2016.
 */
public class MyThread implements Runnable {
    static MySemafor semafor = new MySemafor();
    static MySemafor semafor2 = new MySemafor();
    String threadColor;

    public MyThread(String threadColor) {
        this.threadColor = threadColor;
    }

    @Override
    public void run() {
        // First Traffic Light
//        semafor.acquire(threadColor);
//        System.out.println(threadColor + " woke some thread");
//        semafor.release();

        // Second Traffic Light
        semafor2.acquire(3, threadColor);
        System.out.println(threadColor + " woke up all threads");
        semafor2.release(3);

    }
}
