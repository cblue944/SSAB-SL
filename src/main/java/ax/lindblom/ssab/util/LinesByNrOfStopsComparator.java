package ax.lindblom.ssab.util;

import ax.lindblom.ssab.model.Line;

import java.util.Comparator;

public class LinesByNrOfStopsComparator implements Comparator<Line> {
    @Override
    public int compare(Line line1, Line line2) {
        return line1.getStops().size()-line2.getStops().size();
    }
}
