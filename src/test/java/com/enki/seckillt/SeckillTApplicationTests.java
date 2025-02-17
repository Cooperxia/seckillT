package com.enki.seckillt;

import com.enki.seckillt.annotations.Limit;
import com.enki.seckillt.annotations.LimitType;
import org.joda.time.LocalTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
class SeckillTApplicationTests {

    @Test
    void contextLoads() {
        long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
    }
    private static final AtomicInteger ATOMIC_INTEGER_1 = new AtomicInteger();
    @Test
    @Limit(key = "customer_limit_test", period = 10, count = 3, limitType = LimitType.CUSTOMER)
    @GetMapping("/limitTest2")
    public int testLimiter2() {
        return ATOMIC_INTEGER_1.incrementAndGet();
    }
}
