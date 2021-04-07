package demo3;

public class MyThread implements Runnable{

    private int ticket = 10;

    @Override
    public void run() {
        while (true) {
            if (ticket <= 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售卖的是第" + ticket-- + "张票");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread,"用户1").start();
        new Thread(myThread,"用户2").start();
        new Thread(myThread,"用户3").start();

    }
}
