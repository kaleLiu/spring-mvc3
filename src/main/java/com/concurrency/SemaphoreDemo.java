package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public class SemaphoreRunnable implements Runnable{

        private Semaphore semaphore;

        private int user;

        public SemaphoreRunnable(Semaphore semaphore,int user){
             this.semaphore = semaphore;
             this.user = user;
        }
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("用户["+user+"]进入窗口准备买票");
                Thread.sleep((long) Math.random()*1000);
                System.out.println("用户["+user+"]买票完成，准备离开");
                Thread.sleep((long) Math.random()*1000);
                System.out.println("用户["+user+"]离开售票窗口");
                semaphore.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void execute(){
       final Semaphore semaphore = new Semaphore(2);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0;i<20;i++){
            threadPool.execute(new SemaphoreRunnable(semaphore,i));
        }
        threadPool.shutdown();
    }

    public static void main(String[] args) {
        SemaphoreDemo sd = new SemaphoreDemo();
        sd.execute();
    }
}
