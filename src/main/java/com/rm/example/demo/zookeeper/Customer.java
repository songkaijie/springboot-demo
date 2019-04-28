package com.rm.example.demo.zookeeper;

import org.apache.tomcat.util.net.NioBlockingSelector;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/28
 */
public class Customer implements Runnable {
    private int number;

    public Customer(int number) {
        this.number = number;
    }

    public void buy() {
        System.out.println("商品的数量还剩" + --this.number + "个");
    }

    @Override
    public void run() {
        DistributedLock lock = null;
        try {
            lock = new DistributedLock("172.20.10.5:2181,172.20.10.6:2181,172.20.10.10:2181", "test");
            lock.lock();
            buy();
            System.out.println(Thread.currentThread().getName() + "买了" + number + "号商品");
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
    }
}
