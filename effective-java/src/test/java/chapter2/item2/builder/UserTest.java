package chapter2.item2.builder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void 빌더패턴() {
        User user = new User.Builder("hello", "999-9999-9999")
                .age(20)
                .nickname("kotlin")
                .address("jeju")
                .build();

        assertThat(user.getName()).isEqualTo("hello");
        assertThat(user.getPhoneNumber()).isEqualTo("999-9999-9999");
        assertThat(user.getNickname()).isEqualTo("kotlin");
        assertThat(user.getAddress()).isEqualTo("jeju");
        assertThat(user.getAge()).isEqualTo(20);
    }

}