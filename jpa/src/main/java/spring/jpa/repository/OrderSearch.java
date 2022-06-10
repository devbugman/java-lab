package spring.jpa.repository;

import lombok.Getter;
import lombok.Setter;
import spring.jpa.domain.OrderStatus;

@Getter @Setter
public class OrderSearch {
    
    private String memberName;//회원이름

    private OrderStatus orderStatus; // CANCEL , ORDER
}
