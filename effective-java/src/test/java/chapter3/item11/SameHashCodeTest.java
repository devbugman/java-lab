package chapter3.item11;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class SameHashCodeTest {

    @Test
    void sameHashCode() {
//        final Map<SameHashCode, Integer> map = setUpData();
//        final long start = System.currentTimeMillis();
//        final Integer integer = map.get(new SameHashCode(40000));
//
//        final long end = System.currentTimeMillis();
//        System.out.println("(end - start) = " + (end - start)); // ...........

    }

    private Map<SameHashCode, Integer> setUpData() {
        Map<SameHashCode, Integer> map = new HashMap<>();
        for (int i = 1; i <= 1_000_000; i++) {
            map.put(new SameHashCode(i), i);
        }
        return map;
    }

}