package atguigu.java2;

/**
 * 线程通信的应用 生产者消费者
 * @author xjm
 * @create 2022/6/14-22:56
 */
class Cleck{

    private int productCount = 0;
    //生产产品
    public synchronized void produceProduct() {
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个产品");

            notify();
        }else {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount + "个产品");
            productCount--;

            notify();
        }else {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{

    private Cleck cleck;

    public Producer(Cleck cleck) {
        this.cleck = cleck;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产产品。。。");

        while (true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cleck.produceProduct();
        }
    }
}

class Consumer extends Thread{
    private Cleck cleck;

    public Consumer(Cleck cleck) {
        this.cleck = cleck;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费产品。。。");

        while (true){

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cleck.consumeProduct();
        }

    }
}

public class ProductTest {
    public static void main(String[] args) {
        Cleck cleck = new Cleck();

        Producer p1 = new Producer(cleck);
        p1.setName("生产者1");
        
       Consumer c1 = new Consumer(cleck);
       c1.setName("消费者1");

       p1.start();
       c1.start();
    }
}
