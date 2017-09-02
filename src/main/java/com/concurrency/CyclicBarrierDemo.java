package com.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        final CyclicBarrier cb = new CyclicBarrier(3);
        for (int i=0;i<3;i++){
            final int user = i+1;
            Runnable r = new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep((long) Math.random()*1000);
                        System.out.println("用户["+user+"]到达聚餐点，当前已有"+(cb.getNumberWaiting()+1)+"人到达");
                        cb.await();
                        System.out.println("人员全部到齐，开始吃饭");
                        Thread.sleep((long) Math.random()*1000);

                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
        }
    }
}
