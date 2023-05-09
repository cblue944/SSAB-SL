package ax.lindblom.ssab.parser;

import ax.lindblom.TestData;
import ax.lindblom.ssab.model.Line;
import ax.lindblom.ssab.model.Stop;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TrafiklabParserTest {

    @Test
    void throwsExceptionForNullString() {
        assertThrows(NullPointerException.class, ()->TrafiklabParser.parseStops(null));
    }
    @Test
    void parseLinesReturnListOfLines() throws IOException {
        Map<Integer, Stop> parsedStopResult = TrafiklabParser.parseStops(TestData.STOP_POINTS);
        List<Line> parsedJourneyResult = TrafiklabParser.parseJourney(TestData.JOURNEY_POINTS, parsedStopResult);
        assertEquals(1, parsedJourneyResult.size());
        assertStops(parsedJourneyResult.get(0).getStops());
    }
    @Test
    void parseStopsReturnMapOfStops() throws IOException {
        Map<Integer, Stop> parsedResult = TrafiklabParser.parseStops(TestData.STOP_POINTS);
        assertStops(new ArrayList<>(parsedResult.values()));
    }

    private void assertStops(List<Stop> stops){
        assertEquals(3, stops.size());
        assertEquals(10008, stops.get(0).id());
        assertEquals("Centralen", stops.get(0).name());
        assertEquals(10012, stops.get(1).id());
        assertEquals("Gärdet", stops.get(1).name());
        assertEquals(10014, stops.get(2).id());
        assertEquals("Östermalm", stops.get(2).name());
    }
}