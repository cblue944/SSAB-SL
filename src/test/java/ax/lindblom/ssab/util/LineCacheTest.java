package ax.lindblom.ssab.util;

import ax.lindblom.TestDataFactory;
import ax.lindblom.ssab.model.Line;
import org.awaitility.Awaitility;
import org.awaitility.Durations;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LineCacheTest {
    private final static int EXPECTED_LINENUMBER = 1003;
    private final static int expectedStopId = 12;

    @Test
    void lineCacheReturnListWithinCacheTime () throws InterruptedException {
        LineCache cache = new LineCache(2);
        List<Line> lines = List.of(
                new Line[]{TestDataFactory.getSimpleLine(EXPECTED_LINENUMBER, expectedStopId)});
        cache.setCache(lines);
        Awaitility.await().atMost(Durations.TWO_SECONDS).until(()->cache.getCache()!=null);
    }

    @Test
    void lineCacheReturnsNullAfterCacheTimeExpired () throws InterruptedException {
        LineCache cache = new LineCache(1);
        List<Line> lines = List.of(
                new Line[]{TestDataFactory.getSimpleLine(EXPECTED_LINENUMBER, expectedStopId)});
        cache.setCache(lines);
        Awaitility.await().atMost(Durations.TWO_SECONDS).until(()->cache.getCache()==null);
    }

    @Test
    void lineCacheReturnsNullIfNotSet () {
        LineCache cache = new LineCache(10);
        assertNull(cache.getCache());
    }

}