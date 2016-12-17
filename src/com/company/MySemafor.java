package com.company;

import static java.lang.Thread.sleep;

/**
 * Created by liza on 16/12/2016.
 */
public class MySemafor implements Semafor {
    static int avaliablePermits;

    public MySemafor() {
        //First traffic light
//        avaliablePermits = 1;

        //Second traffic light
        avaliablePermits = 3;
    }

    @Override
    public synchronized void acquire(String threadColor) {

        if (getAvailablePermits() == 0) {
            try {
                System.out.println(threadColor + " entered in waited set");
                wait();
                System.out.println(threadColor + " went out from waited set");
            } catch (InterruptedException e) {
                System.out.println("Sleeping thread had been interrapted");
            }
        }
        avaliablePermits--;
        System.out.println("Switch color: " + threadColor);
        try {
            System.out.println(threadColor + " is working");
            sleep(3000);
            System.out.println(threadColor + " finished work");
        } catch (InterruptedException e) {
            System.out.println("Sleeping thread had been interrapted");
        }
    }

    @Override
    public synchronized void release() {
        avaliablePermits++;
        notify();
    }

    @Override
    public synchronized void acquire(int permits, String threadColor) {

        if (getAvailablePermits() == 0) {
            try {
                System.out.println(threadColor + " entered to waiting set");
                wait();
                System.out.println(threadColor + " went out from waiting set");
            } catch (InterruptedException e) {
                System.out.println("Sleeping thread had been interrapted");
            }
        }
        this.avaliablePermits -= permits;
        System.out.println("Switch color: " + threadColor);
        try {
            System.out.println(threadColor + " is working");
            sleep(3000);
            System.out.println(threadColor + " finished work");
        } catch (InterruptedException e) {
            System.out.println("Sleeping thread had been interrapted");
        }
    }


    @Override
    public synchronized void release(int permits) {
        this.avaliablePermits = permits;
        notifyAll();
    }

    @Override
    public int getAvailablePermits() {
        return avaliablePermits;
    }
}
