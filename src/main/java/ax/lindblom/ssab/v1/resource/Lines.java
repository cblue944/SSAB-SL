package ax.lindblom.ssab.v1.resource;

import ax.lindblom.ssab.model.Line;
import ax.lindblom.ssab.repository.LineRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.List;

@Path("/v1")

public class Lines {

    @Inject
    LineRepository lineRepository;

    @Path("/lines")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Line> top10() throws IOException, InterruptedException {
        return lineRepository.getTop10();
    }
}
