package com.cb;

public class Order {
    private int orderPrice;

    public Order(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void validateOrder(int productPrice) {
        if (orderPrice < productPrice) {
            throw new IllegalArgumentException("주문하신 상품의 가격이 부족합니다.");
        }
        if (orderPrice > productPrice) {
            throw new IllegalArgumentException("주문하신 상품의 가격을 초과하였습니다.");
        }
    }
}
