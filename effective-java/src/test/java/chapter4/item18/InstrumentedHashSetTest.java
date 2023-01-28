package chapter4.item18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InstrumentedHashSetTest {

    @Test
    @DisplayName("addAll메서드에 원소 3개를 추가시 getAddCount()에서 3을 기대했지만 6을 반환한다.")
    void test_1() {
        final InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("java11", "java17", "java8"));

        assertThat(s.getAddConut()).isEqualTo(6);
    }
}