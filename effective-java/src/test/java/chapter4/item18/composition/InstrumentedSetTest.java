package chapter4.item18.composition;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InstrumentedSetTest {

    @Test
    void test_1() {
        final InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());

        s.addAll(List.of("java11", "java17", "java8"));

        assertThat(s.getAddConut()).isEqualTo(3);
    }

}