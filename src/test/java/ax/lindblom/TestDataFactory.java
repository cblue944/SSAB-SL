package ax.lindblom;

import ax.lindblom.ssab.model.Line;
import ax.lindblom.ssab.model.Stop;

import java.util.ArrayList;
import java.util.List;

public class TestDataFactory {

    static public Line getSimpleLine(int lineNumber, int stopId){
        Line line = new Line(lineNumber);
        line.addStop(new Stop(stopId, String.format("Stop_%n", stopId)));
        return line;
    }
    static public Line getSimpleLineMultipleStops(int lineNumber, int nrOfStops){
        Line line = new Line(lineNumber);
        for(int i = 1; i < nrOfStops + 1; i++){
            line.addStop(new Stop(i, String.format("Stop_%n", i)));
        }
        return line;
    }
    static public List<Line> getMultipleSimpleLines(int nrOfLines){
        List<Line> lines = new ArrayList<>();
        for(int i = 1; i < nrOfLines + 1; i++){
            lines.add(getSimpleLineMultipleStops(i,i));
        }
        return lines;
    }
}
