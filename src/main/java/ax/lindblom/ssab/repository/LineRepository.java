package ax.lindblom.ssab.repository;

import ax.lindblom.ssab.model.Line;
import ax.lindblom.ssab.model.Stop;
import ax.lindblom.ssab.parser.TrafiklabParser;
import ax.lindblom.ssab.service.TrafiklabService;
import ax.lindblom.ssab.util.LineCache;
import ax.lindblom.ssab.util.LinesByNrOfStopsComparator;
import ax.lindblom.ssab.util.TrafiklabProperties;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class LineRepository {

    private LineCache cache;
    public List<Line> getTop10() throws IOException, InterruptedException {
        List<Line> lines = getLineCache().getCache();
        if(lines == null) {
            List<Line> linesFromService = getLinesFromService();
            linesFromService.sort(Collections.reverseOrder(new LinesByNrOfStopsComparator()));
            if(linesFromService.size() > 10){
                linesFromService = linesFromService.subList(0,10);
                cache.setCache(linesFromService);
            }
            return cache.getCache();
        }
        return lines;
    }

    private List<Line> getLinesFromService() throws IOException, InterruptedException {
        String stopResponse = TrafiklabService.getStopsJSON();
        Map<Integer, Stop> parsedStopResult = TrafiklabParser.parseStops(stopResponse);
        String journeyResponse = TrafiklabService.getJourneyPointsJSON();
        return TrafiklabParser.parseJourney(journeyResponse, parsedStopResult);
    }

    private LineCache getLineCache() throws IOException {
        if(cache == null) {
            cache = new LineCache(TrafiklabProperties.getCacheLength());
        }
        return cache;
    }
}
