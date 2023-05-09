package ax.lindblom.ssab.repository;

import ax.lindblom.ssab.model.Line;
import ax.lindblom.ssab.service.TrafiklabService;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldJunit5Extension;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(WeldJunit5Extension.class)
class LineRepositoryTest {
    @WeldSetup
    public final WeldInitiator weld = WeldInitiator.from(LineRepository.class)
            .build();

    @Test
    void lineRepositoryReturns10Lines() throws IOException, InterruptedException {
        Path filePathStops = Path.of("src/test/resources/stops.json");
        Path filePathJourneyPoints = Path.of("src/test/resources/journeyPoints.json");
        String stopsJson = Files.readString(filePathStops);
        String journeyPointsJson = Files.readString(filePathJourneyPoints);

        MockedStatic<TrafiklabService> service = mockStatic(TrafiklabService.class);
        service.when(TrafiklabService::getStopsJSON).thenReturn(stopsJson);
        service.when(TrafiklabService::getJourneyPointsJSON).thenReturn(journeyPointsJson);

        List<Line> top10Lines = weld.select(LineRepository.class).get().getTop10();
        assertEquals(10, top10Lines.size());
    }
}