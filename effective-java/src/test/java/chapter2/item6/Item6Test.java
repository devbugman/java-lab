package chapter2.item6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Item6Test {

    @Test
    @DisplayName("new String()으로 생성시 매번 새로운 인스턴스가 생성된다.")
    void newString() {
        String s1 = new String("debug");
        String s2 = new String("debug");
        assertThat(s1).isNotSameAs(s2);
    }

    @Test
    @DisplayName("String 인스턴스Test")
    void string_2() {
        String s1 = new String("debug");
        String s2 = "debug";
        assertThat(s1).isNotSameAs(s2);
    }

    @Test
    @DisplayName("String 객체를 intern() 하면 String constant pool에 추가된다.")
    void string_3() {
        String s1 = new String("debug").intern();
        String s2 = "debug";
        assertThat(s1).isSameAs(s2);
    }

    @Test
    @DisplayName("똑같은 문자열 리터럴을 사용하는경우 같은 코드가 재사용함이 보장")
    void string_4() {
        String s1 = "debug";
        String s2 = "debug";
        assertThat(s1).isSameAs(s2);
    }

    @Test
    @DisplayName(" Integer -128~+127 까지를 미리 캐시해두어 사용된다")
    void integerTest() {
        assertThat(Integer.valueOf(127) == Integer.valueOf(127)).isTrue();
        assertThat(Integer.valueOf(128) == Integer.valueOf(128)).isFalse();
    }

    @Test
    void keySet() {
        Map<String, String> map = new HashMap<>();
        map.put("spring", "spring");
        map.put("java", "java");
        Set<String> key1 = map.keySet();
        map.put("kotlin", "kotlin");
        Set<String> key2 = map.keySet();

        assertThat(key1).isSameAs(key2);
        assertThat(key1.size()).isEqualTo(3);
        assertThat(key2.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("오토박싱시 ")
    void autoBoxing() {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum+= i;
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    @DisplayName("primitiveType")
    void primitiveType() {
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum+= i;
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
