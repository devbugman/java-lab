package chapter5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로 타입은 사용하지말자")
public class Item5 {

    @Test
    @DisplayName("로 타입으로 원소를 TypeCasting 할 때 [ClassCastException] 예외가 발생한다.")
    void rawTypeTest1() {
        List list = new ArrayList();
        list.add("hi"); // 컴파일시 문제가 없음
        list.add(1); // 컴파일시 문제가 없음
        assertThatThrownBy(() -> {
            Integer num = (Integer) list.get(0); // 컴파일시 문제가 없음
            String num2 = (String) list.get(0); // 컴파일시 문제가 없음
        }).isInstanceOf(ClassCastException.class);
    }

    @Test
    @DisplayName("제네릭이 주는 안정감")
    void genericType() {
        List<String> list = new ArrayList();
        list.add("hi");
//        list.add(1); 컴파일 에러
        String s = list.get(0); // (String) list.get(0);
    }

    @Test
    @DisplayName("와일드카드는 [null]외에는 아무 원소도 넣을 수 없다")
    void wildcardType() {
        List<?> collection = new ArrayList<>();
        collection.add(null);
//        collection.add(1); 컴파일 에러
    }
}
