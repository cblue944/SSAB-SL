package ax.lindblom.ssab.parser;

import ax.lindblom.ssab.model.Line;
import ax.lindblom.ssab.model.Stop;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrafiklabParser {

    private TrafiklabParser(){
        throw new IllegalStateException("This is a utility class");
    }
    public static List<Line> parseJourney(String trafiklabResponseBody, Map<Integer, Stop> stops) {
        Map<Integer, Line> lines = new HashMap<>();
        JsonArray result = getResult(trafiklabResponseBody);
        for (JsonValue jsonJourneyPoint: result) {
            int lineNumber = Integer.parseInt(jsonJourneyPoint.asJsonObject().getString("LineNumber"));
            int stopId = Integer.parseInt(jsonJourneyPoint.asJsonObject().getString("JourneyPatternPointNumber"));
            Line line = lines.computeIfAbsent(lineNumber, Line::new);
            line.addStop(stops.get(stopId));
            lines.put(lineNumber, line);
        }
        return new ArrayList<>(lines.values());
    }

    public static Map<Integer, Stop> parseStops(String trafiklabResponseBody) {
        Map<Integer, Stop> stops = new HashMap<>();
        JsonArray result = getResult(trafiklabResponseBody);
        for (JsonValue jsonLine: result) {
            final int stopId = Integer.parseInt(jsonLine.asJsonObject().getString("StopPointNumber"));
            final String stopName = jsonLine.asJsonObject().getString("StopPointName");
            stops.put(stopId, new Stop(stopId, stopName));
        }
        return stops;
    }

    private static JsonArray getResult(String trafiklabResponseBody) {
        try(JsonParser parser = Json.createParser(
                new ByteArrayInputStream(trafiklabResponseBody.getBytes()))){
            while (parser.hasNext()) {
                Event event = parser.next();
                if (event == JsonParser.Event.KEY_NAME ) {
                    String key = parser.getString();
                    if (key.equalsIgnoreCase("result")) {
                        parser.next();
                        return parser.getArray();
                    }
                }
            }
        }
        throw new IllegalArgumentException("The response body doesn't contain a key-value pair named Result");
    }
}
