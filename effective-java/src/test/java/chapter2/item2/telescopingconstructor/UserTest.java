package chapter2.item2.telescopingconstructor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {


    @Test
    void 점층적생성자패턴_1() {
        User user = new User("hello", "099-9999-9999");
        assertThat(user.getName()).isEqualTo("hello");
        assertThat(user.getPhoneNumber()).isEqualTo("099-9999-9999");
        assertThat(user.getAge()).isEqualTo(0);
        assertThat(user.getAddress()).isNull();
        assertThat(user.getNickname()).isNull();
    }

    @Test
    void 점층적생성자패턴_2() {
        User user = new User("hello", "099-9999-9999", 20);
    }

    @Test
    void 점층적생성자패턴_4() {
        User user = new User("hello", "099-9999-9999", 20, "kotlin");
    }

    @Test
    void 점층적생성자패턴_5() {
        User user = new User("hello", "099-9999-9999", 20, "kotlin", "jeju");
    }

}