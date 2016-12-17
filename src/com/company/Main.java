package com.company;

public class Main {

    public static void main(String[] args) {
        Thread thred1 = new Thread(new MyThread("red"));
        Thread thread2 = new Thread(new MyThread("yellow"));
        Thread thread3 = new Thread(new MyThread("green"));
            thred1.start();
            thread2.start();
            thread3.start();
    }
}
