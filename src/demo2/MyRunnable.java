package demo2;

import demo1.MyThread;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            System.out.println("Runnable" + i);
        }
    }

    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        // Thread thread = new Thread(myRunnable);
        // thread.start();

        new Thread(myRunnable).start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("main" + i);
        }
    }
}
