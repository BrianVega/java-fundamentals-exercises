import com.bobocode.FlatteningIterator;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FlatteningIteratorTest {

    @Test
    void testHasNextValidInput() {
        Iterator<Integer> iter = new FlatteningIterator<>(
                List.of(42, 5).iterator(),
                List.of(-4).iterator(),
                List.of(999, 998, 997).iterator());

        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(42), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(5), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(-4), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(999), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(998), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(997), iter.next());
        assertFalse(iter.hasNext());

    }

    @Test
    void testNextEmptyCollections() {
        Iterator<Integer> iter = new FlatteningIterator<>(
                List.<Integer>of().iterator(),
                List.<Integer>of().iterator()
        );

        assertThrows(NoSuchElementException.class, iter::next);
    }

    @Test
    public void testHasNextValidAndEmptyCollections() {
        Iterator<Integer> iter = new FlatteningIterator<>(
                List.of(1).iterator(),
                List.<Integer>of().iterator(),
                List.of(2, 3).iterator()
        );

        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(1), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(2), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(3), iter.next());
        assertFalse(iter.hasNext());
    }
}