package ax.lindblom.ssab.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    private final static int EXPECTED_LINENUMBER = 1003;
    private final static Stop ONE_STOP = new Stop(12, "Storstoppet");
    private final Line lineUnderTest = new Line(EXPECTED_LINENUMBER);

    @Test
    void canGetLineNumber(){
        assertEquals(EXPECTED_LINENUMBER, lineUnderTest.getLineNumber());
    }

    @Test
    void canGetStops(){
        lineUnderTest.addStop(ONE_STOP);
        assertEquals(ONE_STOP, lineUnderTest.getStops().get(0));
    }

    @Test
    void lineConstructorRequireLineNumberLargerThanZero(){
        assertThrows(IllegalArgumentException.class, () -> new Line(-1));
        assertThrows(IllegalArgumentException.class, () -> new Line(0));
    }
}