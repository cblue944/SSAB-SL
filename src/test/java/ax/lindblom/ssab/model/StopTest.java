package ax.lindblom.ssab.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StopTest {
    private final static String EXPECTED_STOP_NAME = "Storstoppet";
    private final static int EXPECTED_ID = 12;
    private final Stop stopUnderTest = new Stop(EXPECTED_ID, EXPECTED_STOP_NAME);

    @Test
    void canGetName(){
        assertEquals(EXPECTED_STOP_NAME, stopUnderTest.name());
    }

    @Test
    void canGetId(){
        assertEquals(EXPECTED_ID, stopUnderTest.id());
    }

    @Test
    void stopConstructorRequirePositiveId(){
        assertThrows(IllegalArgumentException.class, () -> new Stop(-1, EXPECTED_STOP_NAME));
        assertThrows(IllegalArgumentException.class, () -> new Stop(0, EXPECTED_STOP_NAME));
    }
}