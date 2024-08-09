import com.bobocode.BufferingIterator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BufferingIteratorTest {

    @Test
    public void testHasNext() {
        Iterator<List<Integer>> iterator = new BufferingIterator<Integer>(
                List.of(1, 2, 3, 4, 5).iterator(),
                3
        );

        Iterator<List<Integer>> iterator2 = new BufferingIterator<Integer>(
                List.<Integer>of().iterator(),
                2
        );

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator2.hasNext()).isFalse();
    }

    @Test
    public void testNext() {
        Iterator<List<Integer>> iterator = new BufferingIterator<Integer>(
                List.of(1, 2, 3, 4, 5).iterator(),
                3
        );
        List<List<Integer>> batches = new ArrayList<>();

        while (iterator.hasNext()) {
            batches.add(iterator.next());
        }

        assertThat(batches.size()).isEqualTo(2);
        assertThat(batches.get(0)).isEqualTo(List.of(1, 2, 3));
        assertThat(batches.get(1)).isEqualTo(List.of(4, 5));
    }

    @Test
    public void testBufferSizeIsZero() {
        Iterator<List<Integer>> iterator = new BufferingIterator<Integer>(
                List.of(1, 2, 3, 4, 5).iterator(),
                0
        );
            assertThat(iterator.next()).isEqualTo(List.of());
    }

    @Test
    public void testNoSuchElementException() {
        Iterator<List<Integer>> iterator = new BufferingIterator<Integer>(
                List.<Integer>of().iterator(),
                2
        );
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
