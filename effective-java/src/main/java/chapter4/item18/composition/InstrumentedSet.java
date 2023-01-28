package chapter4.item18.composition;

import java.util.Collection;
import java.util.Set;

public class InstrumentedSet<E> extends ForwardingSet<E> {

    private int addConut = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
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
