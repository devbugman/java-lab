package chapter2.item7;

import org.junit.jupiter.api.Test;

import java.util.WeakHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Item7Test {

    @Test
    void weakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key1 = 1011;
        Integer key2 = 1000;

        map.put(key1, "test1");
        map.put(key2, "test2");

        key1 = null;
        System.gc();
//        key1 = null;

        map.entrySet().stream()
                .forEach(System.out::println);
        assertThat(map.size()).isEqualTo(1);

    }
}
