package ax.lindblom.ssab.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

//Integration tests that verifies that config.properties are valid and
//that the SL lines api are up and running
class TrafiklabServiceTest {

    @Test
    void getJourneyPoints() throws IOException, InterruptedException {
        Assertions.assertNotNull(TrafiklabService.getJourneyPointsJSON());
    }
    @Test
    void getStopPoints() throws IOException, InterruptedException {
        Assertions.assertNotNull(TrafiklabService.getStopsJSON());
    }
}