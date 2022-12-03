package com.cb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
//./gradlew --console verbose test jacocoTestReport jacocoTestCoverageVerification

    @Test
    void orderValidateTest() {
        Order order = new Order(1000);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> order.validateOrder(2000));

        assertEquals(illegalArgumentException.getMessage(), "주문하신 상품의 가격이 부족합니다.");
    }
//
//    96
//    @Test
//    void orderValidateTest2() {
//        Order order = new Order(1000);
//        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> order.validateOrder(900));
//
//        assertEquals(illegalArgumentException.getMessage(), "주문하신 상품의 가격을 초과하였습니다.");
//    }
//      100
//    @Test
//    void orderValidateTest3() {
//        Order order = new Order(1000);
//        assertDoesNotThrow(() -> order.validateOrder(1000));
//    }
}