import com.bobocode.InfiniteIterator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class InfiniteIteratorTest {
    private final LocalDate NOW = LocalDate.now();
    private InfiniteIterator businessDaysIterator = new InfiniteIterator(NOW);

    @Test
    void getInstance() {
        LocalDate now = LocalDate.now();

        businessDaysIterator = new InfiniteIterator(now);

        assertThat(businessDaysIterator.getCurrentDate()).isEqualTo(now);
    }

    @Test
    void initializeOnSaturday() {
        LocalDate saturday = LocalDate.of(2024, 8, 3);
        LocalDate monday = LocalDate.of(2024, 8, 5);
        businessDaysIterator = new InfiniteIterator(saturday);
        assertThat(businessDaysIterator.getCurrentDate()).isEqualTo(monday);
    }

    @Test
    void initializeOnSunday() {
        LocalDate sunday = LocalDate.of(2024, 8, 4);
        LocalDate monday = LocalDate.of(2024, 8, 5);
        businessDaysIterator = new InfiniteIterator(sunday);
        assertThat(businessDaysIterator.getCurrentDate()).isEqualTo(monday);
    }

    @Test
    void initializeOnSaturdayAndCallNext() {
        LocalDate saturday = LocalDate.of(2024, 8, 9);
        LocalDate monday = LocalDate.of(2024, 8, 12);
        businessDaysIterator = new InfiniteIterator(saturday);
        businessDaysIterator.next();
        assertThat(businessDaysIterator.getCurrentDate()).isEqualTo(monday);
    }

    @Test
    void hasNext() {
        assertThat(businessDaysIterator.hasNext()).isTrue();
    }

    @Test
    void next() {
        assertThat(businessDaysIterator.next()
                .isEqual(businessDaysIterator.getCurrentDate().plusDays(1)))
                .isTrue();
    }

    @Test
    void testToString() {
        assertThat(businessDaysIterator.toString()).contains( NOW.toString() );
    }
}