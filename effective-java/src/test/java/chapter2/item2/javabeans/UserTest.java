package chapter2.item2.javabeans;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void 자바빈즈() {
        User user = new User();
        user.setName("hello");
        user.setPhoneNumber("999-9999-9999");
        user.setAge(20);
        user.setNickname("kotlin");
        user.setAddress("seoul");
    }

}