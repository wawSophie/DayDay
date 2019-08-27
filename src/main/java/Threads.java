/**
 * Author:Sophie
 * Created: 2019/8/19
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 实现多线程的方式
 */
public class Threads {
    public static void main(String[] args) {
        FutureTask<Integer> task=new FutureTask<Integer>(new Thread3());
        new Thread(task).start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Runnable runnable=new Thread2();
        new Thread(runnable).start();

        Thread thread=new Thread1();
        thread.start();
    }
}
class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("这是继承了Thread的线程");
    }
}
class Thread2 implements Runnable{

    public void run() {
        System.out.println("这是实现了Runnable的线程");
    }
}
class Thread3 implements Callable{

    public Object call() throws Exception {
        System.out.println("这是实现了Callable的线程");
        return 1;
    }

}
