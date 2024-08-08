import com.bobocode.ZippingIterator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class ZippingIteratorTest {

    @Test
    public void testInstanceEqualsIteratorsLength() {
        List<Integer> listA = Arrays.asList(1, 2, 3);
        List<String> listB = Arrays.asList("a", "b", "c");

        BiFunction<Integer, String, String> zipperFunction = (a, b) -> a + b;

        Iterator<String> zippingIterator = new ZippingIterator<>(listA.iterator(), listB.iterator(), zipperFunction);

        assertTrue(zippingIterator.hasNext());
        assertEquals("1a", zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals("2b", zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals("3c", zippingIterator.next());
        assertFalse(zippingIterator.hasNext());
    }

    @Test
    public void testInstanceDifferentIteratorsLength() {
        List<Integer> listA = Arrays.asList(1, 2);
        List<String> listB = Arrays.asList("a", "b", "c");

        BiFunction<Integer, String, String> zipperFunction = (a, b) -> a + b;

        Iterator<String> zippingIterator = new ZippingIterator<>(listA.iterator(), listB.iterator(), zipperFunction);

        assertTrue(zippingIterator.hasNext());
        assertEquals("1a", zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals("2b", zippingIterator.next());
        assertThrows(NoSuchElementException.class, zippingIterator::next);
    }
}