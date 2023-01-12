package chapter3.item11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    @DisplayName("hashCode Test")
    void memberHashCode() {
        final Member member = new Member("hello", 10);
        final Member member2 = new Member("hello", 10);

        System.out.println("member.hashCode() = " + member.hashCode());
        System.out.println("member2.hashCode() = " + member2.hashCode());
    }

    @Test
    @DisplayName("해쉬코드를 재정의 하지 않을시")
    void memberHashCode2() {
        final Member member = new Member("jisoo", 10);
        final Member member2 = new Member("jisoo", 10);
        Map<Member, String> map = new HashMap<>();
        map.put(member, "blackping");

        final String teamName = map.get(member2);
        assertThat(teamName).isNull();
    }

}