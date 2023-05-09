package ax.lindblom.ssab.service;

import ax.lindblom.ssab.util.TrafiklabProperties;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TrafiklabService {

    private TrafiklabService(){
        throw new IllegalStateException("This is a utility class");
    }

    public static String getStopsJSON() throws IOException, InterruptedException {
        URI stopsURI = URI.create(TrafiklabProperties.getBaseUri() +"&model=stop");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(stopsURI)
                .header("Accept", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String getJourneyPointsJSON() throws IOException, InterruptedException {
        URI stopsURI = URI.create(TrafiklabProperties.getBaseUri() +"&model=jour");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(stopsURI)
                .header("Accept", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
