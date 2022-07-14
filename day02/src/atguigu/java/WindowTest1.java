package atguigu.java;

/**
 * 例子：卖票，使用实现runnable接口的方式
 * 问题：卖票过程中，出现重票/错票；原因：当某个线程进行中，尚未操作完，其他线程也参与进来导致；
 * 解决方式：当一个线程在操作共享数据时，其他线程不能参与进来，直到本线程操作完，其他线程才能操作；
 * @author xjm
 * @create 2022/6/8-22:50
 */
class Window1 implements Runnable{

    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {

        while (true){
            synchronized (obj) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
