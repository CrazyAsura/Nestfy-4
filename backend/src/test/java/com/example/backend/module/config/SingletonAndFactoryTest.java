package com.example.backend.module.config;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.example.backend.module.domain.factory.OrderFactory;
import com.example.backend.module.domain.factory.ProductFactory;
import com.example.backend.module.domain.factory.UserFactory;
import com.example.backend.module.domain.models.Order;
import com.example.backend.module.domain.models.Product;
import com.example.backend.module.domain.models.User;

class SingletonAndFactoryTest {

    @Test
    void testSingletonRegistryConcurrentAccess() throws InterruptedException {
        int threadCount = 50;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch finishLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            executor.submit(() -> {
                try {
                    latch.await();
                    SingletonRegistry.put("key_" + index, "value_" + index);
                    SingletonRegistry.putIfAbsent("shared_key", "shared_value");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    finishLatch.countDown();
                }
            });
        }

        latch.countDown();
        boolean finished = finishLatch.await(5, TimeUnit.SECONDS);
        assertTrue(finished, "Threads should finish execution in 5 seconds");
        executor.shutdown();

        for (int i = 0; i < threadCount; i++) {
            assertEquals("value_" + i, SingletonRegistry.get("key_" + i));
        }
        assertEquals("shared_value", SingletonRegistry.get("shared_key"));

        SingletonRegistry.clear();
        assertNull(SingletonRegistry.get("shared_key"));
    }

    @Test
    void testUserFactory() {
        User user = UserFactory.createNewActiveUser("John Doe", "john@example.com", "pass", "123", "456", null, null, null);
        assertNotNull(user);
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertTrue(user.getActive());
        assertNotNull(user.getCreatedAt());

        User empty = UserFactory.createEmptyUser();
        assertNotNull(empty);
        assertNull(empty.getName());
    }

    @Test
    void testProductFactory() {
        Product p = ProductFactory.createProductWithDiscountCalculation(1L, "Laptop", "Work laptop", "img.png", 1000.0, 10.0, null);
        assertNotNull(p);
        assertEquals(1000.0, p.getUnitPrice());
        assertEquals(10.0, p.getDiscountPercentage());
        assertEquals(100.0, p.getDiscountAmount());
        assertEquals(900.0, p.getFinalPrice());
    }

    @Test
    void testOrderFactory() {
        Product p1 = ProductFactory.createProductWithDiscountCalculation(1L, "Laptop", "Work laptop", "img.png", 1000.0, 10.0, null);
        Product p2 = ProductFactory.createProductWithDiscountCalculation(2L, "Mouse", "Gaming mouse", "mouse.png", 100.0, 0.0, null);

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);

        Order order = OrderFactory.createOrderFromProducts(1L, null, products, null);
        assertNotNull(order);
        assertEquals(1100.0, order.getPriceWithOutDiscount());
        assertEquals(100.0, order.getDiscountAmount());
        assertEquals(1000.0, order.getTotal());
        assertEquals((100.0 / 1100.0) * 100.0, order.getDiscountPercentage());
    }
}
