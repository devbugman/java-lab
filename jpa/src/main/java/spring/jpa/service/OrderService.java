package spring.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import spring.jpa.domain.Delivery;
import spring.jpa.domain.Member;
import spring.jpa.domain.Order;
import spring.jpa.domain.OrderItem;
import spring.jpa.domain.item.Item;
import spring.jpa.repository.ItmeRepository;
import spring.jpa.repository.MemberRepository;
import spring.jpa.repository.OrderRepository;
import spring.jpa.repository.OrderSearch;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItmeRepository itmeRepository;

    //주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count){
        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itmeRepository.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //주문상품 생성 
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문생성
        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }
    //주문취소
    @Transactional
    public void cancelOrder(Long orderId){
        Order order = orderRepository.findOne(orderId);
        
        //주문취소
        //jpa를 활용하면 데이터를 변경하면 entity에서 변경내용을 감지하면서
        // 업데이트 쿼리 날라감 더티체킹 
        order.cancel();
    }

    //검색

    public List<Order> findOrders(OrderSearch orderSearch){
        return orderRepository.findAllByString(orderSearch);
    }
}
