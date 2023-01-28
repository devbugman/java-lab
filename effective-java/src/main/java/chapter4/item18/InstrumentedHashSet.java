package chapter4.item18;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addConut = 0;

    public InstrumentedHashSet() {
    }

    @Override
    public boolean add(final E e) {
        addConut++;
        return super.add(e);
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        addConut += c.size();
        return super.addAll(c);
    }

    public int getAddConut() {
        return addConut;
    }
}
