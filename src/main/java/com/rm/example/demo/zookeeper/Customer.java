package com.rm.example.demo.zookeeper;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/28
 */
public class Customer implements Runnable {
    private int number;

    public Customer(int number) {
        this.number = number;
    }

    public synchronized void buy() {
        if (number > 0) {
            System.out.println("**************卖出了" + this.number + "号商品***************");
            number--;
            System.out.println("================" + Thread.currentThread().getName() + "买了" + (this.number + 1) + "号商品===============");
            System.out.println("*********商品的数量还剩" + this.number + "个****************");
        }
    }

    @Override
    public void run() {
        while (true) {
            DistributedLock lock = null;
            try {
                lock = new DistributedLock("172.20.10.5:2181,172.20.10.6:2181,172.20.10.10:2181", "test");
                lock.lock();
                if (this.number > 0) {
                    buy();
                } else {
                    System.out.println("==================" + Thread.currentThread().getName() + "商品卖完了============");
                    break;
                }
            } finally {
                if (lock != null) {
                    lock.unlock();
                }
            }
        }
    }
}
