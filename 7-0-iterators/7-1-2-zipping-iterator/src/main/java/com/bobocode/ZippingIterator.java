package com.bobocode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class ZippingIterator <A, B, C> implements Iterator<C>{
    private final Iterator<A> iteratorA;
    private final Iterator<B> iteratorB;
    private final BiFunction<A, B, C> iteratorC;

    public ZippingIterator(Iterator<A> iteratorA, Iterator<B> iteratorB,
                           BiFunction<A, B, C> iteratorC) {
        this.iteratorA = iteratorA;
        this.iteratorB = iteratorB;
        this.iteratorC = iteratorC;
    }

    @Override
    public boolean hasNext() {
        return iteratorA.hasNext() && iteratorB.hasNext();
    }

    @Override
    public C next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iteratorC.apply(iteratorA.next(), iteratorB.next());
    }
}
