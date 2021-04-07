package demo1;

public class MyThread extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 2000; i++) {
            System.out.println("thread" + i);
        }
    }

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("main" + i);
        }
    }
}
