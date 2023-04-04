package kr.devbugman.convert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayConverterTest {

    @Autowired private PlayConverter playConverter;

    @Test
    @DisplayName("list가 비어있을시 문자열 반환")
    void emptyListConvertToString() {
        final String result = playConverter.convertToDatabaseColumn(new ArrayList<>());
        assertThat(result).isEqualTo("[]");
    }

    @Test
    @DisplayName("list의 값이 있을 시 convertTest")
    void convertToString() {
        final List<Long> longs = Arrays.asList(1L, 2L);
        final String result = playConverter.convertToDatabaseColumn(longs);
        assertThat(result).isEqualTo("[1,2]");
    }

    @Test
    @DisplayName("string data를 List<Long> 데이터 convertTest")
    void convertToList() {
        final String data = "[1, 2]";
        final List<Long> longs = playConverter.convertToEntityAttribute(data);
        assertThat(longs.toString()).isEqualTo("[1, 2]");
    }

    @Test
    @DisplayName("string data를 List<Long> 데이터 convertTest")
    void stringDataOneConvertToList() {
        final String data = "[1]";
        final List<Long> longs = playConverter.convertToEntityAttribute(data);
        assertThat(longs.toString()).isEqualTo("[1]");
    }

    @Test
    @DisplayName("string data가 없을 시 빈배열을 반환")
    void emptyStringDataConvertToList() {
        final String data = "";
        final List<Long> longs = playConverter.convertToEntityAttribute(data);
        assertThat(longs.toString()).isEqualTo("[]");
    }
}