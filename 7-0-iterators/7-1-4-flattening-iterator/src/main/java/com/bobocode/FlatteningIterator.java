package com.bobocode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class FlatteningIterator<T> implements Iterator<T> {
    private final Queue<Iterator<T>> iteratorsQueue;

    @SafeVarargs
    public FlatteningIterator(Iterator<T>... iterators) {
        this.iteratorsQueue = new LinkedList<>();
        for (Iterator<T> iterator : iterators) {
            if (iterator != null) {
                iteratorsQueue.add(iterator);
            }
        }
    }

    @Override
    public boolean hasNext() {
        while (!iteratorsQueue.isEmpty() && !iteratorsQueue.peek().hasNext()) {
            iteratorsQueue.poll();
        }
        return !iteratorsQueue.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iteratorsQueue.peek().next();
    }
}
