package chapter5;

import chapter5.item29.GenericStack;
import chapter5.item29.ObjectStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("이왕이면 제네릭 타입")
public class Item29Test {


    @Test
    @DisplayName("형변환시 예외 발생")
    void test1() {
        ObjectStack objectStack = new ObjectStack();
        objectStack.push("hello");
        objectStack.push("13s2");
//        Integer pop = (Integer) objectStack.pop(); ClassCastException
    }

    @Test
    @DisplayName("제네릭 타입  안전성 ")
    void test2() {
        GenericStack<Integer> s = new GenericStack<>();
//        s.push("sata"); // 컴파일 x
        s.push(1);
        System.out.println(s.pop());
    }

    @Test
    @DisplayName("제네릭 타입  안전성")
    void test3() {
        GenericStack<String> s = new GenericStack<>();
        List.of("hello", "world", "java", "effective", "good")
                .forEach(s::push);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
