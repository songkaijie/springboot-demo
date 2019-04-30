package com.rm.example.demo.zookeeper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author: Song Kaijie
 * @Date: 2019/4/28
 */

@RunWith(SpringRunner.class) // 等价于使用 @RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerTest {
    @Test
    public void test() throws InterruptedException {
        Customer customer = new Customer(10);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(customer);
            thread.start();
        }
        Thread.sleep(100000);
    }
}