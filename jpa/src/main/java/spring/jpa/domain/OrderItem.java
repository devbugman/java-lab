package spring.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import spring.jpa.domain.item.Item;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY) // 하나의 주문이 여러개 의 수량아이템을 가질수 있다.
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; // 주문당시 가격

    private int count; // 주문당시 수량 

    protected OrderItem(){}

    // == 아이템 생성 메서드 ==//
    public static OrderItem createOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);
        
        item.removeStock(count);
        return orderItem;
    }
    // == 비즈니스 로직 == //
    /*
     * 취소한 상품 재고 수량 다시 추가하는 로직
     */
    public void cancel() {
        getItem().addStock(count);
    }

    /*
     * 총 금액 로직
     */
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }

}
