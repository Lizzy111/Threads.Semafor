package com.company;

/**
 * Created by liza on 16/12/2016.
 */
 public interface Semafor {
    public void acquire(String color);

    public void acquire(int permits, String color);

    public void release();

    public void release(int permits);

    public int getAvailablePermits();
}
