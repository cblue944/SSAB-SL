package ax.lindblom.ssab.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final int lineNumber;

    private final List<Stop> stops = new ArrayList<>();

    public Line(int lineNumber){
        this.lineNumber = lineNumber;
        checkConstructorParameters();
    }

    private void checkConstructorParameters() {
        if(lineNumber <= 0 ) {
            throw new IllegalArgumentException("LineNumber must be a positive number");
        }
    }

    public void addStop(Stop stop){
        stops.add(stop);
    }
    public int getLineNumber() {
        return lineNumber;
    }

    public List<Stop> getStops() {
        return stops;
    }
}
