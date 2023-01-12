package chapter3.item10.symmetry;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CaseInsensitiveStringTest {

    @Test
    void caseInsensitiveStringAndStringEqualsTest() {
        final CaseInsensitiveString cis = new CaseInsensitiveString("Abcd");
        final String s = "abcd";
        assertThat(cis.equals(s)).isTrue();
        assertThat(s.equals(cis)).isFalse();
    }

    @Test
    void collectionEqualsTest() {
        final CaseInsensitiveString cis = new CaseInsensitiveString("abcd");
        final String s = "abcd";
        final List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        assertThat(list.contains(s)).isFalse();
    }
}