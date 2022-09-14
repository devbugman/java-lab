package spring.jpa.service;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import spring.jpa.domain.Address;
import spring.jpa.domain.Member;
import spring.jpa.domain.Order;
import spring.jpa.domain.OrderStatus;
import spring.jpa.domain.item.Book;
import spring.jpa.domain.item.Item;
import spring.jpa.exception.NotEnoughStockException;
import spring.jpa.repository.OrderRepository;

@SpringBootTest
@Transactional
public class OrderServiceTest {
    
    @Autowired
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void 상품주문(){
        //given
        Member member = createMember();
      
        Book item = createBook("시골 JPA",10000,10);
        //when
        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        //then
        Order getOrder = orderRepository.findOne(orderId);
        assertEquals(OrderStatus.ORDER,getOrder.getStatus(),"상품주문시 상태는 Order이어야한다.");
        assertEquals(1, getOrder.getOrderItems().size(),"주문한 상품 종류 수가 정확해야 한다.");
        assertEquals(10000 * orderCount, getOrder.getTotalPrice(),"주문한 가격은 가격 * 수량이다.");
        assertEquals(8, item.getStockQuantity(),"주문 수량만큼 재고가 줄어야한다.");
        

    }

    @Test
    void 상품주문_재고수량초과(){
        //given
        Member member = createMember();
        Item item = createBook("시골 JPA",10000,10);
        int orderCount = 11;
        //when
        
        
        NotEnoughStockException e = assertThrows(NotEnoughStockException.class, () -> orderService.order(member.getId(), item.getId(), orderCount));
        //then
        Assertions.assertThat(e.getMessage()).isEqualTo("need more stock");
    }

    @Test
    void 주문취소(){
        //given
        Member member = createMember();
        Book item = createBook("시골JPA", 10000, 10);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        //when
        orderService.cancelOrder(orderId);

        //then
        Order getOrder = orderRepository.findOne(orderId);
        assertEquals(OrderStatus.CENCEL, getOrder.getStatus(), "주문의 상태는 취소여야한다.");
        assertEquals(10, item.getStockQuantity(), "주문이 취소돈 상품은 구만큼 재고가 증가해야한다.");
    }

    private Member createMember(){
        Member member = new Member();
        member.setAddress(new Address("서울", "강가", "123-123"));
        em.persist(member);
        return member;
    }

    private Book createBook(String name,int price,int stockQuantity){
        Book item =new Book();
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
        em.persist(item);
        return item;
    }
   
}
