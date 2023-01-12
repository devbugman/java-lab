package chapter3.item11;

import java.util.Objects;

public class SameHashCode {
    private final int number;

    public SameHashCode(final int number) {
        this.number = number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof SameHashCode)) return false;
        final SameHashCode that = (SameHashCode) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
