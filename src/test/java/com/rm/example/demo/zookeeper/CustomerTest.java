package com.rm.example.demo.zookeeper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/28
 */
public class CustomerTest {
    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer(300);
            Thread thread = new Thread(customer);
            thread.start();
        }
    }
}