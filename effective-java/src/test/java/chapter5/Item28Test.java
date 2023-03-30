package chapter5;

import chapter5.item28.ArrayChooser;
import chapter5.item28.GenericChooser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("배열보다는 리스트")
public class Item28Test {

    @Test
    @DisplayName("배열은 런타임에 실패한다 [ArrayStoreException]")
    void array1() {
        Object[] objectArray = new Long[1];
        assertThatThrownBy(() -> objectArray[0] = "str")
                .isInstanceOf(ArrayStoreException.class);
    }

    @Test
    @DisplayName("제네릭은 컴파일이 되지 않는다")
    void generic1() {
//        List<Object> objects = new ArrayList<Long>(); //컴파일 에러
        List<Object> objects = new ArrayList<Object>();
    }

    @Test
    void array2() {
        List list = new ArrayList();
        list.add(1);
        list.add("hello");

        ArrayChooser arrayChooser = new ArrayChooser(list);
        assertThatThrownBy(() -> {
            Integer choose = (Integer) arrayChooser.choose();
        }).isInstanceOf(ClassCastException.class);
    }

    @Test
    void generic2() {
        List<String> list = List.of("hello", "java", "world");

        GenericChooser<String> chooser = new GenericChooser<>(list);
        assertThat(list).contains(chooser.choose());
    }
}
