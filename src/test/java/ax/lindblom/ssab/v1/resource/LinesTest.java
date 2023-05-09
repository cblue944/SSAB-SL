package ax.lindblom.ssab.v1.resource;

import ax.lindblom.TestDataFactory;
import ax.lindblom.ssab.model.Line;
import ax.lindblom.ssab.repository.LineRepository;
import ax.lindblom.ssab.util.TrafiklabProperties;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldJunit5Extension;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(WeldJunit5Extension.class)
class LinesTest {

    private final static List<Line> LINES = TestDataFactory.getMultipleSimpleLines(10);
    @WeldSetup
    public final WeldInitiator weld = WeldInitiator.from(Lines.class, LinesTest.class)
            .build();

    @ApplicationScoped
    @Produces
    LineRepository produceLineRepository() throws IOException, InterruptedException {
        // Mock object provided by Mockito
        return when(
                mock(LineRepository.class).getTop10())
                .thenReturn(LINES)
                .getMock();
    }


    @Test
    void top10() throws IOException, InterruptedException {
        var result = weld.select(Lines.class).get().top10();
        assertEquals(LINES, result);
    }
}