package ax.lindblom.ssab.util;

import ax.lindblom.TestDataFactory;
import ax.lindblom.ssab.model.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinesByNrOfStopsComparatorTest {

    private final static Line ZERO_STOP_LINE = TestDataFactory.getSimpleLineMultipleStops(1,0);
    private final static Line ONE_STOP_LINE = TestDataFactory.getSimpleLineMultipleStops(2,1);
    private final static Line TWO_STOP_LINE = TestDataFactory.getSimpleLineMultipleStops(3,2);

    private final static LinesByNrOfStopsComparator lineCompare = new LinesByNrOfStopsComparator();
    @Test
    void compareEqualsNrOfStops() {
        int result = lineCompare.compare(ZERO_STOP_LINE, ZERO_STOP_LINE);
        assertEquals(0, result);
        result = lineCompare.compare(ONE_STOP_LINE, ONE_STOP_LINE);
        assertEquals(0, result);
    }
    @Test
    void compareLessNrOfStops() {
        int result = lineCompare.compare(ZERO_STOP_LINE, TWO_STOP_LINE);
        assertTrue(result < 0, "expected to be larger");
        result = lineCompare.compare(ONE_STOP_LINE, TWO_STOP_LINE);
        assertTrue(result < 0, "expected to be larger");
    }
    @Test
    void compareGreaterNrOfStops() {
        int result = lineCompare.compare(ONE_STOP_LINE, ZERO_STOP_LINE);
        assertTrue(result > 0, "expected to be smaller");
        result = lineCompare.compare(TWO_STOP_LINE, ZERO_STOP_LINE);
        assertTrue(result > 0, "expected to be smaller");
    }
}