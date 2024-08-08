package com.bobocode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BufferingIterator <E> implements Iterator<List<E>> {
    private Iterator<E> iterator;
    private int bufferSize;
    private List<E> buffer;

    public BufferingIterator(Iterator<E> iterator, int bufferSize) {
        this.iterator = iterator;
        this.bufferSize = bufferSize;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public List<E> next() {
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        buffer = new ArrayList<>();
        int size = bufferSize;
        while (size > 0 && iterator.hasNext()) {
            buffer.add(iterator.next());
            size--;
        }
//        while (iterator.hasNext()) {
//            buffer.add(iterator.next());
//        }
        return buffer;
    }
}